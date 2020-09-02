/**
 */
package org.opcfoundation.ua._2011._03.ua.UANodeSet;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UA Node Set Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getNamespaceUris <em>Namespace Uris</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getServerUris <em>Server Uris</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getModels <em>Models</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getAliases <em>Aliases</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getGroup <em>Group</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getUAObject <em>UA Object</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getUAVariable <em>UA Variable</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getUAMethod <em>UA Method</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getUAView <em>UA View</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getUAObjectType <em>UA Object Type</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getUAVariableType <em>UA Variable Type</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getUADataType <em>UA Data Type</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getUAReferenceType <em>UA Reference Type</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getLastModified <em>Last Modified</em>}</li>
 * </ul>
 *
 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getUANodeSetType()
 * @model extendedMetaData="name='UANodeSet_._type' kind='elementOnly'"
 * @generated
 */
public interface UANodeSetType extends EObject {
	/**
	 * Returns the value of the '<em><b>Namespace Uris</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace Uris</em>' containment reference.
	 * @see #setNamespaceUris(UriTable)
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getUANodeSetType_NamespaceUris()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='NamespaceUris' namespace='##targetNamespace'"
	 * @generated
	 */
	UriTable getNamespaceUris();

	/**
	 * Sets the value of the '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getNamespaceUris <em>Namespace Uris</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace Uris</em>' containment reference.
	 * @see #getNamespaceUris()
	 * @generated
	 */
	void setNamespaceUris(UriTable value);

	/**
	 * Returns the value of the '<em><b>Server Uris</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Uris</em>' containment reference.
	 * @see #setServerUris(UriTable)
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getUANodeSetType_ServerUris()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ServerUris' namespace='##targetNamespace'"
	 * @generated
	 */
	UriTable getServerUris();

	/**
	 * Sets the value of the '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getServerUris <em>Server Uris</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Uris</em>' containment reference.
	 * @see #getServerUris()
	 * @generated
	 */
	void setServerUris(UriTable value);

	/**
	 * Returns the value of the '<em><b>Models</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Models</em>' containment reference.
	 * @see #setModels(ModelTable)
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getUANodeSetType_Models()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Models' namespace='##targetNamespace'"
	 * @generated
	 */
	ModelTable getModels();

	/**
	 * Sets the value of the '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getModels <em>Models</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Models</em>' containment reference.
	 * @see #getModels()
	 * @generated
	 */
	void setModels(ModelTable value);

	/**
	 * Returns the value of the '<em><b>Aliases</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aliases</em>' containment reference.
	 * @see #setAliases(AliasTable)
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getUANodeSetType_Aliases()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Aliases' namespace='##targetNamespace'"
	 * @generated
	 */
	AliasTable getAliases();

	/**
	 * Sets the value of the '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getAliases <em>Aliases</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aliases</em>' containment reference.
	 * @see #getAliases()
	 * @generated
	 */
	void setAliases(AliasTable value);

	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' containment reference.
	 * @see #setExtensions(ListOfExtensions)
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getUANodeSetType_Extensions()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Extensions' namespace='##targetNamespace'"
	 * @generated
	 */
	ListOfExtensions getExtensions();

	/**
	 * Sets the value of the '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getExtensions <em>Extensions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extensions</em>' containment reference.
	 * @see #getExtensions()
	 * @generated
	 */
	void setExtensions(ListOfExtensions value);

	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getUANodeSetType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:5'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>UA Object</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UA Object</em>' containment reference list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getUANodeSetType_UAObject()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='UAObject' namespace='##targetNamespace' group='#group:5'"
	 * @generated
	 */
	EList<UAObject> getUAObject();

	/**
	 * Returns the value of the '<em><b>UA Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UA Variable</em>' containment reference list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getUANodeSetType_UAVariable()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='UAVariable' namespace='##targetNamespace' group='#group:5'"
	 * @generated
	 */
	EList<UAVariable> getUAVariable();

	/**
	 * Returns the value of the '<em><b>UA Method</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAMethod}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UA Method</em>' containment reference list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getUANodeSetType_UAMethod()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='UAMethod' namespace='##targetNamespace' group='#group:5'"
	 * @generated
	 */
	EList<UAMethod> getUAMethod();

	/**
	 * Returns the value of the '<em><b>UA View</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAView}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UA View</em>' containment reference list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getUANodeSetType_UAView()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='UAView' namespace='##targetNamespace' group='#group:5'"
	 * @generated
	 */
	EList<UAView> getUAView();

	/**
	 * Returns the value of the '<em><b>UA Object Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObjectType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UA Object Type</em>' containment reference list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getUANodeSetType_UAObjectType()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='UAObjectType' namespace='##targetNamespace' group='#group:5'"
	 * @generated
	 */
	EList<UAObjectType> getUAObjectType();

	/**
	 * Returns the value of the '<em><b>UA Variable Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariableType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UA Variable Type</em>' containment reference list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getUANodeSetType_UAVariableType()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='UAVariableType' namespace='##targetNamespace' group='#group:5'"
	 * @generated
	 */
	EList<UAVariableType> getUAVariableType();

	/**
	 * Returns the value of the '<em><b>UA Data Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UADataType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UA Data Type</em>' containment reference list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getUANodeSetType_UADataType()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='UADataType' namespace='##targetNamespace' group='#group:5'"
	 * @generated
	 */
	EList<UADataType> getUADataType();

	/**
	 * Returns the value of the '<em><b>UA Reference Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAReferenceType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UA Reference Type</em>' containment reference list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getUANodeSetType_UAReferenceType()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='UAReferenceType' namespace='##targetNamespace' group='#group:5'"
	 * @generated
	 */
	EList<UAReferenceType> getUAReferenceType();

	/**
	 * Returns the value of the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Modified</em>' attribute.
	 * @see #setLastModified(XMLGregorianCalendar)
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getUANodeSetType_LastModified()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='LastModified'"
	 * @generated
	 */
	XMLGregorianCalendar getLastModified();

	/**
	 * Sets the value of the '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType#getLastModified <em>Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Modified</em>' attribute.
	 * @see #getLastModified()
	 * @generated
	 */
	void setLastModified(XMLGregorianCalendar value);

} // UANodeSetType
