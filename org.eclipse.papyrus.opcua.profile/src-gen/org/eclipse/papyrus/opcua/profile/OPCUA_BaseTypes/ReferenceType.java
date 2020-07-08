/**
 */
package org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.LocalizedText;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Stereotype;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#isSymmetric <em>Symmetric</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#getInverseName <em>Inverse Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#getBase_Stereotype <em>Base Stereotype</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#getBase_Association <em>Base Association</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getReferenceType()
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
	 * @see #setIsAbstract(boolean)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getReferenceType_IsAbstract()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Symmetric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symmetric</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symmetric</em>' attribute.
	 * @see #setSymmetric(boolean)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getReferenceType_Symmetric()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isSymmetric();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#isSymmetric <em>Symmetric</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symmetric</em>' attribute.
	 * @see #isSymmetric()
	 * @generated
	 */
	void setSymmetric(boolean value);

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
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getReferenceType_InverseName()
	 * @model ordered="false"
	 * @generated
	 */
	LocalizedText getInverseName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#getInverseName <em>Inverse Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inverse Name</em>' reference.
	 * @see #getInverseName()
	 * @generated
	 */
	void setInverseName(LocalizedText value);

	/**
	 * Returns the value of the '<em><b>Base Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Stereotype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Stereotype</em>' reference.
	 * @see #setBase_Stereotype(Stereotype)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getReferenceType_Base_Stereotype()
	 * @model ordered="false"
	 * @generated
	 */
	Stereotype getBase_Stereotype();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#getBase_Stereotype <em>Base Stereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Stereotype</em>' reference.
	 * @see #getBase_Stereotype()
	 * @generated
	 */
	void setBase_Stereotype(Stereotype value);

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
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getReferenceType_Base_Association()
	 * @model ordered="false"
	 * @generated
	 */
	Association getBase_Association();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType#getBase_Association <em>Base Association</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Association</em>' reference.
	 * @see #getBase_Association()
	 * @generated
	 */
	void setBase_Association(Association value);

} // ReferenceType
