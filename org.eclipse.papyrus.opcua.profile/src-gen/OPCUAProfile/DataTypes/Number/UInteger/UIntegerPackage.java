/**
 */
package OPCUAProfile.DataTypes.Number.UInteger;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

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
 * @see OPCUAProfile.DataTypes.Number.UInteger.UIntegerFactory
 * @model kind="package"
 * @generated
 */
public interface UIntegerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "UInteger";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///OPCUAProfile/DataTypes/Number/UInteger.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "OPCUAProfile.DataTypes.Number.UInteger";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UIntegerPackage eINSTANCE = OPCUAProfile.DataTypes.Number.UInteger.impl.UIntegerPackageImpl.init();

	/**
	 * The meta object id for the '<em>Byte</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Byte
	 * @see OPCUAProfile.DataTypes.Number.UInteger.impl.UIntegerPackageImpl#getByte()
	 * @generated
	 */
	int BYTE = 0;

	/**
	 * The meta object id for the '<em>UInt16</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see OPCUAProfile.DataTypes.Number.UInteger.impl.UIntegerPackageImpl#getUInt16()
	 * @generated
	 */
	int UINT16 = 1;

	/**
	 * The meta object id for the '<em>UInt32</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see OPCUAProfile.DataTypes.Number.UInteger.impl.UIntegerPackageImpl#getUInt32()
	 * @generated
	 */
	int UINT32 = 2;

	/**
	 * The meta object id for the '<em>UInt64</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see OPCUAProfile.DataTypes.Number.UInteger.impl.UIntegerPackageImpl#getUInt64()
	 * @generated
	 */
	int UINT64 = 3;


	/**
	 * Returns the meta object for data type '{@link Byte <em>Byte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Byte</em>'.
	 * @see Byte
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getByte();

	/**
	 * Returns the meta object for data type '<em>UInt16</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UInt16</em>'.
	 * @model instanceClass="short"
	 * @generated
	 */
	EDataType getUInt16();

	/**
	 * Returns the meta object for data type '<em>UInt32</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UInt32</em>'.
	 * @model instanceClass="int"
	 * @generated
	 */
	EDataType getUInt32();

	/**
	 * Returns the meta object for data type '<em>UInt64</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UInt64</em>'.
	 * @model instanceClass="long"
	 * @generated
	 */
	EDataType getUInt64();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UIntegerFactory getUIntegerFactory();

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
		 * The meta object literal for the '<em>Byte</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Byte
		 * @see OPCUAProfile.DataTypes.Number.UInteger.impl.UIntegerPackageImpl#getByte()
		 * @generated
		 */
		EDataType BYTE = eINSTANCE.getByte();

		/**
		 * The meta object literal for the '<em>UInt16</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see OPCUAProfile.DataTypes.Number.UInteger.impl.UIntegerPackageImpl#getUInt16()
		 * @generated
		 */
		EDataType UINT16 = eINSTANCE.getUInt16();

		/**
		 * The meta object literal for the '<em>UInt32</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see OPCUAProfile.DataTypes.Number.UInteger.impl.UIntegerPackageImpl#getUInt32()
		 * @generated
		 */
		EDataType UINT32 = eINSTANCE.getUInt32();

		/**
		 * The meta object literal for the '<em>UInt64</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see OPCUAProfile.DataTypes.Number.UInteger.impl.UIntegerPackageImpl#getUInt64()
		 * @generated
		 */
		EDataType UINT64 = eINSTANCE.getUInt64();

	}

} //UIntegerPackage
