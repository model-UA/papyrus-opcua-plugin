/**
 */
package OPCUAProfile.ReferenceTypes.References.impl;

import OPCUAProfile.DataTypes.DataTypesPackage;

import OPCUAProfile.DataTypes.Number.Integer.IntegerPackage;

import OPCUAProfile.DataTypes.Number.Integer.impl.IntegerPackageImpl;

import OPCUAProfile.DataTypes.Number.NumberPackage;

import OPCUAProfile.DataTypes.Number.UInteger.UIntegerPackage;

import OPCUAProfile.DataTypes.Number.UInteger.impl.UIntegerPackageImpl;

import OPCUAProfile.DataTypes.Number.impl.NumberPackageImpl;

import OPCUAProfile.DataTypes.impl.DataTypesPackageImpl;

import OPCUAProfile.OPCUAProfilePackage;

import OPCUAProfile.ObjectTypes.ObjectTypesPackage;

import OPCUAProfile.ObjectTypes.impl.ObjectTypesPackageImpl;

import OPCUAProfile.ReferenceTypes.References.ReferenceType;
import OPCUAProfile.ReferenceTypes.References.ReferencesFactory;
import OPCUAProfile.ReferenceTypes.References.ReferencesPackage;

import OPCUAProfile.VariableTypes.VariableTypesPackage;

import OPCUAProfile.VariableTypes.impl.VariableTypesPackageImpl;

import OPCUAProfile.impl.OPCUAProfilePackageImpl;

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
public class ReferencesPackageImpl extends EPackageImpl implements ReferencesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceTypeEClass = null;

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
	 * @see OPCUAProfile.ReferenceTypes.References.ReferencesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ReferencesPackageImpl() {
		super(eNS_URI, ReferencesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ReferencesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ReferencesPackage init() {
		if (isInited) return (ReferencesPackage)EPackage.Registry.INSTANCE.getEPackage(ReferencesPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredReferencesPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ReferencesPackageImpl theReferencesPackage = registeredReferencesPackage instanceof ReferencesPackageImpl ? (ReferencesPackageImpl)registeredReferencesPackage : new ReferencesPackageImpl();

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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DataTypesPackage.eNS_URI);
		DataTypesPackageImpl theDataTypesPackage = (DataTypesPackageImpl)(registeredPackage instanceof DataTypesPackageImpl ? registeredPackage : DataTypesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NumberPackage.eNS_URI);
		NumberPackageImpl theNumberPackage = (NumberPackageImpl)(registeredPackage instanceof NumberPackageImpl ? registeredPackage : NumberPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(UIntegerPackage.eNS_URI);
		UIntegerPackageImpl theUIntegerPackage = (UIntegerPackageImpl)(registeredPackage instanceof UIntegerPackageImpl ? registeredPackage : UIntegerPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(IntegerPackage.eNS_URI);
		IntegerPackageImpl theIntegerPackage = (IntegerPackageImpl)(registeredPackage instanceof IntegerPackageImpl ? registeredPackage : IntegerPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ObjectTypesPackage.eNS_URI);
		ObjectTypesPackageImpl theObjectTypesPackage = (ObjectTypesPackageImpl)(registeredPackage instanceof ObjectTypesPackageImpl ? registeredPackage : ObjectTypesPackage.eINSTANCE);

		// Create package meta-data objects
		theReferencesPackage.createPackageContents();
		theOPCUAProfilePackage.createPackageContents();
		theVariableTypesPackage.createPackageContents();
		theDataTypesPackage.createPackageContents();
		theNumberPackage.createPackageContents();
		theUIntegerPackage.createPackageContents();
		theIntegerPackage.createPackageContents();
		theObjectTypesPackage.createPackageContents();

		// Initialize created meta-data
		theReferencesPackage.initializePackageContents();
		theOPCUAProfilePackage.initializePackageContents();
		theVariableTypesPackage.initializePackageContents();
		theDataTypesPackage.initializePackageContents();
		theNumberPackage.initializePackageContents();
		theUIntegerPackage.initializePackageContents();
		theIntegerPackage.initializePackageContents();
		theObjectTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theReferencesPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ReferencesPackage.eNS_URI, theReferencesPackage);
		return theReferencesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceType() {
		return referenceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceType_IsAbstract() {
		return (EAttribute)referenceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceType_Symmetric() {
		return (EAttribute)referenceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceType_InverseName() {
		return (EReference)referenceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceType_Base_Class() {
		return (EReference)referenceTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferencesFactory getReferencesFactory() {
		return (ReferencesFactory)getEFactoryInstance();
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
		referenceTypeEClass = createEClass(REFERENCE_TYPE);
		createEAttribute(referenceTypeEClass, REFERENCE_TYPE__IS_ABSTRACT);
		createEAttribute(referenceTypeEClass, REFERENCE_TYPE__SYMMETRIC);
		createEReference(referenceTypeEClass, REFERENCE_TYPE__INVERSE_NAME);
		createEReference(referenceTypeEClass, REFERENCE_TYPE__BASE_CLASS);
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
		OPCUAProfilePackage theOPCUAProfilePackage = (OPCUAProfilePackage)EPackage.Registry.INSTANCE.getEPackage(OPCUAProfilePackage.eNS_URI);
		DataTypesPackage theDataTypesPackage = (DataTypesPackage)EPackage.Registry.INSTANCE.getEPackage(DataTypesPackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		referenceTypeEClass.getESuperTypes().add(theOPCUAProfilePackage.getBaseNodeClass());

		// Initialize classes, features, and operations; add parameters
		initEClass(referenceTypeEClass, ReferenceType.class, "ReferenceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceType_IsAbstract(), theDataTypesPackage.getBoolean(), "IsAbstract", null, 1, 1, ReferenceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getReferenceType_Symmetric(), theDataTypesPackage.getBoolean(), "Symmetric", null, 1, 1, ReferenceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getReferenceType_InverseName(), theDataTypesPackage.getLocalizedText(), null, "InverseName", null, 0, 1, ReferenceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getReferenceType_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 0, 1, ReferenceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //ReferencesPackageImpl
