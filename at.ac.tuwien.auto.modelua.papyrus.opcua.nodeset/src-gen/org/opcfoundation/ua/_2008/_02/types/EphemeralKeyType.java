/**
 */
package org.opcfoundation.ua._2008._02.types;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ephemeral Key Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.EphemeralKeyType#getPublicKey <em>Public Key</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.EphemeralKeyType#getSignature <em>Signature</em>}</li>
 * </ul>
 *
 * @see org.opcfoundation.ua._2008._02.types.TypesPackage#getEphemeralKeyType()
 * @model extendedMetaData="name='EphemeralKeyType' kind='elementOnly'"
 * @generated
 */
public interface EphemeralKeyType extends EObject {
	/**
	 * Returns the value of the '<em><b>Public Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Public Key</em>' attribute.
	 * @see #isSetPublicKey()
	 * @see #unsetPublicKey()
	 * @see #setPublicKey(byte[])
	 * @see org.opcfoundation.ua._2008._02.types.TypesPackage#getEphemeralKeyType_PublicKey()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Base64Binary"
	 *        extendedMetaData="kind='element' name='PublicKey' namespace='##targetNamespace'"
	 * @generated
	 */
	byte[] getPublicKey();

	/**
	 * Sets the value of the '{@link org.opcfoundation.ua._2008._02.types.EphemeralKeyType#getPublicKey <em>Public Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Public Key</em>' attribute.
	 * @see #isSetPublicKey()
	 * @see #unsetPublicKey()
	 * @see #getPublicKey()
	 * @generated
	 */
	void setPublicKey(byte[] value);

	/**
	 * Unsets the value of the '{@link org.opcfoundation.ua._2008._02.types.EphemeralKeyType#getPublicKey <em>Public Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPublicKey()
	 * @see #getPublicKey()
	 * @see #setPublicKey(byte[])
	 * @generated
	 */
	void unsetPublicKey();

	/**
	 * Returns whether the value of the '{@link org.opcfoundation.ua._2008._02.types.EphemeralKeyType#getPublicKey <em>Public Key</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Public Key</em>' attribute is set.
	 * @see #unsetPublicKey()
	 * @see #getPublicKey()
	 * @see #setPublicKey(byte[])
	 * @generated
	 */
	boolean isSetPublicKey();

	/**
	 * Returns the value of the '<em><b>Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature</em>' attribute.
	 * @see #isSetSignature()
	 * @see #unsetSignature()
	 * @see #setSignature(byte[])
	 * @see org.opcfoundation.ua._2008._02.types.TypesPackage#getEphemeralKeyType_Signature()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Base64Binary"
	 *        extendedMetaData="kind='element' name='Signature' namespace='##targetNamespace'"
	 * @generated
	 */
	byte[] getSignature();

	/**
	 * Sets the value of the '{@link org.opcfoundation.ua._2008._02.types.EphemeralKeyType#getSignature <em>Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature</em>' attribute.
	 * @see #isSetSignature()
	 * @see #unsetSignature()
	 * @see #getSignature()
	 * @generated
	 */
	void setSignature(byte[] value);

	/**
	 * Unsets the value of the '{@link org.opcfoundation.ua._2008._02.types.EphemeralKeyType#getSignature <em>Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSignature()
	 * @see #getSignature()
	 * @see #setSignature(byte[])
	 * @generated
	 */
	void unsetSignature();

	/**
	 * Returns whether the value of the '{@link org.opcfoundation.ua._2008._02.types.EphemeralKeyType#getSignature <em>Signature</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Signature</em>' attribute is set.
	 * @see #unsetSignature()
	 * @see #getSignature()
	 * @see #setSignature(byte[])
	 * @generated
	 */
	boolean isSetSignature();

} // EphemeralKeyType
