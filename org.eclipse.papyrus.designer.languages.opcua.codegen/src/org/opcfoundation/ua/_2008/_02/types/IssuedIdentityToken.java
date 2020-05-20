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
 * <p>Java class for IssuedIdentityToken complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IssuedIdentityToken">
 *   &lt;complexContent>
 *     &lt;extension base="{http://opcfoundation.org/UA/2008/02/Types.xsd}UserIdentityToken">
 *       &lt;sequence>
 *         &lt;element name="TokenData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="EncryptionAlgorithm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IssuedIdentityToken", propOrder = {
    "tokenData",
    "encryptionAlgorithm"
})
public class IssuedIdentityToken
    extends UserIdentityToken
{

    @XmlElementRef(name = "TokenData", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> tokenData;
    @XmlElementRef(name = "EncryptionAlgorithm", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> encryptionAlgorithm;

    /**
     * Gets the value of the tokenData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getTokenData() {
        return tokenData;
    }

    /**
     * Sets the value of the tokenData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setTokenData(JAXBElement<byte[]> value) {
        this.tokenData = value;
    }

    /**
     * Gets the value of the encryptionAlgorithm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEncryptionAlgorithm() {
        return encryptionAlgorithm;
    }

    /**
     * Sets the value of the encryptionAlgorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEncryptionAlgorithm(JAXBElement<String> value) {
        this.encryptionAlgorithm = value;
    }

}
