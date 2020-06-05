//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.20 at 09:01:50 AM CEST 
//


package org.opcfoundation.ua._2008._02.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ChannelSecurityToken complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChannelSecurityToken">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChannelId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="TokenId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="CreatedAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="RevisedLifetime" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChannelSecurityToken", propOrder = {
    "channelId",
    "tokenId",
    "createdAt",
    "revisedLifetime"
})
public class ChannelSecurityToken {

    @XmlElement(name = "ChannelId")
    @XmlSchemaType(name = "unsignedInt")
    protected Long channelId;
    @XmlElement(name = "TokenId")
    @XmlSchemaType(name = "unsignedInt")
    protected Long tokenId;
    @XmlElement(name = "CreatedAt")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdAt;
    @XmlElement(name = "RevisedLifetime")
    @XmlSchemaType(name = "unsignedInt")
    protected Long revisedLifetime;

    /**
     * Gets the value of the channelId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getChannelId() {
        return channelId;
    }

    /**
     * Sets the value of the channelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setChannelId(Long value) {
        this.channelId = value;
    }

    /**
     * Gets the value of the tokenId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTokenId() {
        return tokenId;
    }

    /**
     * Sets the value of the tokenId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTokenId(Long value) {
        this.tokenId = value;
    }

    /**
     * Gets the value of the createdAt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the value of the createdAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedAt(XMLGregorianCalendar value) {
        this.createdAt = value;
    }

    /**
     * Gets the value of the revisedLifetime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRevisedLifetime() {
        return revisedLifetime;
    }

    /**
     * Sets the value of the revisedLifetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRevisedLifetime(Long value) {
        this.revisedLifetime = value;
    }

}