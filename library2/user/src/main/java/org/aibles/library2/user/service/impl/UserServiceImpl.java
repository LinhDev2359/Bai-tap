package org.aibles.library2.user.service.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.aibles.library2.user.dto.request.CreateUserRequest;
import org.aibles.library2.user.dto.request.UpdateUserRequest;
import org.aibles.library2.user.dto.response.UserResponse;
import org.aibles.library2.user.entity.User;
import org.aibles.library2.user.exception.BadRequestBaseException;
import org.aibles.library2.user.exception.NotFoundBaseException;
import org.aibles.library2.user.repository.UserRepository;
import org.aibles.library2.user.service.UserService;


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
    return UserResponse.from(update);
  }
}
