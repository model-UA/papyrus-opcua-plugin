/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.HasModellingRule.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.HasModellingRule.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HasModellingRuleFactoryImpl extends EFactoryImpl implements HasModellingRuleFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HasModellingRuleFactory init() {
		try {
			HasModellingRuleFactory theHasModellingRuleFactory = (HasModellingRuleFactory)EPackage.Registry.INSTANCE.getEFactory(HasModellingRulePackage.eNS_URI);
			if (theHasModellingRuleFactory != null) {
				return theHasModellingRuleFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new HasModellingRuleFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasModellingRuleFactoryImpl() {
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
			case HasModellingRulePackage.INVERSE_NAME: return createInverseName();
			case HasModellingRulePackage.BROWSE_NAME: return createBrowseName();
			case HasModellingRulePackage.DISPLAY_NAME: return createDisplayName();
			case HasModellingRulePackage.NODE_ID: return createNodeId();
			case HasModellingRulePackage.HAS_MODELLING_RULE: return createHasModellingRule();
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
	public HasModellingRule createHasModellingRule() {
		HasModellingRuleImpl hasModellingRule = new HasModellingRuleImpl();
		return hasModellingRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HasModellingRulePackage getHasModellingRulePackage() {
		return (HasModellingRulePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static HasModellingRulePackage getPackage() {
		return HasModellingRulePackage.eINSTANCE;
	}

} //HasModellingRuleFactoryImpl
