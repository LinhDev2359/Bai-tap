package org.aibles.user_profile.exception;

public class BadRequestException extends BaseException{

  public BadRequestException() {
    setCode("org.aibles.user_profile.exception.BadRequestException");
    setStatus(400);
  }
}
