package at.ac.tuwien.auto.modelua.papyrus.opcua.preferences.pages;

import org.eclipse.jface.preference.*;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;
import at.ac.tuwien.auto.modelua.papyrus.opcua.preferences.Activator;
import at.ac.tuwien.auto.modelua.papyrus.opcua.preferences.listener.SetEditorEnabledListener;

public class MainPreferencesPage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	
	private static final String IMPORT_DIRECTORY_EDITOR_TEXT = "Default Import Directory:";
	private DirectoryFieldEditor importDirectoryEditor;
	
	private static final String EXPORT_DIRECTORY_EDITOR_TEXT = "Default Export Directory:";
	private DirectoryFieldEditor exportDirectoryEditor;
	
	private static final String NODEID_SCHEME_EDITOR_TEXT ="NodeId-Scheme";
	private static final String[][] NODEID_SCHEMES ={ 	{"Automatic Detection", "auto" },
			{"String", "string" },
//			{"Integer", "int" },
//			{"Custom", "custom" }
	};
	private RadioGroupFieldEditor nodeIdSchemeRadioGroupEditor;
	
	private static final String AUTOGEN_NODEID_EDITOR_TEXT ="Automically generate NodeIds";
	private BooleanFieldEditor autogenerateNodeIdBooleanEditor;
	
	private static final String AUTOLOAD_NODESET_EDITOR_TEXT ="Automically reload NodeSet if underlaying NodeSet file changed";
	private BooleanFieldEditor autoloadNodeSetBooleanEditor;
		
	private static final String AUTOGENERATE_NODESET_EDITOR_TEXT ="Automically generate a NodeSet file on save inside default export directory";
	private BooleanFieldEditor autoGenerateNodeSetBooleanEditor;
	
	private static final String REPLICATE_WORKSPACE_HIERARCHY_EDITOR_TEXT ="Create folder hierarchy of NodeSet file inside default export folder";
	private BooleanFieldEditor replicateWorkspaceHierarchyBooleanEditor;
	
	private SetEditorEnabledListener enableReplication;
	
	public MainPreferencesPage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Preference Page for OPC UA modelling");
	}
	
	public void initEditors()
	{
		Composite parent = getFieldEditorParent();
		this.importDirectoryEditor = new DirectoryFieldEditor(
				PreferenceConstants.IMPORT_PATH, 
				IMPORT_DIRECTORY_EDITOR_TEXT , 
				parent );
		
		this.exportDirectoryEditor = new DirectoryFieldEditor(
				PreferenceConstants.EXPORT_PATH, 
				EXPORT_DIRECTORY_EDITOR_TEXT , 
				parent );
		
		this.nodeIdSchemeRadioGroupEditor = new RadioGroupFieldEditor(
				PreferenceConstants.NODEID_SCHEME,
				NODEID_SCHEME_EDITOR_TEXT,
			1,
			NODEID_SCHEMES, getFieldEditorParent());
		
//		this.autogenerateNodeIdBooleanEditor = new BooleanFieldEditor(
//				PreferenceConstants.NODEID_AUTOFILL,
//				AUTOGEN_NODEID_EDITOR_TEXT,
//				parent);
		
		this.autoloadNodeSetBooleanEditor = new BooleanFieldEditor(
				PreferenceConstants.NODEID_AUTOFILL,
				AUTOLOAD_NODESET_EDITOR_TEXT,
				parent);
		
		this.autoGenerateNodeSetBooleanEditor = new BooleanFieldEditor(
				PreferenceConstants.NODESET_AUTO_EXPORT,
				AUTOGENERATE_NODESET_EDITOR_TEXT,
				parent);
		
		
		this.replicateWorkspaceHierarchyBooleanEditor = new BooleanFieldEditor(
				PreferenceConstants.CREATE_FOLDER_HIERARCHY,
				REPLICATE_WORKSPACE_HIERARCHY_EDITOR_TEXT,
				parent);			
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		
		initEditors();
		
		addField(this.importDirectoryEditor);
		addField(this.exportDirectoryEditor);
		addField(this.nodeIdSchemeRadioGroupEditor);
//		addField(this.autsogenerateNodeIdBooleanEditor);
		addField(this.autoloadNodeSetBooleanEditor);
		addField(this.autoGenerateNodeSetBooleanEditor);
		addField(this.replicateWorkspaceHierarchyBooleanEditor);
//		addField(new StringFieldEditor(PreferenceConstants.CUSTOM_NODEID_PREFERENCE, "Custom NodeId Scheme format:", getFieldEditorParent()));
	}
	
	@Override
	protected void initialize() {
	    super.initialize();
	    this.enableReplication =  new SetEditorEnabledListener(this.replicateWorkspaceHierarchyBooleanEditor, getFieldEditorParent());
		this.autoGenerateNodeSetBooleanEditor.setPropertyChangeListener(this.enableReplication);
		
		if(!this.autoGenerateNodeSetBooleanEditor.getBooleanValue())
		{
			this.replicateWorkspaceHierarchyBooleanEditor.setEnabled(false, getFieldEditorParent());
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		
	}
	public void setHierarchyReplicationEnabled(boolean enabled) {
		this.replicateWorkspaceHierarchyBooleanEditor.setEnabled(enabled, getFieldEditorParent());
	}
	
}