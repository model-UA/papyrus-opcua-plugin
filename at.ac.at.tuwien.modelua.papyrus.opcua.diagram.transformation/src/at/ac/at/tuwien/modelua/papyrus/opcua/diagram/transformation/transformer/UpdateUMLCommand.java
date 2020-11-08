package at.ac.at.tuwien.modelua.papyrus.opcua.diagram.transformation.transformer;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;

public class UpdateUMLCommand extends RecordingCommand {

	private InstanceSyncHandler handler;
	private UANodeSetType nodeset;
	private boolean success = false;
	
	public UpdateUMLCommand(TransactionalEditingDomain domain) {
		super(domain);
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
		this.success = this.handler.updateMember(this.nodeset);
	}
	
	public boolean getCommandResult()
	{
		return this.success;
	}

}
