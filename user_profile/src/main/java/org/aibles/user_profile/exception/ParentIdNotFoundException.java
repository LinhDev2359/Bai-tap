package org.aibles.user_profile.exception;

public class ParentIdNotFoundException extends BaseException{

  public ParentIdNotFoundException(String id) {
    setCode("org.aibles.user_profile.exception.ParentIdNotFoundException");
    setStatus(404);
    addParams("Parent id does not exist", id);
  }
}
