package org.aibles.user_profile.facade.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.request.CommentCreateRequest;
import org.aibles.user_profile.dto.request.CommentUpdateRequest;
import org.aibles.user_profile.dto.response.CommentResponse;
import org.aibles.user_profile.facade.CommentFacadeService;
import org.aibles.user_profile.service.CommentService;
import org.aibles.user_profile.service.PostService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
public class CommentFacadeServiceImpl implements CommentFacadeService {

  private final CommentService commentService;
  private final PostService postService;

  @Override
  @Transactional
  public CommentResponse create(String userProfileId, String postId, CommentCreateRequest request) {
    log.info("(create)userProfileId: {}, postId: {}, request: {}", userProfileId, postId, request);
    postService.validateExist(postId);
    return commentService.create(userProfileId, postId, request);
  }

  @Override
  @Transactional
  public List<CommentResponse> getAllByPost(String postId) {
    log.info("(getAllByPost)postId: {}", postId);
    postService.validateExist(postId);
    return commentService.getAllByPost(postId);
  }

  @Override
  @Transactional
  public List<CommentResponse> getAllByParentId(String postId, String parentId) {
    log.info("(getAllByParentId)postId: {}, parentId: {}", postId, parentId);
    postService.validateExist(postId);
    return commentService.getAllByParentId(parentId);
  }

  @Override
  @Transactional
  public void updateContent(String userProfileId, String postId, String commentId,
      CommentUpdateRequest request) {
    log.info("(updateContent)userProfileId: {}, postId: {}, commentId: {}, request: {}", userProfileId, postId, commentId, request);
    postService.validateExist(postId);
    commentService.updateContent(userProfileId, postId, commentId, request);
  }

  @Override
  @Transactional
  public void deleteById(String userProfileId, String postId, String commentId) {
    log.info("(deleteById)userProfileId: {}, postId: {}, commentId: {}", userProfileId, postId, commentId);
    postService.validateExist(postId);
    commentService.deleteById(userProfileId, postId, commentId);
  }
}
