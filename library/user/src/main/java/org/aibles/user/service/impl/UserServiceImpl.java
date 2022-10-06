package org.aibles.user.service.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user.dto.request.CreateUserRequest;
import org.aibles.user.dto.response.UserResponse;
import org.aibles.user.repository.UserRepository;
import org.aibles.user.service.UserService;
import org.aibles.user.dto.request.UpdateUserRequest;
import org.aibles.user.entity.User;
import org.aibles.user.exception.BadRequestBaseException;
import org.aibles.user.exception.NotFoundBaseException;


@Slf4j
public class UserServiceImpl implements UserService {

  private final UserRepository repository;

  public UserServiceImpl(UserRepository repository) {
    this.repository = repository;
  }


  @Override
  @Transactional
  public UserResponse created(CreateUserRequest createUserRequest) {
    log.info("(created)email user create: {}", createUserRequest.getEmail());
    createUserRequest.validateClient();
    User user = createUserRequest.toUser();
    user.validate();
    UserResponse userCreated = UserResponse.from(repository.save(user));
    userCreated.validate();
    return userCreated;
  }

  @Override
  @Transactional
  public List<UserResponse> list() {
    log.info("(list)list user");
    List<User> userList = repository.findAll();
    return userList.stream().map(UserResponse::from).collect(Collectors.toList());
  }

  @Override
  @Transactional
  public UserResponse update(long id, UpdateUserRequest updateUser) {
    log.info("(update)update user by id: {}, email user update: {}", id, updateUser.getEmail());
    User userAlready =
        repository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new NotFoundBaseException(id);

                });
    User user = updateUser.toUser();
    user.setId(userAlready.getId());
    User update = repository.save(user);
    Optional.of(update)
        .orElseThrow(
            () -> {
              throw new BadRequestBaseException(update);
            });
    UserResponse userUpdated = UserResponse.from(update);
    return userUpdated;
  }
}
