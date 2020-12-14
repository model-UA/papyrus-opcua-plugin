package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.opcuatouml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Stereotype;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.AliasTable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.DataTypeDefinition;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.DataTypeField;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.DataTypePurpose;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.LocalizedText;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.ModelTable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.ModelTableEntry;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeIdAlias;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.Reference;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.ReleaseStatus;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.RolePermission;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.StructureTranslationType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.TranslationType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UADataType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAInstance;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAMethod;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAMethodArgument;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANode;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObject;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObjectType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAReferenceType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariableType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAView;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UriTable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.ModelTableImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.RolePermissionImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UADataTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAMethodImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAObjectImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAObjectTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAReferenceTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAVariableImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAVariableTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAViewImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UriTableImpl;

import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.EventPublisher;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.OpcUaDiagramTransformationResources;
import at.ac.tuwien.auto.modelua.papyrus.opcua.libraries.OpcUaLibraryResources;
import at.ac.tuwien.auto.modelua.papyrus.opcua.preferences.PreferenceProvider;

public class OpcUaToUmlTransformer {
	
	private Model baseUmlModel;
	private UANodeSetType baseNodeset;
	private HashMap<Element, Object> matching;
	private HashMap<String, Element> nodeIdMap;
	private HashMap<String, String> aliasTable;
	
	public OpcUaToUmlTransformer(Model umlModel, UANodeSetType nodeset, HashMap<Element, Object> matching, HashMap<String, Element> nodeIdMap)
	{
		this.baseUmlModel = umlModel;
		this.baseNodeset = nodeset;
		this.matching = matching;
		this.nodeIdMap = nodeIdMap;
		this.aliasTable = new HashMap<String, String>();
	}
			
	public boolean transformNodeSet(UANodeSetType nodeset)
	{
		
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(this.baseUmlModel);
		
		// changes to diagrams shall be done inside commands
		TransformOpcUaCommand cmd = new TransformOpcUaCommand(domain, this, nodeset);
		
		domain.getCommandStack().execute(cmd);
		
		return cmd.getCommandResult();
	}
	

	public int calculateWorkunits(UANodeSetType nodeset)
	{
		int workunits = 0;
    	ArrayList<UAInstance> uaInstanceReferences = new ArrayList<UAInstance>();
		
		if(nodeset.getNamespaceUris() != null) {    		
			workunits += nodeset.getNamespaceUris().getUri().size();
    	}		
		if(nodeset.getAliases() != null) {    		
			workunits += nodeset.getAliases().getAlias().size();
    	}
		
		// Todo: calculate workunits for purging old elements
				
		if(nodeset.getUAObjectType() != null || this.baseNodeset.getUAObjectType() != null)
    	{ 
    		EList<UAObjectType> uaTypes = nodeset.getUAObjectType();
    		ArrayList<String> nodeIds = new ArrayList<String>();
    		if(uaTypes != null)
    		{
				for(UAObjectType t : uaTypes)
	    		{
					workunits++;
	    			if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
	    			{
	    				workunits++;
	    			}
	    			
	    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
	    			{
	    				workunits++;
	    			}
	    			nodeIds.add(t.getNodeId());
	    		}
    		}
    		
    		if(this.baseNodeset.getUAObjectType() != null)
        	{   
    			uaTypes = this.baseNodeset.getUAObjectType();

        		for(UAObjectType type : uaTypes)
        		{
        			if(!nodeIds.contains(type.getNodeId()))
        			{
        				workunits++;
        			}
        		}
        	}
    		
    	}
		
		if(nodeset.getUAVariableType() != null || this.baseNodeset.getUAVariableType() != null)
    	{ 
    		EList<UAVariableType> uaTypes = nodeset.getUAVariableType();
    		ArrayList<String> nodeIds = new ArrayList<String>();
    		
    		if(uaTypes != null)
    		{    			
    			for(UAVariableType t : uaTypes)
    			{
    				workunits++;
    				if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    				{
    					workunits++;
    				}
    				
    				if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    				{
    					workunits++;
    				}
    				nodeIds.add(t.getNodeId());
    			}
    		}
    		
    		if(this.baseNodeset.getUAVariableType() != null)
        	{   
    			uaTypes = this.baseNodeset.getUAVariableType();

        		for(UAVariableType type : uaTypes)
        		{
        			if(!nodeIds.contains(type.getNodeId()))
        			{
        				workunits++;
        			}
        		}
        	}
    	}
		
		if(nodeset.getUAReferenceType() != null || this.baseNodeset.getUAReferenceType() != null)
    	{ 
    		EList<UAReferenceType> uaTypes = nodeset.getUAReferenceType();
    		ArrayList<String> nodeIds = new ArrayList<String>();
    		
    		if(uaTypes != null)
    		{
				for(UAReferenceType t : uaTypes)
	    		{
					workunits+=3;
	    			
	    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
	    			{
	    				workunits++;
	    			}
	    			nodeIds.add(t.getNodeId());
	    		}
    		}
    		
    		if(this.baseNodeset.getUAVariableType() != null)
        	{   
    			uaTypes = this.baseNodeset.getUAReferenceType();

        		for(UAReferenceType type : uaTypes)
        		{
        			if(!nodeIds.contains(type.getNodeId()))
        			{
        				workunits++;
        			}
        		}
        	}
    	}
		
		if(nodeset.getUADataType() != null || this.baseNodeset.getUADataType() != null)
    	{ 
    		EList<UADataType> uaTypes = nodeset.getUADataType();
    		ArrayList<String> nodeIds = new ArrayList<String>();
    		
    		if(uaTypes != null)
    		{    			
    			for(UADataType t : uaTypes)
    			{
    				workunits++;
    				if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    				{
    					workunits++;
    				}
    				
    				if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    				{
    					workunits++;
    				}
    				
    				if(t.getDefinition() != null )
    				{
    					workunits++;
    				}
    				nodeIds.add(t.getNodeId());
    			}
    		}
    		
    		if(this.baseNodeset.getUADataType() != null)
        	{   
    			uaTypes = this.baseNodeset.getUADataType();

        		for(UADataType type : uaTypes)
        		{
        			if(!nodeIds.contains(type.getNodeId()))
        			{
        				workunits++;
        			}
        		}
        	}
    	}
		
		if(nodeset.getUAObject() != null || this.baseNodeset.getUAObject() != null)
    	{
			EList<UAObject> uaObjects = nodeset.getUAObject();
			ArrayList<String> nodeIds = new ArrayList<String>();
			
			if(uaObjects != null)
			{
	    		for(UAObject t : uaObjects)
	    		{
	    			if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
	    			{
	    				uaInstanceReferences.add(t);
	    				workunits++;
	    			}
	    			
	    			if(t.getParentNodeId() != null && t.getParentNodeId().length() > 0)
	    			{
	    				workunits++;
	    			}
	    			
	    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
	    			{
	    				workunits++;
	    			}
	    			nodeIds.add(t.getNodeId());
	    		}
			}
			
			if(this.baseNodeset.getUAObject() != null)
        	{   
				uaObjects = this.baseNodeset.getUAObject();

        		for(UAObject type : uaObjects)
        		{
        			if(!nodeIds.contains(type.getNodeId()))
        			{
        				workunits++;
        			}
        		}
        	}
    	}
		
		if(nodeset.getUAVariable() != null|| this.baseNodeset.getUAVariable() != null)
    	{	
			EList<UAVariable> uaVariables = nodeset.getUAVariable();
			ArrayList<String> nodeIds = new ArrayList<String>();
			if(uaVariables != null)
			{				
				for(UAVariable t : uaVariables)
				{
					if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
					{
						uaInstanceReferences.add(t);
						workunits++;
					}
					if((t.getParentNodeId() != null && t.getParentNodeId().length() > 0) ||
							t.getDataType() != null && t.getDataType().length() > 0)
					{
						workunits++;
					}
					
					if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
					{
						workunits++;
					}
					nodeIds.add(t.getNodeId());
				}
			}
			

			if(this.baseNodeset.getUAVariable() != null)
        	{   
				uaVariables = this.baseNodeset.getUAVariable();

        		for(UAVariable type : uaVariables)
        		{
        			if(!nodeIds.contains(type.getNodeId()))
        			{
        				workunits++;
        			}
        		}
        	}
    	}  
		
		if(nodeset.getUAMethod() != null || this.baseNodeset.getUAMethod() != null)
    	{    		
    		EList<UAMethod> uaMethods = nodeset.getUAMethod();
    		ArrayList<String> nodeIds = new ArrayList<String>();
    		
    		if(uaMethods != null)
    		{    			
    			for(UAMethod t : uaMethods)
    			{
    				if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    				{
    					uaInstanceReferences.add(t);
    					workunits++;
    				}
    				if(t.getParentNodeId() != null && t.getParentNodeId().length() > 0)
    				{
    					workunits++;
    				}
    				if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    				{
    					workunits++;
    				}
    				if(t.getMethodDeclarationId() != null && t.getMethodDeclarationId().length() > 0 && 
    						!uaInstanceReferences.contains(t))
    				{
    					uaInstanceReferences.add(t);
    					workunits++;
    				}
    				nodeIds.add(t.getNodeId());
    			}
    		}
    		
    		if(this.baseNodeset.getUAMethod() != null)
        	{   
    			uaMethods = this.baseNodeset.getUAMethod();

        		for(UAMethod type : uaMethods)
        		{
        			if(!nodeIds.contains(type.getNodeId()))
        			{
        				workunits++;
        			}
        		}
        	}
    	}
		
		if(nodeset.getUAView() != null || this.baseNodeset.getUAView() != null)
    	{    		
    		EList<UAView> uaViews = nodeset.getUAView();
    		ArrayList<String> nodeIds = new ArrayList<String>();
    		
    		if(uaViews != null)
    		{
    			for(UAView t : uaViews)
    			{
    				if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    				{
    					workunits++;
    				}
    				if(t.getParentNodeId() != null && t.getParentNodeId().length() > 0)
    				{
    					uaInstanceReferences.add(t);
    					workunits++;
    				}
    				if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    				{
    					workunits++;
    				}
    				nodeIds.add(t.getNodeId());
    			}    			
    		}
    		if(this.baseNodeset.getUAView() != null)
        	{   
    			uaViews = this.baseNodeset.getUAView();

        		for(UAView type : uaViews)
        		{
        			if(!nodeIds.contains(type.getNodeId()))
        			{
        				workunits++;
        			}
        		}
        	}
    	}
		
		if(nodeset.getModels() != null )
    	{
			workunits += nodeset.getModels().getModel().size();
    	}
		
		return workunits;
	}
	
	protected boolean transformMember(UANodeSetType nodeset)
	{
        // Implement your write operations here,
    	boolean success = true;
    	int workUnits = calculateWorkunits(nodeset);
    	EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_NODESET_TOPIC, 0, workUnits);
    	
    	EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_NAMESPACE_TOPIC, 0);
    	if(nodeset.getNamespaceUris() != null) {    		
    		int namespaces = nodeset.getNamespaceUris().getUri().size();
    		success &= transformNamespaces(nodeset.getNamespaceUris());
    		EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_NAMESPACE_TOPIC, namespaces);
       	}

    	EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_ALIAS_TABLE_TOPIC, 0);
    	if(nodeset.getAliases() != null) {    		
    		int aliases = nodeset.getAliases().getAlias().size();
    		success &= transformAliasTable(nodeset.getAliases());
    		EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_ALIAS_TABLE_TOPIC, aliases);
    	}
    	
    
    	// Delete all nodes which are not part of the loaded NodeSet
    	EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_PURGE_OLD_ELEMENTS_TOPIC, 1);
    	success &= removeMissingElements(nodeset);
    	
    	ArrayList<UANode> referenceNodes = new ArrayList<UANode>();
    	ArrayList<UANode> rolePermissionNodes = new ArrayList<UANode>();
    	ArrayList<UAInstance> uaInstanceReferences = new ArrayList<UAInstance>();
    	ArrayList<UADataType> dataTypeDefinitions = new ArrayList<UADataType>();
    	ArrayList<UAReferenceType> referenceTypes = new ArrayList<UAReferenceType>();

    	EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAOBJECT_TYPES_TOPIC, 0);
    	if(nodeset.getUAObjectType() != null)
    	{    		
    		// adding and removing needs to be done via list otherwise 
    		// ConcurrentModificationException
    		EList<UAObjectType> uaObjectTypes = nodeset.getUAObjectType();
    		List<UAObjectType> nodesToAdd = new ArrayList<UAObjectType>();
    		List<UAObjectType> nodesToDelete = new ArrayList<UAObjectType>();

    		for(UAObjectType t : uaObjectTypes)
    		{
    			if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    			{
    				referenceNodes.add(t);
    			}
    			
    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    			{
    				rolePermissionNodes.add(t);
    			}
    			
    			success &= transformUAObjectType(t, nodesToAdd, nodesToDelete);
    			if(!success)
    			{
    				success &= transformUAObjectType(t, nodesToAdd, nodesToDelete);
    				break;
    			}
    			EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAOBJECT_TYPES_TOPIC, 1);	
    		}
    		
    		// Important first remove old elements than add new ones
    		this.baseNodeset.getUAObjectType().removeAll(nodesToDelete);
    		this.baseNodeset.getUAObjectType().addAll(nodesToAdd);

    	}
    	
    	EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAVARIABLE_TYPES_TOPIC, 0);
    	if(nodeset.getUAVariableType() != null)
    	{    		
    		// adding and removing needs to be done via list otherwise 
    		// ConcurrentModificationException
    		EList<UAVariableType> uaVariableTypes = nodeset.getUAVariableType();
    		List<UAVariableType> nodesToAdd = new ArrayList<UAVariableType>();
    		List<UAVariableType> nodesToDelete = new ArrayList<UAVariableType>();
    		
    		
    		for(UAVariableType t : uaVariableTypes)
    		{
    			if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    			{
    				referenceNodes.add(t);
    			}
    			
    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    			{
    				rolePermissionNodes.add(t);
    			}
    			
    			success &= transformUAVariableType(t, nodesToAdd, nodesToDelete);
    			if(!success)
    			{
    				success &= transformUAVariableType(t, nodesToAdd, nodesToDelete);
    				break;
    			}
    			EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAVARIABLE_TYPES_TOPIC, 1);
    		}
    		
    		// Important first remove old elements than add new ones
    		this.baseNodeset.getUAVariableType().removeAll(nodesToDelete);
    		this.baseNodeset.getUAVariableType().addAll(nodesToAdd);
    	}
    	
    	EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UADATA_TYPES_TOPIC, 0);
    	if(nodeset.getUADataType() != null)
    	{    		
    		// adding and removing needs to be done via list otherwise 
    		// ConcurrentModificationException
    		EList<UADataType> uaDataTypes = nodeset.getUADataType();
    		List<UADataType> nodesToAdd = new ArrayList<UADataType>();
    		List<UADataType> nodesToDelete = new ArrayList<UADataType>();
    		
    		for(UADataType t : uaDataTypes)
    		{
    			if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    			{
    				referenceNodes.add(t);
    			}
    			
    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    			{
    				rolePermissionNodes.add(t);
    			}
    			
    			if(t.getDefinition() != null )
    			{
    				dataTypeDefinitions.add(t);
    			}
    			
    			success &= transformUADataType(t, nodesToAdd, nodesToDelete);
    			if(!success)
    			{
    				success &= transformUADataType(t, nodesToAdd, nodesToDelete);
    				break;
    			}
    			EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UADATA_TYPES_TOPIC, 1);
    		}
    		
    		// Important first remove old elements than add new ones
    		this.baseNodeset.getUADataType().removeAll(nodesToDelete);
    		this.baseNodeset.getUADataType().addAll(nodesToAdd);
    	}
		
    	EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAREFERENCE_TYPES_TOPIC, 0);
    	if(nodeset.getUAReferenceType() != null)
    	{    		
    		// adding and removing needs to be done via list otherwise 
    		// ConcurrentModificationException
    		EList<UAReferenceType> uaReferenceTypes = nodeset.getUAReferenceType();
    		List<UAReferenceType> nodesToAdd = new ArrayList<UAReferenceType>();
    		List<UAReferenceType> nodesToDelete = new ArrayList<UAReferenceType>();
    		
    		for(UAReferenceType t : uaReferenceTypes)
    		{
    			referenceTypes.add(t);
    			
    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    			{
    				rolePermissionNodes.add(t);
    			}
    			
    			success &= transformUAReferenceType(t, nodesToAdd, nodesToDelete);

    			if(!success)
    			{
    				success &= transformUAReferenceType(t, nodesToAdd, nodesToDelete);
    				break;
    			}
    			EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAREFERENCE_TYPES_TOPIC, 1);
    		}
    		
    		// Important first remove old elements than add new ones
    		this.baseNodeset.getUAReferenceType().removeAll(nodesToDelete);
    		this.baseNodeset.getUAReferenceType().addAll(nodesToAdd);
    	}
    	
    	EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAOBJECTS_TOPIC, 0);
    	if(nodeset.getUAObject() != null)
    	{
    		// adding and removing needs to be done via list otherwise 
    		// ConcurrentModificationException
			EList<UAObject> uaObjects = nodeset.getUAObject();
    		List<UAObject> nodesToAdd = new ArrayList<UAObject>();
    		List<UAObject> nodesToDelete = new ArrayList<UAObject>();
    		
    		for(UAObject t : uaObjects)
    		{
    			if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    			{
    				referenceNodes.add(t);
    			}
    			
    			if(t.getParentNodeId() != null && t.getParentNodeId().length() > 0)
    			{
    				uaInstanceReferences.add(t);
    			}
    			
    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    			{
    				rolePermissionNodes.add(t);
    			}
    			
    			success &= transformUAObject(t, nodesToAdd, nodesToDelete);
    			if(!success)
    			{
    				success &= transformUAObject(t, nodesToAdd, nodesToDelete);
    				break;
    			}
    			EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAOBJECTS_TOPIC, 1);
    		}
    		
    		// Important first remove old elements than add new ones
    		this.baseNodeset.getUAObject().removeAll(nodesToDelete);
    		this.baseNodeset.getUAObject().addAll(nodesToAdd);
    	}
    	
    	// Important!
    	// UAVariable depends on DataTypes --> DataTypes need to be parsed first
    	EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAVARIABLES_TOPIC, 0);
    	if(nodeset.getUAVariable() != null)
    	{	
    		// adding and removing needs to be done via list otherwise 
    		// ConcurrentModificationException
			EList<UAVariable> uaVariables = nodeset.getUAVariable();
    		List<UAVariable> nodesToAdd = new ArrayList<UAVariable>();
    		List<UAVariable> nodesToDelete = new ArrayList<UAVariable>();
    		
    		for(UAVariable t : uaVariables)
    		{
    			if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    			{
    				referenceNodes.add(t);
    			}
    			if((t.getParentNodeId() != null && t.getParentNodeId().length() > 0) ||
					t.getDataType() != null && t.getDataType().length() > 0)
    			{
    				uaInstanceReferences.add(t);
    			}
    			
    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    			{
    				rolePermissionNodes.add(t);
    			}
    			
    			success &= transformUAVariable(t, nodesToAdd, nodesToDelete);
    			if(!success)
    			{
    				success &= transformUAVariable(t, nodesToAdd, nodesToDelete);
    				break;
    			}
    			EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAVARIABLES_TOPIC, 1);
    		}
    		
    		// Important first remove old elements than add new ones
    		this.baseNodeset.getUAVariable().removeAll(nodesToDelete);
    		this.baseNodeset.getUAVariable().addAll(nodesToAdd);
    	}  
    	
    	EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAMETHODS_TOPIC, 0);
    	if(nodeset.getUAMethod() != null)
    	{    		

    		// adding and removing needs to be done via list otherwise 
    		// ConcurrentModificationException
    		EList<UAMethod> uaMethods = nodeset.getUAMethod();
    		List<UAMethod> nodesToAdd = new ArrayList<UAMethod>();
    		List<UAMethod> nodesToDelete = new ArrayList<UAMethod>();
    		
    		for(UAMethod t : uaMethods)
    		{
    			if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    			{
    				referenceNodes.add(t);
    			}
    			if(t.getParentNodeId() != null && t.getParentNodeId().length() > 0)
    			{
    				uaInstanceReferences.add(t);
    			}
    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    			{
    				rolePermissionNodes.add(t);
    			}
    			if(t.getMethodDeclarationId() != null && t.getMethodDeclarationId().length() > 0 && 
    				!uaInstanceReferences.contains(t))
    			{
    				uaInstanceReferences.add(t);
    			}
    			
    			success &= transformUAMethod(t, nodesToAdd, nodesToDelete);
    			if(!success)
    			{
    				success &= transformUAMethod(t, nodesToAdd, nodesToDelete);
    				break;
    			}
    			EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAMETHODS_TOPIC, 1);
    		}
    		// Important first remove old elements than add new ones
    		this.baseNodeset.getUAMethod().removeAll(nodesToDelete);
    		this.baseNodeset.getUAMethod().addAll(nodesToAdd);
    		
    	}
    	
    	EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAVIEWS_TOPIC, 0);
    	if(nodeset.getUAView() != null)
    	{    		

    		// adding and removing needs to be done via list otherwise 
    		// ConcurrentModificationException
    		EList<UAView> uaViews = nodeset.getUAView();
    		List<UAView> nodesToAdd = new ArrayList<UAView>();
    		List<UAView> nodesToDelete = new ArrayList<UAView>();
    		
    		for(UAView t : uaViews)
    		{
    			if(t.getReferences() != null && t.getReferences().getReference().size() > 0 )
    			{
    				referenceNodes.add(t);
    			}
    			if(t.getParentNodeId() != null && t.getParentNodeId().length() > 0)
    			{
    				uaInstanceReferences.add(t);
    			}
    			if(t.getRolePermissions() != null && t.getRolePermissions().getRolePermission().size() >0)
    			{
    				rolePermissionNodes.add(t);
    			}
    			success &= transformUAView(t, nodesToAdd, nodesToDelete);
    			if(!success)
    			{
    				success &= transformUAView(t, nodesToAdd, nodesToDelete);
    				break;
    			}
    			EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_UAVIEWS_TOPIC, 1);
    		}
    		
    		// Important first remove old elements than add new ones
    		this.baseNodeset.getUAView().removeAll(nodesToDelete);
    		this.baseNodeset.getUAView().addAll(nodesToAdd);
    		
    	}
    	
    	EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_REFERENCES_TOPIC, 0);
    	if(success)
    	{
    		success &= transformUaReferenceTypesReferences(referenceTypes);
    	}
    	
    	if(success)
    	{
    		success &= transformReferences(referenceNodes);
    	}
    	
    	if(success)
    	{
    		success &= transformUaInstanceReferences(uaInstanceReferences);
    	}

    	EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_ROLEPERMISSIONS_TOPIC, 0);
    	if(success)
    	{
    		success &= transformRolePermissions(rolePermissionNodes);
    	}

    	EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_DATATYPE_DEFINITIONS_TOPIC, 0);
    	if(success)
    	{
    		success &= transformDataTypeDefinitions(dataTypeDefinitions);
    	}
    	
    	// has to executed after transformRolePermissions as transformed rolepermissions are required
    	EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_MODELS_TOPIC, 0);
    	if(success && nodeset.getModels() != null )
    	{
    		int model_count = nodeset.getModels().getModel().size();
    		success &= transformModels(nodeset.getModels());
    		EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_MODELS_TOPIC, model_count);
    	}
    	
//    	EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_DONE_TOPIC, success);
    	return success;
	}

	@SuppressWarnings("unchecked")
	private boolean transformModels(ModelTable models) {
		
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype nodeSetType   = nodeSetProfile.getOwnedStereotype("UANodeSetType");
		Stereotype modelTableEntry   = nodeSetProfile.getOwnedStereotype("ModelTableEntry");
		
		ArrayList<String> existingModelUris = new ArrayList<String>();
		boolean success =true;
		
		// remove no longer existing model table entries
		if(this.baseUmlModel.hasValue(nodeSetType, "models"))
		{				
			EList<ModelTableEntry> exstingMtes = this.baseNodeset.getModels().getModel();
			ArrayList<ModelTableEntry> deleteMtes = new ArrayList<ModelTableEntry>();
			ArrayList<Class> deleteMtesUML = new ArrayList<Class>();
			
			EList<DynamicEObjectImpl> mtesUML = (EList<DynamicEObjectImpl>) this.baseUmlModel.getValue(nodeSetType, "models");
			
			for(ModelTableEntry existingMte : exstingMtes)
			{
				boolean found=false;
				for(ModelTableEntry mte : models.getModel())
				{
					if(mte.getModelUri().equals(existingMte.getModelUri()))
					{
						found = true;
						existingModelUris.add(mte.getModelUri());
						break;
					}
				}
				if(!found)
				{
				
					for(DynamicEObjectImpl mte:mtesUML)
					{
						Class baseClassTemp = getStereotypeBaseClass(mte, false);
						if(baseClassTemp.hasValue(modelTableEntry, "modelUri"))
						{
							String modelUri = (String) baseClassTemp.getValue(modelTableEntry, "modelUri");
							if(modelUri.equals(existingMte.getModelUri()))
							{
								deleteMtesUML.add(baseClassTemp);
								break;
							}
						}
						else
						{
							deleteMtesUML.add(baseClassTemp);
						}
					}
					
					deleteMtes.add(existingMte);
				}
			}
			
			
			while(!deleteMtes.isEmpty())
			{
				this.baseNodeset.getModels().getModel().remove(deleteMtes.get(0));
				deleteMtes.remove(0);
			}

			while(!deleteMtesUML.isEmpty())
			{
				this.matching.remove(deleteMtesUML.get(0));
				deleteMtesUML.get(0).destroy();
				deleteMtesUML.remove(0);
			}
		}
		EList<DynamicEObjectImpl> mtesUML = (EList<DynamicEObjectImpl>) this.baseUmlModel.getValue(nodeSetType, "models");
		
		ArrayList<ModelTableEntry> mtesToAdd = new ArrayList<ModelTableEntry>();
		
		for(ModelTableEntry mte : models.getModel())
		{
			Class mteUML=null;
			if(existingModelUris.contains(mte.getModelUri()))
			{
				for(DynamicEObjectImpl mteObj:mtesUML)
				{
					Class baseClassTemp = getStereotypeBaseClass(mteObj, false);
					if(baseClassTemp.hasValue(modelTableEntry, "modelUri"))
					{
						String modelUri = (String) baseClassTemp.getValue(modelTableEntry, "modelUri");
						if(modelUri.equals(mte.getModelUri()))
						{
							mteUML=baseClassTemp;
							break;
						}
					}
				}
			}
			if(mteUML == null)
			{
				mteUML = this.baseUmlModel.createOwnedClass(mte.getModelUri(), false);
				mteUML.applyStereotype(modelTableEntry);
				mteUML.setValue(modelTableEntry, "modelUri", mte.getModelUri());
				
				DynamicEObjectImpl sterAppl = (DynamicEObjectImpl)mteUML.getStereotypeApplication(modelTableEntry);
				mtesUML.add(sterAppl);
				this.matching.put(mteUML, mte);
				mtesToAdd.add(mte);
			}
			
			success &= transformModelTableEntry(mte, mteUML,modelTableEntry);
			
			if(success && mte.getRequiredModel() != null)
			{
				success &= linkRequiredModels(mte, mteUML, nodeSetType, modelTableEntry);
			}
			
			if(!success)
			{
				break;
			}
			
		}
				
		// has to be added this way, otherwise ConcurrentModificationException
		if(this.baseNodeset.getModels() == null)
		{
			this.baseNodeset.setModels(new ModelTableImpl());
		}
		this.baseNodeset.getModels().getModel().addAll(mtesToAdd);
		
		return success;
	}
	
	private boolean transformModelTableEntry(ModelTableEntry mte, Class uaElement, Stereotype stereotype)
	{
		
		// model URI won't be updated here as it is added when element is created
		// required model will be set inside transformModels
		
		// short cannot be null
		uaElement.setValue(stereotype, "accessRestrictions", String.valueOf(mte.getAccessRestrictions()));
		boolean success = true;
		if(mte.getPublicationDate() != null)
		{
			XMLGregorianCalendar cal = mte.getPublicationDate();
			String date = String.valueOf(cal.getDay())+"."+String.valueOf(cal.getMonth())+"."+String.valueOf(cal.getYear());
			uaElement.setValue(stereotype, "publicationDate", date);
		}
		else
		{			
			uaElement.setValue(stereotype, "publicationDate", "");
		}
		
		if(mte.getRolePermissions() != null)
		{
			success &= this.transformRolePermissionGen(mte, uaElement);	
		}
		else if(uaElement.hasValue(stereotype, "rolePermissions"))
		{
			EList<DynamicEObjectImpl> rps = (EList<DynamicEObjectImpl>) uaElement.getValue(stereotype, "rolePermissions");
			rps.clear();
		}
		
		if(mte.getVersion() != null)
		{
			uaElement.setValue(stereotype, "version", mte.getVersion());
		}
		else
		{
			uaElement.setValue(stereotype, "version", "");
		}
				
		return success;
	}
	

	private boolean linkRequiredModels(ModelTableEntry mte, Class uaElement, Stereotype nodeSetType, Stereotype modelTableEntry) {
		
		EList<DynamicEObjectImpl> requiredModels = (EList<DynamicEObjectImpl>) uaElement.getValue(modelTableEntry, "requiredModel");
		requiredModels.clear();
		
		for(ModelTableEntry reqMte : mte.getRequiredModel())
		{
			if(OpcUaLibraryResources.MODEL_URI_MAPPING.containsKey(reqMte.getModelUri()))
			{
				// default namespace needs to be imported
				URI lib_path = URI.createURI(OpcUaLibraryResources.MODEL_URI_MAPPING.get(reqMte.getModelUri()));
				ResourceSet owner_resource = this.baseUmlModel.eResource().getResourceSet(); 
				Model modelimport = (Model) PackageUtil.loadPackage(lib_path, owner_resource);
								
				if(!this.baseUmlModel.getImportedPackages().contains(modelimport))
				{
					this.baseUmlModel.createPackageImport(modelimport);
				}
					
			}
			
			EList<Package> modelImports = this.baseUmlModel.getImportedPackages();
			
			DynamicEObjectImpl reqMteObj = findModelTableEntry(modelImports, reqMte.getModelUri(), nodeSetType, modelTableEntry );
			
			if(reqMteObj== null)
			{
				return false;
			}
			
			requiredModels.add(reqMteObj);
			
		}
		return true;
	}
	
	private DynamicEObjectImpl findModelTableEntry(EList<Package> models, String uri, Stereotype nodeSetType, Stereotype modelTableEntry)
	{
		for(Package model : models)
		{
			if(model.isStereotypeApplied(nodeSetType) && model.hasValue(nodeSetType, "models"))
			{
				EList<DynamicEObjectImpl> packagedModels = (EList<DynamicEObjectImpl>) model.getValue(nodeSetType, "models");
				
				for(DynamicEObjectImpl modelObj : packagedModels)
				{
					Class modelUml = getStereotypeBaseClass(modelObj, false);
					if(modelUml.hasValue(modelTableEntry, "modelUri"))
					{
						String modelUri = (String) modelUml.getValue(modelTableEntry, "modelUri");
						if(modelUri.equals(uri))
						{ 
							return modelObj;
						}
					}
				}
				
			}
		}
		
		return null;
	}

	private boolean removeMissingElements(UANodeSetType nodeset) {
		
		if(this.baseNodeset.getUAObjectType() != null)
    	{    		
			ArrayList<String> nodeIds = new ArrayList<String>();

    		EList<UAObjectType> uaObjectTypes = nodeset.getUAObjectType();    		
    		if(uaObjectTypes != null)
    		{
	    		for(UAObjectType type : uaObjectTypes)
	    		{
	    			nodeIds.add(type.getNodeId());
	    		}
    		}
    		
    		uaObjectTypes = this.baseNodeset.getUAObjectType();
    		ArrayList<UAObjectType> toRemove = new ArrayList<UAObjectType>();
    		
    		for(UAObjectType type : uaObjectTypes)
    		{
    			if(!nodeIds.contains(type.getNodeId()))
    			{
    				destroyMember(type);
    				toRemove.add(type);
    			}
    		}
    		EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_PURGE_OLD_ELEMENTS_TOPIC, toRemove.size());
    		this.baseNodeset.getUAObjectType().removeAll(toRemove);
    	}
    	
    	if(this.baseNodeset.getUAVariableType() != null)
    	{    		
    		ArrayList<String> nodeIds = new ArrayList<String>();
    		
    		EList<UAVariableType> uaVariableTypes = nodeset.getUAVariableType();
    		if(uaVariableTypes != null)
    		{    			
    			for(UAVariableType type : uaVariableTypes)
    			{
    				nodeIds.add(type.getNodeId());
    			}
    		}
       		
    		uaVariableTypes = this.baseNodeset.getUAVariableType();
    		ArrayList<UAVariableType> toRemove = new ArrayList<UAVariableType>();
    		for(UAVariableType type : uaVariableTypes)
    		{
    			if(!nodeIds.contains(type.getNodeId()))
    			{
    				destroyMember(type);
    				toRemove.add(type);
    			}
    		}
    		EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_PURGE_OLD_ELEMENTS_TOPIC, toRemove.size());
    		this.baseNodeset.getUAVariableType().removeAll(toRemove);
    	}
    	
    	if(this.baseNodeset.getUADataType() != null)
    	{    		
    		ArrayList<String> nodeIds = new ArrayList<String>();

    		EList<UADataType> uaDataTypes = nodeset.getUADataType();
    		if(uaDataTypes != null)
    		{    			
    			for(UADataType type : uaDataTypes)
    			{
    				nodeIds.add(type.getNodeId());
    			}
    		}
       		
    		uaDataTypes = this.baseNodeset.getUADataType();
    		ArrayList<UADataType> toRemove = new ArrayList<UADataType>();
    		for(UADataType type : uaDataTypes)
    		{
    			if(!nodeIds.contains(type.getNodeId()))
    			{
    				destroyMember(type);
    				toRemove.add(type);
    			}
    		}
    		EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_PURGE_OLD_ELEMENTS_TOPIC, toRemove.size());
    		this.baseNodeset.getUADataType().removeAll(toRemove);
    	}
		
    	if(this.baseNodeset.getUAReferenceType() != null)
    	{    		
    		ArrayList<String> nodeIds = new ArrayList<String>();
    		
    		EList<UAReferenceType> uaReferenceTypes = nodeset.getUAReferenceType();
    		if(uaReferenceTypes != null)
    		{    			
    			for(UAReferenceType type : uaReferenceTypes)
    			{
    				nodeIds.add(type.getNodeId());
    			}
    		}
       		
    		uaReferenceTypes = this.baseNodeset.getUAReferenceType();
    		ArrayList<UAReferenceType> toRemove = new ArrayList<UAReferenceType>();
    		for(UAReferenceType type : uaReferenceTypes)
    		{
    			if(!nodeIds.contains(type.getNodeId()))
    			{
    				destroyMember(type);
    				toRemove.add(type);
    			}
    		}
    		EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_PURGE_OLD_ELEMENTS_TOPIC, toRemove.size());
    		this.baseNodeset.getUAReferenceType().removeAll(toRemove);
    	}
    	
    	if(this.baseNodeset.getUAObject() != null)
    	{
    		ArrayList<String> nodeIds = new ArrayList<String>();

			EList<UAObject> uaObjects = nodeset.getUAObject();
			if(uaObjects != null)
			{				
				for(UAObject object : uaObjects)
				{
					nodeIds.add(object.getNodeId());
				}
			}
       		
    		uaObjects = this.baseNodeset.getUAObject();
    		ArrayList<UAObject> toRemove = new ArrayList<UAObject>();
    		for(UAObject object : uaObjects)
    		{
    			if(!nodeIds.contains(object.getNodeId()))
    			{
    				destroyMember(object);
    				toRemove.add(object);
    			}
    		}
    		EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_PURGE_OLD_ELEMENTS_TOPIC, toRemove.size());
    		this.baseNodeset.getUAObject().removeAll(toRemove);
    	}
   
    	if(this.baseNodeset.getUAVariable() != null)
    	{	
    		ArrayList<String> nodeIds = new ArrayList<String>();
    		
    		EList<UAVariable> uaVariables = nodeset.getUAVariable();
    		if(uaVariables != null)
    		{    			
    			for(UAVariable var : uaVariables)
    			{
    				nodeIds.add(var.getNodeId());
    			}
    		}
       		
    		uaVariables = this.baseNodeset.getUAVariable();
    		ArrayList<UAVariable> toRemove = new ArrayList<UAVariable>();
    		for(UAVariable var : uaVariables)
    		{
    			if(!nodeIds.contains(var.getNodeId()))
    			{
    				destroyMember(var);
    				toRemove.add(var);
    			}
    		}
    		EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_PURGE_OLD_ELEMENTS_TOPIC, toRemove.size());
    		this.baseNodeset.getUAVariable().removeAll(toRemove);
    	}  
    	
    	if(this.baseNodeset.getUAMethod() != null)
    	{    		
    		ArrayList<String> nodeIds = new ArrayList<String>();
    		
    		EList<UAMethod> uaMethods = nodeset.getUAMethod();
    		if(uaMethods != null)
    		{    			
    			for(UAMethod method : uaMethods)
    			{
    				nodeIds.add(method.getNodeId());
    			}
    		}
       		
    		uaMethods = this.baseNodeset.getUAMethod();
    		ArrayList<UAMethod> toRemove = new ArrayList<UAMethod>();
    		for(UAMethod method : uaMethods)
    		{
    			if(!nodeIds.contains(method.getNodeId()))
    			{
    				destroyMember(method);
    				toRemove.add(method);
    			}
    		}
    		EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_PURGE_OLD_ELEMENTS_TOPIC, toRemove.size());
    		this.baseNodeset.getUAMethod().removeAll(toRemove);
    	}
    	
    	if(this.baseNodeset.getUAView() != null)
    	{    		
    		ArrayList<String> nodeIds = new ArrayList<String>();

    		EList<UAView> uaViews = nodeset.getUAView();
    		if(uaViews != null)
    		{    			
    			for(UAView view : uaViews)
    			{
    				nodeIds.add(view.getNodeId());
    			}
    		}
       		
    		uaViews = this.baseNodeset.getUAView();
    		ArrayList<UAView> toRemove = new ArrayList<UAView>();
    		for(UAView view : uaViews)
    		{
    			if(!nodeIds.contains(view.getNodeId()))
    			{
    				destroyMember(view);
    				toRemove.add(view);
    			}
    		}
    		EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_PURGE_OLD_ELEMENTS_TOPIC, toRemove.size());
    		this.baseNodeset.getUAView().removeAll(toRemove);
    	}
		return true;
	}
	
	private boolean destroyMember(UANode node)
	{
	
		Element elem = getElement(node);
		if(elem == null)
		{
			return false;
		}
		
		for(Relationship rel : elem.getRelationships())
		{
			rel.destroy();
		}
		
		this.nodeIdMap.remove(node.getNodeId());
		this.matching.remove(elem);
		elem.destroy();
		
		return true;
	}

	@SuppressWarnings("unchecked")
	private boolean transformNamespaces(UriTable namespaceUris) {

		EList<String> namespaces_new = namespaceUris.getUri();	
		
		if(this.baseNodeset.getNamespaceUris() == null)
		{
			this.baseNodeset.setNamespaceUris(new UriTableImpl());
		}
		
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaNodeSetType  = nodeSetProfile.getOwnedStereotype("UANodeSetType");
		Stereotype uaNameSpaceType  = nodeSetProfile.getOwnedStereotype("NameSpace");
		
		EcoreEList<DynamicEObjectImpl> nsList = (EcoreEList<DynamicEObjectImpl>) this.baseUmlModel.getValue(uaNodeSetType, "nameSpaceUris");
		ArrayList<Package> toDelete = new ArrayList<Package>();
		HashMap<String, DynamicEObjectImpl> nameSpacePackageMapping = new HashMap<String, DynamicEObjectImpl>();
		
		for(DynamicEObjectImpl nsObject : nsList )
		{
			Package umlNameSpace = (Package) nsObject.dynamicGet(0);
			String uri = umlNameSpace.getURI();
			
			if(!namespaces_new.contains(uri))
			{
				toDelete.add(umlNameSpace);
			}
			else
			{				
				nameSpacePackageMapping.put(uri, nsObject);
			}
		}
		
		
		while(!toDelete.isEmpty())
		{
			toDelete.get(0).destroy();
			toDelete.remove(0);
		}

		EList<Package> importedNamespaces = this.baseUmlModel.getImportedPackages();
		for(Package importedNamespace :importedNamespaces)
		{
			if(importedNamespace.getURI() != null && 
				namespaceUris.getUri().contains(importedNamespace.getURI()))
			{				
				DynamicEObjectImpl nsObject = (DynamicEObjectImpl) importedNamespace.getStereotypeApplication(uaNameSpaceType);
				nameSpacePackageMapping.put(importedNamespace.getURI(),nsObject );
				nsList.add(nsObject);
			}
		}
		
		for(String namespace : namespaceUris.getUri())
		{
			if(namespace == null )
			{
				continue;
			}
			
		
			if( !nameSpacePackageMapping.containsKey(namespace))
			{
				Package ns = null;
				if(OpcUaLibraryResources.NAMESPACE_PACKAGE_MAPPING.containsKey(namespace) )
				{
					// default namespace needs to be imported
					URI lib_path = URI.createURI(OpcUaLibraryResources.NAMESPACE_PACKAGE_MAPPING.get(namespace));
					ResourceSet owner_resource = this.baseUmlModel.eResource().getResourceSet(); 
					Model modelimport = (Model) PackageUtil.loadPackage(lib_path, owner_resource);
					
					for(Package namespacePackage : modelimport.getNestedPackages())
					{
						if(namespacePackage.getURI().equals(namespace))
						{
							ns = namespacePackage;
							break;
						}
					}
					
					if(ns == null)
					{
						continue;
					}
					
					this.baseUmlModel.createPackageImport(ns);
					
				}
				else
				{					
					ns = this.baseUmlModel.createNestedPackage(namespace);
					ns.applyStereotype(uaNameSpaceType);
					ns.setURI(namespace);
				}
				DynamicEObjectImpl temp = (DynamicEObjectImpl)ns.getStereotypeApplication(uaNameSpaceType);
				nameSpacePackageMapping.put(namespace, temp);
				nsList.add(temp);
			}
		}
		
		nsList = (EcoreEList<DynamicEObjectImpl>) this.baseUmlModel.getValue(uaNodeSetType, "nameSpaceUris");
		
		EList<String> existing_namespaces = this.baseNodeset.getNamespaceUris().getUri();
		existing_namespaces.clear();
		existing_namespaces.addAll(namespaces_new);
		
		for(int i=0; i<namespaces_new.size() && i < nameSpacePackageMapping.size();i++)
		{
			String nsString = namespaces_new.get(i);
			DynamicEObjectImpl nsSterApp = nameSpacePackageMapping.get(nsString);
			Package umlNs = (Package) nsSterApp.dynamicGet(0);
			
			nsList.move(i, nsSterApp);
			existing_namespaces.move(i, umlNs.getURI());
		}

		return true;
	}
	
	private boolean transformAliasTable(AliasTable aliasTable)
	{
		boolean success = true;
			
		for(NodeIdAlias alias : aliasTable.getAlias())
		{
			this.aliasTable.put(alias.getAlias(), alias.getValue());
		}
		
		return success;
	}
	
	private boolean transformUAObjectType(UAObjectType node, List<UAObjectType> nodesToAdd, List<UAObjectType> nodesToDelete) {
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAObjectType");
		
		Element uaElement = getElement(node);
		
		if(uaElement == null)
		{
			uaElement = createElement(node, uaStereoType);
		}
		else
		{
			nodesToDelete.add((UAObjectType) this.matching.get(uaElement)); // delete old element	
			this.matching.put(uaElement, node);
		}

		nodesToAdd.add(node);
		
		
		DynamicEObjectImpl stereotype = (DynamicEObjectImpl) uaElement.getStereotypeApplication(uaStereoType);
		if(stereotype == null)
		{
			this.matching.remove(uaElement);
			nodesToDelete.add(node);
			return true;
		}
		
		boolean success = transformUaType(node, uaStereoType, uaElement);
				
		return success;
	}
		
	private boolean transformUAVariableType(UAVariableType node, List<UAVariableType> nodesToAdd, List<UAVariableType> nodesToDelete) {
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAVariableType");
		
		Element uaElement = getElement(node);
		
		if(uaElement == null)
		{
			uaElement = createElement(node, uaStereoType);
		}
		else
		{
			nodesToDelete.add((UAVariableType) this.matching.get(uaElement)); // delete old element	
			this.matching.put(uaElement, node);
		}

		nodesToAdd.add(node);
		
		
		DynamicEObjectImpl stereotype = (DynamicEObjectImpl) uaElement.getStereotypeApplication(uaStereoType);
		if(stereotype == null)
		{
			// UAObjectType Stereotype not applied !!!
			this.matching.remove(uaElement);
			nodesToDelete.add(node);
			return true;
		}
		
		boolean success = transformUaType(node, uaStereoType, uaElement);
		return success;
	}
	
	private boolean transformUADataType(UADataType node, List<UADataType> nodesToAdd, List<UADataType> nodesToDelete) {
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UADataType");
		
		Element uaElement = getElement(node);
		
		if(uaElement == null)
		{
			uaElement = createElement(node, uaStereoType);
		}
		else
		{
			nodesToDelete.add((UADataType) this.matching.get(uaElement)); // delete old element	
			this.matching.put(uaElement, node);
		}
		
		DynamicEObjectImpl stereotype = (DynamicEObjectImpl) uaElement.getStereotypeApplication(uaStereoType);
		if(stereotype == null)
		{
			// UAObjectType Stereotype not applied !!!
			this.matching.remove(uaElement);
			nodesToDelete.add(node);
			return true;
		}
		
		boolean success = transformUaType(node, uaStereoType, uaElement);
		
		if(success)
		{			
			// DataTypeDefinition is parsed later
			if(node.getPurpose() != null )
			{
				Object releaseStatus = uaElement.getValue(uaStereoType, "purpose");
				
				EnumerationLiteral lit = (EnumerationLiteral) releaseStatus;
				Enumeration uaEnum = lit.getEnumeration();
				
				switch(node.getPurpose().getValue())
				{
				case DataTypePurpose.NORMAL_VALUE :
					uaElement.setValue(uaStereoType, "purpose", uaEnum.getOwnedLiteral("Normal"));
					break;
				case DataTypePurpose.SERVICES_ONLY_VALUE:
					uaElement.setValue(uaStereoType, "purpose", uaEnum.getOwnedLiteral("ServicesOnly"));
					break;
				case DataTypePurpose.CODE_GENERATOR_VALUE:
					uaElement.setValue(uaStereoType, "purpose", uaEnum.getOwnedLiteral( "CodeGenerator"));
					break;
				}
			}
			
			
		}
		
		return success;
	}
	
	private boolean transformDataTypeDefinitions( ArrayList<UADataType> dataTypes)
	{
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UADataType");
		boolean success = true;
		
		for(UADataType datatype : dataTypes)
		{
			Class uaElement = (Class) getElement(datatype);
			
			if(uaElement == null)
			{
				success = false;
				break;
			}
			
			DynamicEObjectImpl definition;
			Class definitionClass, dataTypeClass;
			dataTypeClass = (Class) uaElement;
					
			if(uaElement == null || uaStereoType == null)
			{
				uaElement = (Class) getElement(datatype);
			}
			
			if(uaElement.hasValue(uaStereoType, "definition"))
			{
				definition = (DynamicEObjectImpl) uaElement.getValue(uaStereoType, "definition");
				definitionClass = getStereotypeBaseClass(definition, true);
			}
			else
			{
				Package ns = uaElement.getNearestPackage();
				if(ns == null)
				{
					Model model = uaElement.getModel();
					definitionClass = model.createOwnedClass("DataTypeDefinition", false);
				}
				else
				{
					definitionClass = ns.createOwnedClass("DataTypeDefinition", false);
				}
				
				Stereotype uaDefinitionType = nodeSetProfile.getOwnedStereotype("DataTypeDefinition");
				definitionClass.applyStereotype(uaDefinitionType);
				definition = (DynamicEObjectImpl) definitionClass.getStereotypeApplication(uaDefinitionType);
			}
			
			EList<Classifier> classifiers = dataTypeClass.getNestedClassifiers();
			if(!classifiers.contains(definition))
			{
				classifiers.add(definitionClass);
			}
					
			success &= transformDataTypeDefinition(datatype.getDefinition(), definitionClass);
			EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_DATATYPE_DEFINITIONS_TOPIC, 1);
		}
		
		return success;
	}
	
	private boolean transformDataTypeDefinition(DataTypeDefinition dtd, Class definition)
	{
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("DataTypeDefinition");
		boolean success = true;
		
		if(dtd.getBaseType() != null)
		{
			definition.setValue(uaStereoType, "baseType", dtd.getBaseType());
		}
		
		if(dtd.getField() != null)
		{
			success &= transformDataTypeDefinitionField(dtd, definition);
		}
		
		if(dtd.getName() != null)
		{
			definition.setValue(uaStereoType, "name", dtd.getName());
		}
		
		if(dtd.getSymbolicName() != null)
		{
			@SuppressWarnings("unchecked")
			EDataTypeUniqueEList<Object> symbollicName = (EDataTypeUniqueEList<Object>) definition.getValue(uaStereoType, "symbolicName");
			symbollicName.clear();
			for(String symbolic : dtd.getSymbolicName())
			{
				symbollicName.add(symbolic);
			}
		}
		
		definition.setValue(uaStereoType, "isOptionSet", dtd.isIsOptionSet() );
		definition.setValue(uaStereoType, "isUnion", dtd.isIsUnion() );
		
		
		return success;
	}
	
	private boolean transformDataTypeDefinitionField(DataTypeDefinition dtd, Class definition)
	{
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("DataTypeDefinition");
		Stereotype uaDtfType  = nodeSetProfile.getOwnedStereotype("DataTypeField");
		
		@SuppressWarnings("unchecked")
		EcoreEList<DynamicEObjectImpl> field = (EcoreEList<DynamicEObjectImpl>) definition.getValue(uaStereoType, "field");
		EList<Classifier> children = definition.getNestedClassifiers();
		
		ArrayList<DataTypeField> existingDTF = new ArrayList<DataTypeField>();
		ArrayList<Class> deleteDTF = new ArrayList<Class>();
		
		boolean success = true;

		for(DynamicEObjectImpl fieldEntry : field)
		{
			Class dataTypeField = getStereotypeBaseClass(fieldEntry, true);
			if(dataTypeField != null)
			{
				DataTypeField dtf = (DataTypeField) this.matching.get(dataTypeField);
				if(dtd.getField().contains(dtf))
				{						
					existingDTF.add(dtf);
					if(!children.contains(dataTypeField))
					{
						children.add(dataTypeField);
					}
					success &= transformDataTypeField(dtf, dataTypeField);
				}
				else
				{
					deleteDTF.add(dataTypeField);
				}				
			}
		}	
		
		while(!deleteDTF.isEmpty())
		{
			deleteDTF.get(0).destroy();
			deleteDTF.remove(0);
		}
		
		
		for(DataTypeField dtf : dtd.getField())
		{
			if(! existingDTF.contains(dtf))
			{
				Package ns = definition.getNearestPackage();
				Class dtfClass;
				
				if(dtf.getDataType() == null || dtf.getDataType().length() == 0)
				{
					success = false;
					break;
				}
				
				Class datatype = (Class) this.nodeIdMap.get(dtf.getDataType());
				
				if(datatype ==null || datatype.getName() == null || datatype.getName().length() ==0)
				{						
					success =  false;
					break;
				}

				String name = "DataTypeField_"+datatype.getName();

				if(ns == null)
				{
					Model model = definition.getModel();	
					dtfClass = model.createOwnedClass(name, false);
				}
				else
				{
					dtfClass = ns.createOwnedClass(name, false);
				}
				children.add(dtfClass);
				
				dtfClass.applyStereotype(uaDtfType);
				success &= transformDataTypeField(dtf, dtfClass);
			}
		}
		return success;
	}
	
	private boolean transformDataTypeField(DataTypeField dtf, Class field)
	{
		boolean success = true;
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("DataTypeField");
		
		if(dtf.getDisplayName() != null)
		{
			@SuppressWarnings("unchecked")
			EDataTypeUniqueEList<Object> displayName = (EDataTypeUniqueEList<Object>) field.getValue(uaStereoType, "displayName");
			displayName.clear();
			for(LocalizedText display : dtf.getDisplayName())
			{
				displayName.add(display.getValue());
			}
		}
		
		if(dtf.getDescription() != null)
		{
			@SuppressWarnings("unchecked")
			EDataTypeUniqueEList<Object> descriptionList= (EDataTypeUniqueEList<Object>) field.getValue(uaStereoType, "description");
			descriptionList.clear();
			for(LocalizedText description : dtf.getDescription())
			{
				descriptionList.add(description.getValue());
			}
		}
		
		if(dtf.getAbstractDataType() != null)
		{
			Object abstractDataType = getUmlNodeReference(dtf.getAbstractDataType());
			if(abstractDataType == null)
			{
				success = false;
			}
			else
			{				
				field.setValue(uaStereoType, "abstractDataType", abstractDataType);
			}
		}
		
		if(dtf.getArrayDimensions() != null && dtf.getArrayDimensions().length() > 0)
		{
			@SuppressWarnings("unchecked")
			List<Object> arrayDimensions = (List<Object>) field.getValue(uaStereoType, "arrayDimensions");
			arrayDimensions.clear();
			
			for(String dim : dtf.getArrayDimensions().split(","))
			{
				int convertedInt = Integer.valueOf(dim);
				arrayDimensions.add(convertedInt);
			}
			
		}

		if(dtf.getDataType() != null)
		{
			Object dataType = getUmlNodeReference(dtf.getDataType());
			if(dataType == null)
			{
				success = false;
			}
			else
			{				
				field.setValue(uaStereoType, "dataType", dataType);
			}
		}
		
		field.setValue(uaStereoType, "isOptional", dtf.isIsOptional());
		field.setValue(uaStereoType, "maxStringLength", dtf.getMaxStringLength());
				
		if(dtf.getName() != null)
		{
			field.setValue(uaStereoType, "name", dtf.getName());
		}
		
		if(dtf.getSymbolicName() != null)
		{
			@SuppressWarnings("unchecked")
			EDataTypeUniqueEList<Object> symbollicName = (EDataTypeUniqueEList<Object>) field.getValue(uaStereoType, "symbolicName");
			symbollicName.clear();
			for(String symbolic : dtf.getSymbolicName())
			{
				symbollicName.add(symbolic);
			}
		}
		field.setValue(uaStereoType, "value", dtf.getValue());
		field.setValue(uaStereoType, "valueRank", dtf.getValueRank());
		
		return success;
	}
	
	private boolean transformUAReferenceType(UAReferenceType node, List<UAReferenceType> nodesToAdd, List<UAReferenceType> nodesToDelete) {
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAReferenceType");
		
		Element uaElement = getElement(node);
		
		if(uaElement == null)
		{
			uaElement = createElement(node, uaStereoType);
		}
		else
		{
			nodesToDelete.add((UAReferenceType) this.matching.get(uaElement)); // delete old element	
			this.matching.put(uaElement, node);
		}
		
		DynamicEObjectImpl stereotype = (DynamicEObjectImpl) uaElement.getStereotypeApplication(uaStereoType);
		if(stereotype == null)
		{
			// UAObjectType Stereotype not applied !!!
			this.matching.remove(uaElement);
			nodesToDelete.add(node);
			return true;
		}
		
		boolean success = transformUaType(node, uaStereoType, uaElement);
		
		if(success)
		{			
			if(node.getInverseName() != null)
			{
				
				@SuppressWarnings("unchecked")
				EDataTypeUniqueEList<Object> displayNames = (EDataTypeUniqueEList<Object>) uaElement.getValue(uaStereoType, "displayName");
				for(LocalizedText inverseName : node.getInverseName())
				{
					displayNames.add(inverseName.getValue());
				}
			}
			
			uaElement.setValue(uaStereoType, "symmetric", String.valueOf(node.isSymmetric()));
		}
		
		return success;
	
	}
	
	private boolean transformUAObject(UAObject node, List<UAObject> nodesToAdd, List<UAObject> nodesToDelete) {
		
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAObject");
		
		Element uaElement = getElement(node);
		
		if(uaElement == null)
		{
			uaElement = createElement(node, uaStereoType);
		}
		else
		{
			nodesToDelete.add((UAObject) this.matching.get(uaElement)); // delete old element	
			this.matching.put(uaElement, node);
		}
		
		DynamicEObjectImpl stereotype = (DynamicEObjectImpl) uaElement.getStereotypeApplication(uaStereoType);
		if(stereotype == null)
		{
			// UAObjectType Stereotype not applied !!!
			this.matching.remove(uaElement);
			nodesToDelete.add(node);
			return true;
		}
		 
		boolean success = transformUaInstance(node, uaStereoType, uaElement);
		
		if(success)
		{			
			uaElement.setValue(uaStereoType, "eventNotifier", String.valueOf(node.getEventNotifier()));
		}
		
		return success;
	}
	

	@SuppressWarnings("unchecked")
	private boolean transformUAVariable(UAVariable node, List<UAVariable> nodesToAdd, List<UAVariable> nodesToDelete) {
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAVariable");
		
		Element uaElement = getElement(node);
		
		if(uaElement == null)
		{
			uaElement = createElement(node, uaStereoType);
		}
		else
		{
			nodesToDelete.add((UAVariable) this.matching.get(uaElement)); // delete old element	
			this.matching.put(uaElement, node);
		}
		
		DynamicEObjectImpl stereotype = (DynamicEObjectImpl) uaElement.getStereotypeApplication(uaStereoType);
		if(stereotype == null)
		{
			// UAObjectType Stereotype not applied !!!
			this.matching.remove(uaElement);
			nodesToDelete.add(node);
			return true;
		}
		 
		boolean success = transformUaInstance(node, uaStereoType, uaElement);
		
		if(success)
		{
			//TODO: Add value

			uaElement.setValue(uaStereoType, "accessLevel", node.getAccessLevel());
			
			if(node.getArrayDimensions() != null && node.getArrayDimensions().length() > 0)
			{
				List<Object> arrayDimensions = (List<Object>) uaElement.getValue(uaStereoType, "arrayDimensions");
				arrayDimensions.clear();
				
				for(String dim : node.getArrayDimensions().split(","))
				{
					int convertedInt = Integer.valueOf(dim);
					arrayDimensions.add(convertedInt);
				}
			}
				
						
			uaElement.setValue(uaStereoType, "historizing", node.isHistorizing());
			uaElement.setValue(uaStereoType, "minimumSamplingInterval", node.getMinimumSamplingInterval());
			
			if(node.getTranslation() != null)
			{
				Stereotype ttStereoType  = nodeSetProfile.getOwnedStereotype("TranslationType");
				Stereotype sttStereoType  = nodeSetProfile.getOwnedStereotype("StructureTranslationType");
				
				EList<TranslationType> tt = node.getTranslation();				
				
				if(uaElement.hasValue(uaStereoType, "translation"))
				{
					
					EList<DynamicEObjectImpl> translations = (EList<DynamicEObjectImpl>) uaElement.getValue(uaStereoType, "translation");
					while(!translations.isEmpty())
					{
						Class ttClass = getStereotypeBaseClass(translations.get(0), false);
						ttClass.destroy();
					}
				}
				
				Package container = uaElement.getNearestPackage();
				Class variable = (Class)uaElement;
						
				for(TranslationType transType : tt)
				{
					Class ttClass = container.createOwnedClass("TranslationType", false);
					ttClass.applyStereotype(ttStereoType);
					variable.getNestedClassifiers().add(ttClass);
					
					EList<String> text = (EList<String>) ttClass.getValue(ttStereoType, "text");
					for(LocalizedText lt : transType.getText())
					{
						text.add(lt.getValue());
					}

					EList<DynamicEObjectImpl> field = (EList<DynamicEObjectImpl>) ttClass.getValue(ttStereoType, "field");
					
					for(StructureTranslationType stt : transType.getField())
					{
						if(stt.getName() != null && stt.getName().length() >0 )
						{							
							Class sttClass = container.createOwnedClass(stt.getName(), false);
							sttClass.applyStereotype(sttStereoType);
							ttClass.getNestedClassifiers().add(sttClass);
							
							sttClass.setValue(sttStereoType, "name",stt.getName());
							text = (EList<String>) sttClass.getValue(sttStereoType, "text");
							
							for(LocalizedText lt : stt.getText())
							{
								text.add(lt.getValue());
							}
							field.add((DynamicEObjectImpl) sttClass.getStereotypeApplication(sttStereoType));
						}
					}
					
				}
				
			}
			
			uaElement.setValue(uaStereoType, "userAccessLevel", node.getUserAccessLevel());
			uaElement.setValue(uaStereoType, "valueRank", node.getValueRank());
		}


		
		return success;
	}

	private boolean transformUAMethod(UAMethod node, List<UAMethod> nodesToAdd, List<UAMethod> nodesToDelete) {

		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAMethod");
		
		Element uaElement = getElement(node);
		
		if(uaElement == null)
		{
			uaElement = createElement(node, uaStereoType);
		}
		else
		{
			nodesToDelete.add((UAMethod) this.matching.get(uaElement)); // delete old element	
			this.matching.put(uaElement, node);
		}
		
		DynamicEObjectImpl stereotype = (DynamicEObjectImpl) uaElement.getStereotypeApplication(uaStereoType);
		if(stereotype == null)
		{
			// UAObjectType Stereotype not applied !!!
			this.matching.remove(uaElement);
			nodesToDelete.add(node);
			return true;
		}
		 
		boolean success = transformUaInstance(node, uaStereoType, uaElement);
		
		if(success)
		{
			Stereotype uaMethodSter = getMatchingStereotype(node);
			
			if(node.getArgumentDescription() != null)
			{				

				success &= transformMethodArgument(node, (Class) uaElement);
				
			}
			uaElement.setValue(uaMethodSter, "executable", node.isExecutable());			
			uaElement.setValue(uaMethodSter, "userExecutable", node.isUserExecutable());
		}
		return success;
	}
	
	
	
	private boolean transformMethodArgument(UAMethod uaMethod, Class uaElement) {
		
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaMethodStereotype  = nodeSetProfile.getOwnedStereotype("UAMethod");
		Stereotype uaMethodArgumentStereotype  = nodeSetProfile.getOwnedStereotype("UAMethodArgument");
		
		@SuppressWarnings("unchecked")
		EcoreEList<DynamicEObjectImpl> methodArguments = (EcoreEList<DynamicEObjectImpl>) uaElement.getValue(uaMethodStereotype, "argumentDescription");
		EList<Classifier> children = uaElement.getNestedClassifiers();
		
		ArrayList<UAMethodArgument> existingUaMethArg = new ArrayList<UAMethodArgument>();
		ArrayList<Class> deleteUaMethArg = new ArrayList<Class>();
		
		boolean success = true;
		
		for(DynamicEObjectImpl methodArgumentEntry : methodArguments)
		{
			Class methodArgument = getStereotypeBaseClass(methodArgumentEntry, true);
			if(methodArgument != null)
			{
				UAMethodArgument uaMethArg = (UAMethodArgument) this.matching.get(methodArgument);
				if(uaMethod.getArgumentDescription().contains(uaMethArg))
				{						
					existingUaMethArg.add(uaMethArg);
					if(!children.contains(methodArgument))
					{
						children.add(methodArgument);
					}
					transformMethodArgumentEntry(uaMethArg, methodArgument);
				}
				else
				{
					deleteUaMethArg.add(methodArgument);
				}		
			}
		}
		
		while(!deleteUaMethArg.isEmpty())
		{
			deleteUaMethArg.get(0).destroy();
			deleteUaMethArg.remove(0);
		}
		
		for( UAMethodArgument uaMethArg : uaMethod.getArgumentDescription())
		{
			if(!existingUaMethArg.contains(uaMethArg))
			{
				Package ns = uaElement.getNearestPackage();

				Class uaMethArgClass;
				
				if(uaMethArg.getName() == null || uaMethArg.getName().length() == 0)
				{
					success = false;
					break;
				}
				
				String name = "UAMethodArgument_"+uaMethArg.getName();
				
				if(ns == null)
				{
					Model model = uaElement.getModel();	
					uaMethArgClass = model.createOwnedClass(name, false);
				}
				else
				{
					uaMethArgClass = ns.createOwnedClass(name, false);
				}
				children.add(uaMethArgClass);
				uaMethArgClass.applyStereotype(uaMethodArgumentStereotype);
				transformMethodArgumentEntry(uaMethArg, uaMethArgClass);
			}
		}
		
		return success;
	}
	
	@SuppressWarnings("unchecked")
	private boolean transformMethodArgumentEntry(UAMethodArgument uaMethodArgument, Class uaElement) {
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAMethodArgument");
		
		if(uaMethodArgument.getName() != null && uaMethodArgument.getName().length() > 0 )
		{
			uaElement.setValue(uaStereoType, "name", uaMethodArgument.getName());
		}
		
		if(uaMethodArgument.getDescription() != null && uaMethodArgument.getDescription().size() > 0 )
		{
			EDataTypeUniqueEList<Object> descriptionList= (EDataTypeUniqueEList<Object>) uaElement.getValue(uaStereoType, "description");
			descriptionList.clear();
			for(LocalizedText description : uaMethodArgument.getDescription())
			{
				descriptionList.add(description.getValue());
			}
		}
		
		return true;
	}

	private boolean transformUAView(UAView node, List<UAView> nodesToAdd, List<UAView> nodesToDelete) {
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("UAView");
				
		Element uaElement = getElement(node);
		
		if(uaElement == null)
		{
			uaElement = createElement(node, uaStereoType);
		}
		else
		{
			nodesToDelete.add((UAView) this.matching.get(uaElement)); // delete old element	
			this.matching.put(uaElement, node);
		}
		
		DynamicEObjectImpl stereotype = (DynamicEObjectImpl) uaElement.getStereotypeApplication(uaStereoType);
		if(stereotype == null)
		{
			// UAObjectType Stereotype not applied !!!
			this.matching.remove(uaElement);
			nodesToDelete.add(node);
			return true;
		}
		 
		boolean success = transformUaInstance(node, uaStereoType, uaElement);
		return success;
	}
	
	private boolean transformUaInstance(UAInstance node, Stereotype stereotype, Element uaElement) {

		boolean success = transformOpcUaNode(node, stereotype, uaElement);
		
		// ParentNodeId is parsed in a later step
		return success;
	}
	
	private boolean transformUaType(UAType node, Stereotype stereotype, Element uaElement) {
		boolean success = transformOpcUaNode(node, stereotype, uaElement);
		return success;
	}
	
	@SuppressWarnings("unchecked")
	private boolean transformOpcUaNode(UANode node, Stereotype stereotype, Element uaElement) {

		
		if(node.getNodeId() != null) {
			String nodeId = node.getNodeId();

			this.nodeIdMap.put(nodeId, uaElement);			
			
			if(nodeId.startsWith("ns="))
			{
				// remove namespace indicator if existing
				int seperator = nodeId.indexOf(";")+1;
				nodeId = nodeId.substring(seperator);
			}
			
			if(nodeId.contains("s="))
			{
				int seperator = nodeId.lastIndexOf("s=")+2;
				nodeId = nodeId.substring(seperator);
			}
			else if(nodeId.contains("i="))
			{
				int seperator = nodeId.lastIndexOf("i=")+2;
				nodeId = nodeId.substring(seperator);
			} 
			
			uaElement.setValue(stereotype, "nodeId", nodeId);
						
		}
		else
		{
			// node id is mandatory
			return false;
		}
		
		if(node.getDisplayName() != null)
		{			
			EDataTypeUniqueEList<Object> displayNames = (EDataTypeUniqueEList<Object>) uaElement.getValue(stereotype, "displayName");
			displayNames.clear();
			for(LocalizedText displayName : node.getDisplayName())
			{
				displayNames.add(displayName.getValue());
			}
		}
		
		if(node.getDescription() != null)
		{			
			EDataTypeUniqueEList<Object> description = (EDataTypeUniqueEList<Object>) uaElement.getValue(stereotype, "description");
			description.clear();
			for(LocalizedText displayName : node.getDescription())
			{
				description.add(displayName.getValue());
			}
		}
		
		if(node.getCategory() != null)
		{			
			uaElement.setValue(stereotype, "category", node.getCategory());
		}
		
		if(node.getDocumentation() != null)
		{			
			EDataTypeUniqueEList<Object> description = (EDataTypeUniqueEList<Object>) uaElement.getValue(stereotype, "description");
			description.add(node.getDocumentation());
		}
		
		// rolepermissions are not done here because references are needed

		// short cannot be null
		uaElement.setValue(stereotype, "accessRestrictions", String.valueOf(node.getAccessRestrictions()));
		
		if(node.getBrowseName() != null)
		{
			String browseName = node.getBrowseName();
			if(browseName.contains(":"))
			{
				int seperator = browseName.indexOf(":")+1;
				browseName = browseName.substring(seperator);
			}

			uaElement.setValue(stereotype, "browseName", browseName);			
			Class temp = (Class) uaElement;
			temp.setName(browseName);
		}

	
		if(node.getReleaseStatus() != null) {
		
			Object releaseStatus = uaElement.getValue(stereotype, "releaseStatus");
			
			EnumerationLiteral lit = (EnumerationLiteral) releaseStatus;
			Enumeration uaEnum = lit.getEnumeration();
			
			switch(node.getReleaseStatus().getValue())
			{
			case ReleaseStatus.DRAFT_VALUE :
				uaElement.setValue(stereotype, "releaseStatus", uaEnum.getOwnedLiteral("Draft"));
				break;
			case ReleaseStatus.RELEASED_VALUE:
				uaElement.setValue(stereotype, "releaseStatus", uaEnum.getOwnedLiteral("Released"));
				break;
			case ReleaseStatus.DEPRECATED_VALUE:
				uaElement.setValue(stereotype, "releaseStatus", uaEnum.getOwnedLiteral("Deprecated"));
				break;
			}
		}
		
		if(node.getSymbolicName() != null)
		{			
			EDataTypeUniqueEList<Object> symbollicName = (EDataTypeUniqueEList<Object>) uaElement.getValue(stereotype, "symbolicName");
			symbollicName.clear();
			for(String symbolic : node.getSymbolicName())
			{
				symbollicName.add(symbolic);
			}
		}
		// userWriteMask and writeMask cannot be null since they are Shorts
		uaElement.setValue(stereotype, "userWriteMask", String.valueOf(node.getUserWriteMask()));
		uaElement.setValue(stereotype, "writeMask", String.valueOf(node.getWriteMask()));
				
		return true;
	}
		
	private Element getElement(UANode node)
	{
		Element uaElement = null;
		String nodeId = node.getNodeId();
		int namespaceId=0;
		String namespace="";
		
		// check if node is inside a ns
		if(nodeId.contains(";"))
		{				
			// extract namespace id
			String namespaceString = nodeId.split(";")[0].substring(3);
			namespaceId = Integer.parseInt(namespaceString);	
			
			Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
			Stereotype uaNodeSetType  = nodeSetProfile.getOwnedStereotype("UANodeSetType");
			
			@SuppressWarnings("unchecked")
			EcoreEList<DynamicEObjectImpl> nsList = (EcoreEList<DynamicEObjectImpl>) this.baseUmlModel.getValue(uaNodeSetType, "nameSpaceUris");
			
			if(nsList.size() < namespaceId)
			{
				// Namespace does not exists 
				return null;
			}
			
			Package nameSpacePackage = (Package) nsList.get(namespaceId-1).dynamicGet(0);
			namespace = nameSpacePackage.getURI();
		}

		if(this.nodeIdMap.containsKey(node.getNodeId()))
		{
			uaElement = this.nodeIdMap.get(node.getNodeId());

			Element parent = uaElement.getOwner();
			if(parent instanceof Model)
			{
				// parent is model => ns 0
				if(namespaceId != 0)
				{
					// Element not in default Namespace
					uaElement = null;
					this.matching.remove(uaElement);
				}
			}
			else if(parent instanceof Package)
			{
				Package parentNS = (Package) parent;
				if(parentNS == null || parentNS.getURI()==null || !parentNS.getURI().equals(namespace))
				{
					// Element in wrong Namespace 
					uaElement = null;
					this.matching.remove(uaElement);
				}
			}
		}
		return uaElement;
	}
	
	private Element createElement(UANode node, Stereotype uaStereoType)
	{
		Element uaElement = null;
		
		Package namespace = getNamespacePackage(node.getNodeId());
		
		// Element does not exist in Model 
		// create new UAObjectType Element
		int separator = node.getBrowseName().lastIndexOf(":")+1;
		String name = node.getBrowseName().substring(separator);
		
		if(namespace == null)
		{			
			uaElement= baseUmlModel.createOwnedClass(name, false);
		}
		else
		{
			uaElement = namespace.createOwnedClass(name, false);
		}
		
		uaElement.applyStereotype(uaStereoType);
		this.matching.put(uaElement, node);
		this.nodeIdMap.put(node.getNodeId(), uaElement);
		return uaElement;
	}
	
	private Package getNamespacePackage(String nodeId)
	{
		Package namespace = null;
		if(nodeId.contains(";"))
		{				
			// extraced namespace id
			String namespaceString = nodeId.split(";")[0].substring(3);
			int namespaceId = Integer.parseInt(namespaceString);	
			
			Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
			Stereotype uaNodeSetType  = nodeSetProfile.getOwnedStereotype("UANodeSetType");
			
			@SuppressWarnings("unchecked")
			EcoreEList<DynamicEObjectImpl> nsList = (EcoreEList<DynamicEObjectImpl>) this.baseUmlModel.getValue(uaNodeSetType, "nameSpaceUris");
			
			if(nsList.size() < namespaceId)
			{
				// Namespace does not exists 
				return null;
			}
			
			namespace = (Package) nsList.get(namespaceId-1).dynamicGet(0);
			
		}
		
		return namespace;
	}
	
	private boolean transformUaReferenceTypesReferences(ArrayList<UAReferenceType> referenceTypes) {
		boolean success = true;
		// create references between ReferenceTypes
		for(UAReferenceType rt : referenceTypes)
		{
			success &= transformNodeReferences(rt);
			if(!success)
			{
				break;
			}
			EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_REFERENCES_TOPIC, 1);
		}
		// Analyse if reference Type is a hierachical Reference Type
		for(UAReferenceType rt : referenceTypes)
		{
			success &= handleHierachicalTypes(rt);
			if(!success)
			{
				break;
			}
			EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_REFERENCES_TOPIC, 1);
		}
		
		return success;
	}
	
	private boolean handleHierachicalTypes(UAReferenceType referenceType)
	{
		
 		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaReferenceType  = nodeSetProfile.getOwnedStereotype("UAReferenceType");
		Stereotype uaReference  = nodeSetProfile.getOwnedStereotype("Reference");
		Class uaElement = (Class) this.nodeIdMap.get(referenceType.getNodeId());

		
		if(uaElement.getName().equalsIgnoreCase("HierarchicalReferences"))
		{
			uaElement.setValue(uaReferenceType, "isHierarchical", true);
		}
		else if(uaElement.getName().equalsIgnoreCase("References"))
		{
			uaElement.setValue(uaReferenceType, "isHierarchical", false);
			// Reference for References ReferenceType is not set at this point.
			// Nonetheless it exists
		}
		
		for(Generalization reference : uaElement.getGeneralizations())
		{
			// references shall have a referenceType
			if(! reference.hasValue(uaReference, "referenceType"))
			{
				return false;
			}
			
			DynamicEObjectImpl refTypeSterAppl = (DynamicEObjectImpl) reference.getValue(uaReference, "referenceType");
			Class refType = getStereotypeBaseClass(refTypeSterAppl, true);
			if(!refType.hasValue(uaReferenceType, "browseName"))
			{
				return false;
			}
			String browseName = String.valueOf(refType.getValue(uaReferenceType, "browseName"));
			// if this is not a subtype reference, the hierachical property is not inherited/transmitted
			if(!browseName.equalsIgnoreCase("HasSubtype"))
			{
				continue;
			}
						
			for(Element target :reference.getTargets())
			{
				Class uaRefType = (Class)target;
				if(!uaRefType.hasValue(uaReferenceType, "isHierarchical") &&
				   !uaElement.hasValue(uaReferenceType, "isHierarchical"))
				{
					handleHierachicalTypes(uaRefType,uaReferenceType, uaReference);
				}
				
				boolean isForward = (boolean) reference.getValue(uaReference, "isForward");
				
				if(uaRefType.getModel().equals(uaElement.getModel()))
				{
					if(isForward)
					{
						EList<Classifier> children = uaElement.getNestedClassifiers();
						if(!children.contains(uaRefType))
						{
							children.add(uaRefType);
						}
					}
					else
					{					
						EList<Classifier> children = uaRefType.getNestedClassifiers();
						if(!children.contains(uaElement))
						{
							children.add(uaElement);
						}
					}
				}	
				
				if(!uaElement.hasValue(uaReferenceType, "isHierarchical"))
				{
					boolean isHierarchical = (boolean) uaRefType.getValue(uaReferenceType, "isHierarchical");
					uaElement.setValue(uaReferenceType, "isHierarchical", isHierarchical);
				}
			}
		}
		
		return true;
	}
	
	private boolean handleHierachicalTypes(Class referenceType, Stereotype uaReferenceType, Stereotype uaReference)
	{
	    
		if(!referenceType.getName().equalsIgnoreCase("HierarchicalReferences") &&
		   !referenceType.getName().equalsIgnoreCase("References"))
		{
			for(Generalization reference : referenceType.getGeneralizations() )
			{
				for(Element target :reference.getTargets())
				{
					Class uaRefType = (Class)target;
					if(!uaRefType.hasValue(uaReferenceType, "isHierarchical") &&
					   !referenceType.hasValue(uaReferenceType, "isHierarchical"))
					{
						handleHierachicalTypes(uaRefType,uaReferenceType,uaReference);
					}
					
					boolean isForward = (boolean) reference.getValue(uaReference, "isForward");
					if(isForward)
					{
						EList<Classifier> children = referenceType.getNestedClassifiers();
						if(!children.contains(uaRefType))
						{
							children.add(uaRefType);
						}
					}
					else
					{					
						EList<Classifier> children = uaRefType.getNestedClassifiers();
						if(!children.contains(referenceType))
						{
							children.add(referenceType);
						}
					}
					
					if( this.baseUmlModel.equals(uaReferenceType.getModel()) &&
							!referenceType.hasValue(uaReferenceType, "isHierachical"))
					{
						boolean isHierarchical = (boolean) uaRefType.getValue(uaReferenceType, "isHierarchical");
						referenceType.setValue(uaReferenceType, "isHierarchical", isHierarchical);
					}
				}
			}
		}
		return true;
	}
	
		
	private boolean transformReferences(ArrayList<UANode> referenceNodes)
	{
		boolean success = true;
		for(UANode node : referenceNodes)
		{
			success &= transformNodeReferences(node);
			if(!success)
			{
				break;
			}
			EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_REFERENCES_TOPIC, 1);
		}
		
		return success;
	}
	
	private boolean transformNodeReferences(UANode node)
	{
				
		Class uaElement = null;
		
		if(this.nodeIdMap.containsKey(node.getNodeId()))
		{
			uaElement = (Class) this.nodeIdMap.get(node.getNodeId());
		}
		else
		{
			for(Entry<Element, Object> entry : this.matching.entrySet())
			{
				Object uaMember = entry.getValue();
				if(uaMember instanceof UANode)
				{
					UANode UANode = (UANode) uaMember;				
					if(UANode.getNodeId() != null && UANode.getNodeId().equalsIgnoreCase(node.getNodeId()))
					{
						uaElement = (Class) entry.getKey();
						break;
					}
				}
			}

			if(uaElement == null)
			{
				return false;
			}
			else
			{
				this.nodeIdMap.put(node.getNodeId(), uaElement);
			}
		}
		
		boolean success = true;
		if(node.getReferences() != null)
		{
			for(Reference ref: node.getReferences().getReference())
			{
				
				success &= transformNodeReference(uaElement, ref);
			}
		}
		
		return success;
	}
		
	private boolean transformNodeReference(Class uaElement, Reference ref)
	{
		boolean success = true;
		
		Object refType = getUmlNodeReference(ref.getReferenceType());
		if(refType == null)
		{
			return false;
		}
		Class refValue = getUmlNode(ref.getValue());
		if(refValue == null)
		{
			return false;
		}
				
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaReference  = nodeSetProfile.getOwnedStereotype("Reference");
		
		Generalization reference;
		if(uaElement.getGenerals().size() > 0 &&
			uaElement.getGeneralization(refValue) != null)
		{
			reference = uaElement.getGeneralization(refValue);
			
		}
		else
		{
			reference = uaElement.createGeneralization(refValue);
			reference.applyStereotype(uaReference);	
			this.matching.put(reference, ref);
		}
		
		reference.setValue(uaReference,"isForward", String.valueOf(ref.isIsForward()));
		reference.setValue(uaReference,"referenceType", refType);
				
		Class uaReferenceType = getUmlNode(ref.getReferenceType());
		Stereotype uaReferenceTypeStereoType  = nodeSetProfile.getOwnedStereotype("UAReferenceType");
		
		boolean isHierarchicalReference = (boolean) uaReferenceType.getValue(uaReferenceTypeStereoType, "isHierarchical");
		
		reference.setValue(uaReference,"referenceType_symmetric", uaReferenceType.getValue(uaReferenceTypeStereoType, "symmetric"));
		reference.setValue(uaReference,"referenceType_browseName", uaReferenceType.getValue(uaReferenceTypeStereoType, "browseName"));
		reference.setValue(uaReference,"referenceType_isHierarchical", isHierarchicalReference);

		if(isHierarchicalReference && uaElement.getModel().equals(refValue.getModel()) && 
				uaElement.getNearestPackage().equals(refValue.getNearestPackage()))
		{	
			if(ref.isIsForward())
			{
				uaElement.getNestedClassifiers().add(refValue);
			}
			else
			{				
				refValue.getNestedClassifiers().add(uaElement);
			}
		}
		
		return success;
	}
	
	private boolean transformUaInstanceReferences(ArrayList<UAInstance> parentNodes) {
		boolean success = true;
		for(UAInstance var : parentNodes)
		{
			// check if parent node id is set
			if(var.getParentNodeId() != null && var.getParentNodeId().length() > 0)
			{
				success &= updateOpcUaParent(var);
				if(!success)
				{
					break;
				}
			}
			
			// check if UAVariable and set the datatype
			if(var instanceof UAVariable)
			{
				success &= transformUaDatatype((UAVariable) var);
				if(!success)
				{
					break;
				}
				
			}
			else if(var instanceof UAMethod)
			{
				success &= transformMethodDeclarationId((UAMethod) var);
				if(!success)
				{
					break;
				}	
			}

			EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_REFERENCES_TOPIC, 1);
		}
		
		return success;
	}

	private boolean transformMethodDeclarationId(UAMethod inst) {
		// get stereotype Application of parent element
		Object methodDeclarationId = getUmlNodeReference(inst.getMethodDeclarationId());
		
		Class varElement = getUmlNode(inst.getNodeId());
		
		Stereotype uaInstance = getMatchingStereotype(inst);
		varElement.setValue(uaInstance, "methodDeclarationId", methodDeclarationId);

		return true;
	}

	private boolean updateOpcUaParent(UAInstance inst) {
		// get stereotype Application of parent element
		Object parent = getUmlNodeReference(inst.getParentNodeId());
		
		Class varElement = getUmlNode(inst.getNodeId());
		
		Stereotype uaInstance = getMatchingStereotype(inst);
		varElement.setValue(uaInstance, "parentNodeId", parent);
		
		// get UML Element of parent to add UAInstance as child
		Class varParent = getUmlNode(inst.getParentNodeId());
		
		EList<Classifier> children = varParent.getNestedClassifiers();
		if(!children.contains(varElement))
		{
			children.add(varElement);
		}
		return true;
	}
	
	private boolean transformUaDatatype(UAVariable var)
	{
		
		Class varElement  = (Class) this.nodeIdMap.get(var.getNodeId());
		Stereotype uaInstance = getMatchingStereotype(var);
		
		Object dataTypeObject = getUmlNodeReference(var.getDataType());
		
		boolean success = true;
		
		if(dataTypeObject == null)
		{
			success = false;
		}
		else
		{				
			varElement.setValue(uaInstance, "dataType", dataTypeObject);
		}
		
		return success;
	}
	
	private Class getUmlNode(String nodeId)
	{		
		if(nodeId == null || nodeId.length() == 0)
		{
			return null;
		}
		
		if(this.aliasTable.containsKey(nodeId))
		{
			nodeId = this.aliasTable.get(nodeId);
		}
		
		Class umlElement = null;
		if(this.nodeIdMap.containsKey(nodeId))
		{
			umlElement = (Class) this.nodeIdMap.get(nodeId);
		}
		else
		{
			// Element not in nodeId map -> part of imported namespaces 
			if(nodeId.startsWith("ns="))
			{
				// Element part of a namespace
				Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
				Stereotype uaNodeSet  = nodeSetProfile.getOwnedStereotype("UANodeSetType");
				
				@SuppressWarnings("unchecked")
				EcoreEList<DynamicEObjectImpl> nsList = (EcoreEList<DynamicEObjectImpl>) this.baseUmlModel.getValue(uaNodeSet, "nameSpaceUris");
				int seperator = nodeId.indexOf(";");
				String nameSpaceIdString = nodeId.substring(3, seperator); // ns= is 3 chars long
				int nameSpaceId = Integer.valueOf(nameSpaceIdString);
				DynamicEObjectImpl nsObject = nsList.get(nameSpaceId-1);
				Package namespace = (Package) nsObject.dynamicGet(0); // no features defined -> base package feature id  = 0
				
				loadNamespaceContent(namespace, nameSpaceId);
				if(this.nodeIdMap.containsKey(nodeId))
				{
					umlElement = (Class) this.nodeIdMap.get(nodeId);
				}
			}
			else
			{
				// Element part of namespace 0
				EList<Package> imports = this.baseUmlModel.getImportedPackages();
				
				
				Package defaultNs = null;
				for(Package pack : imports)
				{
					if(pack.getName() != null && pack.getName().equalsIgnoreCase("Opc.Ua.NodeSet2"))
					{
						defaultNs = pack;
						break;
					}
				}
				
				if(defaultNs == null)
				{
					// default namespace needs to be imported
					URI lib_path = URI.createURI(OpcUaLibraryResources.BASENAMESPACE_LIBRARY);
					ResourceSet owner_resource = this.baseUmlModel.eResource().getResourceSet(); 
					defaultNs = PackageUtil.loadPackage(lib_path, owner_resource);
					this.baseUmlModel.createPackageImport(defaultNs);
				}
				
				if(defaultNs != null)
				{
					loadNamespaceContent(defaultNs, 0);
					if(this.nodeIdMap.containsKey(nodeId))
					{
						umlElement = (Class) this.nodeIdMap.get(nodeId);
					}
				}
			}
		}
				
		
		return umlElement;
	}
	
	private void loadNamespaceContent(Package namespace, int namespaceId)
	{
		EList<Element> elements = namespace.allOwnedElements();
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaReferenceType  = nodeSetProfile.getOwnedStereotype("UAReferenceType");
		Stereotype uaDataType  = nodeSetProfile.getOwnedStereotype("UADataType");
		Stereotype uaVariableType  = nodeSetProfile.getOwnedStereotype("UAVariableType");
		Stereotype uaObjectType  = nodeSetProfile.getOwnedStereotype("UAObjectType");
		Stereotype uaView  = nodeSetProfile.getOwnedStereotype("UAView");
		Stereotype uaMethod  = nodeSetProfile.getOwnedStereotype("UAMethod");
		Stereotype uaVariable  = nodeSetProfile.getOwnedStereotype("UAVariable");
		Stereotype uaObject  = nodeSetProfile.getOwnedStereotype("UAObject");
		
		String namespacePrefix = "";
		if(namespaceId > 0)
		{
			namespacePrefix = "ns=" + String.valueOf(namespaceId) + ";";
		}
		for(Element element : elements)
		{
			if(element instanceof Class)
			{
				Class clsElement = (Class) element;
				String nodeId = "";
				if(clsElement.isStereotypeApplied(uaReferenceType))
				{
					nodeId = (String) clsElement.getValue(uaReferenceType, "nodeId");
					this.matching.put(clsElement, new  UAReferenceTypeImpl());
				}
				else if(clsElement.isStereotypeApplied(uaDataType))
				{
					nodeId = (String) clsElement.getValue(uaDataType, "nodeId");
					this.matching.put(clsElement, new  UADataTypeImpl());
				}
				else if(clsElement.isStereotypeApplied(uaVariableType))
				{
					nodeId = (String) clsElement.getValue(uaVariableType, "nodeId");
					this.matching.put(clsElement, new  UAVariableTypeImpl());
				}
				else if(clsElement.isStereotypeApplied(uaObjectType))
				{
					nodeId = (String) clsElement.getValue(uaObjectType, "nodeId");
					this.matching.put(clsElement, new  UAObjectTypeImpl());
				}
				else if(clsElement.isStereotypeApplied(uaView))
				{
					nodeId = (String) clsElement.getValue(uaView, "nodeId");
					this.matching.put(clsElement, new  UAViewImpl());
				}
				else if(clsElement.isStereotypeApplied(uaMethod))
				{
					nodeId = (String) clsElement.getValue(uaMethod, "nodeId");
					this.matching.put(clsElement, new  UAMethodImpl());
				}
				else if(clsElement.isStereotypeApplied(uaVariable))
				{
					nodeId = (String) clsElement.getValue(uaVariable, "nodeId");
					this.matching.put(clsElement, new  UAVariableImpl());
				}
				else if(clsElement.isStereotypeApplied(uaObject))
				{
					nodeId = (String) clsElement.getValue(uaObject, "nodeId");
					this.matching.put(clsElement, new  UAObjectImpl());
				}
				else
				{
					continue;
				}
				
				try
				{
					long value = Long.valueOf(nodeId);
					nodeId = namespacePrefix + "i="+nodeId;
				}
				catch (Exception e) {
					nodeId = namespacePrefix + "s="+nodeId;
				}

				this.nodeIdMap.put(nodeId, clsElement);
			}
		}
		return;
	}
	
	private Object getUmlNodeReference(String nodeId)
	{
		Class umlElement = getUmlNode(nodeId);
		if(umlElement == null)
		{
			return null;
		}
		
		for(EObject applEObj : umlElement.getStereotypeApplications())
		{
			DynamicEObjectImpl stereotype = (DynamicEObjectImpl) applEObj;
			String cls = applEObj.eClass().getName();
			if(cls.equalsIgnoreCase("UAReferenceType") || cls.equalsIgnoreCase("UADataType") ||
				cls.equalsIgnoreCase("UAVariableType") ||cls.equalsIgnoreCase("UAObjectType") ||
				cls.equalsIgnoreCase("UAView") ||cls.equalsIgnoreCase("UAMethod") ||
				cls.equalsIgnoreCase("UAVariable") ||cls.equalsIgnoreCase("UAObject") )
			{
				return stereotype;
			}
		}	
		return null;
	}
	
	private boolean transformRolePermissions(ArrayList<UANode> rolePermissionNodes) {
		boolean success = true;
				
		for(UANode node : rolePermissionNodes)
		{
			success &= transformRolePermission(node);
			if(!success)
			{
				break;
			}
			EventPublisher.publishEvent(OpcUaDiagramTransformationResources.EventConstants.TRANSFORM_OPCUA_ROLEPERMISSIONS_TOPIC, 1);
		}
		
		return success;
	}
	
	@SuppressWarnings("unchecked")
		
	private boolean transformRolePermission(UANode rolePermissionNode) {
		Class parent = (Class) getElement(rolePermissionNode);
		return transformRolePermissionGen(rolePermissionNode, parent);
	}
	
	private boolean transformRolePermissionGen(Object rolePermissionNode, Class parent) {
		
		Stereotype uaNodeStereotype = getMatchingStereotype(rolePermissionNode);
		Stereotype uaRpStereotype = getMatchingStereotype(new RolePermissionImpl());
		EList<DynamicEObjectImpl> rpList = (EList<DynamicEObjectImpl>) parent.getValue(uaNodeStereotype, "rolePermissions");
		ArrayList<RolePermission> existingRpList = new ArrayList<RolePermission>();
		ArrayList<Class> elementsToDelete = new ArrayList<Class>();
		
		EList<RolePermission> rolepremissions;
		if(rolePermissionNode instanceof UANode)
		{
			UANode temp =(UANode) rolePermissionNode;
			rolepremissions = temp.getRolePermissions().getRolePermission();
		}
		else if(rolePermissionNode instanceof ModelTableEntry)
		{
			ModelTableEntry temp = (ModelTableEntry) rolePermissionNode;
			rolepremissions = temp.getRolePermissions().getRolePermission();
		}
		else
		{
			// unsupported type
			return false;
		}
		
		for(DynamicEObjectImpl rpObject : rpList)
		{
			Class rpClass = getStereotypeBaseClass(rpObject, true);
			DynamicEObjectImpl rpValue = (DynamicEObjectImpl) rpClass.getValue(uaRpStereotype, "value");
			if(rpValue == null)
			{
				elementsToDelete.add(rpClass);
				continue;
			}
			Class rpValueClass = getStereotypeBaseClass(rpValue, true);
			String rpValueNodeId = getNodeId(rpValueClass);
			
			boolean exists = false;
			for(RolePermission rp : rolepremissions)
			{
				if(rp.getValue().equalsIgnoreCase(rpValueNodeId))
				{
					rpClass.setValue(uaRpStereotype, "permissions", rp.getPermissions());
					existingRpList.add(rp);
					exists=true;
					break;
				}				
			}
			
			if(!exists)
			{
				elementsToDelete.add(rpClass);
			}
		}
		
		while(!elementsToDelete.isEmpty())
		{
			elementsToDelete.get(0).destroy();
			elementsToDelete.remove(0);
		}
		
		for(RolePermission rp : rolepremissions)
		{
			
			if(!existingRpList.contains(rp))
			{
				Package ns = parent.getNearestPackage();
				Class rpValue = (Class) this.nodeIdMap.get(rp.getValue());
				UANode uaRpValue = (UANode) matching.get(rpValue);
				Stereotype rpValueStereotype = getMatchingStereotype(uaRpValue);
				
				String name = "RolePermissions_"+rpValue.getName();
				
				Class rpClass;
				if(ns == null)
				{
					Model model = parent.getModel();
					rpClass = model.createOwnedClass(name, false);
				}
				else
				{
					rpClass = ns.createOwnedClass(name, false);
				}
				
				parent.getNestedClassifiers().add(rpClass);
				rpClass.applyStereotype(uaRpStereotype);
				rpClass.setValue(uaRpStereotype, "value", rpValue.getStereotypeApplication(rpValueStereotype));
				rpClass.setValue(uaRpStereotype, "permissions", rp.getPermissions());
				
				rpList.add((DynamicEObjectImpl) rpClass.getStereotypeApplication(uaRpStereotype));
			}
			
		}
		
		
		return true;
	}
	
	
	private Stereotype getMatchingStereotype(Object node)
	{
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaInstance = null;
		if(node instanceof UAVariable)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UAVariable");
		}
		else if(node instanceof UAObject)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UAObject");
		}
		else if(node instanceof UAMethod)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UAMethod");
		}
		else if(node instanceof UAView)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UAView");
		}
		else if(node instanceof UADataType)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UADataType");
		}
		else if(node instanceof UAObjectType)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UAObjectType");
		}
		else if(node instanceof UAVariableType)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UAVariableType");
		}
		else if(node instanceof UAReferenceType)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UAReferenceType");
		}
		else if(node instanceof DataTypeDefinition)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("DataTypeDefinition");
		}
		else if(node instanceof DataTypeField)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("DataTypeField");
		}
		else if(node instanceof RolePermission)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("RolePermission");
		}
		else if(node instanceof UAMethodArgument)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("UAMethodArgument");
		}
		else if(node instanceof ModelTableEntry)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("ModelTableEntry");
		}
		
		return uaInstance;
	}
	
	private Stereotype getMatchingStereotype(Class node)
	{
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaReferenceType  = nodeSetProfile.getOwnedStereotype("UAReferenceType");
		Stereotype uaDataType  = nodeSetProfile.getOwnedStereotype("UADataType");
		Stereotype uaVariableType  = nodeSetProfile.getOwnedStereotype("UAVariableType");
		Stereotype uaObjectType  = nodeSetProfile.getOwnedStereotype("UAObjectType");
		Stereotype uaView  = nodeSetProfile.getOwnedStereotype("UAView");
		Stereotype uaMethod  = nodeSetProfile.getOwnedStereotype("UAMethod");
		Stereotype uaVariable  = nodeSetProfile.getOwnedStereotype("UAVariable");
		Stereotype uaObject  = nodeSetProfile.getOwnedStereotype("UAObject");
		
		Stereotype return_val;
		 
		if(node.isStereotypeApplied(uaReferenceType))
		{
			return_val = uaReferenceType;
		}
		else if(node.isStereotypeApplied(uaDataType))
		{
			return_val = uaDataType;
		}
		else if(node.isStereotypeApplied(uaVariableType))
		{
			return_val = uaVariableType;
		}
		else if(node.isStereotypeApplied(uaObjectType))
		{
			return_val = uaObjectType;
		}
		else if(node.isStereotypeApplied(uaView))
		{
			return_val = uaView;
		}
		else if(node.isStereotypeApplied(uaMethod))
		{
			return_val = uaMethod;
		}
		else if(node.isStereotypeApplied(uaVariable))
		{
			return_val = uaVariable;
		}
		else if(node.isStereotypeApplied(uaObject))
		{
			return_val = uaObject;
		}
		else
		{
			return_val = null;
		}
			
		
		return return_val;
	}
	
	
	private Class getStereotypeBaseClass(DynamicEObjectImpl eObject, boolean addIfNotExists)
	{
		Class baseClass = null;
		EList<EStructuralFeature> featuresList2 = eObject.eClass().getEAllStructuralFeatures();
		for(EStructuralFeature feature2 : featuresList2)
		{
			int id2 = feature2.getFeatureID();
			String name2 = feature2.getName();
			if(name2.equalsIgnoreCase("base_Class"))
			{
				baseClass= (Class)eObject.dynamicGet(id2);
				
				break;
			}
		}
		
		return baseClass;
	}
	
	private String getNodeId(Class umlUaNode)
	{
		String nodeId = "";
		
		Package namespace = umlUaNode.getNearestPackage();
		Stereotype uaStereotype;
		
		uaStereotype = getMatchingStereotype(umlUaNode);
		
		if(umlUaNode.hasValue(uaStereotype, "nodeId"))
		{
			nodeId = (String) umlUaNode.getValue(uaStereotype, "nodeId");
			
			if(PreferenceProvider.getNodeIdSchema().equalsIgnoreCase("auto"))
			{				
				try {
					double d = Double.parseDouble(nodeId);
					nodeId = "i=" + nodeId;
				} catch (NumberFormatException nfe) {
					nodeId = "s=" + nodeId;
				}
			}
			// other option is string
			else
			{
				nodeId = "s=" + nodeId;
			}
			
			if(namespace != null && namespace.getURI() != null)
			{
				if(this.baseNodeset.getNamespaceUris() == null)
				{
					this.baseNodeset.setNamespaceUris(new UriTableImpl());
				}
				
				if(!this.baseNodeset.getNamespaceUris().getUri().contains(namespace.getURI()))
				{
					this.baseNodeset.getNamespaceUris().getUri().add(namespace.getURI());
				}
				
				int namespaceId = this.baseNodeset.getNamespaceUris().getUri().indexOf(namespace.getURI());
				namespaceId++; // arrays start at 0
				nodeId = "ns=" +String.valueOf(namespaceId) + ";" +nodeId;
			}
		}
		return nodeId;
	}

}

