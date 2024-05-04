package org.aibles.user_profile.controller;

import static org.aibles.user_profile.constant.UserProfileApiConstant.BaseUrl.POST_URL;
import static org.aibles.user_profile.constant.UserProfileApiConstant.ResourceConstant.IMAGE;
import static org.aibles.user_profile.constant.UserProfileApiConstant.ResourceConstant.REACTION;
import static org.aibles.user_profile.util.SecurityService.getUserId;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.Response;
import org.aibles.user_profile.dto.request.ImageUpdateRequest;
import org.aibles.user_profile.dto.request.PostCreateRequest;
import org.aibles.user_profile.dto.request.ReactionCreateRequest;
import org.aibles.user_profile.dto.request.ReactionUpdateRequest;
import org.aibles.user_profile.dto.response.ReactionResponse;
import org.aibles.user_profile.facade.ReactionFacadeService;
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
public class ReactionController {

  private final ReactionFacadeService service;

  @PostMapping("/{postId}" + REACTION)
  @ResponseStatus(HttpStatus.CREATED)
  public ReactionResponse create(@Validated @PathVariable("postId") String postId, @Validated @RequestBody ReactionCreateRequest request) {
    log.info("(create)userProfileId: {}, postId: {}, request: {}", getUserId(), postId, request);
    request.validateType();
    return service.create(getUserId(), postId, request);
  }

  @GetMapping("/{postId}" + REACTION)
  @ResponseStatus(HttpStatus.OK)
  public List<ReactionResponse> getAll(@Validated @PathVariable("postId") String postId) {
    log.info("(getAll)postId: {}", postId);
    return service.getAll(postId);
  }

  @DeleteMapping("/{postId}" + REACTION + "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public String deleteById(@Validated @PathVariable("postId") String postId,
      @Validated @PathVariable("id") String id) {
    log.info("(deleteById)postId: {}, id: {}", postId, id);
    service.deleteById(getUserId(), postId, id);
    return "DELETE SUCCESS!!!";
  }


  @PatchMapping("/{postId}" + REACTION + "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public String updateType(@Validated @PathVariable("postId") String postId,
      @Validated @PathVariable("id") String id,
      @Validated @RequestBody ReactionUpdateRequest request) {
    log.info("(updateType)userProfileId: {}, postId: {}, id: {}, request: {}", getUserId(), postId, id, request);
    request.validateType();
    service.updateType(getUserId(), id, postId, request);
    return "UPDATE SUCCESS!!!";
  }


}
