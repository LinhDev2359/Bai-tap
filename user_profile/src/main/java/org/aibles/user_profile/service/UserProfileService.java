package org.aibles.user_profile.service;

import java.util.List;
import org.aibles.user_profile.dto.request.RegisterRequest;
import org.aibles.user_profile.dto.request.UserProfileCreateRequest;
import org.aibles.user_profile.dto.request.UserProfileUpdateRequest;
import org.aibles.user_profile.dto.response.UserProfileResponse;
import org.aibles.user_profile.entity.UserProfile;

public interface UserProfileService {

  void activeAccount(String email);
  void register(RegisterRequest request);
  UserProfileResponse getById(String id);
  List<UserProfileResponse> getAll();
  void deleteById(String id);
  UserProfileResponse updateById(String id, UserProfileUpdateRequest request);
  UserProfile findByUsername(String username);
  UserProfile findById(String id);
  void validateEmail(String email);
}
