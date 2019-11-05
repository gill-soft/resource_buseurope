
package lv.fis.zont.service.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for raceDefStopXMLType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="raceDefStopXMLType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stopId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="extStopId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arrivalAsStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tariff" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "raceDefStopXMLType", propOrder = {
    "stopId",
    "extStopId",
    "name",
    "countryCode",
    "arrivalAsStr",
    "tariff"
})
public class RaceDefStopXMLType {

    protected long stopId;
    protected String extStopId;
    protected String name;
    protected String countryCode;
    protected String arrivalAsStr;
    protected int tariff;

    /**
     * Gets the value of the stopId property.
     * 
     */
    public long getStopId() {
        return stopId;
    }

    /**
     * Sets the value of the stopId property.
     * 
     */
    public void setStopId(long value) {
        this.stopId = value;
    }

    /**
     * Gets the value of the extStopId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtStopId() {
        return extStopId;
    }

    /**
     * Sets the value of the extStopId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtStopId(String value) {
        this.extStopId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     * Gets the value of the arrivalAsStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalAsStr() {
        return arrivalAsStr;
    }

    /**
     * Sets the value of the arrivalAsStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalAsStr(String value) {
        this.arrivalAsStr = value;
    }

    /**
     * Gets the value of the tariff property.
     * 
     */
    public int getTariff() {
        return tariff;
    }

    /**
     * Sets the value of the tariff property.
     * 
     */
    public void setTariff(int value) {
        this.tariff = value;
    }

}
