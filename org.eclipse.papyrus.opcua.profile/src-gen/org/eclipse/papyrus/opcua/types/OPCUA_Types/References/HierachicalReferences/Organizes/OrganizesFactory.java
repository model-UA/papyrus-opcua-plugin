/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.Organizes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.Organizes.OrganizesPackage
 * @generated
 */
public interface OrganizesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OrganizesFactory eINSTANCE = org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.Organizes.impl.OrganizesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Display Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Display Name</em>'.
	 * @generated
	 */
	DisplayName createDisplayName();

	/**
	 * Returns a new object of class '<em>Node Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Id</em>'.
	 * @generated
	 */
	NodeId createNodeId();

	/**
	 * Returns a new object of class '<em>Browse Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Browse Name</em>'.
	 * @generated
	 */
	BrowseName createBrowseName();

	/**
	 * Returns a new object of class '<em>Inverse Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inverse Name</em>'.
	 * @generated
	 */
	InverseName createInverseName();

	/**
	 * Returns a new object of class '<em>Organizes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Organizes</em>'.
	 * @generated
	 */
	Organizes createOrganizes();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OrganizesPackage getOrganizesPackage();

} //OrganizesFactory