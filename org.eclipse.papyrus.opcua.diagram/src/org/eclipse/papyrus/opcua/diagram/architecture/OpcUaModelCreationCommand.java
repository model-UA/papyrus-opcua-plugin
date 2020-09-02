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
package org.eclipse.papyrus.opcua.diagram.architecture;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.opcua.diagram.Activator;
import org.eclipse.papyrus.opcua.diagram.OpcUaProfileResources;
import org.eclipse.papyrus.uml.diagram.common.commands.ModelCreationCommandBase;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;

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
		URI uri_path = URI.createURI(OpcUaProfileResources.UANODESET_PROFILE_PATH);
		ResourceSet owner_resource = owner.eResource().getResourceSet(); 
		Profile basetypesProfile = (Profile) PackageUtil.loadPackage(uri_path, owner_resource);
		if (basetypesProfile != null) {
			PackageUtil.applyProfile(packageOwner, basetypesProfile, true);
		}
		Model model = (Model) owner;
		
		URI lib_path = URI.createURI(OpcUaProfileResources.UANODESET_LIBRARY_PATH);
		Package pack = PackageUtil.loadPackage(lib_path, owner_resource);
		if (pack != null) {
			model.createPackageImport(pack);
		}
		model.setViewpoint("InformationModel");
		
		Activator.getSynchHandler().registerNewUmlModel(model);

		initializeNodeSet(model, basetypesProfile);
	}
	
	private void initializeNodeSet(Model model, Profile nodeSetProfile)
	{
		Stereotype nodeSetType   = nodeSetProfile.getOwnedStereotype("UANodeSetType");
		Class nodeSet = model.createOwnedClass("NodeSet", false);
		nodeSet.applyStereotype(nodeSetType);
		
//		Stereotype uriTableType  = nodeSetProfile.getOwnedStereotype("UriTable");
//		Class namespaceUriTable = model.createOwnedClass("NameSpaces", false);
//		namespaceUriTable.applyStereotype(uriTableType);
//				
//		nodeSet.setValue(nodeSetType, "nameSpaceUris", namespaceUriTable.getStereotypeApplication(uriTableType));
//		
//		for(EStructuralFeature feature : featuresList)
//		{
//			int id = feature.getFeatureID();
//			String name = feature.getName();
//			Object temp = nodeSetApplication.dynamicGet(id);
//			
//			if(name.equals("nameSpaceUris"))
//			{
//				Object test = nodeSet.getValue(nodeSetType, "nameSpaceUris");
//				
//				String tes ="asdfsa";
//			}
//			else if(name.equals("permissions"))
//			{
//
//				String tes ="asdfsa";
//			}
//		}
//		
		
		
	}
}
