package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.transformer;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Model;

public class ImportNodeSetCommand extends RecordingCommand {
	
	private Model importModel;
	private Model baseModel;
	
	public ImportNodeSetCommand(TransactionalEditingDomain domain) {
		super(domain);
	}

	@Override
	protected void doExecute() {
		this.baseModel.createPackageImport(this.importModel);
		
	}

	public void setImportModel(Model modelimport) {
		this.importModel = modelimport;
	}

	public void setBaseModel(Model baseUmlModel) {
		this.baseModel = baseUmlModel;
	}

}
