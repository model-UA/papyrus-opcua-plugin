package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.ui;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.ui.util.ServiceUtilsForSelection;


public class Utils {
	
	public static Shell getShell(ExecutionEvent event)
	{
		Event trigger = (Event) event.getTrigger();
		Shell shell = trigger.display.getActiveShell();
		return shell;
		
	}
	
	public static URI getModelPath(ExecutionEvent event)
	{
		// Get selection from handler event
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		ModelSet modelSetSelection = null;
		try {
			modelSetSelection = ServiceUtilsForSelection.getInstance().getModelSet(selection);
		} catch (ServiceException e) {
			return null;
		}
		URI uriWithoutExtension = modelSetSelection.getURIWithoutExtension();
		return uriWithoutExtension.appendFileExtension("uml");
	}
	
	public static void openSuccessDialog(Shell shell, String title, String text)
	{
		MessageBox dialog = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
		dialog.setText(title);
		dialog.setMessage(text);
		dialog.open();
	}
	
	public static void openErrorDialog(Shell shell, String title, String text)
	{
		MessageBox dialog = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
		dialog.setText(title);
		dialog.setMessage(text);
		dialog.open();
	}
	
	public static String getWorkspacePath()
	{
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IPath workspacePath = root.getLocation();	
		return workspacePath.toOSString();
	}
		
	public static String openFileDialoag(Shell shell, String title, boolean safeDialog,  String filepath)
	{
		return openFileDialoag(shell, title, safeDialog, filepath, null, null);
	}

	public static String openFileDialoag(Shell shell, String title, boolean safeDialog,  String[] extensions)
	{
		return openFileDialoag(shell, title, safeDialog, null, extensions, null);
	}

	public static String openFileDialoag(Shell shell, String title, boolean safeDialog,  String filepath, String[] extensions)
	{
		return openFileDialoag(shell, title, safeDialog, filepath, extensions, null);
	}
	
	public static String openFileDialoag(Shell shell, String title, boolean safeDialog, String[] extensions, String filename)
	{
		return openFileDialoag(shell, title, safeDialog, null, extensions, filename);
	}
	
	public static String openFileDialoag(Shell shell, String title, boolean safeDialog,  String filepath, String filename)
	{
		return openFileDialoag(shell, title, safeDialog, filepath, null, filename);
	}
	
	
	public static String openFileDialoag(Shell shell, String title, boolean safeDialog,  String filepath, String[] extensions, String filename)
	{
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		
        IPath workspacePath = root.getLocation();
		
        int style = SWT.OPEN;
        if(safeDialog)
        {
        	style = SWT.SAVE;
        }
		FileDialog dialog = new FileDialog(shell, style);
		dialog.setText(title);
		if(extensions != null)
		{
			dialog.setFilterExtensions(extensions);
		}
		if(filepath != null)
		{
			dialog.setFilterPath(workspacePath.toOSString());
		}
		if(filename != null)
		{			
			dialog.setFileName(filename);
		}
		
		return dialog.open();
	}
	
}
