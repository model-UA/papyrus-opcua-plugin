/**
 */
package org.opcfoundation.ua._2008._02.types.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.opcfoundation.ua._2008._02.types.ListOfUadpDataSetMessageContentMask;
import org.opcfoundation.ua._2008._02.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Of Uadp Data Set Message Content Mask</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.ListOfUadpDataSetMessageContentMaskImpl#getUadpDataSetMessageContentMask <em>Uadp Data Set Message Content Mask</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ListOfUadpDataSetMessageContentMaskImpl extends MinimalEObjectImpl.Container implements ListOfUadpDataSetMessageContentMask {
	/**
	 * The cached value of the '{@link #getUadpDataSetMessageContentMask() <em>Uadp Data Set Message Content Mask</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUadpDataSetMessageContentMask()
	 * @generated
	 * @ordered
	 */
	protected EList<Long> uadpDataSetMessageContentMask;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListOfUadpDataSetMessageContentMaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getListOfUadpDataSetMessageContentMask();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Long> getUadpDataSetMessageContentMask() {
		if (uadpDataSetMessageContentMask == null) {
			uadpDataSetMessageContentMask = new EDataTypeEList<Long>(Long.class, this, TypesPackage.LIST_OF_UADP_DATA_SET_MESSAGE_CONTENT_MASK__UADP_DATA_SET_MESSAGE_CONTENT_MASK);
		}
		return uadpDataSetMessageContentMask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesPackage.LIST_OF_UADP_DATA_SET_MESSAGE_CONTENT_MASK__UADP_DATA_SET_MESSAGE_CONTENT_MASK:
				return getUadpDataSetMessageContentMask();
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
			case TypesPackage.LIST_OF_UADP_DATA_SET_MESSAGE_CONTENT_MASK__UADP_DATA_SET_MESSAGE_CONTENT_MASK:
				getUadpDataSetMessageContentMask().clear();
				getUadpDataSetMessageContentMask().addAll((Collection<? extends Long>)newValue);
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
			case TypesPackage.LIST_OF_UADP_DATA_SET_MESSAGE_CONTENT_MASK__UADP_DATA_SET_MESSAGE_CONTENT_MASK:
				getUadpDataSetMessageContentMask().clear();
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
			case TypesPackage.LIST_OF_UADP_DATA_SET_MESSAGE_CONTENT_MASK__UADP_DATA_SET_MESSAGE_CONTENT_MASK:
				return uadpDataSetMessageContentMask != null && !uadpDataSetMessageContentMask.isEmpty();
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
		result.append(" (uadpDataSetMessageContentMask: ");
		result.append(uadpDataSetMessageContentMask);
		result.append(')');
		return result.toString();
	}

} //ListOfUadpDataSetMessageContentMaskImpl
