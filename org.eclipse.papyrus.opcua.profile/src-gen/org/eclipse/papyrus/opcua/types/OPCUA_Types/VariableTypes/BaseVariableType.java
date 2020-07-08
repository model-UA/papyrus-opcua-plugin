/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Variable Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.BaseVariableType#getBase_Variable <em>Base Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.VariableTypesPackage#getBaseVariableType()
 * @model
 * @generated
 */
public interface BaseVariableType extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Variable</em>' reference.
	 * @see #setBase_Variable(Variable)
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.VariableTypesPackage#getBaseVariableType_Base_Variable()
	 * @model ordered="false"
	 * @generated
	 */
	Variable getBase_Variable();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.VariableTypes.BaseVariableType#getBase_Variable <em>Base Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Variable</em>' reference.
	 * @see #getBase_Variable()
	 * @generated
	 */
	void setBase_Variable(Variable value);

} // BaseVariableType
