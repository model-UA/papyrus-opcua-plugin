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

import org.opcfoundation.ua._2008._02.types.ListOfPublishedVariableDataType;
import org.opcfoundation.ua._2008._02.types.PublishedVariableDataType;
import org.opcfoundation.ua._2008._02.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Of Published Variable Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.ListOfPublishedVariableDataTypeImpl#getPublishedVariableDataType <em>Published Variable Data Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ListOfPublishedVariableDataTypeImpl extends MinimalEObjectImpl.Container implements ListOfPublishedVariableDataType {
	/**
	 * The cached value of the '{@link #getPublishedVariableDataType() <em>Published Variable Data Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublishedVariableDataType()
	 * @generated
	 * @ordered
	 */
	protected EList<PublishedVariableDataType> publishedVariableDataType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListOfPublishedVariableDataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getListOfPublishedVariableDataType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PublishedVariableDataType> getPublishedVariableDataType() {
		if (publishedVariableDataType == null) {
			publishedVariableDataType = new EObjectContainmentEList<PublishedVariableDataType>(PublishedVariableDataType.class, this, TypesPackage.LIST_OF_PUBLISHED_VARIABLE_DATA_TYPE__PUBLISHED_VARIABLE_DATA_TYPE);
		}
		return publishedVariableDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.LIST_OF_PUBLISHED_VARIABLE_DATA_TYPE__PUBLISHED_VARIABLE_DATA_TYPE:
				return ((InternalEList<?>)getPublishedVariableDataType()).basicRemove(otherEnd, msgs);
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
			case TypesPackage.LIST_OF_PUBLISHED_VARIABLE_DATA_TYPE__PUBLISHED_VARIABLE_DATA_TYPE:
				return getPublishedVariableDataType();
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
			case TypesPackage.LIST_OF_PUBLISHED_VARIABLE_DATA_TYPE__PUBLISHED_VARIABLE_DATA_TYPE:
				getPublishedVariableDataType().clear();
				getPublishedVariableDataType().addAll((Collection<? extends PublishedVariableDataType>)newValue);
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
			case TypesPackage.LIST_OF_PUBLISHED_VARIABLE_DATA_TYPE__PUBLISHED_VARIABLE_DATA_TYPE:
				getPublishedVariableDataType().clear();
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
			case TypesPackage.LIST_OF_PUBLISHED_VARIABLE_DATA_TYPE__PUBLISHED_VARIABLE_DATA_TYPE:
				return publishedVariableDataType != null && !publishedVariableDataType.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ListOfPublishedVariableDataTypeImpl
