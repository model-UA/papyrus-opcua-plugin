package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.widgets.Shell;

import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.OpcUaDiagramResources;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformer.SynchHandler;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.ui.Utils;
import at.ac.tuwien.auto.modelua.papyrus.opcua.preferences.PreferenceProvider;

public class ExportNodeSetHandler extends AbstractHandler {

	private static final String FILEDIALOG_TITLE ="Select Export file location";
	private static final String[] FILEDIALOG_EXTENSIONS = { "*.xml" };
	
	private static final String SUCCESS_TITLE ="NodeSet Export";
	private static final String SUCCESS_TEXT ="NodeSet successfully exported:\n";

	private static final String ERROR_TITLE ="NodeSet Export Error";
	private static final String ERROR_TEXT ="An error occured while exporting the Nodeset, please check the error logs!";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		// has to done before opening the file dialog otherwise the handle will be lost
		URI uriWithoutExtension = Utils.getModelPath(event);
		
		if(OpcUaDiagramResources.DIAGRAM_SYNCH_HANDLER == null)
		{
			return null;
		}
		
		SynchHandler handler = OpcUaDiagramResources.DIAGRAM_SYNCH_HANDLER;
		
		if(handler.modelIsRegistered(uriWithoutExtension))
		{			
			Shell shell = Utils.getShell(event);
			
			String defaultPath = PreferenceProvider.getExportPath();
			
			if(defaultPath == null || defaultPath.length() == 0)
			{
				defaultPath = Utils.getWorkspacePath();
			}
				
			String filepath = Utils.openFileDialoag(shell, FILEDIALOG_TITLE, true, defaultPath, FILEDIALOG_EXTENSIONS, uriWithoutExtension.lastSegment());
			if(filepath == null)
			{
				return null;
			}
			
			boolean success = handler.exportNodeSetTo(uriWithoutExtension, filepath);
			
			if(success)
			{				
				Utils.openSuccessDialog(shell, SUCCESS_TITLE, SUCCESS_TEXT+filepath);
			}
			else
			{
				Utils.openErrorDialog(shell, ERROR_TITLE, ERROR_TEXT);
			}
		}
		
		return null;
	}
	
}
