package org.eclipse.papyrus.opcua.diagram.transformer;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UANodeSetTypeImpl;

public class SynchHandler {

	private ArrayList<InstanceSyncHandler> instances;
	private HashMap<UANodeSetType, InstanceSyncHandler> nodeSetModelMapping;
	private HashMap<Model, InstanceSyncHandler> modelNodeSetMapping;
	
	public SynchHandler()
	{
		this.instances = new ArrayList<InstanceSyncHandler>();
		this.nodeSetModelMapping = new HashMap<UANodeSetType, InstanceSyncHandler>();
		this.modelNodeSetMapping = new HashMap<Model, InstanceSyncHandler>();
		
	}
	
	public void registerNewUmlModel(Model umlModel)
	{
		if(this.modelNodeSetMapping.containsKey(umlModel))
		{
			return;
		}
		
		UANodeSetType nodeset = new UANodeSetTypeImpl();
		InstanceSyncHandler instance = new InstanceSyncHandler(umlModel, nodeset);
		this.instances.add(instance);
		this.nodeSetModelMapping.put(nodeset, instance);
		this.modelNodeSetMapping.put(umlModel, instance);
	}
	
	public boolean updateObject(Element obj)
	{
		Model model = obj.getModel();
		if(this.modelNodeSetMapping.containsKey(model))
		{
			boolean success = this.modelNodeSetMapping.get(model).updateMember(obj);
			if(success)
			{
				try {
					success = this.modelNodeSetMapping.get(model).writeToNodeSetFile();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					return false;
				}
			}
			return success;
		}
		else
		{
			return false;
		}
	}
	
	
}
