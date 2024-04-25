package org.aibles.user_profile.exception;

public class TypeAlreadyExistedException extends BaseException{

  public TypeAlreadyExistedException(String type) {
    setCode("org.aibles.user_profile.exception.TypeAlreadyExistedException");
    setStatus(409);
    addParams("Type already exist: ", type);
  }
}
