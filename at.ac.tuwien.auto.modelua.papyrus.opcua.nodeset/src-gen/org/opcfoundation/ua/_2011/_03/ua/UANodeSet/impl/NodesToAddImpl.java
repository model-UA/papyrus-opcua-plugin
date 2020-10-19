/**
 */
package org.opcfoundation.ua._2011._03.ua.UANodeSet.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.NodesToAdd;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UADataType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAMethod;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObject;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObjectType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAReferenceType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariableType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAView;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nodes To Add</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.NodesToAddImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.NodesToAddImpl#getUAObject <em>UA Object</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.NodesToAddImpl#getUAVariable <em>UA Variable</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.NodesToAddImpl#getUAMethod <em>UA Method</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.NodesToAddImpl#getUAView <em>UA View</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.NodesToAddImpl#getUAObjectType <em>UA Object Type</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.NodesToAddImpl#getUAVariableType <em>UA Variable Type</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.NodesToAddImpl#getUADataType <em>UA Data Type</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.NodesToAddImpl#getUAReferenceType <em>UA Reference Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodesToAddImpl extends MinimalEObjectImpl.Container implements NodesToAdd {
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodesToAddImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NodeSetPackage.Literals.NODES_TO_ADD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, NodeSetPackage.NODES_TO_ADD__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UAObject> getUAObject() {
		return getGroup().list(NodeSetPackage.Literals.NODES_TO_ADD__UA_OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UAVariable> getUAVariable() {
		return getGroup().list(NodeSetPackage.Literals.NODES_TO_ADD__UA_VARIABLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UAMethod> getUAMethod() {
		return getGroup().list(NodeSetPackage.Literals.NODES_TO_ADD__UA_METHOD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UAView> getUAView() {
		return getGroup().list(NodeSetPackage.Literals.NODES_TO_ADD__UA_VIEW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UAObjectType> getUAObjectType() {
		return getGroup().list(NodeSetPackage.Literals.NODES_TO_ADD__UA_OBJECT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UAVariableType> getUAVariableType() {
		return getGroup().list(NodeSetPackage.Literals.NODES_TO_ADD__UA_VARIABLE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UADataType> getUADataType() {
		return getGroup().list(NodeSetPackage.Literals.NODES_TO_ADD__UA_DATA_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UAReferenceType> getUAReferenceType() {
		return getGroup().list(NodeSetPackage.Literals.NODES_TO_ADD__UA_REFERENCE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NodeSetPackage.NODES_TO_ADD__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case NodeSetPackage.NODES_TO_ADD__UA_OBJECT:
				return ((InternalEList<?>)getUAObject()).basicRemove(otherEnd, msgs);
			case NodeSetPackage.NODES_TO_ADD__UA_VARIABLE:
				return ((InternalEList<?>)getUAVariable()).basicRemove(otherEnd, msgs);
			case NodeSetPackage.NODES_TO_ADD__UA_METHOD:
				return ((InternalEList<?>)getUAMethod()).basicRemove(otherEnd, msgs);
			case NodeSetPackage.NODES_TO_ADD__UA_VIEW:
				return ((InternalEList<?>)getUAView()).basicRemove(otherEnd, msgs);
			case NodeSetPackage.NODES_TO_ADD__UA_OBJECT_TYPE:
				return ((InternalEList<?>)getUAObjectType()).basicRemove(otherEnd, msgs);
			case NodeSetPackage.NODES_TO_ADD__UA_VARIABLE_TYPE:
				return ((InternalEList<?>)getUAVariableType()).basicRemove(otherEnd, msgs);
			case NodeSetPackage.NODES_TO_ADD__UA_DATA_TYPE:
				return ((InternalEList<?>)getUADataType()).basicRemove(otherEnd, msgs);
			case NodeSetPackage.NODES_TO_ADD__UA_REFERENCE_TYPE:
				return ((InternalEList<?>)getUAReferenceType()).basicRemove(otherEnd, msgs);
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
			case NodeSetPackage.NODES_TO_ADD__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case NodeSetPackage.NODES_TO_ADD__UA_OBJECT:
				return getUAObject();
			case NodeSetPackage.NODES_TO_ADD__UA_VARIABLE:
				return getUAVariable();
			case NodeSetPackage.NODES_TO_ADD__UA_METHOD:
				return getUAMethod();
			case NodeSetPackage.NODES_TO_ADD__UA_VIEW:
				return getUAView();
			case NodeSetPackage.NODES_TO_ADD__UA_OBJECT_TYPE:
				return getUAObjectType();
			case NodeSetPackage.NODES_TO_ADD__UA_VARIABLE_TYPE:
				return getUAVariableType();
			case NodeSetPackage.NODES_TO_ADD__UA_DATA_TYPE:
				return getUADataType();
			case NodeSetPackage.NODES_TO_ADD__UA_REFERENCE_TYPE:
				return getUAReferenceType();
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
			case NodeSetPackage.NODES_TO_ADD__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case NodeSetPackage.NODES_TO_ADD__UA_OBJECT:
				getUAObject().clear();
				getUAObject().addAll((Collection<? extends UAObject>)newValue);
				return;
			case NodeSetPackage.NODES_TO_ADD__UA_VARIABLE:
				getUAVariable().clear();
				getUAVariable().addAll((Collection<? extends UAVariable>)newValue);
				return;
			case NodeSetPackage.NODES_TO_ADD__UA_METHOD:
				getUAMethod().clear();
				getUAMethod().addAll((Collection<? extends UAMethod>)newValue);
				return;
			case NodeSetPackage.NODES_TO_ADD__UA_VIEW:
				getUAView().clear();
				getUAView().addAll((Collection<? extends UAView>)newValue);
				return;
			case NodeSetPackage.NODES_TO_ADD__UA_OBJECT_TYPE:
				getUAObjectType().clear();
				getUAObjectType().addAll((Collection<? extends UAObjectType>)newValue);
				return;
			case NodeSetPackage.NODES_TO_ADD__UA_VARIABLE_TYPE:
				getUAVariableType().clear();
				getUAVariableType().addAll((Collection<? extends UAVariableType>)newValue);
				return;
			case NodeSetPackage.NODES_TO_ADD__UA_DATA_TYPE:
				getUADataType().clear();
				getUADataType().addAll((Collection<? extends UADataType>)newValue);
				return;
			case NodeSetPackage.NODES_TO_ADD__UA_REFERENCE_TYPE:
				getUAReferenceType().clear();
				getUAReferenceType().addAll((Collection<? extends UAReferenceType>)newValue);
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
			case NodeSetPackage.NODES_TO_ADD__GROUP:
				getGroup().clear();
				return;
			case NodeSetPackage.NODES_TO_ADD__UA_OBJECT:
				getUAObject().clear();
				return;
			case NodeSetPackage.NODES_TO_ADD__UA_VARIABLE:
				getUAVariable().clear();
				return;
			case NodeSetPackage.NODES_TO_ADD__UA_METHOD:
				getUAMethod().clear();
				return;
			case NodeSetPackage.NODES_TO_ADD__UA_VIEW:
				getUAView().clear();
				return;
			case NodeSetPackage.NODES_TO_ADD__UA_OBJECT_TYPE:
				getUAObjectType().clear();
				return;
			case NodeSetPackage.NODES_TO_ADD__UA_VARIABLE_TYPE:
				getUAVariableType().clear();
				return;
			case NodeSetPackage.NODES_TO_ADD__UA_DATA_TYPE:
				getUADataType().clear();
				return;
			case NodeSetPackage.NODES_TO_ADD__UA_REFERENCE_TYPE:
				getUAReferenceType().clear();
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
			case NodeSetPackage.NODES_TO_ADD__GROUP:
				return group != null && !group.isEmpty();
			case NodeSetPackage.NODES_TO_ADD__UA_OBJECT:
				return !getUAObject().isEmpty();
			case NodeSetPackage.NODES_TO_ADD__UA_VARIABLE:
				return !getUAVariable().isEmpty();
			case NodeSetPackage.NODES_TO_ADD__UA_METHOD:
				return !getUAMethod().isEmpty();
			case NodeSetPackage.NODES_TO_ADD__UA_VIEW:
				return !getUAView().isEmpty();
			case NodeSetPackage.NODES_TO_ADD__UA_OBJECT_TYPE:
				return !getUAObjectType().isEmpty();
			case NodeSetPackage.NODES_TO_ADD__UA_VARIABLE_TYPE:
				return !getUAVariableType().isEmpty();
			case NodeSetPackage.NODES_TO_ADD__UA_DATA_TYPE:
				return !getUADataType().isEmpty();
			case NodeSetPackage.NODES_TO_ADD__UA_REFERENCE_TYPE:
				return !getUAReferenceType().isEmpty();
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
		result.append(" (group: ");
		result.append(group);
		result.append(')');
		return result.toString();
	}

} //NodesToAddImpl
