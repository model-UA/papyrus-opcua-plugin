package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.util;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UMLPlugin;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;

import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.OpcUaDiagramResources;

public class ModelCreator {

	private static final String UML_PROFILE_PATH ="../at.ac.tuwien.auto.modelua.papyrus.opcua.profile/resources/profile/UANodeSet.profile.uml";
	private static final String BASENAMESPACE_LIBRARY_PATH ="../at.ac.tuwien.auto.modelua.papyrus.opcua.libraries/resources/libraries/Opc.Ua.NodeSet2/Opc.Ua.NodeSet2.uml";
	
	public static Model createEmptyTestModel()
	{
		UMLResourcesUtil.initGlobalRegistries();	
		
		
		ResourceSet rset = new ResourceSetImpl();
		UMLResourcesUtil.init(rset);
		
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl()); //$NON-NLS-1$
		
		Map<URI,URI> uriMap = rset.getURIConverter().getURIMap();
		uriMap.put(URI.createURI("pathmap://OPC_UA_PROFILES/UANodeSet.profile.uml"), URI.createURI(UML_PROFILE_PATH));
		
		Resource res = rset.createResource(URI.createURI("./model.uml"));
		
		Model umlTestModel = UMLFactory.eINSTANCE.createModel();
	
		res.getContents().add(umlTestModel);
		initializeNodeSet(umlTestModel, rset);
		loadBaseNodeSet(umlTestModel, rset);
		
		umlTestModel.setViewpoint(OpcUaDiagramResources.DIAGRAM_VIEWPOINT);
		
		return umlTestModel;
	}
	
	private static void initializeNodeSet(Model model, ResourceSet owner_resource)
	{
		// Loading the profile
		Resource resource = owner_resource.getResource(URI.createURI(UML_PROFILE_PATH), true);
		Profile basetypesProfile =  (Profile) EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.PROFILE);
		
		if (basetypesProfile != null) {
			PackageUtil.applyProfile(model, basetypesProfile, true);
			EPackage definitionPackage = (EPackage) basetypesProfile.getDefinition();
			owner_resource.getPackageRegistry().put(definitionPackage.getNsURI(),definitionPackage);
			UMLPlugin.getEPackageNsURIToProfileLocationMap().put(definitionPackage.getNsURI(), EcoreUtil.getURI(basetypesProfile)); 	
		}
		Stereotype nodeSetType   = basetypesProfile.getOwnedStereotype("UANodeSetType");
		model.applyStereotype(nodeSetType);
	}
	
	private static void loadBaseNodeSet(Model model, ResourceSet owner_resource)
	{
		// TODO: do not import Base Namespace if base namespace is beeing updated
//		URI lib_path = URI.createURI(BASENAMESPACE_LIBRARY_PATH);
		
		Resource resource = owner_resource.getResource(URI.createURI(BASENAMESPACE_LIBRARY_PATH), true);
		
		Package defaultNs =  (Package) EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.PACKAGE);				
		//PackageUtil.loadPackage(lib_path, owner_resource);
		
		if (defaultNs != null) {
			model.createPackageImport(defaultNs);
		}
	}
	
}
