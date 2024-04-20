package org.aibles.user_profile.dto.response;

public class AuthInActiveAccountResponse extends LoginResponse{

  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public static AuthInActiveAccountResponse from(String message) {
    AuthInActiveAccountResponse response = new AuthInActiveAccountResponse();
    response.setMessage(message);
    return response;
  }
}
