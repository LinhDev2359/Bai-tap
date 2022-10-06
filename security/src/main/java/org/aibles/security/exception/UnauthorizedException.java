package org.aibles.security.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends BaseExceptionRequest{

  public UnauthorizedException() {
    super();
    setCode("org.aibles.interceptordemo.exception.UnauthorizedException");
    setStatusException(HttpStatus.UNAUTHORIZED.value());
  }
}
