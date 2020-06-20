/**
 */
package OPCUAProfile;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see OPCUAProfile.OPCUAProfileFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='OPC-UA Profile'"
 * @generated
 */
public interface OPCUAProfilePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "OPCUAProfile";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://opcfoundation.org";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "OPCUAProfile";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OPCUAProfilePackage eINSTANCE = OPCUAProfile.impl.OPCUAProfilePackageImpl.init();

	/**
	 * The meta object id for the '{@link OPCUAProfile.impl.BaseNodeClassImpl <em>Base Node Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see OPCUAProfile.impl.BaseNodeClassImpl
	 * @see OPCUAProfile.impl.OPCUAProfilePackageImpl#getBaseNodeClass()
	 * @generated
	 */
	int BASE_NODE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Node Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NODE_CLASS__NODE_ID = 0;

	/**
	 * The feature id for the '<em><b>Node Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NODE_CLASS__NODE_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Browse Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NODE_CLASS__BROWSE_NAME = 2;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NODE_CLASS__DISPLAY_NAME = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NODE_CLASS__DESCRIPTION = 4;

	/**
	 * The feature id for the '<em><b>Write Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NODE_CLASS__WRITE_MASK = 5;

	/**
	 * The number of structural features of the '<em>Base Node Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NODE_CLASS_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Base Node Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_NODE_CLASS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link OPCUAProfile.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see OPCUAProfile.impl.VariableImpl
	 * @see OPCUAProfile.impl.OPCUAProfilePackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 1;

	/**
	 * The feature id for the '<em><b>Node Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NODE_ID = BASE_NODE_CLASS__NODE_ID;

	/**
	 * The feature id for the '<em><b>Node Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NODE_CLASS = BASE_NODE_CLASS__NODE_CLASS;

	/**
	 * The feature id for the '<em><b>Browse Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__BROWSE_NAME = BASE_NODE_CLASS__BROWSE_NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__DISPLAY_NAME = BASE_NODE_CLASS__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__DESCRIPTION = BASE_NODE_CLASS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Write Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__WRITE_MASK = BASE_NODE_CLASS__WRITE_MASK;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__VALUE = BASE_NODE_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__DATA_TYPE = BASE_NODE_CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value Rank</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__VALUE_RANK = BASE_NODE_CLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Array Dimensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__ARRAY_DIMENSIONS = BASE_NODE_CLASS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Access Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__ACCESS_LEVEL = BASE_NODE_CLASS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>User Access Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__USER_ACCESS_LEVEL = BASE_NODE_CLASS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Minimum Sampling Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__MINIMUM_SAMPLING_INTERVAL = BASE_NODE_CLASS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Historizing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__HISTORIZING = BASE_NODE_CLASS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__BASE_CLASS = BASE_NODE_CLASS_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = BASE_NODE_CLASS_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_OPERATION_COUNT = BASE_NODE_CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link OPCUAProfile.impl.ObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see OPCUAProfile.impl.ObjectImpl
	 * @see OPCUAProfile.impl.OPCUAProfilePackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 2;

	/**
	 * The feature id for the '<em><b>Node Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__NODE_ID = BASE_NODE_CLASS__NODE_ID;

	/**
	 * The feature id for the '<em><b>Node Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__NODE_CLASS = BASE_NODE_CLASS__NODE_CLASS;

	/**
	 * The feature id for the '<em><b>Browse Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__BROWSE_NAME = BASE_NODE_CLASS__BROWSE_NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__DISPLAY_NAME = BASE_NODE_CLASS__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__DESCRIPTION = BASE_NODE_CLASS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Write Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__WRITE_MASK = BASE_NODE_CLASS__WRITE_MASK;

	/**
	 * The feature id for the '<em><b>Event Notifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__EVENT_NOTIFIER = BASE_NODE_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__BASE_CLASS = BASE_NODE_CLASS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_FEATURE_COUNT = BASE_NODE_CLASS_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_OPERATION_COUNT = BASE_NODE_CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link OPCUAProfile.impl.MethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see OPCUAProfile.impl.MethodImpl
	 * @see OPCUAProfile.impl.OPCUAProfilePackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 3;

	/**
	 * The feature id for the '<em><b>Node Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__NODE_ID = BASE_NODE_CLASS__NODE_ID;

	/**
	 * The feature id for the '<em><b>Node Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__NODE_CLASS = BASE_NODE_CLASS__NODE_CLASS;

	/**
	 * The feature id for the '<em><b>Browse Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__BROWSE_NAME = BASE_NODE_CLASS__BROWSE_NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__DISPLAY_NAME = BASE_NODE_CLASS__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__DESCRIPTION = BASE_NODE_CLASS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Write Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__WRITE_MASK = BASE_NODE_CLASS__WRITE_MASK;

	/**
	 * The feature id for the '<em><b>Executable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__EXECUTABLE = BASE_NODE_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>User Executable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__USER_EXECUTABLE = BASE_NODE_CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__BASE_CLASS = BASE_NODE_CLASS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = BASE_NODE_CLASS_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_OPERATION_COUNT = BASE_NODE_CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link OPCUAProfile.impl.ViewImpl <em>View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see OPCUAProfile.impl.ViewImpl
	 * @see OPCUAProfile.impl.OPCUAProfilePackageImpl#getView()
	 * @generated
	 */
	int VIEW = 4;

	/**
	 * The feature id for the '<em><b>Node Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__NODE_ID = BASE_NODE_CLASS__NODE_ID;

	/**
	 * The feature id for the '<em><b>Node Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__NODE_CLASS = BASE_NODE_CLASS__NODE_CLASS;

	/**
	 * The feature id for the '<em><b>Browse Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__BROWSE_NAME = BASE_NODE_CLASS__BROWSE_NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__DISPLAY_NAME = BASE_NODE_CLASS__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__DESCRIPTION = BASE_NODE_CLASS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Write Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__WRITE_MASK = BASE_NODE_CLASS__WRITE_MASK;

	/**
	 * The feature id for the '<em><b>Contains No Loops</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__CONTAINS_NO_LOOPS = BASE_NODE_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event Notifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__EVENT_NOTIFIER = BASE_NODE_CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__BASE_CLASS = BASE_NODE_CLASS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_FEATURE_COUNT = BASE_NODE_CLASS_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_OPERATION_COUNT = BASE_NODE_CLASS_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link OPCUAProfile.BaseNodeClass <em>Base Node Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Node Class</em>'.
	 * @see OPCUAProfile.BaseNodeClass
	 * @generated
	 */
	EClass getBaseNodeClass();

	/**
	 * Returns the meta object for the reference '{@link OPCUAProfile.BaseNodeClass#getNodeId <em>Node Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node Id</em>'.
	 * @see OPCUAProfile.BaseNodeClass#getNodeId()
	 * @see #getBaseNodeClass()
	 * @generated
	 */
	EReference getBaseNodeClass_NodeId();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.BaseNodeClass#getNodeClass <em>Node Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Class</em>'.
	 * @see OPCUAProfile.BaseNodeClass#getNodeClass()
	 * @see #getBaseNodeClass()
	 * @generated
	 */
	EAttribute getBaseNodeClass_NodeClass();

	/**
	 * Returns the meta object for the reference '{@link OPCUAProfile.BaseNodeClass#getBrowseName <em>Browse Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Browse Name</em>'.
	 * @see OPCUAProfile.BaseNodeClass#getBrowseName()
	 * @see #getBaseNodeClass()
	 * @generated
	 */
	EReference getBaseNodeClass_BrowseName();

	/**
	 * Returns the meta object for the reference '{@link OPCUAProfile.BaseNodeClass#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Display Name</em>'.
	 * @see OPCUAProfile.BaseNodeClass#getDisplayName()
	 * @see #getBaseNodeClass()
	 * @generated
	 */
	EReference getBaseNodeClass_DisplayName();

	/**
	 * Returns the meta object for the reference '{@link OPCUAProfile.BaseNodeClass#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Description</em>'.
	 * @see OPCUAProfile.BaseNodeClass#getDescription()
	 * @see #getBaseNodeClass()
	 * @generated
	 */
	EReference getBaseNodeClass_Description();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.BaseNodeClass#getWriteMask <em>Write Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Write Mask</em>'.
	 * @see OPCUAProfile.BaseNodeClass#getWriteMask()
	 * @see #getBaseNodeClass()
	 * @generated
	 */
	EAttribute getBaseNodeClass_WriteMask();

	/**
	 * Returns the meta object for class '{@link OPCUAProfile.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see OPCUAProfile.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the reference '{@link OPCUAProfile.Variable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see OPCUAProfile.Variable#getValue()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Value();

	/**
	 * Returns the meta object for the reference '{@link OPCUAProfile.Variable#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Type</em>'.
	 * @see OPCUAProfile.Variable#getDataType()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_DataType();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.Variable#getValueRank <em>Value Rank</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Rank</em>'.
	 * @see OPCUAProfile.Variable#getValueRank()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_ValueRank();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.Variable#getArrayDimensions <em>Array Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Array Dimensions</em>'.
	 * @see OPCUAProfile.Variable#getArrayDimensions()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_ArrayDimensions();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.Variable#getAccessLevel <em>Access Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access Level</em>'.
	 * @see OPCUAProfile.Variable#getAccessLevel()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_AccessLevel();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.Variable#getUserAccessLevel <em>User Access Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Access Level</em>'.
	 * @see OPCUAProfile.Variable#getUserAccessLevel()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_UserAccessLevel();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.Variable#getMinimumSamplingInterval <em>Minimum Sampling Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Sampling Interval</em>'.
	 * @see OPCUAProfile.Variable#getMinimumSamplingInterval()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_MinimumSamplingInterval();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.Variable#getHistorizing <em>Historizing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Historizing</em>'.
	 * @see OPCUAProfile.Variable#getHistorizing()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Historizing();

	/**
	 * Returns the meta object for the reference '{@link OPCUAProfile.Variable#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see OPCUAProfile.Variable#getBase_Class()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Base_Class();

	/**
	 * Returns the meta object for class '{@link OPCUAProfile.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see OPCUAProfile.Object
	 * @generated
	 */
	EClass getObject();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.Object#getEventNotifier <em>Event Notifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Notifier</em>'.
	 * @see OPCUAProfile.Object#getEventNotifier()
	 * @see #getObject()
	 * @generated
	 */
	EAttribute getObject_EventNotifier();

	/**
	 * Returns the meta object for the reference '{@link OPCUAProfile.Object#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see OPCUAProfile.Object#getBase_Class()
	 * @see #getObject()
	 * @generated
	 */
	EReference getObject_Base_Class();

	/**
	 * Returns the meta object for class '{@link OPCUAProfile.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see OPCUAProfile.Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.Method#getExecutable <em>Executable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Executable</em>'.
	 * @see OPCUAProfile.Method#getExecutable()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_Executable();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.Method#getUserExecutable <em>User Executable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Executable</em>'.
	 * @see OPCUAProfile.Method#getUserExecutable()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_UserExecutable();

	/**
	 * Returns the meta object for the reference '{@link OPCUAProfile.Method#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see OPCUAProfile.Method#getBase_Class()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_Base_Class();

	/**
	 * Returns the meta object for class '{@link OPCUAProfile.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View</em>'.
	 * @see OPCUAProfile.View
	 * @generated
	 */
	EClass getView();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.View#getContainsNoLoops <em>Contains No Loops</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contains No Loops</em>'.
	 * @see OPCUAProfile.View#getContainsNoLoops()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_ContainsNoLoops();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.View#getEventNotifier <em>Event Notifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Notifier</em>'.
	 * @see OPCUAProfile.View#getEventNotifier()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_EventNotifier();

	/**
	 * Returns the meta object for the reference '{@link OPCUAProfile.View#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see OPCUAProfile.View#getBase_Class()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Base_Class();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OPCUAProfileFactory getOPCUAProfileFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link OPCUAProfile.impl.BaseNodeClassImpl <em>Base Node Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see OPCUAProfile.impl.BaseNodeClassImpl
		 * @see OPCUAProfile.impl.OPCUAProfilePackageImpl#getBaseNodeClass()
		 * @generated
		 */
		EClass BASE_NODE_CLASS = eINSTANCE.getBaseNodeClass();

		/**
		 * The meta object literal for the '<em><b>Node Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_NODE_CLASS__NODE_ID = eINSTANCE.getBaseNodeClass_NodeId();

		/**
		 * The meta object literal for the '<em><b>Node Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_NODE_CLASS__NODE_CLASS = eINSTANCE.getBaseNodeClass_NodeClass();

		/**
		 * The meta object literal for the '<em><b>Browse Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_NODE_CLASS__BROWSE_NAME = eINSTANCE.getBaseNodeClass_BrowseName();

		/**
		 * The meta object literal for the '<em><b>Display Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_NODE_CLASS__DISPLAY_NAME = eINSTANCE.getBaseNodeClass_DisplayName();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_NODE_CLASS__DESCRIPTION = eINSTANCE.getBaseNodeClass_Description();

		/**
		 * The meta object literal for the '<em><b>Write Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_NODE_CLASS__WRITE_MASK = eINSTANCE.getBaseNodeClass_WriteMask();

		/**
		 * The meta object literal for the '{@link OPCUAProfile.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see OPCUAProfile.impl.VariableImpl
		 * @see OPCUAProfile.impl.OPCUAProfilePackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__VALUE = eINSTANCE.getVariable_Value();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__DATA_TYPE = eINSTANCE.getVariable_DataType();

		/**
		 * The meta object literal for the '<em><b>Value Rank</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__VALUE_RANK = eINSTANCE.getVariable_ValueRank();

		/**
		 * The meta object literal for the '<em><b>Array Dimensions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__ARRAY_DIMENSIONS = eINSTANCE.getVariable_ArrayDimensions();

		/**
		 * The meta object literal for the '<em><b>Access Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__ACCESS_LEVEL = eINSTANCE.getVariable_AccessLevel();

		/**
		 * The meta object literal for the '<em><b>User Access Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__USER_ACCESS_LEVEL = eINSTANCE.getVariable_UserAccessLevel();

		/**
		 * The meta object literal for the '<em><b>Minimum Sampling Interval</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__MINIMUM_SAMPLING_INTERVAL = eINSTANCE.getVariable_MinimumSamplingInterval();

		/**
		 * The meta object literal for the '<em><b>Historizing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__HISTORIZING = eINSTANCE.getVariable_Historizing();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__BASE_CLASS = eINSTANCE.getVariable_Base_Class();

		/**
		 * The meta object literal for the '{@link OPCUAProfile.impl.ObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see OPCUAProfile.impl.ObjectImpl
		 * @see OPCUAProfile.impl.OPCUAProfilePackageImpl#getObject()
		 * @generated
		 */
		EClass OBJECT = eINSTANCE.getObject();

		/**
		 * The meta object literal for the '<em><b>Event Notifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT__EVENT_NOTIFIER = eINSTANCE.getObject_EventNotifier();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT__BASE_CLASS = eINSTANCE.getObject_Base_Class();

		/**
		 * The meta object literal for the '{@link OPCUAProfile.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see OPCUAProfile.impl.MethodImpl
		 * @see OPCUAProfile.impl.OPCUAProfilePackageImpl#getMethod()
		 * @generated
		 */
		EClass METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em><b>Executable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__EXECUTABLE = eINSTANCE.getMethod_Executable();

		/**
		 * The meta object literal for the '<em><b>User Executable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__USER_EXECUTABLE = eINSTANCE.getMethod_UserExecutable();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__BASE_CLASS = eINSTANCE.getMethod_Base_Class();

		/**
		 * The meta object literal for the '{@link OPCUAProfile.impl.ViewImpl <em>View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see OPCUAProfile.impl.ViewImpl
		 * @see OPCUAProfile.impl.OPCUAProfilePackageImpl#getView()
		 * @generated
		 */
		EClass VIEW = eINSTANCE.getView();

		/**
		 * The meta object literal for the '<em><b>Contains No Loops</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW__CONTAINS_NO_LOOPS = eINSTANCE.getView_ContainsNoLoops();

		/**
		 * The meta object literal for the '<em><b>Event Notifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW__EVENT_NOTIFIER = eINSTANCE.getView_EventNotifier();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__BASE_CLASS = eINSTANCE.getView_Base_Class();

	}

} //OPCUAProfilePackage
