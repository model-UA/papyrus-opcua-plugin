/**
 */
package OPCUAProfile.impl;

import OPCUAProfile.BaseNodeClass;
import OPCUAProfile.Method;
import OPCUAProfile.OPCUAProfileFactory;
import OPCUAProfile.OPCUAProfilePackage;
import OPCUAProfile.Variable;
import OPCUAProfile.View;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPCUAProfileFactoryImpl extends EFactoryImpl implements OPCUAProfileFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OPCUAProfileFactory init() {
		try {
			OPCUAProfileFactory theOPCUAProfileFactory = (OPCUAProfileFactory)EPackage.Registry.INSTANCE.getEFactory(OPCUAProfilePackage.eNS_URI);
			if (theOPCUAProfileFactory != null) {
				return theOPCUAProfileFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OPCUAProfileFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPCUAProfileFactoryImpl() {
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
			case OPCUAProfilePackage.BASE_NODE_CLASS: return createBaseNodeClass();
			case OPCUAProfilePackage.VARIABLE: return createVariable();
			case OPCUAProfilePackage.OBJECT: return createObject();
			case OPCUAProfilePackage.METHOD: return createMethod();
			case OPCUAProfilePackage.VIEW: return createView();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseNodeClass createBaseNodeClass() {
		BaseNodeClassImpl baseNodeClass = new BaseNodeClassImpl();
		return baseNodeClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createVariable() {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPCUAProfile.Object createObject() {
		ObjectImpl object = new ObjectImpl();
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method createMethod() {
		MethodImpl method = new MethodImpl();
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public View createView() {
		ViewImpl view = new ViewImpl();
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPCUAProfilePackage getOPCUAProfilePackage() {
		return (OPCUAProfilePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OPCUAProfilePackage getPackage() {
		return OPCUAProfilePackage.eINSTANCE;
	}

} //OPCUAProfileFactoryImpl
