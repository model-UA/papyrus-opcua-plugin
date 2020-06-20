/**
 */
package OPCUAProfile.impl;

import OPCUAProfile.DataTypes.NodeId;

import OPCUAProfile.OPCUAProfilePackage;

import OPCUAProfile.ObjectTypes.ObjectType;

import OPCUAProfile.Variable;

import java.lang.Object;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link OPCUAProfile.impl.VariableImpl#getValue <em>Value</em>}</li>
 *   <li>{@link OPCUAProfile.impl.VariableImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link OPCUAProfile.impl.VariableImpl#getValueRank <em>Value Rank</em>}</li>
 *   <li>{@link OPCUAProfile.impl.VariableImpl#getArrayDimensions <em>Array Dimensions</em>}</li>
 *   <li>{@link OPCUAProfile.impl.VariableImpl#getAccessLevel <em>Access Level</em>}</li>
 *   <li>{@link OPCUAProfile.impl.VariableImpl#getUserAccessLevel <em>User Access Level</em>}</li>
 *   <li>{@link OPCUAProfile.impl.VariableImpl#getMinimumSamplingInterval <em>Minimum Sampling Interval</em>}</li>
 *   <li>{@link OPCUAProfile.impl.VariableImpl#getHistorizing <em>Historizing</em>}</li>
 *   <li>{@link OPCUAProfile.impl.VariableImpl#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableImpl extends BaseNodeClassImpl implements Variable {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected ObjectType value;

	/**
	 * The cached value of the '{@link #getDataType() <em>Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected NodeId dataType;

	/**
	 * The default value of the '{@link #getValueRank() <em>Value Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueRank()
	 * @generated
	 * @ordered
	 */
	protected static final int VALUE_RANK_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getValueRank() <em>Value Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueRank()
	 * @generated
	 * @ordered
	 */
	protected int valueRank = VALUE_RANK_EDEFAULT;

	/**
	 * The default value of the '{@link #getArrayDimensions() <em>Array Dimensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayDimensions()
	 * @generated
	 * @ordered
	 */
	protected static final int ARRAY_DIMENSIONS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getArrayDimensions() <em>Array Dimensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayDimensions()
	 * @generated
	 * @ordered
	 */
	protected int arrayDimensions = ARRAY_DIMENSIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getAccessLevel() <em>Access Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessLevel()
	 * @generated
	 * @ordered
	 */
	protected static final Object ACCESS_LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAccessLevel() <em>Access Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessLevel()
	 * @generated
	 * @ordered
	 */
	protected Object accessLevel = ACCESS_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getUserAccessLevel() <em>User Access Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserAccessLevel()
	 * @generated
	 * @ordered
	 */
	protected static final Object USER_ACCESS_LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserAccessLevel() <em>User Access Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserAccessLevel()
	 * @generated
	 * @ordered
	 */
	protected Object userAccessLevel = USER_ACCESS_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimumSamplingInterval() <em>Minimum Sampling Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumSamplingInterval()
	 * @generated
	 * @ordered
	 */
	protected static final Object MINIMUM_SAMPLING_INTERVAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinimumSamplingInterval() <em>Minimum Sampling Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumSamplingInterval()
	 * @generated
	 * @ordered
	 */
	protected Object minimumSamplingInterval = MINIMUM_SAMPLING_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getHistorizing() <em>Historizing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHistorizing()
	 * @generated
	 * @ordered
	 */
	protected static final Object HISTORIZING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHistorizing() <em>Historizing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHistorizing()
	 * @generated
	 * @ordered
	 */
	protected Object historizing = HISTORIZING_EDEFAULT;

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
	protected VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OPCUAProfilePackage.Literals.VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectType getValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject)value;
			value = (ObjectType)eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPCUAProfilePackage.VARIABLE__VALUE, oldValue, value));
			}
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectType basicGetValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(ObjectType newValue) {
		ObjectType oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.VARIABLE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeId getDataType() {
		if (dataType != null && dataType.eIsProxy()) {
			InternalEObject oldDataType = (InternalEObject)dataType;
			dataType = (NodeId)eResolveProxy(oldDataType);
			if (dataType != oldDataType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPCUAProfilePackage.VARIABLE__DATA_TYPE, oldDataType, dataType));
			}
		}
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeId basicGetDataType() {
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataType(NodeId newDataType) {
		NodeId oldDataType = dataType;
		dataType = newDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.VARIABLE__DATA_TYPE, oldDataType, dataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValueRank() {
		return valueRank;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueRank(int newValueRank) {
		int oldValueRank = valueRank;
		valueRank = newValueRank;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.VARIABLE__VALUE_RANK, oldValueRank, valueRank));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getArrayDimensions() {
		return arrayDimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrayDimensions(int newArrayDimensions) {
		int oldArrayDimensions = arrayDimensions;
		arrayDimensions = newArrayDimensions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.VARIABLE__ARRAY_DIMENSIONS, oldArrayDimensions, arrayDimensions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAccessLevel() {
		return accessLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessLevel(Object newAccessLevel) {
		Object oldAccessLevel = accessLevel;
		accessLevel = newAccessLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.VARIABLE__ACCESS_LEVEL, oldAccessLevel, accessLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getUserAccessLevel() {
		return userAccessLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserAccessLevel(Object newUserAccessLevel) {
		Object oldUserAccessLevel = userAccessLevel;
		userAccessLevel = newUserAccessLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.VARIABLE__USER_ACCESS_LEVEL, oldUserAccessLevel, userAccessLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getMinimumSamplingInterval() {
		return minimumSamplingInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumSamplingInterval(Object newMinimumSamplingInterval) {
		Object oldMinimumSamplingInterval = minimumSamplingInterval;
		minimumSamplingInterval = newMinimumSamplingInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.VARIABLE__MINIMUM_SAMPLING_INTERVAL, oldMinimumSamplingInterval, minimumSamplingInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getHistorizing() {
		return historizing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHistorizing(Object newHistorizing) {
		Object oldHistorizing = historizing;
		historizing = newHistorizing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.VARIABLE__HISTORIZING, oldHistorizing, historizing));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPCUAProfilePackage.VARIABLE__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.VARIABLE__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OPCUAProfilePackage.VARIABLE__VALUE:
				if (resolve) return getValue();
				return basicGetValue();
			case OPCUAProfilePackage.VARIABLE__DATA_TYPE:
				if (resolve) return getDataType();
				return basicGetDataType();
			case OPCUAProfilePackage.VARIABLE__VALUE_RANK:
				return getValueRank();
			case OPCUAProfilePackage.VARIABLE__ARRAY_DIMENSIONS:
				return getArrayDimensions();
			case OPCUAProfilePackage.VARIABLE__ACCESS_LEVEL:
				return getAccessLevel();
			case OPCUAProfilePackage.VARIABLE__USER_ACCESS_LEVEL:
				return getUserAccessLevel();
			case OPCUAProfilePackage.VARIABLE__MINIMUM_SAMPLING_INTERVAL:
				return getMinimumSamplingInterval();
			case OPCUAProfilePackage.VARIABLE__HISTORIZING:
				return getHistorizing();
			case OPCUAProfilePackage.VARIABLE__BASE_CLASS:
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
			case OPCUAProfilePackage.VARIABLE__VALUE:
				setValue((ObjectType)newValue);
				return;
			case OPCUAProfilePackage.VARIABLE__DATA_TYPE:
				setDataType((NodeId)newValue);
				return;
			case OPCUAProfilePackage.VARIABLE__VALUE_RANK:
				setValueRank((Integer)newValue);
				return;
			case OPCUAProfilePackage.VARIABLE__ARRAY_DIMENSIONS:
				setArrayDimensions((Integer)newValue);
				return;
			case OPCUAProfilePackage.VARIABLE__ACCESS_LEVEL:
				setAccessLevel((Object)newValue);
				return;
			case OPCUAProfilePackage.VARIABLE__USER_ACCESS_LEVEL:
				setUserAccessLevel((Object)newValue);
				return;
			case OPCUAProfilePackage.VARIABLE__MINIMUM_SAMPLING_INTERVAL:
				setMinimumSamplingInterval((Object)newValue);
				return;
			case OPCUAProfilePackage.VARIABLE__HISTORIZING:
				setHistorizing((Object)newValue);
				return;
			case OPCUAProfilePackage.VARIABLE__BASE_CLASS:
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
			case OPCUAProfilePackage.VARIABLE__VALUE:
				setValue((ObjectType)null);
				return;
			case OPCUAProfilePackage.VARIABLE__DATA_TYPE:
				setDataType((NodeId)null);
				return;
			case OPCUAProfilePackage.VARIABLE__VALUE_RANK:
				setValueRank(VALUE_RANK_EDEFAULT);
				return;
			case OPCUAProfilePackage.VARIABLE__ARRAY_DIMENSIONS:
				setArrayDimensions(ARRAY_DIMENSIONS_EDEFAULT);
				return;
			case OPCUAProfilePackage.VARIABLE__ACCESS_LEVEL:
				setAccessLevel(ACCESS_LEVEL_EDEFAULT);
				return;
			case OPCUAProfilePackage.VARIABLE__USER_ACCESS_LEVEL:
				setUserAccessLevel(USER_ACCESS_LEVEL_EDEFAULT);
				return;
			case OPCUAProfilePackage.VARIABLE__MINIMUM_SAMPLING_INTERVAL:
				setMinimumSamplingInterval(MINIMUM_SAMPLING_INTERVAL_EDEFAULT);
				return;
			case OPCUAProfilePackage.VARIABLE__HISTORIZING:
				setHistorizing(HISTORIZING_EDEFAULT);
				return;
			case OPCUAProfilePackage.VARIABLE__BASE_CLASS:
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
			case OPCUAProfilePackage.VARIABLE__VALUE:
				return value != null;
			case OPCUAProfilePackage.VARIABLE__DATA_TYPE:
				return dataType != null;
			case OPCUAProfilePackage.VARIABLE__VALUE_RANK:
				return valueRank != VALUE_RANK_EDEFAULT;
			case OPCUAProfilePackage.VARIABLE__ARRAY_DIMENSIONS:
				return arrayDimensions != ARRAY_DIMENSIONS_EDEFAULT;
			case OPCUAProfilePackage.VARIABLE__ACCESS_LEVEL:
				return ACCESS_LEVEL_EDEFAULT == null ? accessLevel != null : !ACCESS_LEVEL_EDEFAULT.equals(accessLevel);
			case OPCUAProfilePackage.VARIABLE__USER_ACCESS_LEVEL:
				return USER_ACCESS_LEVEL_EDEFAULT == null ? userAccessLevel != null : !USER_ACCESS_LEVEL_EDEFAULT.equals(userAccessLevel);
			case OPCUAProfilePackage.VARIABLE__MINIMUM_SAMPLING_INTERVAL:
				return MINIMUM_SAMPLING_INTERVAL_EDEFAULT == null ? minimumSamplingInterval != null : !MINIMUM_SAMPLING_INTERVAL_EDEFAULT.equals(minimumSamplingInterval);
			case OPCUAProfilePackage.VARIABLE__HISTORIZING:
				return HISTORIZING_EDEFAULT == null ? historizing != null : !HISTORIZING_EDEFAULT.equals(historizing);
			case OPCUAProfilePackage.VARIABLE__BASE_CLASS:
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
		result.append(" (ValueRank: ");
		result.append(valueRank);
		result.append(", ArrayDimensions: ");
		result.append(arrayDimensions);
		result.append(", AccessLevel: ");
		result.append(accessLevel);
		result.append(", UserAccessLevel: ");
		result.append(userAccessLevel);
		result.append(", MinimumSamplingInterval: ");
		result.append(minimumSamplingInterval);
		result.append(", Historizing: ");
		result.append(historizing);
		result.append(')');
		return result.toString();
	}

} //VariableImpl
