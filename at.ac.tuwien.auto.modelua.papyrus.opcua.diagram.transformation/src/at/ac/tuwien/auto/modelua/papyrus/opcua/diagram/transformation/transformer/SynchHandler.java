package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.transformer;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UANodeSetTypeImpl;

import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.Activator;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.listener.DiagramChangeListener;
import at.ac.tuwien.auto.modelua.papyrus.opcua.nodeset.parser.NodeSetParser;

public class SynchHandler {

	private ArrayList<InstanceSyncHandler> instances;
	private HashMap<Model, InstanceSyncHandler> modelMapping;
	private HashMap<String, InstanceSyncHandler> projectMapping;
	
	public SynchHandler()
	{
		this.instances = new ArrayList<InstanceSyncHandler>();
		this.modelMapping = new HashMap<Model, InstanceSyncHandler>();
		this.projectMapping = new HashMap<String, InstanceSyncHandler>();
		
	}
	
	public void registerNewUmlModel(Model umlModel)
	{
		
		URI uri = umlModel.eResource().getURI();
		String path = uri.trimFileExtension().devicePath().substring("/resource/".length());
		
		if(this.modelMapping.containsKey(umlModel))
		{
			return;
		}
		
		UANodeSetType nodeset = new UANodeSetTypeImpl();
		InstanceSyncHandler instance = new InstanceSyncHandler(umlModel, nodeset);
		this.instances.add(instance);
		this.modelMapping.put(umlModel, instance);

		this.projectMapping.put(path, instance);
	}
	
	public boolean modelIsRegistered(Model umlModel)
	{
		if(this.modelMapping.containsKey(umlModel))
		{
			return true;
		}
		
		return false;
	}
	
	public boolean modelIsRegistered(URI modelUri)
	{
		String path = modelUri.trimFileExtension().devicePath().substring("/resource/".length());
		
		if(this.projectMapping.containsKey(path))
		{
			return true;
		}
		
		return false;
	}
	
	public void deleteNodeSet(IResourceDelta nodeSetDelta)
	{
		IResource resource = nodeSetDelta.getResource();
		String fileName = getFilePath(resource);
		InstanceSyncHandler handler = this.projectMapping.get(fileName);
		Model modelKey = null;
		
		for(Model model : this.modelMapping.keySet())
		{
			if(this.modelMapping.get(model).equals(handler))
			{
				modelKey = model;
			}
		}
		
		this.projectMapping.remove(fileName);
		this.modelMapping.remove(modelKey);
	}
	
	public boolean exportNodeSetTo(URI modelUri, String exportPath)
	{
		String path = modelUri.trimFileExtension().devicePath().substring("/resource/".length());
		
		if(!this.projectMapping.containsKey(path))
		{
			return false;
		}
		
		boolean success = true;
		
		DiagramChangeListener.disable(true);
		Activator.getFileChangeListener().disable(true);
		try
		{
			this.projectMapping.get(path).writeToNodeSetFile(exportPath);
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
	
	public boolean writeToNodeSet(IResourceDelta nodeSetDelta)
	{
		IResource resource = nodeSetDelta.getResource();
		
		String workspaceUri = getWorkspacePath();
		
		String filePath = workspaceUri + "/"+ getFilePath(resource) + ".xml";
		
		return writeToNodeSet(nodeSetDelta, filePath);
	}
	
	public boolean writeToNodeSet(IResourceDelta nodeSetDelta, String exportPath)
	{
		IResource resource = nodeSetDelta.getResource();
		String fileName = getFilePath(resource);
				
		if(!this.projectMapping.containsKey(fileName))
		{
			return false;
		}
		
		boolean success = true;
		
		DiagramChangeListener.disable(true);
		Activator.getFileChangeListener().disable(true);
		try
		{
			this.projectMapping.get(fileName).writeToNodeSetFile(exportPath);
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
		if(this.modelMapping.containsKey(model))
		{
			boolean success = this.modelMapping.get(model).transformMember(obj);
			
			if(success && writeToFile)
			{
				Activator.getFileChangeListener().disable(true);
				try {
					// disable the resource listener as we're going to change the NodeSet File
					success = this.modelMapping.get(model).writeToNodeSetFile();
				} catch (ParserConfigurationException e) {
					success =  false;
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
	
	public boolean updateNodeSetFrom(URI modelUri, String importPath)
	{
		String modelPath = modelUri.trimFileExtension().devicePath().substring("/resource/".length());
		
		if(!this.projectMapping.containsKey(modelPath))
		{
			return false;
		}
		
		UANodeSetType nodeSet = readNodeset(importPath);
		if(nodeSet == null)
		{
			return false;
		}
		boolean success = true;
		
		DiagramChangeListener.disable(true);
		try
		{
			this.projectMapping.get(modelPath).updatedMember(nodeSet);			
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
	
	public boolean updateNodeSet(IResourceDelta nodeSetDelta)
	{
		IResource resource = nodeSetDelta.getResource();
		String filePath = resource.getLocation().toString();
		String fileName = getFilePath(resource);
		
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

		if(this.modelMapping.containsKey(model))
		{
			boolean success = this.modelMapping.get(model).removeMember(obj);
			if(success)
			{
				// disable the resource listener as we're going to change the NodeSet File
				Activator.getFileChangeListener().disable(true);
				try {
					success = this.modelMapping.get(model).writeToNodeSetFile();			
				} catch (ParserConfigurationException e) {
					success = false;
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
	
	private String getFilePath(IResource resource)
	{
		IWorkspace workspace = resource.getWorkspace();
		String workspaceUri = workspace.getRoot().getRawLocationURI().toString();
		String fileUri = resource.getRawLocationURI().toString();
		int fileExtension=fileUri.length()- resource.getFileExtension().length()-1;
	
		return fileUri.substring(workspaceUri.length()+1, fileExtension);
		
	}

	public boolean importNodeSetFrom(URI modelUri, String filepath) {
		
		String modelPath = modelUri.trimFileExtension().devicePath().substring("/resource/".length());
		
		if(!this.projectMapping.containsKey(modelPath))
		{
			return false;
		}
		
		return this.projectMapping.get(modelPath).importPackage(filepath);
	}
	
	private static String getWorkspacePath()
	{
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IPath workspacePath = root.getLocation();	
		return workspacePath.toOSString();
	}
	
}
