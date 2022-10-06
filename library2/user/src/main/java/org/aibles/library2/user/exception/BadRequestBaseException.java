package org.aibles.library2.user.exception;

import org.springframework.http.HttpStatus;


public class BadRequestBaseException extends BaseExceptionRequest {
    public BadRequestBaseException(Object setData) {
        setStatusException(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.validator.exception.BadRequestBaseException");
        addParams("500: INTERNAL SERVER ERROR!!!", setData);
    }


}
