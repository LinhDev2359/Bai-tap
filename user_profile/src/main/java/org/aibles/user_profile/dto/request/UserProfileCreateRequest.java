package org.aibles.user_profile.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.constant.Gender;
import org.aibles.user_profile.exception.GenderInvalidBaseException;
import org.aibles.user_profile.validation.ValidateDate;
import org.aibles.user_profile.validation.ValidateEmail;
import org.aibles.user_profile.validation.ValidatePhone;

@Slf4j
public class UserProfileCreateRequest {

  @NotBlank(message = "First name cannot blank")
  private String firstName;
  @NotBlank(message = "Last name cannot blank")
  private String lastName;
  private String gender;
  @ValidateDate
  private int dateOfBirth;
  @ValidatePhone
  private String phone;
  @ValidateEmail
  private String email;
  @NotBlank(message = "Address cannot blank")
  private String address;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public int getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(int dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void validateGender() {
    Gender[] genders = Gender.values();
    boolean isValid = false;

    for (Gender genderValue : genders) {
      if (genderValue.name().equals(this.gender)) {
        isValid = true;
        break;
      }
    }

    if (!isValid) {
      log.error("(validateGender)gender: {} invalid", this.gender);
      throw new GenderInvalidBaseException(gender);
    }
  }
}
