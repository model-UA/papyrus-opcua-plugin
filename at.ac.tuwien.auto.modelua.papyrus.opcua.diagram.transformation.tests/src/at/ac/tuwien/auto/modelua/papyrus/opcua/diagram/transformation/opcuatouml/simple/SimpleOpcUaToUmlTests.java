/**
 * 
 */
package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.opcuatouml.simple;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UADataType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAMethod;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObject;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObjectType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAReferenceType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariableType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAView;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UriTable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UADataTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAMethodImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UANodeSetTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAObjectImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAObjectTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAReferenceTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAVariableImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAVariableTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAViewImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UriTableImpl;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.EventPublisher;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.opcuatouml.TransformerHandler;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.util.ModelCreator;

/**
 * @author christoph
 *
 */
class SimpleOpcUaToUmlTests{
	
	private Model umlTestModel;
	private UANodeSetType opcUaTestNodeset;
	private HashMap<Element, Object> matching;
	private HashMap<String, Element> nodeIdMap;
	
	
	private static final String TEST_URI = "https://test-URI.com";
	private static final String TEST_BROWSENAME = "test-uaDataType";
	private static final String TEST_NODEID = "s=test-uaDataType";
	
	private TransformerHandler testObject;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {	
		umlTestModel = ModelCreator.createEmptyTestModel();
		
		opcUaTestNodeset = new UANodeSetTypeImpl();	
		matching = new HashMap<Element, Object>();
		nodeIdMap = new HashMap<String, Element>();
		
		testObject = new TransformerHandler(umlTestModel, opcUaTestNodeset, matching, nodeIdMap);
		EventPublisher.enableEvents(false);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}
	
	void simpleUaNodeChecks(Stereotype uaSter)
	{
		EList<NamedElement> members = umlTestModel.getOwnedMembers();
		
		if(members.size() > 1)
		{
			fail("Too many elements in UML Model");
		}
		else if(members.size() < 1)
		{
			fail("Not enough elements in UML Model");
		}
		else if(! (members.get(0) instanceof Class))
		{
			fail("Element is not of Type class");
		}
		
		Class uaCls = (Class)members.get(0);
		
		boolean nodeIdSet = uaCls.hasValue(uaSter, "nodeId");
		boolean browseNameSet = uaCls.hasValue(uaSter, "browseName");
		
		if(! uaCls.isStereotypeApplied(uaSter))
		{
			fail("Inocorrect Stereotype is applied");
		}
		else if(!nodeIdSet && !browseNameSet )
		{
			fail("NodeId and BrowseName not set");
		}
		else if(!nodeIdSet )
		{
			fail("NodeId not set");
		}
		else if(!browseNameSet )
		{
			fail("BrowseName not set");
		}
		
		String nodeId = String.valueOf(uaCls.getValue(uaSter, "nodeId"));
		String browseName = String.valueOf(uaCls.getValue(uaSter, "browseName"));
		
		if(!nodeId.equals(TEST_NODEID.substring(2)))
		{
			System.out.println("Wrong NodeId, got " + nodeId+ " expected " + TEST_NODEID.substring(2));
			fail("Wrong NodeId, got " + nodeId+ " expected " + TEST_NODEID.substring(2));
		}
		else if(!browseName.equals(TEST_BROWSENAME) )
		{
			fail("Wrong BrowseName, got " + browseName+ " expected " + TEST_BROWSENAME);
		}
	}
	
	@Test
	void simpleNamespaceShallBeTransformed() {
		UriTable uritbl = new UriTableImpl();
		uritbl.getUri().add(TEST_URI);
		this.opcUaTestNodeset.setNamespaceUris(uritbl);
		
		boolean success = testObject.run(opcUaTestNodeset);
		
		if(!success)
		{
			fail("Error in transformation");			
		}
		
		EList<Package> namespaces = umlTestModel.getNestedPackages();
		
		if(namespaces.size() > 1)
		{
			fail("Too many namespaces in model, namespace count: " + String.valueOf(umlTestModel.getNestedPackages().size()));
		}
		else if(namespaces.size() < 1)
		{
			fail("No namespaces in model");
		}
		else if(! namespaces.get(0).getName().equals(TEST_URI))
		{
			fail("Wrong namespace in model, got " + namespaces.get(0).getName());
		}
	}

	@Test
	void simpleUADataTypeShallBeTransformed() {
		UADataType uadt = new UADataTypeImpl();
		uadt.setBrowseName(TEST_BROWSENAME);
		uadt.setNodeId(TEST_NODEID);
		
		opcUaTestNodeset.getUADataType().add(uadt);
		
		boolean success = testObject.run(opcUaTestNodeset);
		
		if(!success)
		{
			fail("Error in transformation");			
		}
		
		Profile prof = umlTestModel.getAppliedProfile("NodeSet");
		Stereotype uaSter = prof.getOwnedStereotype("UADataType");
		simpleUaNodeChecks(uaSter);		
	}

	@Test
	void simpleUAObjectTypeShallBeTransformed() {
		UAObjectType uaot = new UAObjectTypeImpl();
		uaot.setBrowseName(TEST_BROWSENAME);
		uaot.setNodeId(TEST_NODEID);
		
		opcUaTestNodeset.getUAObjectType().add(uaot);
		
		boolean success = testObject.run(opcUaTestNodeset);
		
		if(!success)
		{
			fail("Error in transformation");			
		}

		Profile prof = umlTestModel.getAppliedProfile("NodeSet");
		Stereotype uaSter = prof.getOwnedStereotype("UAObjectType");
		
		simpleUaNodeChecks(uaSter);
	}

	@Test
	void simpleUAReferenceTypeShallBeTransformed() {
		
		UAReferenceType uart = new UAReferenceTypeImpl();
		uart.setBrowseName(TEST_BROWSENAME);
		uart.setNodeId(TEST_NODEID);
		
		opcUaTestNodeset.getUAReferenceType().add(uart);
		
		boolean success = testObject.run(opcUaTestNodeset);
		
		if(!success)
		{
			fail("Error in transformation");			
		}
		
		Profile prof = umlTestModel.getAppliedProfile("NodeSet");
		Stereotype uaSter = prof.getOwnedStereotype("UAReferenceType");
		
		simpleUaNodeChecks(uaSter);
	}

	@Test
	void simpleUAVariableTypeShallBeTransformed() {
		UAVariableType uavt = new UAVariableTypeImpl();
		uavt.setBrowseName(TEST_BROWSENAME);
		uavt.setNodeId(TEST_NODEID);
		
		opcUaTestNodeset.getUAVariableType().add(uavt);
		
		boolean success = testObject.run(opcUaTestNodeset);
		
		if(!success)
		{
			fail("Error in transformation");			
		}
		
		Profile prof = umlTestModel.getAppliedProfile("NodeSet");
		Stereotype uaSter = prof.getOwnedStereotype("UAVariableType");
		simpleUaNodeChecks(uaSter);
	}
	
	@Test
	void simpleUAMethodShallBeTransformed() {
		UAMethod uam = new UAMethodImpl();
		uam.setBrowseName(TEST_BROWSENAME);
		uam.setNodeId(TEST_NODEID);
		
		opcUaTestNodeset.getUAMethod().add(uam);
		
		boolean success = testObject.run(opcUaTestNodeset);
		
		if(!success)
		{
			fail("Error in transformation");			
		}
		
		Profile prof = umlTestModel.getAppliedProfile("NodeSet");
		Stereotype uaSter = prof.getOwnedStereotype("UAMethod");
		simpleUaNodeChecks(uaSter);
	}
	
	@Test
	void simpleUAObjectShallBeTransformed() {
		UAObject uao = new UAObjectImpl();
		uao.setBrowseName(TEST_BROWSENAME);
		uao.setNodeId(TEST_NODEID);
		
		opcUaTestNodeset.getUAObject().add(uao);
		
		boolean success = testObject.run(opcUaTestNodeset);
		
		if(!success)
		{
			fail("Error in transformation");			
		}
		
		Profile prof = umlTestModel.getAppliedProfile("NodeSet");
		Stereotype uaSter = prof.getOwnedStereotype("UAObject");
		simpleUaNodeChecks(uaSter);
	}
	
	@Test
	void simpleUAVariableShallBeTransformed() {
		UAVariable uav = new UAVariableImpl();
		uav.setBrowseName(TEST_BROWSENAME);
		uav.setNodeId(TEST_NODEID);
		uav.setDataType("i=24");
		
		opcUaTestNodeset.getUAVariable().add(uav);
		
		boolean success = testObject.run(opcUaTestNodeset);
		
		if(!success)
		{
			fail("Error in transformation");			
		}
		
		Profile prof = umlTestModel.getAppliedProfile("NodeSet");
		Stereotype uaSter = prof.getOwnedStereotype("UAVariable");
		simpleUaNodeChecks(uaSter);
	}
	
	@Test
	void simpleUAViewShallBeTransformed() {
		UAView uav = new UAViewImpl();
		uav.setBrowseName(TEST_BROWSENAME);
		uav.setNodeId(TEST_NODEID);
		
		opcUaTestNodeset.getUAView().add(uav);
		
		boolean success = testObject.run(opcUaTestNodeset);
		
		if(!success)
		{
			fail("Error in transformation");			
		}
		
		Profile prof = umlTestModel.getAppliedProfile("NodeSet");
		Stereotype uaSter = prof.getOwnedStereotype("UAView");
		simpleUaNodeChecks(uaSter);
	}
}
