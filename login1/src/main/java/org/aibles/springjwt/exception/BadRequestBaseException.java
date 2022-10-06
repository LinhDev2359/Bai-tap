package org.aibles.springjwt.exception;

import org.springframework.http.HttpStatus;


public class BadRequestBaseException extends BaseExceptionRequest {
    public BadRequestBaseException(long id) {
        setStatusException(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.springjwt.exception.ResourceNotFoundException");
        addParams("id", id);
    }
}
