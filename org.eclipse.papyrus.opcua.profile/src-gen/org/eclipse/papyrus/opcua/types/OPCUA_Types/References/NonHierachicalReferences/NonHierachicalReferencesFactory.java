/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.NonHierachicalReferencesPackage
 * @generated
 */
public interface NonHierachicalReferencesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NonHierachicalReferencesFactory eINSTANCE = org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.impl.NonHierachicalReferencesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Non Hierachical References</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Non Hierachical References</em>'.
	 * @generated
	 */
	NonHierachicalReferences createNonHierachicalReferences();

	/**
	 * Returns a new object of class '<em>Node Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Id</em>'.
	 * @generated
	 */
	NodeId createNodeId();

	/**
	 * Returns a new object of class '<em>Display Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Display Name</em>'.
	 * @generated
	 */
	DisplayName createDisplayName();

	/**
	 * Returns a new object of class '<em>Browse Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Browse Name</em>'.
	 * @generated
	 */
	BrowseName createBrowseName();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NonHierachicalReferencesPackage getNonHierachicalReferencesPackage();

} //NonHierachicalReferencesFactory
