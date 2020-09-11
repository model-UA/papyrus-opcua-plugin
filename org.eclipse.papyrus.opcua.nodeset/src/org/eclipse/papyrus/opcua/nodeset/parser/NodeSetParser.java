package org.eclipse.papyrus.opcua.nodeset.parser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.DocumentRoot;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.util.NodeSetResourceFactoryImpl;

public class NodeSetParser {

	public static boolean writeNodeSetFile(String filePath, UANodeSetType nodeset)
	{
		
        // Obtain a new resource set
        ResourceSet resourceSet = new ResourceSetImpl();

        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		(Resource.Factory.Registry.DEFAULT_EXTENSION, new NodeSetResourceFactoryImpl());
        
        resourceSet.getPackageRegistry().put(NodeSetPackage.eNS_URI, NodeSetPackage.eINSTANCE);
        
        // Create a simple Resource containing the model
        Resource resource = resourceSet.createResource(URI.createURI(""));
        resource.getContents().add(nodeset);
        
		
        // set metadata options, in particular utf-8 encoding attribute
        ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(resource.getResourceSet().getPackageRegistry());
        Map<Object,Object> options = new HashMap<Object,Object>();
        options.put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetaData);
        options.put(XMLResource.OPTION_ENCODING, "utf-8");

        // serialize/persist the model to a nodeset XML file
        URI nodesetURI = URI.createFileURI(filePath);
        resource.setURI(nodesetURI);

        try {
			resource.save(options);
	        System.out.println("Nodeset written to " + filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        System.err.println("Nodeset not written to " + filePath);
		}
        
		return false;
	}
	
	public static UANodeSetType readNodeSet (String filePath)
	{
				
		// Create a resource set to hold the resources.
		//
		ResourceSet resourceSet = new ResourceSetImpl();
		
		// Register the appropriate resource factory to handle all file extensions.
		//
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
			(Resource.Factory.Registry.DEFAULT_EXTENSION, 
			 new NodeSetResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		//
		resourceSet.getPackageRegistry().put
			(NodeSetPackage.eNS_URI, 
			 NodeSetPackage.eINSTANCE);
        
		URI nodesetURI = URI.createFileURI(filePath);
		UANodeSetType nodeset = null;
		try {
			// Demand load resource for this file.
			//
			Resource resource = resourceSet.getResource(nodesetURI, true);
			System.out.println("Loaded " + nodesetURI);

			// Validate the contents of the loaded resource.
			//
			
			//nodeset = (UANodeSetTypeImpl) resource.getContents().get(0);
			for (EObject eObject : resource.getContents()) {
				Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
				if (diagnostic.getSeverity() == Diagnostic.OK && 
					eObject instanceof DocumentRoot)
				{
					DocumentRoot docRoot = (DocumentRoot) eObject;
					nodeset = docRoot.getUANodeSet();
				}
			}
			
		}
		catch (RuntimeException exception) {
			System.out.println("Problem loading " + nodesetURI);
			exception.printStackTrace();
		}
		
		
		return nodeset;
	}
}
