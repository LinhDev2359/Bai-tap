package org.aibles.user_profile.exception;

public class UserProfileIdNotFoundException extends BaseException{

  public UserProfileIdNotFoundException(String id) {
    setCode("org.aibles.user_profile.exceptionn.UserProfileIdNotFoundException");
    setStatus(404);
    addParams("User profile id does not exist", id);
  }
}
