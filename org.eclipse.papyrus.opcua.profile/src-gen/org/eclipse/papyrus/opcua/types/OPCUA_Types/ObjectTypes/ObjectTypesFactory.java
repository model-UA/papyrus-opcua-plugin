/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.ObjectTypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.ObjectTypes.ObjectTypesPackage
 * @generated
 */
public interface ObjectTypesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ObjectTypesFactory eINSTANCE = org.eclipse.papyrus.opcua.types.OPCUA_Types.ObjectTypes.impl.ObjectTypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Base Object Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Object Type</em>'.
	 * @generated
	 */
	BaseObjectType createBaseObjectType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ObjectTypesPackage getObjectTypesPackage();

} //ObjectTypesFactory
