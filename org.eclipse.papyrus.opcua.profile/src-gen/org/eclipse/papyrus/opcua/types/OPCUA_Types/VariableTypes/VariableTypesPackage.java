/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes;

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
 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.VariableTypesFactory
 * @model kind="package"
 * @generated
 */
public interface VariableTypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "VariableTypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///OPCUA_Types/VariableTypes.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "OPCUA_Types.VariableTypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VariableTypesPackage eINSTANCE = org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.impl.VariableTypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.impl.BaseVariableTypeImpl <em>Base Variable Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.impl.BaseVariableTypeImpl
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.impl.VariableTypesPackageImpl#getBaseVariableType()
	 * @generated
	 */
	int BASE_VARIABLE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Base Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_VARIABLE_TYPE__BASE_VARIABLE = 0;

	/**
	 * The number of structural features of the '<em>Base Variable Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_VARIABLE_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Base Variable Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_VARIABLE_TYPE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.BaseVariableType <em>Base Variable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Variable Type</em>'.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.BaseVariableType
	 * @generated
	 */
	EClass getBaseVariableType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.BaseVariableType#getBase_Variable <em>Base Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Variable</em>'.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.BaseVariableType#getBase_Variable()
	 * @see #getBaseVariableType()
	 * @generated
	 */
	EReference getBaseVariableType_Base_Variable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VariableTypesFactory getVariableTypesFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.impl.BaseVariableTypeImpl <em>Base Variable Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.impl.BaseVariableTypeImpl
		 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.impl.VariableTypesPackageImpl#getBaseVariableType()
		 * @generated
		 */
		EClass BASE_VARIABLE_TYPE = eINSTANCE.getBaseVariableType();

		/**
		 * The meta object literal for the '<em><b>Base Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_VARIABLE_TYPE__BASE_VARIABLE = eINSTANCE.getBaseVariableType_Base_Variable();

	}

} //VariableTypesPackage
