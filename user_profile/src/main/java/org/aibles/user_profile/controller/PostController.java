package org.aibles.user_profile.controller;

import static org.aibles.user_profile.constant.UserProfileApiConstant.BaseUrl.USER_PROFILE_URL;
import static org.aibles.user_profile.constant.UserProfileApiConstant.ResourceConstant.POST;
import static org.aibles.user_profile.util.SecurityService.getUserId;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.Response;
import org.aibles.user_profile.dto.request.PostCreateRequest;
import org.aibles.user_profile.dto.request.PostUpdateRequest;
import org.aibles.user_profile.facade.PostFacadeService;
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
public class PostController {


  private final PostFacadeService service;

  @PostMapping("/" + POST)
  @ResponseStatus(HttpStatus.OK)
  public Response create(@Validated @RequestBody PostCreateRequest request) {
    log.info("(create)request: {}", request);
    return Response.of(HttpStatus.OK.value(), service.create(getUserId(), request));
  }

  @GetMapping("/" + POST + "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Response getById(@Validated @PathVariable("id") String id) {
    log.info("(getById)id: {}", id);
    return Response.of(HttpStatus.OK.value(), service.getById(getUserId(), id));
  }

  @GetMapping("/" + POST)
  @ResponseStatus(HttpStatus.OK)
  public Response getAll() {
    log.info("(getAll)");
    return Response.of(HttpStatus.OK.value(), service.getAll(getUserId()));
  }

  @DeleteMapping("/" + POST + "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Response deleteById(@Validated @PathVariable("id") String id) {
    log.info("(deleteById)id: {}", id);
    service.deleteById(getUserId(), id);
    return Response.of(HttpStatus.OK.value(), "DELETE SUCCESS!!!");
  }


  @PatchMapping("/" + POST + "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Response updateById(@Validated @PathVariable("id") String id,
      @Validated @RequestBody PostUpdateRequest request) {
    log.info("(updateById)id: {}, request: {}", id, request);
    return Response.of(HttpStatus.OK.value(), service.updateById(id, getUserId(), request));
  }
}
