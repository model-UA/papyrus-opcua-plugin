package org.eclipse.papyrus.designer.languages.opcua.codegen.transformations;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NameParser;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.eclipse.core.internal.resources.File;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.internal.impl.DataTypeImpl;
import org.eclipse.uml2.uml.internal.impl.PackageImpl;
import org.eclipse.uml2.uml.internal.impl.StateMachineImpl;
import org.opcfoundation.ua._2008._02.types.Argument;
import org.opcfoundation.ua._2008._02.types.ExtensionObject;
import org.opcfoundation.ua._2008._02.types.ExtensionObject.Body;
import org.opcfoundation.ua._2008._02.types.ListOfExtensionObject;
import org.opcfoundation.ua._2008._02.types.ListOfUInt32;
import org.opcfoundation.ua._2008._02.types.LocalizedText;
import org.opcfoundation.ua._2008._02.types.NodeId;
import org.opcfoundation.ua._2011._03.uanodeset.ListOfReferences;
import org.opcfoundation.ua._2011._03.uanodeset.Reference;
import org.opcfoundation.ua._2011._03.uanodeset.UAMethod;
import org.opcfoundation.ua._2011._03.uanodeset.UANode;
import org.opcfoundation.ua._2011._03.uanodeset.UANodeSet;
import org.opcfoundation.ua._2011._03.uanodeset.UAObjectType;
import org.opcfoundation.ua._2011._03.uanodeset.UAReferenceType;
import org.opcfoundation.ua._2011._03.uanodeset.UAVariable;
import org.opcfoundation.ua._2011._03.uanodeset.UAVariable.Value;
import org.opcfoundation.ua._2011._03.uanodeset.UriTable;

public class OpcUaUmlNodeSetConverter {
	
	Model model;
	UANodeSet nodeset;
	
	
	public OpcUaUmlNodeSetConverter(Model model)
	{
		this.model = model;
		this.nodeset = new UANodeSet();
	
		UriTable namespace_table = new UriTable();
		this.nodeset.setNamespaceUris(namespace_table);
		List<String> namespaces = namespace_table.getUri();
		namespaces.add(model.getURI());
		
	}
	
	public OpcUaUmlNodeSetConverter(Model model, UANodeSet nodeset)
	{
		this.model = model;
		this.nodeset = nodeset;
		
		UriTable namespace_table = this.nodeset.getNamespaceUris();
		if(namespace_table == null )
		{
			namespace_table = new UriTable();
			this.nodeset.setNamespaceUris(namespace_table);
		}
		List<String> namespaces = namespace_table.getUri();
		namespaces.add(model.getURI());
	}
	
		
	public void readNodeSet(File nodesetFi)
	{
		
	}

	public void writeNodeSet(String filename)
	{
		parsePackagedElements(model.getPackagedElements());
	}
	
	public void synchModelWithNodeSet()
	{
		
	}
	
	public void synchNodeSetWithModel()
	{
		
	}
	
	private void parsePackagedElements(EList<PackageableElement> packagedElements)
	{
		for (PackageableElement elem: packagedElements)
		{
			if(elem instanceof PackageImpl)
			{
				UriTable namespace_table = this.nodeset.getNamespaceUris();
				if(namespace_table == null )
				{
					namespace_table = new UriTable();
					this.nodeset.setNamespaceUris(namespace_table);
				}
				
				List<String> namespaces = namespace_table.getUri();
				if(((PackageImpl) elem).getURI().length() > 0)
				{
					namespaces.add(((PackageImpl) elem).getURI());
				}
				
				System.out.println(elem.getName());
				parsePackage( (org.eclipse.uml2.uml.Package ) elem);
			}
			else if( elem instanceof ClassImpl)
			{
				System.out.println(elem.getName());
				parseClass((Class ) elem);
			}
			else if( elem instanceof DataTypeImpl)
			{
				System.out.println(elem.getName());
			}
		}
	}
	
	private void parsePackage(org.eclipse.uml2.uml.Package packageElement)
	{
		System.out.println(packageElement.getName());
		parsePackagedElements(packageElement.getPackagedElements());
	}
	
	private void parseClass(org.eclipse.uml2.uml.Class classElement)
	{
		UAObjectType uaClass = new UAObjectType();
		String browseName = getNamespaceUriId(classElement) + ":" +classElement.getName() + "Type";
		uaClass.setBrowseName(browseName);
		String nodeId = convertQualifiedNameToNodeId(classElement);
		uaClass.setNodeId(nodeId);
				
		org.opcfoundation.ua._2011._03.uanodeset.LocalizedText displayName = new org.opcfoundation.ua._2011._03.uanodeset.LocalizedText();
		displayName.setLocale(classElement.getName() + "Type");
		uaClass.getDisplayName().add(displayName);
		
		ListOfReferences classListOfRefs = new ListOfReferences();
		List<Reference> refList = classListOfRefs.getReference();
		
		if(classElement.getGeneralizations().size() > 0)
		{			
			Generalization general = classElement.getGeneralizations().get(0);
			if(general.getGeneral() instanceof ClassImpl)
			{
				Reference subtypeRef = new Reference();
				String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasSubtype");
				subtypeRef.setReferenceType(refId);
				subtypeRef.setIsForward(false);
				String super_type = convertQualifiedNameToNodeId((ClassImpl) general.getGeneral());
				subtypeRef.setValue(super_type);
				refList.add(subtypeRef);
			}
			else
			{
				Reference subtypeRef = new Reference();
				String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasSubtype");
				subtypeRef.setReferenceType(refId);
				subtypeRef.setIsForward(false);
				String super_type = convertQualifiedNameToNodeId("i=58");
				subtypeRef.setValue(super_type);
				refList.add(subtypeRef);
			}
		}
		else
		{
			Reference subtypeRef = new Reference();
			String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasSubtype");
			subtypeRef.setReferenceType(refId);
			subtypeRef.setIsForward(false);
			String super_type = convertQualifiedNameToNodeId("i=58");
			subtypeRef.setValue(super_type);
			refList.add(subtypeRef);
		}
		
		uaClass.setReferences(classListOfRefs);
		
		
		List<UANode> extensionList = this.nodeset.getUAObjectOrUAVariableOrUAMethod();
		extensionList.add(uaClass);
		
		EList<Property> attributes = classElement.getOwnedAttributes();
		setAttributes(attributes,uaClass, refList);
		
		EList<Operation> operations = classElement.getOwnedOperations();
		transformOperations(operations, uaClass, refList);
		
		// TODO: add parsing of state machines
//		for (Behavior behavior: classElement.getOwnedBehaviors())
//		{
//			if(behavior instanceof StateMachineImpl)
//			{				
//				System.out.println(behavior.getName());
//			}
//		}
		
	}
	
	private void setAttributes(EList<Property> attributes, UAObjectType parent, List<Reference> parentRefList)
	{
		List<UANode> extensionList = this.nodeset.getUAObjectOrUAVariableOrUAMethod();
		for (Property attrib: attributes)
		{
			// configure attribute
			UAVariable attribute = new UAVariable();
			
			String browseName = getNamespaceUriId(attrib) + ":" +attrib.getName();
			attribute.setBrowseName(browseName);
			String attribNodeId = convertQualifiedNameToNodeId(attrib);
			attribute.setNodeId(attribNodeId);			
			attribute.setParentNodeId(parent.getNodeId());
			
			org.opcfoundation.ua._2011._03.uanodeset.LocalizedText displayName = new org.opcfoundation.ua._2011._03.uanodeset.LocalizedText();
			displayName.setLocale(attrib.getName());
			attribute.getDisplayName().add(displayName);
			
			if(attrib.getDatatype() != null)
			{
				attribute.setDataType(attrib.getDatatype().toString());
			}
			else
			{
				//attribute.setDataType(getDataTypeNodeId(attrib.getType()).getValue().getIdentifier().getValue());
			}
			
			// set reference from class to attribute
			Reference attribRef = new Reference();
			String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasComponent");
			attribRef.setReferenceType(refId);
			attribRef.setIsForward(true);
			attribRef.setValue(attribute.getNodeId());
			parentRefList.add(attribRef);
			
			// set reference from attribute to type
			ListOfReferences attribListOfRefs = new ListOfReferences();
			List<Reference> attribRefList = attribListOfRefs.getReference();
			attribRef = new Reference();
			refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasComponent");
			attribRef.setReferenceType(refId);
			attribRef.setIsForward(false);
			attribRef.setValue(parent.getNodeId());
			attribRefList.add(attribRef);
			
			// TODO: add reference to ObjectNode
			attribRef = new Reference();
			refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasTypeDefinition");
			attribRef.setReferenceType(refId);
			attribRef.setIsForward(true);
			attribRef.setValue("i=63"); 
			attribRefList.add(attribRef);
			
			// TODO: add reference to VariableTypeNode
			attribRef = new Reference();
			refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasModellingRule");
			attribRef.setReferenceType(refId);
			attribRef.setIsForward(true);
			attribRef.setValue("i=78");
			attribRefList.add(attribRef);
			
			// list of references
			attribute.setReferences(attribListOfRefs);
			extensionList.add(attribute);

			System.out.println(attrib.getName());
		}
	}
	
	private void transformOperations(EList<Operation> operations, UAObjectType parent, List<Reference> parentRefList )
	{
		List<UANode> extensionList = this.nodeset.getUAObjectOrUAVariableOrUAMethod();
		for (Operation operation: operations)
		{
			// configure method
			UAMethod method = new UAMethod(); 
			String browseName = getNamespaceUriId(operation) + ":" +operation.getName();
			method.setBrowseName(browseName);
			String opNodeId = convertQualifiedNameToNodeId(operation);
			method.setNodeId(opNodeId);
			method.setParentNodeId(parent.getNodeId());
			
			org.opcfoundation.ua._2011._03.uanodeset.LocalizedText displayName = new org.opcfoundation.ua._2011._03.uanodeset.LocalizedText();
			displayName.setLocale(method.getBrowseName());
			method.getDisplayName().add(displayName);
			
			ListOfReferences methodListOfRefs = new ListOfReferences();
			List<Reference> methodRefList = methodListOfRefs.getReference();
			
			//configure input arguments
			UAVariable inputArgs = new UAVariable();
			inputArgs.setBrowseName("InputArguments");
			
			displayName.setLocale(inputArgs.getBrowseName());
			inputArgs.getDisplayName().add(displayName);
			
			inputArgs.setNodeId( extendNodeId(opNodeId, "InputArguments"));
			inputArgs.setParentNodeId(method.getNodeId());
			inputArgs.setDataType( "i="+ OpcUaNodeIdList.getDataTypeNodeId("Argument"));
			int arrayDim = operation.getOwnedParameters().size();
			inputArgs.setArrayDimensions(String.valueOf(arrayDim)) ;
			
			Value inputArgsValue = inputArgs.getValue();
			if(inputArgsValue == null)
			{
				inputArgsValue = new Value();
				inputArgs.setValue(inputArgsValue);
			}
			
			ListOfExtensionObject inputArgsListOfExtensionObjects = new ListOfExtensionObject();
			List<ExtensionObject> argList = inputArgsListOfExtensionObjects.getExtensionObject();
			setInputArguments(argList,operation.getOwnedParameters());
			
			inputArgsValue.setAny(inputArgsListOfExtensionObjects);
			
			ListOfReferences inputArgsListOfRefs = new ListOfReferences();
			List<Reference> inputArgsRefList = inputArgsListOfRefs.getReference();
			
			// set reference from class to method
			Reference methodRef = new Reference();
			String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasComponent");
			methodRef.setReferenceType(refId);
			methodRef.setIsForward(true);
			methodRef.setValue(method.getNodeId());
			parentRefList.add(methodRef);
			
			methodRef = new Reference();
			refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasComponent");
			methodRef.setReferenceType(refId);
			methodRef.setIsForward(false);
			methodRef.setValue(parent.getNodeId());
			methodRefList.add(methodRef);
						
			// TODO: set Modelling rule
			methodRef = new Reference();
			refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasModellingRule");
			methodRef.setReferenceType(refId);
			methodRef.setIsForward(true);
			methodRef.setValue("i=78");
			methodRefList.add(methodRef);
			inputArgsRefList.add(methodRef);
			
			methodRef = new Reference();
			refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasTypeDefinition");
			methodRef.setReferenceType(refId);
			methodRef.setIsForward(true);
			methodRef.setValue("i=68");
			methodRefList.add(methodRef);
			inputArgsRefList.add(methodRef);
			
			// set reference from method to input arguments
			Reference inputArgsRef = new Reference();
			refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasProperty");
			inputArgsRef.setReferenceType(refId);
			inputArgsRef.setIsForward(true);
			inputArgsRef.setValue(method.getNodeId());
			inputArgsRefList.add(inputArgsRef);
									
			// set references
			method.setReferences(methodListOfRefs);
			inputArgs.setReferences(inputArgsListOfRefs);
			
			// TODO: configure "Value"
			
			extensionList.add(method);
			extensionList.add(inputArgs);
		}
	}
	

	
	private void setInputArguments(List<ExtensionObject> argList, EList<Parameter> paramList)
	{
		for( Parameter param : paramList)
		{
			ExtensionObject inputArgExtensionObject = new ExtensionObject();
			Argument uaArgument = new Argument();
			
			// set Name of Argument
			QName qArgName = new QName(param.getName());
			JAXBElement<String> argName = new JAXBElement<String>(qArgName, String.class, param.getName());
			argName.setValue(param.getName());
			uaArgument.setName(argName);
			
			// set DataType of Argument			
			uaArgument.setDataType(getDataTypeNodeId(param.getType()));
			
			// Set Array Dimension
			// TODO: check if UML Arrays exist as Parameter
			ListOfUInt32 argArrayDimension = new ListOfUInt32();
			List<Long> argArrayDimensionList = argArrayDimension.getUInt32();
			argArrayDimensionList.add((long) 1);
			JAXBElement<ListOfUInt32> value = new JAXBElement<ListOfUInt32>(qArgName, ListOfUInt32.class , argArrayDimension);
			uaArgument.setArrayDimensions(value);
			
			// Set Value Rank
			// TODO: find out why -1
			uaArgument.setValueRank(-1);
			
			// Set description
			LocalizedText descriptionLT = new LocalizedText();
			String comments = "";
			for(Comment comment : param.getOwnedComments())
			{
				comments += comment.getBody() + "\n";
			}
			
			JAXBElement<String> descriptionText = new JAXBElement<String>(qArgName, String.class, comments);
			descriptionLT.setText(descriptionText);
			JAXBElement<LocalizedText> description = new JAXBElement<LocalizedText>(qArgName, LocalizedText.class, descriptionLT);
			uaArgument.setDescription(description );
			
			Body body = new Body();
			body.setAny(uaArgument);
			
			JAXBElement<Body> bodyElem = new JAXBElement<Body>(qArgName, Body.class, body);
			inputArgExtensionObject.setBody(bodyElem);
			
 			inputArgExtensionObject.setTypeId(getDataTypeNodeId("Argument") );
			
			argList.add(inputArgExtensionObject);
		}
	}

	private JAXBElement<NodeId> getDataTypeNodeId(Class dataType)
	{
		NodeId typeId = new NodeId();
		String typeName = dataType.getName();
		String dataTypeId = convertQualifiedNameToNodeId(dataType);
		
		QName qDataTypeName = new QName(typeName);
		JAXBElement<String> dataTypeName = new JAXBElement<String>(qDataTypeName, String.class, dataType.getName());
		dataTypeName.setValue(dataTypeId);
		
		typeId.setIdentifier(dataTypeName);
		
		
		JAXBElement<NodeId> dataTypeNodeId = new JAXBElement<NodeId>(qDataTypeName, NodeId.class, typeId);
		dataTypeNodeId.setValue(typeId);
		return dataTypeNodeId;
	}
	
	private JAXBElement<NodeId> getDataTypeNodeId(DataType dataType)
	{
		NodeId typeId = new NodeId();
		String typeName = dataType.getName();
		String dataTypeId = convertQualifiedNameToNodeId(dataType);
		
		QName qDataTypeName = new QName(typeName);
		JAXBElement<String> dataTypeName = new JAXBElement<String>(qDataTypeName, String.class, dataType.getName());
		dataTypeName.setValue(dataTypeId);
		
		typeId.setIdentifier(dataTypeName);
		
		
		JAXBElement<NodeId> dataTypeNodeId = new JAXBElement<NodeId>(qDataTypeName, NodeId.class, typeId);
		dataTypeNodeId.setValue(typeId);
		return dataTypeNodeId;
	}
	
	private JAXBElement<NodeId> getDataTypeNodeId(Type dataType)
	{
		NodeId typeId = new NodeId();
		String typeName = dataType.getName();
		String dataTypeId = "";
		
		if(typeName.equals("Real"))
		{
			// Real does not exist in OPC UA data types
			typeName = "Float";
		}
		
		if(OpcUaNodeIdList.dataTypeNodeIdExists(typeName))
		{
			dataTypeId = "i="+ OpcUaNodeIdList.getDataTypeNodeId(typeName);
		}
		else
		{
			//OpcUaDataTypeNodeIdList.addDataType(typeName, type );
		}
		QName qDataTypeName = new QName(typeName);
		JAXBElement<String> dataTypeName = new JAXBElement<String>(qDataTypeName, String.class, dataType.getName());
		dataTypeName.setValue(dataTypeId);
		
		typeId.setIdentifier(dataTypeName);
		
		
		JAXBElement<NodeId> dataTypeNodeId = new JAXBElement<NodeId>(qDataTypeName, NodeId.class, typeId);
		dataTypeNodeId.setValue(typeId);
		return dataTypeNodeId;
	}
	
	private JAXBElement<NodeId> getDataTypeNodeId(String typeName)
	{
		NodeId typeId = new NodeId();
		String dataTypeId = "";
		
		if(typeName.equals("Real"))
		{
			// Real does not exist in OPC UA data types
			typeName = "Float";
		}
		
		if(OpcUaNodeIdList.dataTypeNodeIdExists(typeName))
		{
			dataTypeId = "i="+ OpcUaNodeIdList.getDataTypeNodeId(typeName);
		}
		else
		{
			//OpcUaDataTypeNodeIdList.addDataType(typeName, type );
		}
		QName qDataTypeName = new QName(typeName);
		JAXBElement<String> dataTypeName = new JAXBElement<String>(qDataTypeName, String.class, typeName);
		dataTypeName.setValue(dataTypeId);
		
		typeId.setIdentifier(dataTypeName);
		
		
		JAXBElement<NodeId> dataTypeNodeId = new JAXBElement<NodeId>(qDataTypeName, NodeId.class, typeId);
		dataTypeNodeId.setValue(typeId);
		return dataTypeNodeId;
	}
	
	private String getNamespaceUriId(EObject elem)
	{
		
		EObject parent = elem.eContainer();
		String namespace = "";
		while(true)
		{
			if(parent instanceof PackageImpl)
			{
				PackageImpl package_elem = (PackageImpl) parent;
				if(package_elem.getURI() != null && package_elem.getURI().length() > 0)
				{					
					namespace = package_elem.getURI();
					break;
				}
			}
			else if(parent instanceof Model)
			{
				Model model_elem = (Model) parent;
				namespace = model_elem.getURI();
				break;
			}
			parent = parent.eContainer();
		}
		int namespace_id = this.nodeset.getNamespaceUris().getUri().indexOf(namespace);
		
		return String.valueOf(namespace_id);
	}
	
	private String convertQualifiedNameToNodeId(Property elem)
	{
		String namespace_id = getNamespaceUriId(elem);
		String nodeId = "ns=" + namespace_id + ";s=";
		nodeId += elem.getQualifiedName().replace("::","/");
		return nodeId;
	}
	
	private String convertQualifiedNameToNodeId(Operation elem)
	{
		String namespace_id = getNamespaceUriId(elem);
		String nodeId = "ns=" + namespace_id + ";s=";
		nodeId += elem.getQualifiedName().replace("::","/");
		return nodeId;
	}
	
	private String convertQualifiedNameToNodeId(org.eclipse.uml2.uml.Class elem)
	{
		String namespace_id = getNamespaceUriId(elem);
		String nodeId = "ns=" + namespace_id + ";s=";
		nodeId += elem.getQualifiedName().replace("::","/");
		return nodeId;
	}
	
	private String convertQualifiedNameToNodeId( DataType elem)
	{
		String namespace_id = getNamespaceUriId(elem);
		String nodeId = "ns=" + namespace_id + ";s=";
		nodeId += elem.getQualifiedName().replace("::","/");
		return nodeId;
	}
	
	private String convertQualifiedNameToNodeId(String qualifiedName)
	{
		
		return qualifiedName.replace("::","/");
		
	}
	
	private String convertQualifiedNameToNodeId(String qualifiedName, ArrayList<String> names) {
		
		String nodeId = qualifiedName.replace("::","/");
		
		for(String name : names)
		{
			nodeId = nodeId + "/" + name;
		}
		
		return nodeId;
	}
	
	private String extendNodeId(String nodeId, String extension)
	{
		return nodeId+ "/" + extension;
	}
	
}
