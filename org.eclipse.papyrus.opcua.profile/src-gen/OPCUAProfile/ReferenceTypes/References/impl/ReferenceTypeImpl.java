/**
 */
package OPCUAProfile.ReferenceTypes.References.impl;

import OPCUAProfile.DataTypes.LocalizedText;

import OPCUAProfile.ReferenceTypes.References.ReferenceType;
import OPCUAProfile.ReferenceTypes.References.ReferencesPackage;

import OPCUAProfile.impl.BaseNodeClassImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link OPCUAProfile.ReferenceTypes.References.impl.ReferenceTypeImpl#getIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link OPCUAProfile.ReferenceTypes.References.impl.ReferenceTypeImpl#getSymmetric <em>Symmetric</em>}</li>
 *   <li>{@link OPCUAProfile.ReferenceTypes.References.impl.ReferenceTypeImpl#getInverseName <em>Inverse Name</em>}</li>
 *   <li>{@link OPCUAProfile.ReferenceTypes.References.impl.ReferenceTypeImpl#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceTypeImpl extends BaseNodeClassImpl implements ReferenceType {
	/**
	 * The default value of the '{@link #getIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final Object IS_ABSTRACT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected Object isAbstract = IS_ABSTRACT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSymmetric() <em>Symmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymmetric()
	 * @generated
	 * @ordered
	 */
	protected static final Object SYMMETRIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSymmetric() <em>Symmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymmetric()
	 * @generated
	 * @ordered
	 */
	protected Object symmetric = SYMMETRIC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInverseName() <em>Inverse Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInverseName()
	 * @generated
	 * @ordered
	 */
	protected LocalizedText inverseName;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReferencesPackage.Literals.REFERENCE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getIsAbstract() {
		return isAbstract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAbstract(Object newIsAbstract) {
		Object oldIsAbstract = isAbstract;
		isAbstract = newIsAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReferencesPackage.REFERENCE_TYPE__IS_ABSTRACT, oldIsAbstract, isAbstract));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getSymmetric() {
		return symmetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSymmetric(Object newSymmetric) {
		Object oldSymmetric = symmetric;
		symmetric = newSymmetric;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReferencesPackage.REFERENCE_TYPE__SYMMETRIC, oldSymmetric, symmetric));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalizedText getInverseName() {
		if (inverseName != null && inverseName.eIsProxy()) {
			InternalEObject oldInverseName = (InternalEObject)inverseName;
			inverseName = (LocalizedText)eResolveProxy(oldInverseName);
			if (inverseName != oldInverseName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReferencesPackage.REFERENCE_TYPE__INVERSE_NAME, oldInverseName, inverseName));
			}
		}
		return inverseName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalizedText basicGetInverseName() {
		return inverseName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInverseName(LocalizedText newInverseName) {
		LocalizedText oldInverseName = inverseName;
		inverseName = newInverseName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReferencesPackage.REFERENCE_TYPE__INVERSE_NAME, oldInverseName, inverseName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReferencesPackage.REFERENCE_TYPE__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReferencesPackage.REFERENCE_TYPE__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ReferencesPackage.REFERENCE_TYPE__IS_ABSTRACT:
				return getIsAbstract();
			case ReferencesPackage.REFERENCE_TYPE__SYMMETRIC:
				return getSymmetric();
			case ReferencesPackage.REFERENCE_TYPE__INVERSE_NAME:
				if (resolve) return getInverseName();
				return basicGetInverseName();
			case ReferencesPackage.REFERENCE_TYPE__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
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
			case ReferencesPackage.REFERENCE_TYPE__IS_ABSTRACT:
				setIsAbstract((Object)newValue);
				return;
			case ReferencesPackage.REFERENCE_TYPE__SYMMETRIC:
				setSymmetric((Object)newValue);
				return;
			case ReferencesPackage.REFERENCE_TYPE__INVERSE_NAME:
				setInverseName((LocalizedText)newValue);
				return;
			case ReferencesPackage.REFERENCE_TYPE__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
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
			case ReferencesPackage.REFERENCE_TYPE__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case ReferencesPackage.REFERENCE_TYPE__SYMMETRIC:
				setSymmetric(SYMMETRIC_EDEFAULT);
				return;
			case ReferencesPackage.REFERENCE_TYPE__INVERSE_NAME:
				setInverseName((LocalizedText)null);
				return;
			case ReferencesPackage.REFERENCE_TYPE__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
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
			case ReferencesPackage.REFERENCE_TYPE__IS_ABSTRACT:
				return IS_ABSTRACT_EDEFAULT == null ? isAbstract != null : !IS_ABSTRACT_EDEFAULT.equals(isAbstract);
			case ReferencesPackage.REFERENCE_TYPE__SYMMETRIC:
				return SYMMETRIC_EDEFAULT == null ? symmetric != null : !SYMMETRIC_EDEFAULT.equals(symmetric);
			case ReferencesPackage.REFERENCE_TYPE__INVERSE_NAME:
				return inverseName != null;
			case ReferencesPackage.REFERENCE_TYPE__BASE_CLASS:
				return base_Class != null;
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
		result.append(" (IsAbstract: ");
		result.append(isAbstract);
		result.append(", Symmetric: ");
		result.append(symmetric);
		result.append(')');
		return result.toString();
	}

} //ReferenceTypeImpl
