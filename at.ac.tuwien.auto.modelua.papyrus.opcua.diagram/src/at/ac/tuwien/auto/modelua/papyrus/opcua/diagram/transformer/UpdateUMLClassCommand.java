package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformer;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Class;

public class UpdateUMLClassCommand extends RecordingCommand {

	private InstanceSyncHandler handler;
	private Class obj;
	private boolean success = false;
	
	public UpdateUMLClassCommand(TransactionalEditingDomain domain) {
		super(domain);
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
		this.success = this.handler.transformClass(this.obj);
	}
	
	public boolean getCommandResult()
	{
		return this.success;
	}

}
