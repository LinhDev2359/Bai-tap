package org.aibles.projection.exception;

import org.springframework.http.HttpStatus;

public class CreateNotFoundException extends BaseExceptionRequest{

  public CreateNotFoundException(String message) {
    setStatusException(HttpStatus.NOT_FOUND.value());
    setCode("org.aibles.projection.exception.ResourceNotFoundException");
    addParams("message", message);
  }
}
