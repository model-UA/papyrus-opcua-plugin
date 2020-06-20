/**
 */
package OPCUAProfile.DataTypes.Number.UInteger.impl;

import OPCUAProfile.DataTypes.DataTypesPackage;

import OPCUAProfile.DataTypes.Number.Integer.IntegerPackage;

import OPCUAProfile.DataTypes.Number.Integer.impl.IntegerPackageImpl;

import OPCUAProfile.DataTypes.Number.NumberPackage;

import OPCUAProfile.DataTypes.Number.UInteger.UIntegerFactory;
import OPCUAProfile.DataTypes.Number.UInteger.UIntegerPackage;

import OPCUAProfile.DataTypes.Number.impl.NumberPackageImpl;

import OPCUAProfile.DataTypes.impl.DataTypesPackageImpl;

import OPCUAProfile.OPCUAProfilePackage;

import OPCUAProfile.ObjectTypes.ObjectTypesPackage;

import OPCUAProfile.ObjectTypes.impl.ObjectTypesPackageImpl;

import OPCUAProfile.ReferenceTypes.References.ReferencesPackage;

import OPCUAProfile.ReferenceTypes.References.impl.ReferencesPackageImpl;

import OPCUAProfile.VariableTypes.VariableTypesPackage;

import OPCUAProfile.VariableTypes.impl.VariableTypesPackageImpl;

import OPCUAProfile.impl.OPCUAProfilePackageImpl;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
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
public class UIntegerPackageImpl extends EPackageImpl implements UIntegerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType byteEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uInt16EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uInt32EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uInt64EDataType = null;

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
	 * @see OPCUAProfile.DataTypes.Number.UInteger.UIntegerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UIntegerPackageImpl() {
		super(eNS_URI, UIntegerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link UIntegerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UIntegerPackage init() {
		if (isInited) return (UIntegerPackage)EPackage.Registry.INSTANCE.getEPackage(UIntegerPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredUIntegerPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		UIntegerPackageImpl theUIntegerPackage = registeredUIntegerPackage instanceof UIntegerPackageImpl ? (UIntegerPackageImpl)registeredUIntegerPackage : new UIntegerPackageImpl();

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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(IntegerPackage.eNS_URI);
		IntegerPackageImpl theIntegerPackage = (IntegerPackageImpl)(registeredPackage instanceof IntegerPackageImpl ? registeredPackage : IntegerPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ReferencesPackage.eNS_URI);
		ReferencesPackageImpl theReferencesPackage = (ReferencesPackageImpl)(registeredPackage instanceof ReferencesPackageImpl ? registeredPackage : ReferencesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ObjectTypesPackage.eNS_URI);
		ObjectTypesPackageImpl theObjectTypesPackage = (ObjectTypesPackageImpl)(registeredPackage instanceof ObjectTypesPackageImpl ? registeredPackage : ObjectTypesPackage.eINSTANCE);

		// Create package meta-data objects
		theUIntegerPackage.createPackageContents();
		theOPCUAProfilePackage.createPackageContents();
		theVariableTypesPackage.createPackageContents();
		theDataTypesPackage.createPackageContents();
		theNumberPackage.createPackageContents();
		theIntegerPackage.createPackageContents();
		theReferencesPackage.createPackageContents();
		theObjectTypesPackage.createPackageContents();

		// Initialize created meta-data
		theUIntegerPackage.initializePackageContents();
		theOPCUAProfilePackage.initializePackageContents();
		theVariableTypesPackage.initializePackageContents();
		theDataTypesPackage.initializePackageContents();
		theNumberPackage.initializePackageContents();
		theIntegerPackage.initializePackageContents();
		theReferencesPackage.initializePackageContents();
		theObjectTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUIntegerPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UIntegerPackage.eNS_URI, theUIntegerPackage);
		return theUIntegerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getByte() {
		return byteEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUInt16() {
		return uInt16EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUInt32() {
		return uInt32EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUInt64() {
		return uInt64EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UIntegerFactory getUIntegerFactory() {
		return (UIntegerFactory)getEFactoryInstance();
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

		// Create data types
		byteEDataType = createEDataType(BYTE);
		uInt16EDataType = createEDataType(UINT16);
		uInt32EDataType = createEDataType(UINT32);
		uInt64EDataType = createEDataType(UINT64);
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

		// Initialize data types
		initEDataType(byteEDataType, Byte.class, "Byte", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uInt16EDataType, short.class, "UInt16", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uInt32EDataType, int.class, "UInt32", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uInt64EDataType, long.class, "UInt64", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
	}

} //UIntegerPackageImpl
