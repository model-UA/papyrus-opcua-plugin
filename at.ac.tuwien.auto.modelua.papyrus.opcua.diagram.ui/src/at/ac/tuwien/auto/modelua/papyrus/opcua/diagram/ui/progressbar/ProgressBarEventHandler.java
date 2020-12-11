package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.ui.progressbar;

import java.util.ArrayList;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.event.Event;

import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.OpcUaDiagramTransformationResources;

public class ProgressBarEventHandler implements org.osgi.service.event.EventHandler {
	
	private static ArrayList<String> topics = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 498634481507657420L;

		{
			add(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_ALLTOPICS);
			add(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_UML_ALLTOPICS);
		}
	};
	public ProgressBarEventHandler() {
		// TODO Auto-generated constructor stub
		Object service = PlatformUI.getWorkbench().getService(IEventBroker.class);
		if (service instanceof IEventBroker) 
		{
			IEventBroker broker = (IEventBroker) service;
			for(String topic : topics)
			{				
				broker.subscribe(topic, this);
			}
		}
	}

	@Override
	public void handleEvent(Event event) {
		// TODO Auto-generated method stub
		System.out.println(event.getTopic());
	}

}