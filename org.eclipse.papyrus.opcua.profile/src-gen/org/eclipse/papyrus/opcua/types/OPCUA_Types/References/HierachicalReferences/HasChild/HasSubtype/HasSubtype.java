/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HasChild.HasSubtype;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HasChild.HasChild;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HierachicalReferences;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.References;

import org.eclipse.uml2.uml.Generalization;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Has Subtype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HasChild.HasSubtype.HasSubtype#getBase_Generalization <em>Base Generalization</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HasChild.HasSubtype.HasSubtypePackage#getHasSubtype()
 * @model
 * @generated
 */
public interface HasSubtype extends HasChild, HierachicalReferences, References {
	/**
	 * Returns the value of the '<em><b>Base Generalization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Generalization</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Generalization</em>' reference.
	 * @see #setBase_Generalization(Generalization)
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HasChild.HasSubtype.HasSubtypePackage#getHasSubtype_Base_Generalization()
	 * @model ordered="false"
	 * @generated
	 */
	Generalization getBase_Generalization();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.types.OPCUA_Types.References.HierachicalReferences.HasChild.HasSubtype.HasSubtype#getBase_Generalization <em>Base Generalization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Generalization</em>' reference.
	 * @see #getBase_Generalization()
	 * @generated
	 */
	void setBase_Generalization(Generalization value);

} // HasSubtype
