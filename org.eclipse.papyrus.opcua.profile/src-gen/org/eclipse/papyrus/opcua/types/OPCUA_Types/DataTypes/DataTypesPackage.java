/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.DataTypes;

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
 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.DataTypes.DataTypesFactory
 * @model kind="package"
 * @generated
 */
public interface DataTypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "DataTypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///OPCUA_Types/DataTypes.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "OPCUA_Types.DataTypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataTypesPackage eINSTANCE = org.eclipse.papyrus.opcua.types.OPCUA_Types.DataTypes.impl.DataTypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.DataTypes.impl.BaseDataTypeImpl <em>Base Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.DataTypes.impl.BaseDataTypeImpl
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.DataTypes.impl.DataTypesPackageImpl#getBaseDataType()
	 * @generated
	 */
	int BASE_DATA_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_TYPE__BASE_DATA_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Base Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Base Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_TYPE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.DataTypes.BaseDataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Data Type</em>'.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.DataTypes.BaseDataType
	 * @generated
	 */
	EClass getBaseDataType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.DataTypes.BaseDataType#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.DataTypes.BaseDataType#getBase_DataType()
	 * @see #getBaseDataType()
	 * @generated
	 */
	EReference getBaseDataType_Base_DataType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DataTypesFactory getDataTypesFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.DataTypes.impl.BaseDataTypeImpl <em>Base Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.DataTypes.impl.BaseDataTypeImpl
		 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.DataTypes.impl.DataTypesPackageImpl#getBaseDataType()
		 * @generated
		 */
		EClass BASE_DATA_TYPE = eINSTANCE.getBaseDataType();

		/**
		 * The meta object literal for the '<em><b>Base Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_DATA_TYPE__BASE_DATA_TYPE = eINSTANCE.getBaseDataType_Base_DataType();

	}

} //DataTypesPackage
