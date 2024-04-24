package org.aibles.user_profile.exception;

public class InternalServerError extends BaseException {

  public InternalServerError() {
    setStatus(500);
    setCode("org.aibles.user_profile.exception.InternalServerError");
  }
}
