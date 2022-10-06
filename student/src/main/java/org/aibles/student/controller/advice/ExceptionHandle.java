package org.aibles.student.controller.advice;

import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.aibles.student.exception.ExceptionRequest;
import org.aibles.student.exception.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandle {

  @ExceptionHandler(value = {ExceptionRequest.class})
  public ResponseEntity<ExceptionResponse> exceptionHandle(ExceptionRequest error) {
    log.info("(Exception)exception: {}", error);
    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setError("Exception");
    exceptionResponse.setMessage(error.getMessage());
    exceptionResponse.setTimestamp(Instant.now());
    return ResponseEntity.status(HttpStatus.valueOf(error.getStatus())).body(exceptionResponse);
  }

}
