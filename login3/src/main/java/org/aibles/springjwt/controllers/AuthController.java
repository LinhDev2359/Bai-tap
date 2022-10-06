package org.aibles.springjwt.controllers;

import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.aibles.springjwt.dto.request.ProfileRequest;
import org.aibles.springjwt.dto.request.UpdateProfileRequest;
import org.aibles.springjwt.dto.response.ProfileResponse;
import org.aibles.springjwt.entity.User;
import org.aibles.springjwt.dto.request.LoginRequest;
import org.aibles.springjwt.dto.request.SignupRequest;
import org.aibles.springjwt.dto.response.JwtResponse;
import org.aibles.springjwt.dto.response.MessageResponse;

import org.aibles.springjwt.repository.UserRepository;
import org.aibles.springjwt.security.jwt.JwtUtils;
import org.aibles.springjwt.security.services.UserDetailsImpl;
import org.aibles.springjwt.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

  public final UserServiceImpl service;
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  public AuthController(UserServiceImpl service) {
    this.service = service;
  }

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
            loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    return ResponseEntity.ok(new JwtResponse(jwt,
        userDetails.getId(),
        userDetails.getUsername(),
        userDetails.getFirstName(),
        userDetails.getLastName()));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already taken!"));
    }


    // Create new user's account
    User user = new User(signUpRequest.getEmail(),
        encoder.encode(signUpRequest.getPassword()),
        signUpRequest.getFirstName(),signUpRequest.getLastName());
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProfileResponse created(@RequestBody @Valid ProfileRequest profileRequest) {
    log.info("(created)create user: {}", profileRequest);
    return service.createProfile(profileRequest);
  }

  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public ProfileResponse update(@PathVariable("id") long id,
      @RequestBody @Valid UpdateProfileRequest updateUser) {
    log.info("(update)id update: {}", id);
    return service.updateProfile(id, updateUser);
  }
}
