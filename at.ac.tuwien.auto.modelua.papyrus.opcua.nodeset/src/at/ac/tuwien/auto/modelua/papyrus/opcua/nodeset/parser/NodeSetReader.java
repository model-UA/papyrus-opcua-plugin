package at.ac.tuwien.auto.modelua.papyrus.opcua.nodeset.parser;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.ListOfReferences;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.LocalizedText;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.Reference;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAMethod;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObject;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObjectType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UriTable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.ListOfReferencesImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.LocalizedTextImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.ReferenceImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAMethodImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UANodeSetTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAObjectImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAObjectTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAVariableImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UriTableImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;


@Deprecated
public class NodeSetReader {
	
	Document doc;
	Element root;
	public NodeSetReader(Document doc)
	{
		this.doc = doc;
		this.root = doc.getDocumentElement();
	}
	
	public UANodeSetType readNodeSet()
	{
		UANodeSetTypeImpl nodeset = new UANodeSetTypeImpl();
		Node child = (Node) this.root.getFirstChild();
		
		while(child != null)
		{
			String nodeName = child.getNodeName();
			
			if(nodeName.equalsIgnoreCase("NameSpaceUris"))
			{
				UriTable namespaces = parseNameSpaceUris(child);
				nodeset.setNamespaceUris(namespaces);
			}
			else if(nodeName.equalsIgnoreCase("UAObjectType"))
			{
				UAObjectType uaObjectType = parseUAObjectType(child);
				nodeset.getUAObjectType().add(uaObjectType);
			}
			else if(nodeName.equalsIgnoreCase("UAObject"))
			{
				UAObject uaObject = parseUAObject(child);
				nodeset.getUAObject().add(uaObject);
			}
			else if(nodeName.equalsIgnoreCase("UAVariable"))
			{
				UAVariable uaVariable = parseUAVariable(child);
				nodeset.getUAVariable().add(uaVariable);
			}else if(nodeName.equalsIgnoreCase("UAMethod"))
			{
				UAMethod uaMethod = parseUAMethod(child);
				nodeset.getUAMethod().add(uaMethod);
			}
			child = (Node) child.getNextSibling();
		}		
		
		return nodeset;
	}
	
	private UAMethod parseUAMethod(Node uaMethodNode) {
		UAMethodImpl uaMethod = new UAMethodImpl();
		
		Node child = (Node) uaMethodNode.getFirstChild();
		
		while(child != null)
		{
			
			String nodeName = child.getNodeName();
			
			if(nodeName.equalsIgnoreCase("Uri"))
			{
				String uri = child.getTextContent();
				
			}
			
			child = (Node) child.getNextSibling();
		}		
		
		NamedNodeMap attributes = uaMethodNode.getAttributes();
		Node browseName = attributes.getNamedItem("BrowseName");
		if(browseName != null)
		{
			uaMethod.setBrowseName(browseName.getNodeValue());			
		}
		Node nodeId = attributes.getNamedItem("NodeId");
		if(nodeId != null)
		{
			uaMethod.setNodeId(nodeId.getNodeValue());			
		}
			
		return uaMethod;
	}

	private UAVariable parseUAVariable(Node uaVariableNode) {
		UAVariableImpl uaVariable = new UAVariableImpl();
		
		Node child = (Node) uaVariableNode.getFirstChild();
		
		while(child != null)
		{
			
			String nodeName = child.getNodeName();
			
			if(nodeName.equalsIgnoreCase("Uri"))
			{
				String uri = child.getTextContent();
				
			}
			
			child = (Node) child.getNextSibling();
		}		
		
		NamedNodeMap attributes = uaVariableNode.getAttributes();
		Node browseName = attributes.getNamedItem("BrowseName");
		if(browseName != null)
		{
			uaVariable.setBrowseName(browseName.getNodeValue());			
		}
		Node nodeId = attributes.getNamedItem("NodeId");
		if(nodeId != null)
		{
			uaVariable.setNodeId(nodeId.getNodeValue());			
		}
		Node parentNodeId = attributes.getNamedItem("parentNodeId");
		if(parentNodeId != null)
		{
			uaVariable.setParentNodeId(parentNodeId.getNodeValue());			
		}
		Node datatype = attributes.getNamedItem("DataType");
		if(datatype != null)
		{
			uaVariable.setDataType(datatype.getNodeValue());			
		}
			
		return uaVariable;
	}

	private UAObject parseUAObject(Node uaObjectNode) {
		UAObjectImpl uaObject = new UAObjectImpl();
		
		Node child = (Node) uaObjectNode.getFirstChild();
		
		while(child != null)
		{
			
			String nodeName = child.getNodeName();
			
			if(nodeName.equalsIgnoreCase("Uri"))
			{
				String uri = child.getTextContent();
				
			}
			
			child = (Node) child.getNextSibling();
		}		
		
		NamedNodeMap attributes = uaObjectNode.getAttributes();
		Node browseName = attributes.getNamedItem("BrowseName");
		if(browseName != null)
		{
			uaObject.setBrowseName(browseName.getNodeValue());			
		}
		Node nodeId = attributes.getNamedItem("NodeId");
		if(nodeId != null)
		{
			uaObject.setNodeId(nodeId.getNodeValue());			
		}
		
		return uaObject;
	}

	private UriTable parseNameSpaceUris(Node namespaceUrisNode)
	{
		UriTableImpl namespaceTable = new UriTableImpl();
		EList<String> uris = namespaceTable.getUri();
		
		Node child = (Node) namespaceUrisNode.getFirstChild();
		
		while(child != null)
		{
			
			String nodeName = child.getNodeName();
			
			if(nodeName.equalsIgnoreCase("Uri"))
			{
				String uri = child.getTextContent();
				uris.add(uri);
			}
			
			child = (Node) child.getNextSibling();
		}		
		
		
		return namespaceTable;
		
	}
	
	private UAObjectType parseUAObjectType(Node uaObjectTypeNode)
	{
		UAObjectTypeImpl uaObjectType = new UAObjectTypeImpl();
		
		Node child = (Node) uaObjectTypeNode.getFirstChild();
		
		while(child != null)
		{
			String nodeName = child.getNodeName();
			
			if(nodeName.equalsIgnoreCase("DisplayName"))
			{
				String displayName = child.getTextContent();
				EList<LocalizedText> ltList = uaObjectType.getDisplayName();

				for(String line : displayName.split("\n")) 
				{
					LocalizedTextImpl displayNameLT = new LocalizedTextImpl();
					displayNameLT.setValue(line);
					ltList.add(displayNameLT);					
				}
			}
			else if(nodeName.equalsIgnoreCase("References"))
			{
				ListOfReferences uaListOfRef = parseReferecnes(child);
				uaObjectType.setReferences(uaListOfRef);
			}
			child = (Node) child.getNextSibling();
		}		
		
		NamedNodeMap attributes = uaObjectTypeNode.getAttributes();
		Node browseName = attributes.getNamedItem("BrowseName");
		if(browseName != null)
		{
			uaObjectType.setBrowseName(browseName.getNodeValue());			
		}
		Node nodeId = attributes.getNamedItem("NodeId");
		if(nodeId != null)
		{
			uaObjectType.setNodeId(nodeId.getNodeValue());			
		}
		
		return uaObjectType;
		
	}
	
	private ListOfReferences parseReferecnes(Node uaReferences)
	{
		ListOfReferencesImpl uaListOfReferences = new ListOfReferencesImpl();
		
		Node child = (Node) uaReferences.getFirstChild();
		
		while(child != null)
		{
			String nodeName = child.getNodeName();
			
			if(nodeName.equalsIgnoreCase("Reference"))
			{
				Reference ref = parseUAReference(child);
				uaListOfReferences.getReference().add(ref);
			}
			
			child = (Node) child.getNextSibling();
		}		
		
		return uaListOfReferences;
	}
	
	private Reference parseUAReference(Node uaReferenceNode)
	{
		ReferenceImpl uaReference = new ReferenceImpl();
		
		NamedNodeMap attributes = uaReferenceNode.getAttributes();
		Node isForward = attributes.getNamedItem("IsForward");
		if(isForward != null)
		{
			String stringToConvert = isForward.getNodeValue();
			boolean convertedBoolean = Boolean.parseBoolean(stringToConvert);
			uaReference.setIsForward(convertedBoolean);			
		}
		Node referenceType = attributes.getNamedItem("ReferenceType");
		if(referenceType != null)
		{
			uaReference.setReferenceType(referenceType.getNodeValue());			
		}
		
		
		return uaReference;
	}
	
}
