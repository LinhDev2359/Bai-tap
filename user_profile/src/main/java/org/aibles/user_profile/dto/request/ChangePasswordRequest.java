package org.aibles.user_profile.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class ChangePasswordRequest {

  @NotBlank(message = "oldPassword can't be left blank")
  private String oldPassword;
  @NotBlank(message = "newPassword can't be left blank")
  @Length(min = 8, message = "Length of newPassword must greater than 7")
  private String newPassword;
  @NotBlank(message = "confirmNewPassword can't be left blank")
  private String confirmNewPassword;

  public String getOldPassword() {
    return oldPassword;
  }

  public void setOldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  public String getConfirmNewPassword() {
    return confirmNewPassword;
  }

  public void setConfirmNewPassword(String confirmNewPassword) {
    this.confirmNewPassword = confirmNewPassword;
  }
}
