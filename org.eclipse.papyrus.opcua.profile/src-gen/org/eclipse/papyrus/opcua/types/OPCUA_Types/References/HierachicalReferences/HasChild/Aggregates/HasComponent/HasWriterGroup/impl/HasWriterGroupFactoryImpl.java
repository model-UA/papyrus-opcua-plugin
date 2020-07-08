/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HasChild.Aggregates.HasComponent.HasWriterGroup.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HasChild.Aggregates.HasComponent.HasWriterGroup.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HasWriterGroupFactoryImpl extends EFactoryImpl implements HasWriterGroupFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HasWriterGroupFactory init() {
		try {
			HasWriterGroupFactory theHasWriterGroupFactory = (HasWriterGroupFactory)EPackage.Registry.INSTANCE.getEFactory(HasWriterGroupPackage.eNS_URI);
			if (theHasWriterGroupFactory != null) {
				return theHasWriterGroupFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new HasWriterGroupFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasWriterGroupFactoryImpl() {
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
			case HasWriterGroupPackage.INVERSE_NAME: return createInverseName();
			case HasWriterGroupPackage.BROWSE_NAME: return createBrowseName();
			case HasWriterGroupPackage.DISPLAY_NAME: return createDisplayName();
			case HasWriterGroupPackage.NODE_ID: return createNodeId();
			case HasWriterGroupPackage.HAS_WRITER_GROUP: return createHasWriterGroup();
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
	public HasWriterGroup createHasWriterGroup() {
		HasWriterGroupImpl hasWriterGroup = new HasWriterGroupImpl();
		return hasWriterGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HasWriterGroupPackage getHasWriterGroupPackage() {
		return (HasWriterGroupPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static HasWriterGroupPackage getPackage() {
		return HasWriterGroupPackage.eINSTANCE;
	}

} //HasWriterGroupFactoryImpl
