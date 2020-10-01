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
package org.eclipse.papyrus.opcua.diagram;

import java.util.HashMap;

public class OpcUaDiagramResources {
	
	public static final String PROFILES_PATHMAP = "pathmap://OPC_UA_PROFILES/"; //$NON-NLS-1$	

	public static final String UANODESET_PROFILE_PATH = PROFILES_PATHMAP+"UANodeSet.profile.uml";
	
	public static final String LIBRARIES_PATHMAP = "pathmap://OPC_UA_LIBRARIES/"; //$NON-NLS-1$	

	public static final String UANODESET_LIBRARY_PATH = LIBRARIES_PATHMAP+"UANodeSet.uml";
	
	public static final HashMap<String, String> NAMESPACE_PACKAGE_MAPPING = new HashMap<String, String>()
	{{
		
	}};
	
	
	private OpcUaDiagramResources() {
	}
		
}
