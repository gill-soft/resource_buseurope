package com.gillsoft.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for stopXMLType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stopXMLType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stopID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="stopName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stopExtName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stopExtParam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stopXMLType", propOrder = {
    "stopID",
    "stopName",
    "countryCode",
    "stopExtName",
    "stopExtParam"
})
public class StopXMLType {

    protected Long stopID;
    protected String stopName;
    protected String countryCode;
    protected String stopExtName;
    protected String stopExtParam;

    /**
     * Gets the value of the stopID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStopID() {
        return stopID;
    }

    /**
     * Sets the value of the stopID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStopID(Long value) {
        this.stopID = value;
    }

    /**
     * Gets the value of the stopName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStopName() {
        return stopName;
    }

    /**
     * Sets the value of the stopName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStopName(String value) {
        this.stopName = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the stopExtName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStopExtName() {
        return stopExtName;
    }

    /**
     * Sets the value of the stopExtName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStopExtName(String value) {
        this.stopExtName = value;
    }

    /**
     * Gets the value of the stopExtParam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStopExtParam() {
        return stopExtParam;
    }

    /**
     * Sets the value of the stopExtParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStopExtParam(String value) {
        this.stopExtParam = value;
    }

}
