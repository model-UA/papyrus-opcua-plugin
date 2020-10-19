/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.architecture;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.uml.diagram.common.commands.ModelCreationCommandBase;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;

import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.Activator;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.OpcUaDiagramResources;

/**
 */
public class OpcUaModelCreationCommand extends ModelCreationCommandBase {

	/**
	 * @see org.eclipse.papyrus.infra.core.extension.commands.ModelCreationCommandBase#createRootElement()
	 *
	 * @return
	 */

	@Override
	protected EObject createRootElement() {
		return UMLFactory.eINSTANCE.createModel();
	}

	/**
	 * A standard Library model should have :
	 *  - the Library profile applied
	 *  
	 * @see org.eclipse.papyrus.infra.core.extension.commands.ModelCreationCommandBase#initializeModel(org.eclipse.emf.ecore.EObject)
	 *
	 * @param owner
	 */

	@Override
	protected void initializeModel(EObject owner) {
		super.initializeModel(owner);
		Package packageOwner = (Package) owner;
		// Retrieve profiles and apply it
		URI uri_path = URI.createURI(OpcUaDiagramResources.UANODESET_PROFILE_PATH);
		ResourceSet owner_resource = owner.eResource().getResourceSet(); 
		Profile basetypesProfile = (Profile) PackageUtil.loadPackage(uri_path, owner_resource);
		if (basetypesProfile != null) {
			PackageUtil.applyProfile(packageOwner, basetypesProfile, true);
		}
		
		Model model = (Model) owner;
		
		// TODO: do not import Base Namespace if base namespace is beeing updated
		URI lib_path = URI.createURI(OpcUaDiagramResources.BASENAMESPACE_LIBRARY);
		Package defaultNs = PackageUtil.loadPackage(lib_path, owner_resource);
		if (defaultNs != null) {
			model.createPackageImport(defaultNs);
		}
		
		model.setViewpoint("InformationModel");
		
		Activator.getSynchHandler().registerNewUmlModel(model);

		initializeNodeSet(model, basetypesProfile);
	}
	
	private void initializeNodeSet(Model model, Profile nodeSetProfile)
	{
		Stereotype nodeSetType   = nodeSetProfile.getOwnedStereotype("UANodeSetType");
		model.applyStereotype(nodeSetType);
//		Class nodeSet = model.createOwnedClass("NodeSet", false);
//		nodeSet.applyStereotype(nodeSetType);
	}
}
