package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.listener.DiagramChangeListener;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.listener.FileChangeListener;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformer.SynchHandler;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "at.ac.tuwien.auto.modelua.papyrus.opcua.diagram"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	private static SynchHandler nodeSetUmlSynchHandler;
	private static FileChangeListener nodeSetChangedListener;
	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		nodeSetUmlSynchHandler = new SynchHandler();
		nodeSetChangedListener = new FileChangeListener();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(nodeSetChangedListener);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(nodeSetChangedListener);
		DiagramChangeListener.disable(true);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	public static SynchHandler getSynchHandler() {
		return nodeSetUmlSynchHandler;
	}
	
	public static FileChangeListener getFileChangeListener() {
		return nodeSetChangedListener;
	}

}
