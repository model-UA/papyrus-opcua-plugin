/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage;
import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeId;
import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeIdType;

import org.eclipse.uml2.uml.DataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Id</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.impl.NodeIdImpl#getNodeIdType <em>Node Id Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.impl.NodeIdImpl#getStringNodeId <em>String Node Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.impl.NodeIdImpl#getNumericNodeId <em>Numeric Node Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.impl.NodeIdImpl#getGuidNodeId <em>Guid Node Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.impl.NodeIdImpl#getBase_DataType <em>Base Data Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeIdImpl extends MinimalEObjectImpl.Container implements NodeId {
	/**
	 * The default value of the '{@link #getNodeIdType() <em>Node Id Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeIdType()
	 * @generated
	 * @ordered
	 */
	protected static final NodeIdType NODE_ID_TYPE_EDEFAULT = NodeIdType.STRING;

	/**
	 * The cached value of the '{@link #getNodeIdType() <em>Node Id Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeIdType()
	 * @generated
	 * @ordered
	 */
	protected NodeIdType nodeIdType = NODE_ID_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStringNodeId() <em>String Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringNodeId()
	 * @generated
	 * @ordered
	 */
	protected static final Object STRING_NODE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStringNodeId() <em>String Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringNodeId()
	 * @generated
	 * @ordered
	 */
	protected Object stringNodeId = STRING_NODE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumericNodeId() <em>Numeric Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumericNodeId()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMERIC_NODE_ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumericNodeId() <em>Numeric Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumericNodeId()
	 * @generated
	 * @ordered
	 */
	protected int numericNodeId = NUMERIC_NODE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getGuidNodeId() <em>Guid Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuidNodeId()
	 * @generated
	 * @ordered
	 */
	protected static final Object GUID_NODE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGuidNodeId() <em>Guid Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuidNodeId()
	 * @generated
	 * @ordered
	 */
	protected Object guidNodeId = GUID_NODE_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_DataType() <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_DataType()
	 * @generated
	 * @ordered
	 */
	protected DataType base_DataType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeIdImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataTypesPackage.Literals.NODE_ID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NodeIdType getNodeIdType() {
		return nodeIdType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNodeIdType(NodeIdType newNodeIdType) {
		NodeIdType oldNodeIdType = nodeIdType;
		nodeIdType = newNodeIdType == null ? NODE_ID_TYPE_EDEFAULT : newNodeIdType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypesPackage.NODE_ID__NODE_ID_TYPE, oldNodeIdType, nodeIdType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getStringNodeId() {
		return stringNodeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStringNodeId(Object newStringNodeId) {
		Object oldStringNodeId = stringNodeId;
		stringNodeId = newStringNodeId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypesPackage.NODE_ID__STRING_NODE_ID, oldStringNodeId, stringNodeId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNumericNodeId() {
		return numericNodeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumericNodeId(int newNumericNodeId) {
		int oldNumericNodeId = numericNodeId;
		numericNodeId = newNumericNodeId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypesPackage.NODE_ID__NUMERIC_NODE_ID, oldNumericNodeId, numericNodeId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getGuidNodeId() {
		return guidNodeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGuidNodeId(Object newGuidNodeId) {
		Object oldGuidNodeId = guidNodeId;
		guidNodeId = newGuidNodeId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypesPackage.NODE_ID__GUID_NODE_ID, oldGuidNodeId, guidNodeId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataType getBase_DataType() {
		if (base_DataType != null && base_DataType.eIsProxy()) {
			InternalEObject oldBase_DataType = (InternalEObject)base_DataType;
			base_DataType = (DataType)eResolveProxy(oldBase_DataType);
			if (base_DataType != oldBase_DataType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataTypesPackage.NODE_ID__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
			}
		}
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetBase_DataType() {
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBase_DataType(DataType newBase_DataType) {
		DataType oldBase_DataType = base_DataType;
		base_DataType = newBase_DataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypesPackage.NODE_ID__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataTypesPackage.NODE_ID__NODE_ID_TYPE:
				return getNodeIdType();
			case DataTypesPackage.NODE_ID__STRING_NODE_ID:
				return getStringNodeId();
			case DataTypesPackage.NODE_ID__NUMERIC_NODE_ID:
				return getNumericNodeId();
			case DataTypesPackage.NODE_ID__GUID_NODE_ID:
				return getGuidNodeId();
			case DataTypesPackage.NODE_ID__BASE_DATA_TYPE:
				if (resolve) return getBase_DataType();
				return basicGetBase_DataType();
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
			case DataTypesPackage.NODE_ID__NODE_ID_TYPE:
				setNodeIdType((NodeIdType)newValue);
				return;
			case DataTypesPackage.NODE_ID__STRING_NODE_ID:
				setStringNodeId((Object)newValue);
				return;
			case DataTypesPackage.NODE_ID__NUMERIC_NODE_ID:
				setNumericNodeId((Integer)newValue);
				return;
			case DataTypesPackage.NODE_ID__GUID_NODE_ID:
				setGuidNodeId((Object)newValue);
				return;
			case DataTypesPackage.NODE_ID__BASE_DATA_TYPE:
				setBase_DataType((DataType)newValue);
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
			case DataTypesPackage.NODE_ID__NODE_ID_TYPE:
				setNodeIdType(NODE_ID_TYPE_EDEFAULT);
				return;
			case DataTypesPackage.NODE_ID__STRING_NODE_ID:
				setStringNodeId(STRING_NODE_ID_EDEFAULT);
				return;
			case DataTypesPackage.NODE_ID__NUMERIC_NODE_ID:
				setNumericNodeId(NUMERIC_NODE_ID_EDEFAULT);
				return;
			case DataTypesPackage.NODE_ID__GUID_NODE_ID:
				setGuidNodeId(GUID_NODE_ID_EDEFAULT);
				return;
			case DataTypesPackage.NODE_ID__BASE_DATA_TYPE:
				setBase_DataType((DataType)null);
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
			case DataTypesPackage.NODE_ID__NODE_ID_TYPE:
				return nodeIdType != NODE_ID_TYPE_EDEFAULT;
			case DataTypesPackage.NODE_ID__STRING_NODE_ID:
				return STRING_NODE_ID_EDEFAULT == null ? stringNodeId != null : !STRING_NODE_ID_EDEFAULT.equals(stringNodeId);
			case DataTypesPackage.NODE_ID__NUMERIC_NODE_ID:
				return numericNodeId != NUMERIC_NODE_ID_EDEFAULT;
			case DataTypesPackage.NODE_ID__GUID_NODE_ID:
				return GUID_NODE_ID_EDEFAULT == null ? guidNodeId != null : !GUID_NODE_ID_EDEFAULT.equals(guidNodeId);
			case DataTypesPackage.NODE_ID__BASE_DATA_TYPE:
				return base_DataType != null;
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
		result.append(" (NodeIdType: ");
		result.append(nodeIdType);
		result.append(", StringNodeId: ");
		result.append(stringNodeId);
		result.append(", NumericNodeId: ");
		result.append(numericNodeId);
		result.append(", GuidNodeId: ");
		result.append(guidNodeId);
		result.append(')');
		return result.toString();
	}

} //NodeIdImpl
