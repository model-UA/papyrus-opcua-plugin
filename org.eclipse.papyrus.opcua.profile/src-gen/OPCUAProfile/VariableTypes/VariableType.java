/**
 */
package OPCUAProfile.VariableTypes;

import OPCUAProfile.BaseNodeClass;

import OPCUAProfile.DataTypes.DataType;
import OPCUAProfile.DataTypes.NodeId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link OPCUAProfile.VariableTypes.VariableType#getValue <em>Value</em>}</li>
 *   <li>{@link OPCUAProfile.VariableTypes.VariableType#getDataType <em>Data Type</em>}</li>
 *   <li>{@link OPCUAProfile.VariableTypes.VariableType#getValueRank <em>Value Rank</em>}</li>
 *   <li>{@link OPCUAProfile.VariableTypes.VariableType#getArrayDimensions <em>Array Dimensions</em>}</li>
 *   <li>{@link OPCUAProfile.VariableTypes.VariableType#getIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link OPCUAProfile.VariableTypes.VariableType#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 *
 * @see OPCUAProfile.VariableTypes.VariableTypesPackage#getVariableType()
 * @model
 * @generated
 */
public interface VariableType extends BaseNodeClass {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(DataType)
	 * @see OPCUAProfile.VariableTypes.VariableTypesPackage#getVariableType_Value()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataType getValue();

	/**
	 * Sets the value of the '{@link OPCUAProfile.VariableTypes.VariableType#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(DataType value);

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' reference.
	 * @see #setDataType(NodeId)
	 * @see OPCUAProfile.VariableTypes.VariableTypesPackage#getVariableType_DataType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NodeId getDataType();

	/**
	 * Sets the value of the '{@link OPCUAProfile.VariableTypes.VariableType#getDataType <em>Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' reference.
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(NodeId value);

	/**
	 * Returns the value of the '<em><b>Value Rank</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Rank</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Rank</em>' attribute.
	 * @see #setValueRank(int)
	 * @see OPCUAProfile.VariableTypes.VariableTypesPackage#getVariableType_ValueRank()
	 * @model dataType="OPCUAProfile.DataTypes.Number.Integer.Int32" required="true" ordered="false"
	 * @generated
	 */
	int getValueRank();

	/**
	 * Sets the value of the '{@link OPCUAProfile.VariableTypes.VariableType#getValueRank <em>Value Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Rank</em>' attribute.
	 * @see #getValueRank()
	 * @generated
	 */
	void setValueRank(int value);

	/**
	 * Returns the value of the '<em><b>Array Dimensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Dimensions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Dimensions</em>' attribute.
	 * @see #setArrayDimensions(int)
	 * @see OPCUAProfile.VariableTypes.VariableTypesPackage#getVariableType_ArrayDimensions()
	 * @model dataType="OPCUAProfile.DataTypes.Number.UInteger.UInt32" required="true" ordered="false"
	 * @generated
	 */
	int getArrayDimensions();

	/**
	 * Sets the value of the '{@link OPCUAProfile.VariableTypes.VariableType#getArrayDimensions <em>Array Dimensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Array Dimensions</em>' attribute.
	 * @see #getArrayDimensions()
	 * @generated
	 */
	void setArrayDimensions(int value);

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
	 * @see OPCUAProfile.VariableTypes.VariableTypesPackage#getVariableType_IsAbstract()
	 * @model dataType="OPCUAProfile.DataTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	Object getIsAbstract();

	/**
	 * Sets the value of the '{@link OPCUAProfile.VariableTypes.VariableType#getIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #getIsAbstract()
	 * @generated
	 */
	void setIsAbstract(Object value);

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
	 * @see OPCUAProfile.VariableTypes.VariableTypesPackage#getVariableType_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link OPCUAProfile.VariableTypes.VariableType#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // VariableType
