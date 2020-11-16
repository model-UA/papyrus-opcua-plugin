package at.ac.tuwien.auto.modelua.papyrus.opcua.preferences;

import org.eclipse.jface.preference.IPreferenceStore;

public class PreferenceProvider {

	public static String getExportPath()
	{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String exportPath = store.getString(PreferenceConstants.EXPORT_PATH);
		
		return exportPath;
	}
	
	public static String getImportPath()
	{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String importPath = store.getString(PreferenceConstants.IMPORT_PATH);
		
		return importPath;
	}
	
	public static String getNodeIdSchema()
	{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String schema = store.getString(PreferenceConstants.NODEID_SCHEME);
		
		return schema;
	}
	
	public static boolean getAutofileNodeIds()
	{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		boolean autofill = store.getBoolean(PreferenceConstants.NODEID_AUTOFILL);
		
		return autofill;
	}
	
	public static boolean getNodeSetAutoReload()
	{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		boolean autofill = store.getBoolean(PreferenceConstants.NODESET_AUTO_RELOAD);
		
		return autofill;
	}
	
	public static boolean getNodeSetAutoExport()
	{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		boolean autofill = store.getBoolean(PreferenceConstants.NODESET_AUTO_EXPORT);
		
		return autofill;
	}

	public static boolean getCreateWorkspaceFolderHierarchyInExportDir()
	{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		boolean autofill = store.getBoolean(PreferenceConstants.CREATE_FOLDER_HIERARCHY);
		
		return autofill;
	}
	
	public static int getLogLevel()
	{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		int loglevel = Integer.valueOf(store.getString(PreferenceConstants.LOG_LEVEL));
		
		return loglevel;
	}

}
