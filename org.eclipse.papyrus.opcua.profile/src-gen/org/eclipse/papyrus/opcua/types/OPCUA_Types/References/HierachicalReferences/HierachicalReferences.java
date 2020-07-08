/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.References;

import org.eclipse.uml2.uml.Association;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hierachical References</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HierachicalReferences#getBase_Association <em>Base Association</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HierachicalReferencesPackage#getHierachicalReferences()
 * @model
 * @generated
 */
public interface HierachicalReferences extends References {
	/**
	 * Returns the value of the '<em><b>Base Association</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Association</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Association</em>' reference.
	 * @see #setBase_Association(Association)
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HierachicalReferencesPackage#getHierachicalReferences_Base_Association()
	 * @model ordered="false"
	 * @generated
	 */
	Association getBase_Association();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HierachicalReferences#getBase_Association <em>Base Association</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Association</em>' reference.
	 * @see #getBase_Association()
	 * @generated
	 */
	void setBase_Association(Association value);

} // HierachicalReferences
