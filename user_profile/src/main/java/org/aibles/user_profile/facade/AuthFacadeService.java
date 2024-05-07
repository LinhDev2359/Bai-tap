package org.aibles.user_profile.facade;

import org.aibles.user_profile.dto.request.ForgotPasswordRequest;
import org.aibles.user_profile.dto.request.ResetPasswordRequest;
import org.aibles.user_profile.dto.request.VerifyOtpRequest;
import org.aibles.user_profile.dto.request.LoginRequest;
import org.aibles.user_profile.dto.request.RefreshTokenRequest;
import org.aibles.user_profile.dto.request.RegisterRequest;
import org.aibles.user_profile.dto.response.AuthVerifyOtpResponse;
import org.aibles.user_profile.dto.response.LoginResponse;

public interface AuthFacadeService {

  void activeAccount(String email, String otp);
  void register(RegisterRequest request);
  LoginResponse login(LoginRequest request);
  LoginResponse refreshAccessToken(RefreshTokenRequest request);
  void resendOtp(String email);
  void forgotPassword(ForgotPasswordRequest request);
  AuthVerifyOtpResponse verifyOtp(VerifyOtpRequest request);
  void resetPassword(ResetPasswordRequest request);
}
