/**
 */
package org.opcfoundation.ua._2011._03.ua.UANodeSet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nodes To Add</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.NodesToAdd#getGroup <em>Group</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.NodesToAdd#getUAObject <em>UA Object</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.NodesToAdd#getUAVariable <em>UA Variable</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.NodesToAdd#getUAMethod <em>UA Method</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.NodesToAdd#getUAView <em>UA View</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.NodesToAdd#getUAObjectType <em>UA Object Type</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.NodesToAdd#getUAVariableType <em>UA Variable Type</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.NodesToAdd#getUADataType <em>UA Data Type</em>}</li>
 *   <li>{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.NodesToAdd#getUAReferenceType <em>UA Reference Type</em>}</li>
 * </ul>
 *
 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getNodesToAdd()
 * @model extendedMetaData="name='NodesToAdd' kind='elementOnly'"
 * @generated
 */
public interface NodesToAdd extends EObject {
	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getNodesToAdd_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>UA Object</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UA Object</em>' containment reference list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getNodesToAdd_UAObject()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='UAObject' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<UAObject> getUAObject();

	/**
	 * Returns the value of the '<em><b>UA Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UA Variable</em>' containment reference list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getNodesToAdd_UAVariable()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='UAVariable' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<UAVariable> getUAVariable();

	/**
	 * Returns the value of the '<em><b>UA Method</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAMethod}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UA Method</em>' containment reference list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getNodesToAdd_UAMethod()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='UAMethod' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<UAMethod> getUAMethod();

	/**
	 * Returns the value of the '<em><b>UA View</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAView}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UA View</em>' containment reference list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getNodesToAdd_UAView()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='UAView' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<UAView> getUAView();

	/**
	 * Returns the value of the '<em><b>UA Object Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObjectType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UA Object Type</em>' containment reference list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getNodesToAdd_UAObjectType()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='UAObjectType' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<UAObjectType> getUAObjectType();

	/**
	 * Returns the value of the '<em><b>UA Variable Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariableType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UA Variable Type</em>' containment reference list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getNodesToAdd_UAVariableType()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='UAVariableType' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<UAVariableType> getUAVariableType();

	/**
	 * Returns the value of the '<em><b>UA Data Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UADataType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UA Data Type</em>' containment reference list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getNodesToAdd_UADataType()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='UADataType' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<UADataType> getUADataType();

	/**
	 * Returns the value of the '<em><b>UA Reference Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAReferenceType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UA Reference Type</em>' containment reference list.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage#getNodesToAdd_UAReferenceType()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='UAReferenceType' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<UAReferenceType> getUAReferenceType();

} // NodesToAdd
