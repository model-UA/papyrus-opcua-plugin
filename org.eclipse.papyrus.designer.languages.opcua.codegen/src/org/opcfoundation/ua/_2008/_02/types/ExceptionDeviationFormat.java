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
 * <p>Java class for ExceptionDeviationFormat.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExceptionDeviationFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AbsoluteValue_0"/>
 *     &lt;enumeration value="PercentOfValue_1"/>
 *     &lt;enumeration value="PercentOfRange_2"/>
 *     &lt;enumeration value="PercentOfEURange_3"/>
 *     &lt;enumeration value="Unknown_4"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExceptionDeviationFormat")
@XmlEnum
public enum ExceptionDeviationFormat {

    @XmlEnumValue("AbsoluteValue_0")
    ABSOLUTE_VALUE_0("AbsoluteValue_0"),
    @XmlEnumValue("PercentOfValue_1")
    PERCENT_OF_VALUE_1("PercentOfValue_1"),
    @XmlEnumValue("PercentOfRange_2")
    PERCENT_OF_RANGE_2("PercentOfRange_2"),
    @XmlEnumValue("PercentOfEURange_3")
    PERCENT_OF_EU_RANGE_3("PercentOfEURange_3"),
    @XmlEnumValue("Unknown_4")
    UNKNOWN_4("Unknown_4");
    private final String value;

    ExceptionDeviationFormat(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExceptionDeviationFormat fromValue(String v) {
        for (ExceptionDeviationFormat c: ExceptionDeviationFormat.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
