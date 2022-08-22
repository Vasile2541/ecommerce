package com.java.ecommerce.exceptions.customExceptions;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException(String message) {
        super(message);
    }
}
