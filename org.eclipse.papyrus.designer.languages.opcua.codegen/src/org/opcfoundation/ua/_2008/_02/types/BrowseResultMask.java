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
 * <p>Java class for BrowseResultMask.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BrowseResultMask">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None_0"/>
 *     &lt;enumeration value="ReferenceTypeId_1"/>
 *     &lt;enumeration value="IsForward_2"/>
 *     &lt;enumeration value="NodeClass_4"/>
 *     &lt;enumeration value="BrowseName_8"/>
 *     &lt;enumeration value="DisplayName_16"/>
 *     &lt;enumeration value="TypeDefinition_32"/>
 *     &lt;enumeration value="All_63"/>
 *     &lt;enumeration value="ReferenceTypeInfo_3"/>
 *     &lt;enumeration value="TargetInfo_60"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BrowseResultMask")
@XmlEnum
public enum BrowseResultMask {

    @XmlEnumValue("None_0")
    NONE_0("None_0"),
    @XmlEnumValue("ReferenceTypeId_1")
    REFERENCE_TYPE_ID_1("ReferenceTypeId_1"),
    @XmlEnumValue("IsForward_2")
    IS_FORWARD_2("IsForward_2"),
    @XmlEnumValue("NodeClass_4")
    NODE_CLASS_4("NodeClass_4"),
    @XmlEnumValue("BrowseName_8")
    BROWSE_NAME_8("BrowseName_8"),
    @XmlEnumValue("DisplayName_16")
    DISPLAY_NAME_16("DisplayName_16"),
    @XmlEnumValue("TypeDefinition_32")
    TYPE_DEFINITION_32("TypeDefinition_32"),
    @XmlEnumValue("All_63")
    ALL_63("All_63"),
    @XmlEnumValue("ReferenceTypeInfo_3")
    REFERENCE_TYPE_INFO_3("ReferenceTypeInfo_3"),
    @XmlEnumValue("TargetInfo_60")
    TARGET_INFO_60("TargetInfo_60");
    private final String value;

    BrowseResultMask(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BrowseResultMask fromValue(String v) {
        for (BrowseResultMask c: BrowseResultMask.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}