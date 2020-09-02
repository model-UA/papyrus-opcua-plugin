/**
 */
package org.opcfoundation.ua._2008._02.types.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.opcfoundation.ua._2008._02.types.EphemeralKeyType;
import org.opcfoundation.ua._2008._02.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ephemeral Key Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.EphemeralKeyTypeImpl#getPublicKey <em>Public Key</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.EphemeralKeyTypeImpl#getSignature <em>Signature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EphemeralKeyTypeImpl extends MinimalEObjectImpl.Container implements EphemeralKeyType {
	/**
	 * The default value of the '{@link #getPublicKey() <em>Public Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicKey()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] PUBLIC_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublicKey() <em>Public Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublicKey()
	 * @generated
	 * @ordered
	 */
	protected byte[] publicKey = PUBLIC_KEY_EDEFAULT;

	/**
	 * This is true if the Public Key attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean publicKeyESet;

	/**
	 * The default value of the '{@link #getSignature() <em>Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] SIGNATURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSignature() <em>Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected byte[] signature = SIGNATURE_EDEFAULT;

	/**
	 * This is true if the Signature attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean signatureESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EphemeralKeyTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getEphemeralKeyType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getPublicKey() {
		return publicKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublicKey(byte[] newPublicKey) {
		byte[] oldPublicKey = publicKey;
		publicKey = newPublicKey;
		boolean oldPublicKeyESet = publicKeyESet;
		publicKeyESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.EPHEMERAL_KEY_TYPE__PUBLIC_KEY, oldPublicKey, publicKey, !oldPublicKeyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPublicKey() {
		byte[] oldPublicKey = publicKey;
		boolean oldPublicKeyESet = publicKeyESet;
		publicKey = PUBLIC_KEY_EDEFAULT;
		publicKeyESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, TypesPackage.EPHEMERAL_KEY_TYPE__PUBLIC_KEY, oldPublicKey, PUBLIC_KEY_EDEFAULT, oldPublicKeyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPublicKey() {
		return publicKeyESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getSignature() {
		return signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignature(byte[] newSignature) {
		byte[] oldSignature = signature;
		signature = newSignature;
		boolean oldSignatureESet = signatureESet;
		signatureESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.EPHEMERAL_KEY_TYPE__SIGNATURE, oldSignature, signature, !oldSignatureESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSignature() {
		byte[] oldSignature = signature;
		boolean oldSignatureESet = signatureESet;
		signature = SIGNATURE_EDEFAULT;
		signatureESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, TypesPackage.EPHEMERAL_KEY_TYPE__SIGNATURE, oldSignature, SIGNATURE_EDEFAULT, oldSignatureESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSignature() {
		return signatureESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesPackage.EPHEMERAL_KEY_TYPE__PUBLIC_KEY:
				return getPublicKey();
			case TypesPackage.EPHEMERAL_KEY_TYPE__SIGNATURE:
				return getSignature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TypesPackage.EPHEMERAL_KEY_TYPE__PUBLIC_KEY:
				setPublicKey((byte[])newValue);
				return;
			case TypesPackage.EPHEMERAL_KEY_TYPE__SIGNATURE:
				setSignature((byte[])newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TypesPackage.EPHEMERAL_KEY_TYPE__PUBLIC_KEY:
				unsetPublicKey();
				return;
			case TypesPackage.EPHEMERAL_KEY_TYPE__SIGNATURE:
				unsetSignature();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TypesPackage.EPHEMERAL_KEY_TYPE__PUBLIC_KEY:
				return isSetPublicKey();
			case TypesPackage.EPHEMERAL_KEY_TYPE__SIGNATURE:
				return isSetSignature();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (publicKey: ");
		if (publicKeyESet) result.append(publicKey); else result.append("<unset>");
		result.append(", signature: ");
		if (signatureESet) result.append(signature); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //EphemeralKeyTypeImpl
