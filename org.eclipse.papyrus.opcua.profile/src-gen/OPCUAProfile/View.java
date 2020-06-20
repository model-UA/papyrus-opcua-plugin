/**
 */
package OPCUAProfile;

import java.lang.Object;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link OPCUAProfile.View#getContainsNoLoops <em>Contains No Loops</em>}</li>
 *   <li>{@link OPCUAProfile.View#getEventNotifier <em>Event Notifier</em>}</li>
 *   <li>{@link OPCUAProfile.View#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 *
 * @see OPCUAProfile.OPCUAProfilePackage#getView()
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
	 * @see #setContainsNoLoops(Boolean)
	 * @see OPCUAProfile.OPCUAProfilePackage#getView_ContainsNoLoops()
	 * @model dataType="OPCUAProfile.DataTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	Object getContainsNoLoops();

	/**
	 * Sets the value of the '{@link OPCUAProfile.View#getContainsNoLoops <em>Contains No Loops</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contains No Loops</em>' attribute.
	 * @see #getContainsNoLoops()
	 * @generated
	 */
	void setContainsNoLoops(Object value);

	/**
	 * Returns the value of the '<em><b>Event Notifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Notifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Notifier</em>' attribute.
	 * @see #setEventNotifier(Byte)
	 * @see OPCUAProfile.OPCUAProfilePackage#getView_EventNotifier()
	 * @model dataType="OPCUAProfile.DataTypes.Number.UInteger.Byte" required="true" ordered="false"
	 * @generated
	 */
	Object getEventNotifier();

	/**
	 * Sets the value of the '{@link OPCUAProfile.View#getEventNotifier <em>Event Notifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Notifier</em>' attribute.
	 * @see #getEventNotifier()
	 * @generated
	 */
	void setEventNotifier(Object value);

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
	 * @see OPCUAProfile.OPCUAProfilePackage#getView_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link OPCUAProfile.View#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // View
