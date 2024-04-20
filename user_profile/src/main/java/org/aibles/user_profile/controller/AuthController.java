package org.aibles.user_profile.controller;

import static org.aibles.user_profile.constant.UserProfileApiConstant.BaseUrl.AUTH_URL;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.Response;
import org.aibles.user_profile.dto.request.ActiveAccountRequest;
import org.aibles.user_profile.dto.request.LoginRequest;
import org.aibles.user_profile.dto.request.RefreshTokenRequest;
import org.aibles.user_profile.dto.request.RegisterRequest;
import org.aibles.user_profile.dto.request.ResendOtpRequest;
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
  public Response activeAccount(@Valid @RequestBody ActiveAccountRequest request) {
    log.info("(activeAccount)email: {}, otp: {}", request.getEmail(), request.getOtp());
    authFacadeService.activeAccount(request.getEmail(), request.getOtp());
    return Response.of(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), "Your account has been activated successfully");
  }

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public Response register(@Valid @RequestBody RegisterRequest request) {
    log.info("(register)request: {}", request);
    request.validateRole();
    authFacadeService.register(request);
    return Response.of(HttpStatus.CREATED.value(), HttpStatus.OK.getReasonPhrase(), "REGISTER SUCCESS!!!");
  }

  @PostMapping("/login")
  public Response login(@Validated @RequestBody LoginRequest request) {
    log.info("(login) request: {}", request);
    return Response.of(HttpStatus.OK.value(), authFacadeService.login(request)
    );
  }
  @PostMapping("/refresh-token")
  public Response refreshAccessToken(@Validated @RequestBody RefreshTokenRequest request) {
    log.info("(refreshAccessToken) request: {}", request);
    return Response.of(HttpStatus.OK.value(), authFacadeService.refreshAccessToken(request)
    );
  }

  @PostMapping("/resend-otp")
  @ResponseStatus(HttpStatus.OK)
  public Response<String> resendOtp(@Validated @RequestBody ResendOtpRequest request) {
    log.info("(resendOtp)email :{}", request.getEmail());
    authFacadeService.resendOtp(request.getEmail());
    return Response.of(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), "Email send successfully");
  }
}
