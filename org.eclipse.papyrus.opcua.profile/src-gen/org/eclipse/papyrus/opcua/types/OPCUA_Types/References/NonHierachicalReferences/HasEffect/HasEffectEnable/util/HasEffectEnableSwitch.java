/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.HasEffect.HasEffectEnable.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HierachicalReferences;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.HasEffect.HasEffect;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.HasEffect.HasEffectEnable.*;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.References;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.HasEffect.HasEffectEnable.HasEffectEnablePackage
 * @generated
 */
public class HasEffectEnableSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static HasEffectEnablePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasEffectEnableSwitch() {
		if (modelPackage == null) {
			modelPackage = HasEffectEnablePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case HasEffectEnablePackage.INVERSE_NAME: {
				InverseName inverseName = (InverseName)theEObject;
				T result = caseInverseName(inverseName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HasEffectEnablePackage.BROWSE_NAME: {
				BrowseName browseName = (BrowseName)theEObject;
				T result = caseBrowseName(browseName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HasEffectEnablePackage.DISPLAY_NAME: {
				DisplayName displayName = (DisplayName)theEObject;
				T result = caseDisplayName(displayName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HasEffectEnablePackage.NODE_ID: {
				NodeId nodeId = (NodeId)theEObject;
				T result = caseNodeId(nodeId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HasEffectEnablePackage.HAS_EFFECT_ENABLE: {
				HasEffectEnable hasEffectEnable = (HasEffectEnable)theEObject;
				T result = caseHasEffectEnable(hasEffectEnable);
				if (result == null) result = caseHasEffect(hasEffectEnable);
				if (result == null) result = caseHierachicalReferences(hasEffectEnable);
				if (result == null) result = caseReferences(hasEffectEnable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inverse Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inverse Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInverseName(InverseName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Browse Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Browse Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBrowseName(BrowseName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Display Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Display Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDisplayName(DisplayName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Id</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeId(NodeId object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Effect Enable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Effect Enable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasEffectEnable(HasEffectEnable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>References</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>References</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferences(References object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hierachical References</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hierachical References</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHierachicalReferences(HierachicalReferences object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Effect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Effect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasEffect(HasEffect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //HasEffectEnableSwitch
