/**
 */
package OPCUAProfile.VariableTypes;

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
 * @see OPCUAProfile.VariableTypes.VariableTypesFactory
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
	String eNS_URI = "http:///OPCUAProfile/VariableTypes.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "OPCUAProfile.VariableTypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VariableTypesPackage eINSTANCE = OPCUAProfile.VariableTypes.impl.VariableTypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link OPCUAProfile.VariableTypes.impl.VariableTypeImpl <em>Variable Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see OPCUAProfile.VariableTypes.impl.VariableTypeImpl
	 * @see OPCUAProfile.VariableTypes.impl.VariableTypesPackageImpl#getVariableType()
	 * @generated
	 */
	int VARIABLE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Node Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__NODE_ID = OPCUAProfilePackage.BASE_NODE_CLASS__NODE_ID;

	/**
	 * The feature id for the '<em><b>Node Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__NODE_CLASS = OPCUAProfilePackage.BASE_NODE_CLASS__NODE_CLASS;

	/**
	 * The feature id for the '<em><b>Browse Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__BROWSE_NAME = OPCUAProfilePackage.BASE_NODE_CLASS__BROWSE_NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__DISPLAY_NAME = OPCUAProfilePackage.BASE_NODE_CLASS__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__DESCRIPTION = OPCUAProfilePackage.BASE_NODE_CLASS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Write Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__WRITE_MASK = OPCUAProfilePackage.BASE_NODE_CLASS__WRITE_MASK;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__VALUE = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__DATA_TYPE = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value Rank</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__VALUE_RANK = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Array Dimensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__ARRAY_DIMENSIONS = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__IS_ABSTRACT = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE__BASE_CLASS = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Variable Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE_FEATURE_COUNT = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Variable Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE_OPERATION_COUNT = OPCUAProfilePackage.BASE_NODE_CLASS_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link OPCUAProfile.VariableTypes.VariableType <em>Variable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Type</em>'.
	 * @see OPCUAProfile.VariableTypes.VariableType
	 * @generated
	 */
	EClass getVariableType();

	/**
	 * Returns the meta object for the reference '{@link OPCUAProfile.VariableTypes.VariableType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see OPCUAProfile.VariableTypes.VariableType#getValue()
	 * @see #getVariableType()
	 * @generated
	 */
	EReference getVariableType_Value();

	/**
	 * Returns the meta object for the reference '{@link OPCUAProfile.VariableTypes.VariableType#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Type</em>'.
	 * @see OPCUAProfile.VariableTypes.VariableType#getDataType()
	 * @see #getVariableType()
	 * @generated
	 */
	EReference getVariableType_DataType();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.VariableTypes.VariableType#getValueRank <em>Value Rank</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Rank</em>'.
	 * @see OPCUAProfile.VariableTypes.VariableType#getValueRank()
	 * @see #getVariableType()
	 * @generated
	 */
	EAttribute getVariableType_ValueRank();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.VariableTypes.VariableType#getArrayDimensions <em>Array Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Array Dimensions</em>'.
	 * @see OPCUAProfile.VariableTypes.VariableType#getArrayDimensions()
	 * @see #getVariableType()
	 * @generated
	 */
	EAttribute getVariableType_ArrayDimensions();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.VariableTypes.VariableType#getIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see OPCUAProfile.VariableTypes.VariableType#getIsAbstract()
	 * @see #getVariableType()
	 * @generated
	 */
	EAttribute getVariableType_IsAbstract();

	/**
	 * Returns the meta object for the reference '{@link OPCUAProfile.VariableTypes.VariableType#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see OPCUAProfile.VariableTypes.VariableType#getBase_Class()
	 * @see #getVariableType()
	 * @generated
	 */
	EReference getVariableType_Base_Class();

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
		 * The meta object literal for the '{@link OPCUAProfile.VariableTypes.impl.VariableTypeImpl <em>Variable Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see OPCUAProfile.VariableTypes.impl.VariableTypeImpl
		 * @see OPCUAProfile.VariableTypes.impl.VariableTypesPackageImpl#getVariableType()
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

	}

} //VariableTypesPackage
