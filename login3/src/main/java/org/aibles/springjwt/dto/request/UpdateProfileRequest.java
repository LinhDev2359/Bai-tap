package org.aibles.springjwt.dto.request;

import javax.validation.constraints.NotBlank;
import org.aibles.springjwt.entity.User;

public class UpdateProfileRequest extends ProfileRequest{

  private long id;
  @NotBlank
  private String password;

  @NotBlank
  private String firstname;

  @NotBlank
  private String lastname;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public User toUser() {
    User user = new User();
    user.setId(this.getId());
    user.setPassword(this.getPassword());
    user.setFirstname(this.getFirstname());
    user.setLastname(this.getLastname());
    user.setNumberPhone(this.getNumberPhone());
    user.setDateOfBirth(this.getDateOfBirth());
    user.setAddress(this.getAddress());
    return user;
  }
}
