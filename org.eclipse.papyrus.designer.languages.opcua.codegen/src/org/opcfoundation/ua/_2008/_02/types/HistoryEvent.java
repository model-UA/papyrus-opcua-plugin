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
 * <p>Java class for HistoryEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HistoryEvent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Events" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ListOfHistoryEventFieldList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HistoryEvent", propOrder = {
    "events"
})
public class HistoryEvent {

    @XmlElementRef(name = "Events", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ListOfHistoryEventFieldList> events;

    /**
     * Gets the value of the events property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ListOfHistoryEventFieldList }{@code >}
     *     
     */
    public JAXBElement<ListOfHistoryEventFieldList> getEvents() {
        return events;
    }

    /**
     * Sets the value of the events property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ListOfHistoryEventFieldList }{@code >}
     *     
     */
    public void setEvents(JAXBElement<ListOfHistoryEventFieldList> value) {
        this.events = value;
    }

}
