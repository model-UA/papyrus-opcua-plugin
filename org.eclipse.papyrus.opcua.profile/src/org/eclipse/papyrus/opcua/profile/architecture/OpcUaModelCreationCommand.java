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
package org.eclipse.papyrus.opcua.profile.architecture;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.opcua.profile.OpcUaProfileResources;
import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.InformationModel;
import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.InformationModelImpl;
import org.eclipse.papyrus.uml.diagram.common.commands.ModelCreationCommandBase;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.papyrus.opcua.profile.Activator;

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
		Profile basetypesProfile = (Profile) PackageUtil.loadPackage(URI.createURI(OpcUaProfileResources.BASETYPES_PROFILE_PATH), owner.eResource().getResourceSet());
		if (basetypesProfile != null) {
			PackageUtil.applyProfile(packageOwner, basetypesProfile, true);
		}
		
		Profile typesProfile = (Profile) PackageUtil.loadPackage(URI.createURI(OpcUaProfileResources.TYPES_PROFILE_PATH), owner.eResource().getResourceSet());
		if (typesProfile != null) {
			PackageUtil.applyProfile(packageOwner, typesProfile, true);
		}
		
		Model model = (Model) owner;
		model.setViewpoint("InformationModel");
		Activator.getSynchHandler().registerNewUmlModel(model);
	}

}
