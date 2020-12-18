package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.matchers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Stereotype;

public class UANodeGeneralizationMatcher implements IElementMatcher {

	public UANodeGeneralizationMatcher() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean matches(EObject eObject) {
		// TODO Auto-generated method stub
		System.out.println("asdfsadfa");
		if(eObject instanceof Generalization)
		{
			System.out.println("aaaaaaaaaaaaaaaaaaaa");
			Generalization gen = (Generalization)eObject;
//			for (Stereotype ster:gen.getAppliedStereotypes())
//			{
//				String stereotypeName = ster.getName();
//				if(stereotypeName.equalsIgnoreCase("Reference"))
//				{
					boolean valid = true;
					for (Element src : gen.getSources())
					{
						if(src instanceof Class)
						{
							System.out.println("Source:"+ ((Class)src).getName() );
							valid &= elementIsUaNode((Class)src );
						}
					}
					
					for (Element dest : gen.getTargets())
					{
						if(dest instanceof Class)
						{
							System.out.println("Target:"+ ((Class)dest).getName() );
							valid &= elementIsUaNode((Class)dest );
						}
					}
					System.out.println("valid:"+ valid);
					return valid;
//				}
//			}
//			System.out.println("asdfsadfsadfdsafsadfsadf:");
		}
		
		return true;
	}
	
	private boolean elementIsUaNode(Class elem)
	{
		for (Stereotype ster:elem.getAppliedStereotypes())
		{
			String stereotypeName = ster.getName();
			switch(stereotypeName)
			{
				case "UADataType":
				case "UAMethod":
				case "UAObject":
				case "UAObjectType":
				case "UAReferenceType":
				case "UAVariable":
				case "UAVariableType":
				case "UAView":
					return true;
			}
		}
		return false;
	}
}
