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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserTokenPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserTokenPolicy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PolicyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TokenType" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}UserTokenType" minOccurs="0"/>
 *         &lt;element name="IssuedTokenType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IssuerEndpointUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecurityPolicyUri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserTokenPolicy", propOrder = {
    "policyId",
    "tokenType",
    "issuedTokenType",
    "issuerEndpointUrl",
    "securityPolicyUri"
})
public class UserTokenPolicy {

    @XmlElementRef(name = "PolicyId", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> policyId;
    @XmlElement(name = "TokenType")
    @XmlSchemaType(name = "string")
    protected UserTokenType tokenType;
    @XmlElementRef(name = "IssuedTokenType", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> issuedTokenType;
    @XmlElementRef(name = "IssuerEndpointUrl", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> issuerEndpointUrl;
    @XmlElementRef(name = "SecurityPolicyUri", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> securityPolicyUri;

    /**
     * Gets the value of the policyId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPolicyId() {
        return policyId;
    }

    /**
     * Sets the value of the policyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPolicyId(JAXBElement<String> value) {
        this.policyId = value;
    }

    /**
     * Gets the value of the tokenType property.
     * 
     * @return
     *     possible object is
     *     {@link UserTokenType }
     *     
     */
    public UserTokenType getTokenType() {
        return tokenType;
    }

    /**
     * Sets the value of the tokenType property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserTokenType }
     *     
     */
    public void setTokenType(UserTokenType value) {
        this.tokenType = value;
    }

    /**
     * Gets the value of the issuedTokenType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIssuedTokenType() {
        return issuedTokenType;
    }

    /**
     * Sets the value of the issuedTokenType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIssuedTokenType(JAXBElement<String> value) {
        this.issuedTokenType = value;
    }

    /**
     * Gets the value of the issuerEndpointUrl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIssuerEndpointUrl() {
        return issuerEndpointUrl;
    }

    /**
     * Sets the value of the issuerEndpointUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIssuerEndpointUrl(JAXBElement<String> value) {
        this.issuerEndpointUrl = value;
    }

    /**
     * Gets the value of the securityPolicyUri property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSecurityPolicyUri() {
        return securityPolicyUri;
    }

    /**
     * Sets the value of the securityPolicyUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSecurityPolicyUri(JAXBElement<String> value) {
        this.securityPolicyUri = value;
    }

}
