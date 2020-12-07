package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.util;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.mapping.ecore2xml.Ecore2XMLPackage;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resources.ResourcesPlugin;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.eclipse.uml2.uml.util.UMLUtil;

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
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		rset.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		rset.getPackageRegistry().put(UMLPackage.eCONTENT_TYPE, UMLPackage.eINSTANCE);
		rset.getPackageRegistry().put(UMLPackage.eNAME, UMLPackage.eINSTANCE);
		rset.getPackageRegistry().put(UMLPackage.eNS_PREFIX, UMLPackage.eINSTANCE);
		
		EPackage.Registry.INSTANCE.put(UMLPackage.eNS_URI,EPackage.Registry.INSTANCE.get(UMLPackage.eINSTANCE.getNsURI()));
		Ecore2XMLPackage.eINSTANCE.getEClassifiers();
		
		// override wrong pathmap mapping in UMLResourcesUtil
		final URL UMLJarredFileLocation = ResourcesPlugin.class.getResource("ResourcesPlugin.class");
		String UMLJarPath = UMLJarredFileLocation.toString();
		UMLJarPath = UMLJarPath.substring(0, UMLJarPath.indexOf('!'));	
		
		uriMap.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP),  URI.createURI(UMLJarPath+ "!/libraries/"));
		uriMap.put(URI.createURI(UMLResource.METAMODELS_PATHMAP), URI.createURI(UMLJarPath+ "!/metamodels/"));
		uriMap.put(URI.createURI(UMLResource.PROFILES_PATHMAP), URI.createURI(UMLJarPath+ "!/profiles/"));
		
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
//		URI uri_path = URI.createURI(UML_PROFILE_PATH);
		
		Resource resourceEcore = owner_resource.getResource(URI.createURI(UMLResource.PROFILES_PATHMAP+"Ecore.profile.uml"), true);
		
		Profile ecoreProfile= (Profile) EcoreUtil.getObjectByType(resourceEcore.getContents(), UMLPackage.Literals.PROFILE);		
		ecoreProfile.define();
		Resource resource = owner_resource.getResource(URI.createURI(UML_PROFILE_PATH), true);
//		Profile basetypesProfile = (Profile) EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.PACKAGE);				
		
		resource.getContents().add(ecoreProfile);
		Profile basetypesProfile = (Profile) UMLUtil.load(owner_resource,
				URI.createURI(UML_PROFILE_PATH),
				UMLPackage.Literals.PROFILE);

		basetypesProfile.define();
//		Profile basetypesProfile = (Profile) PackageUtil.loadPackage(uri_path, owner_resource);
		if (basetypesProfile != null) {
			PackageUtil.applyProfile(model, basetypesProfile, true);
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
