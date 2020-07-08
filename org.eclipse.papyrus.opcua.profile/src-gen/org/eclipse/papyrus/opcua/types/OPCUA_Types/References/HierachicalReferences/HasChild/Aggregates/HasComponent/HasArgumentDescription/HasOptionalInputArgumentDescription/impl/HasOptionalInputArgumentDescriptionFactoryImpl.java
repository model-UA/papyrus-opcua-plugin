/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HasChild.Aggregates.HasComponent.HasArgumentDescription.HasOptionalInputArgumentDescription.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HasChild.Aggregates.HasComponent.HasArgumentDescription.HasOptionalInputArgumentDescription.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HasOptionalInputArgumentDescriptionFactoryImpl extends EFactoryImpl implements HasOptionalInputArgumentDescriptionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HasOptionalInputArgumentDescriptionFactory init() {
		try {
			HasOptionalInputArgumentDescriptionFactory theHasOptionalInputArgumentDescriptionFactory = (HasOptionalInputArgumentDescriptionFactory)EPackage.Registry.INSTANCE.getEFactory(HasOptionalInputArgumentDescriptionPackage.eNS_URI);
			if (theHasOptionalInputArgumentDescriptionFactory != null) {
				return theHasOptionalInputArgumentDescriptionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new HasOptionalInputArgumentDescriptionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasOptionalInputArgumentDescriptionFactoryImpl() {
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
			case HasOptionalInputArgumentDescriptionPackage.INVERSE_NAME: return createInverseName();
			case HasOptionalInputArgumentDescriptionPackage.BROWSE_NAME: return createBrowseName();
			case HasOptionalInputArgumentDescriptionPackage.DISPLAY_NAME: return createDisplayName();
			case HasOptionalInputArgumentDescriptionPackage.NODE_ID: return createNodeId();
			case HasOptionalInputArgumentDescriptionPackage.HAS_OPTIONAL_INPUT_ARGUMENT_DESCRIPTION: return createHasOptionalInputArgumentDescription();
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
	public HasOptionalInputArgumentDescription createHasOptionalInputArgumentDescription() {
		HasOptionalInputArgumentDescriptionImpl hasOptionalInputArgumentDescription = new HasOptionalInputArgumentDescriptionImpl();
		return hasOptionalInputArgumentDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HasOptionalInputArgumentDescriptionPackage getHasOptionalInputArgumentDescriptionPackage() {
		return (HasOptionalInputArgumentDescriptionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static HasOptionalInputArgumentDescriptionPackage getPackage() {
		return HasOptionalInputArgumentDescriptionPackage.eINSTANCE;
	}

} //HasOptionalInputArgumentDescriptionFactoryImpl
