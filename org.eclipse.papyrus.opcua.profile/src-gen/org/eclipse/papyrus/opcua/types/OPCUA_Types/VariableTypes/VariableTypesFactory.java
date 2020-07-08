/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.VariableTypesPackage
 * @generated
 */
public interface VariableTypesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VariableTypesFactory eINSTANCE = org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.impl.VariableTypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Base Variable Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Variable Type</em>'.
	 * @generated
	 */
	BaseVariableType createBaseVariableType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VariableTypesPackage getVariableTypesPackage();

} //VariableTypesFactory
