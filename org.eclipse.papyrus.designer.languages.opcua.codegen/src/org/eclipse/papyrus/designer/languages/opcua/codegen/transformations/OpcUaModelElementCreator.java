package org.eclipse.papyrus.designer.languages.opcua.codegen.transformations;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.designer.languages.common.base.ILocationStrategy;
import org.eclipse.papyrus.designer.languages.common.base.ModelElementsCreator;
import org.eclipse.papyrus.infra.tools.file.IPFileSystemAccess;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.w3c.dom.Document;


public class OpcUaModelElementCreator extends ModelElementsCreator {
	
	public OpcUaModelElementCreator(IPFileSystemAccess fileSystemAccess, ILocationStrategy locStrategy) {
		this(fileSystemAccess, locStrategy, "OPC-UA Information Model");
		// TODO Auto-generated constructor stub
	}
	
	public OpcUaModelElementCreator(IPFileSystemAccess fileSystemAccess, ILocationStrategy locStrategy,
			String generatorLanguage) {
		super(fileSystemAccess, locStrategy, generatorLanguage);
		// TODO Auto-generated constructor stub
	}

	public void createPackageableElement(PackageableElement packageableElement) throws ParserConfigurationException {
		final String filename = locStrategy.getFileName((NamedElement) packageableElement) + ".xml";
		
		Model model = packageableElement.getModel();
		String modelname = model.getName();
		OpcUaUmlNodeSetConverter parser = new OpcUaUmlNodeSetConverter(model);
		parser.writeNodeSet(filename);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        
        OpcUaNodeSetWriter docWriter = new OpcUaNodeSetWriter(doc); 
		docWriter.writeToFile(parser.nodeset);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transf;
		try {
			transf = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
        
        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transf.setOutputProperty(OutputKeys.INDENT, "yes");
        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        
        StreamResult console = new StreamResult(System.out);
        DOMSource source = new DOMSource(doc);
        try {
			transf.transform(source, console);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//output.concat(OpcUaPackageHeaderGenerator.generateCode(pack).toString());
		//fileSystemAccess.generateFile(filename, output);
	}
	
	@Override
	protected void createPackageableElementFile(PackageableElement arg0, IProgressMonitor arg1) {
		// TODO Auto-generated method stub
		
	}

}
