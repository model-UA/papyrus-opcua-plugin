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

import org.opcfoundation.ua._2008._02.types.ListOfStatusResult;
import org.opcfoundation.ua._2008._02.types.StatusResult;
import org.opcfoundation.ua._2008._02.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Of Status Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.ListOfStatusResultImpl#getStatusResult <em>Status Result</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ListOfStatusResultImpl extends MinimalEObjectImpl.Container implements ListOfStatusResult {
	/**
	 * The cached value of the '{@link #getStatusResult() <em>Status Result</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusResult()
	 * @generated
	 * @ordered
	 */
	protected EList<StatusResult> statusResult;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListOfStatusResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getListOfStatusResult();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StatusResult> getStatusResult() {
		if (statusResult == null) {
			statusResult = new EObjectContainmentEList<StatusResult>(StatusResult.class, this, TypesPackage.LIST_OF_STATUS_RESULT__STATUS_RESULT);
		}
		return statusResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.LIST_OF_STATUS_RESULT__STATUS_RESULT:
				return ((InternalEList<?>)getStatusResult()).basicRemove(otherEnd, msgs);
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
			case TypesPackage.LIST_OF_STATUS_RESULT__STATUS_RESULT:
				return getStatusResult();
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
			case TypesPackage.LIST_OF_STATUS_RESULT__STATUS_RESULT:
				getStatusResult().clear();
				getStatusResult().addAll((Collection<? extends StatusResult>)newValue);
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
			case TypesPackage.LIST_OF_STATUS_RESULT__STATUS_RESULT:
				getStatusResult().clear();
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
			case TypesPackage.LIST_OF_STATUS_RESULT__STATUS_RESULT:
				return statusResult != null && !statusResult.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ListOfStatusResultImpl
