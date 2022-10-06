package org.aibles.springjwt.exception;

import org.springframework.http.HttpStatus;


public class NotFoundBaseException extends BaseExceptionRequest {
    public NotFoundBaseException(long id) {
        setStatusException(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.springjwt.exception.ResourceNotFoundException");
        addParams("id", id);
    }
}
