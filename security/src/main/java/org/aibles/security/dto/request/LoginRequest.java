package org.aibles.security.dto.request;

import org.aibles.security.entity.Logger;

public class LoginRequest {

  private String username;
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

  public Logger toLogger() {
    Logger logger = new Logger();
    logger.setUsername(this.getUsername());
    logger.setPassword(this.getPassword());
    return logger;
  }

}
