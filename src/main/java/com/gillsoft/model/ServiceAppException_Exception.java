package com.gillsoft.model;

import javax.xml.ws.WebFault;

/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ServiceAppException", targetNamespace = "http://web.service.zont.fis.lv/")
public class ServiceAppException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ServiceAppException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ServiceAppException_Exception(String message, ServiceAppException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ServiceAppException_Exception(String message, ServiceAppException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: lv.fis.zont.service.web.ServiceAppException
     */
    public ServiceAppException getFaultInfo() {
        return faultInfo;
    }

}
