/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.NonHierachicalReferences;
import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.NonHierachicalReferencesPackage;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.impl.ReferencesImpl;

import org.eclipse.uml2.uml.Association;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Hierachical References</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.impl.NonHierachicalReferencesImpl#getBase_Association <em>Base Association</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NonHierachicalReferencesImpl extends ReferencesImpl implements NonHierachicalReferences {
	/**
	 * The cached value of the '{@link #getBase_Association() <em>Base Association</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Association()
	 * @generated
	 * @ordered
	 */
	protected Association base_Association;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NonHierachicalReferencesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NonHierachicalReferencesPackage.Literals.NON_HIERACHICAL_REFERENCES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Association getBase_Association() {
		if (base_Association != null && base_Association.eIsProxy()) {
			InternalEObject oldBase_Association = (InternalEObject)base_Association;
			base_Association = (Association)eResolveProxy(oldBase_Association);
			if (base_Association != oldBase_Association) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NonHierachicalReferencesPackage.NON_HIERACHICAL_REFERENCES__BASE_ASSOCIATION, oldBase_Association, base_Association));
			}
		}
		return base_Association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Association basicGetBase_Association() {
		return base_Association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_Association(Association newBase_Association) {
		Association oldBase_Association = base_Association;
		base_Association = newBase_Association;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NonHierachicalReferencesPackage.NON_HIERACHICAL_REFERENCES__BASE_ASSOCIATION, oldBase_Association, base_Association));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NonHierachicalReferencesPackage.NON_HIERACHICAL_REFERENCES__BASE_ASSOCIATION:
				if (resolve) return getBase_Association();
				return basicGetBase_Association();
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
			case NonHierachicalReferencesPackage.NON_HIERACHICAL_REFERENCES__BASE_ASSOCIATION:
				setBase_Association((Association)newValue);
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
			case NonHierachicalReferencesPackage.NON_HIERACHICAL_REFERENCES__BASE_ASSOCIATION:
				setBase_Association((Association)null);
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
			case NonHierachicalReferencesPackage.NON_HIERACHICAL_REFERENCES__BASE_ASSOCIATION:
				return base_Association != null;
		}
		return super.eIsSet(featureID);
	}

} //NonHierachicalReferencesImpl
