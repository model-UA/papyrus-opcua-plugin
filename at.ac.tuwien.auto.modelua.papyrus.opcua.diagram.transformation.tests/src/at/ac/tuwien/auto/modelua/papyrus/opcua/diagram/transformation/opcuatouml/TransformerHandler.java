package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.opcuatouml;

import java.util.HashMap;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;

public class TransformerHandler {
	
	private OpcUaToUmlTransformer transformer;
	
	public TransformerHandler(Model umlModel, UANodeSetType nodeset, HashMap<Element, Object> matching, HashMap<String, Element> nodeIdMap)
	{
		transformer = new OpcUaToUmlTransformer(umlModel, nodeset, matching, nodeIdMap);
	}
	
	public boolean run(UANodeSetType nodset)
	{
		return transformer.transformMember(nodset);
	}
}
