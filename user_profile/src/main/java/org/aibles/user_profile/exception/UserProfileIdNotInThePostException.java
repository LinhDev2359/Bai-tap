package org.aibles.user_profile.exception;

public class UserProfileIdNotInThePostException extends BaseException{

  public UserProfileIdNotInThePostException(String userProfileId, String id) {
    setCode("org.aibles.user_profile.exceptionn.UserProfileIdNotInThePostException");
    setStatus(404);
    addParams("userProfileId", userProfileId);
    addParams("id", id);
  }
}
