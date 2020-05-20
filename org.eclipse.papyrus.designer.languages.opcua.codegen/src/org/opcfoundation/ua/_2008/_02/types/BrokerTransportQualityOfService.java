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
 * <p>Java class for BrokerTransportQualityOfService.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BrokerTransportQualityOfService">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NotSpecified_0"/>
 *     &lt;enumeration value="BestEffort_1"/>
 *     &lt;enumeration value="AtLeastOnce_2"/>
 *     &lt;enumeration value="AtMostOnce_3"/>
 *     &lt;enumeration value="ExactlyOnce_4"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BrokerTransportQualityOfService")
@XmlEnum
public enum BrokerTransportQualityOfService {

    @XmlEnumValue("NotSpecified_0")
    NOT_SPECIFIED_0("NotSpecified_0"),
    @XmlEnumValue("BestEffort_1")
    BEST_EFFORT_1("BestEffort_1"),
    @XmlEnumValue("AtLeastOnce_2")
    AT_LEAST_ONCE_2("AtLeastOnce_2"),
    @XmlEnumValue("AtMostOnce_3")
    AT_MOST_ONCE_3("AtMostOnce_3"),
    @XmlEnumValue("ExactlyOnce_4")
    EXACTLY_ONCE_4("ExactlyOnce_4");
    private final String value;

    BrokerTransportQualityOfService(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BrokerTransportQualityOfService fromValue(String v) {
        for (BrokerTransportQualityOfService c: BrokerTransportQualityOfService.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
