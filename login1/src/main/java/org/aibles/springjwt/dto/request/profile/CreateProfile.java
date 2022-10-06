package org.aibles.springjwt.dto.request.profile;

import java.sql.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.aibles.springjwt.entity.User;

public class CreateProfile {

  @NotBlank
  private String numberPhone;

  @NotNull
  private Date dateOfBirth;

  @NotBlank
  private String address;

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

  public User toUser(User user) {
    User userUpdate = new User();
    userUpdate.setId(user.getId());
    userUpdate.setEmail(user.getEmail());
    userUpdate.setPassword(user.getPassword());
    userUpdate.setFirstName(user.getFirstName());
    userUpdate.setLastName(user.getLastName());
    userUpdate.setNumberPhone(this.getNumberPhone());
    userUpdate.setDateOfBirth(this.getDateOfBirth());
    userUpdate.setAddress(this.getAddress());
    userUpdate.setCreatedAt(user.getCreatedAt());
    return userUpdate;
  }
}
