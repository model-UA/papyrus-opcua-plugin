package org.eclipse.papyrus.opcua.diagram.listener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.papyrus.opcua.diagram.Activator;
import org.eclipse.papyrus.opcua.nodeset.parser.NodeSetReader;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class NodeSetFileChangeListener implements IResourceChangeListener{
	
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
			}
			
		}
	}
	
	public void disable(boolean disable)
	{
		this.disabled = disable;
	}
}
