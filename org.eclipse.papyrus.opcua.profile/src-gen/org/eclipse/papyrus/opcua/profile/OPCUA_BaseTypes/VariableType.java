/**
 */
package org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataType;
import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeId;

import org.eclipse.uml2.uml.Stereotype;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getDataType <em>Data Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getValueRank <em>Value Rank</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getArrayDimensions <em>Array Dimensions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getBase_Stereotype <em>Base Stereotype</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariableType()
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
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariableType_Value()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataType getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getValue <em>Value</em>}' reference.
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
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariableType_DataType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NodeId getDataType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getDataType <em>Data Type</em>}' reference.
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
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariableType_ValueRank()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.Int32" required="true" ordered="false"
	 * @generated
	 */
	int getValueRank();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getValueRank <em>Value Rank</em>}' attribute.
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
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariableType_ArrayDimensions()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.UInteger.UInt32" required="true" ordered="false"
	 * @generated
	 */
	int getArrayDimensions();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getArrayDimensions <em>Array Dimensions</em>}' attribute.
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
	 * @see #setIsAbstract(boolean)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariableType_IsAbstract()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

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
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariableType_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getBase_Class <em>Base Class</em>}' reference.
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
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariableType_Base_Stereotype()
	 * @model ordered="false"
	 * @generated
	 */
	Stereotype getBase_Stereotype();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType#getBase_Stereotype <em>Base Stereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Stereotype</em>' reference.
	 * @see #getBase_Stereotype()
	 * @generated
	 */
	void setBase_Stereotype(Stereotype value);

} // VariableType
