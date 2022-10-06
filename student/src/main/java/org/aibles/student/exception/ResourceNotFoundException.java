package org.aibles.student.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ExceptionRequest {

  public ResourceNotFoundException(long id) {
    setStatus(HttpStatus.NOT_FOUND.value());
    setCode("org.aibles.student.exception.ResourceNotFoundException");
    addParams("id", id);
  }
}
