package com.hexaware.ordermanagement.exception;


public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String message){
        super("Order Not Found");
    }
}
