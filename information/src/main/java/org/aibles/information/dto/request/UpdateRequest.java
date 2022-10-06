package org.aibles.information.dto.request;

import org.aibles.information.entity.Information;

public class UpdateRequest extends CreateRequest{

  private long id;

  public UpdateRequest() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Information toInformation() {
    Information information = new Information();
    information.setId(this.getId());
    information.setFirstname(this.getFirstname());
    information.setLastname(this.getLastname());
    information.setEmail(this.getEmail());
    information.setNumberPhone(this.getNumberPhone());
    information.setDateOfBirth(this.getDateOfBirth());
    information.setAddress(this.getAddress());
    return information;
  }
}
