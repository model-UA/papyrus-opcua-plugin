/**
 */
package org.opcfoundation.ua._2011._03.ua.UANodeSet.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.opcfoundation.ua._2011._03.ua.UANodeSet.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetPackage
 * @generated
 */
public class NodeSetAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static NodeSetPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeSetAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = NodeSetPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeSetSwitch<Adapter> modelSwitch =
		new NodeSetSwitch<Adapter>() {
			@Override
			public Adapter caseAliasTable(AliasTable object) {
				return createAliasTableAdapter();
			}
			@Override
			public Adapter caseDataTypeDefinition(DataTypeDefinition object) {
				return createDataTypeDefinitionAdapter();
			}
			@Override
			public Adapter caseDataTypeField(DataTypeField object) {
				return createDataTypeFieldAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseExtensionType(ExtensionType object) {
				return createExtensionTypeAdapter();
			}
			@Override
			public Adapter caseListOfExtensions(ListOfExtensions object) {
				return createListOfExtensionsAdapter();
			}
			@Override
			public Adapter caseListOfReferences(ListOfReferences object) {
				return createListOfReferencesAdapter();
			}
			@Override
			public Adapter caseListOfRolePermissions(ListOfRolePermissions object) {
				return createListOfRolePermissionsAdapter();
			}
			@Override
			public Adapter caseLocalizedText(LocalizedText object) {
				return createLocalizedTextAdapter();
			}
			@Override
			public Adapter caseModelTable(ModelTable object) {
				return createModelTableAdapter();
			}
			@Override
			public Adapter caseModelTableEntry(ModelTableEntry object) {
				return createModelTableEntryAdapter();
			}
			@Override
			public Adapter caseNodeIdAlias(NodeIdAlias object) {
				return createNodeIdAliasAdapter();
			}
			@Override
			public Adapter caseNodeSetStatus(NodeSetStatus object) {
				return createNodeSetStatusAdapter();
			}
			@Override
			public Adapter caseNodeSetStatusList(NodeSetStatusList object) {
				return createNodeSetStatusListAdapter();
			}
			@Override
			public Adapter caseNodesToAdd(NodesToAdd object) {
				return createNodesToAddAdapter();
			}
			@Override
			public Adapter caseNodesToDelete(NodesToDelete object) {
				return createNodesToDeleteAdapter();
			}
			@Override
			public Adapter caseNodeToDelete(NodeToDelete object) {
				return createNodeToDeleteAdapter();
			}
			@Override
			public Adapter caseReference(Reference object) {
				return createReferenceAdapter();
			}
			@Override
			public Adapter caseReferenceChange(ReferenceChange object) {
				return createReferenceChangeAdapter();
			}
			@Override
			public Adapter caseReferencesToChange(ReferencesToChange object) {
				return createReferencesToChangeAdapter();
			}
			@Override
			public Adapter caseRolePermission(RolePermission object) {
				return createRolePermissionAdapter();
			}
			@Override
			public Adapter caseStructureTranslationType(StructureTranslationType object) {
				return createStructureTranslationTypeAdapter();
			}
			@Override
			public Adapter caseTranslationType(TranslationType object) {
				return createTranslationTypeAdapter();
			}
			@Override
			public Adapter caseUADataType(UADataType object) {
				return createUADataTypeAdapter();
			}
			@Override
			public Adapter caseUAInstance(UAInstance object) {
				return createUAInstanceAdapter();
			}
			@Override
			public Adapter caseUAMethod(UAMethod object) {
				return createUAMethodAdapter();
			}
			@Override
			public Adapter caseUAMethodArgument(UAMethodArgument object) {
				return createUAMethodArgumentAdapter();
			}
			@Override
			public Adapter caseUANode(UANode object) {
				return createUANodeAdapter();
			}
			@Override
			public Adapter caseUANodeSetChangesStatusType(UANodeSetChangesStatusType object) {
				return createUANodeSetChangesStatusTypeAdapter();
			}
			@Override
			public Adapter caseUANodeSetChangesType(UANodeSetChangesType object) {
				return createUANodeSetChangesTypeAdapter();
			}
			@Override
			public Adapter caseUANodeSetType(UANodeSetType object) {
				return createUANodeSetTypeAdapter();
			}
			@Override
			public Adapter caseUAObject(UAObject object) {
				return createUAObjectAdapter();
			}
			@Override
			public Adapter caseUAObjectType(UAObjectType object) {
				return createUAObjectTypeAdapter();
			}
			@Override
			public Adapter caseUAReferenceType(UAReferenceType object) {
				return createUAReferenceTypeAdapter();
			}
			@Override
			public Adapter caseUAType(UAType object) {
				return createUATypeAdapter();
			}
			@Override
			public Adapter caseUAVariable(UAVariable object) {
				return createUAVariableAdapter();
			}
			@Override
			public Adapter caseUAVariableType(UAVariableType object) {
				return createUAVariableTypeAdapter();
			}
			@Override
			public Adapter caseUAView(UAView object) {
				return createUAViewAdapter();
			}
			@Override
			public Adapter caseUriTable(UriTable object) {
				return createUriTableAdapter();
			}
			@Override
			public Adapter caseValueType(ValueType object) {
				return createValueTypeAdapter();
			}
			@Override
			public Adapter caseValueType1(ValueType1 object) {
				return createValueType1Adapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.AliasTable <em>Alias Table</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.AliasTable
	 * @generated
	 */
	public Adapter createAliasTableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.DataTypeDefinition <em>Data Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.DataTypeDefinition
	 * @generated
	 */
	public Adapter createDataTypeDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.DataTypeField <em>Data Type Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.DataTypeField
	 * @generated
	 */
	public Adapter createDataTypeFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.ExtensionType <em>Extension Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.ExtensionType
	 * @generated
	 */
	public Adapter createExtensionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.ListOfExtensions <em>List Of Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.ListOfExtensions
	 * @generated
	 */
	public Adapter createListOfExtensionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.ListOfReferences <em>List Of References</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.ListOfReferences
	 * @generated
	 */
	public Adapter createListOfReferencesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.ListOfRolePermissions <em>List Of Role Permissions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.ListOfRolePermissions
	 * @generated
	 */
	public Adapter createListOfRolePermissionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.LocalizedText <em>Localized Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.LocalizedText
	 * @generated
	 */
	public Adapter createLocalizedTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.ModelTable <em>Model Table</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.ModelTable
	 * @generated
	 */
	public Adapter createModelTableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.ModelTableEntry <em>Model Table Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.ModelTableEntry
	 * @generated
	 */
	public Adapter createModelTableEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeIdAlias <em>Node Id Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeIdAlias
	 * @generated
	 */
	public Adapter createNodeIdAliasAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetStatus
	 * @generated
	 */
	public Adapter createNodeSetStatusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetStatusList <em>Status List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeSetStatusList
	 * @generated
	 */
	public Adapter createNodeSetStatusListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.NodesToAdd <em>Nodes To Add</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodesToAdd
	 * @generated
	 */
	public Adapter createNodesToAddAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.NodesToDelete <em>Nodes To Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodesToDelete
	 * @generated
	 */
	public Adapter createNodesToDeleteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeToDelete <em>Node To Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeToDelete
	 * @generated
	 */
	public Adapter createNodeToDeleteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.Reference
	 * @generated
	 */
	public Adapter createReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.ReferenceChange <em>Reference Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.ReferenceChange
	 * @generated
	 */
	public Adapter createReferenceChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.ReferencesToChange <em>References To Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.ReferencesToChange
	 * @generated
	 */
	public Adapter createReferencesToChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.RolePermission <em>Role Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.RolePermission
	 * @generated
	 */
	public Adapter createRolePermissionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.StructureTranslationType <em>Structure Translation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.StructureTranslationType
	 * @generated
	 */
	public Adapter createStructureTranslationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.TranslationType <em>Translation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.TranslationType
	 * @generated
	 */
	public Adapter createTranslationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UADataType <em>UA Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.UADataType
	 * @generated
	 */
	public Adapter createUADataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAInstance <em>UA Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.UAInstance
	 * @generated
	 */
	public Adapter createUAInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAMethod <em>UA Method</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.UAMethod
	 * @generated
	 */
	public Adapter createUAMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAMethodArgument <em>UA Method Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.UAMethodArgument
	 * @generated
	 */
	public Adapter createUAMethodArgumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANode <em>UA Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.UANode
	 * @generated
	 */
	public Adapter createUANodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetChangesStatusType <em>UA Node Set Changes Status Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetChangesStatusType
	 * @generated
	 */
	public Adapter createUANodeSetChangesStatusTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetChangesType <em>UA Node Set Changes Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetChangesType
	 * @generated
	 */
	public Adapter createUANodeSetChangesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType <em>UA Node Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType
	 * @generated
	 */
	public Adapter createUANodeSetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObject <em>UA Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObject
	 * @generated
	 */
	public Adapter createUAObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObjectType <em>UA Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObjectType
	 * @generated
	 */
	public Adapter createUAObjectTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAReferenceType <em>UA Reference Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.UAReferenceType
	 * @generated
	 */
	public Adapter createUAReferenceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAType <em>UA Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.UAType
	 * @generated
	 */
	public Adapter createUATypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariable <em>UA Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariable
	 * @generated
	 */
	public Adapter createUAVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariableType <em>UA Variable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariableType
	 * @generated
	 */
	public Adapter createUAVariableTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UAView <em>UA View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.UAView
	 * @generated
	 */
	public Adapter createUAViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.UriTable <em>Uri Table</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.UriTable
	 * @generated
	 */
	public Adapter createUriTableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.ValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.ValueType
	 * @generated
	 */
	public Adapter createValueTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.opcfoundation.ua._2011._03.ua.UANodeSet.ValueType1 <em>Value Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.opcfoundation.ua._2011._03.ua.UANodeSet.ValueType1
	 * @generated
	 */
	public Adapter createValueType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //NodeSetAdapterFactory
