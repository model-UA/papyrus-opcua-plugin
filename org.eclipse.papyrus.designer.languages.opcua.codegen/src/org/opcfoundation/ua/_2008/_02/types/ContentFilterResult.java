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
 * <p>Java class for ContentFilterResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContentFilterResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ElementResults" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ListOfContentFilterElementResult" minOccurs="0"/>
 *         &lt;element name="ElementDiagnosticInfos" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ListOfDiagnosticInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContentFilterResult", propOrder = {
    "elementResults",
    "elementDiagnosticInfos"
})
public class ContentFilterResult {

    @XmlElementRef(name = "ElementResults", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ListOfContentFilterElementResult> elementResults;
    @XmlElementRef(name = "ElementDiagnosticInfos", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ListOfDiagnosticInfo> elementDiagnosticInfos;

    /**
     * Gets the value of the elementResults property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ListOfContentFilterElementResult }{@code >}
     *     
     */
    public JAXBElement<ListOfContentFilterElementResult> getElementResults() {
        return elementResults;
    }

    /**
     * Sets the value of the elementResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ListOfContentFilterElementResult }{@code >}
     *     
     */
    public void setElementResults(JAXBElement<ListOfContentFilterElementResult> value) {
        this.elementResults = value;
    }

    /**
     * Gets the value of the elementDiagnosticInfos property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ListOfDiagnosticInfo }{@code >}
     *     
     */
    public JAXBElement<ListOfDiagnosticInfo> getElementDiagnosticInfos() {
        return elementDiagnosticInfos;
    }

    /**
     * Sets the value of the elementDiagnosticInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ListOfDiagnosticInfo }{@code >}
     *     
     */
    public void setElementDiagnosticInfos(JAXBElement<ListOfDiagnosticInfo> value) {
        this.elementDiagnosticInfos = value;
    }

}