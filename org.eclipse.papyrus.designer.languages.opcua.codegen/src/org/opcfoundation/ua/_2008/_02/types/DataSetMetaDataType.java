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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataSetMetaDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataSetMetaDataType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://opcfoundation.org/UA/2008/02/Types.xsd}DataTypeSchemaHeader">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}LocalizedText" minOccurs="0"/>
 *         &lt;element name="Fields" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ListOfFieldMetaData" minOccurs="0"/>
 *         &lt;element name="DataSetClassId" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}Guid" minOccurs="0"/>
 *         &lt;element name="ConfigurationVersion" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ConfigurationVersionDataType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSetMetaDataType", propOrder = {
    "name",
    "description",
    "fields",
    "dataSetClassId",
    "configurationVersion"
})
public class DataSetMetaDataType
    extends DataTypeSchemaHeader
{

    @XmlElementRef(name = "Name", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> name;
    @XmlElementRef(name = "Description", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<LocalizedText> description;
    @XmlElementRef(name = "Fields", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ListOfFieldMetaData> fields;
    @XmlElement(name = "DataSetClassId")
    protected Guid dataSetClassId;
    @XmlElementRef(name = "ConfigurationVersion", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ConfigurationVersionDataType> configurationVersion;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setName(JAXBElement<String> value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LocalizedText }{@code >}
     *     
     */
    public JAXBElement<LocalizedText> getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LocalizedText }{@code >}
     *     
     */
    public void setDescription(JAXBElement<LocalizedText> value) {
        this.description = value;
    }

    /**
     * Gets the value of the fields property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ListOfFieldMetaData }{@code >}
     *     
     */
    public JAXBElement<ListOfFieldMetaData> getFields() {
        return fields;
    }

    /**
     * Sets the value of the fields property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ListOfFieldMetaData }{@code >}
     *     
     */
    public void setFields(JAXBElement<ListOfFieldMetaData> value) {
        this.fields = value;
    }

    /**
     * Gets the value of the dataSetClassId property.
     * 
     * @return
     *     possible object is
     *     {@link Guid }
     *     
     */
    public Guid getDataSetClassId() {
        return dataSetClassId;
    }

    /**
     * Sets the value of the dataSetClassId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Guid }
     *     
     */
    public void setDataSetClassId(Guid value) {
        this.dataSetClassId = value;
    }

    /**
     * Gets the value of the configurationVersion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ConfigurationVersionDataType }{@code >}
     *     
     */
    public JAXBElement<ConfigurationVersionDataType> getConfigurationVersion() {
        return configurationVersion;
    }

    /**
     * Sets the value of the configurationVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ConfigurationVersionDataType }{@code >}
     *     
     */
    public void setConfigurationVersion(JAXBElement<ConfigurationVersionDataType> value) {
        this.configurationVersion = value;
    }

}
