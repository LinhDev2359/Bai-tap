package org.aibles.user_profile.controller;

import static org.aibles.user_profile.constant.UserProfileApiConstant.BaseUrl.AUTH_URL;
import static org.aibles.user_profile.util.SecurityService.getUserId;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.Response;
import org.aibles.user_profile.dto.request.ActiveAccountRequest;
import org.aibles.user_profile.dto.request.ChangePasswordRequest;
import org.aibles.user_profile.dto.request.ForgotPasswordRequest;
import org.aibles.user_profile.dto.request.LoginRequest;
import org.aibles.user_profile.dto.request.RefreshTokenRequest;
import org.aibles.user_profile.dto.request.RegisterRequest;
import org.aibles.user_profile.dto.request.ResendOtpRequest;
import org.aibles.user_profile.dto.request.ResetPasswordRequest;
import org.aibles.user_profile.dto.request.VerifyOtpRequest;
import org.aibles.user_profile.dto.response.AuthVerifyOtpResponse;
import org.aibles.user_profile.dto.response.LoginResponse;
import org.aibles.user_profile.facade.AuthFacadeService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(AUTH_URL)
public class AuthController {

  private final AuthFacadeService authFacadeService;

  @PostMapping("/active")
  @ResponseStatus(HttpStatus.OK)
  public String activeAccount(@Valid @RequestBody ActiveAccountRequest request) {
    log.info("(activeAccount)email: {}, otp: {}", request.getEmail(), request.getOtp());
    authFacadeService.activeAccount(request.getEmail(), request.getOtp());
    return "Your account has been activated successfully";
  }

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public String register(@Valid @RequestBody RegisterRequest request) {
    log.info("(register)request: {}", request);
    request.validateRole();
    authFacadeService.register(request);
    return "REGISTER SUCCESS!!!";
  }

  @PostMapping("/login")
  public LoginResponse login(@Validated @RequestBody LoginRequest request) {
    log.info("(login) request: {}", request);
    return authFacadeService.login(request);
  }
  @PostMapping("/refresh-token")
  public LoginResponse refreshAccessToken(@Validated @RequestBody RefreshTokenRequest request) {
    log.info("(refreshAccessToken) request: {}", request);
    return authFacadeService.refreshAccessToken(request);
  }

  @PostMapping("/resend-otp")
  @ResponseStatus(HttpStatus.OK)
  public String resendOtp(@Validated @RequestBody ResendOtpRequest request) {
    log.info("(resendOtp)email :{}", request.getEmail());
    authFacadeService.resendOtp(request.getEmail());
    return "Email send successfully";
  }

  @PostMapping("/forgot-password")
  @ResponseStatus(HttpStatus.OK)
  public String forgotPassword(@Validated @RequestBody ForgotPasswordRequest request) {
    log.info("(forgotPassword) request: {}", request);
    authFacadeService.forgotPassword(request);
    return "Forgot password successfully";
  }

  @PostMapping("/verify-otp")
  @ResponseStatus(HttpStatus.OK)
  public AuthVerifyOtpResponse verifyOtp(@Validated @RequestBody VerifyOtpRequest request) {
    log.info("(verifyOtp) request: {}", request);
    return authFacadeService.verifyOtp(request);
  }

  @PostMapping("/reset-password")
  @ResponseStatus(HttpStatus.OK)
  public String resetPassword(@Validated @RequestBody ResetPasswordRequest request) {
    log.info("(resetPassword) request: {}", request);
    authFacadeService.resetPassword(request);
    return "Reset password successfully";
  }

  @PostMapping("/change-password")
  @ResponseStatus(HttpStatus.OK)
  public String changePassword(@Validated @RequestBody ChangePasswordRequest request) {
    log.info("(changePassword) request: {}", request);
    authFacadeService.changePassword(request, getUserId());
    return "Change password successfully";
  }

}
