package org.aibles.springjwt.service;

import org.aibles.springjwt.dto.request.ProfileRequest;
import org.aibles.springjwt.dto.request.UpdateProfileRequest;
import org.aibles.springjwt.dto.response.ProfileResponse;
import org.aibles.springjwt.entity.User;

public interface UserService {

    User updateUser(long userId, User user);

    User deleteUser(long userId);

    ProfileResponse createProfile(ProfileRequest profileRequest);

    ProfileResponse updateProfile(long id, UpdateProfileRequest updateProfileRequest);


}


