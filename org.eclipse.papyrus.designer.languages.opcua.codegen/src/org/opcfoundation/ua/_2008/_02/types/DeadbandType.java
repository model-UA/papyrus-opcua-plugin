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
 * <p>Java class for DeadbandType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DeadbandType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None_0"/>
 *     &lt;enumeration value="Absolute_1"/>
 *     &lt;enumeration value="Percent_2"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeadbandType")
@XmlEnum
public enum DeadbandType {

    @XmlEnumValue("None_0")
    NONE_0("None_0"),
    @XmlEnumValue("Absolute_1")
    ABSOLUTE_1("Absolute_1"),
    @XmlEnumValue("Percent_2")
    PERCENT_2("Percent_2");
    private final String value;

    DeadbandType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DeadbandType fromValue(String v) {
        for (DeadbandType c: DeadbandType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}