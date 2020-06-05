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
 * <p>Java class for PublishedDataSetDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublishedDataSetDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DataSetFolder" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ListOfString" minOccurs="0"/>
 *         &lt;element name="DataSetMetaData" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}DataSetMetaDataType" minOccurs="0"/>
 *         &lt;element name="ExtensionFields" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ListOfKeyValuePair" minOccurs="0"/>
 *         &lt;element name="DataSetSource" type="{http://opcfoundation.org/UA/2008/02/Types.xsd}ExtensionObject" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PublishedDataSetDataType", propOrder = {
    "name",
    "dataSetFolder",
    "dataSetMetaData",
    "extensionFields",
    "dataSetSource"
})
public class PublishedDataSetDataType {

    @XmlElementRef(name = "Name", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> name;
    @XmlElementRef(name = "DataSetFolder", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ListOfString> dataSetFolder;
    @XmlElementRef(name = "DataSetMetaData", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<DataSetMetaDataType> dataSetMetaData;
    @XmlElementRef(name = "ExtensionFields", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ListOfKeyValuePair> extensionFields;
    @XmlElementRef(name = "DataSetSource", namespace = "http://opcfoundation.org/UA/2008/02/Types.xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<ExtensionObject> dataSetSource;

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
     * Gets the value of the dataSetFolder property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ListOfString }{@code >}
     *     
     */
    public JAXBElement<ListOfString> getDataSetFolder() {
        return dataSetFolder;
    }

    /**
     * Sets the value of the dataSetFolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ListOfString }{@code >}
     *     
     */
    public void setDataSetFolder(JAXBElement<ListOfString> value) {
        this.dataSetFolder = value;
    }

    /**
     * Gets the value of the dataSetMetaData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DataSetMetaDataType }{@code >}
     *     
     */
    public JAXBElement<DataSetMetaDataType> getDataSetMetaData() {
        return dataSetMetaData;
    }

    /**
     * Sets the value of the dataSetMetaData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DataSetMetaDataType }{@code >}
     *     
     */
    public void setDataSetMetaData(JAXBElement<DataSetMetaDataType> value) {
        this.dataSetMetaData = value;
    }

    /**
     * Gets the value of the extensionFields property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ListOfKeyValuePair }{@code >}
     *     
     */
    public JAXBElement<ListOfKeyValuePair> getExtensionFields() {
        return extensionFields;
    }

    /**
     * Sets the value of the extensionFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ListOfKeyValuePair }{@code >}
     *     
     */
    public void setExtensionFields(JAXBElement<ListOfKeyValuePair> value) {
        this.extensionFields = value;
    }

    /**
     * Gets the value of the dataSetSource property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ExtensionObject }{@code >}
     *     
     */
    public JAXBElement<ExtensionObject> getDataSetSource() {
        return dataSetSource;
    }

    /**
     * Sets the value of the dataSetSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ExtensionObject }{@code >}
     *     
     */
    public void setDataSetSource(JAXBElement<ExtensionObject> value) {
        this.dataSetSource = value;
    }

}