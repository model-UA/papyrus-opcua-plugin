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
 * <p>Java class for RedundancySupport.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RedundancySupport">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None_0"/>
 *     &lt;enumeration value="Cold_1"/>
 *     &lt;enumeration value="Warm_2"/>
 *     &lt;enumeration value="Hot_3"/>
 *     &lt;enumeration value="Transparent_4"/>
 *     &lt;enumeration value="HotAndMirrored_5"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RedundancySupport")
@XmlEnum
public enum RedundancySupport {

    @XmlEnumValue("None_0")
    NONE_0("None_0"),
    @XmlEnumValue("Cold_1")
    COLD_1("Cold_1"),
    @XmlEnumValue("Warm_2")
    WARM_2("Warm_2"),
    @XmlEnumValue("Hot_3")
    HOT_3("Hot_3"),
    @XmlEnumValue("Transparent_4")
    TRANSPARENT_4("Transparent_4"),
    @XmlEnumValue("HotAndMirrored_5")
    HOT_AND_MIRRORED_5("HotAndMirrored_5");
    private final String value;

    RedundancySupport(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RedundancySupport fromValue(String v) {
        for (RedundancySupport c: RedundancySupport.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
