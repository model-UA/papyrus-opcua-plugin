package org.eclipse.papyrus.designer.languages.opcua.codegen.transformations;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NameParser;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.eclipse.core.internal.resources.File;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
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
import org.opcfoundation.ua._2011._03.uanodeset.UAObject;
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

	public void transformUmlToNodeSet()
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
				String super_type = "i="+OpcUaNodeIdList.getObjectTypeNodeId("BaseObjectType");
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
			String super_type = "i="+OpcUaNodeIdList.getObjectTypeNodeId("BaseObjectType");
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

		for (Property attrib: attributes)
		{

			System.out.println(attrib.getName());
			// configure attribute
			
			int upper = attrib.getUpper();
			int lower = attrib.getLower();

			if(attrib.getUpperValue() != null && attrib.getUpperValue() instanceof LiteralInteger)
			{
				upper = attrib.getUpperValue().integerValue();
			}
			if(attrib.getLowerValue() != null && attrib.getLowerValue() instanceof LiteralInteger)
			{
				lower = attrib.getLowerValue().integerValue();
			}	
			
			// get data type and check if it is a basic datatype
			JAXBElement<NodeId> typeNodeId = getDataTypeNodeId(attrib.getType());
			String baseTypeId = typeNodeId.getValue().getIdentifier().getValue();
			// basic data types don't need folder types for multiplicities
			if( lower == upper || !baseTypeId.startsWith("ns"))
			{
				// create normal component
				addSubComponent(attrib, parent.getNodeId(), parentRefList);
			}
			else if(lower == 0 && upper == 1)
			{
				// create optional component
				addOptionalSubComponent(attrib, parent.getNodeId(), parentRefList);
			}
			else if(lower == 0 && upper == -1)
			{
				// create optional place holder
				addOptionalPlaceholder(attrib, parent.getNodeId(), parentRefList);
			}
			else if(lower == 1 && upper == -1)
			{
				// create mandatory place holder
				addMandatoryPlaceholder(attrib, parent.getNodeId(), parentRefList);
			}
			
		}
	}
	
	private void addSubComponent(Property attrib,  String parentNodeId, List<Reference> parentRefList)
	{
		addSubComponent(attrib, parentNodeId, parentRefList, false);
	}

	private void addSubComponent(Property attrib,  String parentNodeId, List<Reference> parentRefList, boolean is_optional)
	{
		List<UANode> extensionList = this.nodeset.getUAObjectOrUAVariableOrUAMethod();
		String browseName = getNamespaceUriId(attrib) + ":" +attrib.getName();
		String attribNodeId = convertQualifiedNameToNodeId(attrib);
				
		org.opcfoundation.ua._2011._03.uanodeset.LocalizedText displayName = new org.opcfoundation.ua._2011._03.uanodeset.LocalizedText();
		displayName.setLocale(attrib.getName());
		
		ListOfReferences attribListOfRefs = new ListOfReferences();
		List<Reference> attribRefList = attribListOfRefs.getReference();
		
		JAXBElement<NodeId> typeNodeId = getDataTypeNodeId(attrib.getType());
		String baseTypeId = typeNodeId.getValue().getIdentifier().getValue();
		if(baseTypeId.startsWith("ns"))
		{
			UAObject attribute = new UAObject();
			attribute.setBrowseName(browseName);
			attribute.setNodeId(attribNodeId);			
			attribute.setParentNodeId(parentNodeId);
			attribute.getDisplayName().add(displayName);
			
			// set type definition
			Reference attribRef = new Reference();
			String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasTypeDefinition");
			attribRef.setReferenceType(refId);
			attribRef.setValue(baseTypeId); 
			attribRefList.add(attribRef);
			
			// list of references
			attribute.setReferences(attribListOfRefs);
			extensionList.add(attribute);
		}
		else
		{
			UAVariable attribute = new UAVariable();
			attribute.setBrowseName(browseName);
			attribute.setNodeId(attribNodeId);			
			attribute.setParentNodeId(parentNodeId);
			attribute.getDisplayName().add(displayName);
			attribute.setDataType(baseTypeId);
			
			// Set Value Rank		
			int upper = attrib.getUpper();
			int lower = attrib.getLower();
			
			if( lower == upper && lower == 1)
			{
				// value is a scalar
				attribute.setValueRank(-1);
				attribute.setArrayDimensions("0");
			}
			else 
			{
				// value is a array one ore more dimensions
				attribute.setValueRank(1);
				attribute.setArrayDimensions(String.valueOf(attrib.getLowerValue().integerValue()));
			}
			// Check if element is optional
			if(lower == 0)
			{
				is_optional = true;
			}
			
			// set type definition
			Reference attribRef = new Reference();
			String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasTypeDefinition");
			attribRef.setReferenceType(refId);
			// if attribute is static transform it as property instead of a variable
			if(attrib.isStatic())
			{
				refId = "i="+ OpcUaNodeIdList.getVariableTypeNodeId("PropertyType");
			}
			else
			{
				refId = "i="+ OpcUaNodeIdList.getVariableTypeNodeId("BaseDataVariableType");
			}
			attribRef.setValue(refId); 
			attribRefList.add(attribRef);
			
			// list of references
			attribute.setReferences(attribListOfRefs);
			extensionList.add(attribute);
		}
		
		// set reference from class to attribute
		Reference attribRef = new Reference();
		String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasComponent");
		attribRef.setReferenceType(refId);
		attribRef.setIsForward(true);
		attribRef.setValue(attribNodeId);
		parentRefList.add(attribRef);
		
		// set reference from attribute to type
		attribRef = new Reference();
		refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasComponent");
		attribRef.setReferenceType(refId);
		attribRef.setIsForward(false);
		attribRef.setValue(parentNodeId);
		attribRefList.add(attribRef);
		
		// set modelling rule
		attribRef = new Reference();
		refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasModellingRule");
		attribRef.setReferenceType(refId);
		attribRef.setIsForward(true);
		if(is_optional)
		{
			refId = "i="+ OpcUaNodeIdList.getObjectNodeId("ModellingRule_Optional");
		}
		else
		{
			refId = "i="+ OpcUaNodeIdList.getObjectNodeId("ModellingRule_Mandatory");			
		}
		attribRef.setValue(refId);
		attribRefList.add(attribRef);
		
		
	}
	
	private UAObject createFolderType(Property attrib,  String parentNodeId, List<Reference> parentRefList)
	{
		UAObject uaFolder = new UAObject();
		String browseName = getNamespaceUriId(attrib) + ":" +attrib.getName() + "Folder";
		uaFolder.setBrowseName(browseName);
		String nodeId = convertQualifiedNameToNodeId(attrib)+ "Folder";
		uaFolder.setNodeId(nodeId);
				
		org.opcfoundation.ua._2011._03.uanodeset.LocalizedText displayName = new org.opcfoundation.ua._2011._03.uanodeset.LocalizedText();
		displayName.setLocale(attrib.getName() + "Folder");
		uaFolder.getDisplayName().add(displayName);
		uaFolder.setParentNodeId(parentNodeId);	
		
		// set reference from attribute to type
		ListOfReferences folderListOfRefs = new ListOfReferences();
		List<Reference> folderRefList = folderListOfRefs.getReference();
		
		// set reference from class to folder
		Reference folderRef = new Reference();
		String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasComponent");
		folderRef.setReferenceType(refId);
		folderRef.setIsForward(true);
		folderRef.setValue(uaFolder.getNodeId());
		parentRefList.add(folderRef);
		
		folderRef = new Reference();
		refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasComponent");
		folderRef.setReferenceType(refId);
		folderRef.setValue(parentNodeId);
		folderRef.setIsForward(false);
		folderRefList.add(folderRef);		
				
		Reference subtypeRef = new Reference();
		refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasTypeDefinition");
		subtypeRef.setReferenceType(refId);
		subtypeRef.setIsForward(false);
		String super_type = "i="+OpcUaNodeIdList.getObjectTypeNodeId("FolderType");
		subtypeRef.setValue(super_type);
		folderRefList.add(subtypeRef);
		
		uaFolder.setReferences(folderListOfRefs);
		
		return uaFolder;
	}
	
	private void addOptionalSubComponent(Property attrib,  String parentNodeId, List<Reference> parentRefList)
	{
		List<UANode> extensionList = this.nodeset.getUAObjectOrUAVariableOrUAMethod();
		
		UAObject uaFolder = createFolderType(attrib, parentNodeId, parentRefList);
		
		// set reference from attribute to type
		ListOfReferences folderListOfRefs = uaFolder.getReferences();
		List<Reference> folderRefList = folderListOfRefs.getReference();
		
		// set modelling rule
		Reference subtypeRef = new Reference();
		String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasModellingRule");
		subtypeRef.setReferenceType(refId);
		subtypeRef.setIsForward(true);
		refId = "i="+ OpcUaNodeIdList.getObjectNodeId("ModellingRule_Mandatory");
		subtypeRef.setValue(refId);
		folderRefList.add(subtypeRef);
		
		extensionList.add(uaFolder);
		addSubComponent(attrib, uaFolder.getNodeId(), folderRefList, true);
	}
	
	private void addOptionalPlaceholder(Property attrib,  String parentNodeId, List<Reference> parentRefList)
	{
		List<UANode> extensionList = this.nodeset.getUAObjectOrUAVariableOrUAMethod();
		
		UAObject uaFolder = createFolderType(attrib, parentNodeId, parentRefList);
		
		// set reference from attribute to type
		ListOfReferences folderListOfRefs = uaFolder.getReferences();
		List<Reference> folderRefList = folderListOfRefs.getReference();
		
		// set modelling rule
		Reference subtypeRef = new Reference();
		String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasModellingRule");
		subtypeRef.setReferenceType(refId);
		subtypeRef.setIsForward(true);
		refId = "i="+ OpcUaNodeIdList.getObjectNodeId("ModellingRule_OptionalPlaceholder");
		subtypeRef.setValue(refId);
		folderRefList.add(subtypeRef);
		
		extensionList.add(uaFolder);
		addSubComponent(attrib, uaFolder.getNodeId(), folderRefList, true);
	}
	
	private void addMandatoryPlaceholder(Property attrib,  String parentNodeId, List<Reference> parentRefList)
	{
		List<UANode> extensionList = this.nodeset.getUAObjectOrUAVariableOrUAMethod();
		
		UAObject uaFolder = createFolderType(attrib, parentNodeId, parentRefList);
		
		// set reference from attribute to type
		ListOfReferences folderListOfRefs = uaFolder.getReferences();
		List<Reference> folderRefList = folderListOfRefs.getReference();
		
		// set modelling rule
		Reference subtypeRef = new Reference();
		String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasModellingRule");
		subtypeRef.setReferenceType(refId);
		subtypeRef.setIsForward(true);
		refId = "i="+ OpcUaNodeIdList.getObjectNodeId("ModellingRule_OptionalPlaceholder");
		subtypeRef.setValue(refId);
		folderRefList.add(subtypeRef);
		
		extensionList.add(uaFolder);
		addSubComponent(attrib, uaFolder.getNodeId(), folderRefList, true);
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
			displayName.setLocale(operation.getName());
			method.getDisplayName().add(displayName);
			
			ListOfReferences methodListOfRefs = new ListOfReferences();
			List<Reference> methodRefList = methodListOfRefs.getReference();
			
			//configure input arguments
			UAVariable inputArgs = new UAVariable();
			inputArgs.setBrowseName("InputArguments");
			
			displayName = new org.opcfoundation.ua._2011._03.uanodeset.LocalizedText();
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
			
			//configure input arguments
			UAVariable outputArgs = new UAVariable();
			outputArgs.setBrowseName("OutputArguments");
			
			displayName = new org.opcfoundation.ua._2011._03.uanodeset.LocalizedText();
			displayName.setLocale(outputArgs.getBrowseName());
			outputArgs.getDisplayName().add(displayName);
			
			outputArgs.setNodeId( extendNodeId(opNodeId, "OutputArguments"));
			outputArgs.setParentNodeId(method.getNodeId());
			outputArgs.setDataType( "i="+ OpcUaNodeIdList.getDataTypeNodeId("Argument"));
			
			Value outputArgsValue = outputArgs.getValue();
			if(outputArgsValue == null)
			{
				outputArgsValue = new Value();
				outputArgs.setValue(outputArgsValue);
			}
			
			ListOfExtensionObject inputArgsListOfExtensionObjects = new ListOfExtensionObject();
			List<ExtensionObject> inputArgList = inputArgsListOfExtensionObjects.getExtensionObject();
			
			ListOfExtensionObject outputArgsListOfExtensionObjects = new ListOfExtensionObject();
			List<ExtensionObject> outputArgList = outputArgsListOfExtensionObjects.getExtensionObject();
			
			setArguments(inputArgList,outputArgList,operation.getOwnedParameters());

			inputArgs.setArrayDimensions(String.valueOf(inputArgList.size())) ;
			outputArgs.setArrayDimensions(String.valueOf(outputArgList.size())) ;
			
			inputArgsValue.setAny(inputArgsListOfExtensionObjects);
			outputArgsValue.setAny(outputArgsListOfExtensionObjects);
			
			ListOfReferences inputArgsListOfRefs = new ListOfReferences();
			List<Reference> inputArgsRefList = inputArgsListOfRefs.getReference();
			
			ListOfReferences outputArgsListOfRefs = new ListOfReferences();
			List<Reference> outputArgsRefList = outputArgsListOfRefs.getReference();
			
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
			refId = "i="+ OpcUaNodeIdList.getObjectNodeId("ModellingRule_Mandatory");
			methodRef.setValue(refId);
			methodRefList.add(methodRef);
			inputArgsRefList.add(methodRef);
			outputArgsRefList.add(methodRef);
						
			// set reference from method to input arguments
			methodRef = new Reference();
			refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasProperty");
			methodRef.setReferenceType(refId);
			methodRef.setIsForward(true);
			methodRef.setValue(inputArgs.getNodeId());
			methodRefList.add(methodRef);
			
			methodRef = new Reference();
			refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasProperty");
			methodRef.setReferenceType(refId);
			methodRef.setIsForward(true);
			methodRef.setValue(outputArgs.getNodeId());
			methodRefList.add(methodRef);
			
			
			// set reference from method to input arguments
			Reference argsRef = new Reference();
			refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasProperty");
			argsRef.setReferenceType(refId);
			argsRef.setIsForward(false);
			argsRef.setValue(method.getNodeId());
			inputArgsRefList.add(argsRef);
			outputArgsRefList.add(argsRef);
			
			argsRef = new Reference();
			refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasTypeDefinition");
			argsRef.setReferenceType(refId);
			argsRef.setIsForward(true);
			refId = "i="+ OpcUaNodeIdList.getVariableTypeNodeId("PropertyType");
			argsRef.setValue(refId);
			inputArgsRefList.add(argsRef);
			outputArgsRefList.add(argsRef);
									
			// set references
			method.setReferences(methodListOfRefs);
			inputArgs.setReferences(inputArgsListOfRefs);
			outputArgs.setReferences(outputArgsListOfRefs);
			
			extensionList.add(method);
			extensionList.add(inputArgs);
			extensionList.add(outputArgs);
		}
	}
	

	
	private void setArguments(List<ExtensionObject> inputArgList, List<ExtensionObject> outputArgList, EList<Parameter> paramList)
	{
 		for( Parameter param : paramList)
		{	
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
			int upper = param.getUpper();
			int lower = param.getLower();
			
			if( lower == upper)
			{
				// value is a scalar
				uaArgument.setValueRank(-1);
			}
			else 
			{
				// value is a array one ore more dimensions
				uaArgument.setValueRank(1);
			}
			
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
			
			ExtensionObject argumentExtensionObject = new ExtensionObject();
			JAXBElement<Body> bodyElem = new JAXBElement<Body>(qArgName, Body.class, body);
			argumentExtensionObject.setBody(bodyElem);
 			argumentExtensionObject.setTypeId(getDataTypeNodeId("Argument") );
			
 			ParameterDirectionKind dir = param.getDirection();
 			if(dir.getLiteral().contentEquals("in"))
 			{ 				
 				inputArgList.add(argumentExtensionObject);
 			}
 			else if(dir.getLiteral().contentEquals("out"))
 			{
 				outputArgList.add(argumentExtensionObject);
 			}
 			else
 			{
 				// TODO: Error inout and return cannot be transformed
 			}
 			
		}
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
		else if(dataType instanceof Class)
		{
			dataTypeId = convertQualifiedNameToNodeId((Class) dataType);
			//OpcUaDataTypeNodeIdList.addDataType(typeName, type );
		}
		else
		{
			// TODO: Error unknown type
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
			if(parent == null)
			{
				// ToDo: set error, at least one namespace needs to be definend
				return "1";
			}
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
