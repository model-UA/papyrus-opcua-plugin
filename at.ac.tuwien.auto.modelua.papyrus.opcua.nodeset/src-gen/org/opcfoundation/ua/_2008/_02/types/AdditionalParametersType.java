/**
 */
package org.opcfoundation.ua._2008._02.types;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Additional Parameters Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.AdditionalParametersType#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see org.opcfoundation.ua._2008._02.types.TypesPackage#getAdditionalParametersType()
 * @model extendedMetaData="name='AdditionalParametersType' kind='elementOnly'"
 * @generated
 */
public interface AdditionalParametersType extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference.
	 * @see #isSetParameters()
	 * @see #unsetParameters()
	 * @see #setParameters(ListOfKeyValuePair)
	 * @see org.opcfoundation.ua._2008._02.types.TypesPackage#getAdditionalParametersType_Parameters()
	 * @model containment="true" unsettable="true"
	 *        extendedMetaData="kind='element' name='Parameters' namespace='##targetNamespace'"
	 * @generated
	 */
	ListOfKeyValuePair getParameters();

	/**
	 * Sets the value of the '{@link org.opcfoundation.ua._2008._02.types.AdditionalParametersType#getParameters <em>Parameters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameters</em>' containment reference.
	 * @see #isSetParameters()
	 * @see #unsetParameters()
	 * @see #getParameters()
	 * @generated
	 */
	void setParameters(ListOfKeyValuePair value);

	/**
	 * Unsets the value of the '{@link org.opcfoundation.ua._2008._02.types.AdditionalParametersType#getParameters <em>Parameters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetParameters()
	 * @see #getParameters()
	 * @see #setParameters(ListOfKeyValuePair)
	 * @generated
	 */
	void unsetParameters();

	/**
	 * Returns whether the value of the '{@link org.opcfoundation.ua._2008._02.types.AdditionalParametersType#getParameters <em>Parameters</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Parameters</em>' containment reference is set.
	 * @see #unsetParameters()
	 * @see #getParameters()
	 * @see #setParameters(ListOfKeyValuePair)
	 * @generated
	 */
	boolean isSetParameters();

} // AdditionalParametersType
