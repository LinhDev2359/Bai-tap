package org.aibles.user_profile.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.constant.Gender;
import org.aibles.user_profile.constant.Role;
import org.aibles.user_profile.dto.request.RegisterRequest;
import org.aibles.user_profile.dto.request.UserProfileCreateRequest;
import org.aibles.user_profile.dto.request.UserProfileUpdateRequest;
import org.aibles.user_profile.dto.response.UserProfileResponse;
import org.aibles.user_profile.entity.UserProfile;
import org.aibles.user_profile.exception.EmailAlreadyExistedException;
import org.aibles.user_profile.exception.UserProfileIdNotFoundException;
import org.aibles.user_profile.exception.UsernameAlreadyExistedException;
import org.aibles.user_profile.exception.UsernameNotFoundException;
import org.aibles.user_profile.repository.UserProfileRepository;
import org.aibles.user_profile.service.UserProfileService;
import org.aibles.user_profile.util.CryptUtil;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

  private final UserProfileRepository repository;

  @Override
  @Transactional
  public void register(RegisterRequest request) {
    log.info("(register)request: {}", request);
    if (repository.existsByEmail(request.getEmail())) {
      log.error("(register)email: {}", request.getEmail());
      throw new EmailAlreadyExistedException(request.getEmail());
    }
    if (repository.existsByUsername(request.getUsername())) {
      log.error("(register)username: {}", request.getUsername());
      throw new UsernameAlreadyExistedException(request.getUsername());
    }
    repository.save(UserProfile.of(request.getUsername(), CryptUtil.getPasswordEncoder().encode(request.getPassword()), request.getEmail(),
        Role.valueOf(request.getRole())));
  }

  @Override
  @Transactional
  public UserProfileResponse getById(String id) {
    log.info("(getById)id: {}", id);
    var userProfile = repository
        .findById(id)
        .orElseThrow(() -> {
          log.error("(getById)id: {}", id);
          throw new UserProfileIdNotFoundException(id);
        });
    return UserProfileResponse.from(userProfile);
  }

  @Override
  @Transactional
  public List<UserProfileResponse> getAll() {
    log.info("(getAll)");
    return UserProfileResponse.from(repository.findAll());
  }

  @Override
  @Transactional
  public void deleteById(String id) {
    log.info("(deleteById)id: {}", id);
    repository
      .findById(id)
      .orElseThrow(() -> {
        log.error("(deleteById)id: {}", id);
        throw new UserProfileIdNotFoundException(id);
      });
    repository.deleteById(id);
  }

  @Override
  @Transactional
  public UserProfileResponse updateById(String id, UserProfileUpdateRequest request) {
    log.info("(updateById)id: {}, request: {}", id, request);
    var userProfile = repository
      .findById(id)
      .orElseThrow(() -> {
        log.error("(updateById)id: {}", id);
        throw new UserProfileIdNotFoundException(id);
      });
    validateEmail(request.getEmail());
    userProfile.setFirstName(request.getFirstName());
    userProfile.setLastName(request.getLastName());
    userProfile.setGender(Gender.valueOf(request.getGender()));
    userProfile.setDateOfBirth(request.getDateOfBirth());
    userProfile.setPhone(request.getPhone());
    userProfile.setEmail(request.getEmail());
    userProfile.setAddress(request.getAddress());
    return UserProfileResponse.from(repository.save(userProfile));
  }

  @Override
  @Transactional
  public UserProfile findByUsername(String username) {
    log.info("(findByUsername)username: {}", username);
    return repository
        .findByUsername(username)
        .orElseThrow(() -> {
          log.error("(findByUsername)username: {}", username);
          throw new UsernameNotFoundException(username);
        });
  }

  @Override
  @Transactional
  public UserProfile findById(String id) {
    log.info("(findById)id: {}", id);
    return repository
        .findById(id)
        .orElseThrow(() -> {
          log.error("(findById)id: {}", id);
          throw new UserProfileIdNotFoundException(id);
        });
  }

  private void validateEmail(String email) {
    log.info("(validateEmail)email: {}", email);
    if(repository.existsByEmail(email)) {
      log.error("(validateEmail)email: {}", email);
      throw new EmailAlreadyExistedException(email);
    }
  }
}
