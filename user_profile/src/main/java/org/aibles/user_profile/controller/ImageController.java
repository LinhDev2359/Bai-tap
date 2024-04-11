package org.aibles.user_profile.controller;

import static org.aibles.user_profile.constant.UserProfileApiConstant.BaseUrl.USER_PROFILE_URL;
import static org.aibles.user_profile.constant.UserProfileApiConstant.ResourceConstant.IMAGE;
import static org.aibles.user_profile.constant.UserProfileApiConstant.ResourceConstant.POST;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.Response;
import org.aibles.user_profile.dto.request.ImageCreateRequest;
import org.aibles.user_profile.dto.request.ImageUpdateRequest;
import org.aibles.user_profile.dto.request.PostCreateRequest;
import org.aibles.user_profile.dto.request.PostUpdateRequest;
import org.aibles.user_profile.facade.ImageFacadeService;
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
public class ImageController {

  private final ImageFacadeService service;

  @PostMapping("/{userProfileId}" + POST + "/{postId}" + IMAGE)
  @ResponseStatus(HttpStatus.OK)
  public Response create(@Validated @PathVariable("userProfileId") String userProfileId,
      @Validated @PathVariable("postId") String postId,
      @Validated @RequestBody ImageCreateRequest request) {
    log.info("(create)userProfileId: {}, postId: {}, request: {}", userProfileId, postId, request);
    return Response.of(HttpStatus.OK.value(), service.create(userProfileId, postId, request));
  }

  @GetMapping("/{userProfileId}" + POST + "/{postId}" + IMAGE + "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Response getById(@Validated @PathVariable("userProfileId") String userProfileId,
      @Validated @PathVariable("postId") String postId,
      @Validated @PathVariable("id") String id) {
    log.info("(getById)userProfileId: {}, postId: {}, id: {}", userProfileId, postId, id);
    return Response.of(HttpStatus.OK.value(), service.getById(userProfileId, postId, id));
  }

  @GetMapping("/{userProfileId}" + POST + "/{postId}" + IMAGE)
  @ResponseStatus(HttpStatus.OK)
  public Response getAll(@Validated @PathVariable("userProfileId") String userProfileId,
      @Validated @PathVariable("postId") String postId) {
    log.info("(getAll)userProfileId: {}, postId: {}", userProfileId, postId);
    return Response.of(HttpStatus.OK.value(), service.getAll(userProfileId, postId));
  }

  @DeleteMapping("/{userProfileId}" + POST + "/{postId}" + IMAGE + "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Response deleteById(@Validated @PathVariable("userProfileId") String userProfileId,
      @Validated @PathVariable("postId") String postId,
      @Validated @PathVariable("id") String id) {
    log.info("(deleteById)userProfileId: {}, postId: {}, id: {}", userProfileId, postId, id);
    service.deleteById(userProfileId, postId, id);
    return Response.of(HttpStatus.OK.value(), "DELETE SUCCESS!!!");
  }


  @PatchMapping("/{userProfileId}" + POST + "/{postId}" + IMAGE + "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Response updateById(@Validated @PathVariable("userProfileId") String userProfileId,
      @Validated @PathVariable("postId") String postId,
      @Validated @PathVariable("id") String id,
      @Validated @RequestBody ImageUpdateRequest request) {
    log.info("(updateById)userProfileId: {}, postId: {}, id: {}, request: {}", userProfileId, postId, id, request);
    return Response.of(HttpStatus.OK.value(), service.updateById(userProfileId, id, postId, request));
  }
}
