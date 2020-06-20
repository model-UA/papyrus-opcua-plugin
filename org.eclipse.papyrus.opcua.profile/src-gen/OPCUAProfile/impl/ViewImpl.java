/**
 */
package OPCUAProfile.impl;

import OPCUAProfile.OPCUAProfilePackage;
import OPCUAProfile.View;

import java.lang.Object;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link OPCUAProfile.impl.ViewImpl#getContainsNoLoops <em>Contains No Loops</em>}</li>
 *   <li>{@link OPCUAProfile.impl.ViewImpl#getEventNotifier <em>Event Notifier</em>}</li>
 *   <li>{@link OPCUAProfile.impl.ViewImpl#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ViewImpl extends BaseNodeClassImpl implements View {
	/**
	 * The default value of the '{@link #getContainsNoLoops() <em>Contains No Loops</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainsNoLoops()
	 * @generated
	 * @ordered
	 */
	protected static final Object CONTAINS_NO_LOOPS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContainsNoLoops() <em>Contains No Loops</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainsNoLoops()
	 * @generated
	 * @ordered
	 */
	protected Object containsNoLoops = CONTAINS_NO_LOOPS_EDEFAULT;

	/**
	 * The default value of the '{@link #getEventNotifier() <em>Event Notifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventNotifier()
	 * @generated
	 * @ordered
	 */
	protected static final Object EVENT_NOTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEventNotifier() <em>Event Notifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventNotifier()
	 * @generated
	 * @ordered
	 */
	protected Object eventNotifier = EVENT_NOTIFIER_EDEFAULT;

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
	protected ViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OPCUAProfilePackage.Literals.VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getContainsNoLoops() {
		return containsNoLoops;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainsNoLoops(Object newContainsNoLoops) {
		Object oldContainsNoLoops = containsNoLoops;
		containsNoLoops = newContainsNoLoops;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.VIEW__CONTAINS_NO_LOOPS, oldContainsNoLoops, containsNoLoops));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getEventNotifier() {
		return eventNotifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventNotifier(Object newEventNotifier) {
		Object oldEventNotifier = eventNotifier;
		eventNotifier = newEventNotifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.VIEW__EVENT_NOTIFIER, oldEventNotifier, eventNotifier));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPCUAProfilePackage.VIEW__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.VIEW__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OPCUAProfilePackage.VIEW__CONTAINS_NO_LOOPS:
				return getContainsNoLoops();
			case OPCUAProfilePackage.VIEW__EVENT_NOTIFIER:
				return getEventNotifier();
			case OPCUAProfilePackage.VIEW__BASE_CLASS:
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
			case OPCUAProfilePackage.VIEW__CONTAINS_NO_LOOPS:
				setContainsNoLoops((Object)newValue);
				return;
			case OPCUAProfilePackage.VIEW__EVENT_NOTIFIER:
				setEventNotifier((Object)newValue);
				return;
			case OPCUAProfilePackage.VIEW__BASE_CLASS:
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
			case OPCUAProfilePackage.VIEW__CONTAINS_NO_LOOPS:
				setContainsNoLoops(CONTAINS_NO_LOOPS_EDEFAULT);
				return;
			case OPCUAProfilePackage.VIEW__EVENT_NOTIFIER:
				setEventNotifier(EVENT_NOTIFIER_EDEFAULT);
				return;
			case OPCUAProfilePackage.VIEW__BASE_CLASS:
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
			case OPCUAProfilePackage.VIEW__CONTAINS_NO_LOOPS:
				return CONTAINS_NO_LOOPS_EDEFAULT == null ? containsNoLoops != null : !CONTAINS_NO_LOOPS_EDEFAULT.equals(containsNoLoops);
			case OPCUAProfilePackage.VIEW__EVENT_NOTIFIER:
				return EVENT_NOTIFIER_EDEFAULT == null ? eventNotifier != null : !EVENT_NOTIFIER_EDEFAULT.equals(eventNotifier);
			case OPCUAProfilePackage.VIEW__BASE_CLASS:
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
		result.append(" (ContainsNoLoops: ");
		result.append(containsNoLoops);
		result.append(", EventNotifier: ");
		result.append(eventNotifier);
		result.append(')');
		return result.toString();
	}

} //ViewImpl
