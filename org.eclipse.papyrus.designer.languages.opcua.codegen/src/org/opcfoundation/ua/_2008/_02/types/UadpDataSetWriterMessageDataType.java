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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UadpDataSetWriterMessageDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UadpDataSetWriterMessageDataType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://opcfoundation.org/UA/2008/02/Types.xsd}DataSetWriterMessageDataType">
 *       &lt;sequence>
 *         &lt;element name="DataSetMessageContentMask" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}UadpDataSetMessageContentMask" minOccurs="0"/>
 *         &lt;element name="ConfiguredSize" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="NetworkMessageNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="DataSetOffset" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UadpDataSetWriterMessageDataType", propOrder = {
    "dataSetMessageContentMask",
    "configuredSize",
    "networkMessageNumber",
    "dataSetOffset"
})
public class UadpDataSetWriterMessageDataType
    extends DataSetWriterMessageDataType
{

    @XmlElement(name = "DataSetMessageContentMask")
    @XmlSchemaType(name = "unsignedInt")
    protected Long dataSetMessageContentMask;
    @XmlElement(name = "ConfiguredSize")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer configuredSize;
    @XmlElement(name = "NetworkMessageNumber")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer networkMessageNumber;
    @XmlElement(name = "DataSetOffset")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer dataSetOffset;

    /**
     * Gets the value of the dataSetMessageContentMask property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDataSetMessageContentMask() {
        return dataSetMessageContentMask;
    }

    /**
     * Sets the value of the dataSetMessageContentMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDataSetMessageContentMask(Long value) {
        this.dataSetMessageContentMask = value;
    }

    /**
     * Gets the value of the configuredSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getConfiguredSize() {
        return configuredSize;
    }

    /**
     * Sets the value of the configuredSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setConfiguredSize(Integer value) {
        this.configuredSize = value;
    }

    /**
     * Gets the value of the networkMessageNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNetworkMessageNumber() {
        return networkMessageNumber;
    }

    /**
     * Sets the value of the networkMessageNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNetworkMessageNumber(Integer value) {
        this.networkMessageNumber = value;
    }

    /**
     * Gets the value of the dataSetOffset property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDataSetOffset() {
        return dataSetOffset;
    }

    /**
     * Sets the value of the dataSetOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDataSetOffset(Integer value) {
        this.dataSetOffset = value;
    }

}
