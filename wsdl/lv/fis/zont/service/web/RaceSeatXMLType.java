
package lv.fis.zont.service.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for raceSeatXMLType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="raceSeatXMLType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="seatNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="seat" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="seatName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "raceSeatXMLType", propOrder = {
    "seatNumber",
    "seat",
    "seatName"
})
public class RaceSeatXMLType {

    protected String seatNumber;
    protected boolean seat;
    protected String seatName;

    /**
     * Gets the value of the seatNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeatNumber() {
        return seatNumber;
    }

    /**
     * Sets the value of the seatNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeatNumber(String value) {
        this.seatNumber = value;
    }

    /**
     * Gets the value of the seat property.
     * 
     */
    public boolean isSeat() {
        return seat;
    }

    /**
     * Sets the value of the seat property.
     * 
     */
    public void setSeat(boolean value) {
        this.seat = value;
    }

    /**
     * Gets the value of the seatName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeatName() {
        return seatName;
    }

    /**
     * Sets the value of the seatName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeatName(String value) {
        this.seatName = value;
    }

}
