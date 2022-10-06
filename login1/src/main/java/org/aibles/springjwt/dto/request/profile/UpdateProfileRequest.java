package org.aibles.springjwt.dto.request.profile;

import java.sql.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.aibles.springjwt.entity.User;

public class UpdateProfileRequest {

  @NotBlank
  private String numberPhone;

  @NotNull
  private Date dateOfBirth;

  @NotBlank
  private String address;

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNumberPhone() {
    return numberPhone;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public String getAddress() {
    return address;
  }

  public void setNumberPhone(String numberPhone) {
    this.numberPhone = numberPhone;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public User toUser(User user) {
    User userUpdate = new User();
    userUpdate.setId(user.getId());
    userUpdate.setPassword(user.getPassword());
    userUpdate.setEmail(user.getEmail());
    userUpdate.setFirstName(this.getFirstName());
    userUpdate.setLastName(this.getLastName());
    userUpdate.setNumberPhone(this.getNumberPhone());
    userUpdate.setDateOfBirth(this.getDateOfBirth());
    userUpdate.setAddress(this.getAddress());
    userUpdate.setCreatedAt(user.getCreatedAt());
    return userUpdate;
  }
}
