package at.ac.tuwien.auto.modelua.papyrus.opcua.preferences.pages;

import org.eclipse.jface.preference.*;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;
import at.ac.tuwien.auto.modelua.papyrus.opcua.preferences.Activator;

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
	
	private static final String AUTOFILL_NODEID_EDITOR_TEXT ="Automically generate NodeIds";
	private BooleanFieldEditor autofillNodeIdBooleanEditor;
	
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
		
		this.autofillNodeIdBooleanEditor = new BooleanFieldEditor(
				PreferenceConstants.NODEID_AUTOFILL,
				AUTOFILL_NODEID_EDITOR_TEXT,
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
		addField(this.autofillNodeIdBooleanEditor);
		

//		addField(new StringFieldEditor(PreferenceConstants.CUSTOM_NODEID_PREFERENCE, "Custom NodeId Scheme format:", getFieldEditorParent()));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		String test="sadfsa";
	}
	
}