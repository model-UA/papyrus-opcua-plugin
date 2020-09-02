/**
 */
package org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ObjectType;
import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable;
import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeId;

import org.eclipse.uml2.uml.Stereotype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableImpl#getValueRank <em>Value Rank</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableImpl#getArrayDimensions <em>Array Dimensions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableImpl#getAccessLevel <em>Access Level</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableImpl#getUserAccessLevel <em>User Access Level</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableImpl#getMinimumSamplingInterval <em>Minimum Sampling Interval</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableImpl#isHistorizing <em>Historizing</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableImpl#getBase_Variable <em>Base Variable</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl.VariableImpl#getBase_Stereotype <em>Base Stereotype</em>}</li>
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
	protected static final byte ACCESS_LEVEL_EDEFAULT = 0x00;

	/**
	 * The cached value of the '{@link #getAccessLevel() <em>Access Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessLevel()
	 * @generated
	 * @ordered
	 */
	protected byte accessLevel = ACCESS_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getUserAccessLevel() <em>User Access Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserAccessLevel()
	 * @generated
	 * @ordered
	 */
	protected static final byte USER_ACCESS_LEVEL_EDEFAULT = 0x00;

	/**
	 * The cached value of the '{@link #getUserAccessLevel() <em>User Access Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserAccessLevel()
	 * @generated
	 * @ordered
	 */
	protected byte userAccessLevel = USER_ACCESS_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimumSamplingInterval() <em>Minimum Sampling Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumSamplingInterval()
	 * @generated
	 * @ordered
	 */
	protected static final double MINIMUM_SAMPLING_INTERVAL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMinimumSamplingInterval() <em>Minimum Sampling Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumSamplingInterval()
	 * @generated
	 * @ordered
	 */
	protected double minimumSamplingInterval = MINIMUM_SAMPLING_INTERVAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isHistorizing() <em>Historizing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHistorizing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HISTORIZING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHistorizing() <em>Historizing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHistorizing()
	 * @generated
	 * @ordered
	 */
	protected boolean historizing = HISTORIZING_EDEFAULT;

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
	 * The cached value of the '{@link #getBase_Variable() <em>Base Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Variable()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Variable base_Variable;

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
	public VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return basetypesPackage.Literals.VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectType getValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject)value;
			value = (ObjectType)eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, basetypesPackage.VARIABLE__VALUE, oldValue, value));
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
	@Override
	public void setValue(ObjectType newValue) {
		ObjectType oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.VARIABLE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NodeId getDataType() {
		if (dataType != null && dataType.eIsProxy()) {
			InternalEObject oldDataType = (InternalEObject)dataType;
			dataType = (NodeId)eResolveProxy(oldDataType);
			if (dataType != oldDataType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, basetypesPackage.VARIABLE__DATA_TYPE, oldDataType, dataType));
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
	@Override
	public void setDataType(NodeId newDataType) {
		NodeId oldDataType = dataType;
		dataType = newDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.VARIABLE__DATA_TYPE, oldDataType, dataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValueRank() {
		return valueRank;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValueRank(int newValueRank) {
		int oldValueRank = valueRank;
		valueRank = newValueRank;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.VARIABLE__VALUE_RANK, oldValueRank, valueRank));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getArrayDimensions() {
		return arrayDimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArrayDimensions(int newArrayDimensions) {
		int oldArrayDimensions = arrayDimensions;
		arrayDimensions = newArrayDimensions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.VARIABLE__ARRAY_DIMENSIONS, oldArrayDimensions, arrayDimensions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public byte getAccessLevel() {
		return accessLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAccessLevel(byte newAccessLevel) {
		byte oldAccessLevel = accessLevel;
		accessLevel = newAccessLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.VARIABLE__ACCESS_LEVEL, oldAccessLevel, accessLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public byte getUserAccessLevel() {
		return userAccessLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUserAccessLevel(byte newUserAccessLevel) {
		byte oldUserAccessLevel = userAccessLevel;
		userAccessLevel = newUserAccessLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.VARIABLE__USER_ACCESS_LEVEL, oldUserAccessLevel, userAccessLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMinimumSamplingInterval() {
		return minimumSamplingInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinimumSamplingInterval(double newMinimumSamplingInterval) {
		double oldMinimumSamplingInterval = minimumSamplingInterval;
		minimumSamplingInterval = newMinimumSamplingInterval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.VARIABLE__MINIMUM_SAMPLING_INTERVAL, oldMinimumSamplingInterval, minimumSamplingInterval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHistorizing() {
		return historizing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHistorizing(boolean newHistorizing) {
		boolean oldHistorizing = historizing;
		historizing = newHistorizing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.VARIABLE__HISTORIZING, oldHistorizing, historizing));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, basetypesPackage.VARIABLE__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.VARIABLE__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Variable getBase_Variable() {
		if (base_Variable != null && base_Variable.eIsProxy()) {
			InternalEObject oldBase_Variable = (InternalEObject)base_Variable;
			base_Variable = (org.eclipse.uml2.uml.Variable)eResolveProxy(oldBase_Variable);
			if (base_Variable != oldBase_Variable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, basetypesPackage.VARIABLE__BASE_VARIABLE, oldBase_Variable, base_Variable));
			}
		}
		return base_Variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Variable basicGetBase_Variable() {
		return base_Variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_Variable(org.eclipse.uml2.uml.Variable newBase_Variable) {
		org.eclipse.uml2.uml.Variable oldBase_Variable = base_Variable;
		base_Variable = newBase_Variable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.VARIABLE__BASE_VARIABLE, oldBase_Variable, base_Variable));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, basetypesPackage.VARIABLE__BASE_STEREOTYPE, oldBase_Stereotype, base_Stereotype));
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
			eNotify(new ENotificationImpl(this, Notification.SET, basetypesPackage.VARIABLE__BASE_STEREOTYPE, oldBase_Stereotype, base_Stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case basetypesPackage.VARIABLE__VALUE:
				if (resolve) return getValue();
				return basicGetValue();
			case basetypesPackage.VARIABLE__DATA_TYPE:
				if (resolve) return getDataType();
				return basicGetDataType();
			case basetypesPackage.VARIABLE__VALUE_RANK:
				return getValueRank();
			case basetypesPackage.VARIABLE__ARRAY_DIMENSIONS:
				return getArrayDimensions();
			case basetypesPackage.VARIABLE__ACCESS_LEVEL:
				return getAccessLevel();
			case basetypesPackage.VARIABLE__USER_ACCESS_LEVEL:
				return getUserAccessLevel();
			case basetypesPackage.VARIABLE__MINIMUM_SAMPLING_INTERVAL:
				return getMinimumSamplingInterval();
			case basetypesPackage.VARIABLE__HISTORIZING:
				return isHistorizing();
			case basetypesPackage.VARIABLE__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case basetypesPackage.VARIABLE__BASE_VARIABLE:
				if (resolve) return getBase_Variable();
				return basicGetBase_Variable();
			case basetypesPackage.VARIABLE__BASE_STEREOTYPE:
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
			case basetypesPackage.VARIABLE__VALUE:
				setValue((ObjectType)newValue);
				return;
			case basetypesPackage.VARIABLE__DATA_TYPE:
				setDataType((NodeId)newValue);
				return;
			case basetypesPackage.VARIABLE__VALUE_RANK:
				setValueRank((Integer)newValue);
				return;
			case basetypesPackage.VARIABLE__ARRAY_DIMENSIONS:
				setArrayDimensions((Integer)newValue);
				return;
			case basetypesPackage.VARIABLE__ACCESS_LEVEL:
				setAccessLevel((Byte)newValue);
				return;
			case basetypesPackage.VARIABLE__USER_ACCESS_LEVEL:
				setUserAccessLevel((Byte)newValue);
				return;
			case basetypesPackage.VARIABLE__MINIMUM_SAMPLING_INTERVAL:
				setMinimumSamplingInterval((Double)newValue);
				return;
			case basetypesPackage.VARIABLE__HISTORIZING:
				setHistorizing((Boolean)newValue);
				return;
			case basetypesPackage.VARIABLE__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case basetypesPackage.VARIABLE__BASE_VARIABLE:
				setBase_Variable((org.eclipse.uml2.uml.Variable)newValue);
				return;
			case basetypesPackage.VARIABLE__BASE_STEREOTYPE:
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
			case basetypesPackage.VARIABLE__VALUE:
				setValue((ObjectType)null);
				return;
			case basetypesPackage.VARIABLE__DATA_TYPE:
				setDataType((NodeId)null);
				return;
			case basetypesPackage.VARIABLE__VALUE_RANK:
				setValueRank(VALUE_RANK_EDEFAULT);
				return;
			case basetypesPackage.VARIABLE__ARRAY_DIMENSIONS:
				setArrayDimensions(ARRAY_DIMENSIONS_EDEFAULT);
				return;
			case basetypesPackage.VARIABLE__ACCESS_LEVEL:
				setAccessLevel(ACCESS_LEVEL_EDEFAULT);
				return;
			case basetypesPackage.VARIABLE__USER_ACCESS_LEVEL:
				setUserAccessLevel(USER_ACCESS_LEVEL_EDEFAULT);
				return;
			case basetypesPackage.VARIABLE__MINIMUM_SAMPLING_INTERVAL:
				setMinimumSamplingInterval(MINIMUM_SAMPLING_INTERVAL_EDEFAULT);
				return;
			case basetypesPackage.VARIABLE__HISTORIZING:
				setHistorizing(HISTORIZING_EDEFAULT);
				return;
			case basetypesPackage.VARIABLE__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case basetypesPackage.VARIABLE__BASE_VARIABLE:
				setBase_Variable((org.eclipse.uml2.uml.Variable)null);
				return;
			case basetypesPackage.VARIABLE__BASE_STEREOTYPE:
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
			case basetypesPackage.VARIABLE__VALUE:
				return value != null;
			case basetypesPackage.VARIABLE__DATA_TYPE:
				return dataType != null;
			case basetypesPackage.VARIABLE__VALUE_RANK:
				return valueRank != VALUE_RANK_EDEFAULT;
			case basetypesPackage.VARIABLE__ARRAY_DIMENSIONS:
				return arrayDimensions != ARRAY_DIMENSIONS_EDEFAULT;
			case basetypesPackage.VARIABLE__ACCESS_LEVEL:
				return accessLevel != ACCESS_LEVEL_EDEFAULT;
			case basetypesPackage.VARIABLE__USER_ACCESS_LEVEL:
				return userAccessLevel != USER_ACCESS_LEVEL_EDEFAULT;
			case basetypesPackage.VARIABLE__MINIMUM_SAMPLING_INTERVAL:
				return minimumSamplingInterval != MINIMUM_SAMPLING_INTERVAL_EDEFAULT;
			case basetypesPackage.VARIABLE__HISTORIZING:
				return historizing != HISTORIZING_EDEFAULT;
			case basetypesPackage.VARIABLE__BASE_CLASS:
				return base_Class != null;
			case basetypesPackage.VARIABLE__BASE_VARIABLE:
				return base_Variable != null;
			case basetypesPackage.VARIABLE__BASE_STEREOTYPE:
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
