package orrg.aibles.user.dto.request;

import java.sql.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import orrg.aibles.user.entity.User;


public class CreateUserRequest {

  @NotBlank
  @Email
  private String email;
  @NotBlank
  private String password;
  @NotBlank
  private String firstname;
  @NotBlank
  private String lastname;
  @NotBlank
  private String numberPhone;
  private Date dateOfBirth;
  @NotBlank
  private String address;

  public CreateUserRequest() {
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

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

  public String getNumberPhone() {
    return numberPhone;
  }

  public void setNumberPhone(String numberPhone) {
    this.numberPhone = numberPhone;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public User toUser() {
    User user = new User();
    user.setEmail(this.getEmail());
    user.setPassword(this.getPassword());
    user.setFirstname(this.getFirstname());
    user.setLastname(this.getLastname());
    user.setNumberPhone(this.getNumberPhone());
    user.setDateOfBirth(this.getDateOfBirth());
    user.setAddress(this.getAddress());
    return user;
  }
}
