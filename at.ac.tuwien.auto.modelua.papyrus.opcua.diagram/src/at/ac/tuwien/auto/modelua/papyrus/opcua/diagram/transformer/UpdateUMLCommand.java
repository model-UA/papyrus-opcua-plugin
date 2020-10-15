package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformer;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;

public class UpdateUMLCommand extends RecordingCommand {

	private InstanceSyncHandler handler;
	private UANodeSetType nodeset;
	private boolean success = false;
	
	public UpdateUMLCommand(TransactionalEditingDomain domain) {
		super(domain);
		// TODO Auto-generated constructor stub
	}

	public void registerInstanceSynchHandler(InstanceSyncHandler handler)
	{
		this.handler = handler;
	}
	
	public void setNodeSet(UANodeSetType nodeSet)
	{
		this.nodeset = nodeSet;
	}
	
	@Override
	protected void doExecute() {
		// TODO Auto-generated method stub
		this.success = this.handler.updateMember(this.nodeset);
	}
	
	public boolean getCommandResult()
	{
		return this.success;
	}

}
