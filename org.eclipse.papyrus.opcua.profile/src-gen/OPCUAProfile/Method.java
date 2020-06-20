/**
 */
package OPCUAProfile;

import java.lang.Object;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link OPCUAProfile.Method#getExecutable <em>Executable</em>}</li>
 *   <li>{@link OPCUAProfile.Method#getUserExecutable <em>User Executable</em>}</li>
 *   <li>{@link OPCUAProfile.Method#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 *
 * @see OPCUAProfile.OPCUAProfilePackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends BaseNodeClass {
	/**
	 * Returns the value of the '<em><b>Executable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executable</em>' attribute.
	 * @see #setExecutable(Boolean)
	 * @see OPCUAProfile.OPCUAProfilePackage#getMethod_Executable()
	 * @model dataType="OPCUAProfile.DataTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	Object getExecutable();

	/**
	 * Sets the value of the '{@link OPCUAProfile.Method#getExecutable <em>Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Executable</em>' attribute.
	 * @see #getExecutable()
	 * @generated
	 */
	void setExecutable(Object value);

	/**
	 * Returns the value of the '<em><b>User Executable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Executable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Executable</em>' attribute.
	 * @see #setUserExecutable(Boolean)
	 * @see OPCUAProfile.OPCUAProfilePackage#getMethod_UserExecutable()
	 * @model dataType="OPCUAProfile.DataTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	Object getUserExecutable();

	/**
	 * Sets the value of the '{@link OPCUAProfile.Method#getUserExecutable <em>User Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Executable</em>' attribute.
	 * @see #getUserExecutable()
	 * @generated
	 */
	void setUserExecutable(Object value);

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
	 * @see OPCUAProfile.OPCUAProfilePackage#getMethod_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link OPCUAProfile.Method#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // Method
