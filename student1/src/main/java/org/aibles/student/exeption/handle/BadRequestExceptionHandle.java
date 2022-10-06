package org.aibles.student.exeption.handle;

import lombok.extern.slf4j.Slf4j;
import org.aibles.student.exeption.BadRequestException;
import org.aibles.student.exeption.reponse.ExceptionReponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
@Slf4j
public class BadRequestExceptionHandle {
    @ExceptionHandler(BadRequestException.class)

    public ExceptionReponse badRequestExceptionHandle(BadRequestException e) {
        log.info("Exception: error{}, message: {}", HttpStatus.BAD_REQUEST.value(), e.getMessage());
        ExceptionReponse exceptionResponse = new ExceptionReponse();
        exceptionResponse.setError("Bad Error!!!");
        exceptionResponse.setMessage(e.getMessage());
        exceptionResponse.setTimeStamp(Instant.now());
        return exceptionResponse;
    }
}
