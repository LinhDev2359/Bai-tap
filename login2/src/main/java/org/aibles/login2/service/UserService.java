package org.aibles.login2.service;



import org.aibles.login2.dto.UserCreateRequest;
import org.aibles.login2.entity.ApiUser;
import org.aibles.login2.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder passwordEncoder;
  public ApiUser readUserByUsername (String username) {
    return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
  }
  public void createUser(UserCreateRequest userCreateRequest) {
    ApiUser user = new ApiUser();
    Optional<ApiUser> byUsername = userRepository.findByUsername(userCreateRequest.getUsername());
    if (byUsername.isPresent()) {
      throw new RuntimeException("User already registered. Please use different username.");
    }
    user.setUsername(userCreateRequest.getUsername());
    user.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
    userRepository.save(user);
  }
}
