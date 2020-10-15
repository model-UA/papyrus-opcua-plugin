package at.ac.tuwien.auto.modelua.papyrus.opcua.nodeset.parser;

import java.io.StringWriter;

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

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.tools.file.IPFileSystemAccess;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.ListOfReferences;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.LocalizedText;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.Reference;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAMethod;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObject;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObjectType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UriTable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@Deprecated
public class NodeSetWriter {
	
	Document doc;
	Element root;
	
	public NodeSetWriter()
	{
		// get container for the current element
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			this.doc = builder.newDocument();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initDocument();
	}
	
	public NodeSetWriter(Document doc)
	{
		this.doc = doc;
		initDocument();
	}

	private void initDocument()
	{
		this.root = doc.createElementNS("http://opcfoundation.org/UA/2011/03/UANodeSet.xsd", "UANodeSet");
		this.root.setAttribute("xmlns","http://opcfoundation.org/UA/2011/03/UANodeSet.xsd");
		this.root.setAttribute("xmlns:uax","http://opcfoundation.org/UA/2008/02/Types.xsd");
		this.root.setAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
		this.root.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
		this.doc.appendChild(this.root);
	}
	
	public boolean writeToFile(String filePath, IPFileSystemAccess fileSystemAccess)
	{
	
		
		
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
			return false;
		}

		fileSystemAccess.generateFile(filePath, writer.toString());
		return true;
	}

	public void convertToXml(UANodeSetType nodeset)
	{
		convertNamespaces(nodeset.getNamespaceUris());
				
		for(UAObjectType node : nodeset.getUAObjectType())
		{
			converterOpcUAObjectType(node);
		}
		
		for(UAMethod node : nodeset.getUAMethod())
		{
			converterOpcUAMethod(node);
		}
		
		for(UAObject node : nodeset.getUAObject())
		{
			converterOpcUAObject(node);
		}
		
		for(UAVariable node : nodeset.getUAVariable())
		{
			converterOpcUAVariable(node);
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
		uaObjType.setAttribute("BrowseName", uaObject.getBrowseName() );
		uaObjType.setAttribute("NodeId", uaObject.getNodeId());
		
		addDisplayName(uaObjType, uaObject.getDisplayName());
		
		ListOfReferences uaRefList = uaObject.getReferences();
		if(uaRefList != null)
		{
			convertReferences(uaObjType, uaRefList);			
		}
		
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
		if(uaRefList != null)
		{
			convertReferences(uaMethod, uaRefList);
		}
		
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
		if(uaRefList != null)
		{
			convertReferences(uaObject, uaRefList);
		}
		
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
		if(uaRefList != null)
		{
			convertReferences(uaVariable, uaRefList);
		}
		
		if(variable.getBrowseName() != null &&
				(variable.getBrowseName().equals("InputArguments") || variable.getBrowseName().equals("OutputArguments"))) 
		{
			uaVariable.setAttribute("ValueRank", "1");
			Element uaValue = this.doc.createElement("Value");
			addInputArguments(uaValue, variable);
			uaVariable.appendChild(uaValue);
		}
		
		this.root.appendChild(uaVariable);
	}
	
	private void addInputArguments(Element argsElement, UAVariable args)
	{
//		Element uaListOfExtensions = this.doc.createElement("uax:ListOfExtensionObject");
//		ListOfExtensionObject listOfExtensions = (ListOfExtensionObject) args.getExtensions();
//		
//		for(ExtensionObject arg : listOfExtensions.getExtensionObject())
//		{
//			Element uaExtensionObject = this.doc.createElement("uax:ExtensionObject");
//			Argument argument = (Argument) arg.getBody().getAny();
//			
//			// set type
//			Element uaTypeID = this.doc.createElement("uax:TypeId");
//			Element uaIdentifier = this.doc.createElement("uax:Identifier");
//			String idstr= arg.getTypeId().getIdentifier();
//			uaIdentifier.setTextContent(idstr);
//			uaTypeID.appendChild(uaIdentifier);
//			uaExtensionObject.appendChild(uaTypeID);
//			
//			// set body
//			Element uaBody = this.doc.createElement("uax:Body");
//			Element uaArgument = this.doc.createElement("uax:Argument");
//			
//			Element uaArgumentName = this.doc.createElement("uax:Name");
//			uaArgumentName.setTextContent(argument.getName());
//			uaArgument.appendChild(uaArgumentName);
//			
//			Element uaDataType = this.doc.createElement("uax:DataType");
//			Element uaDataTypeIdentifier = this.doc.createElement("uax:Identifier");		
//			idstr = argument.getDataType().getIdentifier();
//			uaDataTypeIdentifier.setTextContent(idstr);
//			uaDataType.appendChild(uaDataTypeIdentifier);
//			uaArgument.appendChild(uaDataType);
//			
//			Element uaValueRank = this.doc.createElement("uax:ValueRank");
//			uaValueRank.setTextContent(String.valueOf(argument.getValueRank()));
//			uaArgument.appendChild(uaValueRank);
//
////			Element uaArrayDim = this.doc.createElement("uax:ArrayDimensions");
////			uaArrayDim.setTextContent(argument.getArrayDimensions().getValue().getUInt32().get(0).toString());
////			uaArgument.appendChild(uaArrayDim);
//			
//			Element uaDescription = this.doc.createElement("uax:Description");
////			Element uaEncoding = this.doc.createElement("uax:Encoding");
////			uaEncoding.setTextContent("0");
////			uaDescription.appendChild(uaEncoding);
////			Element uaLocale= this.doc.createElement("uax:Locael");
////			uaDescription.appendChild(uaLocale);
////			Element uaText = this.doc.createElement("uax:Text");
////			uaDescription.appendChild(uaText);
//			
//			uaArgument.appendChild(uaDescription);
//			
//			uaBody.appendChild(uaArgument);
//			uaExtensionObject.appendChild(uaBody);
//			
//			uaListOfExtensions.appendChild(uaExtensionObject);
//		}
//		
//		argsElement.appendChild(uaListOfExtensions);
	}
	
	private void addDisplayName(Element uaObjType, EList<LocalizedText> eList) {
		// TODO Auto-generated method stub
		
		Element displayElement = this.doc.createElement("DisplayName");
		String text ="";
		
		for(LocalizedText line : eList)
		{
			text += line.getValue() +"\n";
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
