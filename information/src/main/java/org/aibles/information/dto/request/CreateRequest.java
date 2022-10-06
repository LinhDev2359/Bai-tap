package org.aibles.information.dto.request;

import java.sql.Date;
import javax.validation.constraints.NotBlank;
import org.aibles.information.entity.Information;

public class CreateRequest {


  @NotBlank
  private String firstname;

  @NotBlank
  private String lastname;

  @NotBlank
  private String email;

  @NotBlank
  private String numberPhone;

  private Date dateOfBirth;

  @NotBlank
  private String address;

  public CreateRequest() {
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public Information toInformation() {
    Information information = new Information();
    information.setFirstname(this.getFirstname());
    information.setLastname(this.getLastname());
    information.setEmail(this.getEmail());
    information.setNumberPhone(this.getNumberPhone());
    information.setDateOfBirth(this.getDateOfBirth());
    information.setAddress(this.getAddress());
    return information;
  }
}
