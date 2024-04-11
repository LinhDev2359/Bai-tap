package org.aibles.user_profile.exception;

public class PostIdNotFoundException extends BaseException{

  public PostIdNotFoundException(String id) {
    setCode("org.aibles.user_profile.exceptionn.PostNotFoundException");
    setStatus(404);
    addParams("Post id does not exist", id);
  }
}
