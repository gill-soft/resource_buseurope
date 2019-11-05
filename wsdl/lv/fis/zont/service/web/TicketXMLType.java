
package lv.fis.zont.service.web;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ticketXMLType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ticketXMLType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="seatNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="originalTicketId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="tsAgentAmount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="commAmount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketNr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="discountId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="raceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fromStopId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="toStopId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="saleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="passengerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passengerDocNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="discountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="raceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="platform" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="carrier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isBack" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isInter" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="arrival" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="departure" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="arrivalString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="departureString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originalAmount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="extReportLink" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passengerSurname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passengerMiddlename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passengerGender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passengerCitizenship" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passengerBirthday" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passengerBirthplace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passengerStreet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passengerZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passengerCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passengerDocSeries" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="passengerDocTypeExt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docTypeExts" type="{http://web.service.zont.fis.lv/}docTypeExtXMLType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="commOwnerAmount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ticketXMLType", propOrder = {
    "seatNumber",
    "ticketId",
    "originalTicketId",
    "amount",
    "tsAgentAmount",
    "commAmount",
    "currencyCode",
    "ticketNr",
    "discountId",
    "raceId",
    "fromStopId",
    "toStopId",
    "saleId",
    "passengerName",
    "passengerDocNum",
    "discountName",
    "raceCode",
    "platform",
    "carrier",
    "isBack",
    "isInter",
    "arrival",
    "departure",
    "arrivalString",
    "departureString",
    "originalAmount",
    "extReportLink",
    "passengerSurname",
    "passengerMiddlename",
    "passengerGender",
    "passengerCitizenship",
    "passengerBirthday",
    "passengerBirthplace",
    "passengerStreet",
    "passengerZip",
    "passengerCity",
    "passengerDocSeries",
    "passengerDocTypeExt",
    "docTypeExts",
    "commOwnerAmount"
})
public class TicketXMLType {

    protected String seatNumber;
    protected Long ticketId;
    protected Long originalTicketId;
    protected Long amount;
    protected Long tsAgentAmount;
    protected Long commAmount;
    protected String currencyCode;
    protected String ticketNr;
    protected String discountId;
    protected Long raceId;
    protected Long fromStopId;
    protected Long toStopId;
    protected Long saleId;
    protected String passengerName;
    protected String passengerDocNum;
    protected String discountName;
    protected String raceCode;
    protected String platform;
    protected String carrier;
    protected boolean isBack;
    protected boolean isInter;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar arrival;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar departure;
    protected String arrivalString;
    protected String departureString;
    protected Long originalAmount;
    protected String extReportLink;
    protected String passengerSurname;
    protected String passengerMiddlename;
    protected String passengerGender;
    protected String passengerCitizenship;
    protected String passengerBirthday;
    protected String passengerBirthplace;
    protected String passengerStreet;
    protected String passengerZip;
    protected String passengerCity;
    protected String passengerDocSeries;
    protected String passengerDocTypeExt;
    @XmlElement(nillable = true)
    protected List<DocTypeExtXMLType> docTypeExts;
    protected Long commOwnerAmount;

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
     * Gets the value of the ticketId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTicketId() {
        return ticketId;
    }

    /**
     * Sets the value of the ticketId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTicketId(Long value) {
        this.ticketId = value;
    }

    /**
     * Gets the value of the originalTicketId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOriginalTicketId() {
        return originalTicketId;
    }

    /**
     * Sets the value of the originalTicketId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOriginalTicketId(Long value) {
        this.originalTicketId = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAmount(Long value) {
        this.amount = value;
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
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the ticketNr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketNr() {
        return ticketNr;
    }

    /**
     * Sets the value of the ticketNr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketNr(String value) {
        this.ticketNr = value;
    }

    /**
     * Gets the value of the discountId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscountId() {
        return discountId;
    }

    /**
     * Sets the value of the discountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscountId(String value) {
        this.discountId = value;
    }

    /**
     * Gets the value of the raceId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRaceId() {
        return raceId;
    }

    /**
     * Sets the value of the raceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRaceId(Long value) {
        this.raceId = value;
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
     * Gets the value of the saleId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSaleId() {
        return saleId;
    }

    /**
     * Sets the value of the saleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSaleId(Long value) {
        this.saleId = value;
    }

    /**
     * Gets the value of the passengerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerName() {
        return passengerName;
    }

    /**
     * Sets the value of the passengerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerName(String value) {
        this.passengerName = value;
    }

    /**
     * Gets the value of the passengerDocNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerDocNum() {
        return passengerDocNum;
    }

    /**
     * Sets the value of the passengerDocNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerDocNum(String value) {
        this.passengerDocNum = value;
    }

    /**
     * Gets the value of the discountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscountName() {
        return discountName;
    }

    /**
     * Sets the value of the discountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscountName(String value) {
        this.discountName = value;
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
     * Gets the value of the isBack property.
     * 
     */
    public boolean isIsBack() {
        return isBack;
    }

    /**
     * Sets the value of the isBack property.
     * 
     */
    public void setIsBack(boolean value) {
        this.isBack = value;
    }

    /**
     * Gets the value of the isInter property.
     * 
     */
    public boolean isIsInter() {
        return isInter;
    }

    /**
     * Sets the value of the isInter property.
     * 
     */
    public void setIsInter(boolean value) {
        this.isInter = value;
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
     * Gets the value of the originalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOriginalAmount() {
        return originalAmount;
    }

    /**
     * Sets the value of the originalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOriginalAmount(Long value) {
        this.originalAmount = value;
    }

    /**
     * Gets the value of the extReportLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtReportLink() {
        return extReportLink;
    }

    /**
     * Sets the value of the extReportLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtReportLink(String value) {
        this.extReportLink = value;
    }

    /**
     * Gets the value of the passengerSurname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerSurname() {
        return passengerSurname;
    }

    /**
     * Sets the value of the passengerSurname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerSurname(String value) {
        this.passengerSurname = value;
    }

    /**
     * Gets the value of the passengerMiddlename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerMiddlename() {
        return passengerMiddlename;
    }

    /**
     * Sets the value of the passengerMiddlename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerMiddlename(String value) {
        this.passengerMiddlename = value;
    }

    /**
     * Gets the value of the passengerGender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerGender() {
        return passengerGender;
    }

    /**
     * Sets the value of the passengerGender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerGender(String value) {
        this.passengerGender = value;
    }

    /**
     * Gets the value of the passengerCitizenship property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerCitizenship() {
        return passengerCitizenship;
    }

    /**
     * Sets the value of the passengerCitizenship property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerCitizenship(String value) {
        this.passengerCitizenship = value;
    }

    /**
     * Gets the value of the passengerBirthday property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerBirthday() {
        return passengerBirthday;
    }

    /**
     * Sets the value of the passengerBirthday property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerBirthday(String value) {
        this.passengerBirthday = value;
    }

    /**
     * Gets the value of the passengerBirthplace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerBirthplace() {
        return passengerBirthplace;
    }

    /**
     * Sets the value of the passengerBirthplace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerBirthplace(String value) {
        this.passengerBirthplace = value;
    }

    /**
     * Gets the value of the passengerStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerStreet() {
        return passengerStreet;
    }

    /**
     * Sets the value of the passengerStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerStreet(String value) {
        this.passengerStreet = value;
    }

    /**
     * Gets the value of the passengerZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerZip() {
        return passengerZip;
    }

    /**
     * Sets the value of the passengerZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerZip(String value) {
        this.passengerZip = value;
    }

    /**
     * Gets the value of the passengerCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerCity() {
        return passengerCity;
    }

    /**
     * Sets the value of the passengerCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerCity(String value) {
        this.passengerCity = value;
    }

    /**
     * Gets the value of the passengerDocSeries property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerDocSeries() {
        return passengerDocSeries;
    }

    /**
     * Sets the value of the passengerDocSeries property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerDocSeries(String value) {
        this.passengerDocSeries = value;
    }

    /**
     * Gets the value of the passengerDocTypeExt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerDocTypeExt() {
        return passengerDocTypeExt;
    }

    /**
     * Sets the value of the passengerDocTypeExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerDocTypeExt(String value) {
        this.passengerDocTypeExt = value;
    }

    /**
     * Gets the value of the docTypeExts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the docTypeExts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocTypeExts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocTypeExtXMLType }
     * 
     * 
     */
    public List<DocTypeExtXMLType> getDocTypeExts() {
        if (docTypeExts == null) {
            docTypeExts = new ArrayList<DocTypeExtXMLType>();
        }
        return this.docTypeExts;
    }

    /**
     * Gets the value of the commOwnerAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCommOwnerAmount() {
        return commOwnerAmount;
    }

    /**
     * Sets the value of the commOwnerAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCommOwnerAmount(Long value) {
        this.commOwnerAmount = value;
    }

}
