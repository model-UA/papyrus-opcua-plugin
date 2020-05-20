package org.eclipse.papyrus.designer.languages.opcua.codegen.transformations;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.eclipse.core.internal.resources.File;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
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

public class OpcUaUmlNodeSetConverter {
	
	Model model;
	UANodeSet nodeset;
	
	
	public OpcUaUmlNodeSetConverter(Model model)
	{
		this.model = model;
		this.nodeset = new UANodeSet();
	}
	
	public OpcUaUmlNodeSetConverter(Model model, UANodeSet nodeset)
	{
		this.model = model;
		this.nodeset = nodeset;
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
				System.out.println(elem.getName());
				parsePackage( (PackageImpl) elem);
			}
			else if( elem instanceof ClassImpl)
			{
				System.out.println(elem.getName());
				parseClass((ClassImpl) elem);
			}
		}
	}
	
	private void parsePackage(PackageImpl packageElement)
	{
		System.out.println(packageElement.getName());
		parsePackagedElements(packageElement.getPackagedElements());
	}
	
	private void parseClass(ClassImpl classElement)
	{
		UAObjectType uaClass = new UAObjectType();
		uaClass.setBrowseName(classElement.getName());
		String nodeId = convertQualifiedNameToNodeId(classElement.getQualifiedName());
		uaClass.setNodeId(nodeId);
		
		
		ListOfReferences classListOfRefs = new ListOfReferences();
		List<Reference> refList = classListOfRefs.getReference();
		uaClass.setReferences(classListOfRefs);
		
		List<UANode> extensionList = this.nodeset.getUAObjectOrUAVariableOrUAMethod();
		extensionList.add(uaClass);
		
		for (Property attrib: classElement.getOwnedAttributes())
		{
			// configure attribute
			UAVariable attribute = new UAVariable();
			attribute.setBrowseName(attrib.getName());
			String attribNodeId = convertQualifiedNameToNodeId(attrib.getQualifiedName());
			attribute.setNodeId(attribNodeId);			
			attribute.setParentNodeId(uaClass.getNodeId());
			if(attrib.getDatatype() != null)
			{
				attribute.setDataType(attrib.getDatatype().toString());
			}
			else
			{
				attribute.setDataType("");
			}
			
			// set reference from class to atttribute
			Reference attribRef = new Reference();
			attribRef.setReferenceType("HasComponent");
			attribRef.setValue(attribute.getNodeId());
			refList.add(attribRef);
			
			// set reference from attribute to type
			ListOfReferences attribListOfRefs = new ListOfReferences();
			List<Reference> attribRefList = attribListOfRefs.getReference();
			attribRef = new Reference();
			attribRef.setReferenceType("HasComponent");
			attribRef.setIsForward(false);
			attribRef.setValue(uaClass.getNodeId());
			attribRefList.add(attribRef);
			
			// TODO: add reference to ObjectNode
			attribRef = new Reference();
			attribRef.setReferenceType("HasTypeDefinition");
			attribRef.setIsForward(false);
			attribRef.setValue("i=63");
			attribRefList.add(attribRef);
			
			// TODO: add reference to VariableTypeNode
			attribRef = new Reference();
			attribRef.setReferenceType("HasModellingRule");
			attribRef.setIsForward(false);
			attribRef.setValue("i=78");
			attribRefList.add(attribRef);
			
			// list of references
			attribute.setReferences(attribListOfRefs);
			extensionList.add(attribute);

			System.out.println(attrib.getName());
		}
		
		for (Operation operation: classElement.getOwnedOperations())
		{
			// configure method
			UAMethod method = new UAMethod(); 
			method.setBrowseName(operation.getName());
			String opNodeId = convertQualifiedNameToNodeId(operation.getQualifiedName());
			method.setNodeId(opNodeId);
			method.setParentNodeId(uaClass.getNodeId());
			
			ListOfReferences methodListOfRefs = new ListOfReferences();
			List<Reference> methodRefList = methodListOfRefs.getReference();
			
			//configure input arguments
			UAVariable inputArgs = new UAVariable();
			inputArgs.setBrowseName("InputArguments");
			inputArgs.setNodeId( extendNodeId(opNodeId, "InputArguments"));
			inputArgs.setParentNodeId(method.getNodeId());
			inputArgs.setDataType("Argument");
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
			for( Parameter param : operation.getOwnedParameters())
			{
				ExtensionObject inputArgExtensionObject = new ExtensionObject();
				Argument uaArgument = new Argument();
				
				// set Name of Argument
				QName qArgName = new QName(inputArgs.getNodeId());
				JAXBElement<String> argName = new JAXBElement<String>(qArgName, String.class, param.getName());
				argName.setValue(param.getName());
				uaArgument.setName(argName);
				
				// set DataType of Argument			
				NodeId typeId = new NodeId();
				JAXBElement<String> typeName = new JAXBElement<String>(qArgName, String.class, param.getType().getName());
				typeId.setIdentifier(typeName);
				JAXBElement<NodeId> dataTypeId = new JAXBElement<NodeId>(qArgName, NodeId.class, typeId);
				uaArgument.setDataType(dataTypeId);
				
				// Set Array Dimension
				// TODO: check if UML Arrays exist as Parameter
				ListOfUInt32 argArrayDimension = new ListOfUInt32();
				List<Long> argArrayDimensionList = argArrayDimension.getUInt32();
				argArrayDimensionList.add((long) 1);
				JAXBElement<ListOfUInt32> value = new JAXBElement<ListOfUInt32>(qArgName, ListOfUInt32.class , argArrayDimension);
				uaArgument.setArrayDimensions(value);
				
				// Set Value Ranke
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
				
				NodeId argumentType = new NodeId();
				JAXBElement<String> argumentTypeString = new JAXBElement<String>(qArgName, String.class, "i=296");
				argumentType.setIdentifier(argumentTypeString);
				JAXBElement<NodeId> typeNode = new JAXBElement<NodeId>(qArgName, NodeId.class, argumentType);
				inputArgExtensionObject.setTypeId(typeNode);
				
				argList.add(inputArgExtensionObject);
			}
			
			inputArgsValue.setAny(inputArgsListOfExtensionObjects);
			
			ListOfReferences inputArgsListOfRefs = new ListOfReferences();
			List<Reference> inputArgsRefList = methodListOfRefs.getReference();
			
			// set reference from class to method
			Reference methodRef = new Reference();
			methodRef.setReferenceType("HasComponent");
			methodRef.setIsForward(false);
			methodRef.setValue(method.getNodeId());
			refList.add(methodRef);
						
			// TODO: set Modelling rule
			methodRef = new Reference();
			methodRef.setReferenceType("HasModellingRule");
			methodRef.setIsForward(false);
			methodRef.setValue("i=78");
			methodRefList.add(methodRef);
			
			// set reference from method to input arguments
			Reference inputArgsRef = new Reference();
			inputArgsRef.setReferenceType("HasProperty");
			inputArgsRef.setIsForward(false);
			inputArgsRef.setValue(inputArgs.getNodeId());
			inputArgsRefList.add(inputArgsRef);
			
			inputArgsRef = new Reference();
			inputArgsRef.setReferenceType("HasTypeDefinition");
			inputArgsRef.setIsForward(false);
			inputArgsRef.setValue("i=68");
			inputArgsRefList.add(inputArgsRef);
						
			// set references
			method.setReferences(methodListOfRefs);
			inputArgs.setReferences(inputArgsListOfRefs);
			
			// TODO: configure "Value"
			
			extensionList.add(method);
			extensionList.add(inputArgs);
		}
		
		// TODO: add parsing of state machines
		
		for (Behavior behavior: classElement.getOwnedBehaviors())
		{
			if(behavior instanceof StateMachineImpl)
			{				
				System.out.println(behavior.getName());
			}
		}
		
	}
	
	private static String convertQualifiedNameToNodeId(String qualifiedName)
	{
		
		return qualifiedName.replace("::","/");
		
	}
	
	private static String convertQualifiedNameToNodeId(String qualifiedName, ArrayList<String> names) {
		
		String nodeId = qualifiedName.replace("::","/");
		
		for(String name : names)
		{
			nodeId = nodeId + "/" + name;
		}
		
		return nodeId;
	}
	
	private static String extendNodeId(String nodeId, String extension)
	{
		return nodeId+ "/" + extension;
	}
	
}
