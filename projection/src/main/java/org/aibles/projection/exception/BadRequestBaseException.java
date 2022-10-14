package org.aibles.projection.exception;

import org.springframework.http.HttpStatus;


public class BadRequestBaseException extends BaseExceptionRequest {
    public BadRequestBaseException(long id) {
        setStatusException(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.projection.exception.ResourceNotFoundException");
        addParams("id", id);
    }
}
