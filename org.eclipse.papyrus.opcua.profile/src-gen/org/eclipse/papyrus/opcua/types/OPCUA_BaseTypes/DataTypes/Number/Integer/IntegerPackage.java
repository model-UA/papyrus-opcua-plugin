/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer;

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
 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.IntegerFactory
 * @model kind="package"
 * @generated
 */
public interface IntegerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Integer";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///OPCUA_BaseTypes/DataTypes/Number/Integer.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "OPCUA_BaseTypes.DataTypes.Number.Integer";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IntegerPackage eINSTANCE = org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.impl.IntegerPackageImpl.init();

	/**
	 * The meta object id for the '<em>SByte</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.impl.IntegerPackageImpl#getSByte()
	 * @generated
	 */
	int SBYTE = 0;

	/**
	 * The meta object id for the '<em>Int16</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.impl.IntegerPackageImpl#getInt16()
	 * @generated
	 */
	int INT16 = 1;

	/**
	 * The meta object id for the '<em>Int64</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.impl.IntegerPackageImpl#getInt64()
	 * @generated
	 */
	int INT64 = 2;

	/**
	 * The meta object id for the '<em>Int32</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.impl.IntegerPackageImpl#getInt32()
	 * @generated
	 */
	int INT32 = 3;


	/**
	 * Returns the meta object for data type '<em>SByte</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>SByte</em>'.
	 * @model instanceClass="byte"
	 * @generated
	 */
	EDataType getSByte();

	/**
	 * Returns the meta object for data type '<em>Int16</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Int16</em>'.
	 * @model instanceClass="short"
	 * @generated
	 */
	EDataType getInt16();

	/**
	 * Returns the meta object for data type '<em>Int64</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Int64</em>'.
	 * @model instanceClass="long"
	 * @generated
	 */
	EDataType getInt64();

	/**
	 * Returns the meta object for data type '<em>Int32</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Int32</em>'.
	 * @model instanceClass="int"
	 * @generated
	 */
	EDataType getInt32();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IntegerFactory getIntegerFactory();

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
		 * The meta object literal for the '<em>SByte</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.impl.IntegerPackageImpl#getSByte()
		 * @generated
		 */
		EDataType SBYTE = eINSTANCE.getSByte();

		/**
		 * The meta object literal for the '<em>Int16</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.impl.IntegerPackageImpl#getInt16()
		 * @generated
		 */
		EDataType INT16 = eINSTANCE.getInt16();

		/**
		 * The meta object literal for the '<em>Int64</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.impl.IntegerPackageImpl#getInt64()
		 * @generated
		 */
		EDataType INT64 = eINSTANCE.getInt64();

		/**
		 * The meta object literal for the '<em>Int32</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.impl.IntegerPackageImpl#getInt32()
		 * @generated
		 */
		EDataType INT32 = eINSTANCE.getInt32();

	}

} //IntegerPackage
