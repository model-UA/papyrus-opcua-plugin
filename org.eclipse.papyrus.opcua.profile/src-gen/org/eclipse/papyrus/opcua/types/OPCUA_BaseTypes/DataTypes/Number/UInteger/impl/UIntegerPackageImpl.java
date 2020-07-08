/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.UInteger.impl;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage;

import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.IntegerPackage;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.impl.IntegerPackageImpl;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.NumberPackage;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.UInteger.UIntegerFactory;
import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.UInteger.UIntegerPackage;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.impl.NumberPackageImpl;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.impl.DataTypesPackageImpl;

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
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.UInteger.UIntegerPackage#eNS_URI
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
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(basetypesPackage.eNS_URI);
		basetypesPackageImpl thebasetypesPackage = (basetypesPackageImpl)(registeredPackage instanceof basetypesPackageImpl ? registeredPackage : basetypesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DataTypesPackage.eNS_URI);
		DataTypesPackageImpl theDataTypesPackage = (DataTypesPackageImpl)(registeredPackage instanceof DataTypesPackageImpl ? registeredPackage : DataTypesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(NumberPackage.eNS_URI);
		NumberPackageImpl theNumberPackage = (NumberPackageImpl)(registeredPackage instanceof NumberPackageImpl ? registeredPackage : NumberPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(IntegerPackage.eNS_URI);
		IntegerPackageImpl theIntegerPackage = (IntegerPackageImpl)(registeredPackage instanceof IntegerPackageImpl ? registeredPackage : IntegerPackage.eINSTANCE);

		// Create package meta-data objects
		theUIntegerPackage.createPackageContents();
		thebasetypesPackage.createPackageContents();
		theDataTypesPackage.createPackageContents();
		theNumberPackage.createPackageContents();
		theIntegerPackage.createPackageContents();

		// Initialize created meta-data
		theUIntegerPackage.initializePackageContents();
		thebasetypesPackage.initializePackageContents();
		theDataTypesPackage.initializePackageContents();
		theNumberPackage.initializePackageContents();
		theIntegerPackage.initializePackageContents();

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
	@Override
	public EDataType getByte() {
		return byteEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getUInt16() {
		return uInt16EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getUInt32() {
		return uInt32EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getUInt64() {
		return uInt64EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		initEDataType(byteEDataType, byte.class, "Byte", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uInt16EDataType, short.class, "UInt16", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uInt32EDataType, int.class, "UInt32", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uInt64EDataType, long.class, "UInt64", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
	}

} //UIntegerPackageImpl
