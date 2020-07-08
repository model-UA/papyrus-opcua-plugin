/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.DataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Localized Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.LocalizedText#getLocale <em>Locale</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.LocalizedText#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.LocalizedText#getBase_DataType <em>Base Data Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage#getLocalizedText()
 * @model
 * @generated
 */
public interface LocalizedText extends EObject {
	/**
	 * Returns the value of the '<em><b>Locale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Locale</em>' attribute.
	 * @see #setLocale(String)
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage#getLocalizedText_Locale()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.String" required="true" ordered="false"
	 * @generated
	 */
	Object getLocale();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.LocalizedText#getLocale <em>Locale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Locale</em>' attribute.
	 * @see #getLocale()
	 * @generated
	 */
	void setLocale(Object value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage#getLocalizedText_Text()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.String" required="true" ordered="false"
	 * @generated
	 */
	Object getText();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.LocalizedText#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(Object value);

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
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.DataTypesPackage#getLocalizedText_Base_DataType()
	 * @model ordered="false"
	 * @generated
	 */
	DataType getBase_DataType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.LocalizedText#getBase_DataType <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Data Type</em>' reference.
	 * @see #getBase_DataType()
	 * @generated
	 */
	void setBase_DataType(DataType value);

} // LocalizedText
