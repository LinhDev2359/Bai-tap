package org.aibles.user_profile.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.aibles.user_profile.validation.ValidateEmail;

public class VerifyOtpRequest {

  @NotBlank(message = "Email cannot blank")
  @ValidateEmail
  private String email;
  @NotBlank(message = "Otp cannot blank")
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
