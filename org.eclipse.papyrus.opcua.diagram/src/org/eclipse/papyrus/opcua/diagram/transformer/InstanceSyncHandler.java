package org.eclipse.papyrus.opcua.diagram.transformer;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.EEnumLiteralImpl;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.papyrus.designer.languages.common.base.HierarchyLocationStrategy;
import org.eclipse.papyrus.designer.languages.common.base.ILocationStrategy;
import org.eclipse.papyrus.infra.tools.file.IPFileSystemAccess;
import org.eclipse.papyrus.infra.tools.file.ProjectBasedFileAccess;
import org.eclipse.papyrus.opcua.nodeset.parser.NodeSetReader;
import org.eclipse.papyrus.opcua.nodeset.parser.NodeSetWriter;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Model;
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
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANode;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObject;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObjectType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAReferenceType;
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
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAMethodImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UANodeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAObjectImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAObjectTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAReferenceTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAVariableImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAVariableTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UriTableImpl;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

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
		ILocationStrategy locStrategy =  new HierarchyLocationStrategy();
		// get container for the current element
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
		
		NodeSetWriter docWriter = new NodeSetWriter(doc); 
		docWriter.convertToXml(this.baseNodeset);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transf;
		try {
			transf = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
        
        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transf.setOutputProperty(OutputKeys.INDENT, "yes");
        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
       
        StringWriter writer = new StringWriter();
        StreamResult streamResult = new StreamResult(writer);
        		
        DOMSource source = new DOMSource(doc);
        try {
			transf.transform(source, streamResult);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//output.concat(OpcUaPackageHeaderGenerator.generateCode(pack).toString());
		fileSystemAccess.generateFile("InformationModel.xml", writer.toString());
		return true;
	}
	public boolean readToNodeSetFile(File filepath) throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(filepath);
		document.getDocumentElement().normalize();
		NodeSetReader reader = new NodeSetReader(document);
		
		UANodeSetType nodeSet = reader.readNodeSet();
		
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
			return_val= updateClass((Class) object);
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
	
	private boolean updateClass(Class object)
	{
		EList<EObject> stereotype_applications = object.getStereotypeApplications();
		EList<Classifier> par = object.parents();
		
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
			
			if(name.equals("uri"))
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
		return false;
		
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
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			
			if(temp == null)
			{
				continue;
			}
			
			if(name.equals("displayName"))
			{
				uaVarType.getDisplayName().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaVarType.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaVarType.getDisplayName().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("description"))
			{
				uaVarType.getDescription().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					//transformNodeIdAlias(aliasUML);
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaVarType.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaVarType.getDescription().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("category"))
			{
				List<String> categories = (List<String>) temp;
				uaVarType.getCategory().clear();
				uaVarType.getCategory().addAll(categories);
			}
			else if(name.equals("documentation"))
			{
				List<String> documentation = (List<String>) temp;
				uaVarType.getCategory().clear();
				uaVarType.getCategory().addAll(documentation);
			}
			else if(name.equals("references"))
			{
				System.out.println(name);
			}
			else if(name.equals("rolePermissions"))
			{
				Object rp_object = ((DynamicEObjectImpl) temp).getClass();
				if(this.matching.containsKey(rp_object))
				{
					ListOfRolePermissions rp = (ListOfRolePermissions) this.matching.get(rp_object);
					uaVarType.setRolePermissions(rp);
				}
			}
			else if(name.equals("extensions"))
			{
				System.out.println(name);
			}
			else if(name.equals("accessRestrictions"))
			{
				String stringToConvert = String.valueOf(temp);
				short convertedShort = Short.parseShort(stringToConvert);
				uaVarType.setAccessRestrictions(convertedShort);
				
			}
			else if(name.equals("browseName"))
			{
				String browseNameString = (String) temp;
				
				if(!browseNameString.startsWith("1:"))
				{					
					browseNameString = "1:"+browseNameString;
					stereotype.dynamicSet(id, browseNameString);
				}
				
				uaVarType.setNodeId(browseNameString);
				
			}
			else if(name.equals("nodeId"))
			{
				String nodeIdString = (String) temp;
				
				if(!((nodeIdString.startsWith("ns=") || nodeIdString.startsWith("i=")) || nodeIdString.startsWith("i=")))
				{					
					nodeIdString = "ns=1;s="+nodeIdString;
					stereotype.dynamicSet(id, nodeIdString);
				}
				
				uaVarType.setNodeId(nodeIdString);
			}
			else if(name.equals("releaseStatus"))
			{
				EEnumLiteralImpl lit = (EEnumLiteralImpl) temp;
				String value = lit.toString();
				switch(value)
				{
				case "Draft":
					uaVarType.setReleaseStatus(ReleaseStatus.DRAFT);
					break;
				case "Released":
					uaVarType.setReleaseStatus(ReleaseStatus.RELEASED);
					break;
				case "Deprecated":
					uaVarType.setReleaseStatus(ReleaseStatus.DEPRECATED);
					break;
				}
			}
			else if(name.equals("symbolicName"))
			{
				List<String> symbolicName = (List<String>) temp;
				uaVarType.getCategory().clear();
				uaVarType.getCategory().addAll(symbolicName);
			}
			else if(name.equals("userWriteMask"))
			{
				String stringToConvert = String.valueOf(temp);
		        Long convertedLong = Long.parseLong(stringToConvert);
				uaVarType.setUserWriteMask(convertedLong);
			}
			else if(name.equals("writeMask"))
			{
				String stringToConvert = String.valueOf(temp);
				Long convertedLong = Long.parseLong(stringToConvert);
				uaVarType.setWriteMask(convertedLong);
			}			
		}

		return true;
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
		
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			if(temp == null)
			{
				continue;
			}
			
			if(name.equals("displayName"))
			{
				uaVariable.getDisplayName().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaVariable.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaVariable.getDisplayName().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("description"))
			{
				uaVariable.getDescription().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					//transformNodeIdAlias(aliasUML);
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaVariable.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaVariable.getDescription().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("category"))
			{
				List<String> categories = (List<String>) temp;
				uaVariable.getCategory().clear();
				uaVariable.getCategory().addAll(categories);
			}
			else if(name.equals("documentation"))
			{
				List<String> documentation = (List<String>) temp;
				uaVariable.getCategory().clear();
				uaVariable.getCategory().addAll(documentation);
			}
			else if(name.equals("references"))
			{
				System.out.println(name);
			}
			else if(name.equals("rolePermissions"))
			{
				Object rp_object = ((DynamicEObjectImpl) temp).getClass();
				if(this.matching.containsKey(rp_object))
				{
					ListOfRolePermissions rp = (ListOfRolePermissions) this.matching.get(rp_object);
					uaVariable.setRolePermissions(rp);
				}
			}
			else if(name.equals("extensions"))
			{
				System.out.println(name);
			}
			else if(name.equals("accessRestrictions"))
			{
				String stringToConvert = String.valueOf(temp);
				short convertedShort = Short.parseShort(stringToConvert);
				uaVariable.setAccessRestrictions(convertedShort);
				
			}
			else if(name.equals("browseName"))
			{
				String browseNameString = (String) temp;
				
				if(!browseNameString.startsWith("1:"))
				{					
					browseNameString = "1:"+browseNameString;
					stereotype.dynamicSet(id, browseNameString);
				}
				
				uaVariable.setNodeId(browseNameString);
				
			}
			else if(name.equals("nodeId"))
			{
				String nodeIdString = (String) temp;
				
				if(!(nodeIdString.startsWith("ns=") || nodeIdString.startsWith("i=")))
				{					
					nodeIdString = "ns=1;s="+nodeIdString;
					stereotype.dynamicSet(id, nodeIdString);
				}
				
				uaVariable.setNodeId(nodeIdString);
			}
			else if(name.equals("releaseStatus"))
			{
				EEnumLiteralImpl lit = (EEnumLiteralImpl) temp;
				String value = lit.toString();
				switch(value)
				{
				case "Draft":
					uaVariable.setReleaseStatus(ReleaseStatus.DRAFT);
					break;
				case "Released":
					uaVariable.setReleaseStatus(ReleaseStatus.RELEASED);
					break;
				case "Deprecated":
					uaVariable.setReleaseStatus(ReleaseStatus.DEPRECATED);
					break;
				}
			}
			else if(name.equals("symbolicName"))
			{
				List<String> symbolicName = (List<String>) temp;
				uaVariable.getCategory().clear();
				uaVariable.getCategory().addAll(symbolicName);
			}
			else if(name.equals("userWriteMask"))
			{
				String stringToConvert = String.valueOf(temp);
		        Long convertedLong = Long.parseLong(stringToConvert);
				uaVariable.setUserWriteMask(convertedLong);
			}
			else if(name.equals("writeMask"))
			{
				String stringToConvert = String.valueOf(temp);
				Long convertedLong = Long.parseLong(stringToConvert);
				uaVariable.setWriteMask(convertedLong);
			}
			else if(name.equals("value"))
			{
				String test ="asdfSA";
			}
			else if(name.equals("translation"))
			{
				String test ="asdfSA";
			}
			else if(name.equals("accessLevel"))
			{
				String stringToConvert = String.valueOf(temp);
				Long convertedLong = Long.parseLong(stringToConvert);
				uaVariable.setAccessLevel(convertedLong);
			}
			else if(name.equals("arrayDimensions"))
			{
				uaVariable.setArrayDimensions(String.valueOf(temp));
			}
			else if(name.equals("dataType"))
			{
				String nodeIdString = (String) temp;
				uaVariable.setDataType(nodeIdString);
			}
			else if(name.equals("historizing"))
			{
				String stringToConvert = String.valueOf(temp);
				boolean convertedBoolean = Boolean.parseBoolean(stringToConvert);
				uaVariable.setHistorizing(convertedBoolean);
			}
			else if(name.equals("minimumSamplingInterval"))
			{
				double intervall = (double ) temp;
				uaVariable.setMinimumSamplingInterval(intervall);
			}
			else if(name.equals("userAccessLevel"))
			{
				String stringToConvert = String.valueOf(temp);
				Long convertedLong = Long.parseLong(stringToConvert);
				uaVariable.setUserAccessLevel(convertedLong);
			}
			else if(name.equals("valueRank"))
			{
				String stringToConvert = String.valueOf(temp);
				int convertedInt = Integer.parseInt(stringToConvert);
				uaVariable.setValueRank(convertedInt);
			}
		}

		return true;
	}

	private boolean transformUAType(Class object,  DynamicEObjectImpl stereotype) {
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
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			if(temp == null)
			{
				continue;
			}
			
			if(name.equals("displayName"))
			{
				uaObjType.getDisplayName().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaObjType.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaObjType.getDisplayName().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("description"))
			{
				uaObjType.getDescription().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					//transformNodeIdAlias(aliasUML);
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaObjType.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaObjType.getDescription().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("category"))
			{
				List<String> categories = (List<String>) temp;
				uaObjType.getCategory().clear();
				uaObjType.getCategory().addAll(categories);
			}
			else if(name.equals("documentation"))
			{
				List<String> documentation = (List<String>) temp;
				uaObjType.getCategory().clear();
				uaObjType.getCategory().addAll(documentation);
			}
			else if(name.equals("references"))
			{
				System.out.println(name);
			}
			else if(name.equals("rolePermissions"))
			{
				Object rp_object = ((DynamicEObjectImpl) temp).getClass();
				if(this.matching.containsKey(rp_object))
				{
					ListOfRolePermissions rp = (ListOfRolePermissions) this.matching.get(rp_object);
					uaObjType.setRolePermissions(rp);
				}
			}
			else if(name.equals("extensions"))
			{
				System.out.println(name);
			}
			else if(name.equals("accessRestrictions"))
			{
				String stringToConvert = String.valueOf(temp);
				short convertedShort = Short.parseShort(stringToConvert);
				uaObjType.setAccessRestrictions(convertedShort);
				
			}
			else if(name.equals("browseName"))
			{
				String browseNameString = (String) temp;
				
				if(!browseNameString.startsWith("1:"))
				{					
					browseNameString = "1:"+browseNameString;
					stereotype.dynamicSet(id, browseNameString);
				}
				
				uaObjType.setNodeId(browseNameString);
				
			}
			else if(name.equals("nodeId"))
			{
				String nodeIdString = (String) temp;
				
				if(!(nodeIdString.startsWith("ns=") || nodeIdString.startsWith("i=")))
				{					
					nodeIdString = "ns=1;s="+nodeIdString;
					stereotype.dynamicSet(id, nodeIdString);
				}
				
				uaObjType.setNodeId(nodeIdString);
			}
			else if(name.equals("releaseStatus"))
			{
				EEnumLiteralImpl lit = (EEnumLiteralImpl) temp;
				String value = lit.toString();
				switch(value)
				{
				case "Draft":
					uaObjType.setReleaseStatus(ReleaseStatus.DRAFT);
					break;
				case "Released":
					uaObjType.setReleaseStatus(ReleaseStatus.RELEASED);
					break;
				case "Deprecated":
					uaObjType.setReleaseStatus(ReleaseStatus.DEPRECATED);
					break;
				}
			}
			else if(name.equals("symbolicName"))
			{
				List<String> symbolicName = (List<String>) temp;
				uaObjType.getCategory().clear();
				uaObjType.getCategory().addAll(symbolicName);
			}
			else if(name.equals("userWriteMask"))
			{
				String stringToConvert = String.valueOf(temp);
		        Long convertedLong = Long.parseLong(stringToConvert);
				uaObjType.setUserWriteMask(convertedLong);
			}
			else if(name.equals("writeMask"))
			{
				String stringToConvert = String.valueOf(temp);
				Long convertedLong = Long.parseLong(stringToConvert);
				uaObjType.setWriteMask(convertedLong);
			}			
		}
		
		return true;
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
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			if(temp == null)
			{
				continue;
			}
			
			if(name.equals("displayName"))
			{
				uaRefType.getDisplayName().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaRefType.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaRefType.getDisplayName().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("description"))
			{
				uaRefType.getDescription().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					//transformNodeIdAlias(aliasUML);
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaRefType.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaRefType.getDescription().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("category"))
			{
				List<String> categories = (List<String>) temp;
				uaRefType.getCategory().clear();
				uaRefType.getCategory().addAll(categories);
			}
			else if(name.equals("documentation"))
			{
				List<String> documentation = (List<String>) temp;
				uaRefType.getCategory().clear();
				uaRefType.getCategory().addAll(documentation);
			}
			else if(name.equals("references"))
			{
				System.out.println(name);
			}
			else if(name.equals("rolePermissions"))
			{
				Object rp_object = ((DynamicEObjectImpl) temp).getClass();
				if(this.matching.containsKey(rp_object))
				{
					ListOfRolePermissions rp = (ListOfRolePermissions) this.matching.get(rp_object);
					uaRefType.setRolePermissions(rp);
				}
			}
			else if(name.equals("extensions"))
			{
				System.out.println(name);
			}
			else if(name.equals("accessRestrictions"))
			{
				String stringToConvert = String.valueOf(temp);
				short convertedShort = Short.parseShort(stringToConvert);
				uaRefType.setAccessRestrictions(convertedShort);
				
			}
			else if(name.equals("browseName"))
			{
				String browseNameString = (String) temp;
				
				if(!browseNameString.startsWith("1:"))
				{					
					browseNameString = "1:"+browseNameString;
					stereotype.dynamicSet(id, browseNameString);
				}
				
				uaRefType.setNodeId(browseNameString);
				
			}
			else if(name.equals("nodeId"))
			{
				String nodeIdString = (String) temp;
				
				if(!(nodeIdString.startsWith("ns=") || nodeIdString.startsWith("i=")))
				{					
					nodeIdString = "ns=1;s="+nodeIdString;
					stereotype.dynamicSet(id, nodeIdString);
				}
				
				uaRefType.setNodeId(nodeIdString);
			}
			else if(name.equals("releaseStatus"))
			{
				EEnumLiteralImpl lit = (EEnumLiteralImpl) temp;
				String value = lit.toString();
				switch(value)
				{
				case "Draft":
					uaRefType.setReleaseStatus(ReleaseStatus.DRAFT);
					break;
				case "Released":
					uaRefType.setReleaseStatus(ReleaseStatus.RELEASED);
					break;
				case "Deprecated":
					uaRefType.setReleaseStatus(ReleaseStatus.DEPRECATED);
					break;
				}
			}
			else if(name.equals("symbolicName"))
			{
				List<String> symbolicName = (List<String>) temp;
				uaRefType.getCategory().clear();
				uaRefType.getCategory().addAll(symbolicName);
			}
			else if(name.equals("userWriteMask"))
			{
				String stringToConvert = String.valueOf(temp);
		        Long convertedLong = Long.parseLong(stringToConvert);
				uaRefType.setUserWriteMask(convertedLong);
			}
			else if(name.equals("writeMask"))
			{
				String stringToConvert = String.valueOf(temp);
				Long convertedLong = Long.parseLong(stringToConvert);
				uaRefType.setWriteMask(convertedLong);
			}	
			else if(name.equals("inverseName"))
			{
				
			}
			else if(name.equals("symmetric"))
			{
				
			}
		}	
		

		return true;
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
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			if(temp == null)
			{
				continue;
			}
			
			if(name.equals("displayName"))
			{
				uaObjType.getDisplayName().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaObjType.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaObjType.getDisplayName().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("description"))
			{
				uaObjType.getDescription().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					//transformNodeIdAlias(aliasUML);
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaObjType.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaObjType.getDescription().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("category"))
			{
				List<String> categories = (List<String>) temp;
				uaObjType.getCategory().clear();
				uaObjType.getCategory().addAll(categories);
			}
			else if(name.equals("documentation"))
			{
				List<String> documentation = (List<String>) temp;
				uaObjType.getCategory().clear();
				uaObjType.getCategory().addAll(documentation);
			}
			else if(name.equals("references"))
			{
				System.out.println(name);
			}
			else if(name.equals("rolePermissions"))
			{
				Object rp_object = ((DynamicEObjectImpl) temp).getClass();
				if(this.matching.containsKey(rp_object))
				{
					ListOfRolePermissions rp = (ListOfRolePermissions) this.matching.get(rp_object);
					uaObjType.setRolePermissions(rp);
				}
			}
			else if(name.equals("extensions"))
			{
				System.out.println(name);
			}
			else if(name.equals("accessRestrictions"))
			{
				String stringToConvert = String.valueOf(temp);
				short convertedShort = Short.parseShort(stringToConvert);
				uaObjType.setAccessRestrictions(convertedShort);
				
			}
			else if(name.equals("browseName"))
			{
				String browseNameString = (String) temp;
				
				if(!browseNameString.startsWith("1:"))
				{					
					browseNameString = "1:"+browseNameString;
					stereotype.dynamicSet(id, browseNameString);
				}
				
				uaObjType.setBrowseName(browseNameString);
				
			}
			else if(name.equals("nodeId"))
			{
				String nodeIdString = (String) temp;
				
				if(!(nodeIdString.startsWith("ns=") || nodeIdString.startsWith("i=")))
				{					
					nodeIdString = "ns=1;s="+nodeIdString;
					stereotype.dynamicSet(id, nodeIdString);
				}
				
				uaObjType.setNodeId(nodeIdString);
			}
			else if(name.equals("releaseStatus"))
			{
				EEnumLiteralImpl lit = (EEnumLiteralImpl) temp;
				String value = lit.toString();
				switch(value)
				{
				case "Draft":
					uaObjType.setReleaseStatus(ReleaseStatus.DRAFT);
					break;
				case "Released":
					uaObjType.setReleaseStatus(ReleaseStatus.RELEASED);
					break;
				case "Deprecated":
					uaObjType.setReleaseStatus(ReleaseStatus.DEPRECATED);
					break;
				}
			}
			else if(name.equals("symbolicName"))
			{
				List<String> symbolicName = (List<String>) temp;
				uaObjType.getCategory().clear();
				uaObjType.getCategory().addAll(symbolicName);
			}
			else if(name.equals("userWriteMask"))
			{
				String stringToConvert = String.valueOf(temp);
		        Long convertedLong = Long.parseLong(stringToConvert);
				uaObjType.setUserWriteMask(convertedLong);
			}
			else if(name.equals("writeMask"))
			{
				String stringToConvert = String.valueOf(temp);
				Long convertedLong = Long.parseLong(stringToConvert);
				uaObjType.setWriteMask(convertedLong);
			}			
		}
		
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
		return true;
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
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			if(temp == null)
			{
				continue;
			}
			
			if(name.equals("displayName"))
			{
				uaObject.getDisplayName().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaObject.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaObject.getDisplayName().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("description"))
			{
				uaObject.getDescription().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					//transformNodeIdAlias(aliasUML);
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaObject.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaObject.getDescription().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("category"))
			{
				List<String> categories = (List<String>) temp;
				uaObject.getCategory().clear();
				uaObject.getCategory().addAll(categories);
			}
			else if(name.equals("documentation"))
			{
				List<String> documentation = (List<String>) temp;
				uaObject.getCategory().clear();
				uaObject.getCategory().addAll(documentation);
			}
			else if(name.equals("references"))
			{
				System.out.println(name);
			}
			else if(name.equals("rolePermissions"))
			{
				Object rp_object = ((DynamicEObjectImpl) temp).getClass();
				if(this.matching.containsKey(rp_object))
				{
					ListOfRolePermissions rp = (ListOfRolePermissions) this.matching.get(rp_object);
					uaObject.setRolePermissions(rp);
				}
			}
			else if(name.equals("extensions"))
			{
				System.out.println(name);
			}
			else if(name.equals("accessRestrictions"))
			{
				String stringToConvert = String.valueOf(temp);
				short convertedShort = Short.parseShort(stringToConvert);
				uaObject.setAccessRestrictions(convertedShort);
				
			}
			else if(name.equals("browseName"))
			{
				String browseNameString = (String) temp;
				
				if(!browseNameString.startsWith("1:"))
				{					
					browseNameString = "1:"+browseNameString;
					stereotype.dynamicSet(id, browseNameString);
				}
				
				uaObject.setNodeId(browseNameString);
				
			}
			else if(name.equals("nodeId"))
			{
				String nodeIdString = (String) temp;
				
				if(!(nodeIdString.startsWith("ns=") || nodeIdString.startsWith("i=")))
				{					
					nodeIdString = "ns=1;s="+nodeIdString;
					stereotype.dynamicSet(id, nodeIdString);
				}
				
				uaObject.setNodeId(nodeIdString);
			}
			else if(name.equals("releaseStatus"))
			{
				EEnumLiteralImpl lit = (EEnumLiteralImpl) temp;
				String value = lit.toString();
				switch(value)
				{
				case "Draft":
					uaObject.setReleaseStatus(ReleaseStatus.DRAFT);
					break;
				case "Released":
					uaObject.setReleaseStatus(ReleaseStatus.RELEASED);
					break;
				case "Deprecated":
					uaObject.setReleaseStatus(ReleaseStatus.DEPRECATED);
					break;
				}
			}
			else if(name.equals("symbolicName"))
			{
				List<String> symbolicName = (List<String>) temp;
				uaObject.getCategory().clear();
				uaObject.getCategory().addAll(symbolicName);
			}
			else if(name.equals("userWriteMask"))
			{
				String stringToConvert = String.valueOf(temp);
		        Long convertedLong = Long.parseLong(stringToConvert);
				uaObject.setUserWriteMask(convertedLong);
			}
			else if(name.equals("writeMask"))
			{
				String stringToConvert = String.valueOf(temp);
				Long convertedLong = Long.parseLong(stringToConvert);
				uaObject.setWriteMask(convertedLong);
			}			
		}
		

		return true;
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
			
			if(name.equals("nameSpaceUris"))
			{
				if(temp == null)
				{
					Stereotype uriTableType  = nodeSetProfile.getOwnedStereotype("UriTable");
					Class namespaceUriTable = this.baseUmlModel.createOwnedClass("NameSpaces", false);
					namespaceUriTable.applyStereotype(uriTableType);
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
					if(name2.equals("base_Class"))
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
			else if(name.equals("serverUris"))
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
					if(name2.equals("base_Class"))
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
			else if(name.equals("models"))
			{
				if(temp == null)
				{
					continue;
				}
			}
			else if(name.equals("aliases"))
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
					if(name2.equals("base_Class"))
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
			else if(name.equals("extensions"))
			{
				if(temp == null)
				{
					continue;
				}
				
				
			}
			else if(name.equals("group"))
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
			
			if(name.equals("displayName"))
			{
				uanode.getDisplayName().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uanode.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uanode.getDisplayName().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("description"))
			{
				uanode.getDescription().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					//transformNodeIdAlias(aliasUML);
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uanode.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uanode.getDescription().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("category"))
			{
				List<String> categories = (List<String>) temp;
				uanode.getCategory().clear();
				uanode.getCategory().addAll(categories);
			}
			else if(name.equals("documentation"))
			{
				List<String> documentation = (List<String>) temp;
				uanode.getCategory().clear();
				uanode.getCategory().addAll(documentation);
			}
			else if(name.equals("references"))
			{
				System.out.println(name);
			}
			else if(name.equals("rolePermissions"))
			{
				Object rp_object = ((DynamicEObjectImpl) temp).getClass();
				if(this.matching.containsKey(rp_object))
				{
					ListOfRolePermissions rp = (ListOfRolePermissions) this.matching.get(rp_object);
					uanode.setRolePermissions(rp);
				}
			}
			else if(name.equals("extensions"))
			{
				System.out.println(name);
			}
			else if(name.equals("accessRestrictions"))
			{
				String stringToConvert = String.valueOf(temp);
				short convertedShort = Short.parseShort(stringToConvert);
				uanode.setAccessRestrictions(convertedShort);
				
			}
			else if(name.equals("browseName"))
			{
				String browseNameString = (String) temp;
				
				if(!browseNameString.startsWith("1:"))
				{					
					browseNameString = "1:"+browseNameString;
					stereotype.dynamicSet(id, browseNameString);
				}
				
				uanode.setNodeId(browseNameString);
				
			}
			else if(name.equals("nodeId"))
			{
				String nodeIdString = (String) temp;
				
				if(!(nodeIdString.startsWith("ns=") || nodeIdString.startsWith("i=")))
				{					
					nodeIdString = "ns=1;s="+nodeIdString;
					stereotype.dynamicSet(id, nodeIdString);
				}
				
				uanode.setNodeId(nodeIdString);
			}
			else if(name.equals("releaseStatus"))
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
			else if(name.equals("symbolicName"))
			{
				List<String> symbolicName = (List<String>) temp;
				uanode.getCategory().clear();
				uanode.getCategory().addAll(symbolicName);
			}
			else if(name.equals("userWriteMask"))
			{
				String stringToConvert = String.valueOf(temp);
		        Long convertedLong = Long.parseLong(stringToConvert);
				uanode.setUserWriteMask(convertedLong);
			}
			else if(name.equals("writeMask"))
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
		
		UAMethodImpl uaVariable;
		if(this.matching.containsKey(object))
		{
			uaVariable = (UAMethodImpl) this.matching.get(object);
		}
		else
		{
			uaVariable = new UAMethodImpl();
			this.matching.put(object, uaVariable);
			this.baseNodeset.getUAMethod().add(uaVariable);
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
			
			if(name.equals("displayName"))
			{
				uaVariable.getDisplayName().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaVariable.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaVariable.getDisplayName().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("description"))
			{
				uaVariable.getDescription().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					//transformNodeIdAlias(aliasUML);
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaVariable.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaVariable.getDescription().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("category"))
			{
				List<String> categories = (List<String>) temp;
				uaVariable.getCategory().clear();
				uaVariable.getCategory().addAll(categories);
			}
			else if(name.equals("documentation"))
			{
				List<String> documentation = (List<String>) temp;
				uaVariable.getCategory().clear();
				uaVariable.getCategory().addAll(documentation);
			}
			else if(name.equals("references"))
			{
				System.out.println(name);
			}
			else if(name.equals("rolePermissions"))
			{
				Object rp_object = ((DynamicEObjectImpl) temp).getClass();
				if(this.matching.containsKey(rp_object))
				{
					ListOfRolePermissions rp = (ListOfRolePermissions) this.matching.get(rp_object);
					uaVariable.setRolePermissions(rp);
				}
			}
			else if(name.equals("extensions"))
			{
				System.out.println(name);
			}
			else if(name.equals("accessRestrictions"))
			{
				String stringToConvert = String.valueOf(temp);
				short convertedShort = Short.parseShort(stringToConvert);
				uaVariable.setAccessRestrictions(convertedShort);
				
			}
			else if(name.equals("browseName"))
			{
				String browseNameString = (String) temp;
				
				if(!browseNameString.startsWith("1:"))
				{					
					browseNameString = "1:"+browseNameString;
					stereotype.dynamicSet(id, browseNameString);
				}
				
				uaVariable.setNodeId(browseNameString);
				
			}
			else if(name.equals("nodeId"))
			{
				String nodeIdString = (String) temp;
				
				if(!(nodeIdString.startsWith("ns=") || nodeIdString.startsWith("i=")))
				{					
					nodeIdString = "ns=1;s="+nodeIdString;
					stereotype.dynamicSet(id, nodeIdString);
				}
				
				uaVariable.setNodeId(nodeIdString);
			}
			else if(name.equals("releaseStatus"))
			{
				EEnumLiteralImpl lit = (EEnumLiteralImpl) temp;
				String value = lit.toString();
				switch(value)
				{
				case "Draft":
					uaVariable.setReleaseStatus(ReleaseStatus.DRAFT);
					break;
				case "Released":
					uaVariable.setReleaseStatus(ReleaseStatus.RELEASED);
					break;
				case "Deprecated":
					uaVariable.setReleaseStatus(ReleaseStatus.DEPRECATED);
					break;
				}
			}
			else if(name.equals("symbolicName"))
			{
				List<String> symbolicName = (List<String>) temp;
				uaVariable.getCategory().clear();
				uaVariable.getCategory().addAll(symbolicName);
			}
			else if(name.equals("userWriteMask"))
			{
				String stringToConvert = String.valueOf(temp);
		        Long convertedLong = Long.parseLong(stringToConvert);
				uaVariable.setUserWriteMask(convertedLong);
			}
			else if(name.equals("writeMask"))
			{
				String stringToConvert = String.valueOf(temp);
				Long convertedLong = Long.parseLong(stringToConvert);
				uaVariable.setWriteMask(convertedLong);
			}
		}
		

		return true;
	}

	private boolean transformUAInstance(Class object,  DynamicEObjectImpl stereotype) {
		EList<EStructuralFeature> featuresList = stereotype.eClass().getEAllStructuralFeatures();
		return false;
		
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
		
		for(EStructuralFeature feature : featuresList)
		{
			int id = feature.getFeatureID();
			String name = feature.getName();
			Object temp = stereotype.dynamicGet(id);
			if(temp == null)
			{
				continue;
			}
			
			if(name.equals("displayName"))
			{
				uaDataType.getDisplayName().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaDataType.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaDataType.getDisplayName().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("description"))
			{
				uaDataType.getDescription().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					//transformNodeIdAlias(aliasUML);
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaDataType.getDisplayName().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								uaDataType.getDescription().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("category"))
			{
				List<String> categories = (List<String>) temp;
				uaDataType.getCategory().clear();
				uaDataType.getCategory().addAll(categories);
			}
			else if(name.equals("documentation"))
			{
				List<String> documentation = (List<String>) temp;
				uaDataType.getCategory().clear();
				uaDataType.getCategory().addAll(documentation);
			}
			else if(name.equals("references"))
			{
				System.out.println(name);
			}
			else if(name.equals("rolePermissions"))
			{
				Object rp_object = ((DynamicEObjectImpl) temp).getClass();
				if(this.matching.containsKey(rp_object))
				{
					ListOfRolePermissions rp = (ListOfRolePermissions) this.matching.get(rp_object);
					uaDataType.setRolePermissions(rp);
				}
			}
			else if(name.equals("extensions"))
			{
				System.out.println(name);
			}
			else if(name.equals("accessRestrictions"))
			{
				String stringToConvert = String.valueOf(temp);
				short convertedShort = Short.parseShort(stringToConvert);
				uaDataType.setAccessRestrictions(convertedShort);
				
			}
			else if(name.equals("browseName"))
			{
				String browseNameString = (String) temp;
				
				if(!browseNameString.startsWith("1:"))
				{					
					browseNameString = "1:"+browseNameString;
					stereotype.dynamicSet(id, browseNameString);
				}
				
				uaDataType.setNodeId(browseNameString);
				
			}
			else if(name.equals("nodeId"))
			{
				String nodeIdString = (String) temp;
				
				if(!(nodeIdString.startsWith("ns=") || nodeIdString.startsWith("i=")))
				{					
					nodeIdString = "ns=1;s="+nodeIdString;
					stereotype.dynamicSet(id, nodeIdString);
				}
				
				uaDataType.setNodeId(nodeIdString);
			}
			else if(name.equals("releaseStatus"))
			{
				EEnumLiteralImpl lit = (EEnumLiteralImpl) temp;
				String value = lit.toString();
				switch(value)
				{
				case "Draft":
					uaDataType.setReleaseStatus(ReleaseStatus.DRAFT);
					break;
				case "Released":
					uaDataType.setReleaseStatus(ReleaseStatus.RELEASED);
					break;
				case "Deprecated":
					uaDataType.setReleaseStatus(ReleaseStatus.DEPRECATED);
					break;
				}
			}
			else if(name.equals("symbolicName"))
			{
				List<String> symbolicName = (List<String>) temp;
				uaDataType.getCategory().clear();
				uaDataType.getCategory().addAll(symbolicName);
			}
			else if(name.equals("userWriteMask"))
			{
				String stringToConvert = String.valueOf(temp);
		        Long convertedLong = Long.parseLong(stringToConvert);
				uaDataType.setUserWriteMask(convertedLong);
			}
			else if(name.equals("writeMask"))
			{
				String stringToConvert = String.valueOf(temp);
				Long convertedLong = Long.parseLong(stringToConvert);
				uaDataType.setWriteMask(convertedLong);
			}			
			else if(name.equals("definition"))
			{
				
			}
			else if(name.equals("purpose"))
			{
				
			}	
		}
		

		return true;
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
			
			if(name.equals("text"))
			{
				tt.getText().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								tt.getText().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								tt.getText().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("field"))
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
						if(name2.equals("base_Class"))
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
			
			if(name.equals("text"))
			{
				stt.getText().clear();
				
				EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl ltUML : ltsUML)
				{
					EList<EStructuralFeature> featuresList2 = ltUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						if(name2.equals("base_Class"))
						{
							Object baseClass = ltUML.dynamicGet(id2);
							if(this.matching.containsKey(baseClass))
							{
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								stt.getText().add(existingLT);
								break;
							}
							else
							{
								updateClass((Class) baseClass);
								LocalizedText existingLT = (LocalizedText) this.matching.get(baseClass);
								stt.getText().add(existingLT);
								break;
							}
						}
					}
				}
			}
			else if(name.equals("name"))
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
			
			if(name.equals("value"))
			{
				rp.setValue((String) temp);
			}
			else if(name.equals("permissions"))
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
			
			if(name.equals("value"))
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
			
			if(name.equals("rolePermission"))
			{
				EcoreEList<DynamicEObjectImpl> rpsUML = (EcoreEList<DynamicEObjectImpl>) temp;
				for(DynamicEObjectImpl rpUML : rpsUML)
				{

					EList<EStructuralFeature> featuresList2 = rpUML.eClass().getEAllStructuralFeatures();
					for(EStructuralFeature feature2 : featuresList2)
					{
						int id2 = feature2.getFeatureID();
						String name2 = feature2.getName();
						
						if(name2.equals("base_Class"))
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
//			if(ster.getName().equals("NodeId"))
//			{
//				
//			}
//		}
		return false;
	}
	
	public boolean updatedMember(UAObject object)
	{
		return false;
	}
	
	public boolean updatedMember(UAObjectType object)
	{
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
			
			if(name.equals("alias"))
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
						if(name2.equals("base_Class"))
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
			
			if(name.equals("alias"))
			{
				String aliasString = (String) stereoptype_application.dynamicGet(id);
				alias.setAlias(aliasString);
			}
			else if(name.equals("value"))
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
					
					if(name.equals("value"))
					{
						String nodeId = getNodeId(target);
						uaReference.setValue(nodeId);
					}
					else if(name.equals("isForward"))
					{
						String stringToConvert = String.valueOf(temp);
						boolean convertedBoolean = Boolean.parseBoolean(stringToConvert);
						uaReference.setIsForward(convertedBoolean);
					}
					else if(name.equals("referenceType"))
					{
						DynamicEObjectImpl uri_object = ((DynamicEObjectImpl) temp);
						EList<EStructuralFeature> featuresList2 = uri_object.eClass().getEAllStructuralFeatures();
						for(EStructuralFeature feature2 : featuresList2)
						{
							int id2 = feature2.getFeatureID();
							String name2 = feature2.getName();
							if(name2.equals("base_Class"))
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
}
