package orrg.aibles.user.controlller;


import static orrg.aibles.user.constant.ApiConstants.USER_API;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import orrg.aibles.user.dto.request.CreateUserRequest;
import orrg.aibles.user.dto.request.UpdateUserRequest;
import orrg.aibles.user.dto.response.UserResponse;
import orrg.aibles.user.service.UserService;

@RestController
@RequestMapping(USER_API)
@Slf4j
public class UserController {

  private final UserService service;

  @Autowired
  public UserController(UserService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public UserResponse created(@RequestBody @Valid CreateUserRequest createUserRequest) {
    return service.created(createUserRequest);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<UserResponse> list() {
    return service.list();
  }

  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public UserResponse update(@PathVariable("id") long id,
      @RequestBody @Valid UpdateUserRequest updateUser) {
    return service.update(id, updateUser);
  }
}
