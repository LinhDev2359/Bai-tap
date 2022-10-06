package orrg.aibles.user.exception;

import org.springframework.http.HttpStatus;


public class BadRequestBaseException extends BaseExceptionRequest {
    public BadRequestBaseException(long id) {
        setStatusException(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.student.exception.ResourceNotFoundExceptionound");
        addParams("id", id);
    }
}
