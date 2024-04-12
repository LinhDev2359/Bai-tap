package org.aibles.user_profile.exception;


public class GenderInvalidBaseException extends BaseException {

  public GenderInvalidBaseException(String gender) {
    setCode("org.aibles.user_profile.exception.GenderInvalidException");
    setStatus(400);
    addParams("Gender incorrect", gender);
  }
}
