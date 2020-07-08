/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.AlwaysGeneratesEvent.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HierachicalReferences;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.AlwaysGeneratesEvent.*;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.GeneratesEvent;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.References;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.AlwaysGeneratesEvent.AlwaysGeneratesEventPackage
 * @generated
 */
public class AlwaysGeneratesEventAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AlwaysGeneratesEventPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlwaysGeneratesEventAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AlwaysGeneratesEventPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlwaysGeneratesEventSwitch<Adapter> modelSwitch =
		new AlwaysGeneratesEventSwitch<Adapter>() {
			@Override
			public Adapter caseInverseName(InverseName object) {
				return createInverseNameAdapter();
			}
			@Override
			public Adapter caseBrowseName(BrowseName object) {
				return createBrowseNameAdapter();
			}
			@Override
			public Adapter caseDisplayName(DisplayName object) {
				return createDisplayNameAdapter();
			}
			@Override
			public Adapter caseNodeId(NodeId object) {
				return createNodeIdAdapter();
			}
			@Override
			public Adapter caseAlwaysGeneratesEvent(AlwaysGeneratesEvent object) {
				return createAlwaysGeneratesEventAdapter();
			}
			@Override
			public Adapter caseReferences(References object) {
				return createReferencesAdapter();
			}
			@Override
			public Adapter caseHierachicalReferences(HierachicalReferences object) {
				return createHierachicalReferencesAdapter();
			}
			@Override
			public Adapter caseGeneratesEvent(GeneratesEvent object) {
				return createGeneratesEventAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.AlwaysGeneratesEvent.InverseName <em>Inverse Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.AlwaysGeneratesEvent.InverseName
	 * @generated
	 */
	public Adapter createInverseNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.AlwaysGeneratesEvent.BrowseName <em>Browse Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.AlwaysGeneratesEvent.BrowseName
	 * @generated
	 */
	public Adapter createBrowseNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.AlwaysGeneratesEvent.DisplayName <em>Display Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.AlwaysGeneratesEvent.DisplayName
	 * @generated
	 */
	public Adapter createDisplayNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.AlwaysGeneratesEvent.NodeId <em>Node Id</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.AlwaysGeneratesEvent.NodeId
	 * @generated
	 */
	public Adapter createNodeIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.AlwaysGeneratesEvent.AlwaysGeneratesEvent <em>Always Generates Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.AlwaysGeneratesEvent.AlwaysGeneratesEvent
	 * @generated
	 */
	public Adapter createAlwaysGeneratesEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.References.References <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.References.References
	 * @generated
	 */
	public Adapter createReferencesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HierachicalReferences <em>Hierachical References</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HierachicalReferences
	 * @generated
	 */
	public Adapter createHierachicalReferencesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.GeneratesEvent <em>Generates Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.GeneratesEvent.GeneratesEvent
	 * @generated
	 */
	public Adapter createGeneratesEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AlwaysGeneratesEventAdapterFactory
