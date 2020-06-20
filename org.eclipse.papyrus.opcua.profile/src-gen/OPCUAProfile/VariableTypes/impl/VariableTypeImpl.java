/**
 */
package OPCUAProfile.VariableTypes.impl;

import OPCUAProfile.DataTypes.DataType;
import OPCUAProfile.DataTypes.NodeId;

import OPCUAProfile.VariableTypes.VariableType;
import OPCUAProfile.VariableTypes.VariableTypesPackage;

import OPCUAProfile.impl.BaseNodeClassImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link OPCUAProfile.VariableTypes.impl.VariableTypeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link OPCUAProfile.VariableTypes.impl.VariableTypeImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link OPCUAProfile.VariableTypes.impl.VariableTypeImpl#getValueRank <em>Value Rank</em>}</li>
 *   <li>{@link OPCUAProfile.VariableTypes.impl.VariableTypeImpl#getArrayDimensions <em>Array Dimensions</em>}</li>
 *   <li>{@link OPCUAProfile.VariableTypes.impl.VariableTypeImpl#getIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link OPCUAProfile.VariableTypes.impl.VariableTypeImpl#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableTypeImpl extends BaseNodeClassImpl implements VariableType {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected DataType value;

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
	 * The default value of the '{@link #getIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final Object IS_ABSTRACT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected Object isAbstract = IS_ABSTRACT_EDEFAULT;

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
	protected VariableTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VariableTypesPackage.Literals.VARIABLE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject)value;
			value = (DataType)eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariableTypesPackage.VARIABLE_TYPE__VALUE, oldValue, value));
			}
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(DataType newValue) {
		DataType oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariableTypesPackage.VARIABLE_TYPE__VALUE, oldValue, value));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariableTypesPackage.VARIABLE_TYPE__DATA_TYPE, oldDataType, dataType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VariableTypesPackage.VARIABLE_TYPE__DATA_TYPE, oldDataType, dataType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VariableTypesPackage.VARIABLE_TYPE__VALUE_RANK, oldValueRank, valueRank));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VariableTypesPackage.VARIABLE_TYPE__ARRAY_DIMENSIONS, oldArrayDimensions, arrayDimensions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getIsAbstract() {
		return isAbstract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAbstract(Object newIsAbstract) {
		Object oldIsAbstract = isAbstract;
		isAbstract = newIsAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariableTypesPackage.VARIABLE_TYPE__IS_ABSTRACT, oldIsAbstract, isAbstract));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariableTypesPackage.VARIABLE_TYPE__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VariableTypesPackage.VARIABLE_TYPE__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VariableTypesPackage.VARIABLE_TYPE__VALUE:
				if (resolve) return getValue();
				return basicGetValue();
			case VariableTypesPackage.VARIABLE_TYPE__DATA_TYPE:
				if (resolve) return getDataType();
				return basicGetDataType();
			case VariableTypesPackage.VARIABLE_TYPE__VALUE_RANK:
				return getValueRank();
			case VariableTypesPackage.VARIABLE_TYPE__ARRAY_DIMENSIONS:
				return getArrayDimensions();
			case VariableTypesPackage.VARIABLE_TYPE__IS_ABSTRACT:
				return getIsAbstract();
			case VariableTypesPackage.VARIABLE_TYPE__BASE_CLASS:
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
			case VariableTypesPackage.VARIABLE_TYPE__VALUE:
				setValue((DataType)newValue);
				return;
			case VariableTypesPackage.VARIABLE_TYPE__DATA_TYPE:
				setDataType((NodeId)newValue);
				return;
			case VariableTypesPackage.VARIABLE_TYPE__VALUE_RANK:
				setValueRank((Integer)newValue);
				return;
			case VariableTypesPackage.VARIABLE_TYPE__ARRAY_DIMENSIONS:
				setArrayDimensions((Integer)newValue);
				return;
			case VariableTypesPackage.VARIABLE_TYPE__IS_ABSTRACT:
				setIsAbstract((Object)newValue);
				return;
			case VariableTypesPackage.VARIABLE_TYPE__BASE_CLASS:
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
			case VariableTypesPackage.VARIABLE_TYPE__VALUE:
				setValue((DataType)null);
				return;
			case VariableTypesPackage.VARIABLE_TYPE__DATA_TYPE:
				setDataType((NodeId)null);
				return;
			case VariableTypesPackage.VARIABLE_TYPE__VALUE_RANK:
				setValueRank(VALUE_RANK_EDEFAULT);
				return;
			case VariableTypesPackage.VARIABLE_TYPE__ARRAY_DIMENSIONS:
				setArrayDimensions(ARRAY_DIMENSIONS_EDEFAULT);
				return;
			case VariableTypesPackage.VARIABLE_TYPE__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case VariableTypesPackage.VARIABLE_TYPE__BASE_CLASS:
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
			case VariableTypesPackage.VARIABLE_TYPE__VALUE:
				return value != null;
			case VariableTypesPackage.VARIABLE_TYPE__DATA_TYPE:
				return dataType != null;
			case VariableTypesPackage.VARIABLE_TYPE__VALUE_RANK:
				return valueRank != VALUE_RANK_EDEFAULT;
			case VariableTypesPackage.VARIABLE_TYPE__ARRAY_DIMENSIONS:
				return arrayDimensions != ARRAY_DIMENSIONS_EDEFAULT;
			case VariableTypesPackage.VARIABLE_TYPE__IS_ABSTRACT:
				return IS_ABSTRACT_EDEFAULT == null ? isAbstract != null : !IS_ABSTRACT_EDEFAULT.equals(isAbstract);
			case VariableTypesPackage.VARIABLE_TYPE__BASE_CLASS:
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
		result.append(", IsAbstract: ");
		result.append(isAbstract);
		result.append(')');
		return result.toString();
	}

} //VariableTypeImpl
