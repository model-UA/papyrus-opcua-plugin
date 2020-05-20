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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActivateSessionRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivateSessionRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestHeader" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}RequestHeader" minOccurs="0"/>
 *         &lt;element name="ClientSignature" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}SignatureData" minOccurs="0"/>
 *         &lt;element name="ClientSoftwareCertificates" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ListOfSignedSoftwareCertificate" minOccurs="0"/>
 *         &lt;element name="LocaleIds" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ListOfString" minOccurs="0"/>
 *         &lt;element name="UserIdentityToken" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ExtensionObject" minOccurs="0"/>
 *         &lt;element name="UserTokenSignature" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}SignatureData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivateSessionRequest", propOrder = {
    "requestHeader",
    "clientSignature",
    "clientSoftwareCertificates",
    "localeIds",
    "userIdentityToken",
    "userTokenSignature"
})
public class ActivateSessionRequest {

    @XmlElementRef(name = "RequestHeader", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<RequestHeader> requestHeader;
    @XmlElementRef(name = "ClientSignature", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<SignatureData> clientSignature;
    @XmlElementRef(name = "ClientSoftwareCertificates", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ListOfSignedSoftwareCertificate> clientSoftwareCertificates;
    @XmlElementRef(name = "LocaleIds", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ListOfString> localeIds;
    @XmlElementRef(name = "UserIdentityToken", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ExtensionObject> userIdentityToken;
    @XmlElementRef(name = "UserTokenSignature", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<SignatureData> userTokenSignature;

    /**
     * Gets the value of the requestHeader property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RequestHeader }{@code >}
     *     
     */
    public JAXBElement<RequestHeader> getRequestHeader() {
        return requestHeader;
    }

    /**
     * Sets the value of the requestHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RequestHeader }{@code >}
     *     
     */
    public void setRequestHeader(JAXBElement<RequestHeader> value) {
        this.requestHeader = value;
    }

    /**
     * Gets the value of the clientSignature property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SignatureData }{@code >}
     *     
     */
    public JAXBElement<SignatureData> getClientSignature() {
        return clientSignature;
    }

    /**
     * Sets the value of the clientSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SignatureData }{@code >}
     *     
     */
    public void setClientSignature(JAXBElement<SignatureData> value) {
        this.clientSignature = value;
    }

    /**
     * Gets the value of the clientSoftwareCertificates property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ListOfSignedSoftwareCertificate }{@code >}
     *     
     */
    public JAXBElement<ListOfSignedSoftwareCertificate> getClientSoftwareCertificates() {
        return clientSoftwareCertificates;
    }

    /**
     * Sets the value of the clientSoftwareCertificates property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ListOfSignedSoftwareCertificate }{@code >}
     *     
     */
    public void setClientSoftwareCertificates(JAXBElement<ListOfSignedSoftwareCertificate> value) {
        this.clientSoftwareCertificates = value;
    }

    /**
     * Gets the value of the localeIds property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ListOfString }{@code >}
     *     
     */
    public JAXBElement<ListOfString> getLocaleIds() {
        return localeIds;
    }

    /**
     * Sets the value of the localeIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ListOfString }{@code >}
     *     
     */
    public void setLocaleIds(JAXBElement<ListOfString> value) {
        this.localeIds = value;
    }

    /**
     * Gets the value of the userIdentityToken property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ExtensionObject }{@code >}
     *     
     */
    public JAXBElement<ExtensionObject> getUserIdentityToken() {
        return userIdentityToken;
    }

    /**
     * Sets the value of the userIdentityToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ExtensionObject }{@code >}
     *     
     */
    public void setUserIdentityToken(JAXBElement<ExtensionObject> value) {
        this.userIdentityToken = value;
    }

    /**
     * Gets the value of the userTokenSignature property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SignatureData }{@code >}
     *     
     */
    public JAXBElement<SignatureData> getUserTokenSignature() {
        return userTokenSignature;
    }

    /**
     * Sets the value of the userTokenSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SignatureData }{@code >}
     *     
     */
    public void setUserTokenSignature(JAXBElement<SignatureData> value) {
        this.userTokenSignature = value;
    }

}
