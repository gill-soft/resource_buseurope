
package lv.fis.zont.service.web;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import net.java.dev.jaxb.array.Base64BinaryArray;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SubAgentWebService", targetNamespace = "http://web.service.zont.fis.lv/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    lv.fis.zont.service.web.ObjectFactory.class,
    net.java.dev.jaxb.array.ObjectFactory.class
})
public interface SubAgentWebService {


    /**
     * 
     * @param saleXML
     * @param contactEmail
     * @param contactPhone
     * @return
     *     returns lv.fis.zont.service.web.OrderXMLType
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public OrderXMLType reserve(
        @WebParam(name = "saleXML", partName = "saleXML")
        OrderXMLType saleXML,
        @WebParam(name = "contactEmail", partName = "contactEmail")
        String contactEmail,
        @WebParam(name = "contactPhone", partName = "contactPhone")
        String contactPhone)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @param backDepDate
     * @param startStopId
     * @param destStopId
     * @param depDate
     * @return
     *     returns lv.fis.zont.service.web.SearchStatXMLType
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public SearchStatXMLType searchRoundTripRacesWithSearchStat(
        @WebParam(name = "startStopId", partName = "startStopId")
        long startStopId,
        @WebParam(name = "destStopId", partName = "destStopId")
        long destStopId,
        @WebParam(name = "depDate", partName = "depDate")
        XMLGregorianCalendar depDate,
        @WebParam(name = "backDepDate", partName = "backDepDate")
        XMLGregorianCalendar backDepDate)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @param orderId
     * @param lang
     * @return
     *     returns net.java.dev.jaxb.array.Base64BinaryArray
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public Base64BinaryArray getTicketPDF(
        @WebParam(name = "orderId", partName = "orderId")
        long orderId,
        @WebParam(name = "lang", partName = "lang")
        String lang)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @param backDepDate
     * @param startStopId
     * @param destStopId
     * @param depDate
     * @return
     *     returns long
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public long searchRoundTripRaces(
        @WebParam(name = "startStopId", partName = "startStopId")
        long startStopId,
        @WebParam(name = "destStopId", partName = "destStopId")
        long destStopId,
        @WebParam(name = "depDate", partName = "depDate")
        XMLGregorianCalendar depDate,
        @WebParam(name = "backDepDate", partName = "backDepDate")
        XMLGregorianCalendar backDepDate)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @param startStopId
     * @param destStopId
     * @param depDate
     * @return
     *     returns long
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public long searchRaces(
        @WebParam(name = "startStopId", partName = "startStopId")
        long startStopId,
        @WebParam(name = "destStopId", partName = "destStopId")
        long destStopId,
        @WebParam(name = "depDate", partName = "depDate")
        XMLGregorianCalendar depDate)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @param saleId
     * @return
     *     returns lv.fis.zont.service.web.OrderXMLType
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public OrderXMLType registerTickets(
        @WebParam(name = "saleId", partName = "saleId")
        long saleId)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @param raceId
     * @param fromStopId
     * @param toStopId
     * @return
     *     returns lv.fis.zont.service.web.RaceDefStopXMLTypeArray
     * @throws AppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public RaceDefStopXMLTypeArray getRaceStops(
        @WebParam(name = "raceId", partName = "raceId")
        long raceId,
        @WebParam(name = "fromStopId", partName = "fromStopId")
        long fromStopId,
        @WebParam(name = "toStopId", partName = "toStopId")
        long toStopId)
        throws AppException_Exception
    ;

    /**
     * 
     * @param password
     * @param username
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    public boolean login(
        @WebParam(name = "username", partName = "username")
        String username,
        @WebParam(name = "password", partName = "password")
        String password);

    /**
     * 
     * @param raceId
     * @return
     *     returns lv.fis.zont.service.web.RaceSeatXMLTypeArray
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public RaceSeatXMLTypeArray getRaceFreeSeats(
        @WebParam(name = "raceId", partName = "raceId")
        long raceId)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    public String getSystemCurrency();

    /**
     * 
     * @param searchStat
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    public boolean isSearchComplete(
        @WebParam(name = "searchStat", partName = "searchStat")
        SearchStatXMLType searchStat);

    /**
     * 
     * @param raceId
     * @param seatsCount
     * @param fromStopId
     * @param departureDate
     * @param lang
     * @param toStopId
     * @param remoteAddr
     * @return
     *     returns lv.fis.zont.service.web.OrderXMLType
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public OrderXMLType startSale(
        @WebParam(name = "fromStopId", partName = "fromStopId")
        long fromStopId,
        @WebParam(name = "toStopId", partName = "toStopId")
        long toStopId,
        @WebParam(name = "raceId", partName = "raceId")
        long raceId,
        @WebParam(name = "departureDate", partName = "departureDate")
        XMLGregorianCalendar departureDate,
        @WebParam(name = "seatsCount", partName = "seatsCount")
        int seatsCount,
        @WebParam(name = "remoteAddr", partName = "remoteAddr")
        String remoteAddr,
        @WebParam(name = "lang", partName = "lang")
        String lang)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @param lang
     * @param ticketId
     * @return
     *     returns java.lang.String
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public String getBuybackAgreement(
        @WebParam(name = "ticketId", partName = "ticketId")
        long ticketId,
        @WebParam(name = "lang", partName = "lang")
        String lang)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @param ticketId
     * @return
     *     returns lv.fis.zont.service.web.BuybackInfoXMLType
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public BuybackInfoXMLType buyback(
        @WebParam(name = "ticketId", partName = "ticketId")
        long ticketId)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    public String getSupportEmail();

    /**
     * 
     * @param ticketXML
     * @return
     *     returns lv.fis.zont.service.web.TicketXMLType
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public TicketXMLType applyDiscount(
        @WebParam(name = "ticketXML", partName = "ticketXML")
        TicketXMLType ticketXML)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @param searchId
     * @return
     *     returns lv.fis.zont.service.web.RaceInfoXMLTypeArray
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public RaceInfoXMLTypeArray getFoundRaces(
        @WebParam(name = "searchId", partName = "searchId")
        long searchId)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     */
    @WebMethod
    public void logout();

    /**
     * 
     * @param ticketId
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    public void processOwnerBuyback(
        @WebParam(name = "ticketId", partName = "ticketId")
        long ticketId)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @param ticketId
     * @return
     *     returns lv.fis.zont.service.web.BuybackInfoXMLType
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public BuybackInfoXMLType calculateBuyback(
        @WebParam(name = "ticketId", partName = "ticketId")
        long ticketId)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @param raceId
     * @param seatsCount
     * @param returnRaceId
     * @param departureBackDate
     * @param fromStopId
     * @param departureDate
     * @param lang
     * @param toStopId
     * @param remoteAddr
     * @return
     *     returns lv.fis.zont.service.web.OrderXMLType
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public OrderXMLType startRoundTripSale(
        @WebParam(name = "fromStopId", partName = "fromStopId")
        long fromStopId,
        @WebParam(name = "toStopId", partName = "toStopId")
        long toStopId,
        @WebParam(name = "raceId", partName = "raceId")
        long raceId,
        @WebParam(name = "returnRaceId", partName = "returnRaceId")
        long returnRaceId,
        @WebParam(name = "departureDate", partName = "departureDate")
        XMLGregorianCalendar departureDate,
        @WebParam(name = "departureBackDate", partName = "departureBackDate")
        XMLGregorianCalendar departureBackDate,
        @WebParam(name = "seatsCount", partName = "seatsCount")
        int seatsCount,
        @WebParam(name = "remoteAddr", partName = "remoteAddr")
        String remoteAddr,
        @WebParam(name = "lang", partName = "lang")
        String lang)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @param maxquantity
     * @return
     *     returns lv.fis.zont.service.web.StopXMLTypeArray
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public StopXMLTypeArray getStops(
        @WebParam(name = "maxquantity", partName = "maxquantity")
        int maxquantity)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param maxquantity
     * @return
     *     returns lv.fis.zont.service.web.StopXMLTypeArray
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public StopXMLTypeArray getStopsExtSystemNames(
        @WebParam(name = "maxquantity", partName = "maxquantity")
        int maxquantity,
        @WebParam(name = "arg1", partName = "arg1")
        long arg1)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    public boolean doLogout();

    /**
     * 
     * @param orderId
     * @return
     *     returns lv.fis.zont.service.web.OrderXMLType
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public OrderXMLType findOrderById(
        @WebParam(name = "orderId", partName = "orderId")
        long orderId)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @param saleId
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    public void cancelReservation(
        @WebParam(name = "saleId", partName = "saleId")
        long saleId)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @return
     *     returns lv.fis.zont.service.web.TicketXMLTypeArray
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public TicketXMLTypeArray getTicketsReturnedByOwners()
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @param maxquantity
     * @return
     *     returns lv.fis.zont.service.web.StopXMLTypeArray
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public StopXMLTypeArray getStopsAnothers(
        @WebParam(name = "maxquantity", partName = "maxquantity")
        int maxquantity)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @param startStopId
     * @param destStopId
     * @param depDate
     * @return
     *     returns lv.fis.zont.service.web.SearchStatXMLType
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public SearchStatXMLType searchRacesWithSearchStat(
        @WebParam(name = "startStopId", partName = "startStopId")
        long startStopId,
        @WebParam(name = "destStopId", partName = "destStopId")
        long destStopId,
        @WebParam(name = "depDate", partName = "depDate")
        XMLGregorianCalendar depDate)
        throws ServiceAppException_Exception
    ;

    /**
     * 
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    public boolean isLoggedIn();

    /**
     * 
     * @param raceId
     * @param fromStopId
     * @param lang
     * @param toStopId
     * @return
     *     returns lv.fis.zont.service.web.DiscountXMLTypeArray
     * @throws ServiceAppException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public DiscountXMLTypeArray getDiscounts(
        @WebParam(name = "raceId", partName = "raceId")
        long raceId,
        @WebParam(name = "fromStopId", partName = "fromStopId")
        long fromStopId,
        @WebParam(name = "toStopId", partName = "toStopId")
        long toStopId,
        @WebParam(name = "lang", partName = "lang")
        String lang)
        throws ServiceAppException_Exception
    ;

}
