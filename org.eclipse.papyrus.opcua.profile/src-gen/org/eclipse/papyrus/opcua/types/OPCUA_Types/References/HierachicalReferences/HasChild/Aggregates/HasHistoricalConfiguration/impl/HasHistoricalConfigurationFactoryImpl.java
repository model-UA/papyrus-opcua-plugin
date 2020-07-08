/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HasChild.Aggregates.HasHistoricalConfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HasChild.Aggregates.HasHistoricalConfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HasHistoricalConfigurationFactoryImpl extends EFactoryImpl implements HasHistoricalConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HasHistoricalConfigurationFactory init() {
		try {
			HasHistoricalConfigurationFactory theHasHistoricalConfigurationFactory = (HasHistoricalConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(HasHistoricalConfigurationPackage.eNS_URI);
			if (theHasHistoricalConfigurationFactory != null) {
				return theHasHistoricalConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new HasHistoricalConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasHistoricalConfigurationFactoryImpl() {
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
			case HasHistoricalConfigurationPackage.INVERSE_NAME: return createInverseName();
			case HasHistoricalConfigurationPackage.BROWSE_NAME: return createBrowseName();
			case HasHistoricalConfigurationPackage.DISPLAY_NAME: return createDisplayName();
			case HasHistoricalConfigurationPackage.NODE_ID: return createNodeId();
			case HasHistoricalConfigurationPackage.HAS_HISTORICAL_CONFIGURATION: return createHasHistoricalConfiguration();
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
	public HasHistoricalConfiguration createHasHistoricalConfiguration() {
		HasHistoricalConfigurationImpl hasHistoricalConfiguration = new HasHistoricalConfigurationImpl();
		return hasHistoricalConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HasHistoricalConfigurationPackage getHasHistoricalConfigurationPackage() {
		return (HasHistoricalConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static HasHistoricalConfigurationPackage getPackage() {
		return HasHistoricalConfigurationPackage.eINSTANCE;
	}

} //HasHistoricalConfigurationFactoryImpl
