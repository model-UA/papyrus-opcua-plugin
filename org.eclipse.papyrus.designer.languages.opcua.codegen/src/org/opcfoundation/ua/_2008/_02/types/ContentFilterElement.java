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
 * <p>Java class for ContentFilterElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContentFilterElement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FilterOperator" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}FilterOperator" minOccurs="0"/>
 *         &lt;element name="FilterOperands" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ListOfExtensionObject" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContentFilterElement", propOrder = {
    "filterOperator",
    "filterOperands"
})
public class ContentFilterElement {

    @XmlElement(name = "FilterOperator")
    @XmlSchemaType(name = "string")
    protected FilterOperator filterOperator;
    @XmlElementRef(name = "FilterOperands", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ListOfExtensionObject> filterOperands;

    /**
     * Gets the value of the filterOperator property.
     * 
     * @return
     *     possible object is
     *     {@link FilterOperator }
     *     
     */
    public FilterOperator getFilterOperator() {
        return filterOperator;
    }

    /**
     * Sets the value of the filterOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterOperator }
     *     
     */
    public void setFilterOperator(FilterOperator value) {
        this.filterOperator = value;
    }

    /**
     * Gets the value of the filterOperands property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ListOfExtensionObject }{@code >}
     *     
     */
    public JAXBElement<ListOfExtensionObject> getFilterOperands() {
        return filterOperands;
    }

    /**
     * Sets the value of the filterOperands property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ListOfExtensionObject }{@code >}
     *     
     */
    public void setFilterOperands(JAXBElement<ListOfExtensionObject> value) {
        this.filterOperands = value;
    }

}
