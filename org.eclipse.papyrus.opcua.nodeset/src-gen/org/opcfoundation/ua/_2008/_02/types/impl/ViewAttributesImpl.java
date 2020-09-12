/**
 */
package org.opcfoundation.ua._2008._02.types.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opcfoundation.ua._2008._02.types.TypesPackage;
import org.opcfoundation.ua._2008._02.types.ViewAttributes;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Attributes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.ViewAttributesImpl#isContainsNoLoops <em>Contains No Loops</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.ViewAttributesImpl#getEventNotifier <em>Event Notifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ViewAttributesImpl extends NodeAttributesImpl implements ViewAttributes {
	/**
	 * The default value of the '{@link #isContainsNoLoops() <em>Contains No Loops</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainsNoLoops()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTAINS_NO_LOOPS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContainsNoLoops() <em>Contains No Loops</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainsNoLoops()
	 * @generated
	 * @ordered
	 */
	protected boolean containsNoLoops = CONTAINS_NO_LOOPS_EDEFAULT;

	/**
	 * This is true if the Contains No Loops attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean containsNoLoopsESet;

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
	public ViewAttributesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getViewAttributes();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContainsNoLoops() {
		return containsNoLoops;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainsNoLoops(boolean newContainsNoLoops) {
		boolean oldContainsNoLoops = containsNoLoops;
		containsNoLoops = newContainsNoLoops;
		boolean oldContainsNoLoopsESet = containsNoLoopsESet;
		containsNoLoopsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.VIEW_ATTRIBUTES__CONTAINS_NO_LOOPS, oldContainsNoLoops, containsNoLoops, !oldContainsNoLoopsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetContainsNoLoops() {
		boolean oldContainsNoLoops = containsNoLoops;
		boolean oldContainsNoLoopsESet = containsNoLoopsESet;
		containsNoLoops = CONTAINS_NO_LOOPS_EDEFAULT;
		containsNoLoopsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, TypesPackage.VIEW_ATTRIBUTES__CONTAINS_NO_LOOPS, oldContainsNoLoops, CONTAINS_NO_LOOPS_EDEFAULT, oldContainsNoLoopsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetContainsNoLoops() {
		return containsNoLoopsESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.VIEW_ATTRIBUTES__EVENT_NOTIFIER, oldEventNotifier, eventNotifier, !oldEventNotifierESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, TypesPackage.VIEW_ATTRIBUTES__EVENT_NOTIFIER, oldEventNotifier, EVENT_NOTIFIER_EDEFAULT, oldEventNotifierESet));
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
			case TypesPackage.VIEW_ATTRIBUTES__CONTAINS_NO_LOOPS:
				return isContainsNoLoops();
			case TypesPackage.VIEW_ATTRIBUTES__EVENT_NOTIFIER:
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
			case TypesPackage.VIEW_ATTRIBUTES__CONTAINS_NO_LOOPS:
				setContainsNoLoops((Boolean)newValue);
				return;
			case TypesPackage.VIEW_ATTRIBUTES__EVENT_NOTIFIER:
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
			case TypesPackage.VIEW_ATTRIBUTES__CONTAINS_NO_LOOPS:
				unsetContainsNoLoops();
				return;
			case TypesPackage.VIEW_ATTRIBUTES__EVENT_NOTIFIER:
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
			case TypesPackage.VIEW_ATTRIBUTES__CONTAINS_NO_LOOPS:
				return isSetContainsNoLoops();
			case TypesPackage.VIEW_ATTRIBUTES__EVENT_NOTIFIER:
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
		result.append(" (containsNoLoops: ");
		if (containsNoLoopsESet) result.append(containsNoLoops); else result.append("<unset>");
		result.append(", eventNotifier: ");
		if (eventNotifierESet) result.append(eventNotifier); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ViewAttributesImpl
