package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.widgets.Shell;

import at.ac.at.tuwien.modelua.papyrus.opcua.diagram.transformation.OpcUaDiagramTransformationResources;
import at.ac.at.tuwien.modelua.papyrus.opcua.diagram.transformation.transformer.SynchHandler;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.ui.Utils;
import at.ac.tuwien.auto.modelua.papyrus.opcua.preferences.PreferenceProvider;

public class ImportNodeSetHandler extends AbstractHandler {
	
	private static final String FILEDIALOG_TITLE ="Select Model file";
	private static final String[] FILEDIALOG_EXTENSIONS = { "*.uml" };
	
	private static final String SUCCESS_TITLE ="NodeSet Import";
	private static final String SUCCESS_TEXT ="NodeSet imported successfully";

	private static final String ERROR_TITLE ="NodeSet Import Error";
	private static final String ERROR_TEXT ="An error occured while importing the Nodeset, please check the error logs!";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// has to done before opening the file dialog otherwise the handle will be lost
		URI uriWithoutExtension = Utils.getModelPath(event);
		
		if(OpcUaDiagramTransformationResources.DIAGRAM_SYNCH_HANDLER == null)
		{
			return null;
		}
		
		SynchHandler handler = OpcUaDiagramTransformationResources.DIAGRAM_SYNCH_HANDLER;
		
		if(handler.modelIsRegistered(uriWithoutExtension))
		{			
			Shell shell = Utils.getShell(event);
			
			String defaultPath = PreferenceProvider.getImportPath();
			
			if(defaultPath == null || defaultPath.length() == 0)
			{
				defaultPath = Utils.getWorkspacePath();
			}
			
			String filepath = Utils.openFileDialoag(shell, FILEDIALOG_TITLE, false, defaultPath , FILEDIALOG_EXTENSIONS, uriWithoutExtension.lastSegment());
			if(filepath == null)
			{
				return null;
			}
			
			boolean success = handler.importNodeSetFrom(uriWithoutExtension, filepath);
			
			if(success)
			{				
				Utils.openSuccessDialog(shell, SUCCESS_TITLE, SUCCESS_TEXT);
			}
			else
			{
				Utils.openErrorDialog(shell, ERROR_TITLE, ERROR_TEXT);
			}
		}
		return null;
	}

}
