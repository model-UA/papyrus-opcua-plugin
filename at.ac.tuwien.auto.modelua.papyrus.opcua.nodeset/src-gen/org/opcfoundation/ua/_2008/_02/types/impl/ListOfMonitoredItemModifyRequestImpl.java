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

import org.opcfoundation.ua._2008._02.types.ListOfMonitoredItemModifyRequest;
import org.opcfoundation.ua._2008._02.types.MonitoredItemModifyRequest;
import org.opcfoundation.ua._2008._02.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Of Monitored Item Modify Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.ListOfMonitoredItemModifyRequestImpl#getMonitoredItemModifyRequest <em>Monitored Item Modify Request</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ListOfMonitoredItemModifyRequestImpl extends MinimalEObjectImpl.Container implements ListOfMonitoredItemModifyRequest {
	/**
	 * The cached value of the '{@link #getMonitoredItemModifyRequest() <em>Monitored Item Modify Request</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonitoredItemModifyRequest()
	 * @generated
	 * @ordered
	 */
	protected EList<MonitoredItemModifyRequest> monitoredItemModifyRequest;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListOfMonitoredItemModifyRequestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getListOfMonitoredItemModifyRequest();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MonitoredItemModifyRequest> getMonitoredItemModifyRequest() {
		if (monitoredItemModifyRequest == null) {
			monitoredItemModifyRequest = new EObjectContainmentEList<MonitoredItemModifyRequest>(MonitoredItemModifyRequest.class, this, TypesPackage.LIST_OF_MONITORED_ITEM_MODIFY_REQUEST__MONITORED_ITEM_MODIFY_REQUEST);
		}
		return monitoredItemModifyRequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.LIST_OF_MONITORED_ITEM_MODIFY_REQUEST__MONITORED_ITEM_MODIFY_REQUEST:
				return ((InternalEList<?>)getMonitoredItemModifyRequest()).basicRemove(otherEnd, msgs);
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
			case TypesPackage.LIST_OF_MONITORED_ITEM_MODIFY_REQUEST__MONITORED_ITEM_MODIFY_REQUEST:
				return getMonitoredItemModifyRequest();
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
			case TypesPackage.LIST_OF_MONITORED_ITEM_MODIFY_REQUEST__MONITORED_ITEM_MODIFY_REQUEST:
				getMonitoredItemModifyRequest().clear();
				getMonitoredItemModifyRequest().addAll((Collection<? extends MonitoredItemModifyRequest>)newValue);
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
			case TypesPackage.LIST_OF_MONITORED_ITEM_MODIFY_REQUEST__MONITORED_ITEM_MODIFY_REQUEST:
				getMonitoredItemModifyRequest().clear();
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
			case TypesPackage.LIST_OF_MONITORED_ITEM_MODIFY_REQUEST__MONITORED_ITEM_MODIFY_REQUEST:
				return monitoredItemModifyRequest != null && !monitoredItemModifyRequest.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ListOfMonitoredItemModifyRequestImpl
