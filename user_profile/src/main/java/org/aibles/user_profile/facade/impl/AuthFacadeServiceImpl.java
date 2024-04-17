package org.aibles.user_profile.facade.impl;

import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.request.LoginRequest;
import org.aibles.user_profile.dto.request.RefreshTokenRequest;
import org.aibles.user_profile.dto.request.RegisterRequest;
import org.aibles.user_profile.dto.response.LoginResponse;
import org.aibles.user_profile.entity.UserProfile;
import org.aibles.user_profile.exception.InvalidRefreshTokenException;
import org.aibles.user_profile.exception.PasswordNotMatchesException;
import org.aibles.user_profile.facade.AuthFacadeService;
import org.aibles.user_profile.service.AuthTokenService;
import org.aibles.user_profile.service.UserProfileService;
import org.aibles.user_profile.util.CryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
public class AuthFacadeServiceImpl implements AuthFacadeService {

  @Autowired
  private RedisTemplate<String, Object> redisTemplate;
  private final UserProfileService userProfileService;
  private final AuthTokenService authTokenService;
  private final Long accessTokenLifeTime;
  private final Long refreshTokenLifeTime;

  @Override
  @Transactional
  public void register(RegisterRequest request) {
    log.info("(register)request: {}", request);
    userProfileService.register(request);
  }

  @Override
  @Transactional
  public LoginResponse login(LoginRequest request) {
    log.info("(login)request: {}", request);
    var user = userProfileService.findByUsername(request.getUsername());
    if(!CryptUtil.getPasswordEncoder().matches(request.getPassword(), user.getPassword())) {
      log.error("(login)request: {}", request);
      throw new PasswordNotMatchesException(request.getPassword());
    }
    String accessToken = authTokenService.generateAccessToken(
        user.getId(), user.getEmail(), request.getUsername());
    String refreshToken = authTokenService.generateRefreshToken(
        user.getId(), user.getEmail(), request.getUsername());
    storeTokens(user.getId(), accessToken, refreshToken);
    return LoginResponse.from(accessToken, refreshToken, accessTokenLifeTime, refreshTokenLifeTime);
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
        userProfile.getId(), userProfile.getEmail(), userProfile.getUsername());
    String refreshToken = authTokenService.generateRefreshToken(
        userProfile.getId(), userProfile.getEmail(), userProfile.getUsername());
    storeTokens(userProfile.getId(), accessToken, refreshToken);
    return LoginResponse.from(accessToken, refreshToken, accessTokenLifeTime, refreshTokenLifeTime);
  }

  private void storeTokens(String userId, String accessToken, String refreshToken) {
    log.info("(storeTokens)userId: {}, accessToken: {}, refreshToken: {}", userId, accessToken, refreshToken);
    redisTemplate.opsForValue().set("accessToken:" + userId, accessToken, accessTokenLifeTime, TimeUnit.MILLISECONDS);
    redisTemplate.opsForValue().set("refreshToken:" + userId, refreshToken, refreshTokenLifeTime, TimeUnit.MILLISECONDS);
  }
}
