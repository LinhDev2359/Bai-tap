package org.aibles.user_profile.exception;

public class UnauthorizedReactionDeletionException extends BaseException{

  public UnauthorizedReactionDeletionException() {
    setCode("org.aibles.user_profile.exception.UnauthorizedReactionDeletionException");
    setStatus(403);
    addParams("Do not have the right to delete other people's reaction posts", "");
  }
}
