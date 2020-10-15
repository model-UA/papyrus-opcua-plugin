/**
 */
package org.opcfoundation.ua._2011._03.ua.UANodeSet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Of Extensions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.ListOfExtensions#getExtension <em>Extension</em>}</li>
 * </ul>
 *
 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getListOfExtensions()
 * @model extendedMetaData="name='ListOfExtensions' kind='elementOnly'"
 * @generated
 */
public interface ListOfExtensions extends EObject {
	/**
	 * Returns the value of the '<em><b>Extension</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2011._03.ua.UANodeSet.ExtensionType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' containment reference list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getListOfExtensions_Extension()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Extension' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ExtensionType> getExtension();

} // ListOfExtensions
