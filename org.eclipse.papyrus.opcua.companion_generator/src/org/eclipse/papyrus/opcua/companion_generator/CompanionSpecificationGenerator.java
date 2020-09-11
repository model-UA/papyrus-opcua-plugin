package org.eclipse.papyrus.opcua.companion_generator;

import java.io.File;
import java.util.Arrays;
import java.util.EventObject;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.eclipse.papyrus.opcua.diagram.OpcUaProfileResources;
import org.eclipse.papyrus.opcua.nodeset.parser.NodeSetParser;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.util.UMLUtil;

public class CompanionSpecificationGenerator {
	
	private URI inputPath;
	private URI outputPath;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompanionSpecificationGenerator generator = new CompanionSpecificationGenerator();
		generator.parseArguments(args);
		generator.convertNodeSets();
	}
	
	private void parseArguments(String[] args)
	{
		Options options = new Options();
        options.addOption(Option.builder("c")
            .longOpt("companion-spec")
            .hasArg(true)
            .desc("Companion specification file or folder path that shall be parsed.")
            .required(true)
            .build());
        options.addOption(Option.builder("o")
            .longOpt("output-path")
            .hasArg(true)
            .desc("Folder path where converted file(s) shall be stored.")
            .required(false)
            .build());

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);

            if (cmd.hasOption("c") && cmd.hasOption("o")) {
            	this.inputPath = URI.createFileURI(cmd.getOptionValue("c"));
                System.out.println("Using input path " + inputPath);
                               
            	this.outputPath = URI.createFileURI(cmd.getOptionValue("o"));
                System.out.println("Using output path " + outputPath);
                
            }
            
        } catch (ParseException pe) {
            System.out.println("Error parsing command-line arguments!");
            System.out.println("Please, follow the instructions below:");
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "Log messages to sequence diagrams converter", options );
            System.exit(1);
     
        }
	}
	
	private void convertNodeSets()
	{
		File path = new File(this.inputPath.toFileString());
		
		if(path.isDirectory())
		{
			for(File child : path.listFiles())
			{
				convertFile(URI.createFileURI(child.getPath()));
			}
		}
		else
		{
			convertFile(this.inputPath);
		}		
	}
	
	private void convertFile(URI filepath)
	{
		UANodeSetType nodeset= NodeSetParser.readNodeSet(filepath.toFileString());

		Model nodeSetModel = UMLFactory.eINSTANCE.createModel();
		nodeSetModel.setName(filepath.trimFileExtension().lastSegment());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		UMLUtil.init(resourceSet);
		//resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory);
		
		URI uri_path = URI.createURI(OpcUaProfileResources.UANODESET_PROFILE_PATH);
				
		Profile basetypesProfile = (Profile) PackageUtil.loadPackage(uri_path, resourceSet);
		if (basetypesProfile != null) {
			PackageUtil.applyProfile(nodeSetModel, basetypesProfile, true);
		}
		
		//String test =" asfdsafdas";
		
	}
	
	
	
}
