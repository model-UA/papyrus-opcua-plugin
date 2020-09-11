package org.eclipse.papyrus.opcua.diagram.transformer;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.EEnumLiteralImpl;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.infra.tools.file.IPFileSystemAccess;
import org.eclipse.papyrus.infra.tools.file.ProjectBasedFileAccess;
import org.eclipse.papyrus.opcua.nodeset.parser.NodeSetParser;
import org.eclipse.papyrus.opcua.nodeset.parser.NodeSetReader;
import org.eclipse.papyrus.opcua.nodeset.parser.NodeSetWriter;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.AliasTable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.ListOfReferences;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.ListOfRolePermissions;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.LocalizedText;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeIdAlias;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.Reference;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.ReleaseStatus;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.RolePermission;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.StructureTranslationType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UADataType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAMethod;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANode;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObject;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObjectType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAReferenceType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariableType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAView;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UriTable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.AliasTableImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.ListOfReferencesImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.ListOfRolePermissionsImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.LocalizedTextImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.NodeIdAliasImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.ReferenceImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.RolePermissionImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.StructureTranslationTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.TranslationTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UADataTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAInstanceImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAMethodImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UANodeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAObjectImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAObjectTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAReferenceTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UATypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAVariableImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAVariableTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAViewImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UriTableImpl;

public class InstanceSyncHandler {
	
	private Model baseUmlModel;
	private UANodeSetType baseNodeset;
	private HashMap<Element, Object> matching;
	
	public InstanceSyncHandler(Model umlModel)
	{
		this.baseUmlModel = umlModel;
		this.matching = new HashMap<Element, Object>();
	}
	
	public InstanceSyncHandler(UANodeSetType nodeset)
	{
		this.baseNodeset = nodeset;
		this.matching = new HashMap<Element, Object>();
	}
	
	public InstanceSyncHandler(Model umlModel, UANodeSetType nodeset)
	{
		this.baseUmlModel = umlModel;
		this.baseNodeset = nodeset;
		this.matching = new HashMap<Element, Object>();
	}
	

	public boolean writeToNodeSetFile() throws ParserConfigurationException
	{
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject[] projects = root.getProjects();
		IPFileSystemAccess fileSystemAccess = new ProjectBasedFileAccess(projects[0]);
		
		//output.concat(OpcUaPackageHeaderGenerator.generateCode(pack).toString());
		if(this.baseUmlModel.getName() == null)
		{
			return false;
		}
		
        IPath filename = root.getLocation();
        IPath project_path = projects[0].getFullPath();
        filename = filename.append(project_path);
        filename = filename.append(this.baseUmlModel.getName() + ".xml");
       
        NodeSetParser.writeToFile(filename.toOSString(), this.baseNodeset);
        
		return true;
	}
	public boolean readToNodeSetFile(File filepath)
	{
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder = factory.newDocumentBuilder();
//		Document document = builder.parse(filepath);
//		document.getDocumentElement().normalize();
//		NodeSetReader reader = new NodeSetReader(document);
//		
//		UANodeSetType nodeSet = reader.readNodeSet();
//		
		return false;
	}
	public void setNodeSetObject(UANodeSetType nodeset)
	{
		this.baseNodeset = nodeset;
	}
	
	public void setUmlModel (Model umlModel)
	{
		this.baseUmlModel = umlModel;
	}
		
	public boolean syncNodeSetToUml()
	{
		return false;
	}
	
	public boolean syncUmlToNodeSet()
	{
		return false;
	}
	
	public boolean updateMember(Element object)
	{
		boolean return_val = false;
		
		if(object instanceof Class)
		{
			//return_val= updateClass((Class) object);
			
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(this.baseUmlModel);
			
			// changes to diagrams shall be done inside commands
			UpdateUMLClassCommand cmd = new UpdateUMLClassCommand(domain);
			cmd.setClass((Class) object);
			cmd.registerInstanceSynchHandler(this);
			
			domain.getCommandStack().execute(cmd);
			
			return_val = cmd.getCommandResult();
		}
		else if(object instanceof DataType)
		{
			return_val= updatedDataType((DataType) object);
		}
		else if(object instanceof Generalization)
		{
			return_val= updatedGeneralization((Generalization) object);
		}
		
		return return_val;
	}
	
	protected boolean updateClass(Class object)
	{
		EList<EObject> stereotype_applications = object.getStereotypeApplications();

		boolean success=false;
		
		for(EObject ster : stereotype_applications)
		{
			DynamicEObjectImpl stereotype = (DynamicEObjectImpl) ster;
			EClass cls = ster.eClass();
			
			switch(cls.getName()) {			
			case "AliasTable":
				success= transformAliasTable(object, stereotype);
				break;
			case "DataTypeDefinition":
				success= transformDataTypeDefinition(object, stereotype);
				break;
			case "DataTypeField":
				success=transformDataTypeField(object, stereotype);
				break;
			case "DataTypePurpose":
				success=transformDataTypePurpose(object, stereotype);
				break;
			case "DocumentRoot":
				success= transformDocumentRoot(object, stereotype);
				break;
			case "ExtensionType":
				success=transformExtensionType(object, stereotype);
				break;
			case "ListOfExtensions":
				success=transformListOfExtensions(object, stereotype);
				break;
			case "ListOfReferences":
				success=transformListOfReferences(object, stereotype);
				break;
			case "ListOfRolePermissions":
				success=transformListOfRolePermissions(object, stereotype);
				break;
			case "LocalizedText":
				success=transformLocalizedText(object, stereotype);
				break;
			case "ModelTable":
				success=transformModelTable(object, stereotype);
				break;
			case "ModelTableEntry":
				success=transformModelTableEntry(object, stereotype);
				break;
			case "NodeIdAlias":
				success=transformNodeIdAlias(object, stereotype);
				break;
			case "NodeSetFactory":
				success=transformNodeSetFactory(object, stereotype);
				break;
			case "NodeSetPackage":
				success=transformNodeSetPackage(object, stereotype);
				break;
			case "NodeSetStatus":
				success=transformNodeSetStatus(object, stereotype);
				break;
			case "NodeSetStatusList":
				success=transformNodeSetStatusList(object, stereotype);
				break;
			case "NodesToAdd":
				success=transformNodesToAdd(object, stereotype);
				break;
			case "NodesToDelete":
				success=transformNodesToDelete(object, stereotype);
				break;
			case "NodeToDelete":
				success=transformNodeToDelete(object, stereotype);
				break;
			case "Reference":
				success=transformReference(object, stereotype);
				break;
			case "ReferenceChange":
				success=transformReferenceChange(object, stereotype);
				break;
			case "ReferencesToChange":
				success=transformReferencesToChange(object, stereotype);
				break;
			case "ReleaseStatus":
				success=transformReleaseStatus(object, stereotype);
				break;
			case "RolePermission":
				success=transformRolePermission(object, stereotype);
				break;
			case "StructureTranslationType":
				success=transformStructureTranslationType(object, stereotype);
				break;
			case "TranslationType":
				success=transformTranslationType(object, stereotype);
				break;
			case "UADataType":
				success=transformUADataType(object, stereotype);
				break;
			case "UAInstance":
				success=transformUAInstance(object, stereotype);
				break;
			case "UAMethod":
				success=transformUAMethod(object, stereotype);
				break;
			case "UAMethodArgument":
				success=transformUAMethodArgument(object, stereotype);
				break;
			case "UANode":
				success=transformUANode(object, stereotype);
				break;
			case "UANodeSetChangesStatusType":
				success=transformUANodeSetChangesStatusType(object, stereotype);
				break;
			case "UANodeSetChangesType":
				success=transformUANodeSetChangesType(object, stereotype);
				break;
			case "UANodeSetType":
				success=transformUANodeSetType(object, stereotype);
				break;
			case "UAObject":
				success=transformUAObject(object, stereotype);
				break;
			case "UAObjectType":
				success=transformUAObjectType(object, stereotype);
				break;
			case "UAReferenceType":
				success=transformUAReferenceType(object, stereotype);
				break;
			case "UAType":
				success=transformUAType(object, stereotype);
				break;
			case "UAVariable":
				success=transformUAVariable(object, stereotype);
				break;
			case "UAVariableType":
				success=transformUAVariableType(object, stereotype);
				break;
			case "UAView":
				success=transformUAView(object, stereotype);
				break;
			case "UriTable":
				success=transformUriTable(object, stereotype);
				break;
			case "ValueType":
				success=transformValueType(object, stereotype);
				break;
			case "ValueType1":
				success=transformValueType1(object, stereotype);
				break;
			default:
				break;
			}
		}
		
		return success;
		
	}
	
	public boolean removeMember(Element obj) {
		
		if(!this.matching.containsKey(obj))
		{
			return true;
		}
		
		boolean success = false;
		Object toBeRemoved = this.matching.get(obj);
		
		if(toBeRemoved instanceof UADataType)
		{
			success = this.baseNodeset.getUADataType().remove(toBeRemoved);
		}
		else if(toBeRemoved instanceof UAMethod)
		{
			success = this.baseNodeset.getUAMethod().remove(toBeRemoved);
		}
		else if(toBeRemoved instanceof UAObjectType)
		{
			success = this.baseNodeset.getUAObjectType().remove(toBeRemoved);
		}
		else if(toBeRemoved instanceof UAObject)
		{
			success = this.baseNodeset.getUAObject().remove(toBeRemoved);
		}
		else if(toBeRemoved instanceof UAReferenceType)
		{
			success = this.baseNodeset.getUAReferenceType().remove(toBeRemoved);
		}
		else if(toBeRemoved instanceof UAVariable)
		{
			success = this.baseNodeset.getUAVariable().remove(toBeRemoved);
		}
		else if(toBeRemoved instanceof UAVariableType)
		{
			success = this.baseNodeset.getUAVariableType().remove(toBeRemoved);
		}
		
		if(success)
		{
			this.matching.remove(obj);
		}
		
		return success;
	}
	
	
	private boolean transformValueType1(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformValueType(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformUriTable(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		
		UriTableImpl uriTable;
		if(this.matching.containsKey(object))
		{
			uriTable = (UriTableImpl) this.matching.get(object);
		}
		else
		{
			uriTable = new UriTableImpl();
			this.matching.put(object, uriTable);
		}
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			if(temp == null)
			{
				continue;
			}
			
			if(name.equalsIgnoreCase("uri"))
			{
				List<String> uris = (List<String>) temp;
				uriTable.getUri().clear();
				uriTable.getUri().addAll(uris);
			}
			
		}
		
		return true;
		
	}

	private boolean transformUAView(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		
		UAViewImpl uaView;
		if(this.matching.containsKey(object))
		{
			uaView = (UAViewImpl) this.matching.get(object);
		}
		else
		{
			uaView = new UAViewImpl();
			this.matching.put(object, uaView);
			this.baseNodeset.getUAView().add(uaView);
		}
		
		boolean success = transformUAInstance(object, stereotype);
		
		if(!success)
		{
			return success;
		}
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			if(temp == null)
			{
				continue;
			}
			
			if(name.equalsIgnoreCase("containsNoLoops"))
			{
				//TODO: Add containsNoLoops
			}
			else if(name.equalsIgnoreCase("eventNotifier"))
			{
				//TODO: Add executable
			}
		}
		

		return true;
		
	}

	private boolean transformUAVariableType(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		
		UAVariableTypeImpl uaVarType;
		if(this.matching.containsKey(object))
		{
			uaVarType = (UAVariableTypeImpl) this.matching.get(object);
		}
		else
		{
			uaVarType = new UAVariableTypeImpl();
			this.matching.put(object, uaVarType);
			this.baseNodeset.getUAVariableType().add(uaVarType);
		}
		
		return transformUAType(object, stereotype);
	}

	private boolean transformUAVariable(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		
		UAVariableImpl uaVariable;
		if(this.matching.containsKey(object))
		{
			uaVariable = (UAVariableImpl) this.matching.get(object);
		}
		else
		{
			uaVariable = new UAVariableImpl();
			this.matching.put(object, uaVariable);
			this.baseNodeset.getUAVariable().add(uaVariable);
		}
		
		EList<Classifier> generals = object.getGenerals();
		boolean success = transformUAInstance(object, stereotype);
		
		if(!success)
		{
			return success;
		}
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			if(temp == null)
			{
				continue;
			}
			
			if(name.equalsIgnoreCase("value"))
			{
				//TODO: Add value
			}
			else if(name.equalsIgnoreCase("translation"))
			{
				//TODO: Add translation
			}
			else if(name.equalsIgnoreCase("accessLevel"))
			{
				String stringToConvert = String.valueOf(temp);
				Long convertedLong = Long.parseLong(stringToConvert);
				uaVariable.setAccessLevel(convertedLong);
			}
			else if(name.equalsIgnoreCase("arrayDimensions"))
			{
				uaVariable.setArrayDimensions(String.valueOf(temp));
			}
			else if(name.equalsIgnoreCase("dataType"))
			{
				String nodeIdString = (String) temp;
				uaVariable.setDataType(nodeIdString);
			}
			else if(name.equalsIgnoreCase("historizing"))
			{
				String stringToConvert = String.valueOf(temp);
				boolean convertedBoolean = Boolean.parseBoolean(stringToConvert);
				uaVariable.setHistorizing(convertedBoolean);
			}
			else if(name.equalsIgnoreCase("minimumSamplingInterval"))
			{
				double intervall = (double ) temp;
				uaVariable.setMinimumSamplingInterval(intervall);
			}
			else if(name.equalsIgnoreCase("userAccessLevel"))
			{
				String stringToConvert = String.valueOf(temp);
				Long convertedLong = Long.parseLong(stringToConvert);
				uaVariable.setUserAccessLevel(convertedLong);
			}
			else if(name.equalsIgnoreCase("valueRank"))
			{
				String stringToConvert = String.valueOf(temp);
				int convertedInt = Integer.parseInt(stringToConvert);
				uaVariable.setValueRank(convertedInt);
			}
		}

		return success;
	}

	private boolean transformUAType(Class object,  DynamicEObjectImpl stereotype) {
		UAType uaObjType;
		if(this.matching.containsKey(object))
		{
			uaObjType = (UAType) this.matching.get(object);
		}
		else
		{
			uaObjType = new UATypeImpl();
			this.matching.put(object, uaObjType);
		}
				
		return transformUANode(object, stereotype);
	}

	private boolean transformUAReferenceType(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		
		UAReferenceTypeImpl uaRefType;
		if(this.matching.containsKey(object))
		{
			uaRefType = (UAReferenceTypeImpl) this.matching.get(object);
		}
		else
		{
			uaRefType = new UAReferenceTypeImpl();
			this.matching.put(object, uaRefType);
			this.baseNodeset.getUAReferenceType().add(uaRefType);
		}
		
		boolean success = transformUAType(object, stereotype);
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			if(temp == null)
			{
				continue;
			}
			
			if(name.equalsIgnoreCase("inverseName"))
			{
				//TODO: add inverserName
			}
			else if(name.equalsIgnoreCase("symmetric"))
			{
				//TODO: add symmetric
			}
		}	
		

		return success;
	}

	private boolean transformUAObjectType(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
			
		UAObjectTypeImpl uaObjType;
		if(this.matching.containsKey(object))
		{
			uaObjType = (UAObjectTypeImpl) this.matching.get(object);
		}
		else
		{
			uaObjType = new UAObjectTypeImpl();
			this.matching.put(object, uaObjType);
			this.baseNodeset.getUAObjectType().add(uaObjType);
		}
		
		boolean success = transformUAType(object, stereotype);
		
		EList<Classifier> generals = object.getGenerals();
		ListOfReferences listOfReferences = uaObjType.getReferences();
		if(listOfReferences == null)
		{
			listOfReferences = new ListOfReferencesImpl();
			uaObjType.setReferences(listOfReferences);
		}
		listOfReferences.getReference().clear();
		
		for(Generalization reference :object.getGeneralizations())
		{
			if(! this.matching.containsKey(reference))
			{
				updatedGeneralization(reference);
			}
			listOfReferences.getReference().add((Reference) this.matching.get(reference));

		}
		return success;
	}

	private boolean transformUAObject(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		
		
		UAObjectImpl uaObject;
		if(this.matching.containsKey(object))
		{
			uaObject = (UAObjectImpl) this.matching.get(object);
		}
		else
		{
			uaObject = new UAObjectImpl();
			this.matching.put(object, uaObject);
			this.baseNodeset.getUAObject().add(uaObject);
		}
		
		boolean success = transformUAInstance(object, stereotype);
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			if(temp == null)
			{
				continue;
			}
			
			if(name.equalsIgnoreCase("eventNotifier"))
			{
				//TODO: Add eventNotifier
			}
		}
		
		return success;
	}

	private boolean transformUANodeSetType(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype nodeSetType = object.getAppliedStereotype("NodeSet::UANodeSetType");
				
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			
			if(name.equalsIgnoreCase("nameSpaceUris"))
			{
				if(temp == null)
				{
					Class namespaceUriTable = (Class) this.baseUmlModel.getMember("NameSpaces");
					Stereotype uriTableType  = nodeSetProfile.getOwnedStereotype("UriTable");

					if(namespaceUriTable == null)
					{
						namespaceUriTable = this.baseUmlModel.createOwnedClass("NameSpaces", false);
						namespaceUriTable.applyStereotype(uriTableType);						
					}
					object.setValue(nodeSetType, "nameSpaceUris", namespaceUriTable.getStereotypeApplication(uriTableType));
					updateClass(namespaceUriTable);
					
					temp = stereotype.dynamicGet(id);
				}
				
				DynamicEObjectImpl uri_object = ((DynamicEObjectImpl) temp);
				EList<EStructuralFeature> featuresList2 = uri_object.eClass().getEAllStructuralFeatures();
				for(EStructuralFeature feature2 : featuresList2)
				{
					int id2 = feature2.getFeatureID();
					String name2 = feature2.getName();
					if(name2.equalsIgnoreCase("base_Class"))
					{
						Object baseClass = uri_object.dynamicGet(id2);
						if(this.matching.containsKey(baseClass))
						{
							UriTableImpl uritable = (UriTableImpl) this.matching.get(baseClass);
							this.baseNodeset.setNamespaceUris(uritable);
							break;
						}
						else
						{
							updateClass((Class) baseClass);
							UriTableImpl uritable = (UriTableImpl) this.matching.get(baseClass);
							this.baseNodeset.setNamespaceUris(uritable);
							break;
						}
					}
				}
			}
			else if(name.equalsIgnoreCase("serverUris"))
			{
				if(temp == null)
				{
					continue;
				}
				DynamicEObjectImpl uri_object = ((DynamicEObjectImpl) temp);
				EList<EStructuralFeature> featuresList2 = uri_object.eClass().getEAllStructuralFeatures();
				for(EStructuralFeature feature2 : featuresList2)
				{
					int id2 = feature2.getFeatureID();
					String name2 = feature2.getName();
					if(name2.equalsIgnoreCase("base_Class"))
					{
						Object baseClass = uri_object.dynamicGet(id2);
						if(this.matching.containsKey(baseClass))
						{
							UriTableImpl uritable = (UriTableImpl) this.matching.get(baseClass);
							this.baseNodeset.setNamespaceUris(uritable);
							break;
						}
						else
						{
							updateClass((Class) baseClass);
							UriTableImpl uritable = (UriTableImpl) this.matching.get(baseClass);
							this.baseNodeset.setNamespaceUris(uritable);
							break;
						}
					}
				}
			}
			else if(name.equalsIgnoreCase("models"))
			{
				if(temp == null)
				{
					continue;
				}
			}
			else if(name.equalsIgnoreCase("aliases"))
			{
				if(temp == null)
				{
					continue;
				}
				
				DynamicEObjectImpl alias_object = ((DynamicEObjectImpl) temp);
				EList<EStructuralFeature> featuresList2 = alias_object.eClass().getEAllStructuralFeatures();
				for(EStructuralFeature feature2 : featuresList2)
				{
					int id2 = feature2.getFeatureID();
					String name2 = feature2.getName();
					if(name2.equalsIgnoreCase("base_Class"))
					{
						Object baseClass = alias_object.dynamicGet(id2);
						if(this.matching.containsKey(baseClass))
						{
							AliasTableImpl aliasTable = (AliasTableImpl) this.matching.get(baseClass);
							this.baseNodeset.setAliases(aliasTable);
							break;
						}
						else
						{
							updateClass((Class) baseClass);
							AliasTableImpl aliasTable = (AliasTableImpl) this.matching.get(baseClass);
							this.baseNodeset.setAliases(aliasTable);
							break;
						}
					}
				}
			}
			else if(name.equalsIgnoreCase("extensions"))
			{
				if(temp == null)
				{
					continue;
				}
				
				
			}
			else if(name.equalsIgnoreCase("group"))
			{
				if(temp == null)
				{
					continue;
				}
				
				
			}
		}
		
		return true;
		
	}

	private boolean transformUANodeSetChangesType(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformUANodeSetChangesStatusType(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformUANode(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		
		UANodeImpl uanode;
		if(this.matching.containsKey(object))
		{
			uanode = (UANodeImpl) this.matching.get(object);
		}
		else
		{
			uanode = new UANodeImpl();
			this.matching.put(object, uanode);
		}
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			if(temp == null)
			{
				continue;
			}
			
			if(name.equalsIgnoreCase("displayName"))
			{
				uanode.getDisplayName().clear();
				List<String> displayNames = (List<String>) temp;
				for(String displayName : displayNames)
				{
					LocalizedTextImpl lt = new LocalizedTextImpl();
					lt.setValue(displayName);
					uanode.getDisplayName().add(lt);
				}
			}
			else if(name.equalsIgnoreCase("description"))
			{
				uanode.getDescription().clear();
				List<String> descriptions = (List<String>) temp;
				for(String description : descriptions)
				{
					LocalizedTextImpl lt = new LocalizedTextImpl();
					lt.setValue(description);
					uanode.getDescription().add(lt);
				}
			}
			else if(name.equalsIgnoreCase("category"))
			{
				List<String> categories = (List<String>) temp;
				uanode.getCategory().clear();
				uanode.getCategory().addAll(categories);
			}
			else if(name.equalsIgnoreCase("documentation"))
			{
				List<String> documentation = (List<String>) temp;
				uanode.getCategory().clear();
				uanode.getCategory().addAll(documentation);
			}
			else if(name.equalsIgnoreCase("references"))
			{
				System.out.println(name);
			}
			else if(name.equalsIgnoreCase("rolePermissions"))
			{
				Object rp_object = ((DynamicEObjectImpl) temp).getClass();
				if(this.matching.containsKey(rp_object))
				{
					ListOfRolePermissions rp = (ListOfRolePermissions) this.matching.get(rp_object);
					uanode.setRolePermissions(rp);
				}
			}
			else if(name.equalsIgnoreCase("extensions"))
			{
				System.out.println(name);
			}
			else if(name.equalsIgnoreCase("accessRestrictions"))
			{
				String stringToConvert = String.valueOf(temp);
				short convertedShort = Short.parseShort(stringToConvert);
				uanode.setAccessRestrictions(convertedShort);
				
			}
			else if(name.equalsIgnoreCase("browseName"))
			{
				String browseNameString = (String) temp;
				
				if(!browseNameString.startsWith("1:"))
				{					
					browseNameString = "1:"+browseNameString;
					stereotype.dynamicSet(id, browseNameString);
				}
				
				uanode.setBrowseName(browseNameString);
				
			}
			else if(name.equalsIgnoreCase("nodeId"))
			{
				String nodeIdString = (String) temp;
				
				if(!(nodeIdString.startsWith("ns=") || nodeIdString.startsWith("i=")))
				{					
					nodeIdString = "ns=1;s="+nodeIdString;
					stereotype.dynamicSet(id, nodeIdString);
				}
				
				uanode.setNodeId(nodeIdString);
			}
			else if(name.equalsIgnoreCase("releaseStatus"))
			{
				EEnumLiteralImpl lit = (EEnumLiteralImpl) temp;
				String value = lit.toString();
				switch(value)
				{
				case "Draft":
					uanode.setReleaseStatus(ReleaseStatus.DRAFT);
					break;
				case "Released":
					uanode.setReleaseStatus(ReleaseStatus.RELEASED);
					break;
				case "Deprecated":
					uanode.setReleaseStatus(ReleaseStatus.DEPRECATED);
					break;
				}
			}
			else if(name.equalsIgnoreCase("symbolicName"))
			{
				List<String> symbolicName = (List<String>) temp;
				uanode.getCategory().clear();
				uanode.getCategory().addAll(symbolicName);
			}
			else if(name.equalsIgnoreCase("userWriteMask"))
			{
				String stringToConvert = String.valueOf(temp);
		        Long convertedLong = Long.parseLong(stringToConvert);
				uanode.setUserWriteMask(convertedLong);
			}
			else if(name.equalsIgnoreCase("writeMask"))
			{
				String stringToConvert = String.valueOf(temp);
				Long convertedLong = Long.parseLong(stringToConvert);
				uanode.setWriteMask(convertedLong);
			}
			
		}

		return true;
	}

	private boolean transformUAMethodArgument(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
	}

	private boolean transformUAMethod(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		
		UAMethodImpl uaMethod;
		if(this.matching.containsKey(object))
		{
			uaMethod = (UAMethodImpl) this.matching.get(object);
		}
		else
		{
			uaMethod = new UAMethodImpl();
			this.matching.put(object, uaMethod);
			this.baseNodeset.getUAMethod().add(uaMethod);
		}
		
		boolean success = transformUAInstance(object, stereotype);
		
		if(!success)
		{
			return success;
		}
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			if(temp == null)
			{
				continue;
			}
			
			if(name.equalsIgnoreCase("argumentDescription"))
			{
				//TODO: Add argumentDescription
			}
			else if(name.equalsIgnoreCase("executable"))
			{
				//TODO: Add executable
			}
			else if(name.equalsIgnoreCase("methodDeclarationId"))
			{
				//TODO: Add methodDeclarationId
			}
			else if(name.equalsIgnoreCase("userExecutable"))
			{
				//TODO: Add userExecutable
			}
		}
		

		return true;
	}

	private boolean transformUAInstance(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		
		UAInstanceImpl uaObjType;
		if(this.matching.containsKey(object))
		{
			uaObjType = (UAInstanceImpl) this.matching.get(object);
		}
		else
		{
			uaObjType = new UAInstanceImpl();
			this.matching.put(object, uaObjType);
		}
				
		boolean success = transformUANode(object, stereotype);
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			if(temp == null)
			{
				continue;
			}
			
			if(name.equalsIgnoreCase("parentNodeId"))
			{
				// TODO: add definition
			}
		}
		
		return success;
	}

	private boolean transformUADataType(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		

		UADataTypeImpl uaDataType;
		if(this.matching.containsKey(object))
		{
			uaDataType = (UADataTypeImpl) this.matching.get(object);
		}
		else
		{
			uaDataType = new UADataTypeImpl();
			this.matching.put(object, uaDataType);
			this.baseNodeset.getUADataType().add(uaDataType);
		}
		boolean success = transformUAType(object, stereotype);
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			if(temp == null)
			{
				continue;
			}
			
			if(name.equalsIgnoreCase("definition"))
			{
				// TODO: add definition
			}
			else if(name.equalsIgnoreCase("purpose"))
			{
				// TODO: add purpose
			}	
		}
		

		return success;
	}

	private boolean transformTranslationType(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		
		TranslationTypeImpl tt;
		if( this.matching.containsKey(object))
		{
			tt = (TranslationTypeImpl) this.matching.get(object);

		}
		else
		{
			tt = new TranslationTypeImpl();
			this.matching.put(object, tt);
		}
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			
			if(name.equalsIgnoreCase("text"))
			{
				tt.getText().clear();
				List<String> texts = (List<String>) temp;
				for(String txt : texts)
				{
					LocalizedTextImpl lt = new LocalizedTextImpl();
					lt.setValue(txt);
					tt.getText().add(lt);
				}
			
			}
			else if(name.equalsIgnoreCase("field"))
			{
				tt.getField().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equalsIgnoreCase("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								StructureTranslationType existingLT = (StructureTranslationType) this.matching.get(baseClass);
								tt.getField().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								StructureTranslationType existingLT = (StructureTranslationType) this.matching.get(baseClass);
								tt.getField().add(existingLT);
								break;
							}
						}
					}
				}
			}
		}

		return true;
	}

	private boolean transformStructureTranslationType(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		
		StructureTranslationTypeImpl stt;
		if( this.matching.containsKey(object))
		{
			stt = (StructureTranslationTypeImpl) this.matching.get(object);

		}
		else
		{
			stt = new StructureTranslationTypeImpl();
			this.matching.put(object, stt);
		}
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			
			if(name.equalsIgnoreCase("text"))
			{
				stt.getText().clear();
				List<String> texts = (List<String>) temp;
				for(String txt : texts)
				{
					LocalizedTextImpl lt = new LocalizedTextImpl();
					lt.setValue(txt);
					stt.getText().add(lt);
				}
				
			}
			else if(name.equalsIgnoreCase("name"))
			{
				stt.setName((String) temp);
			}
		}
		

		return true;
	}

	private boolean transformRolePermission(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		
		RolePermissionImpl rp;
		if( this.matching.containsKey(object))
		{
			rp = (RolePermissionImpl) this.matching.get(object);

		}
		else
		{
			rp = new RolePermissionImpl();
			this.matching.put(object, rp);
		}
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			
			if(name.equalsIgnoreCase("value"))
			{
				rp.setValue((String) temp);
			}
			else if(name.equalsIgnoreCase("permissions"))
			{
				String stringToConvert = String.valueOf(temp);
		        Long convertedLong = Long.parseLong(stringToConvert);
				rp.setPermissions(convertedLong);
			}
		}
		

		return true;
		
	}

	private boolean transformReleaseStatus(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformReferencesToChange(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformReferenceChange(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformNodesToDelete(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformReference(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformNodeToDelete(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformNodesToAdd(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformNodeSetStatusList(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformNodeSetStatus(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformNodeSetPackage(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformNodeSetFactory(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformModelTableEntry(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformModelTable(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformLocalizedText(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			
			if(name.equalsIgnoreCase("value"))
			{
				if( this.matching.containsKey(object))
				{
					LocalizedTextImpl lt = (LocalizedTextImpl) this.matching.get(object);
					lt.setValue((String)temp);
				}
				else
				{
					LocalizedTextImpl lt = new LocalizedTextImpl();
					lt.setValue((String) temp);
					this.matching.put(object, lt);
				}
			}
		}	

		return true;
	}

	private boolean transformListOfRolePermissions(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		
		ListOfRolePermissionsImpl lorp;
		if( this.matching.containsKey(object))
		{
			lorp = (ListOfRolePermissionsImpl) this.matching.get(object);

		}
		else
		{
			lorp = new ListOfRolePermissionsImpl();
			this.matching.put(object, lorp);
		}
		
		lorp.getRolePermission().clear();
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			
			if(name.equalsIgnoreCase("rolePermission"))
			{
				EcoreEList<DynamicEObjectImpl> rpsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl rpUML : rpsUML)
				{

					EList<EStructuralFeature> featuresList2 = rpUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						
						if(name2.equalsIgnoreCase("base_Class"))
						{
							Object baseClass = rpUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								RolePermission rp = (RolePermission) this.matching.get(baseClass);
								lorp.getRolePermission().add(rp);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								RolePermission rp = (RolePermission) this.matching.get(baseClass);
								lorp.getRolePermission().add(rp);
								break;
							}
						}
					}
				}
			}
		}

		return true;
	}

	private boolean transformListOfReferences(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformListOfExtensions(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformExtensionType(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformDocumentRoot(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformDataTypePurpose(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformDataTypeField(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformDataTypeDefinition(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
	}

	private boolean updatedDataType(DataType object)
	{
//		EList<Stereotype> stereotypes = object.getAppliedStereotypes();
//		for(Stereotype ster : stereotypes)
//		{
//			if(ster.getName().equalsIgnoreCase("NodeId"))
//			{
//				
//			}
//		}
		return false;
	}
	
	
	
	private boolean transformAliasTable(Class object, DynamicEObjectImpl stereoptype_application) {
		EList<EStructuralFeature> featuresList = stereoptype_application.eClass().getEAllStructuralFeatures();		
		AliasTable aliasTable = this.baseNodeset.getAliases();
		if(aliasTable == null)
		{
			aliasTable = new AliasTableImpl();
			this.baseNodeset.setAliases(aliasTable);
			this.matching.put(object, aliasTable);
		}	
		aliasTable.getAlias().clear();
		
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			
			if(name.equalsIgnoreCase("alias"))
			{
				EcoreEList<DynamicEObjectImpl> aliasesUML = (EcoreEList<DynamicEObjectImpl>) stereoptype_application.dynamicGet(id);
				for(DynamicEObjectImpl aliasUML : aliasesUML)
				{
					//transformNodeIdAlias(aliasUML);
					EList<EStructuralFeature> featuresList2 = aliasUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equalsIgnoreCase("base_Class"))
						{
							Object baseClass = aliasUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								NodeIdAlias existingAlias = (NodeIdAlias) this.matching.get(baseClass);
								aliasTable.getAlias().add(existingAlias);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								NodeIdAlias existingAlias = (NodeIdAlias) this.matching.get(baseClass);
								aliasTable.getAlias().add(existingAlias);
								break;
							}
						}
					}
				}
			}
		}
		return true;
	}
	
	private boolean transformNodeIdAlias(Class object, DynamicEObjectImpl stereoptype_application) {
		
		EList<EStructuralFeature> featuresList = stereoptype_application.eClass().getEAllStructuralFeatures();
		NodeIdAliasImpl alias = new NodeIdAliasImpl();
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			
			if(name.equalsIgnoreCase("alias"))
			{
				String aliasString = (String) stereoptype_application.dynamicGet(id);
				alias.setAlias(aliasString);
			}
			else if(name.equalsIgnoreCase("value"))
			{
				String nodeIdString = (String) stereoptype_application.dynamicGet(id);
				alias.setValue(nodeIdString);
			}
		}
		
		if(this.matching.containsKey(object))
		{
			NodeIdAlias existingAlias = (NodeIdAlias) this.matching.get(object);
			existingAlias.setAlias(alias.getAlias());
			existingAlias.setValue(alias.getValue());	
		}
		else
		{
			this.matching.put(object, alias);
		}
		
		return true;
	}
	
	private boolean updatedGeneralization(Generalization general) {

		if(general.getSources().size() != 1 || general.getTargets().size() != 1)
		{
			return false;
		}
		
		EList<EObject> stereotype_applications = general.getStereotypeApplications();
		
		ReferenceImpl uaReference;
		
		if(this.matching.containsKey(general))
		{
			uaReference = (ReferenceImpl) this.matching.get(general);
		}
		else
		{
			uaReference = new ReferenceImpl();
			this.matching.put(general, uaReference);
		}
		
		Element target = general.getTargets().get(0);
		Element source = general.getSources().get(0);
		
		for(EObject ster : stereotype_applications)
		{
			DynamicEObjectImpl stereotype = (DynamicEObjectImpl) ster;
			EClass cls = ster.eClass();
			if(cls.getName().equalsIgnoreCase("Reference"))
			{
				EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
				
				for(EStructuralFeature feature : featuresList)
				{
					int id = feature.getFeatureID();
					String name = feature.getName();
					Object temp = stereotype.dynamicGet(id);
					
					if(name.equalsIgnoreCase("value"))
					{
						String nodeId = getNodeId(target);
						uaReference.setValue(nodeId);
					}
					else if(name.equalsIgnoreCase("isForward"))
					{
						String stringToConvert = String.valueOf(temp);
						boolean convertedBoolean = Boolean.parseBoolean(stringToConvert);
						uaReference.setIsForward(convertedBoolean);
					}
					else if(name.equalsIgnoreCase("referenceType"))
					{
						DynamicEObjectImpl uri_object = ((DynamicEObjectImpl) temp);
						EList<EStructuralFeature> featuresList2 = uri_object.eClass().getEAllStructuralFeatures();
						for(EStructuralFeature feature2 : featuresList2)
						{
							int id2 = feature2.getFeatureID();
							String name2 = feature2.getName();
							if(name2.equalsIgnoreCase("base_Class"))
							{
								Object baseClass = uri_object.dynamicGet(id2);
								if(this.matching.containsKey(baseClass))
								{
									UAReferenceType uaRefType = (UAReferenceType) this.matching.get(baseClass);
									uaReference.setReferenceType(uaRefType.getNodeId());
									break;
								}
								else
								{
									updateClass((Class) baseClass);
									UAReferenceType uaRefType = (UAReferenceType) this.matching.get(baseClass);
									uaReference.setReferenceType(uaRefType.getNodeId());
									break;
								}
							}
						}
					}
				}
			}
		}
		

		if(!this.matching.containsKey(source))
		{
			updateClass((Class) source);
		}
		
		UANode src = (UANode) this.matching.get(source);
		ListOfReferences refList = src.getReferences();
		
		boolean contains = refList.getReference().contains(uaReference);
		if(!contains)
		{
			refList.getReference().add(uaReference);
		}
		
		
		return true;
	}
	
	private String getNodeId(Element object)
	{
		EList<EObject> applied_stereotypes = object.getStereotypeApplications();
		for(EObject applied_stereotype : applied_stereotypes)
		{
			DynamicEObjectImpl dyn_ster = (DynamicEObjectImpl) applied_stereotype;
			
			EList<EStructuralFeature> featureList = dyn_ster.eClass().getEAllStructuralFeatures();
			for(EStructuralFeature feature : featureList)
			{
				String name = feature.getName();
				if(name.equalsIgnoreCase("nodeId"))
				{
					int id = feature.getFeatureID();
					return (String) dyn_ster.dynamicGet(id);
				}
			}
		}
		
		return "";
	}
	
	public boolean updatedMember(UANodeSetType nodeset)
	{
		
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(this.baseUmlModel);
		
		// changes to diagrams shall be done inside commands
		UpdateUMLCommand cmd = new UpdateUMLCommand(domain);
		cmd.setNodeSet(nodeset);
		cmd.registerInstanceSynchHandler(this);
		
		domain.getCommandStack().execute(cmd);
		
		return cmd.getCommandResult();
	}
	
	protected boolean updateMember(UANodeSetType nodeset)
	{
        // Implement your write operations here,
    	boolean success = true;
    	success &= updateNamespaces(nodeset.getNamespaceUris());
		
		for(UAObjectType node : nodeset.getUAObjectType())
		{
			success &= updateOpcUAObjectType(node);
		}
		
		for(UAMethod node : nodeset.getUAMethod())
		{
			success &= updateOpcUAMethod(node);
		}
		
		for(UAObject node : nodeset.getUAObject())
		{
			success &= updateOpcUAObject(node);
		}
		
		for(UAVariable node : nodeset.getUAVariable())
		{
			success &= updateOpcUAVariable(node);
		}
	       
		return success;
	}
	
	private boolean updateNamespaces(UriTable namespaceUris) {
		// TODO Auto-generated method stub
		EList<String> namespaces_new = namespaceUris.getUri();	
		EList<String> namespaces_old = this.baseNodeset.getNamespaceUris().getUri();
		
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uriTableType  = nodeSetProfile.getOwnedStereotype("UriTable");
		
		NamedElement namespaceUriTable = this.baseUmlModel.getMember("NameSpaces");
		DynamicEObjectImpl umlUriTable = (DynamicEObjectImpl) namespaceUriTable.getStereotypeApplication(uriTableType);
		
		EList<EStructuralFeature> featuresList = umlUriTable.eClass().getEAllStructuralFeatures();
				
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = umlUriTable.dynamicGet(id);
			if(temp == null)
			{
				continue;
			}
			
			if(name.equalsIgnoreCase("uri"))
			{
				umlUriTable.dynamicSet(id, namespaces_new);

				namespaces_old.clear();
				namespaces_old.addAll(namespaces_new);
			}
			
		}
						
		return true;
	}

	private boolean updateOpcUAObjectType(UAObjectType node) {
	
		Element uaElement = null;
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaObjectTypeType  = nodeSetProfile.getOwnedStereotype("UAObjectType");
		
		for(Entry<Element, Object> entry : this.matching.entrySet())
		{
			Object uaMember = entry.getValue();
			if(uaMember instanceof UAObjectType)
			{
				UAObjectType uaObjectType = (UAObjectType) uaMember;				
				if(uaObjectType.getNodeId() != null && uaObjectType.getNodeId().equalsIgnoreCase(node.getNodeId()))
				{
					uaElement = entry.getKey();
					break;
				}
			}
		}
		
		if(uaElement == null)
		{
			// Element does not exist in Model 
			// create new UAObjectType Element
			int separator = node.getBrowseName().lastIndexOf(":")+1;
			String name = node.getBrowseName().substring(separator);

			uaElement= baseUmlModel.createOwnedClass(name, false);
			uaElement.applyStereotype(uaObjectTypeType);
			this.matching.put(uaElement, node);
			this.baseNodeset.getUAObjectType().add(node);
		}
		
		
		DynamicEObjectImpl stereotype = (DynamicEObjectImpl) uaElement.getStereotypeApplication(uaObjectTypeType);
		if(stereotype == null)
		{
			// UAObjectType Stereotype not applied !!!
			this.matching.remove(uaElement);
			this.baseNodeset.getUAObjectType().remove(node);
			return false;
		}
		
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			
			if(name.equalsIgnoreCase("displayName"))
			{
				
				List<String> displayNames = new ArrayList<String>();
				
				for(LocalizedText displayName : node.getDisplayName())
				{
					displayNames.add(displayName.getValue());
				}
				
				stereotype.dynamicSet(id, displayNames.toArray());
				
			}
			else if(name.equalsIgnoreCase("description"))
			{
				
				List<String> descriptions = new ArrayList<String>();
				
				for(LocalizedText displayName : node.getDescription())
				{
					descriptions.add(displayName.getValue());
				}
				
				stereotype.dynamicSet(id, descriptions.toArray());
			}
			else if(name.equalsIgnoreCase("category"))
			{
				stereotype.dynamicSet(id, node.getCategory());
			}
			else if(name.equalsIgnoreCase("documentation"))
			{
				stereotype.dynamicSet(id, node.getDocumentation());
			}
			else if(name.equalsIgnoreCase("rolePermissions"))
			{
//				Object rp_object = ((DynamicEObjectImpl) temp).getClass();
//				if(this.matching.containsKey(rp_object))
//				{
//					ListOfRolePermissions rp = (ListOfRolePermissions) this.matching.get(rp_object);
//					uaObjType.setRolePermissions(rp);
//				}
			}
			else if(name.equalsIgnoreCase("accessRestrictions"))
			{
				stereotype.dynamicSet(id, String.valueOf(node.getAccessRestrictions()));	
			}
			else if(name.equalsIgnoreCase("browseName"))
			{

				stereotype.dynamicSet(id,node.getBrowseName());	
				
			}
			else if(name.equalsIgnoreCase("nodeId"))
			{
				stereotype.dynamicSet(id,node.getNodeId());	
			}
			else if(name.equalsIgnoreCase("releaseStatus"))
			{
//				EEnumLiteralImpl lit = (EEnumLiteralImpl) temp;
//				String value = lit.toString();
//				switch(value)
//				{
//				case "Draft":
//					uaObjType.setReleaseStatus(ReleaseStatus.DRAFT);
//					break;
//				case "Released":
//					uaObjType.setReleaseStatus(ReleaseStatus.RELEASED);
//					break;
//				case "Deprecated":
//					uaObjType.setReleaseStatus(ReleaseStatus.DEPRECATED);
//					break;
//				}
			}
			else if(name.equalsIgnoreCase("symbolicName"))
			{
				stereotype.dynamicSet(id,node.getSymbolicName());
			}
			else if(name.equalsIgnoreCase("userWriteMask"))
			{
				stereotype.dynamicSet(id, String.valueOf(node.getUserWriteMask()));	
			}
			else if(name.equalsIgnoreCase("writeMask"))
			{
				stereotype.dynamicSet(id, String.valueOf(node.getWriteMask()));	
			}			
		}
		
//		EList<Classifier> generals = object.getGenerals();
//		ListOfReferences listOfReferences = uaObjType.getReferences();
//		if(listOfReferences == null)
//		{
//			listOfReferences = new ListOfReferencesImpl();
//			uaObjType.setReferences(listOfReferences);
//		}
//		listOfReferences.getReference().clear();
//		
//		for(Generalization reference :object.getGeneralizations())
//		{
//			if(! this.matching.containsKey(reference))
//			{
//				updatedGeneralization(reference);
//			}
//			listOfReferences.getReference().add((Reference) this.matching.get(reference));
//
//		}
		
		return true;
	}
	
	private boolean updateOpcUAMethod(UAMethod node) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean updateOpcUAObject(UAObject node) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean updateOpcUAVariable(UAVariable node) {
		// TODO Auto-generated method stub
		return true;
	}
}
