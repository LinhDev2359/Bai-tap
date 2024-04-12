package org.aibles.user_profile.facade;

import org.aibles.user_profile.dto.request.LoginRequest;
import org.aibles.user_profile.dto.request.RefreshTokenRequest;
import org.aibles.user_profile.dto.request.RegisterRequest;
import org.aibles.user_profile.dto.response.LoginResponse;

public interface AuthFacadeService {

  void register(RegisterRequest request);
  LoginResponse login(LoginRequest request);
  LoginResponse refreshAccessToken(RefreshTokenRequest request);
}
