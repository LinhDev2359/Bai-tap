package org.aibles.information.exception;

import org.springframework.http.HttpStatus;


public class InternalServerException extends BaseException {

    public InternalServerException(long id) {
        setStatus(HttpStatus.NOT_FOUND.value());
        setCode("org.aibles.student.exception.InternalServerException");
        addParams("id", id);
    }

}
