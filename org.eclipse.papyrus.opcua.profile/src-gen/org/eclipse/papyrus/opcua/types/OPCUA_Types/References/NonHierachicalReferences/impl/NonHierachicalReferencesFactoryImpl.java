/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NonHierachicalReferencesFactoryImpl extends EFactoryImpl implements NonHierachicalReferencesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NonHierachicalReferencesFactory init() {
		try {
			NonHierachicalReferencesFactory theNonHierachicalReferencesFactory = (NonHierachicalReferencesFactory)EPackage.Registry.INSTANCE.getEFactory(NonHierachicalReferencesPackage.eNS_URI);
			if (theNonHierachicalReferencesFactory != null) {
				return theNonHierachicalReferencesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NonHierachicalReferencesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonHierachicalReferencesFactoryImpl() {
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
			case NonHierachicalReferencesPackage.NON_HIERACHICAL_REFERENCES: return createNonHierachicalReferences();
			case NonHierachicalReferencesPackage.NODE_ID: return createNodeId();
			case NonHierachicalReferencesPackage.DISPLAY_NAME: return createDisplayName();
			case NonHierachicalReferencesPackage.BROWSE_NAME: return createBrowseName();
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
	public NonHierachicalReferences createNonHierachicalReferences() {
		NonHierachicalReferencesImpl nonHierachicalReferences = new NonHierachicalReferencesImpl();
		return nonHierachicalReferences;
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
	public NonHierachicalReferencesPackage getNonHierachicalReferencesPackage() {
		return (NonHierachicalReferencesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NonHierachicalReferencesPackage getPackage() {
		return NonHierachicalReferencesPackage.eINSTANCE;
	}

} //NonHierachicalReferencesFactoryImpl
