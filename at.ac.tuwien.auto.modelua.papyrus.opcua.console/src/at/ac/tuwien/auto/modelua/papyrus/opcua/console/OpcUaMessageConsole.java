package at.ac.tuwien.auto.modelua.papyrus.opcua.console;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import at.ac.tuwien.auto.modelua.papyrus.opcua.preferences.PreferenceConstants;
import at.ac.tuwien.auto.modelua.papyrus.opcua.preferences.PreferenceProvider;

public class OpcUaMessageConsole {
	
	private static boolean init_done=false;
	
	public static final String CONSOLE_NAME= "OPC UA Console";
	public static final String DEBUG_PREFIX= "[DEBUG]:";
	public static final String INFO_PREFIX= "[INFO]:";
	public static final String WARNING_PREFIX= "[WARNING]:";
	public static final String ERROR_PREFIX= "[ERROR]:";
	
	private static MessageConsole console;
	private static MessageConsoleStream debug_stream;
	private static MessageConsoleStream info_stream;
	private static MessageConsoleStream warning_stream;
	private static MessageConsoleStream error_stream;
	
	public static void initConsole() {
		if(!init_done)
		{
			ConsolePlugin plugin = ConsolePlugin.getDefault();
			IConsoleManager conMan = plugin.getConsoleManager();
			IConsole[] existing = conMan.getConsoles();
			
			boolean console_exists=false;
			
			for (int i = 0; i < existing.length; i++)
			{
				if (CONSOLE_NAME.equals(existing[i].getName()))
				{
					console =  (MessageConsole) existing[i];		
					console_exists = true;
					break;
				}
			}
			
			if(! console_exists)
			{
				//no console found, so create a new one
				console = new MessageConsole(CONSOLE_NAME, null);
				conMan.addConsoles(new IConsole[]{console});
			}
			
			
			Color debug_color = Display.getCurrent().getSystemColor(SWT.COLOR_BLUE);
			debug_stream = console.newMessageStream();
			debug_stream.setColor(debug_color);
			
			Color info_color = Display.getCurrent().getSystemColor(SWT.COLOR_BLACK);
			info_stream = console.newMessageStream();
			info_stream.setColor(info_color);

			Color warning_color = Display.getCurrent().getSystemColor(SWT.COLOR_DARK_YELLOW);
			warning_stream = console.newMessageStream();
			warning_stream.setColor(warning_color);

			Color error_color = Display.getCurrent().getSystemColor(SWT.COLOR_RED);
			error_stream = console.newMessageStream();
			error_stream.setColor(error_color);

			init_done = true;
		}
	}
	
	public static void dispose()
	{
		console.destroy();
	}
	
	public static void clear()
	{
		console.clearConsole();
	}
	
	public static MessageConsole getConsole() {
		if(console == null)
		{			
			initConsole();
		}
		return console;
	}
	
	public static void showConsole()
	{
		if(!init_done)
		{
			initConsole();
		}
		
		IConsoleManager conMan = ConsolePlugin.getDefault().getConsoleManager();
		conMan.showConsoleView( console );
	}
	
	public static void debug(String text)
	{
		if(PreferenceProvider.getLogLevel() <= PreferenceConstants.LOG_LEVEL_DEBUG)
		{
			if(debug_stream == null)
			{
				initConsole();
			}
			
			debug_stream.println(DEBUG_PREFIX + text);
		}
	}
	
	public static void info(String text)
	{
		if(PreferenceProvider.getLogLevel() <= PreferenceConstants.LOG_LEVEL_INFO)
		{
			if(info_stream == null)
			{
				initConsole();
			}
			
			info_stream.println(INFO_PREFIX + text);
		}
	}
	
	public static void warning(String text)
	{
		if(PreferenceProvider.getLogLevel() <= PreferenceConstants.LOG_LEVEL_WARNING)
		{
			if(warning_stream == null)
			{
				initConsole();
			}
			
			warning_stream.println(WARNING_PREFIX + text);
		}
	}
	
	public static void error(String text)
	{
		if(PreferenceProvider.getLogLevel() <= PreferenceConstants.LOG_LEVEL_ERROR)
		{
			if(error_stream == null)
			{
				initConsole();
			}
			
			error_stream.println(ERROR_PREFIX + text);
		}
	}
}
