package org.eclipse.papyrus.designer.languages.opcua.codegen.transformations;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.designer.languages.common.base.ILocationStrategy;
import org.eclipse.papyrus.designer.languages.common.base.ModelElementsCreator;
import org.eclipse.papyrus.infra.tools.file.IPFileSystemAccess;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.internal.impl.PackageImpl;
import org.eclipse.uml2.uml.internal.impl.PropertyImpl;
import org.eclipse.uml2.uml.internal.impl.StateMachineImpl;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.uml2.uml.Package;
import org.eclipse.papyrus.designer.languages.opcua.codegen.xtend.*;

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

	public void createPackageableElement(PackageableElement packageableElement) {
		final String filename = locStrategy.getFileName((NamedElement) packageableElement) + ".xml";
		
		String output = "asdfsafd";
		Model model = packageableElement.getModel();
		String modelname = model.getName();
		parsePackagedElements(model.getPackagedElements());

		//output.concat(OpcUaPackageHeaderGenerator.generateCode(pack).toString());
		fileSystemAccess.generateFile(filename, output);
	}
	
	private void parsePackagedElements(EList<PackageableElement> packagedElements)
	{
		for (PackageableElement elem: packagedElements)
		{
			if(elem instanceof PackageImpl)
			{
				System.out.println(elem.getName());
				parsePackage( (PackageImpl) elem);
			}
			else if( elem instanceof ClassImpl)
			{
				System.out.println(elem.getName());
				parseClass((ClassImpl) elem);
			}
		}
	}
	
	private void parsePackage(PackageImpl packageElement)
	{
		System.out.println(packageElement.getName());
		parsePackagedElements(packageElement.getPackagedElements());
	}
	
	private void parseClass(ClassImpl classElement)
	{
		for (Property attrib: classElement.getOwnedAttributes())
		{
			System.out.println(attrib.getName());
		}
		
		for (Operation operation: classElement.getOwnedOperations())
		{
			System.out.println(operation.getName());
		}
		
		for (Behavior behavior: classElement.getOwnedBehaviors())
		{
			if(behavior instanceof StateMachineImpl)
			{				
				System.out.println(behavior.getName());
			}
		}
		
	}
	
	@Override
	protected void createPackageableElementFile(PackageableElement arg0, IProgressMonitor arg1) {
		// TODO Auto-generated method stub
		
	}

}
