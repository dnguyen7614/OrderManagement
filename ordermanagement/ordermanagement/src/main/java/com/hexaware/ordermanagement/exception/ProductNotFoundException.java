package com.hexaware.ordermanagement.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String message){
        super("Product Not Found");
    }
}
