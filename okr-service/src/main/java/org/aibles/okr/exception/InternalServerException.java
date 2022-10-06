package org.aibles.okr.exception;

import org.springframework.http.HttpStatus;


public class InternalServerException extends ExceptionRequest {
    public InternalServerException(long id) {
        setStatusException(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.student.exception.ResourceNotFoundExceptionound");
        addParams("id", id);
    }

}
