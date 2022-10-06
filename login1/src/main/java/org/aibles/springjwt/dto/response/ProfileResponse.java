package org.aibles.springjwt.dto.response;

import java.sql.Date;
import java.time.Instant;
import javax.persistence.Column;
import org.aibles.springjwt.entity.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class ProfileResponse {

  private String email;
  private String firstName;
  private String lastName;
  private String numberPhone;
  private Date dateOfBirth;
  private String address;
  private Instant createdAt;
  private Instant updatedAt;

  public ProfileResponse() {
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


  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public static ProfileResponse from(User user) {
    ProfileResponse response = new ProfileResponse();
    response.setEmail(user.getEmail());
    response.setFirstName(user.getFirstName());
    response.setLastName(user.getLastName());
    response.setNumberPhone(user.getNumberPhone());
    response.setDateOfBirth(user.getDateOfBirth());
    response.setAddress(user.getAddress());
    response.setCreatedAt(user.getCreatedAt());
    response.setUpdatedAt(user.getUpdatedAt());
    return response;

  }
}
