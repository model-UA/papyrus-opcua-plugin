//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.20 at 09:01:50 AM CEST 
//


package org.opcfoundation.ua._2008._02.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MethodNode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MethodNode">
 *   &lt;complexContent>
 *     &lt;extension base="{http://opcfoundation.org/UA/2008/02/Types.xsd}InstanceNode">
 *       &lt;sequence>
 *         &lt;element name="Executable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="UserExecutable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MethodNode", propOrder = {
    "executable",
    "userExecutable"
})
public class MethodNode
    extends InstanceNode
{

    @XmlElement(name = "Executable")
    protected Boolean executable;
    @XmlElement(name = "UserExecutable")
    protected Boolean userExecutable;

    /**
     * Gets the value of the executable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExecutable() {
        return executable;
    }

    /**
     * Sets the value of the executable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExecutable(Boolean value) {
        this.executable = value;
    }

    /**
     * Gets the value of the userExecutable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUserExecutable() {
        return userExecutable;
    }

    /**
     * Sets the value of the userExecutable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUserExecutable(Boolean value) {
        this.userExecutable = value;
    }

}
