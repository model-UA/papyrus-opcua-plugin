/**
 */
package OPCUAProfile.ObjectTypes;

import OPCUAProfile.OPCUAProfilePackage;

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
 * @see OPCUAProfile.ObjectTypes.ObjectTypesFactory
 * @model kind="package"
 * @generated
 */
public interface ObjectTypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ObjectTypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///OPCUAProfile/ObjectTypes.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "OPCUAProfile.ObjectTypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ObjectTypesPackage eINSTANCE = OPCUAProfile.ObjectTypes.impl.ObjectTypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link OPCUAProfile.ObjectTypes.impl.ObjectTypeImpl <em>Object Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see OPCUAProfile.ObjectTypes.impl.ObjectTypeImpl
	 * @see OPCUAProfile.ObjectTypes.impl.ObjectTypesPackageImpl#getObjectType()
	 * @generated
	 */
	int OBJECT_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Node Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__NODE_ID = OPCUAProfilePackage.BASE_NODE_CLASS__NODE_ID;

	/**
	 * The feature id for the '<em><b>Node Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__NODE_CLASS = OPCUAProfilePackage.BASE_NODE_CLASS__NODE_CLASS;

	/**
	 * The feature id for the '<em><b>Browse Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__BROWSE_NAME = OPCUAProfilePackage.BASE_NODE_CLASS__BROWSE_NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__DISPLAY_NAME = OPCUAProfilePackage.BASE_NODE_CLASS__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__DESCRIPTION = OPCUAProfilePackage.BASE_NODE_CLASS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Write Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__WRITE_MASK = OPCUAProfilePackage.BASE_NODE_CLASS__WRITE_MASK;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__IS_ABSTRACT = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE__BASE_CLASS = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE_FEATURE_COUNT = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Object Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TYPE_OPERATION_COUNT = OPCUAProfilePackage.BASE_NODE_CLASS_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link OPCUAProfile.ObjectTypes.ObjectType <em>Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Type</em>'.
	 * @see OPCUAProfile.ObjectTypes.ObjectType
	 * @generated
	 */
	EClass getObjectType();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.ObjectTypes.ObjectType#getIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see OPCUAProfile.ObjectTypes.ObjectType#getIsAbstract()
	 * @see #getObjectType()
	 * @generated
	 */
	EAttribute getObjectType_IsAbstract();

	/**
	 * Returns the meta object for the reference '{@link OPCUAProfile.ObjectTypes.ObjectType#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see OPCUAProfile.ObjectTypes.ObjectType#getBase_Class()
	 * @see #getObjectType()
	 * @generated
	 */
	EReference getObjectType_Base_Class();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ObjectTypesFactory getObjectTypesFactory();

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
		 * The meta object literal for the '{@link OPCUAProfile.ObjectTypes.impl.ObjectTypeImpl <em>Object Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see OPCUAProfile.ObjectTypes.impl.ObjectTypeImpl
		 * @see OPCUAProfile.ObjectTypes.impl.ObjectTypesPackageImpl#getObjectType()
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

	}

} //ObjectTypesPackage
