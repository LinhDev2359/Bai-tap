package org.aibles.user_profile.dto.response;

import org.aibles.user_profile.entity.Image;

public class LoginResponse {
  private String accessToken;
  private String refreshToken;
  private final String tokenType = "Bearer";
  private long accessTokenLifeTime;
  private long refreshTokenLifeTime;

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public String getTokenType() {
    return tokenType;
  }

  public long getAccessTokenLifeTime() {
    return accessTokenLifeTime;
  }

  public void setAccessTokenLifeTime(long accessTokenLifeTime) {
    this.accessTokenLifeTime = accessTokenLifeTime;
  }

  public long getRefreshTokenLifeTime() {
    return refreshTokenLifeTime;
  }

  public void setRefreshTokenLifeTime(long refreshTokenLifeTime) {
    this.refreshTokenLifeTime = refreshTokenLifeTime;
  }

  public static LoginResponse from(String accessToken, String refreshToken, Long accessTokenLifeTime, Long refreshTokenLifeTime) {
    LoginResponse response = new LoginResponse();
    response.setAccessToken(accessToken);
    response.setRefreshToken(refreshToken);
    response.setAccessTokenLifeTime(accessTokenLifeTime);
    response.setRefreshTokenLifeTime(refreshTokenLifeTime);
    return response;
  }
}
