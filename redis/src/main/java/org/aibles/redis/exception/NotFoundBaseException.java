package org.aibles.redis.exception;

import org.springframework.http.HttpStatus;

public class NotFoundBaseException extends BaseExceptionRequest {
    public NotFoundBaseException(long id) {
        setStatusException(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.redis.exception.NotFoundBaseException");
        addParams("id", id);
    }
}
