//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.20 at 09:01:50 AM CEST 
//


package org.opcfoundation.ua._2008._02.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NodeClass.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NodeClass">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unspecified_0"/>
 *     &lt;enumeration value="Object_1"/>
 *     &lt;enumeration value="Variable_2"/>
 *     &lt;enumeration value="Method_4"/>
 *     &lt;enumeration value="ObjectType_8"/>
 *     &lt;enumeration value="VariableType_16"/>
 *     &lt;enumeration value="ReferenceType_32"/>
 *     &lt;enumeration value="DataType_64"/>
 *     &lt;enumeration value="View_128"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NodeClass")
@XmlEnum
public enum NodeClass {

    @XmlEnumValue("Unspecified_0")
    UNSPECIFIED_0("Unspecified_0"),
    @XmlEnumValue("Object_1")
    OBJECT_1("Object_1"),
    @XmlEnumValue("Variable_2")
    VARIABLE_2("Variable_2"),
    @XmlEnumValue("Method_4")
    METHOD_4("Method_4"),
    @XmlEnumValue("ObjectType_8")
    OBJECT_TYPE_8("ObjectType_8"),
    @XmlEnumValue("VariableType_16")
    VARIABLE_TYPE_16("VariableType_16"),
    @XmlEnumValue("ReferenceType_32")
    REFERENCE_TYPE_32("ReferenceType_32"),
    @XmlEnumValue("DataType_64")
    DATA_TYPE_64("DataType_64"),
    @XmlEnumValue("View_128")
    VIEW_128("View_128");
    private final String value;

    NodeClass(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NodeClass fromValue(String v) {
        for (NodeClass c: NodeClass.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
