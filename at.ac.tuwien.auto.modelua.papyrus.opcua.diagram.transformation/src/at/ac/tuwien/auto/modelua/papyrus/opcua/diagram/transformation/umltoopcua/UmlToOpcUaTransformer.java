package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.transformation.umltoopcua;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.AliasTable;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.DataTypeDefinition;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.DataTypeField;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.DataTypePurpose;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.ListOfReferences;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.ModelTableEntry;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.NodeIdAlias;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.Reference;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.ReleaseStatus;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.RolePermission;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.StructureTranslationType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.TranslationType;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.UADataType;
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
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.AliasTableImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.DataTypeDefinitionImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.DataTypeFieldImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.ListOfReferencesImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.ListOfRolePermissionsImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.LocalizedTextImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.ModelTableEntryImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.ModelTableImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.NodeIdAliasImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.ReferenceImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.RolePermissionImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.StructureTranslationTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.TranslationTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UADataTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAInstanceImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAMethodArgumentImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAMethodImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UANodeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAObjectImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAObjectTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAReferenceTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UATypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAVariableImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAVariableTypeImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UAViewImpl;
import org.opcfoundation.ua._2011._03.ua.UANodeSet.impl.UriTableImpl;

import at.ac.tuwien.auto.modelua.papyrus.opcua.preferences.PreferenceProvider;

public class UmlToOpcUaTransformer {
	
	private Model baseUmlModel;
	private UANodeSetType baseNodeset;
	private HashMap<Element, Object> matching;
	private HashMap<String, Element> nodeIdMap;
		
	public UmlToOpcUaTransformer(Model umlModel, UANodeSetType nodeset, HashMap<Element, Object> matching, HashMap<String, Element> nodeIdMap)
	{
		this.baseUmlModel = umlModel;
		this.baseNodeset = nodeset;
		this.matching = matching;
		this.nodeIdMap = nodeIdMap;
	}
			
	public boolean transformMember(Element object)
	{
		boolean return_val = false;
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(this.baseUmlModel);
		
		if(object instanceof Class)
		{			
			// changes to diagrams shall be done inside commands
			TransformUMLClassCommand cmd = new TransformUMLClassCommand(domain);
			cmd.setClass((Class) object);
			cmd.registerInstanceSynchHandler(this);
			
			domain.getCommandStack().execute(cmd);
			
			return_val = cmd.getCommandResult();
		}
		else if(object instanceof Generalization)
		{
			// changes to diagrams shall be done inside commands
			TransformUMLGeneralizationCommand cmd = new TransformUMLGeneralizationCommand(domain);
			cmd.setGeneralization((Generalization) object);
			cmd.registerInstanceSynchHandler(this);
			
			domain.getCommandStack().execute(cmd);
			
			return_val = cmd.getCommandResult();
		}
		else if(object instanceof Model)
		{
			Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
			if(nodeSetProfile != null)
			{
				Stereotype nodeSetType   = nodeSetProfile.getOwnedStereotype("UANodeSetType");
				
				DynamicEObjectImpl stereotype = (DynamicEObjectImpl) object.getStereotypeApplication(nodeSetType);
				if(stereotype != null)
				{
					return_val=transformUANodeSetType((Model) object);
					if(return_val)
					{
						return_val &= transformModel((Model) object);
					}
				}				
			}
			else
			{
				return_val = false;
			}
		}
		else if(object instanceof Package)
		{
			
			// changes to diagrams shall be done inside commands
			TransformUMLPackageCommand cmd = new TransformUMLPackageCommand(domain);
			cmd.setPackage((Package) object);
			cmd.registerInstanceSynchHandler(this);
			
			domain.getCommandStack().execute(cmd);
			
			return_val = cmd.getCommandResult();
		}
		
		return return_val;
	}
	
	private boolean transformModel(Model model) {
		boolean success = true;
		
		for(Element member : model.getOwnedElements())
		{
			if(!this.matching.containsKey(member))
			{
				success &= transformMember(member);
			}
		}
				
		return success;
	}

	protected boolean transformNamespace(Package namespace) {
		
		if(namespace.getURI() == null || namespace.getURI().length() == 0)
		{
			// no namespace Uir set
			return false;
		}
		
		// only modify namespace when its inside the same model
		if(this.baseUmlModel.equals(namespace.getModel()))
		{			
			namespace.setName(namespace.getURI());
		}
		
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype nodeSetType   = nodeSetProfile.getOwnedStereotype("UANodeSetType");
		
		if(this.baseNodeset.getNamespaceUris() == null)
		{
			UriTableImpl nsTable = new UriTableImpl();
			this.baseNodeset.setNamespaceUris(nsTable);
		}
		
		@SuppressWarnings("unchecked")
		EcoreEList<DynamicEObjectImpl> nsList = (EcoreEList<DynamicEObjectImpl>) this.baseUmlModel.getValue(nodeSetType, "nameSpaceUris");
		this.baseNodeset.getNamespaceUris().getUri().clear();
		boolean already_added = false;
		
		for(DynamicEObjectImpl nsObject : nsList )
		{
			Package ns = (Package) nsObject.dynamicGet(0);
			
			if(namespace.equals(ns))
			{
				already_added = true;
			}
			
			if(ns.getURI() != null)
			{
				this.baseNodeset.getNamespaceUris().getUri().add(ns.getURI());
			}
		}
		
		if(!already_added)
		{
			Stereotype nameSpaceType   = nodeSetProfile.getOwnedStereotype("NameSpace");
			nsList.add((DynamicEObjectImpl) namespace.getStereotypeApplication(nameSpaceType));
		}
		
		if(!this.baseNodeset.getNamespaceUris().getUri().contains(namespace.getURI()))
		{
			this.baseNodeset.getNamespaceUris().getUri().add(namespace.getURI());
		}
		
		return true;
	}

	protected boolean transformClass(Class object)
	{
		EList<EObject> stereotype_applications = object.getStereotypeApplications();

		boolean success=false;
		
		for(EObject ster : stereotype_applications)
		{
			DynamicEObjectImpl stereotype = (DynamicEObjectImpl) ster;
			EClass cls = ster.eClass();
			
			switch(cls.getName()) {			
			case "AliasTable":
				success= transformAliasTable(object);
				break;
			case "DataTypeDefinition":
				success= transformDataTypeDefinition(object);
				break;
			case "DataTypeField":
				success=transformDataTypeField(object);
				break;
			case "ExtensionType":
				success=transformExtensionType(object);
				break;
			case "ModelTableEntry":
				success=transformModelTableEntry(object);
				break;
			case "NodeIdAlias":
				success=transformNodeIdAlias(object);
				break;
			case "RolePermission":
				success=transformRolePermission(object);
				break;
			case "StructureTranslationType":
				success=transformStructureTranslationType(object);
				break;
			case "TranslationType":
				success=transformTranslationType(object);
				break;
			case "UADataType":
				success=transformUADataType(object);
				break;
			case "UAMethod":
				success=transformUAMethod(object);
				break;
			case "UAMethodArgument":
				success=transformUAMethodArgument(object);
				break;
			case "UAObject":
				success=transformUAObject(object);
				break;
			case "UAObjectType":
				success=transformUAObjectType(object);
				break;
			case "UAReferenceType":
				success=transformUAReferenceType(object);
				break;
			case "UAVariable":
				success=transformUAVariable(object);
				break;
			case "UAVariableType":
				success=transformUAVariableType(object);
				break;
			case "UAView":
				success=transformUAView(object);
				break;
			case "ValueType":
				success=transformValueType(object);
				break;
			case "ValueType1":
				success=transformValueType1(object);
				break;
			default:
				break;
			}
		}
		
		return success;
		
	}
	
	private boolean transformValueType1(Class object) {
		// TODO: transform ValueType 1
		return false;
		
	}

	private boolean transformValueType(Class object) {
		// TODO: transform ValueType 
		return false;
	}

	private boolean transformUAView(Class object) {
		
		UAViewImpl uaView;
		if(this.matching.containsKey(object))
		{
			uaView = (UAViewImpl) this.matching.get(object);
		}
		else
		{
			uaView = new UAViewImpl();
			this.matching.put(object, uaView);
			if(object.getModel().equals(this.baseUmlModel))
			{
				this.baseNodeset.getUAView().add(uaView);
			}
		}
		
		boolean success = transformUAInstance(object);
		
		if(success)
		{
			Stereotype uaStereotype = getMatchingStereotype(uaView);
			

			if(object.hasValue(uaStereotype, "containsNoLoops"))
			{
				String stringToConvert = String.valueOf(object.getValue(uaStereotype, "containsNoLoops"));
				boolean convertedBoolean = Boolean.parseBoolean(stringToConvert);
				uaView.setContainsNoLoops(convertedBoolean);
			}
			else
			{
				uaView.unsetContainsNoLoops();
			}
			
			if(object.hasValue(uaStereotype, "eventNotifier"))
			{
				String stringToConvert = String.valueOf(object.getValue(uaStereotype, "eventNotifier"));
				short convertedShort = Short.parseShort(stringToConvert);
				uaView.setEventNotifier(convertedShort);
			}
			else
			{
				uaView.unsetEventNotifier();
			}
			
		}

		return true;
		
	}

	private boolean transformUAVariableType(Class object) {
		
		UAVariableTypeImpl uaVarType;
		if(this.matching.containsKey(object))
		{
			uaVarType = (UAVariableTypeImpl) this.matching.get(object);
		}
		else
		{
			uaVarType = new UAVariableTypeImpl();
			this.matching.put(object, uaVarType);
			if(object.getModel().equals(this.baseUmlModel))
			{
				this.baseNodeset.getUAVariableType().add(uaVarType);
			}
		}
		
		return transformUAType(object);
	}

	@SuppressWarnings("unchecked")
	private boolean transformUAVariable(Class object) {
		
		UAVariableImpl uaVariable;
		if(this.matching.containsKey(object))
		{
			uaVariable = (UAVariableImpl) this.matching.get(object);
		}
		else
		{
			uaVariable = new UAVariableImpl();
			this.matching.put(object, uaVariable);
			if(object.getModel().equals(this.baseUmlModel))
			{
				this.baseNodeset.getUAVariable().add(uaVariable);
			}
		}
		
		boolean success = transformUAInstance(object);
		

		if(success)
		{
			Stereotype uaStereotype = getMatchingStereotype(uaVariable);
			
			if(object.hasValue(uaStereotype, "value"))
			{
				//TODO: add value
//				Object value = object.getValue(uaStereotype, "value");
			}
			
			if(object.hasValue(uaStereotype, "translation"))
			{
				EList<DynamicEObjectImpl> translationList = (EList<DynamicEObjectImpl> )object.getValue(uaStereotype, "translation");
				uaVariable.getTranslation().clear();
				for(DynamicEObjectImpl translation : translationList)
				{					
					Class translationClass = getStereotypeBaseClass(translation, true);
					if(translationClass != null)
					{
						TranslationType tt = (TranslationType) this.matching.get(translationClass);
						uaVariable.getTranslation().add(tt);
						
						EList<Classifier> children = object.getNestedClassifiers();
						if(!children.contains(translationClass))
						{
							children.add(translationClass);
						}
					}
				}
			}
			
			if(object.hasValue(uaStereotype, "accessLevel"))
			{
				String stringToConvert = String.valueOf(object.getValue(uaStereotype, "accessLevel"));
				Long convertedLong = Long.parseLong(stringToConvert);
				uaVariable.setAccessLevel(convertedLong);
			}
			else
			{
				uaVariable.unsetAccessLevel();
			}
			
			if(object.hasValue(uaStereotype, "arrayDimensions"))
			{
				List<Object> arrayDimensions = (List<Object>) object.getValue(uaStereotype, "arrayDimensions");
				String convertedString ="";
				
				for(Object dimension : arrayDimensions)
				{
					convertedString = convertedString + "," + String.valueOf(dimension);
				}
								
				uaVariable.setArrayDimensions(convertedString.substring(1));
			}
			else
			{
				uaVariable.unsetArrayDimensions();
			}
			
			if(object.hasValue(uaStereotype, "dataType"))
			{
				DynamicEObjectImpl dataType = (DynamicEObjectImpl) object.getValue(uaStereotype, "dataType");

				Class parentClass = getStereotypeBaseClass(dataType, true);
				
				String nodeId = getNodeId(parentClass);	

				if(nodeId != null && nodeId.length() > 0)
				{					
					uaVariable.setDataType(nodeId);
				}

			}
			else
			{
				uaVariable.unsetDataType();;
			}
			
			if(object.hasValue(uaStereotype, "historizing"))
			{
				String stringToConvert = String.valueOf(object.getValue(uaStereotype, "historizing"));
				boolean convertedBoolean = Boolean.parseBoolean(stringToConvert);
				uaVariable.setHistorizing(convertedBoolean);

			}
			else
			{
				uaVariable.unsetHistorizing();
			}

			if(object.hasValue(uaStereotype, "minimumSamplingInterval"))
			{
				double intervall = (double ) object.getValue(uaStereotype, "minimumSamplingInterval");
				uaVariable.setMinimumSamplingInterval(intervall);

			}

			else
			{
				uaVariable.unsetMinimumSamplingInterval();
			}
			
			
			if(object.hasValue(uaStereotype, "userAccessLevel"))
			{
				String stringToConvert = String.valueOf(object.getValue(uaStereotype, "userAccessLevel"));
				Long convertedLong = Long.parseLong(stringToConvert);
				uaVariable.setUserAccessLevel(convertedLong);
			}
			else
			{
				uaVariable.unsetUserAccessLevel();
			}
			
			if(object.hasValue(uaStereotype, "valueRank"))
			{
				String stringToConvert = String.valueOf(object.getValue(uaStereotype, "valueRank"));
				int convertedInt = Integer.parseInt(stringToConvert);
				uaVariable.setValueRank(convertedInt);

			}
			else
			{
				uaVariable.unsetValueRank();
			}
		}
		
		return success;
	}

	private boolean transformUAType(Class object) {
		UAType uaObjType;
		if(this.matching.containsKey(object))
		{
			uaObjType = (UAType) this.matching.get(object);
		}
		else
		{
			uaObjType = new UATypeImpl();
			this.matching.put(object, uaObjType);
		}
				
		return transformUANode(object);
	}

	@SuppressWarnings("unchecked")
	private boolean transformUAReferenceType(Class object) {
		
		UAReferenceTypeImpl uaRefType;
		if(this.matching.containsKey(object))
		{
			uaRefType = (UAReferenceTypeImpl) this.matching.get(object);
		}
		else
		{
			uaRefType = new UAReferenceTypeImpl();
			this.matching.put(object, uaRefType);
			if(object.getModel().equals(this.baseUmlModel))
			{
				this.baseNodeset.getUAReferenceType().add(uaRefType);
			}
		}
		
		boolean success = transformUAType(object);
		
		if(success)
		{
			Stereotype uaStereotype = getMatchingStereotype(uaRefType);
			if(object.hasValue(uaStereotype, "inverseName"))
			{
				EList<String> inverseNameList = (EList<String>) object.getValue(uaStereotype, "inverseName");
				uaRefType.getInverseName().clear();
				
				for(String inverseName : inverseNameList)
				{
					LocalizedTextImpl lt = new LocalizedTextImpl();
					lt.setValue(inverseName);
					uaRefType.getInverseName().add(lt);
				}
			}
			
			if(object.hasValue(uaStereotype, "symmetric"))
			{
				boolean symmetric = (boolean) object.getValue(uaStereotype, "symmetric");
				uaRefType.setSymmetric(symmetric);
			}
		}


		return success;
	}

	private boolean transformUAObjectType(Class object) {
		
		UAObjectTypeImpl uaObjType;
		if(this.matching.containsKey(object))
		{
			uaObjType = (UAObjectTypeImpl) this.matching.get(object);
		}
		else
		{
			uaObjType = new UAObjectTypeImpl();
			this.matching.put(object, uaObjType);
			if(object.getModel().equals(this.baseUmlModel))
			{
				this.baseNodeset.getUAObjectType().add(uaObjType);
			}
		}
		
		boolean success = transformUAType(object);
		
		return success;
	}

	private boolean transformUAObject(Class object) {
		UAObjectImpl uaObject;
		if(this.matching.containsKey(object))
		{
			uaObject = (UAObjectImpl) this.matching.get(object);
		}
		else
		{
			uaObject = new UAObjectImpl();
			this.matching.put(object, uaObject);
			if(object.getModel().equals(this.baseUmlModel))
			{
				this.baseNodeset.getUAObject().add(uaObject);
			}
		}
		
		boolean success = transformUAInstance(object);
		
		if(success)
		{
			Stereotype uaStereotype = getMatchingStereotype(uaObject);
			
			if(object.hasValue(uaStereotype, "eventNotifier"))
			{
				String stringToConvert = String.valueOf(object.getValue(uaStereotype, "eventNotifier"));
				short convertedShort = Short.parseShort(stringToConvert);
				uaObject.setEventNotifier(convertedShort);
			}
			else
			{
				uaObject.unsetEventNotifier();
			}
		}
			
		return success;
	}

	@SuppressWarnings("unchecked")
	private boolean transformUANodeSetType(Model object) {
		
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype nodeSetType   = nodeSetProfile.getOwnedStereotype("UANodeSetType");
		
		if(this.baseUmlModel.hasValue(nodeSetType, "nameSpaceUris"))
		{			
			EcoreEList<DynamicEObjectImpl> nsList = (EcoreEList<DynamicEObjectImpl>) this.baseUmlModel.getValue(nodeSetType, "nameSpaceUris");
			
			for(DynamicEObjectImpl nsObject : nsList )
			{
				Package ns = (Package) nsObject.dynamicGet(0);
				
				if(ns.getURI() != null)
				{
					this.baseNodeset.getNamespaceUris().getUri().add(ns.getURI());
				}
			}
		}
		
		if(this.baseUmlModel.hasValue(nodeSetType, "serverUris"))
		{
			EcoreEList<String> serverUriList = (EcoreEList<String>) this.baseUmlModel.getValue(nodeSetType, "serverUris");
			
			if(this.baseNodeset.getServerUris() == null)
			{
				this.baseNodeset.setServerUris(new UriTableImpl());
			}
			
			this.baseNodeset.getServerUris().getUri().clear();
			
			for(String serverUri : serverUriList)
			{
				this.baseNodeset.getServerUris().getUri().add(serverUri);
			}
		}		
		
		if(object.hasValue(nodeSetType, "models"))
		{
			EList<DynamicEObjectImpl> modelEntriess = (EList<DynamicEObjectImpl>) object.getValue(nodeSetType, "models");
			
			if(this.baseNodeset.getModels() == null)
			{
				this.baseNodeset.setModels(new ModelTableImpl());
			}
			else
			{
				this.baseNodeset.getModels().getModel().clear();
			}
			
			EList<ModelTableEntry> models = this.baseNodeset.getModels().getModel();
			
			for(DynamicEObjectImpl modelEntry : modelEntriess)
			{
				Class baseClass = getStereotypeBaseClass(modelEntry, true);
				
				if(!this.matching.containsKey(baseClass))
				{
					transformModelTableEntry(baseClass);
				}
				ModelTableEntry mte = (ModelTableEntry) this.matching.get(baseClass);
				models.add(mte);
			}
		}
		else if(this.baseNodeset.getModels() != null)
		{

			this.baseNodeset.getModels().getModel().clear();
		}

		
//		if(object.getValue(nodeSetType, "aliases") != null)
//		{
//				EDataTypeUniqueEList<String> aliases = (EDataTypeUniqueEList<String>) object.getValue(nodeSetType, "aliases");
//		}
//		
//		if(object.getValue(nodeSetType, "extensions") != null)
//		{
//			EDataTypeUniqueEList<String> extensions = (EDataTypeUniqueEList<String>) object.getValue(nodeSetType, "extensions");
//		}
		
//		
//		for(EStructuralFeature feature : featuresList)
//		{
//			int id = feature.getFeatureID();
//			String name = feature.getName();
//			Object temp = stereotype.dynamicGet(id);
//			
//			if(name.equalsIgnoreCase("aliases"))
//			{
//				if(temp == null)
//				{
//					continue;
//				}
//				
//				DynamicEObjectImpl alias_object = ((DynamicEObjectImpl) temp);
//				EList<EStructuralFeature> featuresList2 = alias_object.eClass().getEAllStructuralFeatures();
//				for(EStructuralFeature feature2 : featuresList2)
//				{
//					int id2 = feature2.getFeatureID();
//					String name2 = feature2.getName();
//					if(name2.equalsIgnoreCase("base_Class"))
//					{
//						Object baseClass = alias_object.dynamicGet(id2);
//						if(this.matching.containsKey(baseClass))
//						{
//							AliasTableImpl aliasTable = (AliasTableImpl) this.matching.get(baseClass);
//							this.baseNodeset.setAliases(aliasTable);
//							break;
//						}
//						else
//						{
//							transformClass((Class) baseClass);
//							AliasTableImpl aliasTable = (AliasTableImpl) this.matching.get(baseClass);
//							this.baseNodeset.setAliases(aliasTable);
//							break;
//						}
//					}
//				}
//			}
//			else if(name.equalsIgnoreCase("extensions"))
//			{
//				if(temp == null)
//				{
//					continue;
//				}
//			}
//		}
		
		return true;
		
	}

	@SuppressWarnings("unchecked")
	private boolean transformUANode(Class object) {
		
		UANodeImpl uanode;
		if(this.matching.containsKey(object))
		{
			uanode = (UANodeImpl) this.matching.get(object);
		}
		else
		{
			uanode = new UANodeImpl();
			this.matching.put(object, uanode);
		}

		Stereotype uaStereotype = getMatchingStereotype(uanode);

		if(object.hasValue(uaStereotype, "browseName"))
		{
			String browseName = (String) object.getValue(uaStereotype, "browseName");
			object.setName(browseName);
			
			Package namespace = object.getNearestPackage();
			if(namespace != null && namespace.getURI() != null && namespace.getURI().length() > 0)
			{
				if(this.baseNodeset.getNamespaceUris() == null)
				{
					this.baseNodeset.setNamespaceUris(new UriTableImpl());
				}
				
				EList<String> namespaces = this.baseNodeset.getNamespaceUris().getUri();
				
				int namespaceId = namespaces.indexOf(namespace.getURI());
				namespaceId++; // arrays start at 0
				browseName = String.valueOf(namespaceId) + ":" +browseName;
			}
			
			uanode.setBrowseName( browseName);		
		}
		
		if(object.hasValue(uaStereotype, "nodeId"))
		{
			String nodeId = getNodeId(object);	

			if(nodeId != null && nodeId.length() > 0)
			{					
				uanode.setNodeId(nodeId);
			}
			this.nodeIdMap.put(nodeId, object);
		}
		else
		{
			return false;
		}

		if(object.hasValue(uaStereotype, "displayName"))
		{
			EDataTypeUniqueEList<String> displayName = (EDataTypeUniqueEList<String>) object.getValue(uaStereotype, "displayName");
			uanode.getDisplayName().clear();
			for(String dnEntry : displayName)
			{
				LocalizedTextImpl lt = new LocalizedTextImpl();
				lt.setValue(dnEntry);
				uanode.getDisplayName().add(lt);
			}
		}
		else
		{
			uanode.getDisplayName().clear();
		}
		
		if(object.hasValue(uaStereotype, "description"))
		{
			EDataTypeUniqueEList<String> description = (EDataTypeUniqueEList<String>) object.getValue(uaStereotype, "description");
			uanode.getDescription().clear();
			for(String dEntry : description)
			{
				LocalizedTextImpl lt = new LocalizedTextImpl();
				lt.setValue(dEntry);
				uanode.getDescription().add(lt);
			}
		}
		else
		{
			uanode.getDescription().clear();
		}
		
		if(object.hasValue(uaStereotype, "category"))
		{
			EDataTypeUniqueEList<String> category = (EDataTypeUniqueEList<String>) object.getValue(uaStereotype, "category");
			uanode.getCategory().clear();
			uanode.getCategory().addAll(category);
		}
		else
		{
			uanode.getCategory().clear();
		}
		
		if(object.hasValue(uaStereotype, "documentation"))
		{
			String documentation = (String) object.getValue(uaStereotype, "documentation");
			uanode.setDocumentation( documentation);
		}
		else
		{
			uanode.setDocumentation("");
		}
		
		
		if(object.hasValue(uaStereotype, "rolePermissions"))
		{

			EList<Classifier> classifierList = object.getNestedClassifiers();
			EcoreEList<DynamicEObjectImpl> rolePermissions = (EcoreEList<DynamicEObjectImpl>) object.getValue(uaStereotype, "rolePermissions");
			
			for(DynamicEObjectImpl rolePermission : rolePermissions)
			{
				Class rolePermissionsClass = getStereotypeBaseClass(rolePermission, true);
				
				
				if(!classifierList.contains(rolePermissionsClass))
				{
					classifierList.add(rolePermissionsClass);
				}
				
				if(uanode.getRolePermissions() == null)
				{
					uanode.setRolePermissions(new ListOfRolePermissionsImpl());
				}
				
				if(this.matching.containsKey(rolePermissionsClass))
				{
					RolePermission uaRolePermission = (RolePermission) this.matching.get(rolePermissionsClass);
					uanode.getRolePermissions().getRolePermission().add(uaRolePermission);
				}
			}
		}
		else 
		{
			if(uanode.getRolePermissions() == null)
			{
				uanode.setRolePermissions(new ListOfRolePermissionsImpl());
			}
			else
			{				
				uanode.getRolePermissions().getRolePermission().clear();
			}
		}


		
		if(object.hasValue(uaStereotype, "accessRestrictions"))
		{
			Object temp = object.getValue(uaStereotype, "accessRestrictions");
			String stringToConvert = String.valueOf(temp);
			short convertedShort = Short.parseShort(stringToConvert);
			uanode.setAccessRestrictions(convertedShort);
		}
		else
		{
			uanode.unsetAccessRestrictions();
		}
		
		EnumerationLiteral releaseStatus = (EnumerationLiteral) object.getValue(uaStereotype, "releaseStatus");
		String value = releaseStatus.getLabel();
		switch(value)
		{
		case "Draft":
			uanode.setReleaseStatus(ReleaseStatus.DRAFT);
			break;
		case "Released":
			uanode.setReleaseStatus(ReleaseStatus.RELEASED);
			break;
		case "Deprecated":
			uanode.setReleaseStatus(ReleaseStatus.DEPRECATED);
			break;
		default:
			uanode.unsetReleaseStatus();
		}
		

		if(object.hasValue(uaStereotype, "symbolicName"))
		{
			EDataTypeUniqueEList<String> symbolicName = (EDataTypeUniqueEList<String>) object.getValue(uaStereotype, "symbolicName");
			uanode.setSymbolicName(symbolicName);
		}
		else
		{
			if(uanode.getSymbolicName() != null)
			{				
				uanode.getSymbolicName().clear();
			}
		}
		
		if(object.hasValue(uaStereotype, "userWriteMask"))
		{
			Object temp = object.getValue(uaStereotype, "userWriteMask");
			String stringToConvert = String.valueOf(temp);
			long convertedLong = Long.parseLong(stringToConvert);
			uanode.setUserWriteMask(convertedLong);
		}
		else
		{
			uanode.unsetUserWriteMask();
		}
		
		if(object.hasValue(uaStereotype, "writeMask"))
		{
			Object temp = object.getValue(uaStereotype, "writeMask");
			String stringToConvert = String.valueOf(temp);
			long convertedLong = Long.parseLong(stringToConvert);
			uanode.setWriteMask(convertedLong);
		}
		else
		{
			uanode.unsetWriteMask();
		}
		
		ListOfReferences listOfReferences = uanode.getReferences();
		if(listOfReferences == null)
		{
			listOfReferences = new ListOfReferencesImpl();
			uanode.setReferences(listOfReferences);
		}
		
		listOfReferences.getReference().clear();
		
		for(Generalization reference :object.getGeneralizations())
		{
			if(! this.matching.containsKey(reference))
			{
				transformGeneralization(reference);
			}
			listOfReferences.getReference().add((Reference) this.matching.get(reference));

		}

		return true;
	}



	private boolean transformUAMethod(Class object) {
		
		UAMethodImpl uaMethod;
		if(this.matching.containsKey(object))
		{
			uaMethod = (UAMethodImpl) this.matching.get(object);
		}
		else
		{
			uaMethod = new UAMethodImpl();
			this.matching.put(object, uaMethod);
			if(object.getModel().equals(this.baseUmlModel))
			{				
				this.baseNodeset.getUAMethod().add(uaMethod);
			}
		}
		
		boolean success = transformUAInstance(object);
		
		if(success)
		{
			Stereotype uaStereotype = getMatchingStereotype(uaMethod);

			if(object.hasValue(uaStereotype, "argumentDescription"))
			{
				@SuppressWarnings("unchecked")
				EcoreEList<DynamicEObjectImpl> argumentDescriptionList = (EcoreEList<DynamicEObjectImpl>) object.getValue(uaStereotype, "argumentDescription");
				for(DynamicEObjectImpl argumentDescriptionEntry : argumentDescriptionList)
				{
					Class argumentDescription = getStereotypeBaseClass(argumentDescriptionEntry, true);
					if(argumentDescription != null)
					{
						UAMethodArgument uaMethArg = (UAMethodArgument) this.matching.get(argumentDescription);
						if(!uaMethod.getArgumentDescription().contains(uaMethArg))
						{						
							uaMethod.getArgumentDescription().add(uaMethArg);
						}
						
						EList<Classifier> children = object.getNestedClassifiers();
						if(!children.contains(argumentDescription))
						{
							children.add(argumentDescription);
						}
					
					}
				}		
			}
			else
			{
				uaMethod.getArgumentDescription().clear();
			}
			
			if(object.hasValue(uaStereotype, "executable"))
			{
				boolean executable = (boolean) object.getValue(uaStereotype, "executable");
				uaMethod.setExecutable(executable);
			}
			else
			{
				uaMethod.unsetExecutable();
			}
			
			if(object.hasValue(uaStereotype, "methodDeclarationId"))
			{
				DynamicEObjectImpl methodDeclarationId = (DynamicEObjectImpl) object.getValue(uaStereotype, "methodDeclarationId");

				Class methodDeclarationClass = getStereotypeBaseClass(methodDeclarationId, true);
				
				String nodeId = getNodeId(methodDeclarationClass);	

				if(nodeId != null && nodeId.length() > 0)
				{					
					uaMethod.setMethodDeclarationId(nodeId);
				}
			}
			else
			{
				uaMethod.setMethodDeclarationId("");
			}
			
			if(object.hasValue(uaStereotype, "userExecutable"))
			{
				boolean userExecutable = (boolean) object.getValue(uaStereotype, "executable");
				uaMethod.setUserExecutable(userExecutable);
			}
			else
			{
				uaMethod.unsetUserExecutable();
			}
			
			return success;
		}

		

		return true;
	}

	@SuppressWarnings("unchecked")
	private boolean transformUAMethodArgument(Class object) {
	
		UAMethodArgumentImpl uaMethArg;
		
		if(this.matching.containsKey(object))
		{
			uaMethArg = (UAMethodArgumentImpl) this.matching.get(object);
		}
		else
		{
			uaMethArg = new UAMethodArgumentImpl();
			this.matching.put(object, uaMethArg);
		}
		
		Stereotype uaStereotype = getMatchingStereotype(uaMethArg);

		if(object.hasValue(uaStereotype, "name"))
		{
			String name = String.valueOf(object.getValue(uaStereotype, "name"));
			uaMethArg.setName(name);
		}
		else
		{
			uaMethArg.setName("");
		}
		
		if(object.hasValue(uaStereotype, "description"))
		{
			EDataTypeUniqueEList<String> descriptionList = (EDataTypeUniqueEList<String>) object.getValue(uaStereotype, "description");
			uaMethArg.getDescription().clear();
			
			for(String description : descriptionList)
			{
				LocalizedTextImpl lt = new LocalizedTextImpl();
				lt.setValue(description);
				uaMethArg.getDescription().add(lt);
			}
		}
		else
		{
			uaMethArg.getDescription().clear();
		}
		
		return false;
	}
	
	private boolean transformUAInstance(Class object) {
		
		UAInstanceImpl uaInstance;
		if(this.matching.containsKey(object))
		{
			uaInstance = (UAInstanceImpl) this.matching.get(object);
		}
		else
		{
			uaInstance = new UAInstanceImpl();
			this.matching.put(object, uaInstance);
		}
				
		boolean success = transformUANode(object);
		
		Stereotype uaStereotype = getMatchingStereotype(uaInstance);
		if(object.hasValue(uaStereotype, "parentNodeId"))
		{
			DynamicEObjectImpl parentNode = (DynamicEObjectImpl) object.getValue(uaStereotype, "parentNodeId");

			Class parentClass = getStereotypeBaseClass(parentNode, true);
			
			String nodeId = getNodeId(parentClass);	

			if(nodeId != null && nodeId.length() > 0)
			{					
				uaInstance.setParentNodeId(nodeId);
			}
		}
		else
		{
			uaInstance.setParentNodeId("");
		}
			
		return success;
	}

	private boolean transformUADataType(Class object) {

		UADataTypeImpl uaDataType;
		if(this.matching.containsKey(object))
		{
			uaDataType = (UADataTypeImpl) this.matching.get(object);
		}
		else
		{
			uaDataType = new UADataTypeImpl();
			this.matching.put(object, uaDataType);
			if(object.getModel().equals(this.baseUmlModel))
			{				
				this.baseNodeset.getUADataType().add(uaDataType);
			}
		}
		boolean success = transformUAType(object);
		
		if(success)
		{
			Stereotype dataTypeSter = getMatchingStereotype(uaDataType);
			
			if(object.hasValue(dataTypeSter, "purpose"))
			{
				EnumerationLiteral lit = (EnumerationLiteral) object.getValue(dataTypeSter, "purpose");
				String value = lit.toString();
				switch(value)
				{
				case "Normal":
					uaDataType.setPurpose(DataTypePurpose.NORMAL);
					break;
				case "CodeGenerator":
					uaDataType.setPurpose(DataTypePurpose.CODE_GENERATOR);
					break;
				case "ServicesOnly":
					uaDataType.setPurpose(DataTypePurpose.SERVICES_ONLY);
					break;
				}
			}
			else
			{
				uaDataType.unsetPurpose();
			}
			
			
			if(object.hasValue(dataTypeSter, "definition"))
			{
				DynamicEObjectImpl definition = (DynamicEObjectImpl)object.getValue(dataTypeSter, "definition");
				Class dataTypeDefinition = getStereotypeBaseClass(definition, true);
				if(dataTypeDefinition != null)
				{
					DataTypeDefinition dtd = (DataTypeDefinition) this.matching.get(dataTypeDefinition);
					uaDataType.setDefinition(dtd);
					
					EList<Classifier> children = object.getNestedClassifiers();
					if(!children.contains(definition))
					{
						children.add(dataTypeDefinition);
					}
				}
			}
			else
			{
				uaDataType.setDefinition(null);
			}
		}

		return success;
	}

	@SuppressWarnings("unchecked")
	private boolean transformTranslationType(Class object) {
		
		TranslationTypeImpl tt;
		if( this.matching.containsKey(object))
		{
			tt = (TranslationTypeImpl) this.matching.get(object);

		}
		else
		{
			tt = new TranslationTypeImpl();
			this.matching.put(object, tt);
		}
		
		Stereotype uaStereotype = getMatchingStereotype(tt);
		if(object.hasValue(uaStereotype, "text"))
		{
			tt.getText().clear();
			List<String> texts = (List<String>) object.getValue(uaStereotype, "text");
			for(String txt : texts)
			{
				LocalizedTextImpl lt = new LocalizedTextImpl();
				lt.setValue(txt);
				tt.getText().add(lt);
			}
		}
		
		EcoreEList<DynamicEObjectImpl> ltsUML = (EcoreEList<DynamicEObjectImpl>) object.getValue(uaStereotype, "field");
		
		for(DynamicEObjectImpl ltUML : ltsUML)
		{
			Class baseClass = getStereotypeBaseClass(ltUML, true);
			if(this.matching.containsKey(baseClass))
			{
				StructureTranslationType existingLT = (StructureTranslationType) this.matching.get(baseClass);
				tt.getField().add(existingLT);
				break;
			}
			else
			{
				transformClass((Class) baseClass);
				StructureTranslationType existingLT = (StructureTranslationType) this.matching.get(baseClass);
				tt.getField().add(existingLT);
				break;
			}
		}
	
		return true;
	}

	@SuppressWarnings("unchecked")
	private boolean transformStructureTranslationType(Class object) {
		
		StructureTranslationTypeImpl stt;
		if( this.matching.containsKey(object))
		{
			stt = (StructureTranslationTypeImpl) this.matching.get(object);

		}
		else
		{
			stt = new StructureTranslationTypeImpl();
			this.matching.put(object, stt);
		}
		
		Stereotype uaStereotype = getMatchingStereotype(stt);
		
		if(object.hasValue(uaStereotype, "text"))
		{
			stt.getText().clear();
			List<String> texts = (List<String>) object.getValue(uaStereotype, "text");
			for(String txt : texts)
			{
				LocalizedTextImpl lt = new LocalizedTextImpl();
				lt.setValue(txt);
				stt.getText().add(lt);
			}
		}
		if(object.hasValue(uaStereotype, "name"))
		{
			String nameString = String.valueOf(object.getValue(uaStereotype, "name"));
			stt.setName((String) nameString);
		}	

		return true;
	}

	private boolean transformRolePermission(Class object) {
		
		RolePermissionImpl rp;
		if( this.matching.containsKey(object))
		{
			rp = (RolePermissionImpl) this.matching.get(object);

		}
		else
		{
			rp = new RolePermissionImpl();
			this.matching.put(object, rp);
		}

		Stereotype uaStereotype = getMatchingStereotype(rp);
		
		if(object.hasValue( uaStereotype, "value"))
		{
			DynamicEObjectImpl dataType = (DynamicEObjectImpl) object.getValue(uaStereotype, "value");

			Class parentClass = getStereotypeBaseClass(dataType, true);
			
			String nodeId = getNodeId(parentClass);	

			if(nodeId != null && nodeId.length() > 0)
			{					
				rp.setValue(nodeId);
			}
		}
		else
		{
			rp.setValue("");
		}
		
		if(object.hasValue( uaStereotype, "permissions"))
		{
			String stringToConvert = String.valueOf(object.getValue( uaStereotype, "permissions"));
	        Long convertedLong = Long.parseLong(stringToConvert);
			rp.setPermissions(convertedLong);
		}
		else
		{
			rp.unsetPermissions();
		}
				
		return true;
		
	}

	private boolean transformModelTableEntry(Class object) {
		ModelTableEntry mte;
		if( this.matching.containsKey(object))
		{
			mte = (ModelTableEntry) this.matching.get(object);

		}
		else
		{
			mte = new ModelTableEntryImpl();
			this.matching.put(object, mte);
		}

		Stereotype uaStereotype = getMatchingStereotype(mte);
		
		if(object.hasValue(uaStereotype, "rolePermissions"))
		{
			EList<Classifier> classifierList = object.getNestedClassifiers();
			EcoreEList<DynamicEObjectImpl> rolePermissions = (EcoreEList<DynamicEObjectImpl>) object.getValue(uaStereotype, "rolePermissions");
			
			if(mte.getRolePermissions() == null)
			{
				mte.setRolePermissions(new ListOfRolePermissionsImpl());
			}
			else
			{
				mte.getRolePermissions().getRolePermission().clear();
			}

			for(DynamicEObjectImpl rolePermission : rolePermissions)
			{
				Class rolePermissionsClass = getStereotypeBaseClass(rolePermission, true);
				
				
				if(!classifierList.contains(rolePermissionsClass))
				{
					classifierList.add(rolePermissionsClass);
				}
				
				
				if(this.matching.containsKey(rolePermissionsClass))
				{
					RolePermission uaRolePermission = (RolePermission) this.matching.get(rolePermissionsClass);
					mte.getRolePermissions().getRolePermission().add(uaRolePermission);
				}
			}
		}
		
		if(object.hasValue(uaStereotype, "requiredModel"))
		{
			EList<DynamicEObjectImpl> requiredModelUMLList = (EList<DynamicEObjectImpl>) object.getValue(uaStereotype, "requiredModel");
			mte.getRequiredModel().clear();
			for(DynamicEObjectImpl requiredModelUML: requiredModelUMLList)
			{
				Class baseClass = getStereotypeBaseClass(requiredModelUML, true);
				if(!this.matching.containsKey(baseClass))
				{
					transformModelTableEntry(baseClass);
				}
				ModelTableEntry requiredModelOPCUA = (ModelTableEntry) this.matching.get(baseClass);
				mte.getRequiredModel().add(requiredModelOPCUA);
			}
		}
		else
		{
			mte.getRequiredModel().clear();
		}
		
		if(object.hasValue(uaStereotype, "accessRestrictions"))
		{
			String stringTConvert = String.valueOf(object.getValue(uaStereotype, "modelUri"));
			short convertedShort = Short.valueOf(stringTConvert);
			mte.setAccessRestrictions(convertedShort);
		}
		else
		{
			mte.unsetAccessRestrictions();
		}
		
		if(object.hasValue(uaStereotype, "modelUri"))
		{
			String modelUriString = String.valueOf(object.getValue(uaStereotype, "modelUri"));
			mte.setModelUri(modelUriString);
		}
		else
		{
			mte.setModelUri("");
		}
		

		if(object.hasValue(uaStereotype, "publicationDate"))
		{
			String datetime = String.valueOf(object.getValue(uaStereotype, "publicationDate"));
			int year;
			int month;
			int dayOfMonth;
			String[] segments = datetime.split(".");
			
			if(segments.length != 3)
			{
				return false;
			}
			
			// year.month.day
			if(segments[0].length() == 4)
			{
				year = Integer.valueOf(segments[0]);
				month = Integer.valueOf(segments[1]);
				dayOfMonth = Integer.valueOf(segments[2]);
			}
			// day.month.year
			else if( segments[2].length() == 4)
			{
				year = Integer.valueOf(segments[2]);
				month = Integer.valueOf(segments[1]);
				dayOfMonth = Integer.valueOf(segments[0]);
			}
			else
			{
				// date time format not supported
				return false;
			}
			
			if(year < 0 || month < 1 || month > 12 || dayOfMonth <1 || 
				(month == 2 && dayOfMonth > 29) ||
				((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && dayOfMonth > 31) ||
				((month == 4 || month == 6 || month == 9 || month == 11 ) && dayOfMonth > 30))
			{
				// Not a valid date
				return false;
			}
						
			XMLGregorianCalendar pubDate = mte.getPublicationDate();
			if(pubDate == null)
			{
				try {
					pubDate = DatatypeFactory.newInstance().newXMLGregorianCalendar();
				} catch (DatatypeConfigurationException e) {
					e.printStackTrace();
					return false;
				}
			}
			pubDate.setYear(year);
			pubDate.setMonth(month);
			pubDate.setDay(dayOfMonth);
		}
		else
		{
			mte.setPublicationDate(null);
		}
		
		if(object.hasValue(uaStereotype, "version"))
		{
			String versionString = String.valueOf(object.getValue(uaStereotype, "version"));
			mte.setVersion(versionString);
		}
		else
		{
			mte.setVersion("");
		}
		
		
		
		return false;
	}


	private boolean transformExtensionType(Class object) {
		//TODO: Implement Extension Type transformation 
		return false;
	}
	
	@SuppressWarnings("unchecked")
	private boolean transformDataTypeField(Class object) {
	
		DataTypeFieldImpl dtf;
		if( this.matching.containsKey(object))
		{
			dtf = (DataTypeFieldImpl) this.matching.get(object);

		}
		else
		{
			dtf = new DataTypeFieldImpl();
			this.matching.put(object, dtf);
		}
		Stereotype sterDTF = getMatchingStereotype(dtf);
		
		if(object.getValue(sterDTF, "displayName") !=null)
		{			

			EDataTypeUniqueEList<String> displayNameList = (EDataTypeUniqueEList<String>) object.getValue(sterDTF, "displayName");
			dtf.getDisplayName().clear();
			
			for(String displayName : displayNameList)
			{
				LocalizedTextImpl lt = new LocalizedTextImpl();
				lt.setValue(displayName);
				dtf.getDisplayName().add(lt);
			}
		}
		else
		{
			dtf.getDisplayName().clear();
		}
		
		if(object.getValue(sterDTF, "description") !=null)
		{			

			EDataTypeUniqueEList<String> descriptionList = (EDataTypeUniqueEList<String>) object.getValue(sterDTF, "description");
			dtf.getDescription().clear();
			
			for(String description : descriptionList)
			{
				LocalizedTextImpl lt = new LocalizedTextImpl();
				lt.setValue(description);
				dtf.getDescription().add(lt);
			}
		}
		else
		{
			dtf.getDescription().clear();
		}
		
		if(object.getValue(sterDTF, "abstractDataType") !=null)
		{			
			DynamicEObjectImpl abstractDataType = (DynamicEObjectImpl) object.getValue(sterDTF, "abstractDataType");
			
			Class umlUaNode = getStereotypeBaseClass(abstractDataType, true);
			
			if(!this.matching.containsKey(umlUaNode))
			{
				transformClass(umlUaNode);
			}
			
			if(umlUaNode != null)
			{
				String nodeId = getNodeId(umlUaNode);	

				if(nodeId != null && nodeId.length() > 0)
				{					
					dtf.setAbstractDataType(nodeId);
				}
				
			}
		}
		else
		{
			dtf.setAbstractDataType("");
		}
		
		if(object.getValue(sterDTF, "arrayDimensions") !=null)
		{		
			List<Object> arrayDimensions = (List<Object>) object.getValue(sterDTF, "arrayDimensions");
			String convertedString ="";
			
			for(Object dimension : arrayDimensions)
			{
				convertedString = convertedString + "," + String.valueOf(dimension);
			}
							
			dtf.setArrayDimensions(convertedString.substring(1));
			
		}
		else
		{
			dtf.unsetArrayDimensions();
		}
		
		if(object.getValue(sterDTF, "dataType") !=null)
		{			
			
			DynamicEObjectImpl abstractDataType = (DynamicEObjectImpl) object.getValue(sterDTF, "dataType");
			
			Class umlUaNode = getStereotypeBaseClass(abstractDataType, true);
			
			if(!this.matching.containsKey(umlUaNode))
			{
				transformClass(umlUaNode);
			}
			
			if(umlUaNode != null)
			{
				Stereotype uaStereotype = getMatchingStereotype(this.matching.get(umlUaNode));
				
				if(umlUaNode.hasValue(uaStereotype, "nodeId"))
				{
					String nodeId = getNodeId(umlUaNode);			
					if(nodeId != null && nodeId.length() > 0)
					{					
						dtf.setDataType(nodeId);
					}
					
				}
				
			}
		}
		else
		{
			dtf.unsetDataType();
		}
		
		if(object.getValue(sterDTF, "isOptional") !=null)
		{			
			String stringToConvert = String.valueOf(object.getValue(sterDTF, "isOptional"));
			boolean convertedBoolean = Boolean.parseBoolean(stringToConvert);
			dtf.setIsOptional(convertedBoolean);
		}
		else
		{
			dtf.unsetIsOptional();
		}

		if(object.getValue(sterDTF, "maxStringLength") !=null)
		{			
			String stringToConvert = String.valueOf(object.getValue(sterDTF, "maxStringLength"));
			long convertedLong = Long.parseLong(stringToConvert);
			dtf.setMaxStringLength(convertedLong);
		}
		else
		{
			dtf.unsetMaxStringLength();
		}
		
		if(object.getValue(sterDTF, "name") !=null)
		{			
			String stringName = String.valueOf(object.getValue(sterDTF, "name"));
			dtf.setName(stringName);
		}
		else
		{
			dtf.setName("");
		}
		
		if(object.getValue(sterDTF, "symbolicName") !=null)
		{			

			EDataTypeUniqueEList<String> symbolicNameList = (EDataTypeUniqueEList<String>) object.getValue(sterDTF, "symbolicName");
			if(dtf.getSymbolicName() == null)
			{
				dtf.setSymbolicName(new ArrayList<String>());
			}
			dtf.getSymbolicName().clear();
			
			for(String symbolicName : symbolicNameList)
			{
				dtf.getSymbolicName().add(symbolicName);
			}
		}
		else
		{
			dtf.getSymbolicName().clear();
		}
		
		if(object.getValue(sterDTF, "value") !=null)
		{			
			String stringToConvert = String.valueOf(object.getValue(sterDTF, "value"));
			int convertedInt = Integer.parseInt(stringToConvert);
			dtf.setValue(convertedInt);
		}
		else
		{
			dtf.unsetValue();
		}
		
		if(object.getValue(sterDTF, "valueRank") !=null)
		{			
			String stringToConvert = String.valueOf(object.getValue(sterDTF, "valueRank"));
			int convertedInt = Integer.parseInt(stringToConvert);
			dtf.setValueRank(convertedInt);
		}
		else
		{
			dtf.unsetValueRank();
		}
		
		return true;
		
	}

	@SuppressWarnings("unchecked")
	private boolean transformDataTypeDefinition(Class object) {
			
		DataTypeDefinitionImpl dtd;
		if( this.matching.containsKey(object))
		{
			dtd = (DataTypeDefinitionImpl) this.matching.get(object);
		}
		else
		{
			dtd = new DataTypeDefinitionImpl();
			this.matching.put(object, dtd);
		}
		Stereotype sterDTD = getMatchingStereotype(dtd);
		
		if(object.getValue(sterDTD, "field") !=null)
		{			
			EcoreEList<DynamicEObjectImpl> field = (EcoreEList<DynamicEObjectImpl>) object.getValue(sterDTD, "field");
			for(DynamicEObjectImpl fieldEntry : field)
			{
				Class dataTypeField = getStereotypeBaseClass(fieldEntry, true);
				if(dataTypeField != null)
				{
					DataTypeField dtf = (DataTypeField) this.matching.get(dataTypeField);
					if(!dtd.getField().contains(dtf))
					{						
						dtd.getField().add(dtf);
					}
					
					EList<Classifier> children = object.getNestedClassifiers();
					if(!children.contains(dataTypeField))
					{
						children.add(dataTypeField);
					}
				
				}
			}			
		}
		else
		{
			dtd.getField().clear();
		}
		
		if(object.getValue(sterDTD, "isOptionSet") !=null)
		{			
			String stringToConvert = String.valueOf(object.getValue(sterDTD, "isOptionSet"));
			boolean convertedBoolean = Boolean.parseBoolean(stringToConvert);
			dtd.setIsOptionSet(convertedBoolean);
		}
		else
		{
			dtd.unsetIsOptionSet();
		}

		if(object.getValue(sterDTD, "isUnion") !=null)
		{			
			String stringToConvert = String.valueOf(object.getValue(sterDTD, "isUnion"));
			boolean convertedBoolean = Boolean.parseBoolean(stringToConvert);
			dtd.setIsUnion(convertedBoolean);
		}
		else
		{
			dtd.unsetIsUnion();
		}
		
		if(object.getValue(sterDTD, "name") !=null)
		{			
			String stringToConvert = String.valueOf(object.getValue(sterDTD, "name"));
			dtd.setName(stringToConvert);
		}
		else
		{
			dtd.setName("");
		}
		
		if(object.getValue(sterDTD, "symbolicName") !=null)
		{			

			EDataTypeUniqueEList<String> symbolicNameList = (EDataTypeUniqueEList<String>) object.getValue(sterDTD, "symbolicName");
			dtd.getSymbolicName().clear();
			
			for(String symbolicName : symbolicNameList)
			{
				dtd.getSymbolicName().add(symbolicName);
			}
			
		}
		else
		{
			dtd.unsetSymbolicName();
		}
		
		return true;
	}
	@SuppressWarnings("unchecked")
	private boolean transformAliasTable(Class object) {	
		AliasTable aliasTable = this.baseNodeset.getAliases();
		if(aliasTable == null)
		{
			aliasTable = new AliasTableImpl();
			this.baseNodeset.setAliases(aliasTable);
			this.matching.put(object, aliasTable);
		}	
		aliasTable.getAlias().clear();
		
		Stereotype sterAliasTable = getMatchingStereotype(aliasTable);
		EcoreEList<DynamicEObjectImpl> aliasesUML = (EcoreEList<DynamicEObjectImpl>) object.getValue(sterAliasTable, "alias");
		for(DynamicEObjectImpl aliasUML : aliasesUML)
		{
			Class baseClass = getStereotypeBaseClass(aliasUML, true);
			if(this.matching.containsKey(baseClass))
			{
				NodeIdAlias existingAlias = (NodeIdAlias) this.matching.get(baseClass);
				aliasTable.getAlias().add(existingAlias);
			}
			else
			{
				transformClass((Class) baseClass);
				NodeIdAlias existingAlias = (NodeIdAlias) this.matching.get(baseClass);
				aliasTable.getAlias().add(existingAlias);
			}
		}
		
		return true;
	}
	
	private boolean transformNodeIdAlias(Class object) {
		
		NodeIdAlias alias;
		
		if( this.matching.containsKey(object))
		{
			alias = (NodeIdAlias) this.matching.get(object);
		}
		else
		{
			alias = new NodeIdAliasImpl();
			this.matching.put(object, alias);
		}
		
		Stereotype sterAlias = getMatchingStereotype(alias);
		
		if(object.hasValue(sterAlias, "alias"))
		{
			String aliasString = (String) object.getValue(sterAlias, "alias");
			alias.setAlias(aliasString);
		}
		
		if(object.hasValue(sterAlias, "value"))
		{
			String nodeIdString = (String) object.getValue(sterAlias, "value");
			alias.setAlias(nodeIdString);
		}
				
		return true;
	}
	
	protected boolean transformGeneralization(Generalization general) {

		if(general.getSources().size() != 1 || general.getTargets().size() != 1)
		{
			// only single source/target is supported
			return false;
		}
		
		Profile nodeSetProfile = this.baseUmlModel.getAppliedProfile("NodeSet");
		Stereotype uaStereoType  = nodeSetProfile.getOwnedStereotype("Reference");
		
		ReferenceImpl uaReference;
		
		if(this.matching.containsKey(general))
		{
			uaReference = (ReferenceImpl) this.matching.get(general);
		}
		else
		{
			uaReference = new ReferenceImpl();
			this.matching.put(general, uaReference);
			if(general.hasValue(uaStereoType,"isForward"))
			{
				uaReference.setIsForward((boolean) general.getValue(uaStereoType,"isForward"));
			}
		}
		
		Class target = (Class) general.getTargets().get(0);
		Class source = (Class) general.getSources().get(0);

		String nodeId = getNodeId(target);
		uaReference.setValue(nodeId);
		
		boolean isForward = uaReference.isIsForward();
		boolean isForwardOld = isForward;
		//if(general.hasValue(uaStereoType,"isForward"))
		{
			isForward =(boolean) general.getValue(uaStereoType,"isForward");
		}
//		isForward =(boolean) general.getValue(uaStereoType,"isForward");
		
		boolean directionChanged = isForwardOld ^ isForward;
		uaReference.setIsForward(isForward);

		if(general.hasValue(uaStereoType,"referenceType"))
		{
			Stereotype uaReferenceType  = nodeSetProfile.getOwnedStereotype("UAReferenceType");
			
			DynamicEObjectImpl referenceTypeSterAppl = (DynamicEObjectImpl) general.getValue(uaStereoType,"referenceType");
			Class referenceType = getStereotypeBaseClass(referenceTypeSterAppl, true);
			
			String referenceTypeNode = getNodeId(referenceType);
			uaReference.setReferenceType(referenceTypeNode);
			
			boolean isHierarchicalReference = (boolean) referenceType.getValue(uaReferenceType, "isHierarchical");
			
			Package sourcePackage = source.getNearestPackage();
			String sourceNs = sourcePackage.getURI();
			if(sourceNs == null)
			{
				sourceNs = "";
			}
			
			Package targetPackage = target.getNearestPackage();
			String targetNs = targetPackage.getURI();
			if(targetNs == null)
			{
				targetNs = "";
			}
			
			general.setValue(uaStereoType,"referenceType_symmetric", referenceType.getValue(uaReferenceType, "symmetric"));
			general.setValue(uaStereoType,"referenceType_browseName", referenceType.getValue(uaReferenceType, "browseName"));
			general.setValue(uaStereoType,"referenceType_isHierarchical", isHierarchicalReference);
			
			if(isHierarchicalReference && sourceNs.equals(targetNs))
			{
				//directionChanged = false;
				if(isForward)
				{
					if(directionChanged || target.getNestedClassifiers().contains(source))
					{
						Element owner = target.getOwner();
						if(owner instanceof Class)
						{
							Class ownerClass = (Class)owner;
							ownerClass.getNestedClassifiers().add(source);
						}
						else
						{
							// owner is package of Model
							Package ownerPackage = (Package) owner;
							target.getNestedClassifiers().remove(source);
							source.setPackage(ownerPackage);
						}
						source.getNestedClassifiers().add(target);
					}
					else
					{
						EList<Classifier> children = source.getNestedClassifiers();
						if(!children.contains(target))
						{
							children.add(target);
						}
					}
				}
				else
				{
					if(directionChanged || source.getNestedClassifiers().contains(target))
					{
						Element owner = source.getOwner();
						if(owner instanceof Class)
						{
							Class ownerClass = (Class)owner;
							ownerClass.getNestedClassifiers().add(target);
						}
						else
						{
							// owner is package of Model
							Package ownerPackage = (Package) owner;
							source.getNestedClassifiers().remove(target);
							target.setPackage(ownerPackage);
						}
						target.getNestedClassifiers().add(source);
					}
					else
					{						
						EList<Classifier> children = target.getNestedClassifiers();
						
						if(!children.contains(source))
						{
							children.add(source);
						}
					}
				}
			}
			
			if(source.isStereotypeApplied(uaReferenceType) && target.isStereotypeApplied(uaReferenceType))
			{
				if(isForward)
				{
					if(this.baseUmlModel.equals(target.getModel()))
					{
						boolean isHierarchicalReferenceType = (boolean) source.getValue(uaReferenceType, "isHierarchical");
						target.setValue(uaReferenceType, "isHierarchical", isHierarchicalReferenceType);
					}
				}
				else
				{
					if(this.baseUmlModel.equals(source.getModel()))
					{
						boolean isHierarchicalReferenceType = (boolean) target.getValue(uaReferenceType, "isHierarchical");
						source.setValue(uaReferenceType, "isHierarchical", isHierarchicalReferenceType);
					}
				}
				
			}
			
		}
		
		if(!this.matching.containsKey(source))
		{
			transformClass((Class) source);
		}
		
		UANode src = (UANode) this.matching.get(source);
		ListOfReferences refList = src.getReferences();
		if(refList == null)
		{
			src.setReferences(new ListOfReferencesImpl());
		}
		boolean contains = refList.getReference().contains(uaReference);
		if(!contains)
		{
			refList.getReference().add(uaReference);
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
		else if(node instanceof AliasTable)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("AliasTable");
		}
		else if(node instanceof NodeIdAlias)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("NodeIdAlias");
		}
		else if(node instanceof StructureTranslationType)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("StructureTranslationType");
		}
		else if(node instanceof TranslationType)
		{
			uaInstance  = nodeSetProfile.getOwnedStereotype("TranslationType");
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
								
				if(!this.matching.containsKey(baseClass) && addIfNotExists &&
					this.baseUmlModel.equals(baseClass.getModel()))
				{
					transformClass(baseClass);
				}

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
		
		if(this.baseUmlModel.equals(umlUaNode.getModel()))
		{				
			if(!this.matching.containsKey(umlUaNode))
			{				
				transformClass(umlUaNode);
			}
			uaStereotype = getMatchingStereotype(this.matching.get(umlUaNode));
		}
		else
		{
			// the other method is faster, therefore it should be used by default
			uaStereotype = getMatchingStereotype(umlUaNode);
		}
		
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
