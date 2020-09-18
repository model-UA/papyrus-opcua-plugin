package org.eclipse.papyrus.opcua.diagram.transformer;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.EEnumLiteralImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
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
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAInstance;
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
	private HashMap<String, Element> nodeIdMap;
	private HashMap<String, String> aliasTable;
	
	public InstanceSyncHandler(Model umlModel)
	{
		this.baseUmlModel = umlModel;
		this.matching = new HashMap<Element, Object>();
		this.nodeIdMap = new HashMap<String, Element>();
		this.aliasTable = new HashMap<String, String>();
	}
	
	public InstanceSyncHandler(UANodeSetType nodeset)
	{
		this.baseNodeset = nodeset;
		this.matching = new HashMap<Element, Object>();
		this.nodeIdMap = new HashMap<String, Element>();
		this.aliasTable = new HashMap<String, String>();
	}
	
	public InstanceSyncHandler(Model umlModel, UANodeSetType nodeset)
	{
		this.baseUmlModel = umlModel;
		this.baseNodeset = nodeset;
		this.matching = new HashMap<Element, Object>();
		this.nodeIdMap = new HashMap<String, Element>();
		this.aliasTable = new HashMap<String, String>();
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
       
        NodeSetParser.writeNodeSetFile(filename.toOSString(), this.baseNodeset);
        
		return true;
	}

	
	public void setNodeSetObject(UANodeSetType nodeset)
	{
		this.baseNodeset = nodeset;
	}
	
	public void setUmlModel (Model umlModel)
	{
		this.baseUmlModel = umlModel;
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
			case "ExtensionType":
				success=transformExtensionType(object, stereotype);
				break;
			case "ListOfExtensions":
				success=transformListOfExtensions(object, stereotype);
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
		// EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformValueType(Class object,  DynamicEObjectImpl stereotype) {
		//EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
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
		
		boolean success = true;
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
				try
				{					
					List<String> uris = (List<String>) temp;
					uriTable.getUri().clear();
					uriTable.getUri().addAll(uris);
				}
				catch (Exception e) {
					success = false;
				}
			}
			
		}
		
		return success;
		
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
				String stringToConvert = String.valueOf(temp);
				boolean convertedBoolean = Boolean.parseBoolean(stringToConvert);
				uaView.setContainsNoLoops(convertedBoolean);
			}
			else if(name.equalsIgnoreCase("eventNotifier"))
			{
				String stringToConvert = String.valueOf(temp);
				short convertedShort = Short.parseShort(stringToConvert);
				uaView.setEventNotifier(convertedShort);
			}
		}
		

		return true;
		
	}

	private boolean transformUAVariableType(Class object,  DynamicEObjectImpl stereotype) {
		
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
				String stringToConvert = String.valueOf(temp);
				short convertedShort = Short.parseShort(stringToConvert);
				uaObject.setEventNotifier(convertedShort);
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
//		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformUANodeSetChangesStatusType(Class object,  DynamicEObjectImpl stereotype) {
// 		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
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
//		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
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

	private boolean transformListOfExtensions(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
	}

	private boolean transformExtensionType(Class object,  DynamicEObjectImpl stereotype) {
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
						Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
						Stereotype uaReferenceType  = nodeSetProfile.getOwnedStereotype("Reference");
						
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
    	
    	if(nodeset.getNamespaceUris() != null) {    		
    		success &= updateNamespaces(nodeset.getNamespaceUris());
    	}
    	
    	if(nodeset.getAliases() != null) {    		
    		success &= updateOpcUAliasTable(nodeset.getAliases());
    	}
    	
    	
    	ArrayList<UANode> referenceNodes = new ArrayList<UANode>();
    	
    	if(nodeset.getUAObjectType() != null)
    	{    		
    		// adding and removing needs to be done via list otherwise 
    		// ConcurrentModificationException
    		EList<UAObjectType> uaObjectTypes = nodeset.getUAObjectType();
    		List<UAObjectType> nodesToAdd = new ArrayList<UAObjectType>();
    		List<UAObjectType> nodesToDelete = new ArrayList<UAObjectType>();

    		for(UAObjectType t : uaObjectTypes)
    		{
    			if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    			{
    				referenceNodes.add(t);
    			}
    			success &= updateOpcUAObjectType(t, nodesToAdd, nodesToDelete);
    		}
    		
    		this.baseNodeset.getUAObjectType().removeAll(nodesToDelete);
    		this.baseNodeset.getUAObjectType().addAll(nodesToAdd);

    	}
    	
    	if(nodeset.getUAVariableType() != null)
    	{    		
    		// adding and removing needs to be done via list otherwise 
    		// ConcurrentModificationException
    		EList<UAVariableType> uaVariableTypes = nodeset.getUAVariableType();
    		List<UAVariableType> nodesToAdd = new ArrayList<UAVariableType>();
    		List<UAVariableType> nodesToDelete = new ArrayList<UAVariableType>();
    		
    		
    		for(UAVariableType t : uaVariableTypes)
    		{
    			if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    			{
    				referenceNodes.add(t);
    			}
    			success &= updateOpcUAVariableType(t, nodesToAdd, nodesToDelete);
    		}
    		
    		this.baseNodeset.getUAVariableType().removeAll(nodesToDelete);
    		this.baseNodeset.getUAVariableType().addAll(nodesToAdd);
    	}
    	
    	if(nodeset.getUADataType() != null)
    	{    		
    		// adding and removing needs to be done via list otherwise 
    		// ConcurrentModificationException
    		EList<UADataType> uaDataTypes = nodeset.getUADataType();
    		List<UADataType> nodesToAdd = new ArrayList<UADataType>();
    		List<UADataType> nodesToDelete = new ArrayList<UADataType>();
    		
    		for(UADataType t : uaDataTypes)
    		{
    			if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    			{
    				referenceNodes.add(t);
    			}
    			success &= updateOpcUADataType(t, nodesToAdd, nodesToDelete);
    		}
    		
    		this.baseNodeset.getUADataType().removeAll(nodesToDelete);
    		this.baseNodeset.getUADataType().addAll(nodesToAdd);
    	}
		
    	if(nodeset.getUAReferenceType() != null)
    	{    		
    		// adding and removing needs to be done via list otherwise 
    		// ConcurrentModificationException
    		EList<UAReferenceType> uaDataTypes = nodeset.getUAReferenceType();
    		List<UAReferenceType> nodesToAdd = new ArrayList<UAReferenceType>();
    		List<UAReferenceType> nodesToDelete = new ArrayList<UAReferenceType>();
    		
    		for(UAReferenceType t : uaDataTypes)
    		{
    			if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    			{
    				referenceNodes.add(t);
    			}
    			success &= updateOpcUAReferenceType(t, nodesToAdd, nodesToDelete);
    		}

    		this.baseNodeset.getUAReferenceType().removeAll(nodesToDelete);
    		this.baseNodeset.getUAReferenceType().addAll(nodesToAdd);
    	}
    	
    	
    	if(nodeset.getUAObject() != null)
    	{
    		// adding and removing needs to be done via list otherwise 
    		// ConcurrentModificationException
			EList<UAObject> uaObjects = nodeset.getUAObject();
    		List<UAObject> nodesToAdd = new ArrayList<UAObject>();
    		List<UAObject> nodesToDelete = new ArrayList<UAObject>();
    		
    		for(UAObject t : uaObjects)
    		{
    			if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    			{
    				referenceNodes.add(t);
    			}
    			success &= updateOpcUAObject(t, nodesToAdd, nodesToDelete);
    		}
    		
    		this.baseNodeset.getUAObject().removeAll(nodesToDelete);
    		this.baseNodeset.getUAObject().addAll(nodesToAdd);
    	}
    	if(nodeset.getUAVariable() != null)
    	{	
    		// adding and removing needs to be done via list otherwise 
    		// ConcurrentModificationException
			EList<UAVariable> uaVariables = nodeset.getUAVariable();
    		List<UAVariable> nodesToAdd = new ArrayList<UAVariable>();
    		List<UAVariable> nodesToDelete = new ArrayList<UAVariable>();
    		
    		for(UAVariable t : uaVariables)
    		{
    			if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    			{
    				referenceNodes.add(t);
    			}
    			success &= updateOpcUAVariable(t, nodesToAdd, nodesToDelete);
    		}
    		
    		this.baseNodeset.getUAVariable().removeAll(nodesToDelete);
    		this.baseNodeset.getUAVariable().addAll(nodesToAdd);
			
    	}  
    	
    	if(nodeset.getUAMethod() != null)
    	{    		

    		// adding and removing needs to be done via list otherwise 
    		// ConcurrentModificationException
    		EList<UAMethod> uaMethods = nodeset.getUAMethod();
    		List<UAMethod> nodesToAdd = new ArrayList<UAMethod>();
    		List<UAMethod> nodesToDelete = new ArrayList<UAMethod>();
    		
    		for(UAMethod t : uaMethods)
    		{
    			if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    			{
    				referenceNodes.add(t);
    			}
    			success &= updateOpcUAMethod(t, nodesToAdd, nodesToDelete);
    		}
    		
    		this.baseNodeset.getUAMethod().removeAll(nodesToDelete);
    		this.baseNodeset.getUAMethod().addAll(nodesToAdd);
    		
    	}
    	
    	if(nodeset.getUAView() != null)
    	{    		

    		// adding and removing needs to be done via list otherwise 
    		// ConcurrentModificationException
    		EList<UAView> uaViews = nodeset.getUAView();
    		List<UAView> nodesToAdd = new ArrayList<UAView>();
    		List<UAView> nodesToDelete = new ArrayList<UAView>();
    		
    		for(UAView t : uaViews)
    		{
    			if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    			{
    				referenceNodes.add(t);
    			}
    			success &= updateOpcUAView(t, nodesToAdd, nodesToDelete);
    		}
    		

    		
    		this.baseNodeset.getUAView().removeAll(nodesToDelete);
    		this.baseNodeset.getUAView().addAll(nodesToAdd);
    		
    	}
    	
    	if(success)
    	{
    		success &= updateOpcUaReferences(referenceNodes);
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
	
	private boolean updateOpcUAliasTable(AliasTable aliasTable)
	{
		boolean success = true;
			
		for(NodeIdAlias alias : aliasTable.getAlias())
		{
			this.aliasTable.put(alias.getAlias(), alias.getValue());
		}
		
		return success;
	}
	
	private boolean updateOpcUAObjectType(UAObjectType node, List<UAObjectType> nodesToAdd, List<UAObjectType> nodesToDelete) {
	
		Element uaElement = null;
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAObjectType");
		
		if(this.nodeIdMap.containsKey(node.getNodeId()))
		{
			uaElement = this.nodeIdMap.get(node.getNodeId());
		}
		
		if(uaElement == null)
		{
			// Element does not exist in Model 
			// create new UAObjectType Element
			int separator = node.getBrowseName().lastIndexOf(":")+1;
			String name = node.getBrowseName().substring(separator);

			uaElement= baseUmlModel.createOwnedClass(name, false);
			uaElement.applyStereotype(uaStereoType);
			this.matching.put(uaElement, node);
			nodesToAdd.add(node);
		}
		
		
		DynamicEObjectImpl stereotype = (DynamicEObjectImpl) uaElement.getStereotypeApplication(uaStereoType);
		if(stereotype == null)
		{
			this.matching.remove(uaElement);
			nodesToDelete.add(node);
			return true;
		}
		
		boolean success = updateOpcUaType(node, uaStereoType, uaElement);
				
		return success;
	}
		
	private boolean updateOpcUAVariableType(UAVariableType node, List<UAVariableType> nodesToAdd, List<UAVariableType> nodesToDelete) {
		Element uaElement = null;
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAVariableType");
		
		if(this.nodeIdMap.containsKey(node.getNodeId()))
		{
			uaElement = this.nodeIdMap.get(node.getNodeId());
		}
		
		if(uaElement == null)
		{
			// Element does not exist in Model 
			// create new UAObjectType Element
			int separator = node.getBrowseName().lastIndexOf(":")+1;
			String name = node.getBrowseName().substring(separator);

			uaElement= baseUmlModel.createOwnedClass(name, false);
			uaElement.applyStereotype(uaStereoType);
			this.matching.put(uaElement, node);
			nodesToAdd.add(node);
		}
		
		
		DynamicEObjectImpl stereotype = (DynamicEObjectImpl) uaElement.getStereotypeApplication(uaStereoType);
		if(stereotype == null)
		{
			// UAObjectType Stereotype not applied !!!
			this.matching.remove(uaElement);
			nodesToDelete.add(node);
			return true;
		}
		
		boolean success = updateOpcUaType(node, uaStereoType, uaElement);
		return success;
	}
	
	private boolean updateOpcUADataType(UADataType node, List<UADataType> nodesToAdd, List<UADataType> nodesToDelete) {
		Element uaElement = null;
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UADataType");
		
		if(this.nodeIdMap.containsKey(node.getNodeId()))
		{
			uaElement = this.nodeIdMap.get(node.getNodeId());
		}
		
		if(uaElement == null)
		{
			// Element does not exist in Model 
			// create new UAObjectType Element
			int separator = node.getBrowseName().lastIndexOf(":")+1;
			String name = node.getBrowseName().substring(separator);

			uaElement= baseUmlModel.createOwnedClass(name, false);
			uaElement.applyStereotype(uaStereoType);
			this.matching.put(uaElement, node);
			nodesToAdd.add(node);
		}
		
		
		DynamicEObjectImpl stereotype = (DynamicEObjectImpl) uaElement.getStereotypeApplication(uaStereoType);
		if(stereotype == null)
		{
			// UAObjectType Stereotype not applied !!!
			this.matching.remove(uaElement);
			nodesToDelete.add(node);
			return true;
		}
		
		boolean success = updateOpcUaType(node, uaStereoType, uaElement);
		
//		if(success)
//		{			
//			EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
//			
//			for(EStructuralFeature feature : featuresList)
//			{
//				int id = feature.getFeatureID();
//				String name = feature.getName();
//				
//				if(name.equalsIgnoreCase("definition"))
//				{
//					// TODO: add definition
//				}
//				else if(name.equalsIgnoreCase("purpose"))
//				{
//					// TODO: add purpose
//				}
//				
//			}
//		}
		
		return success;
	}
	
	private boolean updateOpcUAReferenceType(UAReferenceType node, List<UAReferenceType> nodesToAdd, List<UAReferenceType> nodesToDelete) {
		Class uaElement = null;
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAReferenceType");
		
		if(this.nodeIdMap.containsKey(node.getNodeId()))
		{
			uaElement = (Class) this.nodeIdMap.get(node.getNodeId());
		}
		
		if(uaElement == null)
		{
			// Element does not exist in Model 
			// create new UAObjectType Element
			int separator = node.getBrowseName().lastIndexOf(":")+1;
			String name = node.getBrowseName().substring(separator);

			uaElement= baseUmlModel.createOwnedClass(name, false);
			uaElement.applyStereotype(uaStereoType);
			this.matching.put(uaElement, node);
			nodesToAdd.add(node);
		}
		
		
		DynamicEObjectImpl stereotype = (DynamicEObjectImpl) uaElement.getStereotypeApplication(uaStereoType);
		if(stereotype == null)
		{
			// UAObjectType Stereotype not applied !!!
			this.matching.remove(uaElement);
			nodesToDelete.add(node);
			return true;
		}
		
		boolean success = updateOpcUaType(node, uaStereoType, uaElement);
		
		if(success)
		{			
			
			if(node.getInverseName() != null)
			{
				
				EDataTypeUniqueEList<Object> displayNames = (EDataTypeUniqueEList<Object>) uaElement.getValue(uaStereoType, "displayName");
				for(LocalizedText inverseName : node.getInverseName())
				{
					displayNames.add(inverseName.getValue());
				}
			}
			
			
			uaElement.setValue(uaStereoType, "symmetric", String.valueOf(node.isSymmetric()));
		}
		
		return success;
	
	}
	
	private boolean updateOpcUAObject(UAObject node, List<UAObject> nodesToAdd, List<UAObject> nodesToDelete) {
		Class uaElement = null;
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAObject");
		
		if(this.nodeIdMap.containsKey(node.getNodeId()))
		{
			uaElement = (Class) this.nodeIdMap.get(node.getNodeId());
		}
		
		if(uaElement == null)
		{
			// Element does not exist in Model 
			// create new UAObjectType Element
			int separator = node.getBrowseName().lastIndexOf(":")+1;
			String name = node.getBrowseName().substring(separator);

			uaElement= baseUmlModel.createOwnedClass(name, false);
			uaElement.applyStereotype(uaStereoType);
			this.matching.put(uaElement, node);
			nodesToAdd.add(node);
		}
		
		
		DynamicEObjectImpl stereotype = (DynamicEObjectImpl) uaElement.getStereotypeApplication(uaStereoType);
		if(stereotype == null)
		{
			// UAObjectType Stereotype not applied !!!
			this.matching.remove(uaElement);
			nodesToDelete.add(node);
			return true;
		}
		 
		boolean success = updateOpcUaInstance(node, uaStereoType, uaElement);
		
		if(success)
		{			
			uaElement.setValue(uaStereoType, "eventNotifier", String.valueOf(node.getEventNotifier()));
		}
		
		return success;
	}
	

	private boolean updateOpcUAVariable(UAVariable node, List<UAVariable> nodesToAdd, List<UAVariable> nodesToDelete) {
		Element uaElement = null;
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAVariable");
		
		if(this.nodeIdMap.containsKey(node.getNodeId()))
		{
			uaElement = this.nodeIdMap.get(node.getNodeId());
		}

		if(uaElement == null)
		{
			// Element does not exist in Model 
			// create new UAObjectType Element
			int separator = node.getBrowseName().lastIndexOf(":")+1;
			String name = node.getBrowseName().substring(separator);

			uaElement= baseUmlModel.createOwnedClass(name, false);
			uaElement.applyStereotype(uaStereoType);
			this.matching.put(uaElement, node);
			nodesToAdd.add(node);
		}
		
		
		DynamicEObjectImpl stereotype = (DynamicEObjectImpl) uaElement.getStereotypeApplication(uaStereoType);
		if(stereotype == null)
		{
			// UAObjectType Stereotype not applied !!!
			this.matching.remove(uaElement);
			nodesToDelete.add(node);
			return true;
		}
		 
		boolean success = updateOpcUaInstance(node, uaStereoType, uaElement);
		
//		if(success)
//		{
//			EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
//			
//			for(EStructuralFeature feature : featuresList)
//			{
//				int id = feature.getFeatureID();
//				String name = feature.getName();
//				
//				if(name.equalsIgnoreCase("value"))
//				{
//					//TODO: Add value
//				}
//				else if(name.equalsIgnoreCase("translation"))
//				{
//					//TODO: Add translation
//				}
//				else if(name.equalsIgnoreCase("accessLevel"))
//				{
//					//TODO: Add accessLevel
//
//				}
//				else if(name.equalsIgnoreCase("arrayDimensions"))
//				{
//					//TODO: Add arrayDimensions
//
//				}
//				else if(name.equalsIgnoreCase("dataType"))
//				{
//					//TODO: Add dataType
//
//				}
//				else if(name.equalsIgnoreCase("historizing"))
//				{
//					//TODO: Add historizing
//
//				}
//				else if(name.equalsIgnoreCase("minimumSamplingInterval"))
//				{
//					//TODO: Add minimumSamplingInterval
//				}
//				else if(name.equalsIgnoreCase("userAccessLevel"))
//				{
//					//TODO: Add userAccessLevel
//
//				}
//				else if(name.equalsIgnoreCase("valueRank"))
//				{
//					//TODO: Add valueRank
//
//				}
//			}
//		}
		
		
		return success;
	}

	private boolean updateOpcUAMethod(UAMethod node, List<UAMethod> nodesToAdd, List<UAMethod> nodesToDelete) {
		Element uaElement = null;
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAMethod");
		
		if(this.nodeIdMap.containsKey(node.getNodeId()))
		{
			uaElement = this.nodeIdMap.get(node.getNodeId());
		}
		
		if(uaElement == null)
		{
			// Element does not exist in Model 
			// create new UAObjectType Element
			int separator = node.getBrowseName().lastIndexOf(":")+1;
			String name = node.getBrowseName().substring(separator);

			uaElement= baseUmlModel.createOwnedClass(name, false);
			uaElement.applyStereotype(uaStereoType);
			this.matching.put(uaElement, node);
			nodesToAdd.add(node);
		}
		
		
		DynamicEObjectImpl stereotype = (DynamicEObjectImpl) uaElement.getStereotypeApplication(uaStereoType);
		if(stereotype == null)
		{
			// UAObjectType Stereotype not applied !!!
			this.matching.remove(uaElement);
			nodesToDelete.add(node);
			return true;
		}
		 
		boolean success = updateOpcUaInstance(node, uaStereoType, uaElement);
		
//		if(success)
//		{
//			EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
//			
//			for(EStructuralFeature feature : featuresList)
//			{
//				int id = feature.getFeatureID();
//				String name = feature.getName();
//				Object temp = stereotype.dynamicGet(id);
//				if(temp == null)
//				{
//					continue;
//				}
//				
//				if(name.equalsIgnoreCase("argumentDescription"))
//				{
//					//TODO: Add argumentDescription
//				}
//				else if(name.equalsIgnoreCase("executable"))
//				{
//					//TODO: Add executable
//				}
//				else if(name.equalsIgnoreCase("methodDeclarationId"))
//				{
//					//TODO: Add methodDeclarationId
//				}
//				else if(name.equalsIgnoreCase("userExecutable"))
//				{
//					//TODO: Add userExecutable
//				}
//			}
//		}
//		
		return success;
	}
	
	private boolean updateOpcUAView(UAView node, List<UAView> nodesToAdd, List<UAView> nodesToDelete) {
		Element uaElement = null;
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAView");
		
		if(this.nodeIdMap.containsKey(node.getNodeId()))
		{
			uaElement = this.nodeIdMap.get(node.getNodeId());
		}
		
		if(uaElement == null)
		{
			// Element does not exist in Model 
			// create new UAObjectType Element
			int separator = node.getBrowseName().lastIndexOf(":")+1;
			String name = node.getBrowseName().substring(separator);

			uaElement= baseUmlModel.createOwnedClass(name, false);
			uaElement.applyStereotype(uaStereoType);
			this.matching.put(uaElement, node);
			nodesToAdd.add(node);
		}
		
		
		DynamicEObjectImpl stereotype = (DynamicEObjectImpl) uaElement.getStereotypeApplication(uaStereoType);
		if(stereotype == null)
		{
			// UAObjectType Stereotype not applied !!!
			this.matching.remove(uaElement);
			nodesToDelete.add(node);
			return true;
		}
		 
		boolean success = updateOpcUaInstance(node, uaStereoType, uaElement);
		return success;
	}
	
	private boolean updateOpcUaInstance(UAInstance node, Stereotype stereotype, Element uaElement) {

		boolean success = updateOpcUaNode(node, stereotype, uaElement);
		if(success)
		{
			if(node.getParentNodeId() != null) {
				uaElement.setValue(stereotype, "parentNodeId", node.getParentNodeId());		
			}
		}
		return success;
	}
	
	private boolean updateOpcUaType(UAType node, Stereotype stereotype, Element uaElement) {
		boolean success = updateOpcUaNode(node, stereotype, uaElement);
		return success;
	}
	
	private boolean updateOpcUaNode(UANode node, Stereotype stereotype, Element uaElement) {

		
		if(node.getDisplayName() != null)
		{			
			EDataTypeUniqueEList<Object> displayNames = (EDataTypeUniqueEList<Object>) uaElement.getValue(stereotype, "displayName");
			for(LocalizedText displayName : node.getDisplayName())
			{
				displayNames.add(displayName.getValue());
			}
		}
		
		if(node.getDescription() != null)
		{			
			EDataTypeUniqueEList<Object> description = (EDataTypeUniqueEList<Object>) uaElement.getValue(stereotype, "description");
			for(LocalizedText displayName : node.getDescription())
			{
				description.add(displayName.getValue());
			}
		}
		
		if(node.getCategory() != null)
		{			
			uaElement.setValue(stereotype, "category", node.getCategory());
		}
		
		if(node.getDocumentation() != null)
		{			
			uaElement.setValue(stereotype, "documentation", node.getDocumentation());
		}
		
//		if(node.getRolePermissions() != null)
//		{			
//			// TODO: rolepermissions
//			EDataTypeUniqueEList<Object> rolePermissions = (EDataTypeUniqueEList<Object>) uaElement.getValue(stereotype, "rolePermissions");
////				Object rp_object = ((DynamicEObjectImpl) temp).getClass();
////				if(this.matching.containsKey(rp_object))
////				{
////					ListOfRolePermissions rp = (ListOfRolePermissions) this.matching.get(rp_object);
////					uaObjType.setRolePermissions(rp);
////				}
//		}
//		// short cannot be null
		uaElement.setValue(stereotype, "accessRestrictions", String.valueOf(node.getAccessRestrictions()));
		
		if(node.getBrowseName() != null)
		{
			uaElement.setValue(stereotype, "browseName", node.getBrowseName());
		}
		if(node.getNodeId() != null) {
			String nodeId = node.getNodeId();
			uaElement.setValue(stereotype, "nodeId", nodeId);
			
			this.nodeIdMap.put(nodeId, uaElement);			
		}
//		
//		if(node.getReleaseStatus() != null) {
//			Object releaseStatus = uaElement.getValue(stereotype, "releaseStatus");
//			String test = "dasfasf";
////				EEnumLiteralImpl lit = (EEnumLiteralImpl) temp;
////				String value = lit.toString();
////				switch(value)
////				{
////				case "Draft":
////					uaObjType.setReleaseStatus(ReleaseStatus.DRAFT);
////					break;
////				case "Released":
////					uaObjType.setReleaseStatus(ReleaseStatus.RELEASED);
////					break;
////				case "Deprecated":
////					uaObjType.setReleaseStatus(ReleaseStatus.DEPRECATED);
////					break;
////				}
//		}
//		
		if(node.getSymbolicName() != null)
		{			
			EDataTypeUniqueEList<Object> symbollicName = (EDataTypeUniqueEList<Object>) uaElement.getValue(stereotype, "symbolicName");
			for(String symbolic : node.getSymbolicName())
			{
				symbollicName.add(symbolic);
			}
		}
		// userWriteMask and writeMask cannot be null since they are Shorts
		uaElement.setValue(stereotype, "userWriteMask", String.valueOf(node.getUserWriteMask()));
		uaElement.setValue(stereotype, "writeMask", String.valueOf(node.getWriteMask()));
			
		return true;
	}
	private boolean updateOpcUaReferences(ArrayList<UANode> referenceNodes)
	{
		boolean success = true;
		for(UANode node : referenceNodes)
		{
			success &= updateOpcUaNodeReferences(node);
			if(!success)
			{
				break;
			}
		}
		
		return success;
	}
	
	private boolean updateOpcUaNodeReferences(UANode node)
	{
				
		Class uaElement = null;
		if(this.nodeIdMap.containsKey(node.getNodeId()))
		{
			uaElement = (Class) this.nodeIdMap.get(node.getNodeId());
		}
		else
		{
			for(Entry<Element, Object> entry : this.matching.entrySet())
			{
				Object uaMember = entry.getValue();
				if(uaMember instanceof UANode)
				{
					UANode UANode = (UANode) uaMember;				
					if(UANode.getNodeId() != null && UANode.getNodeId().equalsIgnoreCase(node.getNodeId()))
					{
						uaElement = (Class) entry.getKey();
						break;
					}
				}
			}

			if(uaElement == null)
			{
				return false;
			}
			else
			{
				this.nodeIdMap.put(node.getNodeId(), uaElement);
			}
		}
		
		boolean success = true;
		
		for(Reference ref: node.getReferences().getReference())
		{
			
			success &= updateOpcUaNodeReference(uaElement, ref);
		}
		
		return success;
	}
		
	private boolean updateOpcUaNodeReference(Class uaElement, Reference ref)
	{
		boolean success = true;
		
		String refTypeString = ref.getReferenceType();
		if(this.aliasTable.containsKey(refTypeString))
		{
			refTypeString = this.aliasTable.get(refTypeString);
		}

		String refValueString = ref.getValue();
		if(this.aliasTable.containsKey(refTypeString))
		{
			refValueString = this.aliasTable.get(refTypeString);
		}
		
		
		if(!this.nodeIdMap.containsKey(refTypeString) ||
			!this.nodeIdMap.containsKey(refValueString)	)
		{
			return false;
		}
		
		Element refType = this.nodeIdMap.get(refTypeString);
		
		Class refValue = (Class) this.nodeIdMap.get(refValueString);
		
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaReference  = nodeSetProfile.getOwnedStereotype("Reference");
		Stereotype uaReferenceType  = nodeSetProfile.getOwnedStereotype("UAReferenceType");
		
		Generalization reference;
		if(uaElement.getGenerals().size() > 0 &&
			uaElement.getGeneralization(refValue) != null)
		{
			reference = uaElement.getGeneralization(refValue);
			
		}
		else
		{
			reference = uaElement.createGeneralization(refValue);
			reference.applyStereotype(uaReference);	
		}
		reference.setValue(uaReference,"value", refValueString);
		reference.setValue(uaReference,"isForward", String.valueOf(ref.isIsForward()));
		reference.setValue(uaReference,"referenceType", refType.getStereotypeApplication(uaReferenceType));
		
		
		return success;
	}
}
