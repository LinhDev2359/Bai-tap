package org.aibles.user_profile.exception;

public class EmailNotFoundException extends BaseException{

  public EmailNotFoundException(String email) {
    setCode("org.aibles.user_profile.exception.EmailNotFoundException");
    setStatus(404);
    addParams("Email not found: ", email);
  }
}
