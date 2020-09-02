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
import org.eclipse.papyrus.opcua.nodeset.parser.NodeSetReader;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class NodeSetFileChangeListener implements IResourceChangeListener{

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		
		// TODO Auto-generated method stub
		IResource resource = event.getResource();
		IResourceDelta rootDelta = event.getDelta();
		IResourceDelta docDelta = rootDelta.findMember(new Path("/test-project/InformationModel.xml"));
		
        resource = docDelta.getResource();
        IPath location = resource.getLocation();
        
        File nodesetFile = new File(resource.getLocation().toString());
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document document = builder.parse(nodesetFile);
			document.getDocumentElement().normalize();
			NodeSetReader reader = new NodeSetReader(document);
			UANodeSetType nodeSet = reader.readNodeSet();
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        if (resource != null && resource.getFileExtension().equals("xml")) {
           // run the compiler
        	System.out.println("NodeSet Changed");
        }
	}

}
