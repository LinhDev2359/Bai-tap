package org.aibles.springjwt.controllers;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aibles.springjwt.dto.request.login.LoginRequest;
import org.aibles.springjwt.dto.request.profile.CreateProfile;
import org.aibles.springjwt.dto.request.profile.UpdateProfileRequest;
import org.aibles.springjwt.dto.request.login.SignupRequest;
import org.aibles.springjwt.dto.response.JwtResponse;
import org.aibles.springjwt.dto.response.MessageResponse;
import org.aibles.springjwt.dto.response.ProfileResponse;
import org.aibles.springjwt.entity.User;
import org.aibles.springjwt.security.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class AuthController {

  public final UserServiceImpl service;

  public AuthController(UserServiceImpl service) {
    this.service = service;
  }

  @PostMapping("/signin")
  @ResponseStatus(HttpStatus.OK)
  public JwtResponse signin(@Valid @RequestBody LoginRequest loginRequest) {
    log.info("(signin)user signin: {}", loginRequest.getEmail());
    return service.signin(loginRequest);
  }

  @PostMapping("/signup")
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponse signup(@Valid @RequestBody SignupRequest signUpRequest) {
    log.info("(signup)user signup: {}", signUpRequest.getEmail());
    return service.signup(signUpRequest);
  }

  @PutMapping("/create/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public ProfileResponse create(@PathVariable("id") long id, @Valid @RequestBody CreateProfile createProfile) {
    log.info("(create)create profile id: {}", id);
    return service.createProfile(id, createProfile);
  }

  @PutMapping("/update/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ProfileResponse update(@PathVariable("id") long id,
      @RequestBody @Valid UpdateProfileRequest updateUser) {
    log.info("(update)id update: {}", id);
    return service.updateProfile(id, updateUser);
  }

  @GetMapping("/profile/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ProfileResponse getProfile(@PathVariable("id") long id) {
    log.info("(getProfile)get profile id: {}", id);
    return service.getProfile(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ProfileResponse> list() {
    log.info("(list)user:");
    return service.getall();
  }

  @PutMapping("/update-password/{id}")
  @ResponseStatus(HttpStatus.OK)
  public User updatePassword(@PathVariable("id") long id,
      @RequestBody @Valid User userReq) {
    log.info("(updatePassword)update password id: {}", id);
    return service.updatePassword(id, userReq);
  }
}
