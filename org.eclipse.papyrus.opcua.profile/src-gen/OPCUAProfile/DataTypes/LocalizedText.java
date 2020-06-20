/**
 */
package OPCUAProfile.DataTypes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Localized Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link OPCUAProfile.DataTypes.LocalizedText#getLocale <em>Locale</em>}</li>
 *   <li>{@link OPCUAProfile.DataTypes.LocalizedText#getText <em>Text</em>}</li>
 * </ul>
 *
 * @see OPCUAProfile.DataTypes.DataTypesPackage#getLocalizedText()
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
	 * @see OPCUAProfile.DataTypes.DataTypesPackage#getLocalizedText_Locale()
	 * @model dataType="OPCUAProfile.DataTypes.String" required="true" ordered="false"
	 * @generated
	 */
	Object getLocale();

	/**
	 * Sets the value of the '{@link OPCUAProfile.DataTypes.LocalizedText#getLocale <em>Locale</em>}' attribute.
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
	 * @see OPCUAProfile.DataTypes.DataTypesPackage#getLocalizedText_Text()
	 * @model dataType="OPCUAProfile.DataTypes.String" required="true" ordered="false"
	 * @generated
	 */
	Object getText();

	/**
	 * Sets the value of the '{@link OPCUAProfile.DataTypes.LocalizedText#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(Object value);

} // LocalizedText
