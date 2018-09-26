package com.gillsoft.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for raceInfoXMLType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="raceInfoXMLType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="arrival" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="departure" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="arrivalString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="departureString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="carrier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="route" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="platform" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="raceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="freeSeats" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isInter" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isSale" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="fromStopId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="toStopId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="tsAgentAmount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="commAmount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="raceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stationFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stationTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="registerURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketMandatoryAttrs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isTransfer" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "raceInfoXMLType", propOrder = {
    "id",
    "arrival",
    "departure",
    "arrivalString",
    "departureString",
    "carrier",
    "route",
    "platform",
    "price",
    "raceCode",
    "freeSeats",
    "isInter",
    "isSale",
    "fromStopId",
    "toStopId",
    "tsAgentAmount",
    "commAmount",
    "raceName",
    "stationFrom",
    "stationTo",
    "registerURL",
    "ticketMandatoryAttrs",
    "addInfo",
    "isTransfer"
})
public class RaceInfoXMLType implements Serializable {

	private static final long serialVersionUID = 9129532670100714671L;

	protected Long id;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar arrival;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar departure;
    protected String arrivalString;
    protected String departureString;
    protected String carrier;
    protected String route;
    protected String platform;
    protected Long price;
    protected String raceCode;
    protected Long freeSeats;
    protected Boolean isInter;
    protected Boolean isSale;
    protected Long fromStopId;
    protected Long toStopId;
    protected Long tsAgentAmount;
    protected Long commAmount;
    protected String raceName;
    protected String stationFrom;
    protected String stationTo;
    protected String registerURL;
    protected String ticketMandatoryAttrs;
    protected String addInfo;
    protected Boolean isTransfer;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the arrival property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArrival() {
        return arrival;
    }

    /**
     * Sets the value of the arrival property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArrival(XMLGregorianCalendar value) {
        this.arrival = value;
    }

    /**
     * Gets the value of the departure property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeparture() {
        return departure;
    }

    /**
     * Sets the value of the departure property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeparture(XMLGregorianCalendar value) {
        this.departure = value;
    }

    /**
     * Gets the value of the arrivalString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrivalString() {
        return arrivalString;
    }

    /**
     * Sets the value of the arrivalString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrivalString(String value) {
        this.arrivalString = value;
    }

    /**
     * Gets the value of the departureString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartureString() {
        return departureString;
    }

    /**
     * Sets the value of the departureString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartureString(String value) {
        this.departureString = value;
    }

    /**
     * Gets the value of the carrier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarrier() {
        return carrier;
    }

    /**
     * Sets the value of the carrier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarrier(String value) {
        this.carrier = value;
    }

    /**
     * Gets the value of the route property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoute() {
        return route;
    }

    /**
     * Sets the value of the route property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoute(String value) {
        this.route = value;
    }

    /**
     * Gets the value of the platform property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets the value of the platform property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatform(String value) {
        this.platform = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrice(Long value) {
        this.price = value;
    }

    /**
     * Gets the value of the raceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaceCode() {
        return raceCode;
    }

    /**
     * Sets the value of the raceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaceCode(String value) {
        this.raceCode = value;
    }

    /**
     * Gets the value of the freeSeats property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFreeSeats() {
        return freeSeats;
    }

    /**
     * Sets the value of the freeSeats property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFreeSeats(Long value) {
        this.freeSeats = value;
    }

    /**
     * Gets the value of the isInter property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsInter() {
        return isInter;
    }

    /**
     * Sets the value of the isInter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsInter(Boolean value) {
        this.isInter = value;
    }

    /**
     * Gets the value of the isSale property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsSale() {
        return isSale;
    }

    /**
     * Sets the value of the isSale property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsSale(Boolean value) {
        this.isSale = value;
    }

    /**
     * Gets the value of the fromStopId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFromStopId() {
        return fromStopId;
    }

    /**
     * Sets the value of the fromStopId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFromStopId(Long value) {
        this.fromStopId = value;
    }

    /**
     * Gets the value of the toStopId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getToStopId() {
        return toStopId;
    }

    /**
     * Sets the value of the toStopId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setToStopId(Long value) {
        this.toStopId = value;
    }

    /**
     * Gets the value of the tsAgentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTsAgentAmount() {
        return tsAgentAmount;
    }

    /**
     * Sets the value of the tsAgentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTsAgentAmount(Long value) {
        this.tsAgentAmount = value;
    }

    /**
     * Gets the value of the commAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCommAmount() {
        return commAmount;
    }

    /**
     * Sets the value of the commAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCommAmount(Long value) {
        this.commAmount = value;
    }

    /**
     * Gets the value of the raceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRaceName() {
        return raceName;
    }

    /**
     * Sets the value of the raceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRaceName(String value) {
        this.raceName = value;
    }

    /**
     * Gets the value of the stationFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStationFrom() {
        return stationFrom;
    }

    /**
     * Sets the value of the stationFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStationFrom(String value) {
        this.stationFrom = value;
    }

    /**
     * Gets the value of the stationTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStationTo() {
        return stationTo;
    }

    /**
     * Sets the value of the stationTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStationTo(String value) {
        this.stationTo = value;
    }

    /**
     * Gets the value of the registerURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisterURL() {
        return registerURL;
    }

    /**
     * Sets the value of the registerURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisterURL(String value) {
        this.registerURL = value;
    }

    /**
     * Gets the value of the ticketMandatoryAttrs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketMandatoryAttrs() {
        return ticketMandatoryAttrs;
    }

    /**
     * Sets the value of the ticketMandatoryAttrs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketMandatoryAttrs(String value) {
        this.ticketMandatoryAttrs = value;
    }

    /**
     * Gets the value of the addInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddInfo() {
        return addInfo;
    }

    /**
     * Sets the value of the addInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddInfo(String value) {
        this.addInfo = value;
    }

    /**
     * Gets the value of the isTransfer property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsTransfer() {
        return isTransfer;
    }

    /**
     * Sets the value of the isTransfer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsTransfer(Boolean value) {
        this.isTransfer = value;
    }

}
