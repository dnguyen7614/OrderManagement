package com.hexaware.ordermanagement.exception;

public class EmailNotFoundException extends Throwable {


    public EmailNotFoundException(String message){
        super("Email Not Found");
    }
}
