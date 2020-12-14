package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.ui.jobs;

import java.util.ArrayList;
import java.util.HashMap;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.event.EventHandler;

import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.OpcUaDiagramTransformationResources;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.SynchHandler;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.ui.EventSubscriber;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.ui.Utils;

import org.osgi.service.event.Event;

public class UpdateNodeSetJob extends Job implements EventHandler {
		
	private URI uri;
	private String filepath;
	private Shell shell;
	private IProgressMonitor monitor;
	private EventSubscriber es;
	
	private static final String SUCCESS_TITLE ="NodeSet Update";
	private static final String SUCCESS_TEXT ="NodeSet updated successfully";

	private static final String ERROR_TITLE ="NodeSet Update Error";
	private static final String ERROR_TEXT ="An error occured while updating the Nodeset, please check the error logs!";

	
	private static ArrayList<String> topics = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 498634481507657420L;

		{
			add(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_ALLTOPICS);
		}
	};
	
	public UpdateNodeSetJob(URI uri, String filepath, Shell shell) {
		super("Update Nodeset");
		this.uri = uri;
		this.filepath = filepath;
		this.shell = shell;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		SynchHandler handler = OpcUaDiagramTransformationResources.DIAGRAM_SYNCH_HANDLER;
		
		if(handler.modelIsRegistered(uri))
		{
			this.es = new EventSubscriber(topics, this);
			this.monitor = monitor; 
			// the modification of the NodeSet
			boolean success = handler.updateNodeSetFrom(this.uri, this.filepath);
			// The Eclipses doesn't like openening dialogs outside of the UI Thread
			shell.getDisplay().syncExec(() -> {
				if(success)
				{				
					Utils.openSuccessDialog(this.shell, SUCCESS_TITLE, SUCCESS_TEXT);
				}
				else
				{
					Utils.openErrorDialog(this.shell, ERROR_TITLE, ERROR_TEXT);
				}
			});
			
			return Status.OK_STATUS;
		}
		else
		{
			monitor.setCanceled(true);
			return Status.CANCEL_STATUS;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleEvent(Event event) {
		// TODO Auto-generated method stub
		HashMap<String, Object> data = (HashMap<String, Object>) event.getProperty("org.eclipse.e4.data");
		switch(event.getTopic())
		{
		case OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_NODESET_TOPIC:
			int total_steps =  (int)data.get("total");
			this.monitor.beginTask("Transform NodeSet",total_steps);
			break;
		case OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_NAMESPACE_TOPIC:
			this.monitor.subTask("Transforming Namespaces");
			this.monitor.worked((int)data.get("worked"));
			break;
		case OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_ALIAS_TABLE_TOPIC:
			this.monitor.subTask("Transforming Alias Table");
			this.monitor.worked((int)data.get("worked"));
			break;
		case OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_PURGE_OLD_ELEMENTS_TOPIC:
			this.monitor.subTask("Removing not existing Nodes");
			this.monitor.worked((int)data.get("worked"));
			break;
		case OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAOBJECT_TYPES_TOPIC:
			this.monitor.subTask("Transforming UAObjectTypes");
			this.monitor.worked((int)data.get("worked"));
			break;
		case OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAVARIABLE_TYPES_TOPIC:
			this.monitor.subTask("Transforming UAVariableTypes");
			this.monitor.worked((int)data.get("worked"));
			break;
		case OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UADATA_TYPES_TOPIC:
			this.monitor.subTask("Transforming UADataTypes");
			this.monitor.worked((int)data.get("worked"));
			break;
		case OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAREFERENCE_TYPES_TOPIC:
			this.monitor.subTask("Transforming UAReferenceTypes");
			this.monitor.worked((int)data.get("worked"));
			break;
		case OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAOBJECTS_TOPIC:
			this.monitor.subTask("Transforming UAObjects");
			this.monitor.worked((int)data.get("worked"));
			break;
		case OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAVARIABLES_TOPIC:
			this.monitor.subTask("Transforming UAVariables");
			this.monitor.worked((int)data.get("worked"));
			break;
		case OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAMETHODS_TOPIC:
			this.monitor.subTask("Transforming UAMethods");
			this.monitor.worked((int)data.get("worked"));
			break;
		case OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAVIEWS_TOPIC:
			this.monitor.subTask("Transforming UAViews");
			this.monitor.worked((int)data.get("worked"));
			break;
		case OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_REFERENCES_TOPIC:
			this.monitor.subTask("Setting References");
			this.monitor.worked((int)data.get("worked"));
			break;
		case OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_ROLEPERMISSIONS_TOPIC:
			this.monitor.subTask("Transforming Rolepermissions");
			this.monitor.worked((int)data.get("worked"));
			break;
		case OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_DATATYPE_DEFINITIONS_TOPIC:
			this.monitor.subTask("Transforming Datatype Definitions");
			this.monitor.worked((int)data.get("worked"));
			break;
		case OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_MODELS_TOPIC:
			this.monitor.subTask("Transforming Model Entries");
			this.monitor.worked((int)data.get("worked"));
			break;
		case OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_DONE_TOPIC:
			this.monitor.done();
			this.es.unsubscribe();
			break;
		}
	}
	
}
