package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.opcuatouml;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;

public class TransformOpcUaCommand extends RecordingCommand {

	private OpcUaToUmlTransformer transformer;
	private UANodeSetType nodeset;
	private boolean success = false;
	
	public TransformOpcUaCommand(TransactionalEditingDomain domain, OpcUaToUmlTransformer transformer,UANodeSetType nodeSet) {
		super(domain);
		this.transformer = transformer;
		this.nodeset = nodeSet;
	}
	
	@Override
	protected void doExecute() {
		this.success = this.transformer.transformMember(this.nodeset);
	}
	
	public boolean getCommandResult()
	{
		return this.success;
	}

}
