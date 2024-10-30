package org.iesch.ad.rest1.excepciones;

public class ProductNotFoundException extends RuntimeException {
    ProductNotFoundException(String msg){
        super(msg);
    }
}
