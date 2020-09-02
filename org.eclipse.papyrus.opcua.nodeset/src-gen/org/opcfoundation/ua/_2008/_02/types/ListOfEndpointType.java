/**
 */
package org.opcfoundation.ua._2008._02.types;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Of Endpoint Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.ListOfEndpointType#getEndpointType <em>Endpoint Type</em>}</li>
 * </ul>
 *
 * @see org.opcfoundation.ua._2008._02.types.TypesPackage#getListOfEndpointType()
 * @model extendedMetaData="name='ListOfEndpointType' kind='elementOnly'"
 * @generated
 */
public interface ListOfEndpointType extends EObject {
	/**
	 * Returns the value of the '<em><b>Endpoint Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2008._02.types.EndpointType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Type</em>' containment reference list.
	 * @see org.opcfoundation.ua._2008._02.types.TypesPackage#getListOfEndpointType_EndpointType()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='EndpointType' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<EndpointType> getEndpointType();

} // ListOfEndpointType
