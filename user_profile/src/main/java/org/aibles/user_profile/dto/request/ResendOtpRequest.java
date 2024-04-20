package org.aibles.user_profile.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aibles.user_profile.validation.ValidateEmail;

@Data
@NoArgsConstructor
public class ResendOtpRequest {
  @NotBlank(message = "Email can't be left blank")
  @ValidateEmail
  private String email;
}
