/**
 */
package OPCUAProfile.DataTypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Node Class</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see OPCUAProfile.DataTypes.DataTypesPackage#get_NodeClass()
 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName=' NodeClass'"
 * @generated
 */
public enum _NodeClass implements Enumerator {
	/**
	 * The '<em><b>Unspecified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED_VALUE
	 * @generated
	 * @ordered
	 */
	UNSPECIFIED(0, "Unspecified", "Unspecified"),

	/**
	 * The '<em><b>Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	OBJECT(1, "Object", "Object"),

	/**
	 * The '<em><b>Variable</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VARIABLE_VALUE
	 * @generated
	 * @ordered
	 */
	VARIABLE(2, "Variable", "Variable"),

	/**
	 * The '<em><b>Method</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #METHOD_VALUE
	 * @generated
	 * @ordered
	 */
	METHOD(4, "Method", "Method"),

	/**
	 * The '<em><b>Object Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OBJECT_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	OBJECT_TYPE(8, "ObjectType", "ObjectType"),

	/**
	 * The '<em><b>Variable Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VARIABLE_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	VARIABLE_TYPE(16, "VariableType", "VariableType"),

	/**
	 * The '<em><b>Reference Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFERENCE_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	REFERENCE_TYPE(32, "ReferenceType", "ReferenceType"),

	/**
	 * The '<em><b>Data Type</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATA_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	DATA_TYPE(64, "DataType", "DataType"),

	/**
	 * The '<em><b>View</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VIEW_VALUE
	 * @generated
	 * @ordered
	 */
	VIEW(128, "View", "View");

	/**
	 * The '<em><b>Unspecified</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED
	 * @model name="Unspecified"
	 * @generated
	 * @ordered
	 */
	public static final int UNSPECIFIED_VALUE = 0;

	/**
	 * The '<em><b>Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OBJECT
	 * @model name="Object"
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_VALUE = 1;

	/**
	 * The '<em><b>Variable</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VARIABLE
	 * @model name="Variable"
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_VALUE = 2;

	/**
	 * The '<em><b>Method</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #METHOD
	 * @model name="Method"
	 * @generated
	 * @ordered
	 */
	public static final int METHOD_VALUE = 4;

	/**
	 * The '<em><b>Object Type</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OBJECT_TYPE
	 * @model name="ObjectType"
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_TYPE_VALUE = 8;

	/**
	 * The '<em><b>Variable Type</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VARIABLE_TYPE
	 * @model name="VariableType"
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_TYPE_VALUE = 16;

	/**
	 * The '<em><b>Reference Type</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFERENCE_TYPE
	 * @model name="ReferenceType"
	 * @generated
	 * @ordered
	 */
	public static final int REFERENCE_TYPE_VALUE = 32;

	/**
	 * The '<em><b>Data Type</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATA_TYPE
	 * @model name="DataType"
	 * @generated
	 * @ordered
	 */
	public static final int DATA_TYPE_VALUE = 64;

	/**
	 * The '<em><b>View</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VIEW
	 * @model name="View"
	 * @generated
	 * @ordered
	 */
	public static final int VIEW_VALUE = 128;

	/**
	 * An array of all the '<em><b>Node Class</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final _NodeClass[] VALUES_ARRAY =
		new _NodeClass[] {
			UNSPECIFIED,
			OBJECT,
			VARIABLE,
			METHOD,
			OBJECT_TYPE,
			VARIABLE_TYPE,
			REFERENCE_TYPE,
			DATA_TYPE,
			VIEW,
		};

	/**
	 * A public read-only list of all the '<em><b>Node Class</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<_NodeClass> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Node Class</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static _NodeClass get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			_NodeClass result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Node Class</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static _NodeClass getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			_NodeClass result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Node Class</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static _NodeClass get(int value) {
		switch (value) {
			case UNSPECIFIED_VALUE: return UNSPECIFIED;
			case OBJECT_VALUE: return OBJECT;
			case VARIABLE_VALUE: return VARIABLE;
			case METHOD_VALUE: return METHOD;
			case OBJECT_TYPE_VALUE: return OBJECT_TYPE;
			case VARIABLE_TYPE_VALUE: return VARIABLE_TYPE;
			case REFERENCE_TYPE_VALUE: return REFERENCE_TYPE;
			case DATA_TYPE_VALUE: return DATA_TYPE;
			case VIEW_VALUE: return VIEW;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private _NodeClass(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //_NodeClass
