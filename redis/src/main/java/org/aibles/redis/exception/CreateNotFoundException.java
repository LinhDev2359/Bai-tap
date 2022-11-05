package org.aibles.redis.exception;

import org.springframework.http.HttpStatus;

public class CreateNotFoundException extends BaseExceptionRequest{

  public CreateNotFoundException(String message) {
    setStatusException(HttpStatus.NOT_FOUND.value());
    setCode("org.aibles.redis.exception.CreateNotFoundException");
    addParams("message", message);
  }
}
