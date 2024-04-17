package org.aibles.user_profile.exception;

public class PasswordNotMatchesException extends BaseException{

  public PasswordNotMatchesException(String password) {
    setCode("org.aibles.user_profile.exception.PasswordNotMatchesException");
    setStatus(400);
    addParams("Password is not matches", password);
  }
}
