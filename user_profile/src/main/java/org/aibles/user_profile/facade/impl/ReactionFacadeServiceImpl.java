package org.aibles.user_profile.facade.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.request.ReactionCreateRequest;
import org.aibles.user_profile.dto.request.ReactionUpdateRequest;
import org.aibles.user_profile.dto.response.ReactionResponse;
import org.aibles.user_profile.facade.ReactionFacadeService;
import org.aibles.user_profile.service.PostService;
import org.aibles.user_profile.service.ReactionService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
public class ReactionFacadeServiceImpl implements ReactionFacadeService {

  private final ReactionService reactionService;
  private final PostService postService;

  @Override
  @Transactional
  public ReactionResponse create(String userProfileId, String postId,
      ReactionCreateRequest request) {
    log.info("(create)userProfileId: {}, postId: {}, request: {}", userProfileId, postId, request);
    postService.validateExist(postId);
    return reactionService.create(userProfileId, postId, request);
  }

  @Override
  @Transactional
  public List<ReactionResponse> getAll(String postId) {
    log.info("(getAll)postId: {}", postId);
    postService.validateExist(postId);
    return reactionService.getAll(postId);
  }

  @Override
  @Transactional
  public void updateType(String userProfileId, String postId, String reactionId,
      ReactionUpdateRequest request) {
    log.info("(updateType)userProfileId: {}, postId: {}, reactionId: {}, request: {}", userProfileId, reactionId, postId, request);
    postService.validateExist(postId);
    reactionService.updateType(userProfileId, postId, reactionId, request);
  }

  @Override
  @Transactional
  public void deleteById(String userProfileId, String postId, String reactionId) {
    log.info("(deleteById)userProfileId: {}, postId: {}, reactionId: {}", userProfileId, postId, reactionId);
    postService.validateExist(postId);
    reactionService.deleteById(userProfileId, postId, reactionId);
  }

}
