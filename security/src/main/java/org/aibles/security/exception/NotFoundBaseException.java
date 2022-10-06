package org.aibles.security.exception;

import org.springframework.http.HttpStatus;


public class NotFoundBaseException extends BaseExceptionRequest {
    public NotFoundBaseException(Object setData) {
        setStatusException(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.security.exception.NotFoundBaseException");
        addParams("400: BAD REQUEST!!!", setData);
    }
}
