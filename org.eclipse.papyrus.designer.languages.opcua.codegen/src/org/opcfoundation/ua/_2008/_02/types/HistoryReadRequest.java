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
 * <p>Java class for HistoryReadRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HistoryReadRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestHeader" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}RequestHeader" minOccurs="0"/>
 *         &lt;element name="HistoryReadDetails" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ExtensionObject" minOccurs="0"/>
 *         &lt;element name="TimestampsToReturn" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}TimestampsToReturn" minOccurs="0"/>
 *         &lt;element name="ReleaseContinuationPoints" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="NodesToRead" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ListOfHistoryReadValueId" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HistoryReadRequest", propOrder = {
    "requestHeader",
    "historyReadDetails",
    "timestampsToReturn",
    "releaseContinuationPoints",
    "nodesToRead"
})
public class HistoryReadRequest {

    @XmlElementRef(name = "RequestHeader", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<RequestHeader> requestHeader;
    @XmlElementRef(name = "HistoryReadDetails", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ExtensionObject> historyReadDetails;
    @XmlElement(name = "TimestampsToReturn")
    @XmlSchemaType(name = "string")
    protected TimestampsToReturn timestampsToReturn;
    @XmlElement(name = "ReleaseContinuationPoints")
    protected Boolean releaseContinuationPoints;
    @XmlElementRef(name = "NodesToRead", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ListOfHistoryReadValueId> nodesToRead;

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
     * Gets the value of the historyReadDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ExtensionObject }{@code >}
     *     
     */
    public JAXBElement<ExtensionObject> getHistoryReadDetails() {
        return historyReadDetails;
    }

    /**
     * Sets the value of the historyReadDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ExtensionObject }{@code >}
     *     
     */
    public void setHistoryReadDetails(JAXBElement<ExtensionObject> value) {
        this.historyReadDetails = value;
    }

    /**
     * Gets the value of the timestampsToReturn property.
     * 
     * @return
     *     possible object is
     *     {@link TimestampsToReturn }
     *     
     */
    public TimestampsToReturn getTimestampsToReturn() {
        return timestampsToReturn;
    }

    /**
     * Sets the value of the timestampsToReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimestampsToReturn }
     *     
     */
    public void setTimestampsToReturn(TimestampsToReturn value) {
        this.timestampsToReturn = value;
    }

    /**
     * Gets the value of the releaseContinuationPoints property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReleaseContinuationPoints() {
        return releaseContinuationPoints;
    }

    /**
     * Sets the value of the releaseContinuationPoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReleaseContinuationPoints(Boolean value) {
        this.releaseContinuationPoints = value;
    }

    /**
     * Gets the value of the nodesToRead property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ListOfHistoryReadValueId }{@code >}
     *     
     */
    public JAXBElement<ListOfHistoryReadValueId> getNodesToRead() {
        return nodesToRead;
    }

    /**
     * Sets the value of the nodesToRead property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ListOfHistoryReadValueId }{@code >}
     *     
     */
    public void setNodesToRead(JAXBElement<ListOfHistoryReadValueId> value) {
        this.nodesToRead = value;
    }

}
