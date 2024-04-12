package org.aibles.user_profile.exception;

public class ImageIdNotFoundException extends BaseException{

  public ImageIdNotFoundException(String id) {
    setCode("org.aibles.user_profile.exception.ImageNotFoundException");
    setStatus(404);
    addParams("Image id does not exist", id);
  }
}
