package org.aibles.security.service;

import org.aibles.security.dto.request.LoginRequest;
import org.aibles.security.dto.response.LoginResponse;

public interface LoginService {

  void register(LoginRequest loginRequest);

//  Boolean validate(String appUserName, String appPassword, String basicAuthHeader);

  LoginResponse getByUsername(String username);

}
