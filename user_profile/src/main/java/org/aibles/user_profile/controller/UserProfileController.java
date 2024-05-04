package org.aibles.user_profile.controller;

import static org.aibles.user_profile.constant.UserProfileApiConstant.BaseUrl.USER_PROFILE_URL;
import static org.aibles.user_profile.util.SecurityService.getUserId;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.Response;
import org.aibles.user_profile.dto.request.UserProfileUpdateRequest;
import org.aibles.user_profile.dto.response.UserProfileResponse;
import org.aibles.user_profile.facade.UserProfileFacadeService;
import org.aibles.user_profile.service.UserProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(USER_PROFILE_URL)
public class UserProfileController {

  private final UserProfileService service;
  private final UserProfileFacadeService userProfileFacadeService;

  @GetMapping("/self")
  @ResponseStatus(HttpStatus.OK)
  public UserProfileResponse getById() {
    log.info("(getById)id: {}", getUserId());
    return service.getById(getUserId()));
  }

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<UserProfileResponse> getAll() {
    log.info("(getAll)");
    return service.getAll();
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public String deleteById(@Validated @PathVariable("id") String id) {
    log.info("(deleteById)id: {}", id);
    userProfileFacadeService.deleteById(id);
    return "DELETE SUCCESS!!!";
  }


  @PatchMapping("/self")
  @ResponseStatus(HttpStatus.OK)
  public UserProfileResponse updateById(@Validated @RequestBody UserProfileUpdateRequest request) {
    log.info("(updateById)id: {}, request: {}", getUserId(), request);
    return service.updateById(getUserId(), request);
  }
}
