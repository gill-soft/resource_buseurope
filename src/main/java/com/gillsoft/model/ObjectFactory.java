package com.gillsoft.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the lv.fis.zont.service.web package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ServiceAppException_QNAME = new QName("http://web.service.zont.fis.lv/", "ServiceAppException");
    private final static QName _AppException_QNAME = new QName("http://web.service.zont.fis.lv/", "AppException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: lv.fis.zont.service.web
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AppException }
     * 
     */
    public AppException createAppException() {
        return new AppException();
    }

    /**
     * Create an instance of {@link ServiceAppException }
     * 
     */
    public ServiceAppException createServiceAppException() {
        return new ServiceAppException();
    }

    /**
     * Create an instance of {@link DocTypeExtXMLType }
     * 
     */
    public DocTypeExtXMLType createDocTypeExtXMLType() {
        return new DocTypeExtXMLType();
    }

    /**
     * Create an instance of {@link TicketXMLType }
     * 
     */
    public TicketXMLType createTicketXMLType() {
        return new TicketXMLType();
    }

    /**
     * Create an instance of {@link RaceInfoXMLTypeArray }
     * 
     */
    public RaceInfoXMLTypeArray createRaceInfoXMLTypeArray() {
        return new RaceInfoXMLTypeArray();
    }

    /**
     * Create an instance of {@link RaceDefStopXMLTypeArray }
     * 
     */
    public RaceDefStopXMLTypeArray createRaceDefStopXMLTypeArray() {
        return new RaceDefStopXMLTypeArray();
    }

    /**
     * Create an instance of {@link DiscountXMLTypeArray }
     * 
     */
    public DiscountXMLTypeArray createDiscountXMLTypeArray() {
        return new DiscountXMLTypeArray();
    }

    /**
     * Create an instance of {@link RaceSeatXMLTypeArray }
     * 
     */
    public RaceSeatXMLTypeArray createRaceSeatXMLTypeArray() {
        return new RaceSeatXMLTypeArray();
    }

    /**
     * Create an instance of {@link SearchStatXMLType }
     * 
     */
    public SearchStatXMLType createSearchStatXMLType() {
        return new SearchStatXMLType();
    }

    /**
     * Create an instance of {@link RaceSeatXMLType }
     * 
     */
    public RaceSeatXMLType createRaceSeatXMLType() {
        return new RaceSeatXMLType();
    }

    /**
     * Create an instance of {@link RaceDefStopXMLType }
     * 
     */
    public RaceDefStopXMLType createRaceDefStopXMLType() {
        return new RaceDefStopXMLType();
    }

    /**
     * Create an instance of {@link DiscountXMLType }
     * 
     */
    public DiscountXMLType createDiscountXMLType() {
        return new DiscountXMLType();
    }

    /**
     * Create an instance of {@link OrderXMLType }
     * 
     */
    public OrderXMLType createOrderXMLType() {
        return new OrderXMLType();
    }

    /**
     * Create an instance of {@link BuybackInfoXMLType }
     * 
     */
    public BuybackInfoXMLType createBuybackInfoXMLType() {
        return new BuybackInfoXMLType();
    }

    /**
     * Create an instance of {@link StopXMLType }
     * 
     */
    public StopXMLType createStopXMLType() {
        return new StopXMLType();
    }

    /**
     * Create an instance of {@link StopXMLTypeArray }
     * 
     */
    public StopXMLTypeArray createStopXMLTypeArray() {
        return new StopXMLTypeArray();
    }

    /**
     * Create an instance of {@link RaceInfoXMLType }
     * 
     */
    public RaceInfoXMLType createRaceInfoXMLType() {
        return new RaceInfoXMLType();
    }

    /**
     * Create an instance of {@link TicketXMLTypeArray }
     * 
     */
    public TicketXMLTypeArray createTicketXMLTypeArray() {
        return new TicketXMLTypeArray();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceAppException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.service.zont.fis.lv/", name = "ServiceAppException")
    public JAXBElement<ServiceAppException> createServiceAppException(ServiceAppException value) {
        return new JAXBElement<ServiceAppException>(_ServiceAppException_QNAME, ServiceAppException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.service.zont.fis.lv/", name = "AppException")
    public JAXBElement<AppException> createAppException(AppException value) {
        return new JAXBElement<AppException>(_AppException_QNAME, AppException.class, null, value);
    }

}
