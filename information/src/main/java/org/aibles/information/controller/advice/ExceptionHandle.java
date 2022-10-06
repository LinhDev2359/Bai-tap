package org.aibles.information.controller.advice;

import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.aibles.information.exception.BaseException;
import org.aibles.information.exception.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandle {

  @ExceptionHandler(value = {BaseException.class})
  public ResponseEntity<ExceptionResponse> exceptionHandle(BaseException error) {
    log.info("(Exception)exception: {}", error);
    ExceptionResponse exception = new ExceptionResponse();
    exception.setError("Exception");
    exception.setMessage(error.getMessage());
    exception.setTimestamp(Instant.now());
    return ResponseEntity.status(HttpStatus.valueOf(error.getStatus())).body(exception);
  }

  @ExceptionHandler(value = {MethodArgumentNotValidException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse validationExceptionHandle() {
    log.info("(Validation)");
    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setError("Exception");
    exceptionResponse.setMessage("Error input");
    exceptionResponse.setTimestamp(Instant.now());
    return exceptionResponse;
  }
}
