package org.aibles.information.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BaseException {

  public ResourceNotFoundException(long id) {
    setStatus(HttpStatus.NOT_FOUND.value());
    setCode("org.aibles.student.exception.ResourceNotFoundException");
    addParams("id", id);
  }
}
