/**
 */
package OPCUAProfile.DataTypes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link OPCUAProfile.DataTypes.QualifiedName#getNamespaceIndex <em>Namespace Index</em>}</li>
 *   <li>{@link OPCUAProfile.DataTypes.QualifiedName#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see OPCUAProfile.DataTypes.DataTypesPackage#getQualifiedName()
 * @model
 * @generated
 */
public interface QualifiedName extends EObject {
	/**
	 * Returns the value of the '<em><b>Namespace Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace Index</em>' attribute.
	 * @see #setNamespaceIndex(int)
	 * @see OPCUAProfile.DataTypes.DataTypesPackage#getQualifiedName_NamespaceIndex()
	 * @model dataType="OPCUAProfile.DataTypes.Number.Integer.Int32" required="true" ordered="false"
	 * @generated
	 */
	int getNamespaceIndex();

	/**
	 * Sets the value of the '{@link OPCUAProfile.DataTypes.QualifiedName#getNamespaceIndex <em>Namespace Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace Index</em>' attribute.
	 * @see #getNamespaceIndex()
	 * @generated
	 */
	void setNamespaceIndex(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see OPCUAProfile.DataTypes.DataTypesPackage#getQualifiedName_Name()
	 * @model dataType="OPCUAProfile.DataTypes.String" required="true" ordered="false"
	 * @generated
	 */
	Object getName();

	/**
	 * Sets the value of the '{@link OPCUAProfile.DataTypes.QualifiedName#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(Object value);

} // QualifiedName
