package org.eclipse.papyrus.opcua.diagram.transformer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.IPath;
import org.eclipse.papyrus.opcua.diagram.Activator;
import org.eclipse.papyrus.opcua.diagram.listener.DiagramChangeListener;
import org.eclipse.papyrus.opcua.diagram.listener.FileChangeListener;
import org.eclipse.papyrus.opcua.nodeset.parser.NodeSetParser;
import org.eclipse.papyrus.opcua.nodeset.parser.NodeSetReader;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UANodeSetTypeImpl;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class SynchHandler {

	private ArrayList<InstanceSyncHandler> instances;
	private HashMap<UANodeSetType, InstanceSyncHandler> nodeSetModelMapping;
	private HashMap<Model, InstanceSyncHandler> modelNodeSetMapping;
	private HashMap<String, InstanceSyncHandler> projectMapping;
	
	public SynchHandler()
	{
		this.instances = new ArrayList<InstanceSyncHandler>();
		this.nodeSetModelMapping = new HashMap<UANodeSetType, InstanceSyncHandler>();
		this.modelNodeSetMapping = new HashMap<Model, InstanceSyncHandler>();
		this.projectMapping = new HashMap<String, InstanceSyncHandler>();
		
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
		
		this.projectMapping.put(umlModel.getName(), instance);
	}
	
	public boolean writeToNodeSet(IResourceDelta nodeSetDelta)
	{
		IResource resource = nodeSetDelta.getResource();
		String fileName = resource.getLocation().removeFileExtension().lastSegment();

		if(!this.projectMapping.containsKey(fileName))
		{
			return false;
		}
		
		boolean success = true;
		
		DiagramChangeListener.disable(true);
		Activator.getFileChangeListener().disable(true);
		try
		{
			this.projectMapping.get(fileName).writeToNodeSetFile();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			success = false;
		}
		finally
		{			
			DiagramChangeListener.disable(false);
			Activator.getFileChangeListener().disable(false);
		}
		     
		return success;
	}
	
	public boolean updateObject(Element obj)
	{
		return updateObject(obj, false);
	}
		
	public boolean updateObject(Element obj, boolean writeToFile)	
	{
		Model model = obj.getModel();
		if(this.modelNodeSetMapping.containsKey(model))
		{
			boolean success = this.modelNodeSetMapping.get(model).updateMember(obj);
			
			if(success && writeToFile)
			{
				try {
					// disable the resource listener as we're going to change the NodeSet File
					Activator.getFileChangeListener().disable(true);
					success = this.modelNodeSetMapping.get(model).writeToNodeSetFile();
					// enable resource listener again
					Activator.getFileChangeListener().disable(false);
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
	
	public boolean updateNodeSet(IResourceDelta nodeSetDelta)
	{
		IResource resource = nodeSetDelta.getResource();
		String filePath = resource.getLocation().toString();
		String fileName = resource.getLocation().removeFileExtension().lastSegment();
		
		if(!this.projectMapping.containsKey(fileName))
		{
			return false;
		}
		
		UANodeSetType nodeSet = readNodeset(filePath);
		if(nodeSet == null)
		{
			return false;
		}
		boolean success = true;
		
		DiagramChangeListener.disable(true);
		try
		{
			this.projectMapping.get(fileName).updatedMember(nodeSet);			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			success = false;
		}
		finally
		{			
			DiagramChangeListener.disable(false);
		}
		     
		return success;
	}
	
	private UANodeSetType readNodeset(String filePath)
	{

		UANodeSetType nodeSet = new UANodeSetTypeImpl();
		nodeSet = NodeSetParser.readNodeSet(filePath);
				
		return nodeSet;
	}

	public boolean removeObject(Model model, Element obj) {

		if(this.modelNodeSetMapping.containsKey(model))
		{
			boolean success = this.modelNodeSetMapping.get(model).removeMember(obj);
			if(success)
			{
				try {
					// disable the resource listener as we're going to change the NodeSet File
					Activator.getFileChangeListener().disable(true);
					success = this.modelNodeSetMapping.get(model).writeToNodeSetFile();			
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					return false;
				}
				finally
				{			
					// enable resource listener again
					Activator.getFileChangeListener().disable(false);
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
