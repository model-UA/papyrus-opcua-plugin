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
package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram;

import java.util.HashMap;
import java.util.Map;

import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformer.SynchHandler;

public class OpcUaDiagramResources {
	
	public static SynchHandler DIAGRAM_SYNCH_HANDLER = Activator.getSynchHandler();
	
	public static final String DIAGRAM_VIEWPOINT ="NodeSet InformationModel";
	
	public static final String PROFILES_PATHMAP = "pathmap://OPC_UA_PROFILES/"; //$NON-NLS-1$	

	public static final String UANODESET_PROFILE_PATH = PROFILES_PATHMAP+"UANodeSet.profile.uml";
	
	public static final String LIBRARIES_PATHMAP = "pathmap://OPC_UA_LIBRARIES/"; //$NON-NLS-1$	

	public static final String BASENAMESPACE_LIBRARY = LIBRARIES_PATHMAP+"Opc.Ua.NodeSet2/Opc.Ua.NodeSet2.uml";
		
	public static final Map<String , String> NAMESPACE_PACKAGE_MAPPING = new HashMap<String , String>() {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		put("http://opcfoundation.org/UA/Safety", LIBRARIES_PATHMAP+"Opc.Ua.Safety.NodeSet2/Opc.Ua.Safety.NodeSet2.uml");
	}};
	
	private OpcUaDiagramResources() {
	}
		
}
