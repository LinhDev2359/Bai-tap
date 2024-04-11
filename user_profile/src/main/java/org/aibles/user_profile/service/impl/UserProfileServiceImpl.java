package org.aibles.user_profile.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.constant.Gender;
import org.aibles.user_profile.dto.request.UserProfileCreateRequest;
import org.aibles.user_profile.dto.request.UserProfileUpdateRequest;
import org.aibles.user_profile.dto.response.UserProfileResponse;
import org.aibles.user_profile.entity.UserProfile;
import org.aibles.user_profile.exception.EmailAlreadyExistedException;
import org.aibles.user_profile.exception.UserProfileIdNotFoundException;
import org.aibles.user_profile.repository.UserProfileRepository;
import org.aibles.user_profile.service.UserProfileService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

  private final UserProfileRepository repository;

  @Override
  @Transactional
  public UserProfileResponse create(UserProfileCreateRequest request) {
    log.info("(create)request: {}", request);
    validateEmail(request.getEmail());
    return UserProfileResponse.from(
        repository.save(
            UserProfile.of(
                request.getFirstName(),
                request.getLastName(),
                Gender.valueOf(request.getGender()),
                request.getDateOfBirth(),
                request.getPhone(),
                request.getEmail(),
                request.getAddress())));
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

  private void validateEmail(String email) {
    log.info("(validateEmail)email: {}", email);
    if(repository.existsByEmail(email)) {
      log.error("(validateEmail)email: {}", email);
      throw new EmailAlreadyExistedException(email);
    }
  }
}
