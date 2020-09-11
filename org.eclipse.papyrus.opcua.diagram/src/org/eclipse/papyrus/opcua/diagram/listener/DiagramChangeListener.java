package org.eclipse.papyrus.opcua.diagram.listener;

import java.util.HashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.opcua.diagram.Activator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;

public class DiagramChangeListener implements IPapyrusListener {
	
	HashMap<Model, Boolean> autotransform_model;
	private static boolean disabled = false;
	
	public DiagramChangeListener() {
		// TODO Auto-generated constructor stub
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
			System.out.println("Do transformation and Storage");
			Element elem = (Element) notifier ;
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
		else
		{
			System.out.println("Don't do transformation and Storage");
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
			EList<NamedElement> members = new BasicEList<NamedElement>();
			members.addAll(currentModel.getOwnedMembers());

			disabled = true;
			try {
				members.forEach((member) -> Activator.getSynchHandler().updateObject(member));
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
				EList<NamedElement> members = currentModel.getOwnedMembers();
				for(NamedElement member : members )
				{
					disabled = true;
					try {
						Activator.getSynchHandler().updateObject(member);				
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

	

}
