package org.eclipse.papyrus.designer.languages.opcua.codegen.transformations;

import java.awt.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.opcfoundation.ua._2011._03.uanodeset.ListOfReferences;
import org.opcfoundation.ua._2011._03.uanodeset.LocalizedText;
import org.opcfoundation.ua._2011._03.uanodeset.Reference;
import org.opcfoundation.ua._2011._03.uanodeset.UAMethod;
import org.opcfoundation.ua._2011._03.uanodeset.UANode;
import org.opcfoundation.ua._2011._03.uanodeset.UANodeSet;
import org.opcfoundation.ua._2011._03.uanodeset.UAObjectType;
import org.opcfoundation.ua._2011._03.uanodeset.UAVariable;
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
	
	public void writeToFile(UANodeSet nodeset)
	{
		String output ="";
		
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
			else if(node instanceof UAVariable)
			{
				converterOpcUAVariable((UAVariable) node );
			}
		}
		
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
		Element uaMethod = this.doc.createElement("UAObjectType");
		uaMethod.setAttribute("BrowseName", method.getBrowseName());
		uaMethod.setAttribute("NodeId", method.getNodeId());
		uaMethod.setAttribute("ParentNodeId", method.getParentNodeId());
		
		addDisplayName(uaMethod, method.getDisplayName());
		
		ListOfReferences uaRefList = method.getReferences();
		convertReferences(uaMethod, uaRefList);
		
		this.root.appendChild(uaMethod);
	}
	
	private void converterOpcUAVariable(UAVariable variable)
	{
		Element uaVariable = this.doc.createElement("UAObjectType");
		uaVariable.setAttribute("BrowseName", variable.getBrowseName());
		uaVariable.setAttribute("NodeId", variable.getNodeId());
		uaVariable.setAttribute("ParentNodeId", variable.getParentNodeId());
		uaVariable.setAttribute("DataType", variable.getDataType());
		
		addDisplayName(uaVariable, variable.getDisplayName());
		
		if(variable.getArrayDimensions() != null)
		{
			uaVariable.setAttribute("ArrayDimensions", variable.getArrayDimensions());
		}
		
		ListOfReferences uaRefList = variable.getReferences();
		convertReferences(uaVariable, uaRefList);
		
		this.root.appendChild(uaVariable);
	}
	
	
	private void addDisplayName(Element uaObjType, java.util.List<LocalizedText> displayName) {
		// TODO Auto-generated method stub
		
		Element displayElement = this.doc.createElement("DisplayName");
		String text ="";
		
		for(LocalizedText line : displayName)
		{
			text += line.toString() + "\n";
		}
		
		displayElement.setTextContent(text);
		uaObjType.appendChild(displayElement);
	}
	
	private void convertReferences(Element parent, ListOfReferences uaRefList)
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
