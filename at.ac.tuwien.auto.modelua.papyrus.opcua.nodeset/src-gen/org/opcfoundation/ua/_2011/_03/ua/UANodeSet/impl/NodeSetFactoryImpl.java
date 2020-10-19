/**
 */
package org.opcfoundation.ua._2011._03.ua.UANodeSet.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.opcfoundation.ua._2011._03.ua.UANodeSet.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NodeSetFactoryImpl extends EFactoryImpl implements NodeSetFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NodeSetFactory init() {
		try {
			NodeSetFactory theNodeSetFactory = (NodeSetFactory)EPackage.Registry.INSTANCE.getEFactory(NodeSetPackage.eNS_URI);
			if (theNodeSetFactory != null) {
				return theNodeSetFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NodeSetFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeSetFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case NodeSetPackage.ALIAS_TABLE: return createAliasTable();
			case NodeSetPackage.DATA_TYPE_DEFINITION: return createDataTypeDefinition();
			case NodeSetPackage.DATA_TYPE_FIELD: return createDataTypeField();
			case NodeSetPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case NodeSetPackage.EXTENSION_TYPE: return createExtensionType();
			case NodeSetPackage.LIST_OF_EXTENSIONS: return createListOfExtensions();
			case NodeSetPackage.LIST_OF_REFERENCES: return createListOfReferences();
			case NodeSetPackage.LIST_OF_ROLE_PERMISSIONS: return createListOfRolePermissions();
			case NodeSetPackage.LOCALIZED_TEXT: return createLocalizedText();
			case NodeSetPackage.MODEL_TABLE: return createModelTable();
			case NodeSetPackage.MODEL_TABLE_ENTRY: return createModelTableEntry();
			case NodeSetPackage.NODE_ID_ALIAS: return createNodeIdAlias();
			case NodeSetPackage.NODE_SET_STATUS: return createNodeSetStatus();
			case NodeSetPackage.NODE_SET_STATUS_LIST: return createNodeSetStatusList();
			case NodeSetPackage.NODES_TO_ADD: return createNodesToAdd();
			case NodeSetPackage.NODES_TO_DELETE: return createNodesToDelete();
			case NodeSetPackage.NODE_TO_DELETE: return createNodeToDelete();
			case NodeSetPackage.REFERENCE: return createReference();
			case NodeSetPackage.REFERENCE_CHANGE: return createReferenceChange();
			case NodeSetPackage.REFERENCES_TO_CHANGE: return createReferencesToChange();
			case NodeSetPackage.ROLE_PERMISSION: return createRolePermission();
			case NodeSetPackage.STRUCTURE_TRANSLATION_TYPE: return createStructureTranslationType();
			case NodeSetPackage.TRANSLATION_TYPE: return createTranslationType();
			case NodeSetPackage.UA_DATA_TYPE: return createUADataType();
			case NodeSetPackage.UA_INSTANCE: return createUAInstance();
			case NodeSetPackage.UA_METHOD: return createUAMethod();
			case NodeSetPackage.UA_METHOD_ARGUMENT: return createUAMethodArgument();
			case NodeSetPackage.UA_NODE: return createUANode();
			case NodeSetPackage.UA_NODE_SET_CHANGES_STATUS_TYPE: return createUANodeSetChangesStatusType();
			case NodeSetPackage.UA_NODE_SET_CHANGES_TYPE: return createUANodeSetChangesType();
			case NodeSetPackage.UA_NODE_SET_TYPE: return createUANodeSetType();
			case NodeSetPackage.UA_OBJECT: return createUAObject();
			case NodeSetPackage.UA_OBJECT_TYPE: return createUAObjectType();
			case NodeSetPackage.UA_REFERENCE_TYPE: return createUAReferenceType();
			case NodeSetPackage.UA_TYPE: return createUAType();
			case NodeSetPackage.UA_VARIABLE: return createUAVariable();
			case NodeSetPackage.UA_VARIABLE_TYPE: return createUAVariableType();
			case NodeSetPackage.UA_VIEW: return createUAView();
			case NodeSetPackage.URI_TABLE: return createUriTable();
			case NodeSetPackage.VALUE_TYPE: return createValueType();
			case NodeSetPackage.VALUE_TYPE1: return createValueType1();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case NodeSetPackage.DATA_TYPE_PURPOSE:
				return createDataTypePurposeFromString(eDataType, initialValue);
			case NodeSetPackage.RELEASE_STATUS:
				return createReleaseStatusFromString(eDataType, initialValue);
			case NodeSetPackage.ACCESS_LEVEL:
				return createAccessLevelFromString(eDataType, initialValue);
			case NodeSetPackage.ACCESS_LEVEL_OBJECT:
				return createAccessLevelObjectFromString(eDataType, initialValue);
			case NodeSetPackage.ACCESS_RESTRICTION:
				return createAccessRestrictionFromString(eDataType, initialValue);
			case NodeSetPackage.ACCESS_RESTRICTION_OBJECT:
				return createAccessRestrictionObjectFromString(eDataType, initialValue);
			case NodeSetPackage.ARRAY_DIMENSIONS:
				return createArrayDimensionsFromString(eDataType, initialValue);
			case NodeSetPackage.CARDINALITY_TYPE:
				return createCardinalityTypeFromString(eDataType, initialValue);
			case NodeSetPackage.CARDINALITY_TYPE_ITEM:
				return createCardinalityTypeItemFromString(eDataType, initialValue);
			case NodeSetPackage.DATA_TYPE_PURPOSE_OBJECT:
				return createDataTypePurposeObjectFromString(eDataType, initialValue);
			case NodeSetPackage.DURATION:
				return createDurationFromString(eDataType, initialValue);
			case NodeSetPackage.DURATION_OBJECT:
				return createDurationObjectFromString(eDataType, initialValue);
			case NodeSetPackage.EVENT_NOTIFIER:
				return createEventNotifierFromString(eDataType, initialValue);
			case NodeSetPackage.EVENT_NOTIFIER_OBJECT:
				return createEventNotifierObjectFromString(eDataType, initialValue);
			case NodeSetPackage.LOCALE:
				return createLocaleFromString(eDataType, initialValue);
			case NodeSetPackage.NODE_ID:
				return createNodeIdFromString(eDataType, initialValue);
			case NodeSetPackage.QUALIFIED_NAME:
				return createQualifiedNameFromString(eDataType, initialValue);
			case NodeSetPackage.RELEASE_STATUS_OBJECT:
				return createReleaseStatusObjectFromString(eDataType, initialValue);
			case NodeSetPackage.SYMBOLIC_NAME:
				return createSymbolicNameFromString(eDataType, initialValue);
			case NodeSetPackage.SYMBOLIC_NAME_ITEM:
				return createSymbolicNameItemFromString(eDataType, initialValue);
			case NodeSetPackage.VALUE_RANK:
				return createValueRankFromString(eDataType, initialValue);
			case NodeSetPackage.VALUE_RANK_OBJECT:
				return createValueRankObjectFromString(eDataType, initialValue);
			case NodeSetPackage.WRITE_MASK:
				return createWriteMaskFromString(eDataType, initialValue);
			case NodeSetPackage.WRITE_MASK_OBJECT:
				return createWriteMaskObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case NodeSetPackage.DATA_TYPE_PURPOSE:
				return convertDataTypePurposeToString(eDataType, instanceValue);
			case NodeSetPackage.RELEASE_STATUS:
				return convertReleaseStatusToString(eDataType, instanceValue);
			case NodeSetPackage.ACCESS_LEVEL:
				return convertAccessLevelToString(eDataType, instanceValue);
			case NodeSetPackage.ACCESS_LEVEL_OBJECT:
				return convertAccessLevelObjectToString(eDataType, instanceValue);
			case NodeSetPackage.ACCESS_RESTRICTION:
				return convertAccessRestrictionToString(eDataType, instanceValue);
			case NodeSetPackage.ACCESS_RESTRICTION_OBJECT:
				return convertAccessRestrictionObjectToString(eDataType, instanceValue);
			case NodeSetPackage.ARRAY_DIMENSIONS:
				return convertArrayDimensionsToString(eDataType, instanceValue);
			case NodeSetPackage.CARDINALITY_TYPE:
				return convertCardinalityTypeToString(eDataType, instanceValue);
			case NodeSetPackage.CARDINALITY_TYPE_ITEM:
				return convertCardinalityTypeItemToString(eDataType, instanceValue);
			case NodeSetPackage.DATA_TYPE_PURPOSE_OBJECT:
				return convertDataTypePurposeObjectToString(eDataType, instanceValue);
			case NodeSetPackage.DURATION:
				return convertDurationToString(eDataType, instanceValue);
			case NodeSetPackage.DURATION_OBJECT:
				return convertDurationObjectToString(eDataType, instanceValue);
			case NodeSetPackage.EVENT_NOTIFIER:
				return convertEventNotifierToString(eDataType, instanceValue);
			case NodeSetPackage.EVENT_NOTIFIER_OBJECT:
				return convertEventNotifierObjectToString(eDataType, instanceValue);
			case NodeSetPackage.LOCALE:
				return convertLocaleToString(eDataType, instanceValue);
			case NodeSetPackage.NODE_ID:
				return convertNodeIdToString(eDataType, instanceValue);
			case NodeSetPackage.QUALIFIED_NAME:
				return convertQualifiedNameToString(eDataType, instanceValue);
			case NodeSetPackage.RELEASE_STATUS_OBJECT:
				return convertReleaseStatusObjectToString(eDataType, instanceValue);
			case NodeSetPackage.SYMBOLIC_NAME:
				return convertSymbolicNameToString(eDataType, instanceValue);
			case NodeSetPackage.SYMBOLIC_NAME_ITEM:
				return convertSymbolicNameItemToString(eDataType, instanceValue);
			case NodeSetPackage.VALUE_RANK:
				return convertValueRankToString(eDataType, instanceValue);
			case NodeSetPackage.VALUE_RANK_OBJECT:
				return convertValueRankObjectToString(eDataType, instanceValue);
			case NodeSetPackage.WRITE_MASK:
				return convertWriteMaskToString(eDataType, instanceValue);
			case NodeSetPackage.WRITE_MASK_OBJECT:
				return convertWriteMaskObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AliasTable createAliasTable() {
		AliasTableImpl aliasTable = new AliasTableImpl();
		return aliasTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeDefinition createDataTypeDefinition() {
		DataTypeDefinitionImpl dataTypeDefinition = new DataTypeDefinitionImpl();
		return dataTypeDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeField createDataTypeField() {
		DataTypeFieldImpl dataTypeField = new DataTypeFieldImpl();
		return dataTypeField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionType createExtensionType() {
		ExtensionTypeImpl extensionType = new ExtensionTypeImpl();
		return extensionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListOfExtensions createListOfExtensions() {
		ListOfExtensionsImpl listOfExtensions = new ListOfExtensionsImpl();
		return listOfExtensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListOfReferences createListOfReferences() {
		ListOfReferencesImpl listOfReferences = new ListOfReferencesImpl();
		return listOfReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListOfRolePermissions createListOfRolePermissions() {
		ListOfRolePermissionsImpl listOfRolePermissions = new ListOfRolePermissionsImpl();
		return listOfRolePermissions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalizedText createLocalizedText() {
		LocalizedTextImpl localizedText = new LocalizedTextImpl();
		return localizedText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelTable createModelTable() {
		ModelTableImpl modelTable = new ModelTableImpl();
		return modelTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelTableEntry createModelTableEntry() {
		ModelTableEntryImpl modelTableEntry = new ModelTableEntryImpl();
		return modelTableEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeIdAlias createNodeIdAlias() {
		NodeIdAliasImpl nodeIdAlias = new NodeIdAliasImpl();
		return nodeIdAlias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeSetStatus createNodeSetStatus() {
		NodeSetStatusImpl nodeSetStatus = new NodeSetStatusImpl();
		return nodeSetStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeSetStatusList createNodeSetStatusList() {
		NodeSetStatusListImpl nodeSetStatusList = new NodeSetStatusListImpl();
		return nodeSetStatusList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodesToAdd createNodesToAdd() {
		NodesToAddImpl nodesToAdd = new NodesToAddImpl();
		return nodesToAdd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodesToDelete createNodesToDelete() {
		NodesToDeleteImpl nodesToDelete = new NodesToDeleteImpl();
		return nodesToDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeToDelete createNodeToDelete() {
		NodeToDeleteImpl nodeToDelete = new NodeToDeleteImpl();
		return nodeToDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference createReference() {
		ReferenceImpl reference = new ReferenceImpl();
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceChange createReferenceChange() {
		ReferenceChangeImpl referenceChange = new ReferenceChangeImpl();
		return referenceChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferencesToChange createReferencesToChange() {
		ReferencesToChangeImpl referencesToChange = new ReferencesToChangeImpl();
		return referencesToChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RolePermission createRolePermission() {
		RolePermissionImpl rolePermission = new RolePermissionImpl();
		return rolePermission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureTranslationType createStructureTranslationType() {
		StructureTranslationTypeImpl structureTranslationType = new StructureTranslationTypeImpl();
		return structureTranslationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslationType createTranslationType() {
		TranslationTypeImpl translationType = new TranslationTypeImpl();
		return translationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UADataType createUADataType() {
		UADataTypeImpl uaDataType = new UADataTypeImpl();
		return uaDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UAInstance createUAInstance() {
		UAInstanceImpl uaInstance = new UAInstanceImpl();
		return uaInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UAMethod createUAMethod() {
		UAMethodImpl uaMethod = new UAMethodImpl();
		return uaMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UAMethodArgument createUAMethodArgument() {
		UAMethodArgumentImpl uaMethodArgument = new UAMethodArgumentImpl();
		return uaMethodArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UANode createUANode() {
		UANodeImpl uaNode = new UANodeImpl();
		return uaNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UANodeSetChangesStatusType createUANodeSetChangesStatusType() {
		UANodeSetChangesStatusTypeImpl uaNodeSetChangesStatusType = new UANodeSetChangesStatusTypeImpl();
		return uaNodeSetChangesStatusType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UANodeSetChangesType createUANodeSetChangesType() {
		UANodeSetChangesTypeImpl uaNodeSetChangesType = new UANodeSetChangesTypeImpl();
		return uaNodeSetChangesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UANodeSetType createUANodeSetType() {
		UANodeSetTypeImpl uaNodeSetType = new UANodeSetTypeImpl();
		return uaNodeSetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UAObject createUAObject() {
		UAObjectImpl uaObject = new UAObjectImpl();
		return uaObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UAObjectType createUAObjectType() {
		UAObjectTypeImpl uaObjectType = new UAObjectTypeImpl();
		return uaObjectType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UAReferenceType createUAReferenceType() {
		UAReferenceTypeImpl uaReferenceType = new UAReferenceTypeImpl();
		return uaReferenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UAType createUAType() {
		UATypeImpl uaType = new UATypeImpl();
		return uaType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UAVariable createUAVariable() {
		UAVariableImpl uaVariable = new UAVariableImpl();
		return uaVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UAVariableType createUAVariableType() {
		UAVariableTypeImpl uaVariableType = new UAVariableTypeImpl();
		return uaVariableType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UAView createUAView() {
		UAViewImpl uaView = new UAViewImpl();
		return uaView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UriTable createUriTable() {
		UriTableImpl uriTable = new UriTableImpl();
		return uriTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueType createValueType() {
		ValueTypeImpl valueType = new ValueTypeImpl();
		return valueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueType1 createValueType1() {
		ValueType1Impl valueType1 = new ValueType1Impl();
		return valueType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypePurpose createDataTypePurposeFromString(EDataType eDataType, String initialValue) {
		DataTypePurpose result = DataTypePurpose.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataTypePurposeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReleaseStatus createReleaseStatusFromString(EDataType eDataType, String initialValue) {
		ReleaseStatus result = ReleaseStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReleaseStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long createAccessLevelFromString(EDataType eDataType, String initialValue) {
		return (Long)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.UNSIGNED_INT, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAccessLevelToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.UNSIGNED_INT, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long createAccessLevelObjectFromString(EDataType eDataType, String initialValue) {
		return createAccessLevelFromString(NodeSetPackage.Literals.ACCESS_LEVEL, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAccessLevelObjectToString(EDataType eDataType, Object instanceValue) {
		return convertAccessLevelToString(NodeSetPackage.Literals.ACCESS_LEVEL, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Short createAccessRestrictionFromString(EDataType eDataType, String initialValue) {
		return (Short)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.UNSIGNED_BYTE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAccessRestrictionToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.UNSIGNED_BYTE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Short createAccessRestrictionObjectFromString(EDataType eDataType, String initialValue) {
		return createAccessRestrictionFromString(NodeSetPackage.Literals.ACCESS_RESTRICTION, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAccessRestrictionObjectToString(EDataType eDataType, Object instanceValue) {
		return convertAccessRestrictionToString(NodeSetPackage.Literals.ACCESS_RESTRICTION, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createArrayDimensionsFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.TOKEN, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertArrayDimensionsToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.TOKEN, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<String> createCardinalityTypeFromString(EDataType eDataType, String initialValue) {
		if (initialValue == null) return null;
		List<String> result = new ArrayList<String>();
		for (String item : split(initialValue)) {
			result.add(createCardinalityTypeItemFromString(NodeSetPackage.Literals.CARDINALITY_TYPE_ITEM, item));
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCardinalityTypeToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) return null;
		List<?> list = (List<?>)instanceValue;
		if (list.isEmpty()) return "";
		StringBuffer result = new StringBuffer();
		for (Object item : list) {
			result.append(convertCardinalityTypeItemToString(NodeSetPackage.Literals.CARDINALITY_TYPE_ITEM, item));
			result.append(' ');
		}
		return result.substring(0, result.length() - 1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createCardinalityTypeItemFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCardinalityTypeItemToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypePurpose createDataTypePurposeObjectFromString(EDataType eDataType, String initialValue) {
		return createDataTypePurposeFromString(NodeSetPackage.Literals.DATA_TYPE_PURPOSE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataTypePurposeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDataTypePurposeToString(NodeSetPackage.Literals.DATA_TYPE_PURPOSE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double createDurationFromString(EDataType eDataType, String initialValue) {
		return (Double)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.DOUBLE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDurationToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.DOUBLE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double createDurationObjectFromString(EDataType eDataType, String initialValue) {
		return createDurationFromString(NodeSetPackage.Literals.DURATION, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDurationObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDurationToString(NodeSetPackage.Literals.DURATION, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Short createEventNotifierFromString(EDataType eDataType, String initialValue) {
		return (Short)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.UNSIGNED_BYTE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEventNotifierToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.UNSIGNED_BYTE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Short createEventNotifierObjectFromString(EDataType eDataType, String initialValue) {
		return createEventNotifierFromString(NodeSetPackage.Literals.EVENT_NOTIFIER, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEventNotifierObjectToString(EDataType eDataType, Object instanceValue) {
		return convertEventNotifierToString(NodeSetPackage.Literals.EVENT_NOTIFIER, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createLocaleFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLocaleToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createNodeIdFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNodeIdToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createQualifiedNameFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQualifiedNameToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReleaseStatus createReleaseStatusObjectFromString(EDataType eDataType, String initialValue) {
		return createReleaseStatusFromString(NodeSetPackage.Literals.RELEASE_STATUS, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReleaseStatusObjectToString(EDataType eDataType, Object instanceValue) {
		return convertReleaseStatusToString(NodeSetPackage.Literals.RELEASE_STATUS, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<String> createSymbolicNameFromString(EDataType eDataType, String initialValue) {
		if (initialValue == null) return null;
		List<String> result = new ArrayList<String>();
		for (String item : split(initialValue)) {
			result.add(createSymbolicNameItemFromString(NodeSetPackage.Literals.SYMBOLIC_NAME_ITEM, item));
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSymbolicNameToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) return null;
		List<?> list = (List<?>)instanceValue;
		if (list.isEmpty()) return "";
		StringBuffer result = new StringBuffer();
		for (Object item : list) {
			result.append(convertSymbolicNameItemToString(NodeSetPackage.Literals.SYMBOLIC_NAME_ITEM, item));
			result.append(' ');
		}
		return result.substring(0, result.length() - 1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createSymbolicNameItemFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSymbolicNameItemToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer createValueRankFromString(EDataType eDataType, String initialValue) {
		return (Integer)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.INT, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertValueRankToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.INT, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer createValueRankObjectFromString(EDataType eDataType, String initialValue) {
		return createValueRankFromString(NodeSetPackage.Literals.VALUE_RANK, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertValueRankObjectToString(EDataType eDataType, Object instanceValue) {
		return convertValueRankToString(NodeSetPackage.Literals.VALUE_RANK, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long createWriteMaskFromString(EDataType eDataType, String initialValue) {
		return (Long)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.UNSIGNED_INT, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWriteMaskToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.UNSIGNED_INT, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long createWriteMaskObjectFromString(EDataType eDataType, String initialValue) {
		return createWriteMaskFromString(NodeSetPackage.Literals.WRITE_MASK, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWriteMaskObjectToString(EDataType eDataType, Object instanceValue) {
		return convertWriteMaskToString(NodeSetPackage.Literals.WRITE_MASK, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeSetPackage getNodeSetPackage() {
		return (NodeSetPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NodeSetPackage getPackage() {
		return NodeSetPackage.eINSTANCE;
	}

} //NodeSetFactoryImpl
