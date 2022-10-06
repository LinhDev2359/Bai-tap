package org.aibles.library2.user.service;

import java.util.List;
import org.aibles.library2.user.dto.request.CreateUserRequest;
import org.aibles.library2.user.dto.request.UpdateUserRequest;
import org.aibles.library2.user.dto.response.UserResponse;


public interface UserService {

  UserResponse created(CreateUserRequest createUserRequest);

  List<UserResponse> list();

  UserResponse update(long id, UpdateUserRequest updateUser);
}
