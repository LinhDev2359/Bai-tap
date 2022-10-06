package org.aibles.springjwt.security;

import java.util.List;
import org.aibles.springjwt.dto.request.login.LoginRequest;
import org.aibles.springjwt.dto.request.login.SignupRequest;
import org.aibles.springjwt.dto.request.profile.CreateProfile;
import org.aibles.springjwt.dto.request.profile.UpdateProfileRequest;
import org.aibles.springjwt.dto.response.JwtResponse;
import org.aibles.springjwt.dto.response.MessageResponse;
import org.aibles.springjwt.dto.response.ProfileResponse;
import org.aibles.springjwt.entity.User;

public interface UserService {

  JwtResponse signin(LoginRequest loginRequest);

  MessageResponse signup(SignupRequest signupRequest);

  ProfileResponse createProfile(long id, CreateProfile createProfile);

  User updatePassword(long userId, User userReq);

  ProfileResponse updateProfile(long id, UpdateProfileRequest updateProfileRequest);

  ProfileResponse getProfile(long id);

  List<ProfileResponse> getall();


}


