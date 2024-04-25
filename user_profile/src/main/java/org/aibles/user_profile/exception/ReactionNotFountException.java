package org.aibles.user_profile.exception;

public class ReactionNotFountException extends BaseException{

  public ReactionNotFountException(String id) {
    setCode("org.aibles.user_profile.exception.ReactionNotFountException");
    setStatus(404);
    addParams("Reaction id does not exist: ", id);
  }
}
