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
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for BuildInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BuildInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProductUri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ManufacturerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SoftwareVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BuildNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BuildDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BuildInfo", propOrder = {
    "productUri",
    "manufacturerName",
    "productName",
    "softwareVersion",
    "buildNumber",
    "buildDate"
})
public class BuildInfo {

    @XmlElementRef(name = "ProductUri", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> productUri;
    @XmlElementRef(name = "ManufacturerName", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> manufacturerName;
    @XmlElementRef(name = "ProductName", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> productName;
    @XmlElementRef(name = "SoftwareVersion", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> softwareVersion;
    @XmlElementRef(name = "BuildNumber", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> buildNumber;
    @XmlElement(name = "BuildDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar buildDate;

    /**
     * Gets the value of the productUri property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProductUri() {
        return productUri;
    }

    /**
     * Sets the value of the productUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProductUri(JAXBElement<String> value) {
        this.productUri = value;
    }

    /**
     * Gets the value of the manufacturerName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getManufacturerName() {
        return manufacturerName;
    }

    /**
     * Sets the value of the manufacturerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setManufacturerName(JAXBElement<String> value) {
        this.manufacturerName = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProductName(JAXBElement<String> value) {
        this.productName = value;
    }

    /**
     * Gets the value of the softwareVersion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSoftwareVersion() {
        return softwareVersion;
    }

    /**
     * Sets the value of the softwareVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSoftwareVersion(JAXBElement<String> value) {
        this.softwareVersion = value;
    }

    /**
     * Gets the value of the buildNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBuildNumber() {
        return buildNumber;
    }

    /**
     * Sets the value of the buildNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBuildNumber(JAXBElement<String> value) {
        this.buildNumber = value;
    }

    /**
     * Gets the value of the buildDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBuildDate() {
        return buildDate;
    }

    /**
     * Sets the value of the buildDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBuildDate(XMLGregorianCalendar value) {
        this.buildDate = value;
    }

}
