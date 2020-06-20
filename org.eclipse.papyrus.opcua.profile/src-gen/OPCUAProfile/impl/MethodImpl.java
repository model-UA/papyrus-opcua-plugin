/**
 */
package OPCUAProfile.impl;

import OPCUAProfile.Method;
import OPCUAProfile.OPCUAProfilePackage;

import java.lang.Object;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link OPCUAProfile.impl.MethodImpl#getExecutable <em>Executable</em>}</li>
 *   <li>{@link OPCUAProfile.impl.MethodImpl#getUserExecutable <em>User Executable</em>}</li>
 *   <li>{@link OPCUAProfile.impl.MethodImpl#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodImpl extends BaseNodeClassImpl implements Method {
	/**
	 * The default value of the '{@link #getExecutable() <em>Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutable()
	 * @generated
	 * @ordered
	 */
	protected static final Object EXECUTABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExecutable() <em>Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutable()
	 * @generated
	 * @ordered
	 */
	protected Object executable = EXECUTABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUserExecutable() <em>User Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserExecutable()
	 * @generated
	 * @ordered
	 */
	protected static final Object USER_EXECUTABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserExecutable() <em>User Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserExecutable()
	 * @generated
	 * @ordered
	 */
	protected Object userExecutable = USER_EXECUTABLE_EDEFAULT;

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
	protected MethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OPCUAProfilePackage.Literals.METHOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getExecutable() {
		return executable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutable(Object newExecutable) {
		Object oldExecutable = executable;
		executable = newExecutable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.METHOD__EXECUTABLE, oldExecutable, executable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getUserExecutable() {
		return userExecutable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserExecutable(Object newUserExecutable) {
		Object oldUserExecutable = userExecutable;
		userExecutable = newUserExecutable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.METHOD__USER_EXECUTABLE, oldUserExecutable, userExecutable));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPCUAProfilePackage.METHOD__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.METHOD__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OPCUAProfilePackage.METHOD__EXECUTABLE:
				return getExecutable();
			case OPCUAProfilePackage.METHOD__USER_EXECUTABLE:
				return getUserExecutable();
			case OPCUAProfilePackage.METHOD__BASE_CLASS:
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
			case OPCUAProfilePackage.METHOD__EXECUTABLE:
				setExecutable((Object)newValue);
				return;
			case OPCUAProfilePackage.METHOD__USER_EXECUTABLE:
				setUserExecutable((Object)newValue);
				return;
			case OPCUAProfilePackage.METHOD__BASE_CLASS:
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
			case OPCUAProfilePackage.METHOD__EXECUTABLE:
				setExecutable(EXECUTABLE_EDEFAULT);
				return;
			case OPCUAProfilePackage.METHOD__USER_EXECUTABLE:
				setUserExecutable(USER_EXECUTABLE_EDEFAULT);
				return;
			case OPCUAProfilePackage.METHOD__BASE_CLASS:
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
			case OPCUAProfilePackage.METHOD__EXECUTABLE:
				return EXECUTABLE_EDEFAULT == null ? executable != null : !EXECUTABLE_EDEFAULT.equals(executable);
			case OPCUAProfilePackage.METHOD__USER_EXECUTABLE:
				return USER_EXECUTABLE_EDEFAULT == null ? userExecutable != null : !USER_EXECUTABLE_EDEFAULT.equals(userExecutable);
			case OPCUAProfilePackage.METHOD__BASE_CLASS:
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
		result.append(" (Executable: ");
		result.append(executable);
		result.append(", UserExecutable: ");
		result.append(userExecutable);
		result.append(')');
		return result.toString();
	}

} //MethodImpl
