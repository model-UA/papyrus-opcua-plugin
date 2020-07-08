/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.BaseVariableType;
import org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.VariableTypesPackage;

import org.eclipse.uml2.uml.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Variable Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.impl.BaseVariableTypeImpl#getBase_Variable <em>Base Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BaseVariableTypeImpl extends MinimalEObjectImpl.Container implements BaseVariableType {
	/**
	 * The cached value of the '{@link #getBase_Variable() <em>Base Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Variable()
	 * @generated
	 * @ordered
	 */
	protected Variable base_Variable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseVariableTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VariableTypesPackage.Literals.BASE_VARIABLE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Variable getBase_Variable() {
		if (base_Variable != null && base_Variable.eIsProxy()) {
			InternalEObject oldBase_Variable = (InternalEObject)base_Variable;
			base_Variable = (Variable)eResolveProxy(oldBase_Variable);
			if (base_Variable != oldBase_Variable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariableTypesPackage.BASE_VARIABLE_TYPE__BASE_VARIABLE, oldBase_Variable, base_Variable));
			}
		}
		return base_Variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetBase_Variable() {
		return base_Variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_Variable(Variable newBase_Variable) {
		Variable oldBase_Variable = base_Variable;
		base_Variable = newBase_Variable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariableTypesPackage.BASE_VARIABLE_TYPE__BASE_VARIABLE, oldBase_Variable, base_Variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VariableTypesPackage.BASE_VARIABLE_TYPE__BASE_VARIABLE:
				if (resolve) return getBase_Variable();
				return basicGetBase_Variable();
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
			case VariableTypesPackage.BASE_VARIABLE_TYPE__BASE_VARIABLE:
				setBase_Variable((Variable)newValue);
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
			case VariableTypesPackage.BASE_VARIABLE_TYPE__BASE_VARIABLE:
				setBase_Variable((Variable)null);
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
			case VariableTypesPackage.BASE_VARIABLE_TYPE__BASE_VARIABLE:
				return base_Variable != null;
		}
		return super.eIsSet(featureID);
	}

} //BaseVariableTypeImpl
