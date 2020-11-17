package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.transformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.AliasTable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.DataTypeDefinition;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.DataTypeField;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.DataTypePurpose;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.ListOfReferences;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.LocalizedText;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeIdAlias;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.Reference;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.ReleaseStatus;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.RolePermission;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.StructureTranslationType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.TranslationType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UADataType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAInstance;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAMethod;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAMethodArgument;
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
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.DataTypeDefinitionImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.DataTypeFieldImpl;
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
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAMethodArgumentImpl;
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

import at.ac.tuwien.auto.modelua.papyrus.opcua.console.OpcUaMessageConsole;
import at.ac.tuwien.auto.modelua.papyrus.opcua.libraries.OpcUaLibraryResources;
import at.ac.tuwien.auto.modelua.papyrus.opcua.nodeset.parser.NodeSetParser;
import at.ac.tuwien.auto.modelua.papyrus.opcua.preferences.PreferenceProvider;

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
	
	public boolean importPackage(String filepath) 
	{
		URI fileUri = URI.createFileURI(filepath);
		ResourceSet owner_resource = this.baseUmlModel.eResource().getResourceSet(); 
		Model modelimport = (Model) PackageUtil.loadPackage(fileUri, owner_resource);
				
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		if(modelimport.isProfileApplied(nodeSetProfile))
		{
			// Write Operations have to be executed inside a TransactionalEditingDomain
			// easiest way to do this is in a Command
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(this.baseUmlModel);
			
			// changes to diagrams shall be done inside commands
			ImportNodeSetCommand cmd = new ImportNodeSetCommand(domain);
			cmd.setImportModel(modelimport);
			cmd.setBaseModel(this.baseUmlModel);
			
			domain.getCommandStack().execute(cmd);
			
			return true;
		}
		
		return false;
	}
	
	public boolean writeToNodeSetFile() throws ParserConfigurationException
	{
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		
        IPath filePath = root.getLocation();
        URI uri = this.baseUmlModel.eResource().getURI();
		String path = uri.trimFileExtension().devicePath().substring("/resource/".length())+".xml";
		filePath=filePath.append(path);
		return writeToNodeSetFile(filePath.toOSString());
	}
	
	public boolean writeToNodeSetFile(String filepath) throws ParserConfigurationException
	{
		if(!filepath.endsWith(".xml"))
		{
			filepath = filepath+".xml";
		}
		OpcUaMessageConsole.debug("Writing NodeSet file to: "+filepath);
		return NodeSetParser.writeNodeSetFile(filepath, this.baseNodeset);
        
	}

	
	public void setNodeSetObject(UANodeSetType nodeset)
	{
		this.baseNodeset = nodeset;
	}
	
	public void setUmlModel (Model umlModel)
	{
		this.baseUmlModel = umlModel;
	}
		
	public boolean transformMember(Element object)
	{
		boolean return_val = false;
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(this.baseUmlModel);
		
		if(object instanceof Class)
		{			
			// changes to diagrams shall be done inside commands
			UpdateUMLClassCommand cmd = new UpdateUMLClassCommand(domain);
			cmd.setClass((Class) object);
			cmd.registerInstanceSynchHandler(this);
			
			domain.getCommandStack().execute(cmd);
			
			return_val = cmd.getCommandResult();
		}
		else if(object instanceof Generalization)
		{
			// changes to diagrams shall be done inside commands
			UpdateUMLGeneralizationCommand cmd = new UpdateUMLGeneralizationCommand(domain);
			cmd.setGeneralization((Generalization) object);
			cmd.registerInstanceSynchHandler(this);
			
			domain.getCommandStack().execute(cmd);
			
			return_val = cmd.getCommandResult();
		}
		else if(object instanceof Model)
		{
			Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
			Stereotype nodeSetType   = nodeSetProfile.getOwnedStereotype("UANodeSetType");
			
			DynamicEObjectImpl stereotype = (DynamicEObjectImpl) object.getStereotypeApplication(nodeSetType);
			if(stereotype != null)
			{
				return_val=transformUANodeSetType((Model) object, stereotype);
				if(return_val)
				{
					return_val &= transformModel((Model) object);
				}
			}
		}
		else if(object instanceof Package)
		{
			
			// changes to diagrams shall be done inside commands
			UpdateUMLPackageCommand cmd = new UpdateUMLPackageCommand(domain);
			cmd.setPackage((Package) object);
			cmd.registerInstanceSynchHandler(this);
			
			domain.getCommandStack().execute(cmd);
			
			return_val = cmd.getCommandResult();
		}
		
		return return_val;
	}
	
	private boolean transformModel(Model model) {
		boolean success = true;
		
		for(Element member : model.getOwnedElements())
		{
			if(!this.matching.containsKey(member))
			{
				success &= transformMember(member);
			}
		}
		
		return success;
	}

	protected boolean transformNamespace(Package namespace) {
		
		if(namespace.getURI() == null || namespace.getURI().length() == 0)
		{
			// no namespace Uir set
			return false;
		}
		
		// only modify namespace when its inside the same model
		if(this.baseUmlModel.equals(namespace.getModel()))
		{			
			namespace.setName(namespace.getURI());
		}
		
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype nodeSetType   = nodeSetProfile.getOwnedStereotype("UANodeSetType");
		
		if(this.baseNodeset.getNamespaceUris() == null)
		{
			UriTableImpl nsTable = new UriTableImpl();
			this.baseNodeset.setNamespaceUris(nsTable);
		}
		
		EcoreEList<DynamicEObjectImpl> nsList = (EcoreEList<DynamicEObjectImpl>) this.baseUmlModel.getValue(nodeSetType, "nameSpaceUris");
		this.baseNodeset.getNamespaceUris().getUri().clear();
		boolean already_added = false;
		
		for(DynamicEObjectImpl nsObject : nsList )
		{
			Package ns = (Package) nsObject.dynamicGet(0);
			
			if(namespace.equals(ns))
			{
				already_added = true;
			}
			
			if(ns.getURI() != null)
			{
				this.baseNodeset.getNamespaceUris().getUri().add(ns.getURI());
			}
		}
		
		if(!already_added)
		{
			Stereotype nameSpaceType   = nodeSetProfile.getOwnedStereotype("NameSpace");
			nsList.add((DynamicEObjectImpl) namespace.getStereotypeApplication(nameSpaceType));
		}
		
		if(!this.baseNodeset.getNamespaceUris().getUri().contains(namespace.getURI()))
		{
			this.baseNodeset.getNamespaceUris().getUri().add(namespace.getURI());
		}
		
		return true;
	}

	protected boolean transformClass(Class object)
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
				success=transformExtensionType(object);
				break;
			case "ModelTableEntry":
				success=transformModelTableEntry(object);
				break;
			case "NodeIdAlias":
				success=transformNodeIdAlias(object, stereotype);
				break;
			case "RolePermission":
				success=transformRolePermission(object);
				break;
			case "StructureTranslationType":
				success=transformStructureTranslationType(object, stereotype);
				break;
			case "TranslationType":
				success=transformTranslationType(object, stereotype);
				break;
			case "UADataType":
				success=transformUADataType(object);
				break;
			case "UAMethod":
				success=transformUAMethod(object);
				break;
			case "UAMethodArgument":
				success=transformUAMethodArgument(object);
				break;
			case "UAObject":
				success=transformUAObject(object, stereotype);
				break;
			case "UAObjectType":
				success=transformUAObjectType(object);
				break;
			case "UAReferenceType":
				success=transformUAReferenceType(object);
				break;
			case "UAVariable":
				success=transformUAVariable(object);
				break;
			case "UAVariableType":
				success=transformUAVariableType(object);
				break;
			case "UAView":
				success=transformUAView(object);
				break;
			case "ValueType":
				success=transformValueType(object);
				break;
			case "ValueType1":
				success=transformValueType1(object);
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
		}else if(toBeRemoved instanceof Reference)
		{
			success = deleteUAReference((Reference) toBeRemoved, (Generalization) obj);
		}
		
		if(success)
		{
			this.matching.remove(obj);
		}
		
		return success;
	}
	
	
	private boolean deleteUAReference(Reference reference, Generalization general) {
		EList<Element> sources = general.getSources();
		
		for(Element source : sources)
		{
			UANode node = (UANode) this.matching.get(source);
			node.getReferences().getReference().remove(reference);
		}
		
		return true;
	}

	private boolean transformValueType1(Class object) {
		// TODO: transform ValueType 1
		return false;
		
	}

	private boolean transformValueType(Class object) {
		// TODO: transform ValueType 
		return false;
	}

	private boolean transformUAView(Class object) {
		
		UAViewImpl uaView;
		if(this.matching.containsKey(object))
		{
			uaView = (UAViewImpl) this.matching.get(object);
		}
		else
		{
			uaView = new UAViewImpl();
			this.matching.put(object, uaView);
			if(object.getModel().equals(this.baseUmlModel))
			{
				this.baseNodeset.getUAView().add(uaView);
			}
		}
		
		boolean success = transformUAInstance(object);
		
		if(success)
		{
			Stereotype uaStereotype = getMatchingStereotype(uaView);
			

			if(object.hasValue(uaStereotype, "containsNoLoops"))
			{
				String stringToConvert = String.valueOf(object.getValue(uaStereotype, "containsNoLoops"));
				boolean convertedBoolean = Boolean.parseBoolean(stringToConvert);
				uaView.setContainsNoLoops(convertedBoolean);
			}
			else
			{
				uaView.unsetContainsNoLoops();
			}
			
			if(object.hasValue(uaStereotype, "eventNotifier"))
			{
				String stringToConvert = String.valueOf(object.getValue(uaStereotype, "eventNotifier"));
				short convertedShort = Short.parseShort(stringToConvert);
				uaView.setEventNotifier(convertedShort);
			}
			else
			{
				uaView.unsetEventNotifier();
			}
			
		}

		return true;
		
	}

	private boolean transformUAVariableType(Class object) {
		
		UAVariableTypeImpl uaVarType;
		if(this.matching.containsKey(object))
		{
			uaVarType = (UAVariableTypeImpl) this.matching.get(object);
		}
		else
		{
			uaVarType = new UAVariableTypeImpl();
			this.matching.put(object, uaVarType);
			if(object.getModel().equals(this.baseUmlModel))
			{
				this.baseNodeset.getUAVariableType().add(uaVarType);
			}
		}
		
		return transformUAType(object);
	}

	private boolean transformUAVariable(Class object) {
		
		UAVariableImpl uaVariable;
		if(this.matching.containsKey(object))
		{
			uaVariable = (UAVariableImpl) this.matching.get(object);
		}
		else
		{
			uaVariable = new UAVariableImpl();
			this.matching.put(object, uaVariable);
			if(object.getModel().equals(this.baseUmlModel))
			{
				this.baseNodeset.getUAVariable().add(uaVariable);
			}
		}
		
		boolean success = transformUAInstance(object);
		

		if(success)
		{
			Stereotype uaStereotype = getMatchingStereotype(uaVariable);
			
			if(object.hasValue(uaStereotype, "value"))
			{
				//TODO: add value
				Object value = object.getValue(uaStereotype, "value");

			}
			
			if(object.hasValue(uaStereotype, "translation"))
			{
				EList<DynamicEObjectImpl> translationList = (EList<DynamicEObjectImpl> )object.getValue(uaStereotype, "translation");
				uaVariable.getTranslation().clear();
				for(DynamicEObjectImpl translation : translationList)
				{					
					Class translationClass = getStereotypeBaseClass(translation, true);
					if(translationClass != null)
					{
						TranslationType tt = (TranslationType) this.matching.get(translationClass);
						uaVariable.getTranslation().add(tt);
						
						EList<Classifier> children = object.getNestedClassifiers();
						if(!children.contains(translationClass))
						{
							children.add(translationClass);
						}
					}
				}
			}
			
			if(object.hasValue(uaStereotype, "accessLevel"))
			{
				String stringToConvert = String.valueOf(object.getValue(uaStereotype, "accessLevel"));
				Long convertedLong = Long.parseLong(stringToConvert);
				uaVariable.setAccessLevel(convertedLong);
			}
			else
			{
				uaVariable.unsetAccessLevel();
			}
			
			if(object.hasValue(uaStereotype, "arrayDimensions"))
			{
				List<Object> arrayDimensions = (List<Object>) object.getValue(uaStereotype, "arrayDimensions");
				String convertedString ="";
				
				for(Object dimension : arrayDimensions)
				{
					convertedString = convertedString + "," + String.valueOf(dimension);
				}
								
				uaVariable.setArrayDimensions(convertedString.substring(1));
			}
			else
			{
				uaVariable.unsetArrayDimensions();
			}
			
			if(object.hasValue(uaStereotype, "dataType"))
			{
				DynamicEObjectImpl dataType = (DynamicEObjectImpl) object.getValue(uaStereotype, "dataType");

				Class parentClass = getStereotypeBaseClass(dataType, true);
				
				String nodeId = getNodeId(parentClass);	

				if(nodeId != null && nodeId.length() > 0)
				{					
					uaVariable.setDataType(nodeId);
				}

			}
			else
			{
				uaVariable.unsetDataType();;
			}
			
			if(object.hasValue(uaStereotype, "historizing"))
			{
				String stringToConvert = String.valueOf(object.getValue(uaStereotype, "historizing"));
				boolean convertedBoolean = Boolean.parseBoolean(stringToConvert);
				uaVariable.setHistorizing(convertedBoolean);

			}
			else
			{
				uaVariable.unsetHistorizing();
			}

			if(object.hasValue(uaStereotype, "minimumSamplingInterval"))
			{
				double intervall = (double ) object.getValue(uaStereotype, "minimumSamplingInterval");
				uaVariable.setMinimumSamplingInterval(intervall);

			}

			else
			{
				uaVariable.unsetMinimumSamplingInterval();
			}
			
			
			if(object.hasValue(uaStereotype, "userAccessLevel"))
			{
				String stringToConvert = String.valueOf(object.getValue(uaStereotype, "userAccessLevel"));
				Long convertedLong = Long.parseLong(stringToConvert);
				uaVariable.setUserAccessLevel(convertedLong);
			}
			else
			{
				uaVariable.unsetUserAccessLevel();
			}
			
			if(object.hasValue(uaStereotype, "valueRank"))
			{
				String stringToConvert = String.valueOf(object.getValue(uaStereotype, "valueRank"));
				int convertedInt = Integer.parseInt(stringToConvert);
				uaVariable.setValueRank(convertedInt);

			}
			else
			{
				uaVariable.unsetValueRank();
			}
		}
		
		return success;
	}

	private boolean transformUAType(Class object) {
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
				
		return transformUANode(object);
	}

	private boolean transformUAReferenceType(Class object) {
		
		UAReferenceTypeImpl uaRefType;
		if(this.matching.containsKey(object))
		{
			uaRefType = (UAReferenceTypeImpl) this.matching.get(object);
		}
		else
		{
			uaRefType = new UAReferenceTypeImpl();
			this.matching.put(object, uaRefType);
			if(object.getModel().equals(this.baseUmlModel))
			{
				this.baseNodeset.getUAReferenceType().add(uaRefType);
			}
		}
		
		boolean success = transformUAType(object);
		
		if(success)
		{
			Stereotype uaStereotype = getMatchingStereotype(uaRefType);
			if(object.hasValue(uaStereotype, "inverseName"))
			{
				EList<String> inverseNameList = (EList<String>) object.getValue(uaStereotype, "inverseName");
				uaRefType.getInverseName().clear();
				
				for(String inverseName : inverseNameList)
				{
					LocalizedTextImpl lt = new LocalizedTextImpl();
					lt.setValue(inverseName);
					uaRefType.getInverseName().add(lt);
				}
			}
			
			if(object.hasValue(uaStereotype, "symmetric"))
			{
				boolean symmetric = (boolean) object.getValue(uaStereotype, "symmetric");
				uaRefType.setSymmetric(symmetric);
			}
		}


		return success;
	}

	private boolean transformUAObjectType(Class object) {
		
		UAObjectTypeImpl uaObjType;
		if(this.matching.containsKey(object))
		{
			uaObjType = (UAObjectTypeImpl) this.matching.get(object);
		}
		else
		{
			uaObjType = new UAObjectTypeImpl();
			this.matching.put(object, uaObjType);
			if(object.getModel().equals(this.baseUmlModel))
			{
				this.baseNodeset.getUAObjectType().add(uaObjType);
			}
		}
		
		boolean success = transformUAType(object);
		
		return success;
	}

	private boolean transformUAObject(Class object,  DynamicEObjectImpl stereotype) {
		UAObjectImpl uaObject;
		if(this.matching.containsKey(object))
		{
			uaObject = (UAObjectImpl) this.matching.get(object);
		}
		else
		{
			uaObject = new UAObjectImpl();
			this.matching.put(object, uaObject);
			if(object.getModel().equals(this.baseUmlModel))
			{
				this.baseNodeset.getUAObject().add(uaObject);
			}
		}
		
		boolean success = transformUAInstance(object);
		
		if(success)
		{
			Stereotype uaStereotype = getMatchingStereotype(uaObject);
			
			if(object.hasValue(uaStereotype, "eventNotifier"))
			{
				String stringToConvert = String.valueOf(object.getValue(uaStereotype, "eventNotifier"));
				short convertedShort = Short.parseShort(stringToConvert);
				uaObject.setEventNotifier(convertedShort);
			}
			else
			{
				uaObject.unsetEventNotifier();
			}
		}
			
		return success;
	}

	private boolean transformUANodeSetType(Model object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype nodeSetType   = nodeSetProfile.getOwnedStereotype("UANodeSetType");
		
		if(this.baseUmlModel.hasValue(nodeSetType, "nameSpaceUris"))
		{			
			EcoreEList<DynamicEObjectImpl> nsList = (EcoreEList<DynamicEObjectImpl>) this.baseUmlModel.getValue(nodeSetType, "nameSpaceUris");
			
			for(DynamicEObjectImpl nsObject : nsList )
			{
				Package ns = (Package) nsObject.dynamicGet(0);
				
				if(ns.getURI() != null)
				{
					this.baseNodeset.getNamespaceUris().getUri().add(ns.getURI());
				}
			}
		}
		
		if(this.baseUmlModel.hasValue(nodeSetType, "serverUris"))
		{
			EcoreEList<String> serverUriList = (EcoreEList<String>) this.baseUmlModel.getValue(nodeSetType, "serverUris");
			
			if(this.baseNodeset.getServerUris() == null)
			{
				this.baseNodeset.setServerUris(new UriTableImpl());
			}
			
			this.baseNodeset.getServerUris().getUri().clear();
			
			for(String serverUri : serverUriList)
			{
				this.baseNodeset.getServerUris().getUri().add(serverUri);
			}
		}		
		
//		if(object.getValue(nodeSetType, "models") != null)
//		{
//				EDataTypeUniqueEList<String> models = (EDataTypeUniqueEList<String>) object.getValue(nodeSetType, "models");
//		}
//		if(object.getValue(nodeSetType, "aliases") != null)
//		{
//				EDataTypeUniqueEList<String> aliases = (EDataTypeUniqueEList<String>) object.getValue(nodeSetType, "aliases");
//		}
//		
//		if(object.getValue(nodeSetType, "extensions") != null)
//		{
//			EDataTypeUniqueEList<String> extensions = (EDataTypeUniqueEList<String>) object.getValue(nodeSetType, "extensions");
//		}
		
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			
			if(name.equalsIgnoreCase("models"))
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
							transformClass((Class) baseClass);
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
		}
		
		return true;
		
	}

	private boolean transformUANode(Class object) {
		
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

		Stereotype uaStereotype = getMatchingStereotype(uanode);

		if(object.hasValue(uaStereotype, "browseName"))
		{
			String browseName = (String) object.getValue(uaStereotype, "browseName");
			object.setName(browseName);
			
			Package namespace = object.getNearestPackage();
			if(namespace != null && namespace.getURI() != null && namespace.getURI().length() > 0)
			{
				if(this.baseNodeset.getNamespaceUris() == null)
				{
					this.baseNodeset.setNamespaceUris(new UriTableImpl());
				}
				
				EList<String> namespaces = this.baseNodeset.getNamespaceUris().getUri();
				
				int namespaceId = namespaces.indexOf(namespace.getURI());
				namespaceId++; // arrays start at 0
				browseName = String.valueOf(namespaceId) + ":" +browseName;
			}
			
			uanode.setBrowseName( browseName);		
		}
		
		if(object.hasValue(uaStereotype, "nodeId"))
		{
			String nodeId = getNodeId(object);	

			if(nodeId != null && nodeId.length() > 0)
			{					
				uanode.setNodeId(nodeId);
			}
			this.nodeIdMap.put(nodeId, object);
		}
		else
		{
			return false;
		}

		if(object.hasValue(uaStereotype, "displayName"))
		{
			EDataTypeUniqueEList<String> displayName = (EDataTypeUniqueEList<String>) object.getValue(uaStereotype, "displayName");
			uanode.getDisplayName().clear();
			for(String dnEntry : displayName)
			{
				LocalizedTextImpl lt = new LocalizedTextImpl();
				lt.setValue(dnEntry);
				uanode.getDisplayName().add(lt);
			}
		}
		else
		{
			uanode.getDisplayName().clear();
		}
		
		if(object.hasValue(uaStereotype, "description"))
		{
			EDataTypeUniqueEList<String> description = (EDataTypeUniqueEList<String>) object.getValue(uaStereotype, "description");
			uanode.getDescription().clear();
			for(String dEntry : description)
			{
				LocalizedTextImpl lt = new LocalizedTextImpl();
				lt.setValue(dEntry);
				uanode.getDescription().add(lt);
			}
		}
		else
		{
			uanode.getDescription().clear();
		}
		
		if(object.hasValue(uaStereotype, "category"))
		{
			EDataTypeUniqueEList<String> category = (EDataTypeUniqueEList<String>) object.getValue(uaStereotype, "category");
			uanode.getCategory().clear();
			uanode.getCategory().addAll(category);
		}
		else
		{
			uanode.getCategory().clear();
		}
		
		if(object.hasValue(uaStereotype, "documentation"))
		{
			String documentation = (String) object.getValue(uaStereotype, "documentation");
			uanode.setDocumentation( documentation);
		}
		else
		{
			uanode.setDocumentation("");
		}
		
		
		if(object.hasValue(uaStereotype, "rolePermissions"))
		{

			EList<Classifier> classifierList = object.getNestedClassifiers();
			EcoreEList<DynamicEObjectImpl> rolePermissions = (EcoreEList<DynamicEObjectImpl>) object.getValue(uaStereotype, "rolePermissions");
			
			for(DynamicEObjectImpl rolePermission : rolePermissions)
			{
				Class rolePermissionsClass = getStereotypeBaseClass(rolePermission, true);
				
				
				if(!classifierList.contains(rolePermissionsClass))
				{
					classifierList.add(rolePermissionsClass);
				}
				
				if(uanode.getRolePermissions() == null)
				{
					uanode.setRolePermissions(new ListOfRolePermissionsImpl());
				}
				
				if(this.matching.containsKey(rolePermissionsClass))
				{
					RolePermission uaRolePermission = (RolePermission) this.matching.get(rolePermissionsClass);
					uanode.getRolePermissions().getRolePermission().add(uaRolePermission);
				}
			}
		}
		else 
		{
			if(uanode.getRolePermissions() == null)
			{
				uanode.setRolePermissions(new ListOfRolePermissionsImpl());
			}
			else
			{				
				uanode.getRolePermissions().getRolePermission().clear();
			}
		}


		
		if(object.hasValue(uaStereotype, "accessRestrictions"))
		{
			Object temp = object.getValue(uaStereotype, "accessRestrictions");
			String stringToConvert = String.valueOf(temp);
			short convertedShort = Short.parseShort(stringToConvert);
			uanode.setAccessRestrictions(convertedShort);
		}
		else
		{
			uanode.unsetAccessRestrictions();
		}
		
		EnumerationLiteral releaseStatus = (EnumerationLiteral) object.getValue(uaStereotype, "releaseStatus");
		String value = releaseStatus.getLabel();
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
		default:
			uanode.unsetReleaseStatus();
		}
		

		if(object.hasValue(uaStereotype, "symbolicName"))
		{
			EDataTypeUniqueEList<String> symbolicName = (EDataTypeUniqueEList<String>) object.getValue(uaStereotype, "symbolicName");
			uanode.setSymbolicName(symbolicName);
		}
		else
		{
			if(uanode.getSymbolicName() != null)
			{				
				uanode.getSymbolicName().clear();
			}
		}
		
		if(object.hasValue(uaStereotype, "userWriteMask"))
		{
			Object temp = object.getValue(uaStereotype, "userWriteMask");
			String stringToConvert = String.valueOf(temp);
			long convertedLong = Long.parseLong(stringToConvert);
			uanode.setUserWriteMask(convertedLong);
		}
		else
		{
			uanode.unsetUserWriteMask();
		}
		
		if(object.hasValue(uaStereotype, "writeMask"))
		{
			Object temp = object.getValue(uaStereotype, "writeMask");
			String stringToConvert = String.valueOf(temp);
			long convertedLong = Long.parseLong(stringToConvert);
			uanode.setWriteMask(convertedLong);
		}
		else
		{
			uanode.unsetWriteMask();
		}
		
		ListOfReferences listOfReferences = uanode.getReferences();
		if(listOfReferences == null)
		{
			listOfReferences = new ListOfReferencesImpl();
			uanode.setReferences(listOfReferences);
		}
		
		listOfReferences.getReference().clear();
		
		for(Generalization reference :object.getGeneralizations())
		{
			if(! this.matching.containsKey(reference))
			{
				transformGeneralization(reference);
			}
			listOfReferences.getReference().add((Reference) this.matching.get(reference));

		}

		return true;
	}



	private boolean transformUAMethod(Class object) {
		
		UAMethodImpl uaMethod;
		if(this.matching.containsKey(object))
		{
			uaMethod = (UAMethodImpl) this.matching.get(object);
		}
		else
		{
			uaMethod = new UAMethodImpl();
			this.matching.put(object, uaMethod);
			if(object.getModel().equals(this.baseUmlModel))
			{				
				this.baseNodeset.getUAMethod().add(uaMethod);
			}
		}
		
		boolean success = transformUAInstance(object);
		
		if(success)
		{
			Stereotype uaStereotype = getMatchingStereotype(uaMethod);

			if(object.hasValue(uaStereotype, "argumentDescription"))
			{
				EcoreEList<DynamicEObjectImpl> argumentDescriptionList = (EcoreEList<DynamicEObjectImpl>) object.getValue(uaStereotype, "argumentDescription");
				for(DynamicEObjectImpl argumentDescriptionEntry : argumentDescriptionList)
				{
					Class argumentDescription = getStereotypeBaseClass(argumentDescriptionEntry, true);
					if(argumentDescription != null)
					{
						UAMethodArgument uaMethArg = (UAMethodArgument) this.matching.get(argumentDescription);
						if(!uaMethod.getArgumentDescription().contains(uaMethArg))
						{						
							uaMethod.getArgumentDescription().add(uaMethArg);
						}
						
						EList<Classifier> children = object.getNestedClassifiers();
						if(!children.contains(argumentDescription))
						{
							children.add(argumentDescription);
						}
					
					}
				}		
			}
			else
			{
				uaMethod.getArgumentDescription().clear();
			}
			
			if(object.hasValue(uaStereotype, "executable"))
			{
				boolean executable = (boolean) object.getValue(uaStereotype, "executable");
				uaMethod.setExecutable(executable);
			}
			else
			{
				uaMethod.unsetExecutable();
			}
			
			if(object.hasValue(uaStereotype, "methodDeclarationId"))
			{
				DynamicEObjectImpl methodDeclarationId = (DynamicEObjectImpl) object.getValue(uaStereotype, "methodDeclarationId");

				Class methodDeclarationClass = getStereotypeBaseClass(methodDeclarationId, true);
				
				String nodeId = getNodeId(methodDeclarationClass);	

				if(nodeId != null && nodeId.length() > 0)
				{					
					uaMethod.setMethodDeclarationId(nodeId);
				}
			}
			else
			{
				uaMethod.setMethodDeclarationId("");
			}
			
			if(object.hasValue(uaStereotype, "userExecutable"))
			{
				boolean userExecutable = (boolean) object.getValue(uaStereotype, "executable");
				uaMethod.setUserExecutable(userExecutable);
			}
			else
			{
				uaMethod.unsetUserExecutable();
			}
			
			return success;
		}

		

		return true;
	}

	private boolean transformUAMethodArgument(Class object) {
	
		UAMethodArgumentImpl uaMethArg;
		
		if(this.matching.containsKey(object))
		{
			uaMethArg = (UAMethodArgumentImpl) this.matching.get(object);
		}
		else
		{
			uaMethArg = new UAMethodArgumentImpl();
			this.matching.put(object, uaMethArg);
		}
		
		Stereotype uaStereotype = getMatchingStereotype(uaMethArg);

		if(object.hasValue(uaStereotype, "name"))
		{
			String name = String.valueOf(object.getValue(uaStereotype, "name"));
			uaMethArg.setName(name);
		}
		else
		{
			uaMethArg.setName("");
		}
		
		if(object.hasValue(uaStereotype, "description"))
		{
			EDataTypeUniqueEList<String> descriptionList = (EDataTypeUniqueEList<String>) object.getValue(uaStereotype, "description");
			uaMethArg.getDescription().clear();
			
			for(String description : descriptionList)
			{
				LocalizedTextImpl lt = new LocalizedTextImpl();
				lt.setValue(description);
				uaMethArg.getDescription().add(lt);
			}
		}
		else
		{
			uaMethArg.getDescription().clear();
		}
		
		return false;
	}
	
	private boolean transformUAInstance(Class object) {
		
		UAInstanceImpl uaInstance;
		if(this.matching.containsKey(object))
		{
			uaInstance = (UAInstanceImpl) this.matching.get(object);
		}
		else
		{
			uaInstance = new UAInstanceImpl();
			this.matching.put(object, uaInstance);
		}
				
		boolean success = transformUANode(object);
		
		Stereotype uaStereotype = getMatchingStereotype(uaInstance);
		if(object.hasValue(uaStereotype, "parentNodeId"))
		{
			DynamicEObjectImpl parentNode = (DynamicEObjectImpl) object.getValue(uaStereotype, "parentNodeId");

			Class parentClass = getStereotypeBaseClass(parentNode, true);
			
			String nodeId = getNodeId(parentClass);	

			if(nodeId != null && nodeId.length() > 0)
			{					
				uaInstance.setParentNodeId(nodeId);
			}
		}
		else
		{
			uaInstance.setParentNodeId("");
		}
			
		return success;
	}

	private boolean transformUADataType(Class object) {

		UADataTypeImpl uaDataType;
		if(this.matching.containsKey(object))
		{
			uaDataType = (UADataTypeImpl) this.matching.get(object);
		}
		else
		{
			uaDataType = new UADataTypeImpl();
			this.matching.put(object, uaDataType);
			if(object.getModel().equals(this.baseUmlModel))
			{				
				this.baseNodeset.getUADataType().add(uaDataType);
			}
		}
		boolean success = transformUAType(object);
		
		if(success)
		{
			Stereotype dataTypeSter = getMatchingStereotype(uaDataType);
			
			if(object.hasValue(dataTypeSter, "purpose"))
			{
				EnumerationLiteral lit = (EnumerationLiteral) object.getValue(dataTypeSter, "purpose");
				String value = lit.toString();
				switch(value)
				{
				case "Normal":
					uaDataType.setPurpose(DataTypePurpose.NORMAL);
					break;
				case "CodeGenerator":
					uaDataType.setPurpose(DataTypePurpose.CODE_GENERATOR);
					break;
				case "ServicesOnly":
					uaDataType.setPurpose(DataTypePurpose.SERVICES_ONLY);
					break;
				}
			}
			else
			{
				uaDataType.unsetPurpose();
			}
			
			
			if(object.hasValue(dataTypeSter, "definition"))
			{
				DynamicEObjectImpl definition = (DynamicEObjectImpl)object.getValue(dataTypeSter, "definition");
				Class dataTypeDefinition = getStereotypeBaseClass(definition, true);
				if(dataTypeDefinition != null)
				{
					DataTypeDefinition dtd = (DataTypeDefinition) this.matching.get(dataTypeDefinition);
					uaDataType.setDefinition(dtd);
					
					EList<Classifier> children = object.getNestedClassifiers();
					if(!children.contains(definition))
					{
						children.add(dataTypeDefinition);
					}
				}
			}
			else
			{
				uaDataType.setDefinition(null);
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
								transformClass((Class) baseClass);
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

	private boolean transformRolePermission(Class object) {
		
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

		Stereotype uaStereotype = getMatchingStereotype(rp);
		
		if(object.hasValue( uaStereotype, "value"))
		{
			DynamicEObjectImpl dataType = (DynamicEObjectImpl) object.getValue(uaStereotype, "value");

			Class parentClass = getStereotypeBaseClass(dataType, true);
			
			String nodeId = getNodeId(parentClass);	

			if(nodeId != null && nodeId.length() > 0)
			{					
				rp.setValue(nodeId);
			}
		}
		else
		{
			rp.setValue("");
		}
		
		if(object.hasValue( uaStereotype, "permissions"))
		{
			String stringToConvert = String.valueOf(object.getValue( uaStereotype, "permissions"));
	        Long convertedLong = Long.parseLong(stringToConvert);
			rp.setPermissions(convertedLong);
		}
		else
		{
			rp.unsetPermissions();
		}
				
		return true;
		
	}

	private boolean transformModelTableEntry(Class object) {
		//TODO: Implement Model Table transformation 
		
		return false;
	}


	private boolean transformExtensionType(Class object) {
		//TODO: Implement Extension Type transformation 

		return false;
	}
	
	private boolean transformDataTypeField(Class object,  DynamicEObjectImpl stereotype) {
	
		DataTypeFieldImpl dtf;
		if( this.matching.containsKey(object))
		{
			dtf = (DataTypeFieldImpl) this.matching.get(object);

		}
		else
		{
			dtf = new DataTypeFieldImpl();
			this.matching.put(object, dtf);
		}
		Stereotype sterDTF = getMatchingStereotype(dtf);
		
		if(object.getValue(sterDTF, "displayName") !=null)
		{			

			EDataTypeUniqueEList<String> displayNameList = (EDataTypeUniqueEList<String>) object.getValue(sterDTF, "displayName");
			dtf.getDisplayName().clear();
			
			for(String displayName : displayNameList)
			{
				LocalizedTextImpl lt = new LocalizedTextImpl();
				lt.setValue(displayName);
				dtf.getDisplayName().add(lt);
			}
		}
		else
		{
			dtf.getDisplayName().clear();
		}
		
		if(object.getValue(sterDTF, "description") !=null)
		{			

			EDataTypeUniqueEList<String> descriptionList = (EDataTypeUniqueEList<String>) object.getValue(sterDTF, "description");
			dtf.getDescription().clear();
			
			for(String description : descriptionList)
			{
				LocalizedTextImpl lt = new LocalizedTextImpl();
				lt.setValue(description);
				dtf.getDescription().add(lt);
			}
		}
		else
		{
			dtf.getDescription().clear();
		}
		
		if(object.getValue(sterDTF, "abstractDataType") !=null)
		{			
			DynamicEObjectImpl abstractDataType = (DynamicEObjectImpl) object.getValue(sterDTF, "abstractDataType");
			
			Class umlUaNode = getStereotypeBaseClass(abstractDataType, true);
			
			if(!this.matching.containsKey(umlUaNode))
			{
				transformClass(umlUaNode);
			}
			
			if(umlUaNode != null)
			{
				String nodeId = getNodeId(umlUaNode);	

				if(nodeId != null && nodeId.length() > 0)
				{					
					dtf.setAbstractDataType(nodeId);
				}
				
			}
		}
		else
		{
			dtf.setAbstractDataType("");
		}
		
		if(object.getValue(sterDTF, "arrayDimensions") !=null)
		{		
			List<Object> arrayDimensions = (List<Object>) object.getValue(sterDTF, "arrayDimensions");
			String convertedString ="";
			
			for(Object dimension : arrayDimensions)
			{
				convertedString = convertedString + "," + String.valueOf(dimension);
			}
							
			dtf.setArrayDimensions(convertedString.substring(1));
			
		}
		else
		{
			dtf.unsetArrayDimensions();
		}
		
		if(object.getValue(sterDTF, "dataType") !=null)
		{			
			
			DynamicEObjectImpl abstractDataType = (DynamicEObjectImpl) object.getValue(sterDTF, "dataType");
			
			Class umlUaNode = getStereotypeBaseClass(abstractDataType, true);
			
			if(!this.matching.containsKey(umlUaNode))
			{
				transformClass(umlUaNode);
			}
			
			if(umlUaNode != null)
			{
				Stereotype uaStereotype = getMatchingStereotype(this.matching.get(umlUaNode));
				
				if(umlUaNode.hasValue(uaStereotype, "nodeId"))
				{
					String nodeId = getNodeId(umlUaNode);			
					if(nodeId != null && nodeId.length() > 0)
					{					
						dtf.setDataType(nodeId);
					}
					
				}
				
			}
		}
		else
		{
			dtf.unsetDataType();
		}
		
		if(object.getValue(sterDTF, "isOptional") !=null)
		{			
			String stringToConvert = String.valueOf(object.getValue(sterDTF, "isOptional"));
			boolean convertedBoolean = Boolean.parseBoolean(stringToConvert);
			dtf.setIsOptional(convertedBoolean);
		}
		else
		{
			dtf.unsetIsOptional();
		}

		if(object.getValue(sterDTF, "maxStringLength") !=null)
		{			
			String stringToConvert = String.valueOf(object.getValue(sterDTF, "maxStringLength"));
			long convertedLong = Long.parseLong(stringToConvert);
			dtf.setMaxStringLength(convertedLong);
		}
		else
		{
			dtf.unsetMaxStringLength();
		}
		
		if(object.getValue(sterDTF, "name") !=null)
		{			
			String stringName = String.valueOf(object.getValue(sterDTF, "name"));
			dtf.setName(stringName);
		}
		else
		{
			dtf.setName("");
		}
		
		if(object.getValue(sterDTF, "symbolicName") !=null)
		{			

			EDataTypeUniqueEList<String> symbolicNameList = (EDataTypeUniqueEList<String>) object.getValue(sterDTF, "symbolicName");
			if(dtf.getSymbolicName() == null)
			{
				dtf.setSymbolicName(new ArrayList<String>());
			}
			dtf.getSymbolicName().clear();
			
			for(String symbolicName : symbolicNameList)
			{
				dtf.getSymbolicName().add(symbolicName);
			}
		}
		else
		{
			dtf.getSymbolicName().clear();
		}
		
		if(object.getValue(sterDTF, "value") !=null)
		{			
			String stringToConvert = String.valueOf(object.getValue(sterDTF, "value"));
			int convertedInt = Integer.parseInt(stringToConvert);
			dtf.setValue(convertedInt);
		}
		else
		{
			dtf.unsetValue();
		}
		
		if(object.getValue(sterDTF, "valueRank") !=null)
		{			
			String stringToConvert = String.valueOf(object.getValue(sterDTF, "valueRank"));
			int convertedInt = Integer.parseInt(stringToConvert);
			dtf.setValueRank(convertedInt);
		}
		else
		{
			dtf.unsetValueRank();
		}
		
		return true;
		
	}

	private boolean transformDataTypeDefinition(Class object,  DynamicEObjectImpl stereotype) {
			
		DataTypeDefinitionImpl dtd;
		if( this.matching.containsKey(object))
		{
			dtd = (DataTypeDefinitionImpl) this.matching.get(object);

		}
		else
		{
			dtd = new DataTypeDefinitionImpl();
			this.matching.put(object, dtd);
		}
		Stereotype sterDTD = getMatchingStereotype(dtd);
		
		if(object.getValue(sterDTD, "field") !=null)
		{			
			EcoreEList<DynamicEObjectImpl> field = (EcoreEList<DynamicEObjectImpl>) object.getValue(sterDTD, "field");
			for(DynamicEObjectImpl fieldEntry : field)
			{
				Class dataTypeField = getStereotypeBaseClass(fieldEntry, true);
				if(dataTypeField != null)
				{
					DataTypeField dtf = (DataTypeField) this.matching.get(dataTypeField);
					if(!dtd.getField().contains(dtf))
					{						
						dtd.getField().add(dtf);
					}
					
					EList<Classifier> children = object.getNestedClassifiers();
					if(!children.contains(dataTypeField))
					{
						children.add(dataTypeField);
					}
				
				}
			}			
		}
		else
		{
			dtd.getField().clear();
		}
		
		if(object.getValue(sterDTD, "isOptionSet") !=null)
		{			
			String stringToConvert = String.valueOf(object.getValue(sterDTD, "isOptionSet"));
			boolean convertedBoolean = Boolean.parseBoolean(stringToConvert);
			dtd.setIsOptionSet(convertedBoolean);
		}
		else
		{
			dtd.unsetIsOptionSet();
		}

		if(object.getValue(sterDTD, "isUnion") !=null)
		{			
			String stringToConvert = String.valueOf(object.getValue(sterDTD, "isUnion"));
			boolean convertedBoolean = Boolean.parseBoolean(stringToConvert);
			dtd.setIsUnion(convertedBoolean);
		}
		else
		{
			dtd.unsetIsUnion();
		}
		
		if(object.getValue(sterDTD, "name") !=null)
		{			
			String stringToConvert = String.valueOf(object.getValue(sterDTD, "name"));
			dtd.setName(stringToConvert);
		}
		else
		{
			dtd.setName("");
		}
		
		if(object.getValue(sterDTD, "symbolicName") !=null)
		{			

			EDataTypeUniqueEList<String> symbolicNameList = (EDataTypeUniqueEList<String>) object.getValue(sterDTD, "symbolicName");
			dtd.getSymbolicName().clear();
			
			for(String symbolicName : symbolicNameList)
			{
				dtd.getSymbolicName().add(symbolicName);
			}
			
		}
		else
		{
			dtd.unsetSymbolicName();
		}
		
		return true;
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
								transformClass((Class) baseClass);
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
	
	protected boolean transformGeneralization(Generalization general) {

		if(general.getSources().size() != 1 || general.getTargets().size() != 1)
		{
			// only single source/target is supported
			return false;
		}
		
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("Reference");
		
		ReferenceImpl uaReference;
		
		if(this.matching.containsKey(general))
		{
			uaReference = (ReferenceImpl) this.matching.get(general);
		}
		else
		{
			uaReference = new ReferenceImpl();
			this.matching.put(general, uaReference);
			if(general.hasValue(uaStereoType,"isForward"))
			{
				uaReference.setIsForward((boolean) general.getValue(uaStereoType,"isForward"));
			}
		}
		
		Class target = (Class) general.getTargets().get(0);
		Class source = (Class) general.getSources().get(0);

		String nodeId = getNodeId(target);
		uaReference.setValue(nodeId);
		
		boolean isForward = uaReference.isIsForward();
		boolean isForwardOld = isForward;
		//if(general.hasValue(uaStereoType,"isForward"))
		{
			isForward =(boolean) general.getValue(uaStereoType,"isForward");
		}
//		isForward =(boolean) general.getValue(uaStereoType,"isForward");
		
		boolean directionChanged = isForwardOld ^ isForward;
		uaReference.setIsForward(isForward);

		if(general.hasValue(uaStereoType,"referenceType"))
		{
			Stereotype uaReferenceType  = nodeSetProfile.getOwnedStereotype("UAReferenceType");
			
			DynamicEObjectImpl referenceTypeSterAppl = (DynamicEObjectImpl) general.getValue(uaStereoType,"referenceType");
			Class referenceType = getStereotypeBaseClass(referenceTypeSterAppl, true);
			
			String referenceTypeNode = getNodeId(referenceType);
			uaReference.setReferenceType(referenceTypeNode);
			
			boolean isHierachicalReference = (boolean) referenceType.getValue(uaReferenceType, "isHierachical");
			
			Package sourcePackage = source.getNearestPackage();
			String sourceNs = sourcePackage.getURI();
			if(sourceNs == null)
			{
				sourceNs = "";
			}
			
			Package targetPackage = target.getNearestPackage();
			String targetNs = targetPackage.getURI();
			if(targetNs == null)
			{
				targetNs = "";
			}
			
			general.setValue(uaStereoType,"referenceType_symmetric", referenceType.getValue(uaReferenceType, "symmetric"));
			general.setValue(uaStereoType,"referenceType_browseName", referenceType.getValue(uaReferenceType, "browseName"));
			general.setValue(uaStereoType,"referenceType_isHierachical", isHierachicalReference);
			
			if(isHierachicalReference && sourceNs.equals(targetNs))
			{
				//directionChanged = false;
				if(isForward)
				{
					if(directionChanged || target.getNestedClassifiers().contains(source))
					{
						Element owner = target.getOwner();
						if(owner instanceof Class)
						{
							Class ownerClass = (Class)owner;
							ownerClass.getNestedClassifiers().add(source);
						}
						else
						{
							// owner is package of Model
							Package ownerPackage = (Package) owner;
							target.getNestedClassifiers().remove(source);
							source.setPackage(ownerPackage);
						}
						source.getNestedClassifiers().add(target);
					}
					else
					{
						EList<Classifier> children = source.getNestedClassifiers();
						if(!children.contains(target))
						{
							children.add(target);
						}
					}
				}
				else
				{
					if(directionChanged || source.getNestedClassifiers().contains(target))
					{
						Element owner = source.getOwner();
						if(owner instanceof Class)
						{
							Class ownerClass = (Class)owner;
							ownerClass.getNestedClassifiers().add(target);
						}
						else
						{
							// owner is package of Model
							Package ownerPackage = (Package) owner;
							source.getNestedClassifiers().remove(target);
							target.setPackage(ownerPackage);
						}
						target.getNestedClassifiers().add(source);
					}
					else
					{						
						EList<Classifier> children = target.getNestedClassifiers();
						
						if(!children.contains(source))
						{
							children.add(source);
						}
					}
				}
			}
			
			if(source.isStereotypeApplied(uaReferenceType) && target.isStereotypeApplied(uaReferenceType))
			{
				if(isForward)
				{
					if(this.baseUmlModel.equals(target.getModel()))
					{
						boolean isHierachicalReferenceType = (boolean) source.getValue(uaReferenceType, "isHierachical");
						target.setValue(uaReferenceType, "isHierachical", isHierachicalReferenceType);
					}
				}
				else
				{
					if(this.baseUmlModel.equals(source.getModel()))
					{
						boolean isHierachicalReferenceType = (boolean) target.getValue(uaReferenceType, "isHierachical");
						source.setValue(uaReferenceType, "isHierachical", isHierachicalReferenceType);
					}
				}
				
			}
			
		}
		
		if(!this.matching.containsKey(source))
		{
			transformClass((Class) source);
		}
		
		UANode src = (UANode) this.matching.get(source);
		ListOfReferences refList = src.getReferences();
		if(refList == null)
		{
			src.setReferences(new ListOfReferencesImpl());
		}
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
    	ArrayList<UANode> rolePermissionNodes = new ArrayList<UANode>();
    	ArrayList<UAInstance> uaInstanceReferences = new ArrayList<UAInstance>();
    	ArrayList<UADataType> dataTypeDefinitions = new ArrayList<UADataType>();
    	ArrayList<UAReferenceType> referenceTypes = new ArrayList<UAReferenceType>();
    	
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
    			
    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    			{
    				rolePermissionNodes.add(t);
    			}
    			
    			success &= updateOpcUAObjectType(t, nodesToAdd, nodesToDelete);
    			if(!success)
    			{
    				success &= updateOpcUAObjectType(t, nodesToAdd, nodesToDelete);
    				break;
    			}
    		}
    		
    		// Important first remove old elements than add new ones
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
    			
    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    			{
    				rolePermissionNodes.add(t);
    			}
    			
    			success &= updateOpcUAVariableType(t, nodesToAdd, nodesToDelete);
    			if(!success)
    			{
    				success &= updateOpcUAVariableType(t, nodesToAdd, nodesToDelete);
    				break;
    			}
    		}
    		
    		// Important first remove old elements than add new ones
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
    			
    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    			{
    				rolePermissionNodes.add(t);
    			}
    			
    			if(t.getDefinition() != null )
    			{
    				dataTypeDefinitions.add(t);
    			}
    			
    			success &= updateOpcUADataType(t, nodesToAdd, nodesToDelete);
    			if(!success)
    			{
    				success &= updateOpcUADataType(t, nodesToAdd, nodesToDelete);
    				break;
    			}
    		}
    		
    		// Important first remove old elements than add new ones
    		this.baseNodeset.getUADataType().removeAll(nodesToDelete);
    		this.baseNodeset.getUADataType().addAll(nodesToAdd);
    	}
		
    	if(nodeset.getUAReferenceType() != null)
    	{    		
    		// adding and removing needs to be done via list otherwise 
    		// ConcurrentModificationException
    		EList<UAReferenceType> uaReferenceTypes = nodeset.getUAReferenceType();
    		List<UAReferenceType> nodesToAdd = new ArrayList<UAReferenceType>();
    		List<UAReferenceType> nodesToDelete = new ArrayList<UAReferenceType>();
    		
    		for(UAReferenceType t : uaReferenceTypes)
    		{
    			referenceTypes.add(t);
    			
    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    			{
    				rolePermissionNodes.add(t);
    			}
    			
    			success &= updateOpcUAReferenceType(t, nodesToAdd, nodesToDelete);

    			if(!success)
    			{
    				success &= updateOpcUAReferenceType(t, nodesToAdd, nodesToDelete);
    				break;
    			}
    		}
    		
    		// Important first remove old elements than add new ones
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
    			
    			if(t.getParentNodeId() != null && t.getParentNodeId().length() > 0)
    			{
    				uaInstanceReferences.add(t);
    			}
    			
    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    			{
    				rolePermissionNodes.add(t);
    			}
    			
    			success &= updateOpcUAObject(t, nodesToAdd, nodesToDelete);
    			if(!success)
    			{
    				success &= updateOpcUAObject(t, nodesToAdd, nodesToDelete);
    				break;
    			}
    		}
    		
    		// Important first remove old elements than add new ones
    		this.baseNodeset.getUAObject().removeAll(nodesToDelete);
    		this.baseNodeset.getUAObject().addAll(nodesToAdd);
    	}
    	// Important!
    	// UAVariable depends on DataTypes --> DataTypes need to be parsed first
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
    			if((t.getParentNodeId() != null && t.getParentNodeId().length() > 0) ||
					t.getDataType() != null && t.getDataType().length() > 0)
    			{
    				uaInstanceReferences.add(t);
    			}
    			
    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    			{
    				rolePermissionNodes.add(t);
    			}
    			
    			success &= updateOpcUAVariable(t, nodesToAdd, nodesToDelete);
    			if(!success)
    			{
    				success &= updateOpcUAVariable(t, nodesToAdd, nodesToDelete);
    				break;
    			}
    		}
    		
    		// Important first remove old elements than add new ones
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
    			if(t.getParentNodeId() != null && t.getParentNodeId().length() > 0)
    			{
    				uaInstanceReferences.add(t);
    			}
    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    			{
    				rolePermissionNodes.add(t);
    			}
    			if(t.getMethodDeclarationId() != null && t.getMethodDeclarationId().length() > 0 && 
    				!uaInstanceReferences.contains(t))
    			{
    				uaInstanceReferences.add(t);
    			}
    			
    			success &= updateOpcUAMethod(t, nodesToAdd, nodesToDelete);
    			if(!success)
    			{
    				success &= updateOpcUAMethod(t, nodesToAdd, nodesToDelete);
    				break;
    			}
    		}
    		// Important first remove old elements than add new ones
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
    			if(t.getParentNodeId() != null && t.getParentNodeId().length() > 0)
    			{
    				uaInstanceReferences.add(t);
    			}
    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    			{
    				rolePermissionNodes.add(t);
    			}
    			success &= updateOpcUAView(t, nodesToAdd, nodesToDelete);
    			if(!success)
    			{
    				success &= updateOpcUAView(t, nodesToAdd, nodesToDelete);
    				break;
    			}
    		}
    		
    		// Important first remove old elements than add new ones
    		this.baseNodeset.getUAView().removeAll(nodesToDelete);
    		this.baseNodeset.getUAView().addAll(nodesToAdd);
    		
    	}
    	
    	if(success)
    	{
    		success &= updateOpcUaReferenceTypesReferences(referenceTypes);
    	}
    	
    	if(success)
    	{
    		success &= updateOpcUaReferences(referenceNodes);
    	}
    	
    	if(success)
    	{
    		success &= updateOpcUaInstanceReferences(uaInstanceReferences);
    	}
    	
    	if(success)
    	{
    		success &= updateOpcUaRolePermissions(rolePermissionNodes);
    	}
    	
    	if(success)
    	{
    		success &= updateDataTypeDefinitions(dataTypeDefinitions);
    	}
    	    	
		return success;
	}


	private boolean updateNamespaces(UriTable namespaceUris) {

		EList<String> namespaces_new = namespaceUris.getUri();	
		
		if(this.baseNodeset.getNamespaceUris() == null)
		{
			this.baseNodeset.setNamespaceUris(new UriTableImpl());
		}
		
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaNodeSetType  = nodeSetProfile.getOwnedStereotype("UANodeSetType");
		Stereotype uaNameSpaceType  = nodeSetProfile.getOwnedStereotype("NameSpace");
		
		EcoreEList<DynamicEObjectImpl> nsList = (EcoreEList<DynamicEObjectImpl>) this.baseUmlModel.getValue(uaNodeSetType, "nameSpaceUris");
		ArrayList<Package> toDelete = new ArrayList<Package>();
		HashMap<String, DynamicEObjectImpl> nameSpacePackageMapping = new HashMap<String, DynamicEObjectImpl>();
		
		for(DynamicEObjectImpl nsObject : nsList )
		{
			Package umlNameSpace = (Package) nsObject.dynamicGet(0);
			String uri = umlNameSpace.getURI();
			
			if(!namespaces_new.contains(uri))
			{
				toDelete.add(umlNameSpace);
			}
			else
			{				
				nameSpacePackageMapping.put(uri, nsObject);
			}
		}
		
		
		while(!toDelete.isEmpty())
		{
			toDelete.get(0).destroy();
			toDelete.remove(0);
		}

		EList<Package> importedNamespaces = this.baseUmlModel.getImportedPackages();
		for(Package importedNamespace :importedNamespaces)
		{
			if(importedNamespace.getURI() != null && 
				namespaceUris.getUri().contains(importedNamespace.getURI()))
			{				
				DynamicEObjectImpl nsObject = (DynamicEObjectImpl) importedNamespace.getStereotypeApplication(uaNameSpaceType);
				nameSpacePackageMapping.put(importedNamespace.getURI(),nsObject );
				nsList.add(nsObject);
			}
		}
		
		for(String namespace : namespaceUris.getUri())
		{
			if(namespace == null )
			{
				continue;
			}
			
		
			if( !nameSpacePackageMapping.containsKey(namespace))
			{
				Package ns = null;
				if(OpcUaLibraryResources.NAMESPACE_PACKAGE_MAPPING.containsKey(namespace) )
				{
					// default namespace needs to be imported
					URI lib_path = URI.createURI(OpcUaLibraryResources.NAMESPACE_PACKAGE_MAPPING.get(namespace));
					ResourceSet owner_resource = this.baseUmlModel.eResource().getResourceSet(); 
					Model modelimport = (Model) PackageUtil.loadPackage(lib_path, owner_resource);
					
					for(Package namespacePackage : modelimport.getNestedPackages())
					{
						if(namespacePackage.getURI().equals(namespace))
						{
							ns = namespacePackage;
							break;
						}
					}
					
					if(ns == null)
					{
						continue;
					}
					
					this.baseUmlModel.createPackageImport(ns);
					
				}
				else
				{					
					ns = this.baseUmlModel.createNestedPackage(namespace);
					ns.applyStereotype(uaNameSpaceType);
					ns.setURI(namespace);
				}
				DynamicEObjectImpl temp = (DynamicEObjectImpl)ns.getStereotypeApplication(uaNameSpaceType);
				nameSpacePackageMapping.put(namespace, temp);
				nsList.add(temp);
			}
		}
		
		nsList = (EcoreEList<DynamicEObjectImpl>) this.baseUmlModel.getValue(uaNodeSetType, "nameSpaceUris");
		
		EList<String> existing_namespaces = this.baseNodeset.getNamespaceUris().getUri();
		existing_namespaces.clear();
		existing_namespaces.addAll(namespaces_new);
		
		for(int i=0; i<namespaces_new.size() && i < nameSpacePackageMapping.size();i++)
		{
			String nsString = namespaces_new.get(i);
			DynamicEObjectImpl nsSterApp = nameSpacePackageMapping.get(nsString);
			Package umlNs = (Package) nsSterApp.dynamicGet(0);
			
			nsList.move(i, nsSterApp);
			existing_namespaces.move(i, umlNs.getURI());
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
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAObjectType");
		
		Element uaElement = getElement(node);
		
		if(uaElement == null)
		{
			uaElement = createElement(node, uaStereoType);
			nodesToDelete.add(node); // delete old element if namespace is different
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
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAVariableType");
		
		Element uaElement = getElement(node);
		
		if(uaElement == null)
		{
			uaElement = createElement(node, uaStereoType);
			nodesToDelete.add(node); // delete old element if namespace is different
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
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UADataType");
		
		Element uaElement = getElement(node);
		
		if(uaElement == null)
		{
			uaElement = createElement(node, uaStereoType);
			nodesToDelete.add(node); // delete old element if namespace is different
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
			// DataTypeDefinition is parsed later
			if(node.getPurpose() != null )
			{
				Object releaseStatus = uaElement.getValue(uaStereoType, "purpose");
				
				EnumerationLiteral lit = (EnumerationLiteral) releaseStatus;
				Enumeration uaEnum = lit.getEnumeration();
				
				switch(node.getPurpose().getValue())
				{
				case DataTypePurpose.NORMAL_VALUE :
					uaElement.setValue(uaStereoType, "purpose", uaEnum.getOwnedLiteral("Normal"));
					break;
				case DataTypePurpose.SERVICES_ONLY_VALUE:
					uaElement.setValue(uaStereoType, "purpose", uaEnum.getOwnedLiteral("ServicesOnly"));
					break;
				case DataTypePurpose.CODE_GENERATOR_VALUE:
					uaElement.setValue(uaStereoType, "purpose", uaEnum.getOwnedLiteral( "CodeGenerator"));
					break;
				}
			}
			
			
		}
		
		return success;
	}
	
	private boolean updateDataTypeDefinitions( ArrayList<UADataType> dataTypes)
	{
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UADataType");
		boolean success = true;
		
		for(UADataType datatype : dataTypes)
		{
			Class uaElement = (Class) getElement(datatype);
			
			if(uaElement == null)
			{
				success = false;
				break;
			}
			
			DynamicEObjectImpl definition;
			Class definitionClass, dataTypeClass;
			dataTypeClass = (Class) uaElement;
					
			if(uaElement == null || uaStereoType == null)
			{
				uaElement = (Class) getElement(datatype);
			}
			
			if(uaElement.hasValue(uaStereoType, "definition"))
			{
				definition = (DynamicEObjectImpl) uaElement.getValue(uaStereoType, "definition");
				definitionClass = getStereotypeBaseClass(definition, true);
			}
			else
			{
				Package ns = uaElement.getNearestPackage();
				if(ns == null)
				{
					Model model = uaElement.getModel();
					definitionClass = model.createOwnedClass("DataTypeDefinition", false);
				}
				else
				{
					definitionClass = ns.createOwnedClass("DataTypeDefinition", false);
				}
				
				Stereotype uaDefinitionType = nodeSetProfile.getOwnedStereotype("DataTypeDefinition");
				definitionClass.applyStereotype(uaDefinitionType);
				definition = (DynamicEObjectImpl) definitionClass.getStereotypeApplication(uaDefinitionType);
			}
			
			EList<Classifier> classifiers = dataTypeClass.getNestedClassifiers();
			if(!classifiers.contains(definition))
			{
				classifiers.add(definitionClass);
			}
					
			success &= updateOpcUaDataTypeDefinition(datatype.getDefinition(), definitionClass);
			
		}
		
		return success;
	}
	
	private boolean updateOpcUaDataTypeDefinition(DataTypeDefinition dtd, Class definition)
	{
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("DataTypeDefinition");
		boolean success = true;
		
		if(dtd.getBaseType() != null)
		{
			definition.setValue(uaStereoType, "baseType", dtd.getBaseType());
		}
		
		if(dtd.getField() != null)
		{
			success &= updateOpcUaDataTypeDefinition_Field(dtd, definition);
		}
		
		if(dtd.getName() != null)
		{
			definition.setValue(uaStereoType, "name", dtd.getName());
		}
		
		if(dtd.getSymbolicName() != null)
		{
			EDataTypeUniqueEList<Object> symbollicName = (EDataTypeUniqueEList<Object>) definition.getValue(uaStereoType, "symbolicName");
			symbollicName.clear();
			for(String symbolic : dtd.getSymbolicName())
			{
				symbollicName.add(symbolic);
			}
		}
		
		definition.setValue(uaStereoType, "isOptionSet", dtd.isIsOptionSet() );
		definition.setValue(uaStereoType, "isUnion", dtd.isIsUnion() );
		
		
		return success;
	}
	
	private boolean updateOpcUaDataTypeDefinition_Field(DataTypeDefinition dtd, Class definition)
	{
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("DataTypeDefinition");
		Stereotype uaDtfType  = nodeSetProfile.getOwnedStereotype("DataTypeField");
		
		EcoreEList<DynamicEObjectImpl> field = (EcoreEList<DynamicEObjectImpl>) definition.getValue(uaStereoType, "field");
		EList<Classifier> children = definition.getNestedClassifiers();
		
		ArrayList<DataTypeField> existingDTF = new ArrayList<DataTypeField>();
		ArrayList<Class> deleteDTF = new ArrayList<Class>();
		
		boolean success = true;

		for(DynamicEObjectImpl fieldEntry : field)
		{
			Class dataTypeField = getStereotypeBaseClass(fieldEntry, true);
			if(dataTypeField != null)
			{
				DataTypeField dtf = (DataTypeField) this.matching.get(dataTypeField);
				if(dtd.getField().contains(dtf))
				{						
					existingDTF.add(dtf);
					if(!children.contains(dataTypeField))
					{
						children.add(dataTypeField);
					}
					success &= updateOpcUaDataTypeField(dtf, dataTypeField);
				}
				else
				{
					deleteDTF.add(dataTypeField);
				}				
			}
		}	
		
		while(!deleteDTF.isEmpty())
		{
			deleteDTF.get(0).destroy();
			deleteDTF.remove(0);
		}
		
		
		for(DataTypeField dtf : dtd.getField())
		{
			if(! existingDTF.contains(dtf))
			{
				Package ns = definition.getNearestPackage();
				Class dtfClass;
				
				if(dtf.getDataType() == null || dtf.getDataType().length() == 0)
				{
					success = false;
					break;
				}
				
				Class datatype = (Class) this.nodeIdMap.get(dtf.getDataType());
				
				if(datatype ==null || datatype.getName() == null || datatype.getName().length() ==0)
				{						
					success =  false;
					break;
				}

				String name = "DataTypeField_"+datatype.getName();

				if(ns == null)
				{
					Model model = definition.getModel();	
					dtfClass = model.createOwnedClass(name, false);
				}
				else
				{
					dtfClass = ns.createOwnedClass(name, false);
				}
				children.add(dtfClass);
				
				dtfClass.applyStereotype(uaDtfType);
				success &= updateOpcUaDataTypeField(dtf, dtfClass);
			}
		}
		return success;
	}
	
	private boolean updateOpcUaDataTypeField(DataTypeField dtf, Class field)
	{
		boolean success = true;
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("DataTypeField");
		
		if(dtf.getDisplayName() != null)
		{
			EDataTypeUniqueEList<Object> displayName = (EDataTypeUniqueEList<Object>) field.getValue(uaStereoType, "displayName");
			displayName.clear();
			for(LocalizedText display : dtf.getDisplayName())
			{
				displayName.add(display.getValue());
			}
		}
		
		if(dtf.getDescription() != null)
		{
			EDataTypeUniqueEList<Object> descriptionList= (EDataTypeUniqueEList<Object>) field.getValue(uaStereoType, "description");
			descriptionList.clear();
			for(LocalizedText description : dtf.getDescription())
			{
				descriptionList.add(description.getValue());
			}
		}
		
		if(dtf.getAbstractDataType() != null)
		{
			Object abstractDataType = getUmlNodeReference(dtf.getAbstractDataType());
			if(abstractDataType == null)
			{
				success = false;
			}
			else
			{				
				field.setValue(uaStereoType, "abstractDataType", abstractDataType);
			}
		}
		
		if(dtf.getArrayDimensions() != null && dtf.getArrayDimensions().length() > 0)
		{
			List<Object> arrayDimensions = (List<Object>) field.getValue(uaStereoType, "arrayDimensions");
			arrayDimensions.clear();
			
			for(String dim : dtf.getArrayDimensions().split(","))
			{
				int convertedInt = Integer.valueOf(dim);
				arrayDimensions.add(convertedInt);
			}
			
		}

		if(dtf.getDataType() != null)
		{
			Object dataType = getUmlNodeReference(dtf.getDataType());
			if(dataType == null)
			{
				success = false;
			}
			else
			{				
				field.setValue(uaStereoType, "dataType", dataType);
			}
		}
		
		field.setValue(uaStereoType, "isOptional", dtf.isIsOptional());
		field.setValue(uaStereoType, "maxStringLength", dtf.getMaxStringLength());
				
		if(dtf.getName() != null)
		{
			field.setValue(uaStereoType, "name", dtf.getName());
		}
		
		if(dtf.getSymbolicName() != null)
		{
			EDataTypeUniqueEList<Object> symbollicName = (EDataTypeUniqueEList<Object>) field.getValue(uaStereoType, "symbolicName");
			symbollicName.clear();
			for(String symbolic : dtf.getSymbolicName())
			{
				symbollicName.add(symbolic);
			}
		}
		field.setValue(uaStereoType, "value", dtf.getValue());
		field.setValue(uaStereoType, "valueRank", dtf.getValueRank());
		
		return success;
	}
	
	private boolean updateOpcUAReferenceType(UAReferenceType node, List<UAReferenceType> nodesToAdd, List<UAReferenceType> nodesToDelete) {
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAReferenceType");
		
		Element uaElement = getElement(node);
		
		if(uaElement == null)
		{
			uaElement = createElement(node, uaStereoType);
			nodesToDelete.add(node); // delete old element if namespace is different
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
		
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAObject");
		
		Element uaElement = getElement(node);
		
		if(uaElement == null)
		{
			uaElement = createElement(node, uaStereoType);
			nodesToDelete.add(node); // delete old element if namespace is different
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
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAVariable");
		
		Element uaElement = getElement(node);
		
		if(uaElement == null)
		{
			uaElement = createElement(node, uaStereoType);
			nodesToDelete.add(node); // delete old element if namespace is different
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
			//TODO: Add value

			uaElement.setValue(uaStereoType, "accessLevel", node.getAccessLevel());
			
			if(node.getArrayDimensions() != null && node.getArrayDimensions().length() > 0)
			{
				List<Object> arrayDimensions = (List<Object>) uaElement.getValue(uaStereoType, "arrayDimensions");
				arrayDimensions.clear();
				
				for(String dim : node.getArrayDimensions().split(","))
				{
					int convertedInt = Integer.valueOf(dim);
					arrayDimensions.add(convertedInt);
				}
			}
				
						
			uaElement.setValue(uaStereoType, "historizing", node.isHistorizing());
			uaElement.setValue(uaStereoType, "minimumSamplingInterval", node.getMinimumSamplingInterval());
			
			if(node.getTranslation() != null)
			{
				Stereotype ttStereoType  = nodeSetProfile.getOwnedStereotype("TranslationType");
				Stereotype sttStereoType  = nodeSetProfile.getOwnedStereotype("StructureTranslationType");
				
				EList<TranslationType> tt = node.getTranslation();				
				
				if(uaElement.hasValue(uaStereoType, "translation"))
				{
					
					EList<DynamicEObjectImpl> translations = (EList<DynamicEObjectImpl>) uaElement.getValue(uaStereoType, "translation");
					while(!translations.isEmpty())
					{
						Class ttClass = getStereotypeBaseClass(translations.get(0), false);
						ttClass.destroy();
					}
				}
				
				Package container = uaElement.getNearestPackage();
				Class variable = (Class)uaElement;
						
				for(TranslationType transType : tt)
				{
					Class ttClass = container.createOwnedClass("TranslationType", false);
					ttClass.applyStereotype(ttStereoType);
					variable.getNestedClassifiers().add(ttClass);
					
					EList<String> text = (EList<String>) ttClass.getValue(ttStereoType, "text");
					for(LocalizedText lt : transType.getText())
					{
						text.add(lt.getValue());
					}

					EList<DynamicEObjectImpl> field = (EList<DynamicEObjectImpl>) ttClass.getValue(ttStereoType, "field");
					
					for(StructureTranslationType stt : transType.getField())
					{
						if(stt.getName() != null && stt.getName().length() >0 )
						{							
							Class sttClass = container.createOwnedClass(stt.getName(), false);
							sttClass.applyStereotype(sttStereoType);
							ttClass.getNestedClassifiers().add(sttClass);
							
							sttClass.setValue(sttStereoType, "name",stt.getName());
							text = (EList<String>) sttClass.getValue(sttStereoType, "text");
							
							for(LocalizedText lt : stt.getText())
							{
								text.add(lt.getValue());
							}
							field.add((DynamicEObjectImpl) sttClass.getStereotypeApplication(sttStereoType));
						}
					}
					
				}
				
			}
			
			uaElement.setValue(uaStereoType, "userAccessLevel", node.getUserAccessLevel());
			uaElement.setValue(uaStereoType, "valueRank", node.getValueRank());
		}


		
		return success;
	}

	private boolean updateOpcUAMethod(UAMethod node, List<UAMethod> nodesToAdd, List<UAMethod> nodesToDelete) {

		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAMethod");
		
		Element uaElement = getElement(node);
		
		if(uaElement == null)
		{
			uaElement = createElement(node, uaStereoType);
			nodesToDelete.add(node); // delete old element if namespace is different
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
			Stereotype uaMethodSter = getMatchingStereotype(node);
			
			if(node.getArgumentDescription() != null)
			{				

				success &= updateOpcUaMethodArgument(node, (Class) uaElement);
				
			}
			uaElement.setValue(uaMethodSter, "executable", node.isExecutable());			
			uaElement.setValue(uaMethodSter, "userExecutable", node.isUserExecutable());
		}
		return success;
	}
	
	
	
	private boolean updateOpcUaMethodArgument(UAMethod uaMethod, Class uaElement) {
		
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaMethodStereotype  = nodeSetProfile.getOwnedStereotype("UAMethod");
		Stereotype uaMethodArgumentStereotype  = nodeSetProfile.getOwnedStereotype("UAMethodArgument");
		
		EcoreEList<DynamicEObjectImpl> methodArguments = (EcoreEList<DynamicEObjectImpl>) uaElement.getValue(uaMethodStereotype, "argumentDescription");
		EList<Classifier> children = uaElement.getNestedClassifiers();
		
		ArrayList<UAMethodArgument> existingUaMethArg = new ArrayList<UAMethodArgument>();
		ArrayList<Class> deleteUaMethArg = new ArrayList<Class>();
		
		boolean success = true;
		
		for(DynamicEObjectImpl methodArgumentEntry : methodArguments)
		{
			Class methodArgument = getStereotypeBaseClass(methodArgumentEntry, true);
			if(methodArgument != null)
			{
				UAMethodArgument uaMethArg = (UAMethodArgument) this.matching.get(methodArgument);
				if(uaMethod.getArgumentDescription().contains(uaMethArg))
				{						
					existingUaMethArg.add(uaMethArg);
					if(!children.contains(methodArgument))
					{
						children.add(methodArgument);
					}
					updateOpcUaMethodArgumentEntry(uaMethArg, methodArgument);
				}
				else
				{
					deleteUaMethArg.add(methodArgument);
				}		
			}
		}
		
		while(!deleteUaMethArg.isEmpty())
		{
			deleteUaMethArg.get(0).destroy();
			deleteUaMethArg.remove(0);
		}
		
		for( UAMethodArgument uaMethArg : uaMethod.getArgumentDescription())
		{
			if(!existingUaMethArg.contains(uaMethArg))
			{
				Package ns = uaElement.getNearestPackage();

				Class uaMethArgClass;
				
				if(uaMethArg.getName() == null || uaMethArg.getName().length() == 0)
				{
					success = false;
					break;
				}
				
				String name = "UAMethodArgument_"+uaMethArg.getName();
				
				if(ns == null)
				{
					Model model = uaElement.getModel();	
					uaMethArgClass = model.createOwnedClass(name, false);
				}
				else
				{
					uaMethArgClass = ns.createOwnedClass(name, false);
				}
				children.add(uaMethArgClass);
				uaMethArgClass.applyStereotype(uaMethodArgumentStereotype);
				updateOpcUaMethodArgumentEntry(uaMethArg, uaMethArgClass);
			}
		}
		
		return success;
	}
	
	private boolean updateOpcUaMethodArgumentEntry(UAMethodArgument uaMethodArgument, Class uaElement) {
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAMethodArgument");
		
		if(uaMethodArgument.getName() != null && uaMethodArgument.getName().length() > 0 )
		{
			uaElement.setValue(uaStereoType, "name", uaMethodArgument.getName());
		}
		
		if(uaMethodArgument.getDescription() != null && uaMethodArgument.getDescription().size() > 0 )
		{
			EDataTypeUniqueEList<Object> descriptionList= (EDataTypeUniqueEList<Object>) uaElement.getValue(uaStereoType, "description");
			descriptionList.clear();
			for(LocalizedText description : uaMethodArgument.getDescription())
			{
				descriptionList.add(description.getValue());
			}
		}
		
		return true;
	}

	private boolean updateOpcUAView(UAView node, List<UAView> nodesToAdd, List<UAView> nodesToDelete) {
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAView");
				
		Element uaElement = getElement(node);
		
		if(uaElement == null)
		{
			uaElement = createElement(node, uaStereoType);
			nodesToDelete.add(node); // delete old element if namespace is different
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
		
		// ParentNodeId is parsed in a later step
		return success;
	}
	
	private boolean updateOpcUaType(UAType node, Stereotype stereotype, Element uaElement) {
		boolean success = updateOpcUaNode(node, stereotype, uaElement);
		return success;
	}
	
	private boolean updateOpcUaNode(UANode node, Stereotype stereotype, Element uaElement) {

		
		if(node.getNodeId() != null) {
			String nodeId = node.getNodeId();

			this.nodeIdMap.put(nodeId, uaElement);			
			
			if(nodeId.startsWith("ns="))
			{
				// remove namespace indicator if existing
				int seperator = nodeId.indexOf(";")+1;
				nodeId = nodeId.substring(seperator);
			}
			
			if(nodeId.contains("s="))
			{
				int seperator = nodeId.lastIndexOf("s=")+2;
				nodeId = nodeId.substring(seperator);
			}
			else if(nodeId.contains("i="))
			{
				int seperator = nodeId.lastIndexOf("i=")+2;
				nodeId = nodeId.substring(seperator);
			} 
			
			uaElement.setValue(stereotype, "nodeId", nodeId);
						
		}
		else
		{
			// node id is mandatory
			return false;
		}
		
		if(node.getDisplayName() != null)
		{			
			EDataTypeUniqueEList<Object> displayNames = (EDataTypeUniqueEList<Object>) uaElement.getValue(stereotype, "displayName");
			displayNames.clear();
			for(LocalizedText displayName : node.getDisplayName())
			{
				displayNames.add(displayName.getValue());
			}
		}
		
		if(node.getDescription() != null)
		{			
			EDataTypeUniqueEList<Object> description = (EDataTypeUniqueEList<Object>) uaElement.getValue(stereotype, "description");
			description.clear();
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
			EDataTypeUniqueEList<Object> description = (EDataTypeUniqueEList<Object>) uaElement.getValue(stereotype, "description");
			description.add(node.getDocumentation());
		}
		
		// rolepermissions are not done here because references are needed

		// short cannot be null
		uaElement.setValue(stereotype, "accessRestrictions", String.valueOf(node.getAccessRestrictions()));
		
		if(node.getBrowseName() != null)
		{
			String browseName = node.getBrowseName();
			if(browseName.contains(":"))
			{
				int seperator = browseName.indexOf(":")+1;
				browseName = browseName.substring(seperator);
			}

			uaElement.setValue(stereotype, "browseName", browseName);
		}

	
		if(node.getReleaseStatus() != null) {
		
			Object releaseStatus = uaElement.getValue(stereotype, "releaseStatus");
			
			EnumerationLiteral lit = (EnumerationLiteral) releaseStatus;
			Enumeration uaEnum = lit.getEnumeration();
			
			switch(node.getReleaseStatus().getValue())
			{
			case ReleaseStatus.DRAFT_VALUE :
				uaElement.setValue(stereotype, "releaseStatus", uaEnum.getOwnedLiteral("Draft"));
				break;
			case ReleaseStatus.RELEASED_VALUE:
				uaElement.setValue(stereotype, "releaseStatus", uaEnum.getOwnedLiteral("Released"));
				break;
			case ReleaseStatus.DEPRECATED_VALUE:
				uaElement.setValue(stereotype, "releaseStatus", uaEnum.getOwnedLiteral("Deprecated"));
				break;
			}
		}
		
		if(node.getSymbolicName() != null)
		{			
			EDataTypeUniqueEList<Object> symbollicName = (EDataTypeUniqueEList<Object>) uaElement.getValue(stereotype, "symbolicName");
			symbollicName.clear();
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
		
	private Element getElement(UANode node)
	{
		Element uaElement = null;
		String nodeId = node.getNodeId();
		int namespaceId=0;
		String namespace="";
		
		// check if node is inside a ns
		if(nodeId.contains(";"))
		{				
			// extract namespace id
			String namespaceString = nodeId.split(";")[0].substring(3);
			namespaceId = Integer.parseInt(namespaceString);	
			
			Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
			Stereotype uaNodeSetType  = nodeSetProfile.getOwnedStereotype("UANodeSetType");
			
			EcoreEList<DynamicEObjectImpl> nsList = (EcoreEList<DynamicEObjectImpl>) this.baseUmlModel.getValue(uaNodeSetType, "nameSpaceUris");
			
			if(nsList.size() < namespaceId)
			{
				// Namespace does not exists 
				return null;
			}
			
			Package nameSpacePackage = (Package) nsList.get(namespaceId-1).dynamicGet(0);
			namespace = nameSpacePackage.getURI();
		}

		if(this.nodeIdMap.containsKey(node.getNodeId()))
		{
			uaElement = this.nodeIdMap.get(node.getNodeId());

			Element parent = uaElement.getOwner();
			if(parent instanceof Model)
			{
				// parent is model => ns 0
				if(namespaceId != 0)
				{
					// Element not in default Namespace
					uaElement = null;
					this.matching.remove(uaElement);
				}
			}
			else if(parent instanceof Package)
			{
				Package parentNS = (Package) parent;
				if(parentNS == null || parentNS.getURI()==null || !parentNS.getURI().equals(namespace))
				{
					// Element in wrong Namespace 
					uaElement = null;
					this.matching.remove(uaElement);
				}
			}
		}
		return uaElement;
	}
	
	private Element createElement(UANode node, Stereotype uaStereoType)
	{
		Element uaElement = null;
		
		Package namespace = getNamespacePackage(node.getNodeId());
		
		// Element does not exist in Model 
		// create new UAObjectType Element
		int separator = node.getBrowseName().lastIndexOf(":")+1;
		String name = node.getBrowseName().substring(separator);
		
		if(namespace == null)
		{			
			uaElement= baseUmlModel.createOwnedClass(name, false);
		}
		else
		{
			uaElement = namespace.createOwnedClass(name, false);
		}
		
		uaElement.applyStereotype(uaStereoType);
		this.matching.put(uaElement, node);
		this.nodeIdMap.put(node.getNodeId(), uaElement);
		return uaElement;
	}
	
	private Package getNamespacePackage(String nodeId)
	{
		Package namespace = null;
		if(nodeId.contains(";"))
		{				
			// extraced namespace id
			String namespaceString = nodeId.split(";")[0].substring(3);
			int namespaceId = Integer.parseInt(namespaceString);	
			
			Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
			Stereotype uaNodeSetType  = nodeSetProfile.getOwnedStereotype("UANodeSetType");
			
			EcoreEList<DynamicEObjectImpl> nsList = (EcoreEList<DynamicEObjectImpl>) this.baseUmlModel.getValue(uaNodeSetType, "nameSpaceUris");
			
			if(nsList.size() < namespaceId)
			{
				// Namespace does not exists 
				return null;
			}
			
			namespace = (Package) nsList.get(namespaceId-1).dynamicGet(0);
			
		}
		
		return namespace;
	}
	
	private boolean updateOpcUaReferenceTypesReferences(ArrayList<UAReferenceType> referenceTypes) {
		boolean success = true;
		// create references between ReferenceTypes
		for(UAReferenceType rt : referenceTypes)
		{
			success &= updateOpcUaNodeReferences(rt);
			if(!success)
			{
				break;
			}
		}
		// Analyse if reference Type is a hierachical Reference Type
		for(UAReferenceType rt : referenceTypes)
		{
			success &= handleHierachicalTypes(rt);
			if(!success)
			{
				break;
			}
		}
		
		return success;
	}
	
	private boolean handleHierachicalTypes(UAReferenceType referenceType)
	{
		
 		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaReferenceType  = nodeSetProfile.getOwnedStereotype("UAReferenceType");
		Stereotype uaReference  = nodeSetProfile.getOwnedStereotype("Reference");
		Class uaElement = (Class) this.nodeIdMap.get(referenceType.getNodeId());

		boolean isSubtype = false;
		
		if(uaElement.getName().equalsIgnoreCase("HierarchicalReferences"))
		{
			uaElement.setValue(uaReferenceType, "isHierachical", true);
		}
		else if(uaElement.getName().equalsIgnoreCase("References"))
		{
			uaElement.setValue(uaReferenceType, "isHierachical", false);
			// Reference for References ReferenceType is not set at this point.
			// Nonetheless it exists
			isSubtype = true;
		}
		
		for(Generalization reference : uaElement.getGeneralizations())
		{
			// references shall have a referenceType
			if(! reference.hasValue(uaReference, "referenceType"))
			{
				return false;
			}
			
			DynamicEObjectImpl refTypeSterAppl = (DynamicEObjectImpl) reference.getValue(uaReference, "referenceType");
			Class refType = getStereotypeBaseClass(refTypeSterAppl, true);
			if(!refType.hasValue(uaReferenceType, "browseName"))
			{
				return false;
			}
			String browseName = String.valueOf(refType.getValue(uaReferenceType, "browseName"));
			// if this is not a subtype reference, the hierachical property is not inherited/transmitted
			if(!browseName.equalsIgnoreCase("HasSubtype"))
			{
				continue;
			}
			
			// each ReferenceType shall be a subtype of another type
			isSubtype = true;
			
			for(Element target :reference.getTargets())
			{
				Class uaRefType = (Class)target;
				if(!uaRefType.hasValue(uaReferenceType, "isHierachical") &&
				   !uaElement.hasValue(uaReferenceType, "isHierachical"))
				{
					handleHierachicalTypes(uaRefType,uaReferenceType, uaReference);
				}
				
				boolean isForward = (boolean) reference.getValue(uaReference, "isForward");
				
				if(uaRefType.getModel().equals(uaElement.getModel()))
				{
					if(isForward)
					{
						EList<Classifier> children = uaElement.getNestedClassifiers();
						if(!children.contains(uaRefType))
						{
							children.add(uaRefType);
						}
					}
					else
					{					
						EList<Classifier> children = uaRefType.getNestedClassifiers();
						if(!children.contains(uaElement))
						{
							children.add(uaElement);
						}
					}
				}	
				
				if(!uaElement.hasValue(uaReferenceType, "isHierachical"))
				{
					boolean isHierachical = (boolean) uaRefType.getValue(uaReferenceType, "isHierachical");
					uaElement.setValue(uaReferenceType, "isHierachical", isHierachical);
				}
			}
		}
		
		return isSubtype;
	}
	
	private boolean handleHierachicalTypes(Class referenceType, Stereotype uaReferenceType, Stereotype uaReference)
	{
	    
		if(!referenceType.getName().equalsIgnoreCase("HierarchicalReferences") &&
		   !referenceType.getName().equalsIgnoreCase("References		String test =\"asdfasf\";\n" + 
		   		"		EList<Generalization> aas = uaElement.getGeneralizations();"))
		{
			for(Generalization reference : referenceType.getGeneralizations() )
			{
				for(Element target :reference.getTargets())
				{
					Class uaRefType = (Class)target;
					if(!uaRefType.hasValue(uaReferenceType, "isHierachical") &&
					   !referenceType.hasValue(uaReferenceType, "isHierachical"))
					{
						handleHierachicalTypes(uaRefType,uaReferenceType,uaReference);
					}
					
					boolean isForward = (boolean) reference.getValue(uaReference, "isForward");
					if(isForward)
					{
						EList<Classifier> children = referenceType.getNestedClassifiers();
						if(!children.contains(uaRefType))
						{
							children.add(uaRefType);
						}
					}
					else
					{					
						EList<Classifier> children = uaRefType.getNestedClassifiers();
						if(!children.contains(referenceType))
						{
							children.add(referenceType);
						}
					}
					
					if(!referenceType.hasValue(uaReferenceType, "isHierachical"))
					{
						boolean isHierachical = (boolean) uaRefType.getValue(uaReferenceType, "isHierachical");
						referenceType.setValue(uaReferenceType, "isHierachical", isHierachical);
					}
				}
			}
		}
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
		
		Object refType = getUmlNodeReference(ref.getReferenceType());
		if(refType == null)
		{
			return false;
		}
		Class refValue = getUmlNode(ref.getValue());
		if(refValue == null)
		{
			return false;
		}
				
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaReference  = nodeSetProfile.getOwnedStereotype("Reference");
		
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
			this.matching.put(reference, ref);
		}
		
		reference.setValue(uaReference,"isForward", String.valueOf(ref.isIsForward()));
		reference.setValue(uaReference,"referenceType", refType);
				
		Class uaReferenceType = getUmlNode(ref.getReferenceType());
		Stereotype uaReferenceTypeStereoType  = nodeSetProfile.getOwnedStereotype("UAReferenceType");
		
		boolean isHierachicalReference = (boolean) uaReferenceType.getValue(uaReferenceTypeStereoType, "isHierachical");
		
		reference.setValue(uaReference,"referenceType_symmetric", uaReferenceType.getValue(uaReferenceTypeStereoType, "symmetric"));
		reference.setValue(uaReference,"referenceType_browseName", uaReferenceType.getValue(uaReferenceTypeStereoType, "browseName"));
		reference.setValue(uaReference,"referenceType_isHierachical", isHierachicalReference);

		if(isHierachicalReference && uaElement.getModel().equals(refValue.getModel()) && 
				uaElement.getNearestPackage().equals(refValue.getNearestPackage()))
		{	
			if(ref.isIsForward())
			{
				uaElement.getNestedClassifiers().add(refValue);
			}
			else
			{				
				refValue.getNestedClassifiers().add(uaElement);
			}
		}
		
		return success;
	}
	
	private boolean updateOpcUaInstanceReferences(ArrayList<UAInstance> parentNodes) {
		boolean success = true;
		for(UAInstance var : parentNodes)
		{
			// check if parent node id is set
			if(var.getParentNodeId() != null && var.getParentNodeId().length() > 0)
			{
				success &= updateOpcUaParent(var);
				if(!success)
				{
					break;
				}
			}
			
			// check if UAVariable and set the datatype
			if(var instanceof UAVariable)
			{
				success &= updateOpcUaDatatype((UAVariable) var);
				if(!success)
				{
					break;
				}
				
			}
			else if(var instanceof UAMethod)
			{
				success &= updateOpcUaMethodDeclarationId((UAMethod) var);
				if(!success)
				{
					break;
				}	
			}
			
		}
		
		return success;
	}

	private boolean updateOpcUaMethodDeclarationId(UAMethod inst) {
		// get stereotype Application of parent element
		Object methodDeclarationId = getUmlNodeReference(inst.getMethodDeclarationId());
		
		Class varElement = getUmlNode(inst.getNodeId());
		
		Stereotype uaInstance = getMatchingStereotype(inst);
		varElement.setValue(uaInstance, "methodDeclarationId", methodDeclarationId);

		return true;
	}

	private boolean updateOpcUaParent(UAInstance inst) {
		// get stereotype Application of parent element
		Object parent = getUmlNodeReference(inst.getParentNodeId());
		
		Class varElement = getUmlNode(inst.getNodeId());
		
		Stereotype uaInstance = getMatchingStereotype(inst);
		varElement.setValue(uaInstance, "parentNodeId", parent);
		
		// get UML Element of parent to add UAInstance as child
		Class varParent = getUmlNode(inst.getParentNodeId());
		
		EList<Classifier> children = varParent.getNestedClassifiers();
		if(!children.contains(varElement))
		{
			children.add(varElement);
		}
		return true;
	}
	
	private boolean updateOpcUaDatatype(UAVariable var)
	{
		
		Class varElement  = (Class) this.nodeIdMap.get(var.getNodeId());
		Stereotype uaInstance = getMatchingStereotype(var);
		
		Object dataTypeObject = getUmlNodeReference(var.getDataType());
		boolean success = true;
		
		if(dataTypeObject == null)
		{
			success = false;
		}
		else
		{				
			varElement.setValue(uaInstance, "dataType", dataTypeObject);
		}
		
		return success;
	}
	
	private Class getUmlNode(String nodeId)
	{		
		if(nodeId == null || nodeId.length() == 0)
		{
			return null;
		}
		
		if(this.aliasTable.containsKey(nodeId))
		{
			nodeId = this.aliasTable.get(nodeId);
		}
		
		Class umlElement = null;
		if(this.nodeIdMap.containsKey(nodeId))
		{
			umlElement = (Class) this.nodeIdMap.get(nodeId);
		}
		else
		{
			// Element not in nodeId map -> part of imported namespaces 
			if(nodeId.startsWith("ns="))
			{
				// Element part of a namespace
				Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
				Stereotype uaNodeSet  = nodeSetProfile.getOwnedStereotype("UANodeSetType");
				
				EcoreEList<DynamicEObjectImpl> nsList = (EcoreEList<DynamicEObjectImpl>) this.baseUmlModel.getValue(uaNodeSet, "nameSpaceUris");
				int seperator = nodeId.indexOf(";");
				String nameSpaceIdString = nodeId.substring(3, seperator); // ns= is 3 chars long
				int nameSpaceId = Integer.valueOf(nameSpaceIdString);
				DynamicEObjectImpl nsObject = nsList.get(nameSpaceId-1);
				Package namespace = (Package) nsObject.dynamicGet(0); // no features defined -> base package feature id  = 0
				
				loadNamespaceContent(namespace, nameSpaceId);
				if(this.nodeIdMap.containsKey(nodeId))
				{
					umlElement = (Class) this.nodeIdMap.get(nodeId);
				}
			}
			else
			{
				// Element part of namespace 0
				EList<Package> imports = this.baseUmlModel.getImportedPackages();
				
				
				Package defaultNs = null;
				for(Package pack : imports)
				{
					if(pack.getName().equalsIgnoreCase("Opc.Ua.NodeSet2"))
					{
						defaultNs = pack;
						break;
					}
				}
				
				if(defaultNs == null)
				{
					// default namespace needs to be imported
					URI lib_path = URI.createURI(OpcUaLibraryResources.BASENAMESPACE_LIBRARY);
					ResourceSet owner_resource = this.baseUmlModel.eResource().getResourceSet(); 
					defaultNs = PackageUtil.loadPackage(lib_path, owner_resource);
					this.baseUmlModel.createPackageImport(defaultNs);
				}
				
				if(defaultNs != null)
				{
					loadNamespaceContent(defaultNs, 0);
					if(this.nodeIdMap.containsKey(nodeId))
					{
						umlElement = (Class) this.nodeIdMap.get(nodeId);
					}
				}
			}
		}
				
		
		return umlElement;
	}
	
	private void loadNamespaceContent(Package namespace, int namespaceId)
	{
		EList<Element> elements = namespace.allOwnedElements();
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaReferenceType  = nodeSetProfile.getOwnedStereotype("UAReferenceType");
		Stereotype uaDataType  = nodeSetProfile.getOwnedStereotype("UADataType");
		Stereotype uaVariableType  = nodeSetProfile.getOwnedStereotype("UAVariableType");
		Stereotype uaObjectType  = nodeSetProfile.getOwnedStereotype("UAObjectType");
		Stereotype uaView  = nodeSetProfile.getOwnedStereotype("UAView");
		Stereotype uaMethod  = nodeSetProfile.getOwnedStereotype("UAMethod");
		Stereotype uaVariable  = nodeSetProfile.getOwnedStereotype("UAVariable");
		Stereotype uaObject  = nodeSetProfile.getOwnedStereotype("UAObject");
		
		String namespacePrefix = "";
		if(namespaceId > 0)
		{
			namespacePrefix = "ns=" + String.valueOf(namespaceId) + ";";
		}
		for(Element element : elements)
		{
			if(element instanceof Class)
			{
				Class clsElement = (Class) element;
				String nodeId = "";
				if(clsElement.isStereotypeApplied(uaReferenceType))
				{
					nodeId = (String) clsElement.getValue(uaReferenceType, "nodeId");
					this.matching.put(uaObject, new  UAReferenceTypeImpl());
				}
				else if(clsElement.isStereotypeApplied(uaDataType))
				{
					nodeId = (String) clsElement.getValue(uaDataType, "nodeId");
					this.matching.put(uaObject, new  UADataTypeImpl());
				}
				else if(clsElement.isStereotypeApplied(uaVariableType))
				{
					nodeId = (String) clsElement.getValue(uaVariableType, "nodeId");
					this.matching.put(uaObject, new  UAVariableTypeImpl());
				}
				else if(clsElement.isStereotypeApplied(uaObjectType))
				{
					nodeId = (String) clsElement.getValue(uaObjectType, "nodeId");
					this.matching.put(uaObject, new  UAObjectTypeImpl());
				}
				else if(clsElement.isStereotypeApplied(uaView))
				{
					nodeId = (String) clsElement.getValue(uaView, "nodeId");
					this.matching.put(uaObject, new  UAViewImpl());
				}
				else if(clsElement.isStereotypeApplied(uaMethod))
				{
					nodeId = (String) clsElement.getValue(uaMethod, "nodeId");
					this.matching.put(uaObject, new  UAMethodImpl());
				}
				else if(clsElement.isStereotypeApplied(uaVariable))
				{
					nodeId = (String) clsElement.getValue(uaVariable, "nodeId");
					this.matching.put(uaObject, new  UAVariableImpl());
				}
				else if(clsElement.isStereotypeApplied(uaObject))
				{
					nodeId = (String) clsElement.getValue(uaObject, "nodeId");
					this.matching.put(uaObject, new  UAObjectImpl());
				}
				else
				{
					continue;
				}
				
				try
				{
					long value = Long.valueOf(nodeId);
					nodeId = namespacePrefix + "i="+nodeId;
				}
				catch (Exception e) {
					nodeId = namespacePrefix + "s="+nodeId;
				}
				
				this.nodeIdMap.put(nodeId, clsElement);
			}
		}
		return;
	}
	
	private Object getUmlNodeReference(String nodeId)
	{
		Class umlElement = getUmlNode(nodeId);
		if(umlElement == null)
		{
			return null;
		}
		
		for(EObject applEObj : umlElement.getStereotypeApplications())
		{
			DynamicEObjectImpl stereotype = (DynamicEObjectImpl) applEObj;
			String cls = applEObj.eClass().getName();
			if(cls.equalsIgnoreCase("UAReferenceType") || cls.equalsIgnoreCase("UADataType") ||
				cls.equalsIgnoreCase("UAVariableType") ||cls.equalsIgnoreCase("UAObjectType") ||
				cls.equalsIgnoreCase("UAView") ||cls.equalsIgnoreCase("UAMethod") ||
				cls.equalsIgnoreCase("UAVariable") ||cls.equalsIgnoreCase("UAObject") )
			{
				return stereotype;
			}
		}	
		return null;
	}
	
	private boolean updateOpcUaRolePermissions(ArrayList<UANode> rolePermissionNodes) {
		boolean success = true;
				
		for(UANode node : rolePermissionNodes)
		{
			success &= updateOpcUaRolePermission(node);
			if(!success)
			{
				break;
			}
		}
		
		return success;
	}
	
	private boolean updateOpcUaRolePermission(UANode rolePermissionNode) {
		
		Class parent = (Class) getElement(rolePermissionNode);
		Stereotype uaNodeStereotype = getMatchingStereotype(rolePermissionNode);
		Stereotype uaRpStereotype = getMatchingStereotype(new RolePermissionImpl());
		EList<DynamicEObjectImpl> rpList = (EList<DynamicEObjectImpl>) parent.getValue(uaNodeStereotype, "rolePermissions");
		ArrayList<RolePermission> existingRpList = new ArrayList<RolePermission>();
		ArrayList<Class> elementsToDelete = new ArrayList<Class>();
		
		for(DynamicEObjectImpl rpObject : rpList)
		{
			Class rpClass = getStereotypeBaseClass(rpObject, true);
			DynamicEObjectImpl rpValue = (DynamicEObjectImpl) rpClass.getValue(uaRpStereotype, "value");
			if(rpValue == null)
			{
				elementsToDelete.add(rpClass);
				continue;
			}
			Class rpValueClass = getStereotypeBaseClass(rpValue, true);
			String rpValueNodeId = getNodeId(rpValueClass);
			
			boolean exists = false;
			
			for(RolePermission rp : rolePermissionNode.getRolePermissions().getRolePermission())
			{
				if(rp.getValue().equalsIgnoreCase(rpValueNodeId))
				{
					rpClass.setValue(uaRpStereotype, "permissions", rp.getPermissions());
					existingRpList.add(rp);
					exists=true;
					break;
				}				
			}
			
			if(!exists)
			{
				elementsToDelete.add(rpClass);
			}
		}
		
		while(!elementsToDelete.isEmpty())
		{
			elementsToDelete.get(0).destroy();
			elementsToDelete.remove(0);
		}
		
		for(RolePermission rp : rolePermissionNode.getRolePermissions().getRolePermission())
		{
			
			if(!existingRpList.contains(rp))
			{
				Package ns = parent.getNearestPackage();
				Class rpValue = (Class) this.nodeIdMap.get(rp.getValue());
				UANode uaRpValue = (UANode) matching.get(rpValue);
				Stereotype rpValueStereotype = getMatchingStereotype(uaRpValue);
				
				String name = "RolePermissions_"+rpValue.getName();
				
				Class rpClass;
				if(ns == null)
				{
					Model model = parent.getModel();
					rpClass = model.createOwnedClass(name, false);
				}
				else
				{
					rpClass = ns.createOwnedClass(name, false);
				}
				
				parent.getNestedClassifiers().add(rpClass);
				rpClass.applyStereotype(uaRpStereotype);
				rpClass.setValue(uaRpStereotype, "value", rpValue.getStereotypeApplication(rpValueStereotype));
				rpClass.setValue(uaRpStereotype, "permissions", rp.getPermissions());
				
				rpList.add((DynamicEObjectImpl) rpClass.getStereotypeApplication(uaRpStereotype));
			}
			
		}
		
		
		return true;
	}
	
	
	private Stereotype getMatchingStereotype(Object node)
	{
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaInstance = null;
		if(node instanceof UAVariable)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UAVariable");
		}
		else if(node instanceof UAObject)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UAObject");
		}
		else if(node instanceof UAMethod)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UAMethod");
		}
		else if(node instanceof UAView)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UAView");
		}
		else if(node instanceof UADataType)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UADataType");
		}
		else if(node instanceof UAObjectType)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UAObjectType");
		}
		else if(node instanceof UAVariableType)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UAVariableType");
		}
		else if(node instanceof UAReferenceType)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UAReferenceType");
		}
		else if(node instanceof DataTypeDefinition)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("DataTypeDefinition");
		}
		else if(node instanceof DataTypeField)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("DataTypeField");
		}
		else if(node instanceof RolePermission)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("RolePermission");
		}
		else if(node instanceof UAMethodArgument)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UAMethodArgument");
		}
		
		return uaInstance;
	}
	
	private Stereotype getMatchingStereotype(Class node)
	{
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaReferenceType  = nodeSetProfile.getOwnedStereotype("UAReferenceType");
		Stereotype uaDataType  = nodeSetProfile.getOwnedStereotype("UADataType");
		Stereotype uaVariableType  = nodeSetProfile.getOwnedStereotype("UAVariableType");
		Stereotype uaObjectType  = nodeSetProfile.getOwnedStereotype("UAObjectType");
		Stereotype uaView  = nodeSetProfile.getOwnedStereotype("UAView");
		Stereotype uaMethod  = nodeSetProfile.getOwnedStereotype("UAMethod");
		Stereotype uaVariable  = nodeSetProfile.getOwnedStereotype("UAVariable");
		Stereotype uaObject  = nodeSetProfile.getOwnedStereotype("UAObject");
		
		Stereotype return_val;
		 
		if(node.isStereotypeApplied(uaReferenceType))
		{
			return_val = uaReferenceType;
		}
		else if(node.isStereotypeApplied(uaDataType))
		{
			return_val = uaDataType;
		}
		else if(node.isStereotypeApplied(uaVariableType))
		{
			return_val = uaVariableType;
		}
		else if(node.isStereotypeApplied(uaObjectType))
		{
			return_val = uaObjectType;
		}
		else if(node.isStereotypeApplied(uaView))
		{
			return_val = uaView;
		}
		else if(node.isStereotypeApplied(uaMethod))
		{
			return_val = uaMethod;
		}
		else if(node.isStereotypeApplied(uaVariable))
		{
			return_val = uaVariable;
		}
		else if(node.isStereotypeApplied(uaObject))
		{
			return_val = uaObject;
		}
		else
		{
			return_val = null;
		}
			
		
		return return_val;
	}
	
	
	private Class getStereotypeBaseClass(DynamicEObjectImpl eObject, boolean addIfNotExists)
	{
		Class baseClass = null;
		EList<EStructuralFeature> featuresList2 = eObject.eClass().getEAllStructuralFeatures();
		for(EStructuralFeature feature2 : featuresList2)
		{
			int id2 = feature2.getFeatureID();
			String name2 = feature2.getName();
			if(name2.equalsIgnoreCase("base_Class"))
			{
				baseClass= (Class)eObject.dynamicGet(id2);
								
				if(!this.matching.containsKey(baseClass) && addIfNotExists &&
					this.baseUmlModel.equals(baseClass.getModel()))
				{
					transformClass(baseClass);
				}

				break;
			}
		}
		
		return baseClass;
	}
	
	private String getNodeId(Class umlUaNode)
	{
		String nodeId = "";
		
		Package namespace = umlUaNode.getNearestPackage();
		Stereotype uaStereotype;
		
		if(this.baseUmlModel.equals(umlUaNode.getModel()))
		{				
			if(!this.matching.containsKey(umlUaNode))
			{				
				transformClass(umlUaNode);
			}
			uaStereotype = getMatchingStereotype(this.matching.get(umlUaNode));
		}
		else
		{
			// the other method is faster, therefore it should be used by default
			uaStereotype = getMatchingStereotype(umlUaNode);
		}
		
		if(umlUaNode.hasValue(uaStereotype, "nodeId"))
		{
			nodeId = (String) umlUaNode.getValue(uaStereotype, "nodeId");
			
			if(PreferenceProvider.getNodeIdSchema().equalsIgnoreCase("auto"))
			{				
				try {
					double d = Double.parseDouble(nodeId);
					nodeId = "i=" + nodeId;
				} catch (NumberFormatException nfe) {
					nodeId = "s=" + nodeId;
				}
			}
			// other option is string
			else
			{
				nodeId = "s=" + nodeId;
			}
			
			if(namespace != null && namespace.getURI() != null)
			{
				if(this.baseNodeset.getNamespaceUris() == null)
				{
					this.baseNodeset.setNamespaceUris(new UriTableImpl());
				}
				
				if(!this.baseNodeset.getNamespaceUris().getUri().contains(namespace.getURI()))
				{
					this.baseNodeset.getNamespaceUris().getUri().add(namespace.getURI());
				}
				
				int namespaceId = this.baseNodeset.getNamespaceUris().getUri().indexOf(namespace.getURI());
				namespaceId++; // arrays start at 0
				nodeId = "ns=" +String.valueOf(namespaceId) + ";" +nodeId;
			}
		}
		return nodeId;
	}

}
