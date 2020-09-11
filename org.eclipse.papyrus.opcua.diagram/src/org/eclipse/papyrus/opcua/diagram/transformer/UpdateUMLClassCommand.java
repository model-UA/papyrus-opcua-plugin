package org.eclipse.papyrus.opcua.diagram.transformer;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Class;

public class UpdateUMLClassCommand extends RecordingCommand {

	private InstanceSyncHandler handler;
	private Class obj;
	private boolean success = false;
	
	public UpdateUMLClassCommand(TransactionalEditingDomain domain) {
		super(domain);
		// TODO Auto-generated constructor stub
	}

	public void registerInstanceSynchHandler(InstanceSyncHandler handler)
	{
		this.handler = handler;
	}
	
	public void setClass(Class obj)
	{
		this.obj = obj;
	}
	
	@Override
	protected void doExecute() {
		// TODO Auto-generated method stub
		this.success = this.handler.updateClass(this.obj);
	}
	
	public boolean getCommandResult()
	{
		return this.success;
	}

}
