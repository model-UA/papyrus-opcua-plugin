package at.ac.tuwien.auto.modelua.papyrus.opcua.console;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;

public class OpcUaConsoleFactory implements IConsoleFactory {
	
	public static final String CONSOLE_NAME= "OPC UA Console";
	
	@Override
	public void openConsole() {
		IConsoleManager consoleManager = ConsolePlugin.getDefault().getConsoleManager();
		MessageConsole console = new MessageConsole(CONSOLE_NAME, null);
	    consoleManager.addConsoles( new IConsole[] { console } );
	    consoleManager.showConsoleView( console );
	}

}
