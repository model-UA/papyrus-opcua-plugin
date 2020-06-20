/**
 */
package OPCUAProfile.impl;

import OPCUAProfile.BaseNodeClass;

import OPCUAProfile.DataTypes.DataTypesPackage;

import OPCUAProfile.DataTypes.Number.Integer.IntegerPackage;

import OPCUAProfile.DataTypes.Number.Integer.impl.IntegerPackageImpl;

import OPCUAProfile.DataTypes.Number.NumberPackage;

import OPCUAProfile.DataTypes.Number.UInteger.UIntegerPackage;

import OPCUAProfile.DataTypes.Number.UInteger.impl.UIntegerPackageImpl;

import OPCUAProfile.DataTypes.Number.impl.NumberPackageImpl;

import OPCUAProfile.DataTypes.impl.DataTypesPackageImpl;

import OPCUAProfile.Method;
import OPCUAProfile.OPCUAProfileFactory;
import OPCUAProfile.OPCUAProfilePackage;

import OPCUAProfile.ObjectTypes.ObjectTypesPackage;

import OPCUAProfile.ObjectTypes.impl.ObjectTypesPackageImpl;

import OPCUAProfile.ReferenceTypes.References.ReferencesPackage;

import OPCUAProfile.ReferenceTypes.References.impl.ReferencesPackageImpl;

import OPCUAProfile.Variable;

import OPCUAProfile.VariableTypes.VariableTypesPackage;

import OPCUAProfile.VariableTypes.impl.VariableTypesPackageImpl;

import OPCUAProfile.View;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
public class OPCUAProfilePackageImpl extends EPackageImpl implements OPCUAProfilePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseNodeClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewEClass = null;

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
	 * @see OPCUAProfile.OPCUAProfilePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OPCUAProfilePackageImpl() {
		super(eNS_URI, OPCUAProfileFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OPCUAProfilePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OPCUAProfilePackage init() {
		if (isInited) return (OPCUAProfilePackage)EPackage.Registry.INSTANCE.getEPackage(OPCUAProfilePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredOPCUAProfilePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		OPCUAProfilePackageImpl theOPCUAProfilePackage = registeredOPCUAProfilePackage instanceof OPCUAProfilePackageImpl ? (OPCUAProfilePackageImpl)registeredOPCUAProfilePackage : new OPCUAProfilePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(VariableTypesPackage.eNS_URI);
		VariableTypesPackageImpl theVariableTypesPackage = (VariableTypesPackageImpl)(registeredPackage instanceof VariableTypesPackageImpl ? registeredPackage : VariableTypesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DataTypesPackage.eNS_URI);
		DataTypesPackageImpl theDataTypesPackage = (DataTypesPackageImpl)(registeredPackage instanceof DataTypesPackageImpl ? registeredPackage : DataTypesPackage.eINSTANCE);
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
		theOPCUAProfilePackage.createPackageContents();
		theVariableTypesPackage.createPackageContents();
		theDataTypesPackage.createPackageContents();
		theNumberPackage.createPackageContents();
		theUIntegerPackage.createPackageContents();
		theIntegerPackage.createPackageContents();
		theReferencesPackage.createPackageContents();
		theObjectTypesPackage.createPackageContents();

		// Initialize created meta-data
		theOPCUAProfilePackage.initializePackageContents();
		theVariableTypesPackage.initializePackageContents();
		theDataTypesPackage.initializePackageContents();
		theNumberPackage.initializePackageContents();
		theUIntegerPackage.initializePackageContents();
		theIntegerPackage.initializePackageContents();
		theReferencesPackage.initializePackageContents();
		theObjectTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOPCUAProfilePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OPCUAProfilePackage.eNS_URI, theOPCUAProfilePackage);
		return theOPCUAProfilePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBaseNodeClass() {
		return baseNodeClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseNodeClass_NodeId() {
		return (EReference)baseNodeClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBaseNodeClass_NodeClass() {
		return (EAttribute)baseNodeClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseNodeClass_BrowseName() {
		return (EReference)baseNodeClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseNodeClass_DisplayName() {
		return (EReference)baseNodeClassEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseNodeClass_Description() {
		return (EReference)baseNodeClassEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBaseNodeClass_WriteMask() {
		return (EAttribute)baseNodeClassEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_Value() {
		return (EReference)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_DataType() {
		return (EReference)variableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_ValueRank() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_ArrayDimensions() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_AccessLevel() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_UserAccessLevel() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_MinimumSamplingInterval() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Historizing() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_Base_Class() {
		return (EReference)variableEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObject() {
		return objectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObject_EventNotifier() {
		return (EAttribute)objectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObject_Base_Class() {
		return (EReference)objectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethod() {
		return methodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethod_Executable() {
		return (EAttribute)methodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethod_UserExecutable() {
		return (EAttribute)methodEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethod_Base_Class() {
		return (EReference)methodEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getView() {
		return viewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getView_ContainsNoLoops() {
		return (EAttribute)viewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getView_EventNotifier() {
		return (EAttribute)viewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getView_Base_Class() {
		return (EReference)viewEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPCUAProfileFactory getOPCUAProfileFactory() {
		return (OPCUAProfileFactory)getEFactoryInstance();
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
		baseNodeClassEClass = createEClass(BASE_NODE_CLASS);
		createEReference(baseNodeClassEClass, BASE_NODE_CLASS__NODE_ID);
		createEAttribute(baseNodeClassEClass, BASE_NODE_CLASS__NODE_CLASS);
		createEReference(baseNodeClassEClass, BASE_NODE_CLASS__BROWSE_NAME);
		createEReference(baseNodeClassEClass, BASE_NODE_CLASS__DISPLAY_NAME);
		createEReference(baseNodeClassEClass, BASE_NODE_CLASS__DESCRIPTION);
		createEAttribute(baseNodeClassEClass, BASE_NODE_CLASS__WRITE_MASK);

		variableEClass = createEClass(VARIABLE);
		createEReference(variableEClass, VARIABLE__VALUE);
		createEReference(variableEClass, VARIABLE__DATA_TYPE);
		createEAttribute(variableEClass, VARIABLE__VALUE_RANK);
		createEAttribute(variableEClass, VARIABLE__ARRAY_DIMENSIONS);
		createEAttribute(variableEClass, VARIABLE__ACCESS_LEVEL);
		createEAttribute(variableEClass, VARIABLE__USER_ACCESS_LEVEL);
		createEAttribute(variableEClass, VARIABLE__MINIMUM_SAMPLING_INTERVAL);
		createEAttribute(variableEClass, VARIABLE__HISTORIZING);
		createEReference(variableEClass, VARIABLE__BASE_CLASS);

		objectEClass = createEClass(OBJECT);
		createEAttribute(objectEClass, OBJECT__EVENT_NOTIFIER);
		createEReference(objectEClass, OBJECT__BASE_CLASS);

		methodEClass = createEClass(METHOD);
		createEAttribute(methodEClass, METHOD__EXECUTABLE);
		createEAttribute(methodEClass, METHOD__USER_EXECUTABLE);
		createEReference(methodEClass, METHOD__BASE_CLASS);

		viewEClass = createEClass(VIEW);
		createEAttribute(viewEClass, VIEW__CONTAINS_NO_LOOPS);
		createEAttribute(viewEClass, VIEW__EVENT_NOTIFIER);
		createEReference(viewEClass, VIEW__BASE_CLASS);
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
		VariableTypesPackage theVariableTypesPackage = (VariableTypesPackage)EPackage.Registry.INSTANCE.getEPackage(VariableTypesPackage.eNS_URI);
		DataTypesPackage theDataTypesPackage = (DataTypesPackage)EPackage.Registry.INSTANCE.getEPackage(DataTypesPackage.eNS_URI);
		ReferencesPackage theReferencesPackage = (ReferencesPackage)EPackage.Registry.INSTANCE.getEPackage(ReferencesPackage.eNS_URI);
		ObjectTypesPackage theObjectTypesPackage = (ObjectTypesPackage)EPackage.Registry.INSTANCE.getEPackage(ObjectTypesPackage.eNS_URI);
		UIntegerPackage theUIntegerPackage = (UIntegerPackage)EPackage.Registry.INSTANCE.getEPackage(UIntegerPackage.eNS_URI);
		IntegerPackage theIntegerPackage = (IntegerPackage)EPackage.Registry.INSTANCE.getEPackage(IntegerPackage.eNS_URI);
		NumberPackage theNumberPackage = (NumberPackage)EPackage.Registry.INSTANCE.getEPackage(NumberPackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theVariableTypesPackage);
		getESubpackages().add(theDataTypesPackage);
		getESubpackages().add(theReferencesPackage);
		getESubpackages().add(theObjectTypesPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		variableEClass.getESuperTypes().add(this.getBaseNodeClass());
		objectEClass.getESuperTypes().add(this.getBaseNodeClass());
		methodEClass.getESuperTypes().add(this.getBaseNodeClass());
		viewEClass.getESuperTypes().add(this.getBaseNodeClass());

		// Initialize classes, features, and operations; add parameters
		initEClass(baseNodeClassEClass, BaseNodeClass.class, "BaseNodeClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBaseNodeClass_NodeId(), theDataTypesPackage.getNodeId(), null, "NodeId", null, 1, 1, BaseNodeClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBaseNodeClass_NodeClass(), theDataTypesPackage.get_NodeClass(), "NodeClass", null, 1, 1, BaseNodeClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBaseNodeClass_BrowseName(), theDataTypesPackage.getQualifiedName(), null, "BrowseName", null, 1, 1, BaseNodeClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBaseNodeClass_DisplayName(), theDataTypesPackage.getLocalizedText(), null, "DisplayName", null, 1, 1, BaseNodeClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBaseNodeClass_Description(), theDataTypesPackage.getLocalizedText(), null, "Description", null, 1, 1, BaseNodeClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBaseNodeClass_WriteMask(), theUIntegerPackage.getUInt32(), "WriteMask", null, 1, 1, BaseNodeClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariable_Value(), theObjectTypesPackage.getObjectType(), null, "Value", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariable_DataType(), theDataTypesPackage.getNodeId(), null, "DataType", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariable_ValueRank(), theIntegerPackage.getInt32(), "ValueRank", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariable_ArrayDimensions(), theUIntegerPackage.getUInt32(), "ArrayDimensions", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariable_AccessLevel(), theUIntegerPackage.getByte(), "AccessLevel", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariable_UserAccessLevel(), theUIntegerPackage.getByte(), "UserAccessLevel", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariable_MinimumSamplingInterval(), theNumberPackage.getDouble(), "MinimumSamplingInterval", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariable_Historizing(), theDataTypesPackage.getBoolean(), "Historizing", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariable_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(objectEClass, OPCUAProfile.Object.class, "Object", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObject_EventNotifier(), theUIntegerPackage.getByte(), "EventNotifier", null, 1, 1, OPCUAProfile.Object.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getObject_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 0, 1, OPCUAProfile.Object.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(methodEClass, Method.class, "Method", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMethod_Executable(), theDataTypesPackage.getBoolean(), "Executable", null, 1, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMethod_UserExecutable(), theDataTypesPackage.getBoolean(), "UserExecutable", null, 1, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMethod_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 0, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(viewEClass, View.class, "View", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getView_ContainsNoLoops(), theDataTypesPackage.getBoolean(), "ContainsNoLoops", null, 1, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getView_EventNotifier(), theUIntegerPackage.getByte(), "EventNotifier", null, 1, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getView_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 0, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

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
		  (this,
		   source,
		   new String[] {
			   "originalName", "OPC-UA Profile"
		   });
		addAnnotation
		  (baseNodeClassEClass,
		   source,
		   new String[] {
			   "originalName", "Base Node Class"
		   });
	}

} //OPCUAProfilePackageImpl
