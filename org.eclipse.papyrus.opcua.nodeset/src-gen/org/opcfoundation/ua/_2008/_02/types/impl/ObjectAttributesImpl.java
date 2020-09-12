/**
 */
package org.opcfoundation.ua._2008._02.types.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opcfoundation.ua._2008._02.types.ObjectAttributes;
import org.opcfoundation.ua._2008._02.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Attributes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.ObjectAttributesImpl#getEventNotifier <em>Event Notifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectAttributesImpl extends NodeAttributesImpl implements ObjectAttributes {
	/**
	 * The default value of the '{@link #getEventNotifier() <em>Event Notifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventNotifier()
	 * @generated
	 * @ordered
	 */
	protected static final short EVENT_NOTIFIER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEventNotifier() <em>Event Notifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventNotifier()
	 * @generated
	 * @ordered
	 */
	protected short eventNotifier = EVENT_NOTIFIER_EDEFAULT;

	/**
	 * This is true if the Event Notifier attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean eventNotifierESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectAttributesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getObjectAttributes();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public short getEventNotifier() {
		return eventNotifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventNotifier(short newEventNotifier) {
		short oldEventNotifier = eventNotifier;
		eventNotifier = newEventNotifier;
		boolean oldEventNotifierESet = eventNotifierESet;
		eventNotifierESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.OBJECT_ATTRIBUTES__EVENT_NOTIFIER, oldEventNotifier, eventNotifier, !oldEventNotifierESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEventNotifier() {
		short oldEventNotifier = eventNotifier;
		boolean oldEventNotifierESet = eventNotifierESet;
		eventNotifier = EVENT_NOTIFIER_EDEFAULT;
		eventNotifierESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, TypesPackage.OBJECT_ATTRIBUTES__EVENT_NOTIFIER, oldEventNotifier, EVENT_NOTIFIER_EDEFAULT, oldEventNotifierESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEventNotifier() {
		return eventNotifierESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesPackage.OBJECT_ATTRIBUTES__EVENT_NOTIFIER:
				return getEventNotifier();
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
			case TypesPackage.OBJECT_ATTRIBUTES__EVENT_NOTIFIER:
				setEventNotifier((Short)newValue);
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
			case TypesPackage.OBJECT_ATTRIBUTES__EVENT_NOTIFIER:
				unsetEventNotifier();
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
			case TypesPackage.OBJECT_ATTRIBUTES__EVENT_NOTIFIER:
				return isSetEventNotifier();
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
		result.append(" (eventNotifier: ");
		if (eventNotifierESet) result.append(eventNotifier); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ObjectAttributesImpl
