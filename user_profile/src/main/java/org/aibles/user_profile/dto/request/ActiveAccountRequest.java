package org.aibles.user_profile.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.aibles.user_profile.validation.ValidateEmail;

public class ActiveAccountRequest {

  @NotBlank(message = "email can't be not blank")
  @ValidateEmail
  private String email;
  @NotBlank(message = "otp can't be not blank")
  private String otp;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getOtp() {
    return otp;
  }

  public void setOtp(String otp) {
    this.otp = otp;
  }
}
