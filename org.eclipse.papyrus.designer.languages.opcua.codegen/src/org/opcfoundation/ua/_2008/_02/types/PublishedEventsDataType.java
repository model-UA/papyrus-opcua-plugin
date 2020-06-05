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
 * <p>Java class for PublishedEventsDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublishedEventsDataType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://opcfoundation.org/UA/2008/02/Types.xsd}PublishedDataSetSourceDataType">
 *       &lt;sequence>
 *         &lt;element name="EventNotifier" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}NodeId" minOccurs="0"/>
 *         &lt;element name="SelectedFields" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ListOfSimpleAttributeOperand" minOccurs="0"/>
 *         &lt;element name="Filter" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ContentFilter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublishedEventsDataType", propOrder = {
    "eventNotifier",
    "selectedFields",
    "filter"
})
public class PublishedEventsDataType
    extends PublishedDataSetSourceDataType
{

    @XmlElementRef(name = "EventNotifier", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<NodeId> eventNotifier;
    @XmlElementRef(name = "SelectedFields", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ListOfSimpleAttributeOperand> selectedFields;
    @XmlElementRef(name = "Filter", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ContentFilter> filter;

    /**
     * Gets the value of the eventNotifier property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link NodeId }{@code >}
     *     
     */
    public JAXBElement<NodeId> getEventNotifier() {
        return eventNotifier;
    }

    /**
     * Sets the value of the eventNotifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link NodeId }{@code >}
     *     
     */
    public void setEventNotifier(JAXBElement<NodeId> value) {
        this.eventNotifier = value;
    }

    /**
     * Gets the value of the selectedFields property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ListOfSimpleAttributeOperand }{@code >}
     *     
     */
    public JAXBElement<ListOfSimpleAttributeOperand> getSelectedFields() {
        return selectedFields;
    }

    /**
     * Sets the value of the selectedFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ListOfSimpleAttributeOperand }{@code >}
     *     
     */
    public void setSelectedFields(JAXBElement<ListOfSimpleAttributeOperand> value) {
        this.selectedFields = value;
    }

    /**
     * Gets the value of the filter property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ContentFilter }{@code >}
     *     
     */
    public JAXBElement<ContentFilter> getFilter() {
        return filter;
    }

    /**
     * Sets the value of the filter property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ContentFilter }{@code >}
     *     
     */
    public void setFilter(JAXBElement<ContentFilter> value) {
        this.filter = value;
    }

}
