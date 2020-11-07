package at.ac.tuwien.auto.modelua.papyrus.opcua.preferences.pages;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import at.ac.tuwien.auto.modelua.papyrus.opcua.preferences.Activator;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.NODEID_AUTOFILL, true);
		store.setDefault(PreferenceConstants.NODESET_AUTO_RELOAD, true);
		store.setDefault(PreferenceConstants.NODESET_AUTO_EXPORT, false);
		store.setDefault(PreferenceConstants.CREATE_FOLDER_HIERARCHY, false);
		store.setDefault(PreferenceConstants.NODEID_SCHEME, "auto");
		// store.setDefault(PreferenceConstants.CUSTOM_NODEID_PREFERENCE, "{qualified-name}");
	}

}
