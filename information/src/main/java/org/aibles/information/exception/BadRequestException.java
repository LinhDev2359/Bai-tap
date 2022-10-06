package org.aibles.information.exception;

import org.springframework.http.HttpStatus;


public class BadRequestException extends BaseException {

    public BadRequestException(long id) {
        setStatus(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.student.exception.BadRequestException");
        addParams("id", id);
    }
}
