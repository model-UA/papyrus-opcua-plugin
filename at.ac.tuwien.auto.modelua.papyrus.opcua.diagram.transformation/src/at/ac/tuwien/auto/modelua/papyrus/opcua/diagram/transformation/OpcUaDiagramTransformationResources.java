package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation;

public class OpcUaDiagramTransformationResources {
	public static SynchHandler DIAGRAM_SYNCH_HANDLER = Activator.getSynchHandler();
	
	public class EventConstants{
		public static final String TOPIC ="at/ac/tuwien/auto/modelua/papyrus/opcua/diagram/transformation/events";
		public static final String ALLTOPICS = TOPIC+"/*";
		
		public static final String IMPORT_STATUS=TOPIC+"/importStatus";
		public static final String EXPORT_STATUS=TOPIC+"/exportStatus";
		public static final String UODATE_STATUS=TOPIC+"/updateStatus"; 
		
		public static final String TRANSFORM_OPCUA_TOPIC = TOPIC+"/transformOpcUa";
		public static final String TRANSFORM_OPCUA_ALLTOPICS = TRANSFORM_OPCUA_TOPIC+"/*";
		public static final String TRANSFORM_OPCUA_DONE_TOPIC = TRANSFORM_OPCUA_TOPIC+"/transformationDone";
		public static final String TRANSFORM_OPCUA_NODESET_TOPIC = TRANSFORM_OPCUA_TOPIC+"/transformOpcUaNodeSet";
		
		public static final String TRANSFORM_OPCUA_NAMESPACE_TOPIC = TRANSFORM_OPCUA_TOPIC+"/transformNamespaces";
		public static final String TRANSFORM_OPCUA_ALIAS_TABLE_TOPIC = TRANSFORM_OPCUA_TOPIC+"/transformAliasTable";
		public static final String TRANSFORM_OPCUA_PURGE_OLD_ELEMENTS_TOPIC = TRANSFORM_OPCUA_TOPIC+"/purgeOldElements";
		
		public static final String TRANSFORM_OPCUA_UADATA_TYPES_TOPIC = TRANSFORM_OPCUA_TOPIC+"/transformOpcUaDataTypes";
		public static final String TRANSFORM_OPCUA_UAMETHODS_TOPIC = TRANSFORM_OPCUA_TOPIC+"/transformOpcUaMethods";
		public static final String TRANSFORM_OPCUA_UAOBJECT_TYPES_TOPIC = TRANSFORM_OPCUA_TOPIC+"/transformOpcUaObjecTypes";
		public static final String TRANSFORM_OPCUA_UAOBJECTS_TOPIC = TRANSFORM_OPCUA_TOPIC+"/transformOpcUaObjects";
		public static final String TRANSFORM_OPCUA_UAREFERENCE_TYPES_TOPIC = TRANSFORM_OPCUA_TOPIC+"/transformOpcUaReferenceTypes";
		public static final String TRANSFORM_OPCUA_UAVARIABLE_TYPES_TOPIC = TRANSFORM_OPCUA_TOPIC+"/transformOpcUaVariableTypes";
		public static final String TRANSFORM_OPCUA_UAVARIABLES_TOPIC = TRANSFORM_OPCUA_TOPIC+"/transformOpcUaVariables";
		public static final String TRANSFORM_OPCUA_UAVIEWS_TOPIC = TRANSFORM_OPCUA_TOPIC+"/transformOpcUaViews";
		
		public static final String TRANSFORM_OPCUA_REFERENCES_TOPIC = TRANSFORM_OPCUA_TOPIC+"/transformReferences";
		public static final String TRANSFORM_OPCUA_ROLEPERMISSIONS_TOPIC = TRANSFORM_OPCUA_TOPIC+"/transformRolePermissions";
		public static final String TRANSFORM_OPCUA_DATATYPE_DEFINITIONS_TOPIC = TRANSFORM_OPCUA_TOPIC+"/transformDataTypeDefinitions";
		public static final String TRANSFORM_OPCUA_MODELS_TOPIC = TRANSFORM_OPCUA_TOPIC+"/transformModels";
		
		public static final String TRANSFORM_UML_TOPIC = TOPIC+"/transformUml";
		public static final String TRANSFORM_UML_ALLTOPICS = TRANSFORM_UML_TOPIC+"/*";
		public static final String TRANSFORM_UML_CLASS_ALLTOPICS = TRANSFORM_UML_TOPIC+"/transformUmlClass";
		public static final String TRANSFORM_UML_GENERALIZATIONS_ALLTOPICS = TRANSFORM_UML_TOPIC+"/transformUmlGeneralizations";
		public static final String TRANSFORM_UML_PACKAGE_ALLTOPICS = TRANSFORM_UML_TOPIC+"/transformUmlPackage";
	}
}
