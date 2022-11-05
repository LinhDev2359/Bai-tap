package org.aibles.redis.exception;

import org.springframework.http.HttpStatus;

public class BadRequestBaseException extends BaseExceptionRequest {
    public BadRequestBaseException(long id) {
        setStatusException(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.redis.exception.BadRequestBaseException");
        addParams("id", id);
    }
}
