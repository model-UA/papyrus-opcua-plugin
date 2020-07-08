/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.DataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Id</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeId#getNodeIdType <em>Node Id Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeId#getStringNodeId <em>String Node Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeId#getNumericNodeId <em>Numeric Node Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeId#getGuidNodeId <em>Guid Node Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeId#getBase_DataType <em>Base Data Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage#getNodeId()
 * @model
 * @generated
 */
public interface NodeId extends EObject {
	/**
	 * Returns the value of the '<em><b>Node Id Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeIdType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Id Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Id Type</em>' attribute.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeIdType
	 * @see #setNodeIdType(NodeIdType)
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage#getNodeId_NodeIdType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NodeIdType getNodeIdType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeId#getNodeIdType <em>Node Id Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Id Type</em>' attribute.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeIdType
	 * @see #getNodeIdType()
	 * @generated
	 */
	void setNodeIdType(NodeIdType value);

	/**
	 * Returns the value of the '<em><b>String Node Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Node Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Node Id</em>' attribute.
	 * @see #setStringNodeId(String)
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage#getNodeId_StringNodeId()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.String" required="true" ordered="false"
	 * @generated
	 */
	Object getStringNodeId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeId#getStringNodeId <em>String Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Node Id</em>' attribute.
	 * @see #getStringNodeId()
	 * @generated
	 */
	void setStringNodeId(Object value);

	/**
	 * Returns the value of the '<em><b>Numeric Node Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Numeric Node Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numeric Node Id</em>' attribute.
	 * @see #setNumericNodeId(int)
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage#getNodeId_NumericNodeId()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.Int32" required="true" ordered="false"
	 * @generated
	 */
	int getNumericNodeId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeId#getNumericNodeId <em>Numeric Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Numeric Node Id</em>' attribute.
	 * @see #getNumericNodeId()
	 * @generated
	 */
	void setNumericNodeId(int value);

	/**
	 * Returns the value of the '<em><b>Guid Node Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guid Node Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guid Node Id</em>' attribute.
	 * @see #setGuidNodeId(String)
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage#getNodeId_GuidNodeId()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.String" required="true" ordered="false"
	 * @generated
	 */
	Object getGuidNodeId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeId#getGuidNodeId <em>Guid Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guid Node Id</em>' attribute.
	 * @see #getGuidNodeId()
	 * @generated
	 */
	void setGuidNodeId(Object value);

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
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage#getNodeId_Base_DataType()
	 * @model ordered="false"
	 * @generated
	 */
	DataType getBase_DataType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeId#getBase_DataType <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Data Type</em>' reference.
	 * @see #getBase_DataType()
	 * @generated
	 */
	void setBase_DataType(DataType value);

} // NodeId
