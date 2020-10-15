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

import org.opcfoundation.ua._2008._02.types.CartesianCoordinates;
import org.opcfoundation.ua._2008._02.types.ListOfCartesianCoordinates;
import org.opcfoundation.ua._2008._02.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Of Cartesian Coordinates</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.ListOfCartesianCoordinatesImpl#getCartesianCoordinates <em>Cartesian Coordinates</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ListOfCartesianCoordinatesImpl extends MinimalEObjectImpl.Container implements ListOfCartesianCoordinates {
	/**
	 * The cached value of the '{@link #getCartesianCoordinates() <em>Cartesian Coordinates</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCartesianCoordinates()
	 * @generated
	 * @ordered
	 */
	protected EList<CartesianCoordinates> cartesianCoordinates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListOfCartesianCoordinatesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getListOfCartesianCoordinates();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CartesianCoordinates> getCartesianCoordinates() {
		if (cartesianCoordinates == null) {
			cartesianCoordinates = new EObjectContainmentEList<CartesianCoordinates>(CartesianCoordinates.class, this, TypesPackage.LIST_OF_CARTESIAN_COORDINATES__CARTESIAN_COORDINATES);
		}
		return cartesianCoordinates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.LIST_OF_CARTESIAN_COORDINATES__CARTESIAN_COORDINATES:
				return ((InternalEList<?>)getCartesianCoordinates()).basicRemove(otherEnd, msgs);
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
			case TypesPackage.LIST_OF_CARTESIAN_COORDINATES__CARTESIAN_COORDINATES:
				return getCartesianCoordinates();
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
			case TypesPackage.LIST_OF_CARTESIAN_COORDINATES__CARTESIAN_COORDINATES:
				getCartesianCoordinates().clear();
				getCartesianCoordinates().addAll((Collection<? extends CartesianCoordinates>)newValue);
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
			case TypesPackage.LIST_OF_CARTESIAN_COORDINATES__CARTESIAN_COORDINATES:
				getCartesianCoordinates().clear();
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
			case TypesPackage.LIST_OF_CARTESIAN_COORDINATES__CARTESIAN_COORDINATES:
				return cartesianCoordinates != null && !cartesianCoordinates.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ListOfCartesianCoordinatesImpl
