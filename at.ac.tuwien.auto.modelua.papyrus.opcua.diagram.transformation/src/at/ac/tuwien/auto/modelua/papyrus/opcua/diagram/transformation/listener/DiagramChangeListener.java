package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.listener;

import java.util.HashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;

import at.ac.tuwien.auto.modelua.papyrus.opcua.console.OpcUaMessageConsole;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.Activator;

public class DiagramChangeListener implements IPapyrusListener {
	
	HashMap<Model, Boolean> autotransform_model;
	private static boolean disabled = false;
	
	public DiagramChangeListener() {
		super();
		this.autotransform_model = new HashMap<Model, Boolean>();
	}
	
	public static void disable(boolean disable)
	{
		disabled = disable;
	}
	
	@Override
	public void notifyChanged(Notification notification) {

		if(disabled)
		{
			return;
		}
		
		Object notifier = notification.getNotifier();
		Model currentModel;
		
		if(notifier != null && notifier instanceof Element)
		{
			currentModel = ((Element) notifier).getModel();
		}
		else
		{
			return;
		}
		
		boolean transform = shall_be_auto_transformed(currentModel);
		
		if(transform)
		{
			Element elem = (Element) notifier ;
			printNotficationType(notification);
			
			if(notification.getEventType() == Notification.REMOVE || 
				notification.getEventType() == Notification.REMOVE_MANY)
			{
				Model mod = elem.getModel();
				elem = (Element)notification.getOldValue();
				
				disabled = true;
				try {
					Activator.getSynchHandler().removeObject(mod, elem);					
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				finally {
					disabled = false;
				}
			}
			else if(notification.getEventType() == Notification.REMOVING_ADAPTER)
			{
				return;
			}
			else //if(notification.getEventType() == Notification.ADD ||
				//	notification.getEventType() == Notification.SET )
			{				
				disabled = true;
				try {
					Activator.getSynchHandler().updateObject(elem);				
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				finally {
					disabled = false;
				}
			}
		}
	}
	
	public boolean shall_be_auto_transformed(Model currentModel)
	{
		if(currentModel == null)
		{
			return false;
		}
		
		boolean auto_transform = shall_be_transformed(currentModel);
		
		if(!this.autotransform_model.containsKey(currentModel))
		{
			this.autotransform_model.put(currentModel, auto_transform);
			Activator.getSynchHandler().registerNewUmlModel(currentModel);
			
			disabled = true;
			try {
				Activator.getSynchHandler().initModel(currentModel);				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				disabled = false;
			}

		}
		else if(! this.autotransform_model.get(currentModel))
		{
			boolean old_state = this.autotransform_model.get(currentModel);
			this.autotransform_model.replace(currentModel, auto_transform);
			if(old_state != auto_transform)
			{
				Activator.getSynchHandler().registerNewUmlModel(currentModel);

				disabled = true;
				try {
					Activator.getSynchHandler().initModel(currentModel);				
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				finally {
					disabled = false;
				}
			}
		}
				
		return this.autotransform_model.get(currentModel);
	}
	
	
	public boolean shall_be_transformed(Model currentModel)
	{
		if(currentModel == null)
		{
			return false;
		}
		
		boolean transform = is_informationmodel(currentModel);
		
		return transform;
	}
	
	public boolean is_informationmodel(Model currentModel)
	{
		if(currentModel == null) 
		{
			return false;	
		}
		
		String vp = currentModel.getViewpoint();
		if(vp != null && vp.contains("InformationModel"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private void printNotficationType(Notification notification)
	{
		if(notification.getEventType() == Notification.ADD)
		{
			OpcUaMessageConsole.debug("ADD");
		}
		else if( notification.getEventType() == Notification.ADD_MANY)
		{
			OpcUaMessageConsole.debug("ADD_MANY");
		
		}
		else if( notification.getEventType() == Notification.EVENT_TYPE_COUNT)
		{
			
			OpcUaMessageConsole.debug("EVENT_TYPE_COUNT");
		}
		else if( notification.getEventType() == Notification.MOVE)
		{
			OpcUaMessageConsole.debug("MOVE");
		
		}
		else if( notification.getEventType() == Notification.NO_FEATURE_ID)
		{
			OpcUaMessageConsole.debug("NO_FEATURE_ID");
		
		}
		else if( notification.getEventType() == Notification.NO_INDEX)
		{
			OpcUaMessageConsole.debug("NO_INDEX");
		}
		else if( notification.getEventType() == Notification.REMOVE)
		{
			OpcUaMessageConsole.debug("REMOVE");
		
		}
		else if( notification.getEventType() == Notification.REMOVE_MANY)
		{
			OpcUaMessageConsole.debug("REMOVE_MANY");
		
		}
		else if( notification.getEventType() == Notification.REMOVING_ADAPTER)
		{
			OpcUaMessageConsole.debug("REMOVING_ADAPTER");
		
		}
		else if( notification.getEventType() == Notification.RESOLVE)
		{
			OpcUaMessageConsole.debug("RESOLVE");
		
		}
		else if( notification.getEventType() == Notification.SET)
		{
			OpcUaMessageConsole.debug("SET");
		
		}
		else if( notification.getEventType() == Notification.UNSET)
		{
			OpcUaMessageConsole.debug("UNSET");
		
		}
	}

}
