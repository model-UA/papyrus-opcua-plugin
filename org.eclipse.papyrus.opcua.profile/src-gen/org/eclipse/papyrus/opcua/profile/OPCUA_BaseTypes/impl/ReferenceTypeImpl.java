/**
 */
package org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType;
import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.LocalizedText;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Stereotype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ReferenceTypeImpl#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ReferenceTypeImpl#isSymmetric <em>Symmetric</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ReferenceTypeImpl#getInverseName <em>Inverse Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ReferenceTypeImpl#getBase_Stereotype <em>Base Stereotype</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ReferenceTypeImpl#getBase_Association <em>Base Association</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceTypeImpl extends BaseNodeClassImpl implements ReferenceType {
	/**
	 * The default value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean isAbstract = IS_ABSTRACT_EDEFAULT;

	/**
	 * The default value of the '{@link #isSymmetric() <em>Symmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSymmetric()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SYMMETRIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSymmetric() <em>Symmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSymmetric()
	 * @generated
	 * @ordered
	 */
	protected boolean symmetric = SYMMETRIC_EDEFAULT;

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
	 * The cached value of the '{@link #getBase_Stereotype() <em>Base Stereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Stereotype()
	 * @generated
	 * @ordered
	 */
	protected Stereotype base_Stereotype;

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
		return basetypesPackage.Literals.REFERENCE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsAbstract() {
		return isAbstract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsAbstract(boolean newIsAbstract) {
		boolean oldIsAbstract = isAbstract;
		isAbstract = newIsAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.REFERENCE_TYPE__IS_ABSTRACT, oldIsAbstract, isAbstract));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSymmetric() {
		return symmetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSymmetric(boolean newSymmetric) {
		boolean oldSymmetric = symmetric;
		symmetric = newSymmetric;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.REFERENCE_TYPE__SYMMETRIC, oldSymmetric, symmetric));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LocalizedText getInverseName() {
		if (inverseName != null && inverseName.eIsProxy()) {
			InternalEObject oldInverseName = (InternalEObject)inverseName;
			inverseName = (LocalizedText)eResolveProxy(oldInverseName);
			if (inverseName != oldInverseName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, basetypesPackage.REFERENCE_TYPE__INVERSE_NAME, oldInverseName, inverseName));
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
	@Override
	public void setInverseName(LocalizedText newInverseName) {
		LocalizedText oldInverseName = inverseName;
		inverseName = newInverseName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.REFERENCE_TYPE__INVERSE_NAME, oldInverseName, inverseName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Stereotype getBase_Stereotype() {
		if (base_Stereotype != null && base_Stereotype.eIsProxy()) {
			InternalEObject oldBase_Stereotype = (InternalEObject)base_Stereotype;
			base_Stereotype = (Stereotype)eResolveProxy(oldBase_Stereotype);
			if (base_Stereotype != oldBase_Stereotype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, basetypesPackage.REFERENCE_TYPE__BASE_STEREOTYPE, oldBase_Stereotype, base_Stereotype));
			}
		}
		return base_Stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stereotype basicGetBase_Stereotype() {
		return base_Stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_Stereotype(Stereotype newBase_Stereotype) {
		Stereotype oldBase_Stereotype = base_Stereotype;
		base_Stereotype = newBase_Stereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.REFERENCE_TYPE__BASE_STEREOTYPE, oldBase_Stereotype, base_Stereotype));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, basetypesPackage.REFERENCE_TYPE__BASE_ASSOCIATION, oldBase_Association, base_Association));
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
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.REFERENCE_TYPE__BASE_ASSOCIATION, oldBase_Association, base_Association));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case basetypesPackage.REFERENCE_TYPE__IS_ABSTRACT:
				return isIsAbstract();
			case basetypesPackage.REFERENCE_TYPE__SYMMETRIC:
				return isSymmetric();
			case basetypesPackage.REFERENCE_TYPE__INVERSE_NAME:
				if (resolve) return getInverseName();
				return basicGetInverseName();
			case basetypesPackage.REFERENCE_TYPE__BASE_STEREOTYPE:
				if (resolve) return getBase_Stereotype();
				return basicGetBase_Stereotype();
			case basetypesPackage.REFERENCE_TYPE__BASE_ASSOCIATION:
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
			case basetypesPackage.REFERENCE_TYPE__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case basetypesPackage.REFERENCE_TYPE__SYMMETRIC:
				setSymmetric((Boolean)newValue);
				return;
			case basetypesPackage.REFERENCE_TYPE__INVERSE_NAME:
				setInverseName((LocalizedText)newValue);
				return;
			case basetypesPackage.REFERENCE_TYPE__BASE_STEREOTYPE:
				setBase_Stereotype((Stereotype)newValue);
				return;
			case basetypesPackage.REFERENCE_TYPE__BASE_ASSOCIATION:
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
			case basetypesPackage.REFERENCE_TYPE__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case basetypesPackage.REFERENCE_TYPE__SYMMETRIC:
				setSymmetric(SYMMETRIC_EDEFAULT);
				return;
			case basetypesPackage.REFERENCE_TYPE__INVERSE_NAME:
				setInverseName((LocalizedText)null);
				return;
			case basetypesPackage.REFERENCE_TYPE__BASE_STEREOTYPE:
				setBase_Stereotype((Stereotype)null);
				return;
			case basetypesPackage.REFERENCE_TYPE__BASE_ASSOCIATION:
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
			case basetypesPackage.REFERENCE_TYPE__IS_ABSTRACT:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case basetypesPackage.REFERENCE_TYPE__SYMMETRIC:
				return symmetric != SYMMETRIC_EDEFAULT;
			case basetypesPackage.REFERENCE_TYPE__INVERSE_NAME:
				return inverseName != null;
			case basetypesPackage.REFERENCE_TYPE__BASE_STEREOTYPE:
				return base_Stereotype != null;
			case basetypesPackage.REFERENCE_TYPE__BASE_ASSOCIATION:
				return base_Association != null;
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
