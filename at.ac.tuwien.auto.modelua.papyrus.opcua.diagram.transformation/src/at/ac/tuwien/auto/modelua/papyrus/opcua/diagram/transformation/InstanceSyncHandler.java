package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation;

import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.Reference;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UADataType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAMethod;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANode;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UANodeSetType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObject;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAObjectType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAReferenceType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UAVariableType;

import at.ac.tuwien.auto.modelua.papyrus.opcua.console.OpcUaMessageConsole;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.opcuatouml.OpcUaToUmlTransformer;
import at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.umltoopcua.UmlToOpcUaTransformer;
import at.ac.tuwien.auto.modelua.papyrus.opcua.nodeset.parser.NodeSetParser;

public class InstanceSyncHandler {
	
	private Model baseUmlModel;
	private UANodeSetType baseNodeset;
	private HashMap<Element, Object> matching;
	private HashMap<String, Element> nodeIdMap;
	
	private UmlToOpcUaTransformer umlToOpcUa;
	private OpcUaToUmlTransformer opcUaToUml;
		
	public InstanceSyncHandler(Model umlModel, UANodeSetType nodeset)
	{
		this.baseUmlModel = umlModel;
		this.baseNodeset = nodeset;
		this.matching = new HashMap<Element, Object>();
		this.nodeIdMap = new HashMap<String, Element>();

		this.opcUaToUml = new OpcUaToUmlTransformer(umlModel, nodeset, matching, nodeIdMap);
		this.umlToOpcUa = new UmlToOpcUaTransformer(umlModel, nodeset, matching, nodeIdMap);
	}
	
	public boolean importPackage(String filepath) 
	{
		URI fileUri = URI.createFileURI(filepath);
		ResourceSet owner_resource = this.baseUmlModel.eResource().getResourceSet(); 
		Model modelimport = (Model) PackageUtil.loadPackage(fileUri, owner_resource);
				
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		if(modelimport.isProfileApplied(nodeSetProfile))
		{
			// Write Operations have to be executed inside a TransactionalEditingDomain
			// easiest way to do this is in a Command
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(this.baseUmlModel);
			
			// changes to diagrams shall be done inside commands
			ImportNodeSetCommand cmd = new ImportNodeSetCommand(domain);
			cmd.setImportModel(modelimport);
			cmd.setBaseModel(this.baseUmlModel);
			
			domain.getCommandStack().execute(cmd);
			
			return true;
		}
		
		return false;
	}
	
	public boolean writeToNodeSetFile() throws ParserConfigurationException
	{
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		
        IPath filePath = root.getLocation();
        URI uri = this.baseUmlModel.eResource().getURI();
		String path = uri.trimFileExtension().devicePath().substring("/resource/".length())+".xml";
		filePath=filePath.append(path);
		return writeToNodeSetFile(filePath.toOSString());
	}
	
	public boolean writeToNodeSetFile(String filepath) throws ParserConfigurationException
	{
		if(!filepath.endsWith(".xml"))
		{
			filepath = filepath+".xml";
		}
		OpcUaMessageConsole.debug("Writing NodeSet file to: "+filepath);
		return NodeSetParser.writeNodeSetFile(filepath, this.baseNodeset);
        
	}

	
	public void setNodeSetObject(UANodeSetType nodeset)
	{
		this.baseNodeset = nodeset;
	}
	
	public void setUmlModel (Model umlModel)
	{
		this.baseUmlModel = umlModel;
	}
		
	public boolean transformMember(Element object)
	{
		boolean return_val = false;
		return_val = this.umlToOpcUa.transformMember(object);
		return return_val;
	}
	
	public boolean transformNodeSet(UANodeSetType nodeset)
	{
		boolean return_val = false;
		return_val = this.opcUaToUml.transformNodeSet(nodeset);
		return return_val;
	}
		
	public boolean removeMember(Element obj) {
		
		if(!this.matching.containsKey(obj))
		{
			return true;
		}
		
		boolean success = false;
		Object toBeRemoved = this.matching.get(obj);
		
		if(toBeRemoved instanceof UADataType)
		{
			success = this.baseNodeset.getUADataType().remove(toBeRemoved);
		}
		else if(toBeRemoved instanceof UAMethod)
		{
			success = this.baseNodeset.getUAMethod().remove(toBeRemoved);
		}
		else if(toBeRemoved instanceof UAObjectType)
		{
			success = this.baseNodeset.getUAObjectType().remove(toBeRemoved);
		}
		else if(toBeRemoved instanceof UAObject)
		{
			success = this.baseNodeset.getUAObject().remove(toBeRemoved);
		}
		else if(toBeRemoved instanceof UAReferenceType)
		{
			success = this.baseNodeset.getUAReferenceType().remove(toBeRemoved);
		}
		else if(toBeRemoved instanceof UAVariable)
		{
			success = this.baseNodeset.getUAVariable().remove(toBeRemoved);
		}
		else if(toBeRemoved instanceof UAVariableType)
		{
			success = this.baseNodeset.getUAVariableType().remove(toBeRemoved);
		}else if(toBeRemoved instanceof Reference)
		{
			success = deleteUAReference((Reference) toBeRemoved, (Generalization) obj);
		}
		
		if(success)
		{
			this.matching.remove(obj);
		}
		
		return success;
	}
	
	
	private boolean deleteUAReference(Reference reference, Generalization general) {
		EList<Element> sources = general.getSources();
		
		for(Element source : sources)
		{
			UANode node = (UANode) this.matching.get(source);
			node.getReferences().getReference().remove(reference);
		}
		
		return true;
	}
}
