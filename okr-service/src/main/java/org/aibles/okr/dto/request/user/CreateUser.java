package org.aibles.okr.dto.request.user;

import java.sql.Date;
import java.time.Instant;
import javax.validation.constraints.NotBlank;
import org.aibles.okr.entity.User;

public class CreateUser {

  @NotBlank
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

  private Instant createdAt;
  private Instant updatedAt;

  public CreateUser() {
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
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
    user.setCreatedAt(this.getCreatedAt());
    user.setUpdatedAt(this.getUpdatedAt());
    return user;
  }
}
