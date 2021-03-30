package com.hotjoe.services.ws;


import com.hotjoe.services.model.Product;
import com.hotjoe.services.model.exception.BadProductNameException;
import com.hotjoe.services.model.exception.ProductAlreadyExistsException;
import com.hotjoe.services.model.exception.ProductNotFoundException;
import com.hotjoe.services.model.request.GetProductRequest;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * A sample service to demonstrate some simple JAX-WS calls.  This service is
 * meant to simulate a simple catalog - you can add items to the catalog and
 * you can query and get items from the catalog.  For this demo it just keeps
 * a simple Map of product id to Product.
 *
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ProductService {
    private static final Logger logger = Logger.getLogger(ProductService.class.getName());

    //
    // a demo backing store - it could be a db or whatever
    //
    private static final Map<Integer, Product> products = new HashMap<>();

    @WebMethod
    public Product getProduct(GetProductRequest getProductRequest) throws ProductNotFoundException {

        if( products.containsKey(getProductRequest.getProductId()))
            return products.get(getProductRequest.getProductId());

        throw new ProductNotFoundException("productId not found - " + getProductRequest.getProductId());
    }

    @WebMethod
    public Product createProduct(Product product) throws ProductAlreadyExistsException, BadProductNameException {

        logger.log(Level.FINE, "got a create product request");

        if( product.getProductId() == null )
            product.setProductId( ThreadLocalRandom.current().nextInt(10000, 1000000 + 1));
        else if( products.containsKey(product.getProductId()))
            throw new ProductAlreadyExistsException("product id " + product.getProductId() + " already exists");

        //
        // arbitrary business rule to show other exceptions - record description can't have dashes.
        //
        if( (product.getDescription() != null) && product.getDescription().contains("-"))
            throw new BadProductNameException("record description " + product.getDescription() +
                    " is invalid. it cannot contain the minus sign (dash) character");

        logger.log(Level.INFO, "Created product record with description \"" + product.getDescription() + "\"");

        products.put(product.getProductId(), product);

        return product;
    }
}
