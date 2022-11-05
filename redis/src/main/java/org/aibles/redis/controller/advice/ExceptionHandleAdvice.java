package org.aibles.redis.controller.advice;

import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.aibles.redis.exception.BaseExceptionRequest;
import org.aibles.redis.exception.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandleAdvice {

  @ExceptionHandler(value = {BaseExceptionRequest.class})
  public ResponseEntity<ExceptionResponse> exceptionHandle(
      BaseExceptionRequest error) {
    log.info("(Exception)exception: {}", error.getCode());
    ExceptionResponse response = new ExceptionResponse();
    response.setError("Exception");
    response.setMessage(error.getMessage());
    response.setTimestamp(Instant.now());
    return new ResponseEntity<>(response, HttpStatus.valueOf(error.getStatusException()));
  }

  @ExceptionHandler(value = {MethodArgumentNotValidException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse validationExceptionHandle() {
    log.info("(Validation)");
    ExceptionResponse response = new ExceptionResponse();
    response.setError("Exception");
    response.setMessage("Error input");
    response.setTimestamp(Instant.now());
    return response;
  }
}

