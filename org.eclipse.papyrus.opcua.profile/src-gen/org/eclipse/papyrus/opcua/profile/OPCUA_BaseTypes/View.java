/**
 */
package org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes;

import org.eclipse.uml2.uml.Stereotype;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View#isContainsNoLoops <em>Contains No Loops</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View#getEventNotifier <em>Event Notifier</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View#getBase_Stereotype <em>Base Stereotype</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getView()
 * @model
 * @generated
 */
public interface View extends BaseNodeClass {
	/**
	 * Returns the value of the '<em><b>Contains No Loops</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contains No Loops</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contains No Loops</em>' attribute.
	 * @see #setContainsNoLoops(boolean)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getView_ContainsNoLoops()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isContainsNoLoops();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View#isContainsNoLoops <em>Contains No Loops</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contains No Loops</em>' attribute.
	 * @see #isContainsNoLoops()
	 * @generated
	 */
	void setContainsNoLoops(boolean value);

	/**
	 * Returns the value of the '<em><b>Event Notifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Notifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Notifier</em>' attribute.
	 * @see #setEventNotifier(byte)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getView_EventNotifier()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.UInteger.Byte" required="true" ordered="false"
	 * @generated
	 */
	byte getEventNotifier();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View#getEventNotifier <em>Event Notifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Notifier</em>' attribute.
	 * @see #getEventNotifier()
	 * @generated
	 */
	void setEventNotifier(byte value);

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
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getView_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

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
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getView_Base_Stereotype()
	 * @model ordered="false"
	 * @generated
	 */
	Stereotype getBase_Stereotype();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View#getBase_Stereotype <em>Base Stereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Stereotype</em>' reference.
	 * @see #getBase_Stereotype()
	 * @generated
	 */
	void setBase_Stereotype(Stereotype value);

} // View
