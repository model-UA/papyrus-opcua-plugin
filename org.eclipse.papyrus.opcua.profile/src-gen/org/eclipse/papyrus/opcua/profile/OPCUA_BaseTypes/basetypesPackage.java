/**
 */
package org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes;

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
 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='OPC-UA_BaseTypes'"
 * @generated
 */
public interface basetypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "OPCUA_BaseTypes";

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
	String eNS_PREFIX = "OPCUA_BaseTypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	basetypesPackage eINSTANCE = org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.BaseNodeClassImpl <em>Base Node Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.BaseNodeClassImpl
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl#getBaseNodeClass()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableImpl
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl#getVariable()
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
	 * The feature id for the '<em><b>Base Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__BASE_VARIABLE = BASE_NODE_CLASS_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Base Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__BASE_STEREOTYPE = BASE_NODE_CLASS_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = BASE_NODE_CLASS_FEATURE_COUNT + 11;

	/**
	 * The number of operations of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_OPERATION_COUNT = BASE_NODE_CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ObjectTypeImpl <em>Object Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ObjectTypeImpl
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl#getObjectType()
	 * @generated
	 */
	int OBJECT_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Node Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__NODE_ID = BASE_NODE_CLASS__NODE_ID;

	/**
	 * The feature id for the '<em><b>Node Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__NODE_CLASS = BASE_NODE_CLASS__NODE_CLASS;

	/**
	 * The feature id for the '<em><b>Browse Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__BROWSE_NAME = BASE_NODE_CLASS__BROWSE_NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__DISPLAY_NAME = BASE_NODE_CLASS__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__DESCRIPTION = BASE_NODE_CLASS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Write Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__WRITE_MASK = BASE_NODE_CLASS__WRITE_MASK;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__IS_ABSTRACT = BASE_NODE_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__BASE_CLASS = BASE_NODE_CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__BASE_STEREOTYPE = BASE_NODE_CLASS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Object Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE_FEATURE_COUNT = BASE_NODE_CLASS_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Object Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE_OPERATION_COUNT = BASE_NODE_CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ObjectImpl
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 3;

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
	 * The feature id for the '<em><b>Base Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__BASE_STEREOTYPE = BASE_NODE_CLASS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_FEATURE_COUNT = BASE_NODE_CLASS_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_OPERATION_COUNT = BASE_NODE_CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.MethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.MethodImpl
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 4;

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
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__BASE_OPERATION = BASE_NODE_CLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__BASE_STEREOTYPE = BASE_NODE_CLASS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = BASE_NODE_CLASS_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_OPERATION_COUNT = BASE_NODE_CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ViewImpl <em>View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ViewImpl
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl#getView()
	 * @generated
	 */
	int VIEW = 5;

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
	 * The feature id for the '<em><b>Base Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__BASE_STEREOTYPE = BASE_NODE_CLASS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_FEATURE_COUNT = BASE_NODE_CLASS_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_OPERATION_COUNT = BASE_NODE_CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableTypeImpl <em>Variable Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableTypeImpl
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl#getVariableType()
	 * @generated
	 */
	int VARIABLE_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Node Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__NODE_ID = BASE_NODE_CLASS__NODE_ID;

	/**
	 * The feature id for the '<em><b>Node Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__NODE_CLASS = BASE_NODE_CLASS__NODE_CLASS;

	/**
	 * The feature id for the '<em><b>Browse Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__BROWSE_NAME = BASE_NODE_CLASS__BROWSE_NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__DISPLAY_NAME = BASE_NODE_CLASS__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__DESCRIPTION = BASE_NODE_CLASS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Write Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__WRITE_MASK = BASE_NODE_CLASS__WRITE_MASK;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__VALUE = BASE_NODE_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__DATA_TYPE = BASE_NODE_CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value Rank</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__VALUE_RANK = BASE_NODE_CLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Array Dimensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__ARRAY_DIMENSIONS = BASE_NODE_CLASS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__IS_ABSTRACT = BASE_NODE_CLASS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__BASE_CLASS = BASE_NODE_CLASS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Base Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__BASE_STEREOTYPE = BASE_NODE_CLASS_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Variable Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE_FEATURE_COUNT = BASE_NODE_CLASS_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Variable Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE_OPERATION_COUNT = BASE_NODE_CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ReferenceTypeImpl <em>Reference Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ReferenceTypeImpl
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl#getReferenceType()
	 * @generated
	 */
	int REFERENCE_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Node Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__NODE_ID = BASE_NODE_CLASS__NODE_ID;

	/**
	 * The feature id for the '<em><b>Node Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__NODE_CLASS = BASE_NODE_CLASS__NODE_CLASS;

	/**
	 * The feature id for the '<em><b>Browse Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__BROWSE_NAME = BASE_NODE_CLASS__BROWSE_NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__DISPLAY_NAME = BASE_NODE_CLASS__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__DESCRIPTION = BASE_NODE_CLASS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Write Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__WRITE_MASK = BASE_NODE_CLASS__WRITE_MASK;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__IS_ABSTRACT = BASE_NODE_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Symmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__SYMMETRIC = BASE_NODE_CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Inverse Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__INVERSE_NAME = BASE_NODE_CLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__BASE_STEREOTYPE = BASE_NODE_CLASS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Base Association</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__BASE_ASSOCIATION = BASE_NODE_CLASS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Reference Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE_FEATURE_COUNT = BASE_NODE_CLASS_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Reference Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE_OPERATION_COUNT = BASE_NODE_CLASS_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass <em>Base Node Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Node Class</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass
	 * @generated
	 */
	EClass getBaseNodeClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getNodeId <em>Node Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node Id</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getNodeId()
	 * @see #getBaseNodeClass()
	 * @generated
	 */
	EReference getBaseNodeClass_NodeId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getNodeClass <em>Node Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Class</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getNodeClass()
	 * @see #getBaseNodeClass()
	 * @generated
	 */
	EAttribute getBaseNodeClass_NodeClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getBrowseName <em>Browse Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Browse Name</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getBrowseName()
	 * @see #getBaseNodeClass()
	 * @generated
	 */
	EReference getBaseNodeClass_BrowseName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getDisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Display Name</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getDisplayName()
	 * @see #getBaseNodeClass()
	 * @generated
	 */
	EReference getBaseNodeClass_DisplayName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Description</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getDescription()
	 * @see #getBaseNodeClass()
	 * @generated
	 */
	EReference getBaseNodeClass_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getWriteMask <em>Write Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Write Mask</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getWriteMask()
	 * @see #getBaseNodeClass()
	 * @generated
	 */
	EAttribute getBaseNodeClass_WriteMask();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getValue()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Value();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Type</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getDataType()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_DataType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getValueRank <em>Value Rank</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Rank</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getValueRank()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_ValueRank();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getArrayDimensions <em>Array Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Array Dimensions</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getArrayDimensions()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_ArrayDimensions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getAccessLevel <em>Access Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access Level</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getAccessLevel()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_AccessLevel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getUserAccessLevel <em>User Access Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Access Level</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getUserAccessLevel()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_UserAccessLevel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getMinimumSamplingInterval <em>Minimum Sampling Interval</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Sampling Interval</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getMinimumSamplingInterval()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_MinimumSamplingInterval();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#isHistorizing <em>Historizing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Historizing</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#isHistorizing()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Historizing();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getBase_Class()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getBase_Variable <em>Base Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Variable</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getBase_Variable()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Base_Variable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getBase_Stereotype <em>Base Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Stereotype</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getBase_Stereotype()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Base_Stereotype();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ObjectType <em>Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Type</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ObjectType
	 * @generated
	 */
	EClass getObjectType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ObjectType#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ObjectType#isIsAbstract()
	 * @see #getObjectType()
	 * @generated
	 */
	EAttribute getObjectType_IsAbstract();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ObjectType#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ObjectType#getBase_Class()
	 * @see #getObjectType()
	 * @generated
	 */
	EReference getObjectType_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ObjectType#getBase_Stereotype <em>Base Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Stereotype</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ObjectType#getBase_Stereotype()
	 * @see #getObjectType()
	 * @generated
	 */
	EReference getObjectType_Base_Stereotype();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Object
	 * @generated
	 */
	EClass getObject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Object#getEventNotifier <em>Event Notifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Notifier</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Object#getEventNotifier()
	 * @see #getObject()
	 * @generated
	 */
	EAttribute getObject_EventNotifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Object#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Object#getBase_Class()
	 * @see #getObject()
	 * @generated
	 */
	EReference getObject_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Object#getBase_Stereotype <em>Base Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Stereotype</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Object#getBase_Stereotype()
	 * @see #getObject()
	 * @generated
	 */
	EReference getObject_Base_Stereotype();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Method#isExecutable <em>Executable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Executable</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Method#isExecutable()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_Executable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Method#isUserExecutable <em>User Executable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Executable</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Method#isUserExecutable()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_UserExecutable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Method#getBase_Operation <em>Base Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Operation</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Method#getBase_Operation()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_Base_Operation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Method#getBase_Stereotype <em>Base Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Stereotype</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Method#getBase_Stereotype()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_Base_Stereotype();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View
	 * @generated
	 */
	EClass getView();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View#isContainsNoLoops <em>Contains No Loops</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contains No Loops</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View#isContainsNoLoops()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_ContainsNoLoops();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View#getEventNotifier <em>Event Notifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Notifier</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View#getEventNotifier()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_EventNotifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View#getBase_Class()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View#getBase_Stereotype <em>Base Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Stereotype</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View#getBase_Stereotype()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Base_Stereotype();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType <em>Variable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Type</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType
	 * @generated
	 */
	EClass getVariableType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getValue()
	 * @see #getVariableType()
	 * @generated
	 */
	EReference getVariableType_Value();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Type</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getDataType()
	 * @see #getVariableType()
	 * @generated
	 */
	EReference getVariableType_DataType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getValueRank <em>Value Rank</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Rank</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getValueRank()
	 * @see #getVariableType()
	 * @generated
	 */
	EAttribute getVariableType_ValueRank();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getArrayDimensions <em>Array Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Array Dimensions</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getArrayDimensions()
	 * @see #getVariableType()
	 * @generated
	 */
	EAttribute getVariableType_ArrayDimensions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#isIsAbstract()
	 * @see #getVariableType()
	 * @generated
	 */
	EAttribute getVariableType_IsAbstract();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getBase_Class()
	 * @see #getVariableType()
	 * @generated
	 */
	EReference getVariableType_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getBase_Stereotype <em>Base Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Stereotype</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getBase_Stereotype()
	 * @see #getVariableType()
	 * @generated
	 */
	EReference getVariableType_Base_Stereotype();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType <em>Reference Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Type</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType
	 * @generated
	 */
	EClass getReferenceType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#isIsAbstract()
	 * @see #getReferenceType()
	 * @generated
	 */
	EAttribute getReferenceType_IsAbstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#isSymmetric <em>Symmetric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symmetric</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#isSymmetric()
	 * @see #getReferenceType()
	 * @generated
	 */
	EAttribute getReferenceType_Symmetric();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#getInverseName <em>Inverse Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inverse Name</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#getInverseName()
	 * @see #getReferenceType()
	 * @generated
	 */
	EReference getReferenceType_InverseName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#getBase_Stereotype <em>Base Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Stereotype</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#getBase_Stereotype()
	 * @see #getReferenceType()
	 * @generated
	 */
	EReference getReferenceType_Base_Stereotype();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#getBase_Association <em>Base Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Association</em>'.
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#getBase_Association()
	 * @see #getReferenceType()
	 * @generated
	 */
	EReference getReferenceType_Base_Association();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	basetypesFactory getbasetypesFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.BaseNodeClassImpl <em>Base Node Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.BaseNodeClassImpl
		 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl#getBaseNodeClass()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableImpl
		 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl#getVariable()
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
		 * The meta object literal for the '<em><b>Base Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__BASE_VARIABLE = eINSTANCE.getVariable_Base_Variable();

		/**
		 * The meta object literal for the '<em><b>Base Stereotype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__BASE_STEREOTYPE = eINSTANCE.getVariable_Base_Stereotype();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ObjectTypeImpl <em>Object Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ObjectTypeImpl
		 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl#getObjectType()
		 * @generated
		 */
		EClass OBJECT_TYPE = eINSTANCE.getObjectType();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_TYPE__IS_ABSTRACT = eINSTANCE.getObjectType_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_TYPE__BASE_CLASS = eINSTANCE.getObjectType_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Stereotype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_TYPE__BASE_STEREOTYPE = eINSTANCE.getObjectType_Base_Stereotype();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ObjectImpl
		 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl#getObject()
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
		 * The meta object literal for the '<em><b>Base Stereotype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT__BASE_STEREOTYPE = eINSTANCE.getObject_Base_Stereotype();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.MethodImpl
		 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl#getMethod()
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
		 * The meta object literal for the '<em><b>Base Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__BASE_OPERATION = eINSTANCE.getMethod_Base_Operation();

		/**
		 * The meta object literal for the '<em><b>Base Stereotype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__BASE_STEREOTYPE = eINSTANCE.getMethod_Base_Stereotype();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ViewImpl <em>View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ViewImpl
		 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl#getView()
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

		/**
		 * The meta object literal for the '<em><b>Base Stereotype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__BASE_STEREOTYPE = eINSTANCE.getView_Base_Stereotype();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableTypeImpl <em>Variable Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableTypeImpl
		 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl#getVariableType()
		 * @generated
		 */
		EClass VARIABLE_TYPE = eINSTANCE.getVariableType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_TYPE__VALUE = eINSTANCE.getVariableType_Value();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_TYPE__DATA_TYPE = eINSTANCE.getVariableType_DataType();

		/**
		 * The meta object literal for the '<em><b>Value Rank</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_TYPE__VALUE_RANK = eINSTANCE.getVariableType_ValueRank();

		/**
		 * The meta object literal for the '<em><b>Array Dimensions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_TYPE__ARRAY_DIMENSIONS = eINSTANCE.getVariableType_ArrayDimensions();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_TYPE__IS_ABSTRACT = eINSTANCE.getVariableType_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_TYPE__BASE_CLASS = eINSTANCE.getVariableType_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Base Stereotype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_TYPE__BASE_STEREOTYPE = eINSTANCE.getVariableType_Base_Stereotype();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ReferenceTypeImpl <em>Reference Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ReferenceTypeImpl
		 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl#getReferenceType()
		 * @generated
		 */
		EClass REFERENCE_TYPE = eINSTANCE.getReferenceType();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_TYPE__IS_ABSTRACT = eINSTANCE.getReferenceType_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Symmetric</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_TYPE__SYMMETRIC = eINSTANCE.getReferenceType_Symmetric();

		/**
		 * The meta object literal for the '<em><b>Inverse Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_TYPE__INVERSE_NAME = eINSTANCE.getReferenceType_InverseName();

		/**
		 * The meta object literal for the '<em><b>Base Stereotype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_TYPE__BASE_STEREOTYPE = eINSTANCE.getReferenceType_Base_Stereotype();

		/**
		 * The meta object literal for the '<em><b>Base Association</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_TYPE__BASE_ASSOCIATION = eINSTANCE.getReferenceType_Base_Association();

	}

} //basetypesPackage
