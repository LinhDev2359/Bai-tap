package org.aibles.springjwt.service.impl;


import java.util.Optional;
import javax.swing.text.BadLocationException;
import lombok.extern.slf4j.Slf4j;
import org.aibles.springjwt.dto.request.ProfileRequest;
import org.aibles.springjwt.dto.request.UpdateProfileRequest;
import org.aibles.springjwt.dto.response.ProfileResponse;
import org.aibles.springjwt.service.UserService;
import org.aibles.springjwt.entity.User;
import org.aibles.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

  @Autowired
  private final UserRepository userRepository;


  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


  @Override
  public User updateUser(long userId, User userReq) {
    User user1 = userRepository.findById((int) userId)
        .map(result -> {

          result.setPassword(userReq.getPassword());
          result.setFirstname(userReq.getFirstname());
          result.setLastname(userReq.getLastname());
          result.setAddress(userReq.getAddress());
          result.setNumberPhone(userReq.getNumberPhone());
          result.setDateOfBirth(userReq.getDateOfBirth());

          return result;
        })
        .map(userRepository::save)
        .orElse(null);
    return user1;
  }


  @Override
  public User deleteUser(long userId) {
    return userRepository.findById((int) userId)
        .map(user -> {
          userRepository.delete(user);
          return user;
        })
        .orElse(null);
  }

  @Override
  public ProfileResponse createProfile(ProfileRequest profileRequest) {
    log.info("(created)create commit of id key results: {}", profileRequest.getNumberPhone());
    User user = profileRequest.toUser();
    User create = userRepository.save(user);
    ProfileResponse profileResponse= ProfileResponse.from(create);
    return profileResponse;
  }

  @Override
  public ProfileResponse updateProfile(long id, UpdateProfileRequest updateProfileRequest) {
    log.info("(update)update user: {}", updateProfileRequest);
    User userAlready =
        userRepository
            .findById((int) id)
            .orElseThrow(
                () -> {
                  try {
                    throw new BadLocationException("not found", 404);
                  } catch (BadLocationException e) {
                    throw new RuntimeException(e);
                  }

                });
    User user = updateProfileRequest.toUser();
    user.setId(userAlready.getId());
    user.setCreatedAt(userAlready.getCreatedAt());
    User update = userRepository.save(user);
    Optional.of(update)
        .orElseThrow(
            () -> {
              try {
                throw new BadLocationException("not found", 404);
              } catch (BadLocationException e) {
                throw new RuntimeException(e);
              }
            });
    ProfileResponse userUpdated = ProfileResponse.from(update);
    return userUpdated;
  }


}

