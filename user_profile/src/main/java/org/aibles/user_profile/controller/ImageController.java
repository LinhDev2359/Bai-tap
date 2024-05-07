package org.aibles.user_profile.controller;

import static org.aibles.user_profile.constant.UserProfileApiConstant.BaseUrl.POST_URL;
import static org.aibles.user_profile.constant.UserProfileApiConstant.BaseUrl.USER_PROFILE_URL;
import static org.aibles.user_profile.constant.UserProfileApiConstant.ResourceConstant.IMAGE;
import static org.aibles.user_profile.constant.UserProfileApiConstant.ResourceConstant.POST;
import static org.aibles.user_profile.util.SecurityService.getUserId;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.Response;
import org.aibles.user_profile.dto.request.ImageCreateRequest;
import org.aibles.user_profile.dto.request.ImageUpdateRequest;
import org.aibles.user_profile.dto.request.PostCreateRequest;
import org.aibles.user_profile.dto.request.PostUpdateRequest;
import org.aibles.user_profile.dto.response.ImageResponse;
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
@RequestMapping(POST_URL)
public class ImageController {

  private final ImageFacadeService service;

  @PostMapping("/{postId}" + IMAGE)
  @ResponseStatus(HttpStatus.CREATED)
  public ImageResponse create(@Validated @PathVariable("postId") String postId,
      @Validated @RequestBody ImageCreateRequest request) {
    log.info("(create)userProfileId: {}, postId: {}, request: {}", getUserId(), postId, request);
    return service.create(getUserId(), postId, request);
  }

  @GetMapping("/{postId}" + IMAGE + "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ImageResponse getById(@Validated @PathVariable("postId") String postId,
      @Validated @PathVariable("id") String id) {
    log.info("(getById)userProfileId: {}, postId: {}, id: {}", getUserId(), postId, id);
    return service.getById(getUserId(), postId, id);
  }

  @GetMapping("/{postId}" + IMAGE)
  @ResponseStatus(HttpStatus.OK)
  public List<ImageResponse> getAll(@Validated @PathVariable("postId") String postId) {
    log.info("(getAll)userProfileId: {}, postId: {}", getUserId(), postId);
    return service.getAll(getUserId(), postId);
  }

  @DeleteMapping("/{postId}" + IMAGE + "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public String deleteById(@Validated @PathVariable("postId") String postId,
      @Validated @PathVariable("id") String id) {
    log.info("(deleteById)userProfileId: {}, postId: {}, id: {}", getUserId(), postId, id);
    service.deleteById(getUserId(), postId, id);
    return "DELETE SUCCESS!!!";
  }


  @PatchMapping("/{postId}" + IMAGE + "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ImageResponse updateById(@Validated @PathVariable("postId") String postId,
      @Validated @PathVariable("id") String id,
      @Validated @RequestBody ImageUpdateRequest request) {
    log.info("(updateById)userProfileId: {}, postId: {}, id: {}, request: {}", getUserId(), postId, id, request);
    return service.updateById(getUserId(), id, postId, request);
  }
}
