package org.aibles.user_profile.exception;

public class TypeInvalidBaseException extends BaseException{

  public TypeInvalidBaseException(String type) {
    setCode("org.aibles.user_profile.exception.TypeInvalidBaseException");
    setStatus(400);
    addParams("Type incorrect", type);
  }
}
