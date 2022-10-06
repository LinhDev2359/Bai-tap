package org.aibles.message2.dto.response;

import java.sql.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.aibles.message2.entity.User;
import org.aibles.message2.validation.BaseValidator;


public class UserResponse extends BaseValidator<UserResponse> {

  @NotNull(message = "id.NotNull.message")
  private long id;
  @NotBlank(message = "email.NotBlank.message")
  private String email;
  @NotBlank(message = "password.NotBlank.message")
  private String password;
  @NotBlank(message = "firstname.NotBlank.message")
  private String firstname;
  @NotBlank(message = "lastname.NotBlank.message")
  private String lastname;
  @NotBlank(message = "numberPhone.NotBlank.message")
  private String numberPhone;
  @NotNull(message = "dateOfBirth.NotNull.message")
  private Date dateOfBirth;
  @NotBlank(message = "address.NotBlank.message")
  private String address;

  public UserResponse() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public static UserResponse from(User user) {
    UserResponse response = new UserResponse();
    response.setId(user.getId());
    response.setEmail(user.getEmail());
    response.setPassword(user.getPassword());
    response.setFirstname(user.getFirstname());
    response.setLastname(user.getLastname());
    response.setNumberPhone(user.getNumberPhone());
    response.setDateOfBirth(user.getDateOfBirth());
    response.setAddress(user.getAddress());
    return response;

  }
}
