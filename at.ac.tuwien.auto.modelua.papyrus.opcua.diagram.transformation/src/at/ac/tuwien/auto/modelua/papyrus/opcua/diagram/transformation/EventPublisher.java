package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation;

import java.util.HashMap;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.ui.PlatformUI;

public class EventPublisher {
	
	private static boolean enabled = true;
	
	public static void enableEvents(boolean enable)
	{
		enabled = enable;
	}
	
	public static boolean publishEvent(String eventId, Object data) {
		if(enabled)
		{
			Object service = PlatformUI.getWorkbench().getService(IEventBroker.class);
			if (service instanceof IEventBroker) {
				((IEventBroker) service).post(eventId, data);
				return true;
			}
			return false;
		} 
		return true;
	}
	
	public static boolean publishEvent(String eventId, int current, int total) {
		if(enabled)
		{
			Object service = PlatformUI.getWorkbench().getService(IEventBroker.class);
			if (service instanceof IEventBroker) {
				HashMap<String, Object> data = new HashMap<String, Object>();
				data.put("value_type", "absolute");
				data.put("current", current);
				data.put("total", total);
	
				((IEventBroker) service).post(eventId, data);
				return true;
			}
			return false;
		}
		return true;
	}
	
	public static boolean publishEvent(String eventId, int worked) {
		if(enabled)
		{
			Object service = PlatformUI.getWorkbench().getService(IEventBroker.class);
			if (service instanceof IEventBroker) {
				HashMap<String, Object> data = new HashMap<String, Object>();
				data.put("value_type", "delta");
				data.put("worked", worked);
				
				((IEventBroker) service).post(eventId, data);
				return true;
			}
	
			return false;
		}
		return true;
	}
}
