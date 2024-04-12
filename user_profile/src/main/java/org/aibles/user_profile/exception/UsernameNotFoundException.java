package org.aibles.user_profile.exception;

public class UsernameNotFoundException extends BaseException{

  public UsernameNotFoundException(String username) {
    setCode("org.aibles.user_profile.exception.UsernameNotFoundException");
    setStatus(404);
    addParams("Username does not exist", username);
  }
}
