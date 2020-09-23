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
					boolean success = Activator.getSynchHandler().updateNodeSet(affectedObject);
					if(success)
					{
						System.out.println("NodeSet updated succesfully");
					}
					else
					{
						System.err.print("Error when updating NodeSet");
					}
				}
				else if(affectedObject.getFullPath().getFileExtension().equalsIgnoreCase("uml"))
				{
					boolean success = Activator.getSynchHandler().writeToNodeSet(affectedObject);
					if(success)
					{
						System.out.println("NodeSet written succesfully");
					}
					else
					{
						System.err.print("Error when writing NodeSet");
					}
				}
				
			}
			
		}
	}
	
	public void disable(boolean disable)
	{
		this.disabled = disable;
	}
}
