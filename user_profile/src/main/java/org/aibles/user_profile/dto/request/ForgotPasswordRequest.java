package org.aibles.user_profile.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.aibles.user_profile.validation.ValidateEmail;

public class ForgotPasswordRequest {

  @NotBlank(message = "Email cannot blank")
  @ValidateEmail
  private String email;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
