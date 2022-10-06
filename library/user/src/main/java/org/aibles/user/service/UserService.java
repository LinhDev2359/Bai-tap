package org.aibles.user.service;

import java.util.List;
import org.aibles.user.dto.response.UserResponse;
import org.aibles.user.dto.request.CreateUserRequest;
import org.aibles.user.dto.request.UpdateUserRequest;


public interface UserService {

  UserResponse created(CreateUserRequest createUserRequest);

  List<UserResponse> list();

  UserResponse update(long id, UpdateUserRequest updateUser);
}
