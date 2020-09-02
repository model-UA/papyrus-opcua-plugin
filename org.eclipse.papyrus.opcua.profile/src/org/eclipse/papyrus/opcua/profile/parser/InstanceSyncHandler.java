package org.eclipse.papyrus.opcua.profile.parser;

import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObject;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObjectType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UANodeSetTypeImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;

public class InstanceSyncHandler {
	
	private Model baseUmlModel;
	private UANodeSetType baseNodeset;
	
	public InstanceSyncHandler(Model umlModel)
	{
		this.baseUmlModel = umlModel;
	}
	
	public InstanceSyncHandler(UANodeSetType nodeset)
	{
		this.baseNodeset = nodeset;
	}
	
	public InstanceSyncHandler(Model umlModel, UANodeSetType nodeset)
	{
		this.baseUmlModel = umlModel;
		this.baseNodeset = nodeset;
	}
	
	public void setNodeSetObject(UANodeSetType nodeset)
	{
		this.baseNodeset = nodeset;
	}
	
	public void setUmlModel (Model umlModel)
	{
		this.baseUmlModel = umlModel;
	}
		
	public boolean syncNodeSetToUml()
	{
		return false;
	}
	
	public boolean syncUmlToNodeSet()
	{
		return false;
	}
	
	public boolean updateMember(Element object)
	{
		return false;
	}
	
	private boolean updateClass(Class object)
	{
		return false;
	}
	
	private boolean updatedDataType(DataType object)
	{
		return false;
	}
	
	public boolean updatedMember(UAObject object)
	{
		return false;
	}
	
	public boolean updatedMember(UAObjectType object)
	{
		return false;
	}

}
