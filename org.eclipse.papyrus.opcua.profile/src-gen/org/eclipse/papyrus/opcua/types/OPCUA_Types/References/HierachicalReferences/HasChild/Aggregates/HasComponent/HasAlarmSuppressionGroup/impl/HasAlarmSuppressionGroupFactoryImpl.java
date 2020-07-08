/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HasChild.Aggregates.HasComponent.HasAlarmSuppressionGroup.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HasChild.Aggregates.HasComponent.HasAlarmSuppressionGroup.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HasAlarmSuppressionGroupFactoryImpl extends EFactoryImpl implements HasAlarmSuppressionGroupFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HasAlarmSuppressionGroupFactory init() {
		try {
			HasAlarmSuppressionGroupFactory theHasAlarmSuppressionGroupFactory = (HasAlarmSuppressionGroupFactory)EPackage.Registry.INSTANCE.getEFactory(HasAlarmSuppressionGroupPackage.eNS_URI);
			if (theHasAlarmSuppressionGroupFactory != null) {
				return theHasAlarmSuppressionGroupFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new HasAlarmSuppressionGroupFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasAlarmSuppressionGroupFactoryImpl() {
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
			case HasAlarmSuppressionGroupPackage.INVERSE_NAME: return createInverseName();
			case HasAlarmSuppressionGroupPackage.BROWSE_NAME: return createBrowseName();
			case HasAlarmSuppressionGroupPackage.DISPLAY_NAME: return createDisplayName();
			case HasAlarmSuppressionGroupPackage.NODE_ID: return createNodeId();
			case HasAlarmSuppressionGroupPackage.HAS_ALARM_SUPPRESSION_GROUP: return createHasAlarmSuppressionGroup();
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
	public HasAlarmSuppressionGroup createHasAlarmSuppressionGroup() {
		HasAlarmSuppressionGroupImpl hasAlarmSuppressionGroup = new HasAlarmSuppressionGroupImpl();
		return hasAlarmSuppressionGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HasAlarmSuppressionGroupPackage getHasAlarmSuppressionGroupPackage() {
		return (HasAlarmSuppressionGroupPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static HasAlarmSuppressionGroupPackage getPackage() {
		return HasAlarmSuppressionGroupPackage.eINSTANCE;
	}

} //HasAlarmSuppressionGroupFactoryImpl
