/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.Organizes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.Organizes.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OrganizesFactoryImpl extends EFactoryImpl implements OrganizesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OrganizesFactory init() {
		try {
			OrganizesFactory theOrganizesFactory = (OrganizesFactory)EPackage.Registry.INSTANCE.getEFactory(OrganizesPackage.eNS_URI);
			if (theOrganizesFactory != null) {
				return theOrganizesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OrganizesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizesFactoryImpl() {
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
			case OrganizesPackage.DISPLAY_NAME: return createDisplayName();
			case OrganizesPackage.NODE_ID: return createNodeId();
			case OrganizesPackage.BROWSE_NAME: return createBrowseName();
			case OrganizesPackage.INVERSE_NAME: return createInverseName();
			case OrganizesPackage.ORGANIZES: return createOrganizes();
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
	public Organizes createOrganizes() {
		OrganizesImpl organizes = new OrganizesImpl();
		return organizes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OrganizesPackage getOrganizesPackage() {
		return (OrganizesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OrganizesPackage getPackage() {
		return OrganizesPackage.eINSTANCE;
	}

} //OrganizesFactoryImpl
