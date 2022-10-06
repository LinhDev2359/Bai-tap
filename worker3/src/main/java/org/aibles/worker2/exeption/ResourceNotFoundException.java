package org.aibles.worker2.exeption;

import org.springframework.http.HttpStatus;


public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String message, HttpStatus httpStatus){
        super(message,httpStatus);
    }
}
