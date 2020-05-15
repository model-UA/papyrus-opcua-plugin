package org.eclipse.papyrus.designer.languages.opcua.codegen.ui.handlers;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.designer.languages.common.base.HierarchyLocationStrategy;
import org.eclipse.papyrus.designer.languages.common.base.ILocationStrategy;
import org.eclipse.papyrus.designer.languages.opcua.codegen.transformations.OpcUaModelElementCreator;
import org.eclipse.papyrus.infra.tools.file.IPFileSystemAccess;
import org.eclipse.papyrus.infra.tools.file.ProjectBasedFileAccess;
import org.eclipse.papyrus.uml.diagram.common.handlers.CmdHandler;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;

public class GenerateCodeHandler extends CmdHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
 		System.out.println("OPC-UA Information Model generation execution started!");
 		updateSelectedEObject();
		if(selectedEObject instanceof PackageableElement)
		{
			PackageableElement packageableElement = (PackageableElement) selectedEObject;
			
			IProject project = getCurrentProject();
			if(project != null)
			{
				IPFileSystemAccess fileSystemAccess = new ProjectBasedFileAccess(project);
				ILocationStrategy locStrategy =  new HierarchyLocationStrategy();
				// get container for the current element
				OpcUaModelElementCreator elem_creator = new OpcUaModelElementCreator(fileSystemAccess ,locStrategy);
				generate(elem_creator, packageableElement);
			}
		}
		else if(selectedEObject == null)
		{
			System.err.println("selectedEObject is null !");
		}

 		System.out.println("OPC-UA Information Model generation execution ended!");
		return null;
	}

	private void generate(OpcUaModelElementCreator elem_creator, PackageableElement packageableElement) {
		try {
			elem_creator.createPackageableElement(packageableElement);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private IProject getCurrentProject() {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		URI uri = selectedEObject.eResource().getURI();
		IProject project = root.getProject(uri.segment(1));
		return project;
	}
	
//	public boolean isEnabled()
//	{
//		updateSelectedEObject();
//		return (selectedEObject instanceof Package || selectedEObject instanceof Classifier);
//	}

}
