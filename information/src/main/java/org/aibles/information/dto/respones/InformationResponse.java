package org.aibles.information.dto.respones;

import java.sql.Date;
import org.aibles.information.entity.Information;

public class InformationResponse {

  private long id;
  private String firstname;
  private String lastname;
  private String email;
  private String numberPhone;
  private Date dateOfBirth;
  private String address;

  public InformationResponse() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public static InformationResponse from(Information information) {
    InformationResponse response = new InformationResponse();
    response.setId(information.getId());
    response.setFirstname(information.getFirstname());
    response.setLastname(information.getLastname());
    response.setEmail(information.getEmail());
    response.setNumberPhone(information.getNumberPhone());
    response.setDateOfBirth(information.getDateOfBirth());
    response.setAddress(information.getAddress());
    return response;
  }
}
