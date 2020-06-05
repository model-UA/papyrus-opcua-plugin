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
 * <p>Java class for MonitoringMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MonitoringMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Disabled_0"/>
 *     &lt;enumeration value="Sampling_1"/>
 *     &lt;enumeration value="Reporting_2"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MonitoringMode")
@XmlEnum
public enum MonitoringMode {

    @XmlEnumValue("Disabled_0")
    DISABLED_0("Disabled_0"),
    @XmlEnumValue("Sampling_1")
    SAMPLING_1("Sampling_1"),
    @XmlEnumValue("Reporting_2")
    REPORTING_2("Reporting_2");
    private final String value;

    MonitoringMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MonitoringMode fromValue(String v) {
        for (MonitoringMode c: MonitoringMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}