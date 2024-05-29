package org.aibles.user_profile.controller;

import static org.aibles.user_profile.constant.UserProfileApiConstant.BaseUrl.POST_URL;
import static org.aibles.user_profile.constant.UserProfileApiConstant.ResourceConstant.COMMENT;
import static org.aibles.user_profile.util.SecurityService.getUserId;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.Response;
import org.aibles.user_profile.dto.request.CommentCreateRequest;
import org.aibles.user_profile.dto.request.CommentUpdateRequest;
import org.aibles.user_profile.dto.response.CommentResponse;
import org.aibles.user_profile.facade.CommentFacadeService;
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
public class CommentController {

  private final CommentFacadeService service;

  @PostMapping("/{postId}" + COMMENT)
  @ResponseStatus(HttpStatus.CREATED)
  public CommentResponse create(@Validated @PathVariable("postId") String postId, @Validated @RequestBody CommentCreateRequest request) {
    log.info("(create)userProfileId: {}, postId: {}, request: {}", getUserId(), postId, request);
    return service.create(getUserId(), postId, request);
  }

  @GetMapping("/{postId}" + COMMENT)
  @ResponseStatus(HttpStatus.OK)
  public List<CommentResponse> getAllByPostId(@Validated @PathVariable("postId") String postId) {
    log.info("(getAllByPostId)postId: {}", postId);
    return service.getAllByPost(postId);
  }

  @GetMapping("/{postId}" + COMMENT + "/{parentId}")
  @ResponseStatus(HttpStatus.OK)
  public List<CommentResponse> getAllByParentId(@Validated @PathVariable("postId") String postId, @Validated @PathVariable("parentId") String parentId) {
    log.info("(getAllByParentId)postId: {}, parentId: {}", postId, parentId);
    return service.getAllByParentId(postId, parentId);
  }

  @DeleteMapping("/{postId}" + COMMENT + "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public String deleteById(@Validated @PathVariable("postId") String postId,
      @Validated @PathVariable("id") String id) {
    log.info("(deleteById)postId: {}, id: {}", postId, id);
    service.deleteById(getUserId(), postId, id);
    return "DELETE SUCCESS!!!";
  }


  @PatchMapping("/{postId}" + COMMENT + "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public String updateContent(@Validated @PathVariable("postId") String postId,
      @Validated @PathVariable("id") String id,
      @Validated @RequestBody CommentUpdateRequest request) {
    log.info("(updateContent)userProfileId: {}, postId: {}, id: {}, request: {}", getUserId(), postId, id, request);
    service.updateContent(getUserId(), id, postId, request);
    return "UPDATE SUCCESS!!!";
  }
}
