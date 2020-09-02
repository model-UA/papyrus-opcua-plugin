/**
 */
package org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.BaseNodeClass;
import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.InformationModel;
import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Method;
import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ObjectType;
import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.ReferenceType;
import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Variable;
import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.VariableType;
import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.View;
import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesFactory;
import org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.basetypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class basetypesFactoryImpl extends EFactoryImpl implements basetypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static basetypesFactory init() {
		try {
			basetypesFactory thebasetypesFactory = (basetypesFactory)EPackage.Registry.INSTANCE.getEFactory(basetypesPackage.eNS_URI);
			if (thebasetypesFactory != null) {
				return thebasetypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new basetypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public basetypesFactoryImpl() {
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
			case basetypesPackage.BASE_NODE_CLASS: return createBaseNodeClass();
			case basetypesPackage.VARIABLE: return createVariable();
			case basetypesPackage.OBJECT_TYPE: return createObjectType();
			case basetypesPackage.OBJECT: return createObject();
			case basetypesPackage.METHOD: return createMethod();
			case basetypesPackage.VIEW: return createView();
			case basetypesPackage.VARIABLE_TYPE: return createVariableType();
			case basetypesPackage.REFERENCE_TYPE: return createReferenceType();
			case basetypesPackage.INFORMATION_MODEL: return createInformationModel();
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
	public BaseNodeClass createBaseNodeClass() {
		BaseNodeClassImpl baseNodeClass = new BaseNodeClassImpl();
		return baseNodeClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Variable createVariable() {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectType createObjectType() {
		ObjectTypeImpl objectType = new ObjectTypeImpl();
		return objectType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.papyrus.opcua.profile.OPCUA_BaseTypes.Object createObject() {
		ObjectImpl object = new ObjectImpl();
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Method createMethod() {
		MethodImpl method = new MethodImpl();
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public View createView() {
		ViewImpl view = new ViewImpl();
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableType createVariableType() {
		VariableTypeImpl variableType = new VariableTypeImpl();
		return variableType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReferenceType createReferenceType() {
		ReferenceTypeImpl referenceType = new ReferenceTypeImpl();
		return referenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InformationModel createInformationModel() {
		InformationModelImpl informationModel = new InformationModelImpl();
		return informationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public basetypesPackage getbasetypesPackage() {
		return (basetypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static basetypesPackage getPackage() {
		return basetypesPackage.eINSTANCE;
	}

} //basetypesFactoryImpl
