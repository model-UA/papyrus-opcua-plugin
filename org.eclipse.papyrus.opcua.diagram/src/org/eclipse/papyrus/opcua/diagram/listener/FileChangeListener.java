package org.eclipse.papyrus.opcua.diagram.listener;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.papyrus.opcua.diagram.Activator;

public class FileChangeListener implements IResourceChangeListener{
	
	private boolean disabled = false;
		
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		
		if(this.disabled)
		{
			return;
		}
		
		// TODO Auto-generated method stub
		IResourceDelta rootDelta = event.getDelta();
		if(rootDelta == null)
		{
			return;
		}
		IResourceDelta[] affectedProjects = rootDelta.getAffectedChildren();
		
		for (IResourceDelta affectedProject : affectedProjects)
		{
			IResourceDelta[] affectedObjects = affectedProject.getAffectedChildren();
			
			for(IResourceDelta affectedObject : affectedObjects)
			{
				if(affectedObject.getFullPath().getFileExtension().equalsIgnoreCase("xml"))
				{
					Activator.getSynchHandler().updateNodeSet(affectedObject);
				}
				else if(affectedObject.getFullPath().getFileExtension().equalsIgnoreCase("uml"))
				{
					Activator.getSynchHandler().writeToNodeSet(affectedObject);
				}
				
			}
			
		}
	}
	
	public void disable(boolean disable)
	{
		this.disabled = disable;
	}
}
