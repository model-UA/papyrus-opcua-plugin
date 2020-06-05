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
 * <p>Java class for BrowseDescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BrowseDescription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NodeId" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}NodeId" minOccurs="0"/>
 *         &lt;element name="BrowseDirection" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}BrowseDirection" minOccurs="0"/>
 *         &lt;element name="ReferenceTypeId" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}NodeId" minOccurs="0"/>
 *         &lt;element name="IncludeSubtypes" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="NodeClassMask" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="ResultMask" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BrowseDescription", propOrder = {
    "nodeId",
    "browseDirection",
    "referenceTypeId",
    "includeSubtypes",
    "nodeClassMask",
    "resultMask"
})
public class BrowseDescription {

    @XmlElementRef(name = "NodeId", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<NodeId> nodeId;
    @XmlElement(name = "BrowseDirection")
    @XmlSchemaType(name = "string")
    protected BrowseDirection browseDirection;
    @XmlElementRef(name = "ReferenceTypeId", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<NodeId> referenceTypeId;
    @XmlElement(name = "IncludeSubtypes")
    protected Boolean includeSubtypes;
    @XmlElement(name = "NodeClassMask")
    @XmlSchemaType(name = "unsignedInt")
    protected Long nodeClassMask;
    @XmlElement(name = "ResultMask")
    @XmlSchemaType(name = "unsignedInt")
    protected Long resultMask;

    /**
     * Gets the value of the nodeId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link NodeId }{@code >}
     *     
     */
    public JAXBElement<NodeId> getNodeId() {
        return nodeId;
    }

    /**
     * Sets the value of the nodeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link NodeId }{@code >}
     *     
     */
    public void setNodeId(JAXBElement<NodeId> value) {
        this.nodeId = value;
    }

    /**
     * Gets the value of the browseDirection property.
     * 
     * @return
     *     possible object is
     *     {@link BrowseDirection }
     *     
     */
    public BrowseDirection getBrowseDirection() {
        return browseDirection;
    }

    /**
     * Sets the value of the browseDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link BrowseDirection }
     *     
     */
    public void setBrowseDirection(BrowseDirection value) {
        this.browseDirection = value;
    }

    /**
     * Gets the value of the referenceTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link NodeId }{@code >}
     *     
     */
    public JAXBElement<NodeId> getReferenceTypeId() {
        return referenceTypeId;
    }

    /**
     * Sets the value of the referenceTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link NodeId }{@code >}
     *     
     */
    public void setReferenceTypeId(JAXBElement<NodeId> value) {
        this.referenceTypeId = value;
    }

    /**
     * Gets the value of the includeSubtypes property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeSubtypes() {
        return includeSubtypes;
    }

    /**
     * Sets the value of the includeSubtypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeSubtypes(Boolean value) {
        this.includeSubtypes = value;
    }

    /**
     * Gets the value of the nodeClassMask property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNodeClassMask() {
        return nodeClassMask;
    }

    /**
     * Sets the value of the nodeClassMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNodeClassMask(Long value) {
        this.nodeClassMask = value;
    }

    /**
     * Gets the value of the resultMask property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getResultMask() {
        return resultMask;
    }

    /**
     * Sets the value of the resultMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setResultMask(Long value) {
        this.resultMask = value;
    }

}