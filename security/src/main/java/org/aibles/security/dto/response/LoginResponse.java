package org.aibles.security.dto.response;

import javax.validation.constraints.NotBlank;
import org.aibles.security.entity.Logger;

public class LoginResponse {

  @NotBlank
  private String username;

  @NotBlank
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public static LoginResponse from(Logger logger) {
    LoginResponse response = new LoginResponse();
    response.setUsername(logger.getUsername());
    response.setPassword(logger.getPassword());
    return response;

  }

}
