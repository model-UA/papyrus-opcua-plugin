/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HasChild.Aggregates.HasComponent.HasDataSetReader.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HasChild.Aggregates.HasComponent.HasDataSetReader.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HasDataSetReaderFactoryImpl extends EFactoryImpl implements HasDataSetReaderFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HasDataSetReaderFactory init() {
		try {
			HasDataSetReaderFactory theHasDataSetReaderFactory = (HasDataSetReaderFactory)EPackage.Registry.INSTANCE.getEFactory(HasDataSetReaderPackage.eNS_URI);
			if (theHasDataSetReaderFactory != null) {
				return theHasDataSetReaderFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new HasDataSetReaderFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasDataSetReaderFactoryImpl() {
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
			case HasDataSetReaderPackage.INVERSE_NAME: return createInverseName();
			case HasDataSetReaderPackage.BROWSE_NAME: return createBrowseName();
			case HasDataSetReaderPackage.DISPLAY_NAME: return createDisplayName();
			case HasDataSetReaderPackage.NODE_ID: return createNodeId();
			case HasDataSetReaderPackage.HAS_DATA_SET_READER: return createHasDataSetReader();
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
	public HasDataSetReader createHasDataSetReader() {
		HasDataSetReaderImpl hasDataSetReader = new HasDataSetReaderImpl();
		return hasDataSetReader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HasDataSetReaderPackage getHasDataSetReaderPackage() {
		return (HasDataSetReaderPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static HasDataSetReaderPackage getPackage() {
		return HasDataSetReaderPackage.eINSTANCE;
	}

} //HasDataSetReaderFactoryImpl
