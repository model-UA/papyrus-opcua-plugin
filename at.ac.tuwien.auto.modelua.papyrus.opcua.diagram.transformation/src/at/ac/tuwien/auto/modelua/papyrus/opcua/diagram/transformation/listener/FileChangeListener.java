package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.listener;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.IPath;

import at.ac.tuwien.auto.modelua.papyrus.opcua.console.OpcUaMessageConsole;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.Activator;
import at.ac.tuwien.auto.modelua.papyrus.opcua.preferences.PreferenceProvider;

public class FileChangeListener implements IResourceChangeListener{
	
	private boolean disabled = false;
	private boolean disable_once = false;
	
	
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		
		if(this.disabled)
		{
			return;
		}
		
		IResourceDelta rootDelta = event.getDelta();
		if(rootDelta == null)
		{
			return;
		}
		
		checkChildren(rootDelta);
		
	}
	
	private void checkChildren( IResourceDelta affectedObject)
	{

		IPath filePath = affectedObject.getFullPath();
		if(filePath.getFileExtension() != null)
		{
			String fileExtension = filePath.getFileExtension();
			if(fileExtension.equalsIgnoreCase("xml") && PreferenceProvider.getNodeSetAutoReload())
			{			
				// Workaround: if xml was written ignore the first trigger
				if(this.disable_once)
				{
					this.disable_once = false;
				}
				else if(affectedObject.getKind() == IResourceDelta.CHANGED)
				{
					boolean success = Activator.getSynchHandler().updateNodeSet(affectedObject);
					if(success)
					{
						OpcUaMessageConsole.info("UML NodeSet backend updated succesfully");
					}
					else
					{
						OpcUaMessageConsole.error("Error when updating UML NodeSet backend");
					}
				}
			}
			else if(fileExtension.equalsIgnoreCase("uml"))
			{
				if(affectedObject.getKind() == IResourceDelta.REMOVED)
				{
					Activator.getSynchHandler().deleteNodeSet(affectedObject);
				}
				else if(affectedObject.getKind() == IResourceDelta.CHANGED)
				{
					boolean success = Activator.getSynchHandler().writeToNodeSet(affectedObject);
					if(success)
					{
						OpcUaMessageConsole.info("NodeSet file written succesfully");
						
						String exportPath = PreferenceProvider.getExportPath();
						
						if( PreferenceProvider.getNodeSetAutoExport() &&
							exportPath.length() > 0)
						{
							
							if(PreferenceProvider.getCreateWorkspaceFolderHierarchyInExportDir())
							{
								if(!exportPath.endsWith("/"))
								{
									exportPath += "/";
								}
								
								String folderPath = getFolderPath(affectedObject);
								exportPath = exportPath+folderPath;
								
							}
							
							if(!exportPath.endsWith("/"))
							{
								exportPath += "/";
							}
							
							String filename = getFileName(affectedObject);
							exportPath = exportPath+filename+".xml";
							
							success = Activator.getSynchHandler().writeToNodeSet(affectedObject, exportPath);
							if(!success)
							{
								OpcUaMessageConsole.error("Error when exporting NodeSet file to "+exportPath);
							}
						}
					}
					else
					{
						OpcUaMessageConsole.error("Error when writing NodeSet file");
					}

				}
						
			}
		}
		for (IResourceDelta affectedChild : affectedObject.getAffectedChildren())
		{
			checkChildren(affectedChild);
		}
	}
	
	public void disable(boolean disable)
	{
		this.disabled = disable;
		if(disable)
		{
			this.disable_once = true;
		}
	}
	
	private String getFolderPath(IResourceDelta resourceDelta)
	{
		IResource resource = resourceDelta.getResource();
		
		IWorkspace workspace = resource.getWorkspace();
		String workspaceUri = workspace.getRoot().getRawLocationURI().toString();
		String fileUri = resource.getRawLocationURI().toString();
		int fileName=fileUri.length()- resource.getName().length()-1;
	
		return fileUri.substring(workspaceUri.length()+1, fileName);
	
	}
	
	private String getFileName(IResourceDelta resourceDelta)
	{
		IResource resource = resourceDelta.getResource();
		
		String fileUri = resource.getRawLocationURI().toString();
		int fileEName=fileUri.length()- resource.getName().length();
		int fileExtension=fileUri.length()- resource.getFileExtension().length()-1;
	
		return fileUri.substring(fileEName, fileExtension);
		
	}
}
