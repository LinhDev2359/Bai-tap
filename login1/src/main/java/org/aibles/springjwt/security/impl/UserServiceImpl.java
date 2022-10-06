package org.aibles.springjwt.security.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.aibles.springjwt.dto.request.login.LoginRequest;
import org.aibles.springjwt.dto.request.login.SignupRequest;
import org.aibles.springjwt.dto.request.profile.CreateProfile;
import org.aibles.springjwt.dto.request.profile.UpdateProfileRequest;
import org.aibles.springjwt.dto.response.JwtResponse;
import org.aibles.springjwt.dto.response.MessageResponse;
import org.aibles.springjwt.dto.response.ProfileResponse;
import org.aibles.springjwt.entity.User;
import org.aibles.springjwt.exception.BadRequestBaseException;
import org.aibles.springjwt.exception.InternalServerBaseException;
import org.aibles.springjwt.exception.NotFoundBaseException;
import org.aibles.springjwt.repository.UserRepository;
import org.aibles.springjwt.security.UserService;
import org.aibles.springjwt.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

  @Autowired
  private final UserRepository userRepository;

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;


  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


  @Override
  public User updatePassword(long userId, User userReq) {
    log.info("(updatePassword)update password for id: {}", userId);
    User user1 = userRepository.findById(userId)
        .map(result -> {

          result.setPassword(encoder.encode(userReq.getPassword()));

          return result;
        })
        .map(userRepository::save)
        .orElse(null);
    return user1;
  }

  @Override
  public JwtResponse signin(LoginRequest loginRequest) {
    log.info("(signin)signin user for email: {}", loginRequest.getEmail());
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
            loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    JwtResponse get =new JwtResponse(jwt,
        userDetails.getId(),
        userDetails.getUsername(),
        userDetails.getLastName(),
        userDetails.getFirstName());
    return get;
  }

  @Override
  public MessageResponse signup(SignupRequest signupRequest) {
    log.info("(signup)signup user for email: {}", signupRequest.getEmail());
    if (userRepository.existsByEmail(signupRequest.getEmail())) {
        return new MessageResponse("Error: Email is already taken!");
    }

    User user = new User(signupRequest.getEmail(), signupRequest.getFirstName(),
        signupRequest.getLastName(),
        encoder.encode(signupRequest.getPassword()));
    //user.setCreatedAt(Instant.from(LocalDateTime.now()));
    userRepository.save(user);

    MessageResponse message = new MessageResponse("User registered successfully!");
    return message;
  }

  @Override
  @Transactional
  public ProfileResponse createProfile(long id, CreateProfile createProfile) {
    log.info("(createProfile)create profile user: {}", createProfile);
    User userAlready =
        userRepository
            .findById(id)
            .orElseThrow(() -> {
                      throw new BadRequestBaseException(id);
                });
    User user = createProfile.toUser(userAlready);
    user = userRepository.save(user);
    ProfileResponse userCreated = ProfileResponse.from(user);
    return userCreated;
  }


  @Override
  public ProfileResponse updateProfile(long id, UpdateProfileRequest updateProfileRequest) {
    log.info("(updateProfile)update profile user: {}", updateProfileRequest);
    User userAlready =
        userRepository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new NotFoundBaseException(id);
                });
    User user = updateProfileRequest.toUser(userAlready);
    User update = userRepository.save(user);
    Optional.of(update)
        .orElseThrow(
            () -> {
              throw new InternalServerBaseException(id);
            });
    ProfileResponse userUpdated = ProfileResponse.from(update);
    return userUpdated;
  }

  @Override
  public ProfileResponse getProfile(long id) {
    log.info("(getProfile)get profile for user by id: {}", id);
    User userAlready =
        userRepository
            .findById(id)
            .orElseThrow(() -> {
                  throw new NotFoundBaseException(id);
                });
    return ProfileResponse.from(userAlready);
  }

  @Override
  public List<ProfileResponse> getall() {
    log.info("(getall)get all user");
    List<User> profileResponses = userRepository.findAll();
    return profileResponses.stream().map(ProfileResponse::from).collect(Collectors.toList());

  }

}

