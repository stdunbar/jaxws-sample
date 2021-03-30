
package com.hotjoe.services.test.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hotjoe.services.test.ws.client package. 
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

    private final static QName _HeartbeatResponse_QNAME = new QName("http://ws.services.hotjoe.com/", "heartbeatResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hotjoe.services.test.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HeartbeatResponse }
     * 
     */
    public HeartbeatResponse createHeartbeatResponse() {
        return new HeartbeatResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HeartbeatResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.services.hotjoe.com/", name = "heartbeatResponse")
    public JAXBElement<HeartbeatResponse> createHeartbeatResponse(HeartbeatResponse value) {
        return new JAXBElement<HeartbeatResponse>(_HeartbeatResponse_QNAME, HeartbeatResponse.class, null, value);
    }

}
