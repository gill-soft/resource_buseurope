
package lv.fis.zont.service.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchStatXMLType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchStatXMLType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="checkCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchStatXMLType", propOrder = {
    "searchId",
    "checkCode"
})
public class SearchStatXMLType {

    protected long searchId;
    protected int checkCode;

    /**
     * Gets the value of the searchId property.
     * 
     */
    public long getSearchId() {
        return searchId;
    }

    /**
     * Sets the value of the searchId property.
     * 
     */
    public void setSearchId(long value) {
        this.searchId = value;
    }

    /**
     * Gets the value of the checkCode property.
     * 
     */
    public int getCheckCode() {
        return checkCode;
    }

    /**
     * Sets the value of the checkCode property.
     * 
     */
    public void setCheckCode(int value) {
        this.checkCode = value;
    }

}
