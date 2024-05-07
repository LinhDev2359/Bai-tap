package org.aibles.user_profile.exception;

public class SecretKeyInvalidException extends BaseException{

  public SecretKeyInvalidException() {
    setCode("org.aibles.user_profile.exception.SecretKeyInvalidException");
    setStatus(400);
  }
}
