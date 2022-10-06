package org.aibles.springjwt.dto.response;

import java.sql.Date;
import java.time.Instant;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.aibles.springjwt.dto.request.ProfileRequest;
import org.aibles.springjwt.entity.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class ProfileResponse {

  private long id;
  private String password;
  private String firstname;
  private String lastname;
  private String numberPhone;
  private Date dateOfBirth;
  private String address;
  private Instant createdAt;
  private Instant updatedAt;

  public String getNumberPhone() {
    return numberPhone;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public String getAddress() {
    return address;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
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

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public static ProfileResponse from(User user) {
    ProfileResponse response = new ProfileResponse();
    response.setId(user.getId());
    response.setFirstname(user.getFirstname());
    response.setLastname(user.getLastname());
    response.setPassword(user.getPassword());
    response.setNumberPhone(user.getNumberPhone());
    response.setDateOfBirth(user.getDateOfBirth());
    response.setAddress(user.getAddress());
    response.setCreatedAt(user.getCreatedAt());
    response.setUpdatedAt(user.getUpdatedAt());
    return response;

  }
}
