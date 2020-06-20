/**
 */
package OPCUAProfile.DataTypes.impl;

import OPCUAProfile.DataTypes.DataType;
import OPCUAProfile.DataTypes.DataTypesFactory;
import OPCUAProfile.DataTypes.DataTypesPackage;
import OPCUAProfile.DataTypes.LocalizedText;
import OPCUAProfile.DataTypes.NodeId;
import OPCUAProfile.DataTypes.NodeIdType;

import OPCUAProfile.DataTypes.Number.Integer.IntegerPackage;

import OPCUAProfile.DataTypes.Number.Integer.impl.IntegerPackageImpl;

import OPCUAProfile.DataTypes.Number.NumberPackage;

import OPCUAProfile.DataTypes.Number.UInteger.UIntegerPackage;

import OPCUAProfile.DataTypes.Number.UInteger.impl.UIntegerPackageImpl;

import OPCUAProfile.DataTypes.Number.impl.NumberPackageImpl;

import OPCUAProfile.DataTypes.QualifiedName;
import OPCUAProfile.DataTypes._NodeClass;

import OPCUAProfile.OPCUAProfilePackage;

import OPCUAProfile.ObjectTypes.ObjectTypesPackage;

import OPCUAProfile.ObjectTypes.impl.ObjectTypesPackageImpl;

import OPCUAProfile.ReferenceTypes.References.ReferencesPackage;

import OPCUAProfile.ReferenceTypes.References.impl.ReferencesPackageImpl;

import OPCUAProfile.VariableTypes.VariableTypesPackage;

import OPCUAProfile.VariableTypes.impl.VariableTypesPackageImpl;

import OPCUAProfile.impl.OPCUAProfilePackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.uml2.types.TypesPackage;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataTypesPackageImpl extends EPackageImpl implements DataTypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualifiedNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localizedTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeIdEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum nodeIdTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum _NodeClassEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType booleanEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see OPCUAProfile.DataTypes.DataTypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DataTypesPackageImpl() {
		super(eNS_URI, DataTypesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link DataTypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DataTypesPackage init() {
		if (isInited) return (DataTypesPackage)EPackage.Registry.INSTANCE.getEPackage(DataTypesPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDataTypesPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DataTypesPackageImpl theDataTypesPackage = registeredDataTypesPackage instanceof DataTypesPackageImpl ? (DataTypesPackageImpl)registeredDataTypesPackage : new DataTypesPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(OPCUAProfilePackage.eNS_URI);
		OPCUAProfilePackageImpl theOPCUAProfilePackage = (OPCUAProfilePackageImpl)(registeredPackage instanceof OPCUAProfilePackageImpl ? registeredPackage : OPCUAProfilePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VariableTypesPackage.eNS_URI);
		VariableTypesPackageImpl theVariableTypesPackage = (VariableTypesPackageImpl)(registeredPackage instanceof VariableTypesPackageImpl ? registeredPackage : VariableTypesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NumberPackage.eNS_URI);
		NumberPackageImpl theNumberPackage = (NumberPackageImpl)(registeredPackage instanceof NumberPackageImpl ? registeredPackage : NumberPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(UIntegerPackage.eNS_URI);
		UIntegerPackageImpl theUIntegerPackage = (UIntegerPackageImpl)(registeredPackage instanceof UIntegerPackageImpl ? registeredPackage : UIntegerPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(IntegerPackage.eNS_URI);
		IntegerPackageImpl theIntegerPackage = (IntegerPackageImpl)(registeredPackage instanceof IntegerPackageImpl ? registeredPackage : IntegerPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ReferencesPackage.eNS_URI);
		ReferencesPackageImpl theReferencesPackage = (ReferencesPackageImpl)(registeredPackage instanceof ReferencesPackageImpl ? registeredPackage : ReferencesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ObjectTypesPackage.eNS_URI);
		ObjectTypesPackageImpl theObjectTypesPackage = (ObjectTypesPackageImpl)(registeredPackage instanceof ObjectTypesPackageImpl ? registeredPackage : ObjectTypesPackage.eINSTANCE);

		// Create package meta-data objects
		theDataTypesPackage.createPackageContents();
		theOPCUAProfilePackage.createPackageContents();
		theVariableTypesPackage.createPackageContents();
		theNumberPackage.createPackageContents();
		theUIntegerPackage.createPackageContents();
		theIntegerPackage.createPackageContents();
		theReferencesPackage.createPackageContents();
		theObjectTypesPackage.createPackageContents();

		// Initialize created meta-data
		theDataTypesPackage.initializePackageContents();
		theOPCUAProfilePackage.initializePackageContents();
		theVariableTypesPackage.initializePackageContents();
		theNumberPackage.initializePackageContents();
		theUIntegerPackage.initializePackageContents();
		theIntegerPackage.initializePackageContents();
		theReferencesPackage.initializePackageContents();
		theObjectTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDataTypesPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DataTypesPackage.eNS_URI, theDataTypesPackage);
		return theDataTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualifiedName() {
		return qualifiedNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQualifiedName_NamespaceIndex() {
		return (EAttribute)qualifiedNameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQualifiedName_Name() {
		return (EAttribute)qualifiedNameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalizedText() {
		return localizedTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalizedText_Locale() {
		return (EAttribute)localizedTextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalizedText_Text() {
		return (EAttribute)localizedTextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataType() {
		return dataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataType_IsAbstract() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataType_Base_Class() {
		return (EReference)dataTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeId() {
		return nodeIdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeId_NodeIdType() {
		return (EAttribute)nodeIdEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeId_StringNodeId() {
		return (EAttribute)nodeIdEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeId_NumericNodeId() {
		return (EAttribute)nodeIdEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeId_GuidNodeId() {
		return (EAttribute)nodeIdEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNodeIdType() {
		return nodeIdTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum get_NodeClass() {
		return _NodeClassEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getString() {
		return stringEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getBoolean() {
		return booleanEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypesFactory getDataTypesFactory() {
		return (DataTypesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		qualifiedNameEClass = createEClass(QUALIFIED_NAME);
		createEAttribute(qualifiedNameEClass, QUALIFIED_NAME__NAMESPACE_INDEX);
		createEAttribute(qualifiedNameEClass, QUALIFIED_NAME__NAME);

		localizedTextEClass = createEClass(LOCALIZED_TEXT);
		createEAttribute(localizedTextEClass, LOCALIZED_TEXT__LOCALE);
		createEAttribute(localizedTextEClass, LOCALIZED_TEXT__TEXT);

		dataTypeEClass = createEClass(DATA_TYPE);
		createEAttribute(dataTypeEClass, DATA_TYPE__IS_ABSTRACT);
		createEReference(dataTypeEClass, DATA_TYPE__BASE_CLASS);

		nodeIdEClass = createEClass(NODE_ID);
		createEAttribute(nodeIdEClass, NODE_ID__NODE_ID_TYPE);
		createEAttribute(nodeIdEClass, NODE_ID__STRING_NODE_ID);
		createEAttribute(nodeIdEClass, NODE_ID__NUMERIC_NODE_ID);
		createEAttribute(nodeIdEClass, NODE_ID__GUID_NODE_ID);

		// Create enums
		nodeIdTypeEEnum = createEEnum(NODE_ID_TYPE);
		_NodeClassEEnum = createEEnum(_NODE_CLASS);

		// Create data types
		stringEDataType = createEDataType(STRING);
		booleanEDataType = createEDataType(BOOLEAN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		NumberPackage theNumberPackage = (NumberPackage)EPackage.Registry.INSTANCE.getEPackage(NumberPackage.eNS_URI);
		IntegerPackage theIntegerPackage = (IntegerPackage)EPackage.Registry.INSTANCE.getEPackage(IntegerPackage.eNS_URI);
		OPCUAProfilePackage theOPCUAProfilePackage = (OPCUAProfilePackage)EPackage.Registry.INSTANCE.getEPackage(OPCUAProfilePackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theNumberPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dataTypeEClass.getESuperTypes().add(theOPCUAProfilePackage.getBaseNodeClass());

		// Initialize classes, features, and operations; add parameters
		initEClass(qualifiedNameEClass, QualifiedName.class, "QualifiedName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQualifiedName_NamespaceIndex(), theIntegerPackage.getInt32(), "NamespaceIndex", null, 1, 1, QualifiedName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getQualifiedName_Name(), this.getString(), "Name", null, 1, 1, QualifiedName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(localizedTextEClass, LocalizedText.class, "LocalizedText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocalizedText_Locale(), this.getString(), "Locale", null, 1, 1, LocalizedText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLocalizedText_Text(), this.getString(), "Text", null, 1, 1, LocalizedText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataTypeEClass, DataType.class, "DataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataType_IsAbstract(), this.getBoolean(), "IsAbstract", null, 1, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataType_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(nodeIdEClass, NodeId.class, "NodeId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNodeId_NodeIdType(), this.getNodeIdType(), "NodeIdType", null, 1, 1, NodeId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNodeId_StringNodeId(), this.getString(), "StringNodeId", null, 1, 1, NodeId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNodeId_NumericNodeId(), theIntegerPackage.getInt32(), "NumericNodeId", null, 1, 1, NodeId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNodeId_GuidNodeId(), this.getString(), "GuidNodeId", null, 1, 1, NodeId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(nodeIdTypeEEnum, NodeIdType.class, "NodeIdType");
		addEEnumLiteral(nodeIdTypeEEnum, NodeIdType.STRING);
		addEEnumLiteral(nodeIdTypeEEnum, NodeIdType.NUMERIC);
		addEEnumLiteral(nodeIdTypeEEnum, NodeIdType.GUID);
		addEEnumLiteral(nodeIdTypeEEnum, NodeIdType.OPAQUE);

		initEEnum(_NodeClassEEnum, _NodeClass.class, "_NodeClass");
		addEEnumLiteral(_NodeClassEEnum, _NodeClass.UNSPECIFIED);
		addEEnumLiteral(_NodeClassEEnum, _NodeClass.OBJECT);
		addEEnumLiteral(_NodeClassEEnum, _NodeClass.VARIABLE);
		addEEnumLiteral(_NodeClassEEnum, _NodeClass.METHOD);
		addEEnumLiteral(_NodeClassEEnum, _NodeClass.OBJECT_TYPE);
		addEEnumLiteral(_NodeClassEEnum, _NodeClass.VARIABLE_TYPE);
		addEEnumLiteral(_NodeClassEEnum, _NodeClass.REFERENCE_TYPE);
		addEEnumLiteral(_NodeClassEEnum, _NodeClass.DATA_TYPE);
		addEEnumLiteral(_NodeClassEEnum, _NodeClass.VIEW);

		// Initialize data types
		initEDataType(stringEDataType, String.class, "String", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(booleanEDataType, Boolean.class, "Boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";
		addAnnotation
		  (_NodeClassEEnum,
		   source,
		   new String[] {
			   "originalName", " NodeClass"
		   });
		addAnnotation
		  (getDataType_IsAbstract(),
		   source,
		   new String[] {
			   "originalName", "IsAbstract "
		   });
	}

} //DataTypesPackageImpl
