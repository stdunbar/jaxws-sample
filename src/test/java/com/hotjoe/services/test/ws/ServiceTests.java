package com.hotjoe.services.test.ws;


import com.hotjoe.services.test.ws.client.BadProductNameException_Exception;
import com.hotjoe.services.test.ws.client.GetProductRequest;
import com.hotjoe.services.test.ws.client.HeartBeatService;
import com.hotjoe.services.test.ws.client.HeartBeatServiceService;
import com.hotjoe.services.test.ws.client.HeartbeatResponse;
import com.hotjoe.services.test.ws.client.Product;
import com.hotjoe.services.test.ws.client.ProductAlreadyExistsException_Exception;
import com.hotjoe.services.test.ws.client.ProductNotFoundException_Exception;
import com.hotjoe.services.test.ws.client.ProductService;
import com.hotjoe.services.test.ws.client.ProductServiceService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.PomEquippedResolveStage;
import org.jboss.shrinkwrap.resolver.api.maven.ScopeType;
import org.jboss.shrinkwrap.resolver.api.maven.strategy.TransitiveStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
* This is the primary test harness for the service example.  It sets up the war file to be tested
* and runs a few tests.
*
* For speed in testing, there should be a single test class.  The reason is that each new test
* class requires spinning up a new instance of Wildfly and this is expensive.  You can certainly
* do it if you want but be aware of the overhead.
*
*/
@RunWith(Arquillian.class)
public class ServiceTests {
    // private static final Logger logger = LoggerFactory.getLogger(ProductServiceTests.class);

    /**
    * The @Deployment annotation is required with Arquillian tests.  This method creates a temporary
    * war file that will be tested.  For this example this war contains the dependencies specified
    * in the <pre>pom.xml</pre> file and anything in the <pre>com.hotjoe</pre> package.
    */
    @Deployment(testable = false)
    @SuppressWarnings("unused")
    public static WebArchive createDeployment() {

        PomEquippedResolveStage pom = Maven.resolver().loadPomFromFile("pom.xml");
        ScopeType[] scopes = {ScopeType.COMPILE}; // no SYSTEM and no PROVIDED
        File[] libs = pom.importDependencies(scopes).resolve().using(TransitiveStrategy.INSTANCE).asFile();

        return ShrinkWrap.create(WebArchive.class, "sample.war")
                .addAsLibraries(libs)
                .addPackages(true, Filters.exclude(".*Test.*"), "com.hotjoe")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    /**
    * Tests the heartbeat service.  The <pre>@RunAsClient</pre> means that this test will run as
    * a true client of the service.
    */
    @Test
    @RunAsClient
    public void testHeartbeat(@ArquillianResource URL baseURL) throws IOException {
        HeartBeatServiceService heartBeatServiceService = new HeartBeatServiceService(new URL(baseURL.toExternalForm() + "HeartBeatService?wsdl"));

        HeartBeatService heartBeatService = heartBeatServiceService.getHeartBeatServicePort();

        HeartbeatResponse heartbeatResponse = heartBeatService.getHeartBeat();

        assertNotNull(heartbeatResponse);

        assertTrue(heartbeatResponse.getStatus().equalsIgnoreCase("ok"));
    }

/*    @Test
    @RunAsClient
    public void testVersion(@ArquillianResource URL baseURL) throws Exception {
        VersionServiceService versionServiceService = new VersionServiceService(new URL(baseURL.toExternalForm() + "VersionService?wsdl"));

        VersionService versionService = versionServiceService.getVersionServicePort();

        VersionInfo versionInfo = versionService.getFullStatus();

        assertNotNull(versionInfo);

        assertNotNull(versionInfo.getCommitMessageFull());
    } */

    /**
     * Tests the product create service with a given product Id.
     */
    @Test
    @RunAsClient
    public void testNewProductHappyPath(@ArquillianResource URL baseURL) throws Exception {
        ProductServiceService productServiceService = new ProductServiceService(new URL(baseURL.toExternalForm() + "ProductService?wsdl"));

        ProductService productService = productServiceService.getProductServicePort();

        Random random = new Random();
        Integer productId = random.nextInt(100000);

        Product product = new Product();
        product.setProductId(productId);
        product.setDescription("This is the product description");
        OffsetDateTime now = OffsetDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        product.setCreateDate(formatter.format(now));

        Product productResponse = productService.createProduct(product);

        assertEquals(productResponse.getProductId(), productId);
        assertNotNull(productResponse.getDescription());
    }

    /**
     * Tests the product create service letting the service generate the product Id.
     */
    @Test
    @RunAsClient
    public void testNoProductId(@ArquillianResource URL baseURL) throws Exception {
        ProductServiceService productServiceService = new ProductServiceService(new URL(baseURL.toExternalForm() + "ProductService?wsdl"));

        ProductService productService = productServiceService.getProductServicePort();

        Product product = new Product();
        product.setDescription("This is the product description");
        OffsetDateTime now = OffsetDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        product.setCreateDate(formatter.format(now));

        Product productResponse = productService.createProduct(product);

        assertNotNull(productResponse.getProductId());
        assertNotNull(productResponse.getDescription());
    }

    /**
     * Tests the product create service letting the service generate the product Id.
     */
    @Test(expected=ProductAlreadyExistsException_Exception.class)
    @RunAsClient
    public void testNewProductDuplicateId(@ArquillianResource URL baseURL) throws Exception {
        ProductServiceService productServiceService = new ProductServiceService(new URL(baseURL.toExternalForm() + "ProductService?wsdl"));

        ProductService productService = productServiceService.getProductServicePort();

        Random random = new Random();
        Integer productId = random.nextInt(100000);

        Product product = new Product();
        product.setProductId(productId);
        product.setDescription("This is the product description");
        OffsetDateTime now = OffsetDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        product.setCreateDate(formatter.format(now));

        Product productResponse = productService.createProduct(product);

        assertEquals(productResponse.getProductId(), productId);
        assertNotNull(productResponse.getDescription());

        productService.createProduct(product);
        fail("we should have gotten an exception!");
    }

    @Test(expected = BadProductNameException_Exception.class)
    @RunAsClient
    public void testNewProductBadDescription(@ArquillianResource URL baseURL) throws Exception {
        ProductServiceService productServiceService = new ProductServiceService(new URL(baseURL.toExternalForm() + "ProductService?wsdl"));

        ProductService productService = productServiceService.getProductServicePort();

        Random random = new Random();
        Integer productId = random.nextInt(100000);

        Product product = new Product();
        product.setProductId(productId);
        product.setDescription("This is the product-description");
        OffsetDateTime now = OffsetDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        product.setCreateDate(formatter.format(now));

        productService.createProduct(product);

        fail("we should have gotten an exception!");
    }

    @Test
    @RunAsClient
    public void testGetProduct(@ArquillianResource URL baseURL) throws Exception {
        ProductServiceService productServiceService = new ProductServiceService(new URL(baseURL.toExternalForm() + "ProductService?wsdl"));

        ProductService productService = productServiceService.getProductServicePort();

        Random random = new Random();
        Integer productId = random.nextInt(100000);

        Product product = new Product();
        product.setProductId(productId);
        product.setDescription("This is the product description");
        OffsetDateTime now = OffsetDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        product.setCreateDate(formatter.format(now));

        Product productResponse = productService.createProduct(product);

        assertEquals(productResponse.getProductId(), productId);
        assertNotNull(productResponse.getDescription());

        GetProductRequest getProductRequest = new GetProductRequest();
        getProductRequest.setProductId(productId);

        Product productReturned = productService.getProduct(getProductRequest);

        assertEquals(productReturned.getProductId(), productId);
        assertNotNull(productReturned.getDescription());
    }

    @Test(expected= ProductNotFoundException_Exception.class)
    @RunAsClient
    public void testGetBadProductId(@ArquillianResource URL baseURL) throws Exception {
        ProductServiceService productServiceService = new ProductServiceService(new URL(baseURL.toExternalForm() + "ProductService?wsdl"));

        ProductService productService = productServiceService.getProductServicePort();

        GetProductRequest getProductRequest = new GetProductRequest();
        getProductRequest.setProductId(1234);

        productService.getProduct(getProductRequest);

        fail("we should have gotten an exception!");
    }
}
