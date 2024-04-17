package org.aibles.user_profile.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.constant.Gender;
import org.aibles.user_profile.constant.Role;
import org.aibles.user_profile.exception.GenderInvalidBaseException;
import org.aibles.user_profile.exception.RoleInvalidBaseException;
import org.aibles.user_profile.validation.ValidateEmail;

@Slf4j
public class RegisterRequest {

  @NotBlank(message = "Username cannot blank")
  private String username;
  @NotBlank(message = "Password cannot blank")
  private String password;
  @ValidateEmail
  private String email;
  @NotBlank(message = "Role cannot blank")
  private String role;

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

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public void validateRole() {
    Role[] roles = Role.values();
    boolean isValid = false;

    for (Role genderValue : roles) {
      if (genderValue.name().equals(this.role)) {
        isValid = true;
        break;
      }
    }

    if (!isValid) {
      log.error("(validateRole)role: {} invalid", this.role);
      throw new RoleInvalidBaseException(role);
    }
  }
}
