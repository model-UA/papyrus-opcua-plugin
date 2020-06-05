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
 * <p>Java class for EventFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EventFilter">
 *   &lt;complexContent>
 *     &lt;extension base="{http://opcfoundation.org/UA/2008/02/Types.xsd}MonitoringFilter">
 *       &lt;sequence>
 *         &lt;element name="SelectClauses" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ListOfSimpleAttributeOperand" minOccurs="0"/>
 *         &lt;element name="WhereClause" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ContentFilter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventFilter", propOrder = {
    "selectClauses",
    "whereClause"
})
public class EventFilter
    extends MonitoringFilter
{

    @XmlElementRef(name = "SelectClauses", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ListOfSimpleAttributeOperand> selectClauses;
    @XmlElementRef(name = "WhereClause", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ContentFilter> whereClause;

    /**
     * Gets the value of the selectClauses property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ListOfSimpleAttributeOperand }{@code >}
     *     
     */
    public JAXBElement<ListOfSimpleAttributeOperand> getSelectClauses() {
        return selectClauses;
    }

    /**
     * Sets the value of the selectClauses property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ListOfSimpleAttributeOperand }{@code >}
     *     
     */
    public void setSelectClauses(JAXBElement<ListOfSimpleAttributeOperand> value) {
        this.selectClauses = value;
    }

    /**
     * Gets the value of the whereClause property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ContentFilter }{@code >}
     *     
     */
    public JAXBElement<ContentFilter> getWhereClause() {
        return whereClause;
    }

    /**
     * Sets the value of the whereClause property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ContentFilter }{@code >}
     *     
     */
    public void setWhereClause(JAXBElement<ContentFilter> value) {
        this.whereClause = value;
    }

}
