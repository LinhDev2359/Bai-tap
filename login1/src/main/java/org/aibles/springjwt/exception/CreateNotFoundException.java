package org.aibles.springjwt.exception;

import org.springframework.http.HttpStatus;

public class CreateNotFoundException extends BaseExceptionRequest{

  public CreateNotFoundException(String message) {
    setStatusException(HttpStatus.NOT_FOUND.value());
    setCode("org.aibles.springjwt.exception.ResourceNotFoundException");
    addParams("message", message);
  }
}
