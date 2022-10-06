package org.aibles.login2.dto;

import lombok.Data;

@Data
public class UserCreateRequest {
  private String username;
  private String password;

}
