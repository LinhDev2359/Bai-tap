package org.aibles.user_profile.exception;

public class TitleAlreadyExistedException extends BaseException{

  public TitleAlreadyExistedException(String title) {
    setCode("org.aibles.user_profile.exceptionn.TitleAlreadyExistedException");
    setStatus(409);
    addParams("Title already exist", title);
  }
}
