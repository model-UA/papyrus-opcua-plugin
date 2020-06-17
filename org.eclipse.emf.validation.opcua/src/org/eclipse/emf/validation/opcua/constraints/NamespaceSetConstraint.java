package org.eclipse.emf.validation.opcua.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Class;

public class NamespaceSetConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EObject parent = eObj.eContainer();
		
		String namespace = "";
		while(true)
		{
			if(parent instanceof Package)
			{
				Package package_elem = (Package) parent;
				if(package_elem.getURI() != null && package_elem.getURI().length() > 0)
				{					
					namespace = package_elem.getURI();
					break;
				}
			}
			else if(parent instanceof Model)
			{
				Model model_elem = (Model) parent;
				namespace = model_elem.getURI();
				break;
			}
			parent = parent.eContainer();
			if(parent == null )
			{
				break;
			}
		}
		if(namespace.length() == 0)
		{
			return ctx.createFailureStatus(new Object[] { eObj.eClass()
		               .getName() + ": '" + ((Class) eObj).getName() + "'" });
		}
		
		return ctx.createSuccessStatus();
	}

}
