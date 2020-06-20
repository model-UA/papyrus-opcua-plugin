/**
 */
package OPCUAProfile.ReferenceTypes.References;

import OPCUAProfile.BaseNodeClass;

import OPCUAProfile.DataTypes.LocalizedText;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link OPCUAProfile.ReferenceTypes.References.ReferenceType#getIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link OPCUAProfile.ReferenceTypes.References.ReferenceType#getSymmetric <em>Symmetric</em>}</li>
 *   <li>{@link OPCUAProfile.ReferenceTypes.References.ReferenceType#getInverseName <em>Inverse Name</em>}</li>
 *   <li>{@link OPCUAProfile.ReferenceTypes.References.ReferenceType#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 *
 * @see OPCUAProfile.ReferenceTypes.References.ReferencesPackage#getReferenceType()
 * @model
 * @generated
 */
public interface ReferenceType extends BaseNodeClass {
	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(Boolean)
	 * @see OPCUAProfile.ReferenceTypes.References.ReferencesPackage#getReferenceType_IsAbstract()
	 * @model dataType="OPCUAProfile.DataTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	Object getIsAbstract();

	/**
	 * Sets the value of the '{@link OPCUAProfile.ReferenceTypes.References.ReferenceType#getIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #getIsAbstract()
	 * @generated
	 */
	void setIsAbstract(Object value);

	/**
	 * Returns the value of the '<em><b>Symmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symmetric</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symmetric</em>' attribute.
	 * @see #setSymmetric(Boolean)
	 * @see OPCUAProfile.ReferenceTypes.References.ReferencesPackage#getReferenceType_Symmetric()
	 * @model dataType="OPCUAProfile.DataTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	Object getSymmetric();

	/**
	 * Sets the value of the '{@link OPCUAProfile.ReferenceTypes.References.ReferenceType#getSymmetric <em>Symmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symmetric</em>' attribute.
	 * @see #getSymmetric()
	 * @generated
	 */
	void setSymmetric(Object value);

	/**
	 * Returns the value of the '<em><b>Inverse Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inverse Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inverse Name</em>' reference.
	 * @see #setInverseName(LocalizedText)
	 * @see OPCUAProfile.ReferenceTypes.References.ReferencesPackage#getReferenceType_InverseName()
	 * @model ordered="false"
	 * @generated
	 */
	LocalizedText getInverseName();

	/**
	 * Sets the value of the '{@link OPCUAProfile.ReferenceTypes.References.ReferenceType#getInverseName <em>Inverse Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inverse Name</em>' reference.
	 * @see #getInverseName()
	 * @generated
	 */
	void setInverseName(LocalizedText value);

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see OPCUAProfile.ReferenceTypes.References.ReferencesPackage#getReferenceType_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link OPCUAProfile.ReferenceTypes.References.ReferenceType#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // ReferenceType
