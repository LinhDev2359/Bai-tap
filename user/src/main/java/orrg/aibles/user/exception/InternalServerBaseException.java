package orrg.aibles.user.exception;

import org.springframework.http.HttpStatus;


public class InternalServerBaseException extends BaseExceptionRequest {
    public InternalServerBaseException(long id) {
        setStatusException(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.student.exception.ResourceNotFoundExceptionound");
        addParams("id", id);
    }

}
