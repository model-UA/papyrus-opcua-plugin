/**
 */
package org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage;

import org.eclipse.uml2.uml.Stereotype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ObjectImpl#getEventNotifier <em>Event Notifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ObjectImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.ObjectImpl#getBase_Stereotype <em>Base Stereotype</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectImpl extends BaseNodeClassImpl implements org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Object {
	/**
	 * The default value of the '{@link #getEventNotifier() <em>Event Notifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventNotifier()
	 * @generated
	 * @ordered
	 */
	protected static final byte EVENT_NOTIFIER_EDEFAULT = 0x00;

	/**
	 * The cached value of the '{@link #getEventNotifier() <em>Event Notifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventNotifier()
	 * @generated
	 * @ordered
	 */
	protected byte eventNotifier = EVENT_NOTIFIER_EDEFAULT;

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
	 * The cached value of the '{@link #getBase_Stereotype() <em>Base Stereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Stereotype()
	 * @generated
	 * @ordered
	 */
	protected Stereotype base_Stereotype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return basetypesPackage.Literals.OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public byte getEventNotifier() {
		return eventNotifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEventNotifier(byte newEventNotifier) {
		byte oldEventNotifier = eventNotifier;
		eventNotifier = newEventNotifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.OBJECT__EVENT_NOTIFIER, oldEventNotifier, eventNotifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, basetypesPackage.OBJECT__BASE_CLASS, oldBase_Class, base_Class));
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
	@Override
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.OBJECT__BASE_CLASS, oldBase_Class, base_Class));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, basetypesPackage.OBJECT__BASE_STEREOTYPE, oldBase_Stereotype, base_Stereotype));
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
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.OBJECT__BASE_STEREOTYPE, oldBase_Stereotype, base_Stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case basetypesPackage.OBJECT__EVENT_NOTIFIER:
				return getEventNotifier();
			case basetypesPackage.OBJECT__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case basetypesPackage.OBJECT__BASE_STEREOTYPE:
				if (resolve) return getBase_Stereotype();
				return basicGetBase_Stereotype();
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
			case basetypesPackage.OBJECT__EVENT_NOTIFIER:
				setEventNotifier((Byte)newValue);
				return;
			case basetypesPackage.OBJECT__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case basetypesPackage.OBJECT__BASE_STEREOTYPE:
				setBase_Stereotype((Stereotype)newValue);
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
			case basetypesPackage.OBJECT__EVENT_NOTIFIER:
				setEventNotifier(EVENT_NOTIFIER_EDEFAULT);
				return;
			case basetypesPackage.OBJECT__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case basetypesPackage.OBJECT__BASE_STEREOTYPE:
				setBase_Stereotype((Stereotype)null);
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
			case basetypesPackage.OBJECT__EVENT_NOTIFIER:
				return eventNotifier != EVENT_NOTIFIER_EDEFAULT;
			case basetypesPackage.OBJECT__BASE_CLASS:
				return base_Class != null;
			case basetypesPackage.OBJECT__BASE_STEREOTYPE:
				return base_Stereotype != null;
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
		result.append(" (EventNotifier: ");
		result.append(eventNotifier);
		result.append(')');
		return result.toString();
	}

} //ObjectImpl