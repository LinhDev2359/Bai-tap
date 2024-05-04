package org.aibles.user_profile.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.aibles.user_profile.validation.ValidateEmail;

public class ResetPasswordRequest {

  @NotBlank(message = "Secret key cannot blank")
  private String secretKey;
  @NotBlank(message = "Email cannot blank")
  @ValidateEmail
  private String email;
  @NotBlank(message = "Password cannot blank")
  private String password;
  @NotBlank(message = "Confirm password cannot blank")
  private String confirmPassword;

  public String getSecretKey() {
    return secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }
}
