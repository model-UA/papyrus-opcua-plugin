//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.20 at 09:01:50 AM CEST 
//


package org.opcfoundation.ua._2008._02.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListOfSessionDiagnosticsDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListOfSessionDiagnosticsDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SessionDiagnosticsDataType" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}SessionDiagnosticsDataType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfSessionDiagnosticsDataType", propOrder = {
    "sessionDiagnosticsDataType"
})
public class ListOfSessionDiagnosticsDataType {

    @XmlElement(name = "SessionDiagnosticsDataType", nillable = true)
    protected List<SessionDiagnosticsDataType> sessionDiagnosticsDataType;

    /**
     * Gets the value of the sessionDiagnosticsDataType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sessionDiagnosticsDataType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSessionDiagnosticsDataType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SessionDiagnosticsDataType }
     * 
     * 
     */
    public List<SessionDiagnosticsDataType> getSessionDiagnosticsDataType() {
        if (sessionDiagnosticsDataType == null) {
            sessionDiagnosticsDataType = new ArrayList<SessionDiagnosticsDataType>();
        }
        return this.sessionDiagnosticsDataType;
    }

}
