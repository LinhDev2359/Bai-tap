package org.aibles.okr.exception;

import org.springframework.http.HttpStatus;


public class BadRequestException extends ExceptionRequest {
    public BadRequestException(long id) {
        setStatusException(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.student.exception.ResourceNotFoundExceptionound");
        addParams("id", id);
    }
}
