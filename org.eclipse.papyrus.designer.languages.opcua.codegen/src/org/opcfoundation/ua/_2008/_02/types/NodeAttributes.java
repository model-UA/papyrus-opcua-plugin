//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.20 at 09:01:50 AM CEST 
//


package org.opcfoundation.ua._2008._02.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NodeAttributes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NodeAttributes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SpecifiedAttributes" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="DisplayName" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}LocalizedText" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}LocalizedText" minOccurs="0"/>
 *         &lt;element name="WriteMask" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="UserWriteMask" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NodeAttributes", propOrder = {
    "specifiedAttributes",
    "displayName",
    "description",
    "writeMask",
    "userWriteMask"
})
@XmlSeeAlso({
    VariableTypeAttributes.class,
    ReferenceTypeAttributes.class,
    ObjectTypeAttributes.class,
    MethodAttributes.class,
    DataTypeAttributes.class,
    GenericAttributes.class,
    ViewAttributes.class,
    VariableAttributes.class,
    ObjectAttributes.class
})
public class NodeAttributes {

    @XmlElement(name = "SpecifiedAttributes")
    @XmlSchemaType(name = "unsignedInt")
    protected Long specifiedAttributes;
    @XmlElementRef(name = "DisplayName", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<LocalizedText> displayName;
    @XmlElementRef(name = "Description", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<LocalizedText> description;
    @XmlElement(name = "WriteMask")
    @XmlSchemaType(name = "unsignedInt")
    protected Long writeMask;
    @XmlElement(name = "UserWriteMask")
    @XmlSchemaType(name = "unsignedInt")
    protected Long userWriteMask;

    /**
     * Gets the value of the specifiedAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSpecifiedAttributes() {
        return specifiedAttributes;
    }

    /**
     * Sets the value of the specifiedAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSpecifiedAttributes(Long value) {
        this.specifiedAttributes = value;
    }

    /**
     * Gets the value of the displayName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LocalizedText }{@code >}
     *     
     */
    public JAXBElement<LocalizedText> getDisplayName() {
        return displayName;
    }

    /**
     * Sets the value of the displayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LocalizedText }{@code >}
     *     
     */
    public void setDisplayName(JAXBElement<LocalizedText> value) {
        this.displayName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LocalizedText }{@code >}
     *     
     */
    public JAXBElement<LocalizedText> getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LocalizedText }{@code >}
     *     
     */
    public void setDescription(JAXBElement<LocalizedText> value) {
        this.description = value;
    }

    /**
     * Gets the value of the writeMask property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getWriteMask() {
        return writeMask;
    }

    /**
     * Sets the value of the writeMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setWriteMask(Long value) {
        this.writeMask = value;
    }

    /**
     * Gets the value of the userWriteMask property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUserWriteMask() {
        return userWriteMask;
    }

    /**
     * Sets the value of the userWriteMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUserWriteMask(Long value) {
        this.userWriteMask = value;
    }

}
