package org.aibles.springjwt.dto.response;

public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private long id;
  private String email;

  public JwtResponse(String accessToken, long id, String email) {
    this.token = accessToken;
    this.id = id;
    this.email = email;
  }

  public JwtResponse(String jwt, long id, String email, String firstName, String lastName) {
  }

  public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


}
