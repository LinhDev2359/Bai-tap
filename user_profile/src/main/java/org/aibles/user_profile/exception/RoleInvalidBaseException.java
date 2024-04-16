package org.aibles.user_profile.exception;

public class RoleInvalidBaseException extends BaseException{

  public RoleInvalidBaseException(String role) {
    setCode("org.aibles.user_profile.exception.RoleInvalidBaseException");
    setStatus(400);
    addParams("Role incorrect", role);
  }
}
