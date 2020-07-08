/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.impl;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage;

import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.IntegerFactory;
import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.IntegerPackage;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.NumberPackage;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.UInteger.UIntegerPackage;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.UInteger.impl.UIntegerPackageImpl;

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
public class IntegerPackageImpl extends EPackageImpl implements IntegerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType sByteEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType int16EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType int64EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType int32EDataType = null;

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
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.IntegerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private IntegerPackageImpl() {
		super(eNS_URI, IntegerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link IntegerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IntegerPackage init() {
		if (isInited) return (IntegerPackage)EPackage.Registry.INSTANCE.getEPackage(IntegerPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredIntegerPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		IntegerPackageImpl theIntegerPackage = registeredIntegerPackage instanceof IntegerPackageImpl ? (IntegerPackageImpl)registeredIntegerPackage : new IntegerPackageImpl();

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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(UIntegerPackage.eNS_URI);
		UIntegerPackageImpl theUIntegerPackage = (UIntegerPackageImpl)(registeredPackage instanceof UIntegerPackageImpl ? registeredPackage : UIntegerPackage.eINSTANCE);

		// Create package meta-data objects
		theIntegerPackage.createPackageContents();
		thebasetypesPackage.createPackageContents();
		theDataTypesPackage.createPackageContents();
		theNumberPackage.createPackageContents();
		theUIntegerPackage.createPackageContents();

		// Initialize created meta-data
		theIntegerPackage.initializePackageContents();
		thebasetypesPackage.initializePackageContents();
		theDataTypesPackage.initializePackageContents();
		theNumberPackage.initializePackageContents();
		theUIntegerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theIntegerPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IntegerPackage.eNS_URI, theIntegerPackage);
		return theIntegerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getSByte() {
		return sByteEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getInt16() {
		return int16EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getInt64() {
		return int64EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getInt32() {
		return int32EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntegerFactory getIntegerFactory() {
		return (IntegerFactory)getEFactoryInstance();
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
		sByteEDataType = createEDataType(SBYTE);
		int16EDataType = createEDataType(INT16);
		int64EDataType = createEDataType(INT64);
		int32EDataType = createEDataType(INT32);
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
		initEDataType(sByteEDataType, byte.class, "SByte", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(int16EDataType, short.class, "Int16", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(int64EDataType, long.class, "Int64", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(int32EDataType, int.class, "Int32", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
	}

} //IntegerPackageImpl
