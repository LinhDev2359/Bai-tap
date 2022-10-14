package org.aibles.projection.exception;

import org.springframework.http.HttpStatus;


public class NotFoundBaseException extends BaseExceptionRequest {
    public NotFoundBaseException(long id) {
        setStatusException(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.projection.exception.ResourceNotFoundException");
        addParams("id", id);
    }
}
