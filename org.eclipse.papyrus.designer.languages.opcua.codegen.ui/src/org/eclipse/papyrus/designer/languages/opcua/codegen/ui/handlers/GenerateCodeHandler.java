package org.eclipse.papyrus.designer.languages.opcua.codegen.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.uml.diagram.common.handlers.CmdHandler;

public class GenerateCodeHandler extends CmdHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("OPC-UA Information Model generation execution!");
		return null;
	}

}
