package org.aibles.user_profile.exception;

public class UsernameAlreadyExistedException extends BaseException{

  public UsernameAlreadyExistedException(String username) {
    setCode("org.aibles.user_profile.exception.UsernameAlreadyExistedException");
    setStatus(409);
    addParams("Username already exist", username);
  }
}
