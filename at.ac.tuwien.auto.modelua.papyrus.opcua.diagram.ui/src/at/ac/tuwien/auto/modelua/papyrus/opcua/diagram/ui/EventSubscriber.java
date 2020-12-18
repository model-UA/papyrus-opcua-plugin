package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.ui;

import java.util.ArrayList;

import org.osgi.service.event.EventHandler;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.ui.PlatformUI;

import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.OpcUaDiagramTransformationResources;

public class EventSubscriber {
	
	EventHandler handler;
	
	public EventSubscriber(ArrayList<String> topics, EventHandler handler) {
		this.handler = handler;
		Object service = PlatformUI.getWorkbench().getService(IEventBroker.class);
		if (service instanceof IEventBroker) 
		{
			IEventBroker broker = (IEventBroker) service;
			for(String topic : topics)
			{				
				broker.subscribe(topic, handler);
			}
		}
	}
	
	public void unsubscribe()
	{
		Object service = PlatformUI.getWorkbench().getService(IEventBroker.class);
		if (service instanceof IEventBroker) 
		{
			IEventBroker broker = (IEventBroker) service;
			broker.unsubscribe(handler);
		}
	}
	
}