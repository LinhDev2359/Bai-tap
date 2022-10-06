package org.aibles.message2.dto.request;

import java.sql.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.aibles.message2.entity.User;
import org.aibles.message2.validation.BaseValidator;



public class CreateUserRequest extends BaseValidator<CreateUserRequest> {

  @NotBlank(message = "email.NotBlank.message")
  @Email
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

  public CreateUserRequest() {
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
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
