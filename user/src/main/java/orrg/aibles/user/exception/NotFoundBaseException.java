package orrg.aibles.user.exception;

import org.springframework.http.HttpStatus;


public class NotFoundBaseException extends BaseExceptionRequest {
    public NotFoundBaseException(long id) {
        setStatusException(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.student.exception.ResourceNotFoundExceptionound");
        addParams("id", id);
    }
}
