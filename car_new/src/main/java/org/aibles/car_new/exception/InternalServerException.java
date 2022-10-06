package org.aibles.car_new.exception;

import org.springframework.http.HttpStatus;


public class InternalServerException extends BaseException {
    public InternalServerException() {
        setCode("org.aibles.animal.exception.InternalServerException");
        setStatus(HttpStatus.BAD_REQUEST.value());
        addParams("Http", HttpStatus.NOT_FOUND);
    }

}
