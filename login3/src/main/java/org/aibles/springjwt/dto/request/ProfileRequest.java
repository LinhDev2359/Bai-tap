package org.aibles.springjwt.dto.request;

import java.sql.Date;
import java.time.Instant;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.aibles.springjwt.entity.User;

public class ProfileRequest {

  @NotBlank
  private String numberPhone;

  @NotNull
  private Date dateOfBirth;

  @NotBlank
  private String address;

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
    user.setNumberPhone(this.getNumberPhone());
    user.setDateOfBirth(this.getDateOfBirth());
    user.setAddress(this.getAddress());
    return user;
  }
}
