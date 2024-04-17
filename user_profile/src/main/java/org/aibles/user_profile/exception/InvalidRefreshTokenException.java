package org.aibles.user_profile.exception;

public class InvalidRefreshTokenException extends BaseException{

  public InvalidRefreshTokenException() {
    this.setStatus(401);
    this.setCode("org.aibles.user_profile.exception.InvalidRefreshTokenException");
  }
}
