/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.ObjectTypes;

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
 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.ObjectTypes.ObjectTypesFactory
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
	String eNS_URI = "http:///OPCUA_Types/ObjectTypes.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "OPCUA_Types.ObjectTypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ObjectTypesPackage eINSTANCE = org.eclipse.papyrus.opcua.types.OPCUA_Types.ObjectTypes.impl.ObjectTypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.ObjectTypes.impl.BaseObjectTypeImpl <em>Base Object Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.ObjectTypes.impl.BaseObjectTypeImpl
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.ObjectTypes.impl.ObjectTypesPackageImpl#getBaseObjectType()
	 * @generated
	 */
	int BASE_OBJECT_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_OBJECT_TYPE__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Base Object Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_OBJECT_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Base Object Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_OBJECT_TYPE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.ObjectTypes.BaseObjectType <em>Base Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Object Type</em>'.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.ObjectTypes.BaseObjectType
	 * @generated
	 */
	EClass getBaseObjectType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.ObjectTypes.BaseObjectType#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.ObjectTypes.BaseObjectType#getBase_Class()
	 * @see #getBaseObjectType()
	 * @generated
	 */
	EReference getBaseObjectType_Base_Class();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.ObjectTypes.impl.BaseObjectTypeImpl <em>Base Object Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.ObjectTypes.impl.BaseObjectTypeImpl
		 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.ObjectTypes.impl.ObjectTypesPackageImpl#getBaseObjectType()
		 * @generated
		 */
		EClass BASE_OBJECT_TYPE = eINSTANCE.getBaseObjectType();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_OBJECT_TYPE__BASE_CLASS = eINSTANCE.getBaseObjectType_Base_Class();

	}

} //ObjectTypesPackage
