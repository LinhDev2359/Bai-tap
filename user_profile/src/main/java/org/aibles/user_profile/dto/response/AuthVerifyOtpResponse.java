package org.aibles.user_profile.dto.response;

import org.aibles.user_profile.entity.Post;

public class AuthVerifyOtpResponse {

  private String secretKey;

  public String getSecretKey() {
    return secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
  }

  public static AuthVerifyOtpResponse from(String secretKey) {
    AuthVerifyOtpResponse response = new AuthVerifyOtpResponse();
    response.setSecretKey(secretKey);
    return response;
  }
}


