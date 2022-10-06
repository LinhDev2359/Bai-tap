package orrg.aibles.user.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import orrg.aibles.user.dto.request.CreateUserRequest;
import orrg.aibles.user.dto.request.UpdateUserRequest;
import orrg.aibles.user.dto.response.UserResponse;

public interface UserService {

  UserResponse created(CreateUserRequest createUserRequest);

  List<UserResponse> list();

  UserResponse update(long id, UpdateUserRequest updateUser);
}
