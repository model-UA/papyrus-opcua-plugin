package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram;

import at.ac.tuwien.auto.modelua.papyrus.opcua.console.OpcUaMessageConsole;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "at.ac.tuwien.auto.modelua.papyrus.opcua.diagram"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		OpcUaMessageConsole.debug("Starting diagram plugin");
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		OpcUaMessageConsole.debug("Stopping diagram plugin");
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
