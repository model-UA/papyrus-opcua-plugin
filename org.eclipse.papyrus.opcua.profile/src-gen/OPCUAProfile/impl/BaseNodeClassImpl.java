/**
 */
package OPCUAProfile.impl;

import OPCUAProfile.BaseNodeClass;

import OPCUAProfile.DataTypes.LocalizedText;
import OPCUAProfile.DataTypes.NodeId;
import OPCUAProfile.DataTypes.QualifiedName;
import OPCUAProfile.DataTypes._NodeClass;

import OPCUAProfile.OPCUAProfilePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Node Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link OPCUAProfile.impl.BaseNodeClassImpl#getNodeId <em>Node Id</em>}</li>
 *   <li>{@link OPCUAProfile.impl.BaseNodeClassImpl#getNodeClass <em>Node Class</em>}</li>
 *   <li>{@link OPCUAProfile.impl.BaseNodeClassImpl#getBrowseName <em>Browse Name</em>}</li>
 *   <li>{@link OPCUAProfile.impl.BaseNodeClassImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link OPCUAProfile.impl.BaseNodeClassImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link OPCUAProfile.impl.BaseNodeClassImpl#getWriteMask <em>Write Mask</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BaseNodeClassImpl extends MinimalEObjectImpl.Container implements BaseNodeClass {
	/**
	 * The cached value of the '{@link #getNodeId() <em>Node Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeId()
	 * @generated
	 * @ordered
	 */
	protected NodeId nodeId;

	/**
	 * The default value of the '{@link #getNodeClass() <em>Node Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeClass()
	 * @generated
	 * @ordered
	 */
	protected static final _NodeClass NODE_CLASS_EDEFAULT = _NodeClass.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getNodeClass() <em>Node Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeClass()
	 * @generated
	 * @ordered
	 */
	protected _NodeClass nodeClass = NODE_CLASS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBrowseName() <em>Browse Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBrowseName()
	 * @generated
	 * @ordered
	 */
	protected QualifiedName browseName;

	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected LocalizedText displayName;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected LocalizedText description;

	/**
	 * The default value of the '{@link #getWriteMask() <em>Write Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWriteMask()
	 * @generated
	 * @ordered
	 */
	protected static final int WRITE_MASK_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWriteMask() <em>Write Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWriteMask()
	 * @generated
	 * @ordered
	 */
	protected int writeMask = WRITE_MASK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseNodeClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OPCUAProfilePackage.Literals.BASE_NODE_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeId getNodeId() {
		if (nodeId != null && nodeId.eIsProxy()) {
			InternalEObject oldNodeId = (InternalEObject)nodeId;
			nodeId = (NodeId)eResolveProxy(oldNodeId);
			if (nodeId != oldNodeId) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPCUAProfilePackage.BASE_NODE_CLASS__NODE_ID, oldNodeId, nodeId));
			}
		}
		return nodeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeId basicGetNodeId() {
		return nodeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeId(NodeId newNodeId) {
		NodeId oldNodeId = nodeId;
		nodeId = newNodeId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.BASE_NODE_CLASS__NODE_ID, oldNodeId, nodeId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public _NodeClass getNodeClass() {
		return nodeClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeClass(_NodeClass newNodeClass) {
		_NodeClass oldNodeClass = nodeClass;
		nodeClass = newNodeClass == null ? NODE_CLASS_EDEFAULT : newNodeClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.BASE_NODE_CLASS__NODE_CLASS, oldNodeClass, nodeClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName getBrowseName() {
		if (browseName != null && browseName.eIsProxy()) {
			InternalEObject oldBrowseName = (InternalEObject)browseName;
			browseName = (QualifiedName)eResolveProxy(oldBrowseName);
			if (browseName != oldBrowseName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPCUAProfilePackage.BASE_NODE_CLASS__BROWSE_NAME, oldBrowseName, browseName));
			}
		}
		return browseName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedName basicGetBrowseName() {
		return browseName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBrowseName(QualifiedName newBrowseName) {
		QualifiedName oldBrowseName = browseName;
		browseName = newBrowseName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.BASE_NODE_CLASS__BROWSE_NAME, oldBrowseName, browseName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalizedText getDisplayName() {
		if (displayName != null && displayName.eIsProxy()) {
			InternalEObject oldDisplayName = (InternalEObject)displayName;
			displayName = (LocalizedText)eResolveProxy(oldDisplayName);
			if (displayName != oldDisplayName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPCUAProfilePackage.BASE_NODE_CLASS__DISPLAY_NAME, oldDisplayName, displayName));
			}
		}
		return displayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalizedText basicGetDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayName(LocalizedText newDisplayName) {
		LocalizedText oldDisplayName = displayName;
		displayName = newDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.BASE_NODE_CLASS__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalizedText getDescription() {
		if (description != null && description.eIsProxy()) {
			InternalEObject oldDescription = (InternalEObject)description;
			description = (LocalizedText)eResolveProxy(oldDescription);
			if (description != oldDescription) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OPCUAProfilePackage.BASE_NODE_CLASS__DESCRIPTION, oldDescription, description));
			}
		}
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalizedText basicGetDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(LocalizedText newDescription) {
		LocalizedText oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.BASE_NODE_CLASS__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWriteMask() {
		return writeMask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWriteMask(int newWriteMask) {
		int oldWriteMask = writeMask;
		writeMask = newWriteMask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPCUAProfilePackage.BASE_NODE_CLASS__WRITE_MASK, oldWriteMask, writeMask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OPCUAProfilePackage.BASE_NODE_CLASS__NODE_ID:
				if (resolve) return getNodeId();
				return basicGetNodeId();
			case OPCUAProfilePackage.BASE_NODE_CLASS__NODE_CLASS:
				return getNodeClass();
			case OPCUAProfilePackage.BASE_NODE_CLASS__BROWSE_NAME:
				if (resolve) return getBrowseName();
				return basicGetBrowseName();
			case OPCUAProfilePackage.BASE_NODE_CLASS__DISPLAY_NAME:
				if (resolve) return getDisplayName();
				return basicGetDisplayName();
			case OPCUAProfilePackage.BASE_NODE_CLASS__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case OPCUAProfilePackage.BASE_NODE_CLASS__WRITE_MASK:
				return getWriteMask();
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
			case OPCUAProfilePackage.BASE_NODE_CLASS__NODE_ID:
				setNodeId((NodeId)newValue);
				return;
			case OPCUAProfilePackage.BASE_NODE_CLASS__NODE_CLASS:
				setNodeClass((_NodeClass)newValue);
				return;
			case OPCUAProfilePackage.BASE_NODE_CLASS__BROWSE_NAME:
				setBrowseName((QualifiedName)newValue);
				return;
			case OPCUAProfilePackage.BASE_NODE_CLASS__DISPLAY_NAME:
				setDisplayName((LocalizedText)newValue);
				return;
			case OPCUAProfilePackage.BASE_NODE_CLASS__DESCRIPTION:
				setDescription((LocalizedText)newValue);
				return;
			case OPCUAProfilePackage.BASE_NODE_CLASS__WRITE_MASK:
				setWriteMask((Integer)newValue);
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
			case OPCUAProfilePackage.BASE_NODE_CLASS__NODE_ID:
				setNodeId((NodeId)null);
				return;
			case OPCUAProfilePackage.BASE_NODE_CLASS__NODE_CLASS:
				setNodeClass(NODE_CLASS_EDEFAULT);
				return;
			case OPCUAProfilePackage.BASE_NODE_CLASS__BROWSE_NAME:
				setBrowseName((QualifiedName)null);
				return;
			case OPCUAProfilePackage.BASE_NODE_CLASS__DISPLAY_NAME:
				setDisplayName((LocalizedText)null);
				return;
			case OPCUAProfilePackage.BASE_NODE_CLASS__DESCRIPTION:
				setDescription((LocalizedText)null);
				return;
			case OPCUAProfilePackage.BASE_NODE_CLASS__WRITE_MASK:
				setWriteMask(WRITE_MASK_EDEFAULT);
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
			case OPCUAProfilePackage.BASE_NODE_CLASS__NODE_ID:
				return nodeId != null;
			case OPCUAProfilePackage.BASE_NODE_CLASS__NODE_CLASS:
				return nodeClass != NODE_CLASS_EDEFAULT;
			case OPCUAProfilePackage.BASE_NODE_CLASS__BROWSE_NAME:
				return browseName != null;
			case OPCUAProfilePackage.BASE_NODE_CLASS__DISPLAY_NAME:
				return displayName != null;
			case OPCUAProfilePackage.BASE_NODE_CLASS__DESCRIPTION:
				return description != null;
			case OPCUAProfilePackage.BASE_NODE_CLASS__WRITE_MASK:
				return writeMask != WRITE_MASK_EDEFAULT;
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
		result.append(" (NodeClass: ");
		result.append(nodeClass);
		result.append(", WriteMask: ");
		result.append(writeMask);
		result.append(')');
		return result.toString();
	}

} //BaseNodeClassImpl
