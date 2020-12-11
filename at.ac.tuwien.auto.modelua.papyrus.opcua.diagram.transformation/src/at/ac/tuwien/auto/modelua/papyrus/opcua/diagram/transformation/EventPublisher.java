package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.ui.PlatformUI;

public class EventPublisher {

	public static boolean publishEvent(String eventId, Object data) {
		Object service = PlatformUI.getWorkbench().getService(IEventBroker.class);
		  if (service instanceof IEventBroker) {
		   ((IEventBroker) service).post(eventId, data);
		   return true;
		  }
		  
		  return false;
	}

}
