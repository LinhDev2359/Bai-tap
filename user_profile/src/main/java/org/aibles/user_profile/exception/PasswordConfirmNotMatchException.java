package org.aibles.user_profile.exception;

public class PasswordConfirmNotMatchException extends BaseException{

  public PasswordConfirmNotMatchException() {
    setCode("org.aibles.user_profile.exception.PasswordConfirmNotMatchException");
    setStatus(400);
  }
}
