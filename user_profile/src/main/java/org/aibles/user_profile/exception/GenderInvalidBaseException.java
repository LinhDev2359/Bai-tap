package org.aibles.user_profile.exception;


public class GenderInvalidBaseException extends BaseException {

  public GenderInvalidBaseException(String gender) {
    setCode("org.aibles.user_profile.exceptionn.GenderInvalidException");
    setStatus(400);
    addParams("Gender incorrect", gender);
  }
}
