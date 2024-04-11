package org.aibles.user_profile.controller.advice;

import java.time.Instant;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.exception.BaseException;
import org.aibles.user_profile.exception.response.ExceptionResponse;
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
    log.info("(exceptionHandle)exception: {}", error);
    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setError(String.valueOf(error.getStatus()));
    exceptionResponse.setMessage(error.getParams().toString());
    exceptionResponse.setTimestamp(Instant.now());
    return ResponseEntity.status(HttpStatus.valueOf(error.getStatus())).body(exceptionResponse);
  }

  @ExceptionHandler(value = {MethodArgumentNotValidException.class})
  public ExceptionResponse validationExceptionHandle(MethodArgumentNotValidException exception) {
    log.info("(Validation)");
    String errorMessage = exception.getBindingResult().getFieldErrors().stream()
        .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
        .collect(Collectors.joining(", "));

    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setError("Validation Exception");
    exceptionResponse.setMessage(errorMessage);
    exceptionResponse.setTimestamp(Instant.now());

    return exceptionResponse;
  }
}
