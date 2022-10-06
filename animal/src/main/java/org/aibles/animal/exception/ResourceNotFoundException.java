package org.aibles.animal.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ExceptionRequest {

  public ResourceNotFoundException(long id) {
    setCode("org.aibles.animal.exception.ResourceNotFoundException");
    setStatus(HttpStatus.BAD_REQUEST.value());
    addParams("id", id);
  }
}
