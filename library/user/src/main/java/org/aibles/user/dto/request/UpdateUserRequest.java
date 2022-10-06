package org.aibles.user.dto.request;


import org.aibles.user.entity.User;

public class UpdateUserRequest extends CreateUserRequest {

  private long id;

  public UpdateUserRequest() {
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
    return user;
  }
}
