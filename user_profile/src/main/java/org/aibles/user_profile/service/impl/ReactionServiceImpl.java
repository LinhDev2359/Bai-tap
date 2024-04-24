package org.aibles.user_profile.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.constant.TypeReaction;
import org.aibles.user_profile.dto.request.ReactionCreateRequest;
import org.aibles.user_profile.dto.request.ReactionUpdateRequest;
import org.aibles.user_profile.dto.response.ReactionResponse;
import org.aibles.user_profile.entity.Reaction;
import org.aibles.user_profile.exception.ReactionNotFountException;
import org.aibles.user_profile.exception.TypeAlreadyExistedException;
import org.aibles.user_profile.exception.UnauthorizedReactionDeletionException;
import org.aibles.user_profile.repository.ReactionRepository;
import org.aibles.user_profile.service.ReactionService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
public class ReactionServiceImpl implements ReactionService {

  private final ReactionRepository repository;

  @Override
  @Transactional
  public ReactionResponse create(String userProfileId, String postId, ReactionCreateRequest request) {
    log.info("(create)userProfileId: {}, postId: {}, request: {}", userProfileId, postId, request);
    validateType(request.getType());
    return ReactionResponse.from(repository.save(Reaction.of(TypeReaction.valueOf(request.getType()), postId, userProfileId)));
  }

  @Override
  @Transactional
  public List<ReactionResponse> getAll(String postId) {
    log.info("(getAll)postId: {}", postId);
    return repository.findAllByPostId(postId);
  }

  @Override
  @Transactional
  public void updateType(String userProfileId, String postId, String reactionId, ReactionUpdateRequest request) {
    log.info("(updateType)userProfileId: {}, postId: {}, reactionId: {}, request: {}", userProfileId, reactionId, postId, request);
    repository
        .findById(reactionId)
        .orElseThrow(() -> {
          log.error("(updateType)userProfileId: {}, postId: {}, reactionId: {}, request: {}", userProfileId, reactionId, postId, request);
          throw new ReactionNotFountException(reactionId);
        });
    repository.updateType(reactionId, postId, userProfileId, TypeReaction.valueOf(request.getType()));
  }

  @Override
  @Transactional
  public void deleteById(String userProfileId, String postId, String reactionId) {
    log.info("(deleteById)userProfileId: {}, postId: {}, reactionId: {}", userProfileId, postId, reactionId);
    repository
        .findById(reactionId)
        .orElseThrow(() -> {
          log.error("(delete)userProfileId: {}, postId: {}, reactionId: {}", userProfileId, postId, reactionId);
          throw new ReactionNotFountException(reactionId);
        });
    if(!repository.existsByIdAndUserProfileIdAndPostId(reactionId, userProfileId, postId)) {
      log.error("(deleteById)userProfileId: {}, postId: {}, reactionId: {}", userProfileId, postId, reactionId);
      throw new UnauthorizedReactionDeletionException();
    }
    repository.deleteById(reactionId);
  }

  private void validateType(String type) {
    log.info("(validateType)type: {}", type);
    if (repository.existsByType(TypeReaction.valueOf(type))) {
      log.error("(validateType)type: {}", type);
      throw new TypeAlreadyExistedException(type);
    }
  }
}
