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
 * <p>Java class for PubSubGroupDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PubSubGroupDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SecurityMode" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}MessageSecurityMode" minOccurs="0"/>
 *         &lt;element name="SecurityGroupId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecurityKeyServices" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ListOfEndpointDescription" minOccurs="0"/>
 *         &lt;element name="MaxNetworkMessageSize" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="GroupProperties" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ListOfKeyValuePair" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PubSubGroupDataType", propOrder = {
    "name",
    "enabled",
    "securityMode",
    "securityGroupId",
    "securityKeyServices",
    "maxNetworkMessageSize",
    "groupProperties"
})
@XmlSeeAlso({
    WriterGroupDataType.class,
    ReaderGroupDataType.class
})
public class PubSubGroupDataType {

    @XmlElementRef(name = "Name", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> name;
    @XmlElement(name = "Enabled")
    protected Boolean enabled;
    @XmlElement(name = "SecurityMode")
    @XmlSchemaType(name = "string")
    protected MessageSecurityMode securityMode;
    @XmlElementRef(name = "SecurityGroupId", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> securityGroupId;
    @XmlElementRef(name = "SecurityKeyServices", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ListOfEndpointDescription> securityKeyServices;
    @XmlElement(name = "MaxNetworkMessageSize")
    @XmlSchemaType(name = "unsignedInt")
    protected Long maxNetworkMessageSize;
    @XmlElementRef(name = "GroupProperties", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ListOfKeyValuePair> groupProperties;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setName(JAXBElement<String> value) {
        this.name = value;
    }

    /**
     * Gets the value of the enabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnabled(Boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the securityMode property.
     * 
     * @return
     *     possible object is
     *     {@link MessageSecurityMode }
     *     
     */
    public MessageSecurityMode getSecurityMode() {
        return securityMode;
    }

    /**
     * Sets the value of the securityMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageSecurityMode }
     *     
     */
    public void setSecurityMode(MessageSecurityMode value) {
        this.securityMode = value;
    }

    /**
     * Gets the value of the securityGroupId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSecurityGroupId() {
        return securityGroupId;
    }

    /**
     * Sets the value of the securityGroupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSecurityGroupId(JAXBElement<String> value) {
        this.securityGroupId = value;
    }

    /**
     * Gets the value of the securityKeyServices property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ListOfEndpointDescription }{@code >}
     *     
     */
    public JAXBElement<ListOfEndpointDescription> getSecurityKeyServices() {
        return securityKeyServices;
    }

    /**
     * Sets the value of the securityKeyServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ListOfEndpointDescription }{@code >}
     *     
     */
    public void setSecurityKeyServices(JAXBElement<ListOfEndpointDescription> value) {
        this.securityKeyServices = value;
    }

    /**
     * Gets the value of the maxNetworkMessageSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxNetworkMessageSize() {
        return maxNetworkMessageSize;
    }

    /**
     * Sets the value of the maxNetworkMessageSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxNetworkMessageSize(Long value) {
        this.maxNetworkMessageSize = value;
    }

    /**
     * Gets the value of the groupProperties property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ListOfKeyValuePair }{@code >}
     *     
     */
    public JAXBElement<ListOfKeyValuePair> getGroupProperties() {
        return groupProperties;
    }

    /**
     * Sets the value of the groupProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ListOfKeyValuePair }{@code >}
     *     
     */
    public void setGroupProperties(JAXBElement<ListOfKeyValuePair> value) {
        this.groupProperties = value;
    }

}