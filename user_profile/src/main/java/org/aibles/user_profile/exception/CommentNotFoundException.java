package org.aibles.user_profile.exception;

public class CommentNotFoundException extends BaseException{

  public CommentNotFoundException(String id) {
    setCode("org.aibles.user_profile.exception.CommentNotFoundException");
    setStatus(404);
    addParams("Comment id does not exist", id);
  }
}
