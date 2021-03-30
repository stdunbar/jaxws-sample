
package com.hotjoe.services.test.ws.client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ProductNotFoundException", targetNamespace = "http://ws.services.hotjoe.com/")
public class ProductNotFoundException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ProductNotFoundException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ProductNotFoundException_Exception(String message, ProductNotFoundException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ProductNotFoundException_Exception(String message, ProductNotFoundException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.hotjoe.services.test.ws.client.ProductNotFoundException
     */
    public ProductNotFoundException getFaultInfo() {
        return faultInfo;
    }

}