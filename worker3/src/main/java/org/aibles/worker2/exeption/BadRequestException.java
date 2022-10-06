package org.aibles.worker2.exeption;

import org.springframework.http.HttpStatus;


public class BadRequestException extends Exception {
    public BadRequestException(String message, HttpStatus httpStatus){
        super(message,httpStatus);
    }
}
