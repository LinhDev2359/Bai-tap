package org.aibles.okr.service;

import java.util.List;
import org.aibles.okr.dto.request.user.CreateUser;
import org.aibles.okr.dto.request.user.UpdateUser;
import org.aibles.okr.dto.response.UserResponse;
import org.aibles.okr.entity.User;

public interface UserService {

  UserResponse created(CreateUser createUser);

  List<User> list();

  UserResponse update(long id, UpdateUser updateUser);
}
