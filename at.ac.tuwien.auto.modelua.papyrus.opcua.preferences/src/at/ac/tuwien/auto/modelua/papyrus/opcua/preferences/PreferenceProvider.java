package at.ac.tuwien.auto.modelua.papyrus.opcua.preferences;

import org.eclipse.jface.preference.IPreferenceStore;

import at.ac.tuwien.auto.modelua.papyrus.opcua.preferences.pages.PreferenceConstants;

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
	
	public static boolean getAutofileNodeIds()
	{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		boolean autofill = store.getBoolean(PreferenceConstants.NODEID_AUTOFILL);
		
		return autofill;
	}
	
	public static String getNodeIdSchema()
	{
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String schema = store.getString(PreferenceConstants.NODEID_SCHEME);
		
		return schema;
	}
}
