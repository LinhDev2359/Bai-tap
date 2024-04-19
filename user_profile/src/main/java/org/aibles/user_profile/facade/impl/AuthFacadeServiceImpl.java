package org.aibles.user_profile.facade.impl;

import static org.aibles.user_profile.constant.RedisConstant.ACTIVE_ACCOUNT;
import static org.aibles.user_profile.constant.RedisConstant.OTP;
import static org.aibles.user_profile.constant.RedisConstant.OTP_REGISTER_TTL_MINUTES;
import static org.aibles.user_profile.constant.RedisConstant.OTP_TTL_MINUTES;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.request.LoginRequest;
import org.aibles.user_profile.dto.request.RefreshTokenRequest;
import org.aibles.user_profile.dto.request.RegisterRequest;
import org.aibles.user_profile.dto.response.AuthActiveAccountResponse;
import org.aibles.user_profile.dto.response.AuthInActiveAccountResponse;
import org.aibles.user_profile.dto.response.LoginResponse;
import org.aibles.user_profile.entity.UserProfile;
import org.aibles.user_profile.exception.InvalidRefreshTokenException;
import org.aibles.user_profile.exception.OTPInvalidException;
import org.aibles.user_profile.exception.PasswordNotMatchesException;
import org.aibles.user_profile.facade.AuthFacadeService;
import org.aibles.user_profile.service.AuthTokenService;
import org.aibles.user_profile.service.EmailService;
import org.aibles.user_profile.service.OtpService;
import org.aibles.user_profile.service.UserProfileService;
import org.aibles.user_profile.util.CryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
public class AuthFacadeServiceImpl implements AuthFacadeService {

  private static final String MESSAGE_ACCOUNT_NOT_UNLOCKED = "Account hasn't been active yet!";

  @Autowired
  private RedisTemplate<String, Object> redisTemplate;
  private final UserProfileService userProfileService;
  private final AuthTokenService authTokenService;
  private final Long accessTokenLifeTime;
  private final Long refreshTokenLifeTime;
  private final OtpService otpService;
  private final EmailService emailService;

  @Override
  public void activeAccount(String email, String otp) {
    log.info("(activeAccount)email: {} otp: {}", email, otp);
    userProfileService.validateEmail(email);
    var redisKey = email + "_" + OTP + "_" + ACTIVE_ACCOUNT;
    String otpCache = (String) redisTemplate.opsForValue().get(redisKey);
    if (!Objects.equals(otpCache, otp)) {
      log.error("(activeAccount)otp : {}, otpCache : {}", otp, otpCache);
      throw new OTPInvalidException(otp);
    }
    userProfileService.activeAccount(email);
  }

  @Override
  @Transactional
  public void register(RegisterRequest request) {
    log.info("(register)request: {}", request);
    userProfileService.register(request);

    var otp = otpService.generateOtp();
    var redisKey = request.getEmail() + "_" + OTP + "_" + ACTIVE_ACCOUNT;

    redisTemplate.opsForValue().set(redisKey, otp, OTP_REGISTER_TTL_MINUTES, TimeUnit.MINUTES);
    String subject = "Send OTP for Active account";
    createActiveEmail(subject, request.getEmail(), otp);
  }

  @Override
  @Transactional
  public LoginResponse login(LoginRequest request) {
    log.info("(login)request: {}", request);
    var user = userProfileService.findByUsername(request.getUsername());
    if(!user.getActivated()) {
      log.error("(login)request: {}", request);
      return AuthInActiveAccountResponse.from(MESSAGE_ACCOUNT_NOT_UNLOCKED);
    }
    if(!CryptUtil.getPasswordEncoder().matches(request.getPassword(), user.getPassword())) {
      log.error("(login)request: {}", request);
      throw new PasswordNotMatchesException(request.getPassword());
    }
    String accessToken = authTokenService.generateAccessToken(
        user.getId(), user.getEmail(), request.getUsername(), user.getRole().toString());
    String refreshToken = authTokenService.generateRefreshToken(
        user.getId(), user.getEmail(), request.getUsername(), user.getRole().toString());
    storeTokens(user.getId(), accessToken, refreshToken);
    return AuthActiveAccountResponse.from(accessToken, refreshToken, accessTokenLifeTime, refreshTokenLifeTime);
  }

  @Override
  @Transactional
  public LoginResponse refreshAccessToken(RefreshTokenRequest request) {
    log.info("(refreshAccessToken)request: {}", request);
    String userId = authTokenService.getSubjectFromAccessToken(request.getRefreshToken());
    UserProfile userProfile = userProfileService.findById(userId);
    if(!authTokenService.validateRefreshToken(request.getRefreshToken(), userId)){
      log.error("(refreshAccessToken)request: {}", request);
      throw new InvalidRefreshTokenException();
    }
    String accessToken = authTokenService.generateAccessToken(
        userProfile.getId(), userProfile.getEmail(), userProfile.getUsername(), userProfile.getRole().toString());
    String refreshToken = authTokenService.generateRefreshToken(
        userProfile.getId(), userProfile.getEmail(), userProfile.getUsername(), userProfile.getRole().toString());
    storeTokens(userProfile.getId(), accessToken, refreshToken);
    return AuthActiveAccountResponse.from(accessToken, refreshToken, accessTokenLifeTime, refreshTokenLifeTime);
  }

  @Override
  @Transactional
  public void resendOtp(String email) {
    log.info("(sendOtp)email: {}", email);
    userProfileService.validateEmail(email);
    var otp = otpService.generateOtp();
    var redisKey = email + "_" + OTP + "_" + ACTIVE_ACCOUNT;
    redisTemplate.opsForValue().set(redisKey, otp, OTP_TTL_MINUTES, TimeUnit.MINUTES);
    String subject = "Resend OTP for Active account";
    createActiveEmail(subject, email, otp);
  }

  private void storeTokens(String userId, String accessToken, String refreshToken) {
    log.info("(storeTokens)userId: {}, accessToken: {}, refreshToken: {}", userId, accessToken, refreshToken);
    redisTemplate.opsForValue().set("accessToken:" + userId, accessToken, accessTokenLifeTime, TimeUnit.MILLISECONDS);
    redisTemplate.opsForValue().set("refreshToken:" + userId, refreshToken, refreshTokenLifeTime, TimeUnit.MILLISECONDS);
  }

  private void createActiveEmail(String subject, String email, String otp) {
    var param = new HashMap<String, Object>();
    param.put("otp", otp);
    param.put("otp_life", String.valueOf(OTP_TTL_MINUTES));
    emailService.send(subject, email, "mail-template", param);
  }
}
