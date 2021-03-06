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
package at.ac.tuwien.auto.modelua.papyrus.opcua.profile;

public class OpcUaProfileResources {
//	Workaround for deploying plugins, uri_mapping is somehow not available in built plugin				
//	public static final String PROFILES_PATHMAP = "pathmap://OPC_UA_PROFILES/";
	public static final String PROFILES_PATHMAP = "platform:/plugin/at.ac.tuwien.auto.modelua.papyrus.opcua.profile/resources/profile/"; 

	public static final String UANODESET_PROFILE_PATH = PROFILES_PATHMAP+"UANodeSet.profile.uml";
	
	private OpcUaProfileResources() {
	}
		
}
