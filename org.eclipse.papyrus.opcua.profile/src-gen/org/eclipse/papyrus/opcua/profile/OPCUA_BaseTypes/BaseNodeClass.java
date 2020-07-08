/**
 */
package org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.LocalizedText;
import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.NodeId;
import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.QualifiedName;
import org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes._NodeClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Node Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getNodeId <em>Node Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getNodeClass <em>Node Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getBrowseName <em>Browse Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getWriteMask <em>Write Mask</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getBaseNodeClass()
 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='Base Node Class'"
 * @generated
 */
public interface BaseNodeClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Node Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Id</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Id</em>' reference.
	 * @see #setNodeId(NodeId)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getBaseNodeClass_NodeId()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NodeId getNodeId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getNodeId <em>Node Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Id</em>' reference.
	 * @see #getNodeId()
	 * @generated
	 */
	void setNodeId(NodeId value);

	/**
	 * Returns the value of the '<em><b>Node Class</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes._NodeClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Class</em>' attribute.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes._NodeClass
	 * @see #setNodeClass(_NodeClass)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getBaseNodeClass_NodeClass()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	_NodeClass getNodeClass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getNodeClass <em>Node Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Class</em>' attribute.
	 * @see org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes._NodeClass
	 * @see #getNodeClass()
	 * @generated
	 */
	void setNodeClass(_NodeClass value);

	/**
	 * Returns the value of the '<em><b>Browse Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Browse Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Browse Name</em>' reference.
	 * @see #setBrowseName(QualifiedName)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getBaseNodeClass_BrowseName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	QualifiedName getBrowseName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getBrowseName <em>Browse Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Browse Name</em>' reference.
	 * @see #getBrowseName()
	 * @generated
	 */
	void setBrowseName(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Display Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Name</em>' reference.
	 * @see #setDisplayName(LocalizedText)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getBaseNodeClass_DisplayName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	LocalizedText getDisplayName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getDisplayName <em>Display Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Name</em>' reference.
	 * @see #getDisplayName()
	 * @generated
	 */
	void setDisplayName(LocalizedText value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' reference.
	 * @see #setDescription(LocalizedText)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getBaseNodeClass_Description()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	LocalizedText getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getDescription <em>Description</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' reference.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(LocalizedText value);

	/**
	 * Returns the value of the '<em><b>Write Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Mask</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Mask</em>' attribute.
	 * @see #setWriteMask(int)
	 * @see org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage#getBaseNodeClass_WriteMask()
	 * @model dataType="org.eclipse.papyrus.opcua.types.OPCUA_BaseTypes.DataTypes.Number.UInteger.UInt32" required="true" ordered="false"
	 * @generated
	 */
	int getWriteMask();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass#getWriteMask <em>Write Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Write Mask</em>' attribute.
	 * @see #getWriteMask()
	 * @generated
	 */
	void setWriteMask(int value);

} // BaseNodeClass
