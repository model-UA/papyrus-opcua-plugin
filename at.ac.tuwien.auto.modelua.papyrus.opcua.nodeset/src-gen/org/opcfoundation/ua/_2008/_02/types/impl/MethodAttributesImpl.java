/**
 */
package org.opcfoundation.ua._2008._02.types.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.opcfoundation.ua._2008._02.types.MethodAttributes;
import org.opcfoundation.ua._2008._02.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Attributes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.MethodAttributesImpl#isExecutable <em>Executable</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.MethodAttributesImpl#isUserExecutable <em>User Executable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodAttributesImpl extends NodeAttributesImpl implements MethodAttributes {
	/**
	 * The default value of the '{@link #isExecutable() <em>Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExecutable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXECUTABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExecutable() <em>Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExecutable()
	 * @generated
	 * @ordered
	 */
	protected boolean executable = EXECUTABLE_EDEFAULT;

	/**
	 * This is true if the Executable attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean executableESet;

	/**
	 * The default value of the '{@link #isUserExecutable() <em>User Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUserExecutable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USER_EXECUTABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUserExecutable() <em>User Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUserExecutable()
	 * @generated
	 * @ordered
	 */
	protected boolean userExecutable = USER_EXECUTABLE_EDEFAULT;

	/**
	 * This is true if the User Executable attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean userExecutableESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodAttributesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getMethodAttributes();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExecutable() {
		return executable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutable(boolean newExecutable) {
		boolean oldExecutable = executable;
		executable = newExecutable;
		boolean oldExecutableESet = executableESet;
		executableESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.METHOD_ATTRIBUTES__EXECUTABLE, oldExecutable, executable, !oldExecutableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetExecutable() {
		boolean oldExecutable = executable;
		boolean oldExecutableESet = executableESet;
		executable = EXECUTABLE_EDEFAULT;
		executableESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, TypesPackage.METHOD_ATTRIBUTES__EXECUTABLE, oldExecutable, EXECUTABLE_EDEFAULT, oldExecutableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetExecutable() {
		return executableESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUserExecutable() {
		return userExecutable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserExecutable(boolean newUserExecutable) {
		boolean oldUserExecutable = userExecutable;
		userExecutable = newUserExecutable;
		boolean oldUserExecutableESet = userExecutableESet;
		userExecutableESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.METHOD_ATTRIBUTES__USER_EXECUTABLE, oldUserExecutable, userExecutable, !oldUserExecutableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserExecutable() {
		boolean oldUserExecutable = userExecutable;
		boolean oldUserExecutableESet = userExecutableESet;
		userExecutable = USER_EXECUTABLE_EDEFAULT;
		userExecutableESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, TypesPackage.METHOD_ATTRIBUTES__USER_EXECUTABLE, oldUserExecutable, USER_EXECUTABLE_EDEFAULT, oldUserExecutableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserExecutable() {
		return userExecutableESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesPackage.METHOD_ATTRIBUTES__EXECUTABLE:
				return isExecutable();
			case TypesPackage.METHOD_ATTRIBUTES__USER_EXECUTABLE:
				return isUserExecutable();
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
			case TypesPackage.METHOD_ATTRIBUTES__EXECUTABLE:
				setExecutable((Boolean)newValue);
				return;
			case TypesPackage.METHOD_ATTRIBUTES__USER_EXECUTABLE:
				setUserExecutable((Boolean)newValue);
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
			case TypesPackage.METHOD_ATTRIBUTES__EXECUTABLE:
				unsetExecutable();
				return;
			case TypesPackage.METHOD_ATTRIBUTES__USER_EXECUTABLE:
				unsetUserExecutable();
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
			case TypesPackage.METHOD_ATTRIBUTES__EXECUTABLE:
				return isSetExecutable();
			case TypesPackage.METHOD_ATTRIBUTES__USER_EXECUTABLE:
				return isSetUserExecutable();
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
		result.append(" (executable: ");
		if (executableESet) result.append(executable); else result.append("<unset>");
		result.append(", userExecutable: ");
		if (userExecutableESet) result.append(userExecutable); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //MethodAttributesImpl
