/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.DataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.QualifiedName#getNamespaceIndex <em>Namespace Index</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.QualifiedName#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.QualifiedName#getBase_DataType <em>Base Data Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage#getQualifiedName()
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
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage#getQualifiedName_NamespaceIndex()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.Int32" required="true" ordered="false"
	 * @generated
	 */
	int getNamespaceIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.QualifiedName#getNamespaceIndex <em>Namespace Index</em>}' attribute.
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
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage#getQualifiedName_Name()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.String" required="true" ordered="false"
	 * @generated
	 */
	Object getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.QualifiedName#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(Object value);

	/**
	 * Returns the value of the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Data Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Data Type</em>' reference.
	 * @see #setBase_DataType(DataType)
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage#getQualifiedName_Base_DataType()
	 * @model ordered="false"
	 * @generated
	 */
	DataType getBase_DataType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.QualifiedName#getBase_DataType <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Data Type</em>' reference.
	 * @see #getBase_DataType()
	 * @generated
	 */
	void setBase_DataType(DataType value);

} // QualifiedName
