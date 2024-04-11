package org.aibles.user_profile.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistedException extends BaseException{

  public EmailAlreadyExistedException(String email) {
    setCode("org.aibles.user_profile.exceptionn.EmailAlreadyExistedException");
    setStatus(409);
    addParams("Email already exist", email);
  }
}
