package org.aibles.user_profile.service;

import java.util.List;
import org.aibles.user_profile.dto.request.UserProfileCreateRequest;
import org.aibles.user_profile.dto.request.UserProfileUpdateRequest;
import org.aibles.user_profile.dto.response.UserProfileResponse;

public interface UserProfileService {

  UserProfileResponse create(UserProfileCreateRequest request);
  UserProfileResponse getById(String id);
  List<UserProfileResponse> getAll();
  void deleteById(String id);
  UserProfileResponse updateById(String id, UserProfileUpdateRequest request);
}
