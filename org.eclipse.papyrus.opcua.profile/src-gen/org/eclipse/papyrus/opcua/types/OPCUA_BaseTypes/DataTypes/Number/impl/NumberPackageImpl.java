/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.impl;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage;

import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.basetypesPackageImpl;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.IntegerPackage;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.impl.IntegerPackageImpl;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.NumberFactory;
import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.NumberPackage;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.UInteger.UIntegerPackage;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.UInteger.impl.UIntegerPackageImpl;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.impl.DataTypesPackageImpl;

import org.eclipse.uml2.types.TypesPackage;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NumberPackageImpl extends EPackageImpl implements NumberPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType doubleEDataType = null;

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
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.NumberPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NumberPackageImpl() {
		super(eNS_URI, NumberFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link NumberPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NumberPackage init() {
		if (isInited) return (NumberPackage)EPackage.Registry.INSTANCE.getEPackage(NumberPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredNumberPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		NumberPackageImpl theNumberPackage = registeredNumberPackage instanceof NumberPackageImpl ? (NumberPackageImpl)registeredNumberPackage : new NumberPackageImpl();

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
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(UIntegerPackage.eNS_URI);
		UIntegerPackageImpl theUIntegerPackage = (UIntegerPackageImpl)(registeredPackage instanceof UIntegerPackageImpl ? registeredPackage : UIntegerPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(IntegerPackage.eNS_URI);
		IntegerPackageImpl theIntegerPackage = (IntegerPackageImpl)(registeredPackage instanceof IntegerPackageImpl ? registeredPackage : IntegerPackage.eINSTANCE);

		// Create package meta-data objects
		theNumberPackage.createPackageContents();
		thebasetypesPackage.createPackageContents();
		theDataTypesPackage.createPackageContents();
		theUIntegerPackage.createPackageContents();
		theIntegerPackage.createPackageContents();

		// Initialize created meta-data
		theNumberPackage.initializePackageContents();
		thebasetypesPackage.initializePackageContents();
		theDataTypesPackage.initializePackageContents();
		theUIntegerPackage.initializePackageContents();
		theIntegerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNumberPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NumberPackage.eNS_URI, theNumberPackage);
		return theNumberPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getDouble() {
		return doubleEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NumberFactory getNumberFactory() {
		return (NumberFactory)getEFactoryInstance();
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
		doubleEDataType = createEDataType(DOUBLE);
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
		UIntegerPackage theUIntegerPackage = (UIntegerPackage)EPackage.Registry.INSTANCE.getEPackage(UIntegerPackage.eNS_URI);
		IntegerPackage theIntegerPackage = (IntegerPackage)EPackage.Registry.INSTANCE.getEPackage(IntegerPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theUIntegerPackage);
		getESubpackages().add(theIntegerPackage);

		// Initialize data types
		initEDataType(doubleEDataType, double.class, "Double", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
	}

} //NumberPackageImpl
