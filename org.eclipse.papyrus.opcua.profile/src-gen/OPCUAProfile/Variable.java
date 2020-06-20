/**
 */
package OPCUAProfile;

import OPCUAProfile.DataTypes.NodeId;

import OPCUAProfile.ObjectTypes.ObjectType;

import java.lang.Object;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link OPCUAProfile.Variable#getValue <em>Value</em>}</li>
 *   <li>{@link OPCUAProfile.Variable#getDataType <em>Data Type</em>}</li>
 *   <li>{@link OPCUAProfile.Variable#getValueRank <em>Value Rank</em>}</li>
 *   <li>{@link OPCUAProfile.Variable#getArrayDimensions <em>Array Dimensions</em>}</li>
 *   <li>{@link OPCUAProfile.Variable#getAccessLevel <em>Access Level</em>}</li>
 *   <li>{@link OPCUAProfile.Variable#getUserAccessLevel <em>User Access Level</em>}</li>
 *   <li>{@link OPCUAProfile.Variable#getMinimumSamplingInterval <em>Minimum Sampling Interval</em>}</li>
 *   <li>{@link OPCUAProfile.Variable#getHistorizing <em>Historizing</em>}</li>
 *   <li>{@link OPCUAProfile.Variable#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 *
 * @see OPCUAProfile.OPCUAProfilePackage#getVariable()
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
	 * @see OPCUAProfile.OPCUAProfilePackage#getVariable_Value()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ObjectType getValue();

	/**
	 * Sets the value of the '{@link OPCUAProfile.Variable#getValue <em>Value</em>}' reference.
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
	 * @see OPCUAProfile.OPCUAProfilePackage#getVariable_DataType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NodeId getDataType();

	/**
	 * Sets the value of the '{@link OPCUAProfile.Variable#getDataType <em>Data Type</em>}' reference.
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
	 * @see OPCUAProfile.OPCUAProfilePackage#getVariable_ValueRank()
	 * @model dataType="OPCUAProfile.DataTypes.Number.Integer.Int32" required="true" ordered="false"
	 * @generated
	 */
	int getValueRank();

	/**
	 * Sets the value of the '{@link OPCUAProfile.Variable#getValueRank <em>Value Rank</em>}' attribute.
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
	 * @see OPCUAProfile.OPCUAProfilePackage#getVariable_ArrayDimensions()
	 * @model dataType="OPCUAProfile.DataTypes.Number.UInteger.UInt32" required="true" ordered="false"
	 * @generated
	 */
	int getArrayDimensions();

	/**
	 * Sets the value of the '{@link OPCUAProfile.Variable#getArrayDimensions <em>Array Dimensions</em>}' attribute.
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
	 * @see #setAccessLevel(Byte)
	 * @see OPCUAProfile.OPCUAProfilePackage#getVariable_AccessLevel()
	 * @model dataType="OPCUAProfile.DataTypes.Number.UInteger.Byte" required="true" ordered="false"
	 * @generated
	 */
	Object getAccessLevel();

	/**
	 * Sets the value of the '{@link OPCUAProfile.Variable#getAccessLevel <em>Access Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Level</em>' attribute.
	 * @see #getAccessLevel()
	 * @generated
	 */
	void setAccessLevel(Object value);

	/**
	 * Returns the value of the '<em><b>User Access Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Access Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Access Level</em>' attribute.
	 * @see #setUserAccessLevel(Byte)
	 * @see OPCUAProfile.OPCUAProfilePackage#getVariable_UserAccessLevel()
	 * @model dataType="OPCUAProfile.DataTypes.Number.UInteger.Byte" required="true" ordered="false"
	 * @generated
	 */
	Object getUserAccessLevel();

	/**
	 * Sets the value of the '{@link OPCUAProfile.Variable#getUserAccessLevel <em>User Access Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Access Level</em>' attribute.
	 * @see #getUserAccessLevel()
	 * @generated
	 */
	void setUserAccessLevel(Object value);

	/**
	 * Returns the value of the '<em><b>Minimum Sampling Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Sampling Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Sampling Interval</em>' attribute.
	 * @see #setMinimumSamplingInterval(Double)
	 * @see OPCUAProfile.OPCUAProfilePackage#getVariable_MinimumSamplingInterval()
	 * @model dataType="OPCUAProfile.DataTypes.Number.Double" required="true" ordered="false"
	 * @generated
	 */
	Object getMinimumSamplingInterval();

	/**
	 * Sets the value of the '{@link OPCUAProfile.Variable#getMinimumSamplingInterval <em>Minimum Sampling Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Sampling Interval</em>' attribute.
	 * @see #getMinimumSamplingInterval()
	 * @generated
	 */
	void setMinimumSamplingInterval(Object value);

	/**
	 * Returns the value of the '<em><b>Historizing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Historizing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Historizing</em>' attribute.
	 * @see #setHistorizing(Boolean)
	 * @see OPCUAProfile.OPCUAProfilePackage#getVariable_Historizing()
	 * @model dataType="OPCUAProfile.DataTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	Object getHistorizing();

	/**
	 * Sets the value of the '{@link OPCUAProfile.Variable#getHistorizing <em>Historizing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Historizing</em>' attribute.
	 * @see #getHistorizing()
	 * @generated
	 */
	void setHistorizing(Object value);

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
	 * @see OPCUAProfile.OPCUAProfilePackage#getVariable_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link OPCUAProfile.Variable#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // Variable
