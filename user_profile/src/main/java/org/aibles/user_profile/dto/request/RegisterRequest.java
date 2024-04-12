package org.aibles.user_profile.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.aibles.user_profile.validation.ValidateEmail;

public class RegisterRequest {

  @NotBlank(message = "Username cannot blank")
  private String username;
  @NotBlank(message = "Password cannot blank")
  private String password;
  @ValidateEmail
  private String email;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
