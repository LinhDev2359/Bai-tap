package org.aibles.worker2.exeption;

import org.springframework.http.HttpStatus;


public class InternalServerException extends Exception {
    public InternalServerException(String message, HttpStatus httpStatus){
        super(message,httpStatus);
    }

}
