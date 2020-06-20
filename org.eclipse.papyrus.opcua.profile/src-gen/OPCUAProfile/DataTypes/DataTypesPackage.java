/**
 */
package OPCUAProfile.DataTypes;

import OPCUAProfile.OPCUAProfilePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see OPCUAProfile.DataTypes.DataTypesFactory
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
	String eNS_URI = "http:///OPCUAProfile/DataTypes.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "OPCUAProfile.DataTypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataTypesPackage eINSTANCE = OPCUAProfile.DataTypes.impl.DataTypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link OPCUAProfile.DataTypes.impl.QualifiedNameImpl <em>Qualified Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see OPCUAProfile.DataTypes.impl.QualifiedNameImpl
	 * @see OPCUAProfile.DataTypes.impl.DataTypesPackageImpl#getQualifiedName()
	 * @generated
	 */
	int QUALIFIED_NAME = 0;

	/**
	 * The feature id for the '<em><b>Namespace Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_NAME__NAMESPACE_INDEX = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_NAME__NAME = 1;

	/**
	 * The number of structural features of the '<em>Qualified Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_NAME_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Qualified Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_NAME_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link OPCUAProfile.DataTypes.impl.LocalizedTextImpl <em>Localized Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see OPCUAProfile.DataTypes.impl.LocalizedTextImpl
	 * @see OPCUAProfile.DataTypes.impl.DataTypesPackageImpl#getLocalizedText()
	 * @generated
	 */
	int LOCALIZED_TEXT = 1;

	/**
	 * The feature id for the '<em><b>Locale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALIZED_TEXT__LOCALE = 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALIZED_TEXT__TEXT = 1;

	/**
	 * The number of structural features of the '<em>Localized Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALIZED_TEXT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Localized Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALIZED_TEXT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link OPCUAProfile.DataTypes.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see OPCUAProfile.DataTypes.impl.DataTypeImpl
	 * @see OPCUAProfile.DataTypes.impl.DataTypesPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Node Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NODE_ID = OPCUAProfilePackage.BASE_NODE_CLASS__NODE_ID;

	/**
	 * The feature id for the '<em><b>Node Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NODE_CLASS = OPCUAProfilePackage.BASE_NODE_CLASS__NODE_CLASS;

	/**
	 * The feature id for the '<em><b>Browse Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__BROWSE_NAME = OPCUAProfilePackage.BASE_NODE_CLASS__BROWSE_NAME;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__DISPLAY_NAME = OPCUAProfilePackage.BASE_NODE_CLASS__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__DESCRIPTION = OPCUAProfilePackage.BASE_NODE_CLASS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Write Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__WRITE_MASK = OPCUAProfilePackage.BASE_NODE_CLASS__WRITE_MASK;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__IS_ABSTRACT = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__BASE_CLASS = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = OPCUAProfilePackage.BASE_NODE_CLASS_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OPERATION_COUNT = OPCUAProfilePackage.BASE_NODE_CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link OPCUAProfile.DataTypes.impl.NodeIdImpl <em>Node Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see OPCUAProfile.DataTypes.impl.NodeIdImpl
	 * @see OPCUAProfile.DataTypes.impl.DataTypesPackageImpl#getNodeId()
	 * @generated
	 */
	int NODE_ID = 3;

	/**
	 * The feature id for the '<em><b>Node Id Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ID__NODE_ID_TYPE = 0;

	/**
	 * The feature id for the '<em><b>String Node Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ID__STRING_NODE_ID = 1;

	/**
	 * The feature id for the '<em><b>Numeric Node Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ID__NUMERIC_NODE_ID = 2;

	/**
	 * The feature id for the '<em><b>Guid Node Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ID__GUID_NODE_ID = 3;

	/**
	 * The number of structural features of the '<em>Node Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ID_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Node Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ID_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link OPCUAProfile.DataTypes.NodeIdType <em>Node Id Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see OPCUAProfile.DataTypes.NodeIdType
	 * @see OPCUAProfile.DataTypes.impl.DataTypesPackageImpl#getNodeIdType()
	 * @generated
	 */
	int NODE_ID_TYPE = 4;

	/**
	 * The meta object id for the '{@link OPCUAProfile.DataTypes._NodeClass <em>Node Class</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see OPCUAProfile.DataTypes._NodeClass
	 * @see OPCUAProfile.DataTypes.impl.DataTypesPackageImpl#get_NodeClass()
	 * @generated
	 */
	int _NODE_CLASS = 5;

	/**
	 * The meta object id for the '<em>String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see String
	 * @see OPCUAProfile.DataTypes.impl.DataTypesPackageImpl#getString()
	 * @generated
	 */
	int STRING = 6;

	/**
	 * The meta object id for the '<em>Boolean</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Boolean
	 * @see OPCUAProfile.DataTypes.impl.DataTypesPackageImpl#getBoolean()
	 * @generated
	 */
	int BOOLEAN = 7;


	/**
	 * Returns the meta object for class '{@link OPCUAProfile.DataTypes.QualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qualified Name</em>'.
	 * @see OPCUAProfile.DataTypes.QualifiedName
	 * @generated
	 */
	EClass getQualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.DataTypes.QualifiedName#getNamespaceIndex <em>Namespace Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace Index</em>'.
	 * @see OPCUAProfile.DataTypes.QualifiedName#getNamespaceIndex()
	 * @see #getQualifiedName()
	 * @generated
	 */
	EAttribute getQualifiedName_NamespaceIndex();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.DataTypes.QualifiedName#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see OPCUAProfile.DataTypes.QualifiedName#getName()
	 * @see #getQualifiedName()
	 * @generated
	 */
	EAttribute getQualifiedName_Name();

	/**
	 * Returns the meta object for class '{@link OPCUAProfile.DataTypes.LocalizedText <em>Localized Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Localized Text</em>'.
	 * @see OPCUAProfile.DataTypes.LocalizedText
	 * @generated
	 */
	EClass getLocalizedText();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.DataTypes.LocalizedText#getLocale <em>Locale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Locale</em>'.
	 * @see OPCUAProfile.DataTypes.LocalizedText#getLocale()
	 * @see #getLocalizedText()
	 * @generated
	 */
	EAttribute getLocalizedText_Locale();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.DataTypes.LocalizedText#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see OPCUAProfile.DataTypes.LocalizedText#getText()
	 * @see #getLocalizedText()
	 * @generated
	 */
	EAttribute getLocalizedText_Text();

	/**
	 * Returns the meta object for class '{@link OPCUAProfile.DataTypes.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see OPCUAProfile.DataTypes.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.DataTypes.DataType#getIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see OPCUAProfile.DataTypes.DataType#getIsAbstract()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_IsAbstract();

	/**
	 * Returns the meta object for the reference '{@link OPCUAProfile.DataTypes.DataType#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see OPCUAProfile.DataTypes.DataType#getBase_Class()
	 * @see #getDataType()
	 * @generated
	 */
	EReference getDataType_Base_Class();

	/**
	 * Returns the meta object for class '{@link OPCUAProfile.DataTypes.NodeId <em>Node Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Id</em>'.
	 * @see OPCUAProfile.DataTypes.NodeId
	 * @generated
	 */
	EClass getNodeId();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.DataTypes.NodeId#getNodeIdType <em>Node Id Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Id Type</em>'.
	 * @see OPCUAProfile.DataTypes.NodeId#getNodeIdType()
	 * @see #getNodeId()
	 * @generated
	 */
	EAttribute getNodeId_NodeIdType();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.DataTypes.NodeId#getStringNodeId <em>String Node Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Node Id</em>'.
	 * @see OPCUAProfile.DataTypes.NodeId#getStringNodeId()
	 * @see #getNodeId()
	 * @generated
	 */
	EAttribute getNodeId_StringNodeId();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.DataTypes.NodeId#getNumericNodeId <em>Numeric Node Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numeric Node Id</em>'.
	 * @see OPCUAProfile.DataTypes.NodeId#getNumericNodeId()
	 * @see #getNodeId()
	 * @generated
	 */
	EAttribute getNodeId_NumericNodeId();

	/**
	 * Returns the meta object for the attribute '{@link OPCUAProfile.DataTypes.NodeId#getGuidNodeId <em>Guid Node Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guid Node Id</em>'.
	 * @see OPCUAProfile.DataTypes.NodeId#getGuidNodeId()
	 * @see #getNodeId()
	 * @generated
	 */
	EAttribute getNodeId_GuidNodeId();

	/**
	 * Returns the meta object for enum '{@link OPCUAProfile.DataTypes.NodeIdType <em>Node Id Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Node Id Type</em>'.
	 * @see OPCUAProfile.DataTypes.NodeIdType
	 * @generated
	 */
	EEnum getNodeIdType();

	/**
	 * Returns the meta object for enum '{@link OPCUAProfile.DataTypes._NodeClass <em>Node Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Node Class</em>'.
	 * @see OPCUAProfile.DataTypes._NodeClass
	 * @generated
	 */
	EEnum get_NodeClass();

	/**
	 * Returns the meta object for data type '{@link String <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String</em>'.
	 * @see String
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getString();

	/**
	 * Returns the meta object for data type '{@link Boolean <em>Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Boolean</em>'.
	 * @see Boolean
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getBoolean();

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
		 * The meta object literal for the '{@link OPCUAProfile.DataTypes.impl.QualifiedNameImpl <em>Qualified Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see OPCUAProfile.DataTypes.impl.QualifiedNameImpl
		 * @see OPCUAProfile.DataTypes.impl.DataTypesPackageImpl#getQualifiedName()
		 * @generated
		 */
		EClass QUALIFIED_NAME = eINSTANCE.getQualifiedName();

		/**
		 * The meta object literal for the '<em><b>Namespace Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUALIFIED_NAME__NAMESPACE_INDEX = eINSTANCE.getQualifiedName_NamespaceIndex();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUALIFIED_NAME__NAME = eINSTANCE.getQualifiedName_Name();

		/**
		 * The meta object literal for the '{@link OPCUAProfile.DataTypes.impl.LocalizedTextImpl <em>Localized Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see OPCUAProfile.DataTypes.impl.LocalizedTextImpl
		 * @see OPCUAProfile.DataTypes.impl.DataTypesPackageImpl#getLocalizedText()
		 * @generated
		 */
		EClass LOCALIZED_TEXT = eINSTANCE.getLocalizedText();

		/**
		 * The meta object literal for the '<em><b>Locale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCALIZED_TEXT__LOCALE = eINSTANCE.getLocalizedText_Locale();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCALIZED_TEXT__TEXT = eINSTANCE.getLocalizedText_Text();

		/**
		 * The meta object literal for the '{@link OPCUAProfile.DataTypes.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see OPCUAProfile.DataTypes.impl.DataTypeImpl
		 * @see OPCUAProfile.DataTypes.impl.DataTypesPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__IS_ABSTRACT = eINSTANCE.getDataType_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE__BASE_CLASS = eINSTANCE.getDataType_Base_Class();

		/**
		 * The meta object literal for the '{@link OPCUAProfile.DataTypes.impl.NodeIdImpl <em>Node Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see OPCUAProfile.DataTypes.impl.NodeIdImpl
		 * @see OPCUAProfile.DataTypes.impl.DataTypesPackageImpl#getNodeId()
		 * @generated
		 */
		EClass NODE_ID = eINSTANCE.getNodeId();

		/**
		 * The meta object literal for the '<em><b>Node Id Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_ID__NODE_ID_TYPE = eINSTANCE.getNodeId_NodeIdType();

		/**
		 * The meta object literal for the '<em><b>String Node Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_ID__STRING_NODE_ID = eINSTANCE.getNodeId_StringNodeId();

		/**
		 * The meta object literal for the '<em><b>Numeric Node Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_ID__NUMERIC_NODE_ID = eINSTANCE.getNodeId_NumericNodeId();

		/**
		 * The meta object literal for the '<em><b>Guid Node Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_ID__GUID_NODE_ID = eINSTANCE.getNodeId_GuidNodeId();

		/**
		 * The meta object literal for the '{@link OPCUAProfile.DataTypes.NodeIdType <em>Node Id Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see OPCUAProfile.DataTypes.NodeIdType
		 * @see OPCUAProfile.DataTypes.impl.DataTypesPackageImpl#getNodeIdType()
		 * @generated
		 */
		EEnum NODE_ID_TYPE = eINSTANCE.getNodeIdType();

		/**
		 * The meta object literal for the '{@link OPCUAProfile.DataTypes._NodeClass <em>Node Class</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see OPCUAProfile.DataTypes._NodeClass
		 * @see OPCUAProfile.DataTypes.impl.DataTypesPackageImpl#get_NodeClass()
		 * @generated
		 */
		EEnum _NODE_CLASS = eINSTANCE.get_NodeClass();

		/**
		 * The meta object literal for the '<em>String</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see String
		 * @see OPCUAProfile.DataTypes.impl.DataTypesPackageImpl#getString()
		 * @generated
		 */
		EDataType STRING = eINSTANCE.getString();

		/**
		 * The meta object literal for the '<em>Boolean</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Boolean
		 * @see OPCUAProfile.DataTypes.impl.DataTypesPackageImpl#getBoolean()
		 * @generated
		 */
		EDataType BOOLEAN = eINSTANCE.getBoolean();

	}

} //DataTypesPackage
