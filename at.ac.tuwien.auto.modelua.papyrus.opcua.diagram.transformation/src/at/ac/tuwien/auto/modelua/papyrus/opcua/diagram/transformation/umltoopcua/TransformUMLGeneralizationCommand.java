package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.umltoopcua;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Generalization;

public class TransformUMLGeneralizationCommand extends RecordingCommand {

	private UmlToOpcUaTransformer handler;
	private Generalization obj;
	private boolean success = false;
	
	public TransformUMLGeneralizationCommand(TransactionalEditingDomain domain) {
		super(domain);
	}

	public void registerInstanceSynchHandler(UmlToOpcUaTransformer handler)
	{
		this.handler = handler;
	}
	
	public void setGeneralization(Generalization obj)
	{
		this.obj = obj;
	}
	
	@Override
	protected void doExecute() {
		this.success = this.handler.transformGeneralization(this.obj);
	}
	
	public boolean getCommandResult()
	{
		return this.success;
	}

}
