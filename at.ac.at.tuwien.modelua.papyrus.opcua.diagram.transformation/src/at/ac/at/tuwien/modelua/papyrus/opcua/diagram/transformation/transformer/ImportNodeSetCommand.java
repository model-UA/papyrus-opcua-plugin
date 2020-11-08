package at.ac.at.tuwien.modelua.papyrus.opcua.diagram.transformation.transformer;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Model;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;

public class ImportNodeSetCommand extends RecordingCommand {
	
	private Model importModel;
	private Model baseModel;
	private boolean success = false;
	
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
