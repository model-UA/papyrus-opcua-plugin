package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.listener;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.IPath;

import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.Activator;

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
		
		checkChildren(rootDelta);
		
	}
	
	private void checkChildren( IResourceDelta affectedObject)
	{

		IPath filePath = affectedObject.getFullPath();
		if(filePath.getFileExtension() != null)
		{
			String fileExtension = filePath.getFileExtension();
			if(fileExtension.equalsIgnoreCase("xml"))
			{
				boolean success = Activator.getSynchHandler().updateNodeSet(affectedObject);
				if(success)
				{
					System.out.println("UML NodeSet backend updated succesfully");
				}
				else
				{
					System.err.print("Error when updating UML NodeSet backend");
				}
			}
			else if(fileExtension.equalsIgnoreCase("uml"))
			{
				boolean success = Activator.getSynchHandler().writeToNodeSet(affectedObject);
				if(success)
				{
					System.out.println("NodeSet file written succesfully");
				}
				else
				{
					System.err.print("Error when writing NodeSet file");
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
	}
}
