package org.aibles.user_profile.controller;

import static org.aibles.user_profile.constant.UserProfileApiConstant.BaseUrl.USER_PROFILE_URL;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.Response;
import org.aibles.user_profile.dto.request.UserProfileCreateRequest;
import org.aibles.user_profile.dto.request.UserProfileUpdateRequest;
import org.aibles.user_profile.facade.UserProfileFacadeService;
import org.aibles.user_profile.service.UserProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

  @PostMapping()
  @ResponseStatus(HttpStatus.OK)
  public Response create(@Validated @RequestBody UserProfileCreateRequest request) {
    log.info("(create)request: {}", request);
    request.validateGender();
    return Response.of(HttpStatus.OK.value(), service.create(request));
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Response getById(@Validated @PathVariable("id") String id) {
    log.info("(getById)id: {}", id);
    return Response.of(HttpStatus.OK.value(), service.getById(id));
  }

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public Response getAll() {
    log.info("(getAll)");
    return Response.of(HttpStatus.OK.value(), service.getAll());
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Response deleteById(@Validated @PathVariable("id") String id) {
    log.info("(deleteById)id: {}", id);
    userProfileFacadeService.deleteById(id);
    return Response.of(HttpStatus.OK.value(), "DELETE SUCCESS!!!");
  }


  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Response updateById(@Validated @PathVariable("id") String id,
      @Validated @RequestBody UserProfileUpdateRequest request) {
    log.info("(updateById)id: {}, request: {}", id, request);
    return Response.of(HttpStatus.OK.value(), service.updateById(id, request));
  }
}
