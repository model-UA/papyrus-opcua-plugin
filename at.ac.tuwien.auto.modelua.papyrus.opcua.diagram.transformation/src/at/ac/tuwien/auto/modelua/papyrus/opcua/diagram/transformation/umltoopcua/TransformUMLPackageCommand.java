package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.umltoopcua;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Package;

public class TransformUMLPackageCommand extends RecordingCommand {

	private UmlToOpcUaTransformer handler;
	private Package obj;
	private boolean success = false;
	
	public TransformUMLPackageCommand(TransactionalEditingDomain domain) {
		super(domain);
	}

	public void registerInstanceSynchHandler(UmlToOpcUaTransformer handler)
	{
		this.handler = handler;
	}
	
	public void setPackage(Package obj)
	{
		this.obj = obj;
	}
	
	@Override
	protected void doExecute() {
		this.success = this.handler.transformNamespace(this.obj);
	}
	
	public boolean getCommandResult()
	{
		return this.success;
	}

}
