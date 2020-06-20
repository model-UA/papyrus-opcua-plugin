/**
 */
package OPCUAProfile.DataTypes.impl;

import OPCUAProfile.DataTypes.DataTypesPackage;
import OPCUAProfile.DataTypes.QualifiedName;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link OPCUAProfile.DataTypes.impl.QualifiedNameImpl#getNamespaceIndex <em>Namespace Index</em>}</li>
 *   <li>{@link OPCUAProfile.DataTypes.impl.QualifiedNameImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QualifiedNameImpl extends MinimalEObjectImpl.Container implements QualifiedName {
	/**
	 * The default value of the '{@link #getNamespaceIndex() <em>Namespace Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespaceIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int NAMESPACE_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNamespaceIndex() <em>Namespace Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespaceIndex()
	 * @generated
	 * @ordered
	 */
	protected int namespaceIndex = NAMESPACE_INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final Object NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected Object name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualifiedNameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataTypesPackage.Literals.QUALIFIED_NAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNamespaceIndex() {
		return namespaceIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespaceIndex(int newNamespaceIndex) {
		int oldNamespaceIndex = namespaceIndex;
		namespaceIndex = newNamespaceIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypesPackage.QUALIFIED_NAME__NAMESPACE_INDEX, oldNamespaceIndex, namespaceIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(Object newName) {
		Object oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypesPackage.QUALIFIED_NAME__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataTypesPackage.QUALIFIED_NAME__NAMESPACE_INDEX:
				return getNamespaceIndex();
			case DataTypesPackage.QUALIFIED_NAME__NAME:
				return getName();
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
			case DataTypesPackage.QUALIFIED_NAME__NAMESPACE_INDEX:
				setNamespaceIndex((Integer)newValue);
				return;
			case DataTypesPackage.QUALIFIED_NAME__NAME:
				setName((Object)newValue);
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
			case DataTypesPackage.QUALIFIED_NAME__NAMESPACE_INDEX:
				setNamespaceIndex(NAMESPACE_INDEX_EDEFAULT);
				return;
			case DataTypesPackage.QUALIFIED_NAME__NAME:
				setName(NAME_EDEFAULT);
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
			case DataTypesPackage.QUALIFIED_NAME__NAMESPACE_INDEX:
				return namespaceIndex != NAMESPACE_INDEX_EDEFAULT;
			case DataTypesPackage.QUALIFIED_NAME__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (NamespaceIndex: ");
		result.append(namespaceIndex);
		result.append(", Name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //QualifiedNameImpl
