/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.HasEffect.HasEffectUnsuppressed.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.HasEffect.HasEffectUnsuppressed.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HasEffectUnsuppressedFactoryImpl extends EFactoryImpl implements HasEffectUnsuppressedFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HasEffectUnsuppressedFactory init() {
		try {
			HasEffectUnsuppressedFactory theHasEffectUnsuppressedFactory = (HasEffectUnsuppressedFactory)EPackage.Registry.INSTANCE.getEFactory(HasEffectUnsuppressedPackage.eNS_URI);
			if (theHasEffectUnsuppressedFactory != null) {
				return theHasEffectUnsuppressedFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new HasEffectUnsuppressedFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasEffectUnsuppressedFactoryImpl() {
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
			case HasEffectUnsuppressedPackage.INVERSE_NAME: return createInverseName();
			case HasEffectUnsuppressedPackage.BROWSE_NAME: return createBrowseName();
			case HasEffectUnsuppressedPackage.DISPLAY_NAME: return createDisplayName();
			case HasEffectUnsuppressedPackage.NODE_ID: return createNodeId();
			case HasEffectUnsuppressedPackage.HAS_EFFECT_UNSUPPRESSED: return createHasEffectUnsuppressed();
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
	public HasEffectUnsuppressed createHasEffectUnsuppressed() {
		HasEffectUnsuppressedImpl hasEffectUnsuppressed = new HasEffectUnsuppressedImpl();
		return hasEffectUnsuppressed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HasEffectUnsuppressedPackage getHasEffectUnsuppressedPackage() {
		return (HasEffectUnsuppressedPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static HasEffectUnsuppressedPackage getPackage() {
		return HasEffectUnsuppressedPackage.eINSTANCE;
	}

} //HasEffectUnsuppressedFactoryImpl
