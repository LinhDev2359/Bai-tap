package org.aibles.okr.service.impl;


import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.aibles.okr.dto.request.user.CreateUser;
import org.aibles.okr.dto.request.user.UpdateUser;
import org.aibles.okr.dto.response.UserResponse;
import org.aibles.okr.entity.User;
import org.aibles.okr.exception.InternalServerException;
import org.aibles.okr.exception.ResourceNotFoundException;
import org.aibles.okr.repository.UserRepository;
import org.aibles.okr.service.UserService;

@Slf4j
public class UserServiceImpl implements UserService {

  private final UserRepository repository;

  public UserServiceImpl(UserRepository repository) {
    this.repository = repository;
  }


  @Override
  @Transactional
  public UserResponse created(CreateUser createUser) {
    log.info("(Created)create user: {}", createUser);
    User user = createUser.toUser();
     user = repository.save(user);
    UserResponse userCreated = UserResponse.from(user);
    return userCreated;
  }

  @Override
  @Transactional
  public List<User> list() {
    log.info("List user");
    List<User> userList = repository.findAll();
    return userList;
  }

  @Override
  @Transactional
  public UserResponse update(long id, UpdateUser updateUser) {
    log.info("(Update)update user by id: {}, user update: {}", id, updateUser);
    User userCheck =
        repository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new ResourceNotFoundException(id);

                });
    User user = updateUser.toUser();
    user.setId(userCheck.getId());
    User update = repository.save(user);
    Optional.of(update)
        .orElseThrow(
            () -> {
              throw new InternalServerException(id);
            });
    UserResponse userUpdated = UserResponse.from(update);
    return userUpdated;
  }
}
