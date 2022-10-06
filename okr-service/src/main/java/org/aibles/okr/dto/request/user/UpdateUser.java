package org.aibles.okr.dto.request.user;

import org.aibles.okr.entity.User;

public class UpdateUser extends CreateUser {

  private long id;

  public UpdateUser() {
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
