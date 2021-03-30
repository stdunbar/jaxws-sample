# JAX-WS Sample application for Wildfly
A very simple JAX-WS sample application that implements a few services.  The
services are meant purely as a demonstration and are not "real" services.


Deployment
----

To build, simply run

```mvn clean package```

This will compile, run the unit tests, and create a war file that can be deployed into an JEE app server.  I've only
tested with Wildfly at this point.

The war file can be deployed to Wildfly and possibly other JEE application servers.
For Wildlfy, there are many options to deploy listed on
[the application deployment page](https://docs.jboss.org/author/display/WFLY10/Application+deployment)
that can help deploy.

Sample Service Info
----
There are a total of three service endpoints:

```getHeartBeat``` - returns a small response with an "OK" string if the service is up
  and running. A heartbeat service like this is commonly used in load balancing
  environments so that a load balancer can validate that an application is healthy.

The request looks like:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://ws.services.hotjoe.com/">
  <soapenv:Header/>
  <soapenv:Body>
    <ws:getHeartBeat/>
  </soapenv:Body>
</soapenv:Envelope>
```

with a positive response of:
```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <ns1:getHeartBeatResponse xmlns:ns1="http://ws.services.hotjoe.com/">
      <return xmlns:ns2="http://ws.services.hotjoe.com/">
        <status>OK</status>
      </return>
    </ns1:getHeartBeatResponse>
  </soap:Body>
</soap:Envelope>
```

```createProduct``` - puts a "product" in the catalog.  The product SOAP packet looks like:
  
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://ws.services.hotjoe.com/">
  <soapenv:Header/>
  <soapenv:Body>
    <ws:createProduct>
      <arg0>
        <productId>123456</productId>
        <description>This is the description</description>
        <createDate>2021-03-30T12:40:21.038-06:00</createDate>
      </arg0>
    </ws:createProduct>
  </soapenv:Body>
</soapenv:Envelope>
```

This creates a product in the catalog.  The productId and createDate are optional and will be filled in by
the service if they are not set.  The response will echo back the same structure with the optional fields
populated if needed:

```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <ns1:createProductResponse xmlns:ns1="http://ws.services.hotjoe.com/">
      <return>
        <productId>123456</productId>
        <description>This is the description</description>
        <createDate>2021-03-30T12:40:21.038-06:00</createDate>
      </return>
    </ns1:createProductResponse>
  </soap:Body>
</soap:Envelope>
```

Note that the productId is simply a random integer between 10000 and 1000000.  The
createDate is when the product was added to the catalog.

If the product id is already in use a ProductAlreadyExistsException SOAP fault will be returned
with the body

```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <soap:Fault>
      <faultcode>soap:Server</faultcode>
      <faultstring>product id 12345 already exists</faultstring>
      <detail>
        <ns1:ProductAlreadyExistsException xmlns:ns1="http://ws.services.hotjoe.com/"/>
      </detail>
    </soap:Fault>
  </soap:Body>
</soap:Envelope>
```

```getProduct``` gets an existing product with the given product id.
The response body looks the same as the call to create a new product.  The call is simply:

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://ws.services.hotjoe.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <ws:getProduct>
         <arg0>
            <productId>12345</productId>
         </arg0>
      </ws:getProduct>
   </soapenv:Body>
</soapenv:Envelope>
```

with a response

```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <ns1:getProductResponse xmlns:ns1="http://ws.services.hotjoe.com/">
      <return>
        <productId>12345</productId>
        <description>This is the description</description>
        <createDate>2021-03-30T12:45:44.035-06:00</createDate>
      </return>
    </ns1:getProductResponse>
  </soap:Body>
</soap:Envelope>
```

if the product id cannot be found, a ProductNotFoundException SOAP fault is returned:


```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <soap:Fault>
      <faultcode>soap:Server</faultcode>
      <faultstring>productId not found - 666</faultstring>
      <detail>
        <ns1:ProductNotFoundException xmlns:ns1="http://ws.services.hotjoe.com/"/>
      </detail>
    </soap:Fault>
  </soap:Body>
</soap:Envelope>
```


Copyright (c) 2021
by Xigole Systems
Licensed under the MIT License - see the file LICENSE for details. 
