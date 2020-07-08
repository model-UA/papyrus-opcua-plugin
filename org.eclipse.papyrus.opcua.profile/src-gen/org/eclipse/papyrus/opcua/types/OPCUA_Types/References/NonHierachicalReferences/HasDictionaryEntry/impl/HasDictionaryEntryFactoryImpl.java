/**
 */
package org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.HasDictionaryEntry.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.opcua.types.OPCUA_Types.References.NonHierachicalReferences.HasDictionaryEntry.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HasDictionaryEntryFactoryImpl extends EFactoryImpl implements HasDictionaryEntryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HasDictionaryEntryFactory init() {
		try {
			HasDictionaryEntryFactory theHasDictionaryEntryFactory = (HasDictionaryEntryFactory)EPackage.Registry.INSTANCE.getEFactory(HasDictionaryEntryPackage.eNS_URI);
			if (theHasDictionaryEntryFactory != null) {
				return theHasDictionaryEntryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new HasDictionaryEntryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasDictionaryEntryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case HasDictionaryEntryPackage.INVERSE_NAME: return createInverseName();
			case HasDictionaryEntryPackage.BROWSE_NAME: return createBrowseName();
			case HasDictionaryEntryPackage.DISPLAY_NAME: return createDisplayName();
			case HasDictionaryEntryPackage.NODE_ID: return createNodeId();
			case HasDictionaryEntryPackage.HAS_DICTIONARY_ENTRY: return createHasDictionaryEntry();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InverseName createInverseName() {
		InverseNameImpl inverseName = new InverseNameImpl();
		return inverseName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BrowseName createBrowseName() {
		BrowseNameImpl browseName = new BrowseNameImpl();
		return browseName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DisplayName createDisplayName() {
		DisplayNameImpl displayName = new DisplayNameImpl();
		return displayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NodeId createNodeId() {
		NodeIdImpl nodeId = new NodeIdImpl();
		return nodeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HasDictionaryEntry createHasDictionaryEntry() {
		HasDictionaryEntryImpl hasDictionaryEntry = new HasDictionaryEntryImpl();
		return hasDictionaryEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HasDictionaryEntryPackage getHasDictionaryEntryPackage() {
		return (HasDictionaryEntryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static HasDictionaryEntryPackage getPackage() {
		return HasDictionaryEntryPackage.eINSTANCE;
	}

} //HasDictionaryEntryFactoryImpl
