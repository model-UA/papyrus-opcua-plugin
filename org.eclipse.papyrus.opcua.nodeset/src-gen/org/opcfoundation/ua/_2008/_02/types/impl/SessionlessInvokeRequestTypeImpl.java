/**
 */
package org.opcfoundation.ua._2008._02.types.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.opcfoundation.ua._2008._02.types.ListOfString;
import org.opcfoundation.ua._2008._02.types.ListOfUInt32;
import org.opcfoundation.ua._2008._02.types.SessionlessInvokeRequestType;
import org.opcfoundation.ua._2008._02.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sessionless Invoke Request Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.SessionlessInvokeRequestTypeImpl#getUrisVersion <em>Uris Version</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.SessionlessInvokeRequestTypeImpl#getNamespaceUris <em>Namespace Uris</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.SessionlessInvokeRequestTypeImpl#getServerUris <em>Server Uris</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.SessionlessInvokeRequestTypeImpl#getLocaleIds <em>Locale Ids</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2008._02.types.impl.SessionlessInvokeRequestTypeImpl#getServiceId <em>Service Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SessionlessInvokeRequestTypeImpl extends MinimalEObjectImpl.Container implements SessionlessInvokeRequestType {
	/**
	 * The cached value of the '{@link #getUrisVersion() <em>Uris Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrisVersion()
	 * @generated
	 * @ordered
	 */
	protected ListOfUInt32 urisVersion;

	/**
	 * This is true if the Uris Version containment reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean urisVersionESet;

	/**
	 * The cached value of the '{@link #getNamespaceUris() <em>Namespace Uris</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespaceUris()
	 * @generated
	 * @ordered
	 */
	protected ListOfString namespaceUris;

	/**
	 * This is true if the Namespace Uris containment reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean namespaceUrisESet;

	/**
	 * The cached value of the '{@link #getServerUris() <em>Server Uris</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerUris()
	 * @generated
	 * @ordered
	 */
	protected ListOfString serverUris;

	/**
	 * This is true if the Server Uris containment reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean serverUrisESet;

	/**
	 * The cached value of the '{@link #getLocaleIds() <em>Locale Ids</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocaleIds()
	 * @generated
	 * @ordered
	 */
	protected ListOfString localeIds;

	/**
	 * This is true if the Locale Ids containment reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean localeIdsESet;

	/**
	 * The default value of the '{@link #getServiceId() <em>Service Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceId()
	 * @generated
	 * @ordered
	 */
	protected static final long SERVICE_ID_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getServiceId() <em>Service Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceId()
	 * @generated
	 * @ordered
	 */
	protected long serviceId = SERVICE_ID_EDEFAULT;

	/**
	 * This is true if the Service Id attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean serviceIdESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SessionlessInvokeRequestTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getSessionlessInvokeRequestType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListOfUInt32 getUrisVersion() {
		return urisVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUrisVersion(ListOfUInt32 newUrisVersion, NotificationChain msgs) {
		ListOfUInt32 oldUrisVersion = urisVersion;
		urisVersion = newUrisVersion;
		boolean oldUrisVersionESet = urisVersionESet;
		urisVersionESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__URIS_VERSION, oldUrisVersion, newUrisVersion, !oldUrisVersionESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrisVersion(ListOfUInt32 newUrisVersion) {
		if (newUrisVersion != urisVersion) {
			NotificationChain msgs = null;
			if (urisVersion != null)
				msgs = ((InternalEObject)urisVersion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__URIS_VERSION, null, msgs);
			if (newUrisVersion != null)
				msgs = ((InternalEObject)newUrisVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__URIS_VERSION, null, msgs);
			msgs = basicSetUrisVersion(newUrisVersion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldUrisVersionESet = urisVersionESet;
			urisVersionESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__URIS_VERSION, newUrisVersion, newUrisVersion, !oldUrisVersionESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicUnsetUrisVersion(NotificationChain msgs) {
		ListOfUInt32 oldUrisVersion = urisVersion;
		urisVersion = null;
		boolean oldUrisVersionESet = urisVersionESet;
		urisVersionESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__URIS_VERSION, oldUrisVersion, null, oldUrisVersionESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUrisVersion() {
		if (urisVersion != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)urisVersion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__URIS_VERSION, null, msgs);
			msgs = basicUnsetUrisVersion(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldUrisVersionESet = urisVersionESet;
			urisVersionESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__URIS_VERSION, null, null, oldUrisVersionESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUrisVersion() {
		return urisVersionESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListOfString getNamespaceUris() {
		return namespaceUris;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNamespaceUris(ListOfString newNamespaceUris, NotificationChain msgs) {
		ListOfString oldNamespaceUris = namespaceUris;
		namespaceUris = newNamespaceUris;
		boolean oldNamespaceUrisESet = namespaceUrisESet;
		namespaceUrisESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__NAMESPACE_URIS, oldNamespaceUris, newNamespaceUris, !oldNamespaceUrisESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespaceUris(ListOfString newNamespaceUris) {
		if (newNamespaceUris != namespaceUris) {
			NotificationChain msgs = null;
			if (namespaceUris != null)
				msgs = ((InternalEObject)namespaceUris).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__NAMESPACE_URIS, null, msgs);
			if (newNamespaceUris != null)
				msgs = ((InternalEObject)newNamespaceUris).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__NAMESPACE_URIS, null, msgs);
			msgs = basicSetNamespaceUris(newNamespaceUris, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldNamespaceUrisESet = namespaceUrisESet;
			namespaceUrisESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__NAMESPACE_URIS, newNamespaceUris, newNamespaceUris, !oldNamespaceUrisESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicUnsetNamespaceUris(NotificationChain msgs) {
		ListOfString oldNamespaceUris = namespaceUris;
		namespaceUris = null;
		boolean oldNamespaceUrisESet = namespaceUrisESet;
		namespaceUrisESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__NAMESPACE_URIS, oldNamespaceUris, null, oldNamespaceUrisESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNamespaceUris() {
		if (namespaceUris != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)namespaceUris).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__NAMESPACE_URIS, null, msgs);
			msgs = basicUnsetNamespaceUris(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldNamespaceUrisESet = namespaceUrisESet;
			namespaceUrisESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__NAMESPACE_URIS, null, null, oldNamespaceUrisESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNamespaceUris() {
		return namespaceUrisESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListOfString getServerUris() {
		return serverUris;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServerUris(ListOfString newServerUris, NotificationChain msgs) {
		ListOfString oldServerUris = serverUris;
		serverUris = newServerUris;
		boolean oldServerUrisESet = serverUrisESet;
		serverUrisESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVER_URIS, oldServerUris, newServerUris, !oldServerUrisESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerUris(ListOfString newServerUris) {
		if (newServerUris != serverUris) {
			NotificationChain msgs = null;
			if (serverUris != null)
				msgs = ((InternalEObject)serverUris).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVER_URIS, null, msgs);
			if (newServerUris != null)
				msgs = ((InternalEObject)newServerUris).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVER_URIS, null, msgs);
			msgs = basicSetServerUris(newServerUris, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldServerUrisESet = serverUrisESet;
			serverUrisESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVER_URIS, newServerUris, newServerUris, !oldServerUrisESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicUnsetServerUris(NotificationChain msgs) {
		ListOfString oldServerUris = serverUris;
		serverUris = null;
		boolean oldServerUrisESet = serverUrisESet;
		serverUrisESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVER_URIS, oldServerUris, null, oldServerUrisESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetServerUris() {
		if (serverUris != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)serverUris).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVER_URIS, null, msgs);
			msgs = basicUnsetServerUris(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldServerUrisESet = serverUrisESet;
			serverUrisESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVER_URIS, null, null, oldServerUrisESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetServerUris() {
		return serverUrisESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListOfString getLocaleIds() {
		return localeIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocaleIds(ListOfString newLocaleIds, NotificationChain msgs) {
		ListOfString oldLocaleIds = localeIds;
		localeIds = newLocaleIds;
		boolean oldLocaleIdsESet = localeIdsESet;
		localeIdsESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__LOCALE_IDS, oldLocaleIds, newLocaleIds, !oldLocaleIdsESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocaleIds(ListOfString newLocaleIds) {
		if (newLocaleIds != localeIds) {
			NotificationChain msgs = null;
			if (localeIds != null)
				msgs = ((InternalEObject)localeIds).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__LOCALE_IDS, null, msgs);
			if (newLocaleIds != null)
				msgs = ((InternalEObject)newLocaleIds).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__LOCALE_IDS, null, msgs);
			msgs = basicSetLocaleIds(newLocaleIds, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldLocaleIdsESet = localeIdsESet;
			localeIdsESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__LOCALE_IDS, newLocaleIds, newLocaleIds, !oldLocaleIdsESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicUnsetLocaleIds(NotificationChain msgs) {
		ListOfString oldLocaleIds = localeIds;
		localeIds = null;
		boolean oldLocaleIdsESet = localeIdsESet;
		localeIdsESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__LOCALE_IDS, oldLocaleIds, null, oldLocaleIdsESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLocaleIds() {
		if (localeIds != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)localeIds).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__LOCALE_IDS, null, msgs);
			msgs = basicUnsetLocaleIds(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldLocaleIdsESet = localeIdsESet;
			localeIdsESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__LOCALE_IDS, null, null, oldLocaleIdsESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLocaleIds() {
		return localeIdsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getServiceId() {
		return serviceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceId(long newServiceId) {
		long oldServiceId = serviceId;
		serviceId = newServiceId;
		boolean oldServiceIdESet = serviceIdESet;
		serviceIdESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVICE_ID, oldServiceId, serviceId, !oldServiceIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetServiceId() {
		long oldServiceId = serviceId;
		boolean oldServiceIdESet = serviceIdESet;
		serviceId = SERVICE_ID_EDEFAULT;
		serviceIdESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVICE_ID, oldServiceId, SERVICE_ID_EDEFAULT, oldServiceIdESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetServiceId() {
		return serviceIdESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__URIS_VERSION:
				return basicUnsetUrisVersion(msgs);
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__NAMESPACE_URIS:
				return basicUnsetNamespaceUris(msgs);
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVER_URIS:
				return basicUnsetServerUris(msgs);
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__LOCALE_IDS:
				return basicUnsetLocaleIds(msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__URIS_VERSION:
				return getUrisVersion();
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__NAMESPACE_URIS:
				return getNamespaceUris();
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVER_URIS:
				return getServerUris();
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__LOCALE_IDS:
				return getLocaleIds();
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVICE_ID:
				return getServiceId();
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
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__URIS_VERSION:
				setUrisVersion((ListOfUInt32)newValue);
				return;
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__NAMESPACE_URIS:
				setNamespaceUris((ListOfString)newValue);
				return;
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVER_URIS:
				setServerUris((ListOfString)newValue);
				return;
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__LOCALE_IDS:
				setLocaleIds((ListOfString)newValue);
				return;
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVICE_ID:
				setServiceId((Long)newValue);
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
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__URIS_VERSION:
				unsetUrisVersion();
				return;
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__NAMESPACE_URIS:
				unsetNamespaceUris();
				return;
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVER_URIS:
				unsetServerUris();
				return;
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__LOCALE_IDS:
				unsetLocaleIds();
				return;
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVICE_ID:
				unsetServiceId();
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
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__URIS_VERSION:
				return isSetUrisVersion();
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__NAMESPACE_URIS:
				return isSetNamespaceUris();
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVER_URIS:
				return isSetServerUris();
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__LOCALE_IDS:
				return isSetLocaleIds();
			case TypesPackage.SESSIONLESS_INVOKE_REQUEST_TYPE__SERVICE_ID:
				return isSetServiceId();
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
		result.append(" (serviceId: ");
		if (serviceIdESet) result.append(serviceId); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //SessionlessInvokeRequestTypeImpl
