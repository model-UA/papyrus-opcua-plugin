package at.ac.tuwien.auto.modelua.designer.languages.opcua.codegen.transformations;

import java.awt.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;
import javax.xml.bind.JAXBElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.opcfoundation.ua._2008._02.types.Argument;
import org.opcfoundation.ua._2008._02.types.ExtensionObject;
import org.opcfoundation.ua._2008._02.types.ListOfExtensionObject;
import org.opcfoundation.ua._2008._02.types.NodeId;
import org.opcfoundation.ua._2011._03.uanodeset.ListOfReferences;
import org.opcfoundation.ua._2011._03.uanodeset.LocalizedText;
import org.opcfoundation.ua._2011._03.uanodeset.Reference;
import org.opcfoundation.ua._2011._03.uanodeset.UAMethod;
import org.opcfoundation.ua._2011._03.uanodeset.UANode;
import org.opcfoundation.ua._2011._03.uanodeset.UANodeSet;
import org.opcfoundation.ua._2011._03.uanodeset.UAObject;
import org.opcfoundation.ua._2011._03.uanodeset.UAObjectType;
import org.opcfoundation.ua._2011._03.uanodeset.UAVariable;
import org.opcfoundation.ua._2011._03.uanodeset.UAVariable.Value;
import org.opcfoundation.ua._2011._03.uanodeset.UriTable;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class OpcUaNodeSetWriter {
	
	Document doc;
	Element root;
	public OpcUaNodeSetWriter(Document doc)
	{
		this.doc = doc;
		this.root = doc.createElementNS("http://opcfoundation.org/UA/2011/03/UANodeSet.xsd", "UANodeSet");
		this.root.setAttribute("xmlns","http://opcfoundation.org/UA/2011/03/UANodeSet.xsd");
		this.root.setAttribute("xmlns:uax","http://opcfoundation.org/UA/2008/02/Types.xsd");
		this.root.setAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
		this.root.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
		this.doc.appendChild(this.root);
	}
	
	public void convertToXml(UANodeSet nodeset)
	{
		convertNamespaces(nodeset.getNamespaceUris());
		
		for( UANode node : nodeset.getUAObjectOrUAVariableOrUAMethod())
		{
			if(node instanceof UAObjectType)
			{
				converterOpcUAObjectType((UAObjectType)node);
			}
			else if(node instanceof UAMethod)
			{
				converterOpcUAMethod((UAMethod) node );
			}
			else if(node instanceof UAObject)
			{
				converterOpcUAObject((UAObject) node );
			}			
			else if(node instanceof UAVariable)
			{
				converterOpcUAVariable((UAVariable) node );
			}
		}
	}
	
	private void convertNamespaces(UriTable namespace_table)
	{
		Element namespaceUris = this.doc.createElement("NamespaceUris");
		
		for(String namespace : namespace_table.getUri())
		{
			if(namespace != null && namespace.length() > 0)
			{
				Element namespaceElement = this.doc.createElement("Uri");
				namespaceElement.setTextContent(namespace);
				namespaceUris.appendChild(namespaceElement);				
			}
		}
		
		this.root.appendChild(namespaceUris);
	}
	
	private void converterOpcUAObjectType(UAObjectType uaObject)
	{
		Element uaObjType = this.doc.createElement("UAObjectType");
		uaObjType.setAttribute("BrowseName", uaObject.getBrowseName());
		uaObjType.setAttribute("NodeId", uaObject.getNodeId());
		
		addDisplayName(uaObjType, uaObject.getDisplayName());
		
		ListOfReferences uaRefList = uaObject.getReferences();
		convertReferences(uaObjType, uaRefList);
		
		this.root.appendChild(uaObjType);
	}

	private void converterOpcUAMethod(UAMethod method)
	{
		Element uaMethod = this.doc.createElement("UAMethod");
		uaMethod.setAttribute("BrowseName", method.getBrowseName());
		uaMethod.setAttribute("NodeId", method.getNodeId());
		uaMethod.setAttribute("ParentNodeId", method.getParentNodeId());
		
		addDisplayName(uaMethod, method.getDisplayName());
		
		ListOfReferences uaRefList = method.getReferences();
		convertReferences(uaMethod, uaRefList);
		
		this.root.appendChild(uaMethod);
	}
	
	private void converterOpcUAObject(UAObject obj)
	{
		Element uaObject = this.doc.createElement("UAObject");
		uaObject.setAttribute("BrowseName", obj.getBrowseName());
		uaObject.setAttribute("NodeId", obj.getNodeId());
		uaObject.setAttribute("ParentNodeId", obj.getParentNodeId());
		
		addDisplayName(uaObject, obj.getDisplayName());
		
		ListOfReferences uaRefList = obj.getReferences();
		convertReferences(uaObject, uaRefList);
		
		this.root.appendChild(uaObject);
	}
	
	private void converterOpcUAVariable(UAVariable variable)
	{
		Element uaVariable = this.doc.createElement("UAVariable");
		uaVariable.setAttribute("BrowseName", variable.getBrowseName());
		uaVariable.setAttribute("NodeId", variable.getNodeId());
		uaVariable.setAttribute("ParentNodeId", variable.getParentNodeId());
		
		
		if(variable.getDataType().length() > 0)
		{
			uaVariable.setAttribute("DataType", variable.getDataType());
		}
		addDisplayName(uaVariable, variable.getDisplayName());
		
		if(variable.getArrayDimensions() != null && variable.getArrayDimensions().length() > 0)
		{
			uaVariable.setAttribute("ArrayDimensions", variable.getArrayDimensions());
		}
		
		ListOfReferences uaRefList = variable.getReferences();
		convertReferences(uaVariable, uaRefList);
		
		if(variable.getBrowseName().equals("InputArguments") || variable.getBrowseName().equals("OutputArguments")) 
		{
			uaVariable.setAttribute("ValueRank", "1");
			Element uaValue = this.doc.createElement("Value");
			addInputArguments(uaValue, variable.getValue());
			uaVariable.appendChild(uaValue);
		}
		
		this.root.appendChild(uaVariable);
	}
	
	private void addInputArguments(Element argsElement, Value args)
	{
		Element uaListOfExtensions = this.doc.createElement("uax:ListOfExtensionObject");
		ListOfExtensionObject listOfExtensions = (ListOfExtensionObject) args.getAny();
		
		for(ExtensionObject arg : listOfExtensions.getExtensionObject())
		{
			Element uaExtensionObject = this.doc.createElement("uax:ExtensionObject");
			Argument argument = (Argument) arg.getBody().getValue().getAny();
			
			// set type
			Element uaTypeID = this.doc.createElement("uax:TypeId");
			Element uaIdentifier = this.doc.createElement("uax:Identifier");
			String idstr= arg.getTypeId().getValue().getIdentifier().getValue();
			uaIdentifier.setTextContent(idstr);
			uaTypeID.appendChild(uaIdentifier);
			uaExtensionObject.appendChild(uaTypeID);
			
			// set body
			Element uaBody = this.doc.createElement("uax:Body");
			Element uaArgument = this.doc.createElement("uax:Argument");
			
			Element uaArgumentName = this.doc.createElement("uax:Name");
			uaArgumentName.setTextContent(argument.getName().getValue());
			uaArgument.appendChild(uaArgumentName);
			
			Element uaDataType = this.doc.createElement("uax:DataType");
			Element uaDataTypeIdentifier = this.doc.createElement("uax:Identifier");		
			idstr = argument.getDataType().getValue().getIdentifier().getValue();
			uaDataTypeIdentifier.setTextContent(idstr);
			uaDataType.appendChild(uaDataTypeIdentifier);
			uaArgument.appendChild(uaDataType);
			
			Element uaValueRank = this.doc.createElement("uax:ValueRank");
			uaValueRank.setTextContent(argument.getValueRank().toString());
			uaArgument.appendChild(uaValueRank);

//			Element uaArrayDim = this.doc.createElement("uax:ArrayDimensions");
//			uaArrayDim.setTextContent(argument.getArrayDimensions().getValue().getUInt32().get(0).toString());
//			uaArgument.appendChild(uaArrayDim);
			
			Element uaDescription = this.doc.createElement("uax:Description");
//			Element uaEncoding = this.doc.createElement("uax:Encoding");
//			uaEncoding.setTextContent("0");
//			uaDescription.appendChild(uaEncoding);
//			Element uaLocale= this.doc.createElement("uax:Locael");
//			uaDescription.appendChild(uaLocale);
//			Element uaText = this.doc.createElement("uax:Text");
//			uaDescription.appendChild(uaText);
			
			uaArgument.appendChild(uaDescription);
			
			uaBody.appendChild(uaArgument);
			uaExtensionObject.appendChild(uaBody);
			
			uaListOfExtensions.appendChild(uaExtensionObject);
		}
		
		argsElement.appendChild(uaListOfExtensions);
	}
	
	private void addDisplayName(Element uaObjType, java.util.List<LocalizedText> displayName) {
		// TODO Auto-generated method stub
		
		Element displayElement = this.doc.createElement("DisplayName");
		String text ="";
		
		for(LocalizedText line : displayName)
		{
			text += line.getLocale();
		}
		
		displayElement.setTextContent(text);
		uaObjType.appendChild(displayElement);
	}
	
	private void convertReferences(Element parent, ListOfReferences uaRefList)
	{
		if(uaRefList.getReference().size() > 0)
		{
			Element references = this.doc.createElement("References");
			
			for( Reference uaRef : uaRefList.getReference() )
			{
				Element reference = this.doc.createElement("Reference");
				
				if(uaRef.isIsForward())
				{
					reference.setAttribute("IsForward", "true");
				}
				else
				{
					reference.setAttribute("IsForward", "false");
				}
				reference.setAttribute("ReferenceType", uaRef.getReferenceType());
				reference.setTextContent(uaRef.getValue());
				
				references.appendChild(reference);
			}
			
			parent.appendChild(references);
		}
	}
}
