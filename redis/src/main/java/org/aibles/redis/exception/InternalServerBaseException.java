package org.aibles.redis.exception;

import org.springframework.http.HttpStatus;

public class InternalServerBaseException extends BaseExceptionRequest {

    public InternalServerBaseException(long id) {
        setStatusException(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.redis.exception.InternalServerBaseException");
        addParams("id", id);
    }

}
