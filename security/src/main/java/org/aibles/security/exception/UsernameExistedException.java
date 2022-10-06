package org.aibles.security.exception;

import org.springframework.http.HttpStatus;

public class UsernameExistedException extends BaseExceptionRequest{

  public UsernameExistedException(Object setData) {
    setStatusException(HttpStatus.NOT_FOUND.value());
    setCode("org.aibles.security.exception.BadRequestBaseException");
    addParams("500: INTERNAL SERVER ERROR!!!", setData);
  }
}
