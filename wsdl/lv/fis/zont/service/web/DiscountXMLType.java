
package lv.fis.zont.service.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for discountXMLType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="discountXMLType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="percent" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="mandatoryNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "discountXMLType", propOrder = {
    "id",
    "name",
    "amount",
    "percent",
    "mandatoryNote"
})
public class DiscountXMLType {

    protected String id;
    protected String name;
    protected long amount;
    protected long percent;
    protected String mandatoryNote;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
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
     * Gets the value of the amount property.
     * 
     */
    public long getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(long value) {
        this.amount = value;
    }

    /**
     * Gets the value of the percent property.
     * 
     */
    public long getPercent() {
        return percent;
    }

    /**
     * Sets the value of the percent property.
     * 
     */
    public void setPercent(long value) {
        this.percent = value;
    }

    /**
     * Gets the value of the mandatoryNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMandatoryNote() {
        return mandatoryNote;
    }

    /**
     * Sets the value of the mandatoryNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMandatoryNote(String value) {
        this.mandatoryNote = value;
    }

}
