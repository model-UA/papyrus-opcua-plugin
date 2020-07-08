/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.AlwaysGeneratesEvent.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.AlwaysGeneratesEvent.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlwaysGeneratesEventFactoryImpl extends EFactoryImpl implements AlwaysGeneratesEventFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AlwaysGeneratesEventFactory init() {
		try {
			AlwaysGeneratesEventFactory theAlwaysGeneratesEventFactory = (AlwaysGeneratesEventFactory)EPackage.Registry.INSTANCE.getEFactory(AlwaysGeneratesEventPackage.eNS_URI);
			if (theAlwaysGeneratesEventFactory != null) {
				return theAlwaysGeneratesEventFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AlwaysGeneratesEventFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlwaysGeneratesEventFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AlwaysGeneratesEventPackage.INVERSE_NAME: return createInverseName();
			case AlwaysGeneratesEventPackage.BROWSE_NAME: return createBrowseName();
			case AlwaysGeneratesEventPackage.DISPLAY_NAME: return createDisplayName();
			case AlwaysGeneratesEventPackage.NODE_ID: return createNodeId();
			case AlwaysGeneratesEventPackage.ALWAYS_GENERATES_EVENT: return createAlwaysGeneratesEvent();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InverseName createInverseName() {
		InverseNameImpl inverseName = new InverseNameImpl();
		return inverseName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BrowseName createBrowseName() {
		BrowseNameImpl browseName = new BrowseNameImpl();
		return browseName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DisplayName createDisplayName() {
		DisplayNameImpl displayName = new DisplayNameImpl();
		return displayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NodeId createNodeId() {
		NodeIdImpl nodeId = new NodeIdImpl();
		return nodeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AlwaysGeneratesEvent createAlwaysGeneratesEvent() {
		AlwaysGeneratesEventImpl alwaysGeneratesEvent = new AlwaysGeneratesEventImpl();
		return alwaysGeneratesEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AlwaysGeneratesEventPackage getAlwaysGeneratesEventPackage() {
		return (AlwaysGeneratesEventPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AlwaysGeneratesEventPackage getPackage() {
		return AlwaysGeneratesEventPackage.eINSTANCE;
	}

} //AlwaysGeneratesEventFactoryImpl
