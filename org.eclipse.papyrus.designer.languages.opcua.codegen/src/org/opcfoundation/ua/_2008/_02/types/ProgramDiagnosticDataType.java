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
 * <p>Java class for ProgramDiagnosticDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProgramDiagnosticDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CreateSessionId" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}NodeId" minOccurs="0"/>
 *         &lt;element name="CreateClientName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvocationCreationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LastTransitionTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LastMethodCall" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastMethodSessionId" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}NodeId" minOccurs="0"/>
 *         &lt;element name="LastMethodInputArguments" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ListOfArgument" minOccurs="0"/>
 *         &lt;element name="LastMethodOutputArguments" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ListOfArgument" minOccurs="0"/>
 *         &lt;element name="LastMethodCallTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LastMethodReturnStatus" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}StatusResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProgramDiagnosticDataType", propOrder = {
    "createSessionId",
    "createClientName",
    "invocationCreationTime",
    "lastTransitionTime",
    "lastMethodCall",
    "lastMethodSessionId",
    "lastMethodInputArguments",
    "lastMethodOutputArguments",
    "lastMethodCallTime",
    "lastMethodReturnStatus"
})
public class ProgramDiagnosticDataType {

    @XmlElementRef(name = "CreateSessionId", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<NodeId> createSessionId;
    @XmlElementRef(name = "CreateClientName", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> createClientName;
    @XmlElement(name = "InvocationCreationTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar invocationCreationTime;
    @XmlElement(name = "LastTransitionTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastTransitionTime;
    @XmlElementRef(name = "LastMethodCall", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lastMethodCall;
    @XmlElementRef(name = "LastMethodSessionId", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<NodeId> lastMethodSessionId;
    @XmlElementRef(name = "LastMethodInputArguments", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ListOfArgument> lastMethodInputArguments;
    @XmlElementRef(name = "LastMethodOutputArguments", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ListOfArgument> lastMethodOutputArguments;
    @XmlElement(name = "LastMethodCallTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastMethodCallTime;
    @XmlElementRef(name = "LastMethodReturnStatus", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<StatusResult> lastMethodReturnStatus;

    /**
     * Gets the value of the createSessionId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link NodeId }{@code >}
     *     
     */
    public JAXBElement<NodeId> getCreateSessionId() {
        return createSessionId;
    }

    /**
     * Sets the value of the createSessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link NodeId }{@code >}
     *     
     */
    public void setCreateSessionId(JAXBElement<NodeId> value) {
        this.createSessionId = value;
    }

    /**
     * Gets the value of the createClientName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreateClientName() {
        return createClientName;
    }

    /**
     * Sets the value of the createClientName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreateClientName(JAXBElement<String> value) {
        this.createClientName = value;
    }

    /**
     * Gets the value of the invocationCreationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInvocationCreationTime() {
        return invocationCreationTime;
    }

    /**
     * Sets the value of the invocationCreationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInvocationCreationTime(XMLGregorianCalendar value) {
        this.invocationCreationTime = value;
    }

    /**
     * Gets the value of the lastTransitionTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastTransitionTime() {
        return lastTransitionTime;
    }

    /**
     * Sets the value of the lastTransitionTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastTransitionTime(XMLGregorianCalendar value) {
        this.lastTransitionTime = value;
    }

    /**
     * Gets the value of the lastMethodCall property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLastMethodCall() {
        return lastMethodCall;
    }

    /**
     * Sets the value of the lastMethodCall property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLastMethodCall(JAXBElement<String> value) {
        this.lastMethodCall = value;
    }

    /**
     * Gets the value of the lastMethodSessionId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link NodeId }{@code >}
     *     
     */
    public JAXBElement<NodeId> getLastMethodSessionId() {
        return lastMethodSessionId;
    }

    /**
     * Sets the value of the lastMethodSessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link NodeId }{@code >}
     *     
     */
    public void setLastMethodSessionId(JAXBElement<NodeId> value) {
        this.lastMethodSessionId = value;
    }

    /**
     * Gets the value of the lastMethodInputArguments property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ListOfArgument }{@code >}
     *     
     */
    public JAXBElement<ListOfArgument> getLastMethodInputArguments() {
        return lastMethodInputArguments;
    }

    /**
     * Sets the value of the lastMethodInputArguments property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ListOfArgument }{@code >}
     *     
     */
    public void setLastMethodInputArguments(JAXBElement<ListOfArgument> value) {
        this.lastMethodInputArguments = value;
    }

    /**
     * Gets the value of the lastMethodOutputArguments property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ListOfArgument }{@code >}
     *     
     */
    public JAXBElement<ListOfArgument> getLastMethodOutputArguments() {
        return lastMethodOutputArguments;
    }

    /**
     * Sets the value of the lastMethodOutputArguments property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ListOfArgument }{@code >}
     *     
     */
    public void setLastMethodOutputArguments(JAXBElement<ListOfArgument> value) {
        this.lastMethodOutputArguments = value;
    }

    /**
     * Gets the value of the lastMethodCallTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastMethodCallTime() {
        return lastMethodCallTime;
    }

    /**
     * Sets the value of the lastMethodCallTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastMethodCallTime(XMLGregorianCalendar value) {
        this.lastMethodCallTime = value;
    }

    /**
     * Gets the value of the lastMethodReturnStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StatusResult }{@code >}
     *     
     */
    public JAXBElement<StatusResult> getLastMethodReturnStatus() {
        return lastMethodReturnStatus;
    }

    /**
     * Sets the value of the lastMethodReturnStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StatusResult }{@code >}
     *     
     */
    public void setLastMethodReturnStatus(JAXBElement<StatusResult> value) {
        this.lastMethodReturnStatus = value;
    }

}
