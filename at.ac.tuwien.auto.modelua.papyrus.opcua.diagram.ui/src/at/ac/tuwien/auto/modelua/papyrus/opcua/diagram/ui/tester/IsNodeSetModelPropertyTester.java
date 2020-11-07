package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.ui.tester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;

import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.OpcUaDiagramResources;

public class IsNodeSetModelPropertyTester extends PropertyTester {
	
	private final static String EXPORTABLE_MODEL_PROPERTY = "isNodeSetModel"; //$NON-NLS-1$
	private final static String DIAGRAM_VIEWPOINT = OpcUaDiagramResources.DIAGRAM_VIEWPOINT;
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		boolean propertyTest = false;
		if (EXPORTABLE_MODEL_PROPERTY.equals(property)) {
			if (receiver instanceof IStructuredSelection) {
				IStructuredSelection selection =(IStructuredSelection) receiver;
				
				if(selection.getFirstElement() instanceof EObjectTreeElement)
				{
					EObjectTreeElement treeElement = (EObjectTreeElement) selection.getFirstElement();
					if(treeElement.getEObject() instanceof Element ||
						treeElement.getEObject() instanceof CSSDiagramImpl)
					{
						Model model;
						if(treeElement.getEObject() instanceof CSSDiagramImpl)
						{
							CSSDiagramImpl diagramImpl = (CSSDiagramImpl) treeElement.getEObject();
							model = (Model) diagramImpl.getElement();
							
						}
						else
						{							
							Element elem = (Element) treeElement.getEObject();
							model = elem.getModel() ;
						}
						
						if( model != null)
						{							
							String viewpoint = model.getViewpoint();
							
							if(viewpoint != null && viewpoint.equalsIgnoreCase(DIAGRAM_VIEWPOINT))
							{
								propertyTest = true;
							}
						}
					}
				}
				
			}
		}
		return propertyTest;
	}

}
