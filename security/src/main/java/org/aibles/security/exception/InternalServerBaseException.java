package org.aibles.security.exception;

import org.springframework.http.HttpStatus;


public class InternalServerBaseException extends BaseExceptionRequest {
    public InternalServerBaseException() {
        setStatusException(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.security.exception.InternalServerBaseException");
    }

}
