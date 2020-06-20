/**
 */
package OPCUAProfile.ReferenceTypes.References;

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
 * @see OPCUAProfile.ReferenceTypes.References.ReferencesFactory
 * @model kind="package"
 * @generated
 */
public interface ReferencesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "References";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///OPCUAProfile/ReferenceTypes/References.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "OPCUAProfile.ReferenceTypes.References";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ReferencesPackage eINSTANCE = OPCUAProfile.ReferenceTypes.References.impl.ReferencesPackageImpl.init();

	/**
	 * The meta object id for the '{@link OPCUAProfile.ReferenceTypes.References.impl.ReferenceTypeImpl <em>Reference Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see OPCUAProfile.ReferenceTypes.References.impl.ReferenceTypeImpl
	 * @see OPCUAProfile.ReferenceTypes.References.impl.ReferencesPackageImpl#getReferenceType()
	 * @generated
	 */
	int REFERENCE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Node Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__NODE_ID = OPCUAProfilePackage.BASE_NODE_CLASS__NODE_ID;

	/**
	 * The feature id for the '<em><b>Node Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__NODE_CLASS = OPCUAProfilePackage.BASE_NODE_CLASS__NODE_CLASS;

	/**
	 * The feature id for the '<em><b>Browse Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__BROWSE_NAME = OPCUAProfilePackage.BASE_NODE_CLASS__BROWSE_NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__DISPLAY_NAME = OPCUAProfilePackage.BASE_NODE_CLASS__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__DESCRIPTION = OPCUAProfilePackage.BASE_NODE_CLASS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Write Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__WRITE_MASK = OPCUAProfilePackage.BASE_NODE_CLASS__WRITE_MASK;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__IS_ABSTRACT = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Symmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__SYMMETRIC = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Inverse Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__INVERSE_NAME = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__BASE_CLASS = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Reference Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE_FEATURE_COUNT = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Reference Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE_OPERATION_COUNT = OPCUAProfilePackage.BASE_NODE_CLASS_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link OPCUAProfile.ReferenceTypes.References.ReferenceType <em>Reference Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Type</em>'.
	 * @see OPCUAProfile.ReferenceTypes.References.ReferenceType
	 * @generated
	 */
	EClass getReferenceType();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.ReferenceTypes.References.ReferenceType#getIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see OPCUAProfile.ReferenceTypes.References.ReferenceType#getIsAbstract()
	 * @see #getReferenceType()
	 * @generated
	 */
	EAttribute getReferenceType_IsAbstract();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.ReferenceTypes.References.ReferenceType#getSymmetric <em>Symmetric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symmetric</em>'.
	 * @see OPCUAProfile.ReferenceTypes.References.ReferenceType#getSymmetric()
	 * @see #getReferenceType()
	 * @generated
	 */
	EAttribute getReferenceType_Symmetric();

	/**
	 * Returns the meta object for the reference '{@link OPCUAProfile.ReferenceTypes.References.ReferenceType#getInverseName <em>Inverse Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inverse Name</em>'.
	 * @see OPCUAProfile.ReferenceTypes.References.ReferenceType#getInverseName()
	 * @see #getReferenceType()
	 * @generated
	 */
	EReference getReferenceType_InverseName();

	/**
	 * Returns the meta object for the reference '{@link OPCUAProfile.ReferenceTypes.References.ReferenceType#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see OPCUAProfile.ReferenceTypes.References.ReferenceType#getBase_Class()
	 * @see #getReferenceType()
	 * @generated
	 */
	EReference getReferenceType_Base_Class();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ReferencesFactory getReferencesFactory();

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
		 * The meta object literal for the '{@link OPCUAProfile.ReferenceTypes.References.impl.ReferenceTypeImpl <em>Reference Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see OPCUAProfile.ReferenceTypes.References.impl.ReferenceTypeImpl
		 * @see OPCUAProfile.ReferenceTypes.References.impl.ReferencesPackageImpl#getReferenceType()
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
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_TYPE__BASE_CLASS = eINSTANCE.getReferenceType_Base_Class();

	}

} //ReferencesPackage
