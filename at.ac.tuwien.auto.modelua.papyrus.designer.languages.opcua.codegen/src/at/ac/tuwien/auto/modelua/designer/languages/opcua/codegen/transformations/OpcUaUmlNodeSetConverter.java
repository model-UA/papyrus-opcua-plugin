package at.ac.tuwien.auto.modelua.designer.languages.opcua.codegen.transformations;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NameParser;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.eclipse.core.internal.resources.File;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.util.FeatureMapUtil.EntryImpl;
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
import org.opcfoundation.ua._2008._02.types.BodyType;
import org.opcfoundation.ua._2008._02.types.ExtensionObject;
import org.opcfoundation.ua._2008._02.types.ListOfUInt32;
import org.opcfoundation.ua._2008._02.types.NodeId;
import org.opcfoundation.ua._2008._02.types.TypesFactory;
import org.opcfoundation.ua._2008._02.types.ValueType;
import org.opcfoundation.ua._2008._02.types.impl.ArgumentImpl;
import org.opcfoundation.ua._2008._02.types.impl.BodyTypeImpl;
import org.opcfoundation.ua._2008._02.types.impl.ExtensionObjectImpl;
import org.opcfoundation.ua._2008._02.types.impl.ListOfExtensionObjectImpl;
import org.opcfoundation.ua._2008._02.types.impl.ListOfUInt32Impl;
import org.opcfoundation.ua._2008._02.types.impl.NodeIdImpl;
import org.opcfoundation.ua._2008._02.types.impl.TypesFactoryImpl;
import org.opcfoundation.ua._2008._02.types.util.TypesAdapterFactory;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.ListOfReferences;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.LocalizedText;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.Reference;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAMethod;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANode;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObject;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObjectType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UriTable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.ValueType1;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.ListOfReferencesImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.LocalizedTextImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.ReferenceImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAMethodImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UANodeSetTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAObjectImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAObjectTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAVariableImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UriTableImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.ValueType1Impl;

import at.ac.tuwien.auto.modelua.papyrus.designer.languages.opcua.codegen.Activator;

public class OpcUaUmlNodeSetConverter {
	
	Model model;
	UANodeSetType nodeset;
	
	
	public OpcUaUmlNodeSetConverter(Model model)
	{
		this.model = model;
		this.nodeset = new UANodeSetTypeImpl();
		UriTable namespace_table = new UriTableImpl();
		this.nodeset.setNamespaceUris(namespace_table);
		List<String> namespaces = namespace_table.getUri();
		namespaces.add(model.getURI());
		
	}
	
	public OpcUaUmlNodeSetConverter(Model model, UANodeSetTypeImpl nodeset)
	{
		this.model = model;
		this.nodeset = nodeset;
		
		UriTable namespace_table = this.nodeset.getNamespaceUris();
		if(namespace_table == null )
		{
			namespace_table = new UriTableImpl();
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
					namespace_table = new UriTableImpl();
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
		UAObjectTypeImpl uaClass = new UAObjectTypeImpl();
		String browseName = getNamespaceUriId(classElement) + ":" +classElement.getName() + "Type";
		uaClass.setBrowseName(browseName);
		String nodeId = convertQualifiedNameToNodeId(classElement);
		uaClass.setNodeId(nodeId);
				
		LocalizedTextImpl displayName = new LocalizedTextImpl();
		displayName.setLocale(classElement.getName() + "Type");
		uaClass.getDisplayName().add(displayName);
		
		ListOfReferencesImpl classListOfRefs = new ListOfReferencesImpl();
		List<Reference> refList = classListOfRefs.getReference();
		
		if(classElement.getGeneralizations().size() > 0)
		{			
			Generalization general = classElement.getGeneralizations().get(0);
			if(general.getGeneral() instanceof ClassImpl)
			{
				Reference subtypeRef = new ReferenceImpl();
				String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasSubtype");
				subtypeRef.setReferenceType(refId);
				subtypeRef.setIsForward(false);
				String super_type = convertQualifiedNameToNodeId((ClassImpl) general.getGeneral());
				subtypeRef.setValue(super_type);
				refList.add(subtypeRef);
			}
			else
			{
				Reference subtypeRef = new ReferenceImpl();
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
			Reference subtypeRef = new ReferenceImpl();
			String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasSubtype");
			subtypeRef.setReferenceType(refId);
			subtypeRef.setIsForward(false);
			String super_type = "i="+OpcUaNodeIdList.getObjectTypeNodeId("BaseObjectType");
			subtypeRef.setValue(super_type);
			refList.add(subtypeRef);
		}
		
		uaClass.setReferences(classListOfRefs);
		
		
		List<UAObjectType> extensionList = this.nodeset.getUAObjectType();
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
			NodeId baseTypeId = getDataTypeNodeId(attrib.getType());
			//		typeNodeId.getValue().getIdentifier();
			// basic data types don't need folder types for multiplicities
			if( lower == upper || !baseTypeId.getIdentifier().startsWith("ns"))
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
		String browseName = getNamespaceUriId(attrib) + ":" +attrib.getName();
		String attribNodeId = convertQualifiedNameToNodeId(attrib);
				
		LocalizedText displayName = new LocalizedTextImpl();
		displayName.setLocale(attrib.getName());
		
		ListOfReferencesImpl attribListOfRefs = new ListOfReferencesImpl();
		List<Reference> attribRefList = attribListOfRefs.getReference();
		
		String baseTypeId = getDataTypeNodeId(attrib.getType()).getIdentifier();
		if(baseTypeId.startsWith("ns"))
		{
			UAObject attribute = new UAObjectImpl();
			attribute.setBrowseName(browseName);
			attribute.setNodeId(attribNodeId);			
			attribute.setParentNodeId(parentNodeId);
			attribute.getDisplayName().add(displayName);
			
			// set type definition
			Reference attribRef = new ReferenceImpl();
			String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasTypeDefinition");
			attribRef.setReferenceType(refId);
			attribRef.setValue(baseTypeId); 
			attribRefList.add(attribRef);
			
			// list of references
			attribute.setReferences(attribListOfRefs);
			this.nodeset.getUAObject().add(attribute);
		}
		else
		{
			UAVariable attribute = new UAVariableImpl();
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
			Reference attribRef = new ReferenceImpl();
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
			this.nodeset.getUAVariable().add(attribute);
		}
		
		// set reference from class to attribute
		Reference attribRef = new ReferenceImpl();
		String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasComponent");
		attribRef.setReferenceType(refId);
		attribRef.setIsForward(true);
		attribRef.setValue(attribNodeId);
		parentRefList.add(attribRef);
		
		// set reference from attribute to type
		attribRef = new ReferenceImpl();
		refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasComponent");
		attribRef.setReferenceType(refId);
		attribRef.setIsForward(false);
		attribRef.setValue(parentNodeId);
		attribRefList.add(attribRef);
		
		// set modelling rule
		attribRef = new ReferenceImpl();
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
		UAObject uaFolder = new UAObjectImpl();
		String browseName = getNamespaceUriId(attrib) + ":" +attrib.getName() + "Folder";
		uaFolder.setBrowseName(browseName);
		String nodeId = convertQualifiedNameToNodeId(attrib)+ "Folder";
		uaFolder.setNodeId(nodeId);
				
		LocalizedText displayName = new LocalizedTextImpl();
		displayName.setLocale(attrib.getName() + "Folder");
		uaFolder.getDisplayName().add(displayName);
		uaFolder.setParentNodeId(parentNodeId);	
		
		// set reference from attribute to type
		ListOfReferencesImpl folderListOfRefs = new ListOfReferencesImpl();
		List<Reference> folderRefList = folderListOfRefs.getReference();
		
		// set reference from class to folder
		Reference folderRef = new ReferenceImpl();
		String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasComponent");
		folderRef.setReferenceType(refId);
		folderRef.setIsForward(true);
		folderRef.setValue(uaFolder.getNodeId());
		parentRefList.add(folderRef);
		
		folderRef = new ReferenceImpl();
		refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasComponent");
		folderRef.setReferenceType(refId);
		folderRef.setValue(parentNodeId);
		folderRef.setIsForward(false);
		folderRefList.add(folderRef);		
				
		Reference subtypeRef = new ReferenceImpl();
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
		List<UAObject> extensionList = this.nodeset.getUAObject();
		
		UAObject uaFolder = createFolderType(attrib, parentNodeId, parentRefList);
		
		// set reference from attribute to type
		ListOfReferences folderListOfRefs = uaFolder.getReferences();
		List<Reference> folderRefList = folderListOfRefs.getReference();
		
		// set modelling rule
		Reference subtypeRef = new ReferenceImpl();
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
		List<UAObject> extensionList = this.nodeset.getUAObject();
		
		UAObject uaFolder = createFolderType(attrib, parentNodeId, parentRefList);
		
		// set reference from attribute to type
		ListOfReferences folderListOfRefs = uaFolder.getReferences();
		List<Reference> folderRefList = folderListOfRefs.getReference();
		
		// set modelling rule
		Reference subtypeRef = new ReferenceImpl();
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
		List<UAObject> extensionList = this.nodeset.getUAObject();
		
		UAObject uaFolder = createFolderType(attrib, parentNodeId, parentRefList);
		
		// set reference from attribute to type
		ListOfReferences folderListOfRefs = uaFolder.getReferences();
		List<Reference> folderRefList = folderListOfRefs.getReference();
		
		// set modelling rule
		Reference subtypeRef = new ReferenceImpl();
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
		for (Operation operation: operations)
		{
			// configure method
			UAMethod method = new UAMethodImpl(); 
			String browseName = getNamespaceUriId(operation) + ":" +operation.getName();
			method.setBrowseName(browseName);
			String opNodeId = convertQualifiedNameToNodeId(operation);
			method.setNodeId(opNodeId);
			method.setParentNodeId(parent.getNodeId());
			
			LocalizedText displayName = new LocalizedTextImpl();
			displayName.setLocale(operation.getName());
			method.getDisplayName().add(displayName);
			
			ListOfReferencesImpl methodListOfRefs = new ListOfReferencesImpl();
			List<Reference> methodRefList = methodListOfRefs.getReference();
			
			//configure input arguments
			UAVariable inputArgs = new UAVariableImpl();
			inputArgs.setBrowseName("InputArguments");
			
			displayName = new LocalizedTextImpl();
			displayName.setLocale(inputArgs.getBrowseName());
			inputArgs.getDisplayName().add(displayName);
			
			inputArgs.setNodeId( extendNodeId(opNodeId, "InputArguments"));
			inputArgs.setParentNodeId(method.getNodeId());
			inputArgs.setDataType( "i="+ OpcUaNodeIdList.getDataTypeNodeId("Argument"));
			int arrayDim = operation.getOwnedParameters().size();
			inputArgs.setArrayDimensions(String.valueOf(arrayDim)) ;
			
			ValueType1 inputArgsValue = inputArgs.getValue();
			if(inputArgsValue == null)
			{
				inputArgsValue = new ValueType1Impl();
				inputArgs.setValue(inputArgsValue);
			}
			
			//configure input arguments
			UAVariable outputArgs = new UAVariableImpl();
			outputArgs.setBrowseName("OutputArguments");
			
			displayName = new LocalizedTextImpl();
			displayName.setLocale(outputArgs.getBrowseName());
			outputArgs.getDisplayName().add(displayName);
			
			outputArgs.setNodeId( extendNodeId(opNodeId, "OutputArguments"));
			outputArgs.setParentNodeId(method.getNodeId());
			outputArgs.setDataType( "i="+ OpcUaNodeIdList.getDataTypeNodeId("Argument"));
			
			ValueType1 outputArgsValue = outputArgs.getValue();
			if(outputArgsValue == null)
			{
				outputArgsValue = new ValueType1Impl();
				outputArgs.setValue(outputArgsValue);
			}
			
			ListOfExtensionObjectImpl inputArgsListOfExtensionObjectImpls = new ListOfExtensionObjectImpl();
			List<ExtensionObject> inputArgList = inputArgsListOfExtensionObjectImpls.getExtensionObject();
			
			ListOfExtensionObjectImpl outputArgsListOfExtensionObjectImpls = new ListOfExtensionObjectImpl();
			List<ExtensionObject> outputArgList = outputArgsListOfExtensionObjectImpls.getExtensionObject();
			
			setArguments(inputArgList,outputArgList,operation.getOwnedParameters());

			inputArgs.setArrayDimensions(String.valueOf(inputArgList.size())) ;
			outputArgs.setArrayDimensions(String.valueOf(outputArgList.size())) ;
			
			inputArgsValue.getAny().setValue(0, inputArgsListOfExtensionObjectImpls);
			outputArgsValue.getAny().setValue(0,outputArgsListOfExtensionObjectImpls);
			
			ListOfReferencesImpl inputArgsListOfRefs = new ListOfReferencesImpl();
			List<Reference> inputArgsRefList = inputArgsListOfRefs.getReference();
			
			ListOfReferencesImpl outputArgsListOfRefs = new ListOfReferencesImpl();
			List<Reference> outputArgsRefList = outputArgsListOfRefs.getReference();
			
			// set reference from class to method
			Reference methodRef = new ReferenceImpl();
			String refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasComponent");
			methodRef.setReferenceType(refId);
			methodRef.setIsForward(true);
			methodRef.setValue(method.getNodeId());
			parentRefList.add(methodRef);
			
			methodRef = new ReferenceImpl();
			refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasComponent");
			methodRef.setReferenceType(refId);
			methodRef.setIsForward(false);
			methodRef.setValue(parent.getNodeId());
			methodRefList.add(methodRef);
						
			// set Modelling rule
			methodRef = new ReferenceImpl();
			refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasModellingRule");
			methodRef.setReferenceType(refId);
			methodRef.setIsForward(true);
			refId = "i="+ OpcUaNodeIdList.getObjectNodeId("ModellingRule_Mandatory");
			methodRef.setValue(refId);
			methodRefList.add(methodRef);
			inputArgsRefList.add(methodRef);
			outputArgsRefList.add(methodRef);
						
			// set reference from method to input arguments
			methodRef = new ReferenceImpl();
			refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasProperty");
			methodRef.setReferenceType(refId);
			methodRef.setIsForward(true);
			methodRef.setValue(inputArgs.getNodeId());
			methodRefList.add(methodRef);
			
			methodRef = new ReferenceImpl();
			refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasProperty");
			methodRef.setReferenceType(refId);
			methodRef.setIsForward(true);
			methodRef.setValue(outputArgs.getNodeId());
			methodRefList.add(methodRef);
			
			
			// set reference from method to input arguments
			Reference argsRef = new ReferenceImpl();
			refId = "i="+ OpcUaNodeIdList.getReferenceTypeNodeId("HasProperty");
			argsRef.setReferenceType(refId);
			argsRef.setIsForward(false);
			argsRef.setValue(method.getNodeId());
			inputArgsRefList.add(argsRef);
			outputArgsRefList.add(argsRef);
			
			argsRef = new ReferenceImpl();
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
			
			this.nodeset.getUAMethod().add(method);
			this.nodeset.getUAVariable().add(inputArgs);
			this.nodeset.getUAVariable().add(outputArgs);
		}
	}
	

	
	private void setArguments(List<ExtensionObject> inputArgList, List<ExtensionObject> outputArgList, EList<Parameter> paramList)
	{
 		for( Parameter param : paramList)
		{	
			Argument uaArgument = new ArgumentImpl();
			
			// set Name of Argument
			uaArgument.setName(param.getName());
			
			if(param.getType() == null)
			{
				Activator.log.error("Paramer " + param.getQualifiedName() +" does not have a type", null);
				continue;
			}
			
			// set DataType of Argument			
			uaArgument.setDataType(getDataTypeNodeId(param.getType()));
			
			// Set Array Dimension
			// TODO: check if UML Arrays exist as Parameter
			ListOfUInt32 argArrayDimension = new ListOfUInt32Impl();
			List<Long> argArrayDimensionList = argArrayDimension.getUInt32();
			argArrayDimensionList.add((long) 1);
			uaArgument.setArrayDimensions(argArrayDimension);
			
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
			LocalizedText descriptionLT = new LocalizedTextImpl();
			String comments = "";
			for(Comment comment : param.getOwnedComments())
			{
				comments += comment.getBody() + "\n";
			}
			
			descriptionLT.setLocale(comments);
			uaArgument.setDescription((org.opcfoundation.ua._2008._02.types.LocalizedText) descriptionLT );
			
			TypesFactory type_fac = new TypesFactoryImpl();
			BodyType body = type_fac.createBodyType();
			body.getAny().setValue(0, uaArgument);
			
			ExtensionObject argumentExtensionObject = new ExtensionObjectImpl();
			argumentExtensionObject.setBody(body);
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
 			else if(dir.getLiteral().contentEquals("inout"))
 			{
 				Activator.log.error("Parameter Type inout is not transformable", null);
 			}
 			else
 			{
 				// inout and return cannot be transformed
 				Activator.log.error("Parameter Type return is not transformable", null);
 			}
 			
		}
	}
	
	private NodeId getDataTypeNodeId(Type dataType)
	{
		NodeId typeId = new NodeIdImpl();		
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
			Activator.log.error("Got unknown type "+typeName, null);
		}

		typeId.setIdentifier(dataTypeId);

		return typeId;
	}
	
	private NodeId getDataTypeNodeId(String typeName)
	{
		NodeId typeId = new NodeIdImpl();
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

		typeId.setIdentifier(dataTypeId);
		
		return typeId;
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
				String qualifiedName = "";
				
				if(elem instanceof Class)
				{
					Class class_elem = (Class) elem;
					qualifiedName = "Class "+class_elem.getQualifiedName();
				}
				else if(elem instanceof org.eclipse.uml2.uml.Package)
				{
					org.eclipse.uml2.uml.Package package_elem = (org.eclipse.uml2.uml.Package) elem;
					qualifiedName = "Package "+ package_elem.getQualifiedName();
				}
				else if(elem instanceof Operation)
				{
					Operation operation_elem = (Operation) elem;
					qualifiedName ="Operation "+ operation_elem.getQualifiedName();
				}
								
				Activator.log.error(qualifiedName+" is not inside any namespace", null );
				return "0";
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
