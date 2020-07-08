/**
 */
package org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeId;

import org.eclipse.uml2.uml.Stereotype;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getDataType <em>Data Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getValueRank <em>Value Rank</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getArrayDimensions <em>Array Dimensions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getAccessLevel <em>Access Level</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getUserAccessLevel <em>User Access Level</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getMinimumSamplingInterval <em>Minimum Sampling Interval</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#isHistorizing <em>Historizing</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getBase_Variable <em>Base Variable</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getBase_Stereotype <em>Base Stereotype</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends BaseNodeClass {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(ObjectType)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariable_Value()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ObjectType getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(ObjectType value);

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
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariable_DataType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NodeId getDataType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getDataType <em>Data Type</em>}' reference.
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
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariable_ValueRank()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Integer.Int32" required="true" ordered="false"
	 * @generated
	 */
	int getValueRank();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getValueRank <em>Value Rank</em>}' attribute.
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
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariable_ArrayDimensions()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.UInteger.UInt32" required="true" ordered="false"
	 * @generated
	 */
	int getArrayDimensions();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getArrayDimensions <em>Array Dimensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Array Dimensions</em>' attribute.
	 * @see #getArrayDimensions()
	 * @generated
	 */
	void setArrayDimensions(int value);

	/**
	 * Returns the value of the '<em><b>Access Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Level</em>' attribute.
	 * @see #setAccessLevel(byte)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariable_AccessLevel()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.UInteger.Byte" required="true" ordered="false"
	 * @generated
	 */
	byte getAccessLevel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getAccessLevel <em>Access Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Level</em>' attribute.
	 * @see #getAccessLevel()
	 * @generated
	 */
	void setAccessLevel(byte value);

	/**
	 * Returns the value of the '<em><b>User Access Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Access Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Access Level</em>' attribute.
	 * @see #setUserAccessLevel(byte)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariable_UserAccessLevel()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.UInteger.Byte" required="true" ordered="false"
	 * @generated
	 */
	byte getUserAccessLevel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getUserAccessLevel <em>User Access Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Access Level</em>' attribute.
	 * @see #getUserAccessLevel()
	 * @generated
	 */
	void setUserAccessLevel(byte value);

	/**
	 * Returns the value of the '<em><b>Minimum Sampling Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Sampling Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Sampling Interval</em>' attribute.
	 * @see #setMinimumSamplingInterval(double)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariable_MinimumSamplingInterval()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.Double" required="true" ordered="false"
	 * @generated
	 */
	double getMinimumSamplingInterval();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getMinimumSamplingInterval <em>Minimum Sampling Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Sampling Interval</em>' attribute.
	 * @see #getMinimumSamplingInterval()
	 * @generated
	 */
	void setMinimumSamplingInterval(double value);

	/**
	 * Returns the value of the '<em><b>Historizing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Historizing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Historizing</em>' attribute.
	 * @see #setHistorizing(boolean)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariable_Historizing()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isHistorizing();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#isHistorizing <em>Historizing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Historizing</em>' attribute.
	 * @see #isHistorizing()
	 * @generated
	 */
	void setHistorizing(boolean value);

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
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariable_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Base Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Variable</em>' reference.
	 * @see #setBase_Variable(org.eclipse.uml2.uml.Variable)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariable_Base_Variable()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Variable getBase_Variable();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getBase_Variable <em>Base Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Variable</em>' reference.
	 * @see #getBase_Variable()
	 * @generated
	 */
	void setBase_Variable(org.eclipse.uml2.uml.Variable value);

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
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getVariable_Base_Stereotype()
	 * @model ordered="false"
	 * @generated
	 */
	Stereotype getBase_Stereotype();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable#getBase_Stereotype <em>Base Stereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Stereotype</em>' reference.
	 * @see #getBase_Stereotype()
	 * @generated
	 */
	void setBase_Stereotype(Stereotype value);

} // Variable
