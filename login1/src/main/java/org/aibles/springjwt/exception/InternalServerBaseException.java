package org.aibles.springjwt.exception;

import org.springframework.http.HttpStatus;


public class InternalServerBaseException extends BaseExceptionRequest {
    public InternalServerBaseException(long id) {
        setStatusException(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.springjwt.exception.ResourceNotFoundException");
        addParams("id", id);
    }

}
