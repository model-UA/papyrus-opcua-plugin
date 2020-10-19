/**
 */
package org.opcfoundation.ua._2008._02.types.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opcfoundation.ua._2008._02.types.KeyValuePair;
import org.opcfoundation.ua._2008._02.types.ListOfKeyValuePair;
import org.opcfoundation.ua._2008._02.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Of Key Value Pair</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.ListOfKeyValuePairImpl#getKeyValuePair <em>Key Value Pair</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ListOfKeyValuePairImpl extends MinimalEObjectImpl.Container implements ListOfKeyValuePair {
	/**
	 * The cached value of the '{@link #getKeyValuePair() <em>Key Value Pair</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyValuePair()
	 * @generated
	 * @ordered
	 */
	protected EList<KeyValuePair> keyValuePair;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListOfKeyValuePairImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getListOfKeyValuePair();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KeyValuePair> getKeyValuePair() {
		if (keyValuePair == null) {
			keyValuePair = new EObjectContainmentEList<KeyValuePair>(KeyValuePair.class, this, TypesPackage.LIST_OF_KEY_VALUE_PAIR__KEY_VALUE_PAIR);
		}
		return keyValuePair;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.LIST_OF_KEY_VALUE_PAIR__KEY_VALUE_PAIR:
				return ((InternalEList<?>)getKeyValuePair()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesPackage.LIST_OF_KEY_VALUE_PAIR__KEY_VALUE_PAIR:
				return getKeyValuePair();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TypesPackage.LIST_OF_KEY_VALUE_PAIR__KEY_VALUE_PAIR:
				getKeyValuePair().clear();
				getKeyValuePair().addAll((Collection<? extends KeyValuePair>)newValue);
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
			case TypesPackage.LIST_OF_KEY_VALUE_PAIR__KEY_VALUE_PAIR:
				getKeyValuePair().clear();
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
			case TypesPackage.LIST_OF_KEY_VALUE_PAIR__KEY_VALUE_PAIR:
				return keyValuePair != null && !keyValuePair.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ListOfKeyValuePairImpl
