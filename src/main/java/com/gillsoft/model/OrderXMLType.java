package com.gillsoft.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for orderXMLType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderXMLType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="paymentSum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="payState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clientMail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clientPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clientIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clientLang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="directTickets" type="{http://web.service.zont.fis.lv/}ticketXMLType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="returnTickets" type="{http://web.service.zont.fis.lv/}ticketXMLType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderXMLType", propOrder = {
    "id",
    "paymentSum",
    "payState",
    "clientMail",
    "clientPhone",
    "clientIp",
    "clientLang",
    "directTickets",
    "returnTickets"
})
public class OrderXMLType {

    protected Long id;
    protected Long paymentSum;
    protected String payState;
    protected String clientMail;
    protected String clientPhone;
    protected String clientIp;
    protected String clientLang;
    @XmlElement(nillable = true)
    protected List<TicketXMLType> directTickets;
    @XmlElement(nillable = true)
    protected List<TicketXMLType> returnTickets;

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
     * Gets the value of the paymentSum property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPaymentSum() {
        return paymentSum;
    }

    /**
     * Sets the value of the paymentSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPaymentSum(Long value) {
        this.paymentSum = value;
    }

    /**
     * Gets the value of the payState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayState() {
        return payState;
    }

    /**
     * Sets the value of the payState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayState(String value) {
        this.payState = value;
    }

    /**
     * Gets the value of the clientMail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientMail() {
        return clientMail;
    }

    /**
     * Sets the value of the clientMail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientMail(String value) {
        this.clientMail = value;
    }

    /**
     * Gets the value of the clientPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientPhone() {
        return clientPhone;
    }

    /**
     * Sets the value of the clientPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientPhone(String value) {
        this.clientPhone = value;
    }

    /**
     * Gets the value of the clientIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * Sets the value of the clientIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientIp(String value) {
        this.clientIp = value;
    }

    /**
     * Gets the value of the clientLang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientLang() {
        return clientLang;
    }

    /**
     * Sets the value of the clientLang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientLang(String value) {
        this.clientLang = value;
    }

    /**
     * Gets the value of the directTickets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the directTickets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirectTickets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TicketXMLType }
     * 
     * 
     */
    public List<TicketXMLType> getDirectTickets() {
        if (directTickets == null) {
            directTickets = new ArrayList<TicketXMLType>();
        }
        return this.directTickets;
    }

    /**
     * Gets the value of the returnTickets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the returnTickets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReturnTickets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TicketXMLType }
     * 
     * 
     */
    public List<TicketXMLType> getReturnTickets() {
        if (returnTickets == null) {
            returnTickets = new ArrayList<TicketXMLType>();
        }
        return this.returnTickets;
    }

}
