package org.aibles.login2.service.impl;

import java.util.Collections;
import org.aibles.login2.entity.ApiUser;
import org.aibles.login2.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthenticationUserDetailService implements UserDetailsService {


  private final UserService userService;

  public AuthenticationUserDetailService(UserService userService) {
    this.userService = userService;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    ApiUser apiUser = userService.readUserByUsername(username);
    if (apiUser == null) {
      throw new UsernameNotFoundException(username);
    }
    return new org.springframework.security.core.userdetails.User(apiUser.getUsername(),
        apiUser.getPassword(), Collections.emptyList());
  }
}
