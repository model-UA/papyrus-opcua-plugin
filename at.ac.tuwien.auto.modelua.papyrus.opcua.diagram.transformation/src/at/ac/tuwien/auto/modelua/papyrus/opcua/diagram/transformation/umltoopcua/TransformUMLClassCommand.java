package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.umltoopcua;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Class;

public class TransformUMLClassCommand extends RecordingCommand {

	private UmlToOpcUaTransformer handler;
	private Class obj;
	private boolean success = false;
	
	public TransformUMLClassCommand(TransactionalEditingDomain domain) {
		super(domain);
	}

	public void registerInstanceSynchHandler(UmlToOpcUaTransformer handler)
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
