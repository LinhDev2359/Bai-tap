package org.aibles.user_profile.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.request.CommentCreateRequest;
import org.aibles.user_profile.dto.request.CommentUpdateRequest;
import org.aibles.user_profile.dto.response.CommentResponse;
import org.aibles.user_profile.entity.Comment;
import org.aibles.user_profile.exception.CommentNotFoundException;
import org.aibles.user_profile.exception.ParentIdNotFoundException;
import org.aibles.user_profile.exception.UnauthorizedReactionDeletionException;
import org.aibles.user_profile.repository.CommentRepository;
import org.aibles.user_profile.service.CommentService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

  private final CommentRepository repository;

  @Override
  @Transactional
  public CommentResponse create(String userProfileId, String postId, CommentCreateRequest request) {
    log.info("(create)userProfileId: {}, postId: {}, request: {}", userProfileId, postId, request);
    if(request.getParentId() != null && !request.getParentId().isEmpty()) {
      validateParentId(request.getParentId());
    }
    return CommentResponse.from(repository.save(Comment.of(request.getContent(),
        request.getParentId(), userProfileId, postId)));
  }

  @Override
  @Transactional
  public List<CommentResponse> getAllByPost(String postId) {
    log.info("(getAllByPost)postId: {}", postId);
    return repository.findAllByPostId(postId).stream().map(comment -> new CommentResponse(
        comment.getId(), comment.getContent(), comment.getParentId(), comment.getUserProfileId(),
        comment.getPostId(), comment.getCreatedAt(), comment.getUpdatedAt()
    )).collect(Collectors.toList());
  }

  @Override
  @Transactional
  public List<CommentResponse> getAllByParentId(String parentId) {
    log.info("(getAllByParentId)parentId: {}", parentId);
    return repository.findAllByParentId(parentId).stream().map(comment -> new CommentResponse(
        comment.getId(), comment.getContent(), comment.getParentId(), comment.getUserProfileId(),
        comment.getPostId(), comment.getCreatedAt(), comment.getUpdatedAt()
    )).collect(Collectors.toList());
  }

  @Override
  @Transactional
  public void updateContent(String userProfileId, String postId, String commentId,
      CommentUpdateRequest request) {
    log.info("(updateContent)userProfileId: {}, postId: {}, commentId: {}, request: {}",
        userProfileId, postId, commentId, request);
    repository
        .findById(commentId)
        .orElseThrow(() -> {
          log.error("(updateContent)userProfileId: {}, postId: {}, commentId: {}, request: {}",
              userProfileId, postId, commentId, request);
          throw new CommentNotFoundException(commentId);
        });
    repository.updateContent(commentId, postId, userProfileId, request.getContent());
  }

  @Override
  @Transactional
  public void deleteById(String userProfileId, String postId, String commentId) {
    log.info("(deleteById)userProfileId: {}, postId: {}, commentId: {}", userProfileId, postId, commentId);
    repository
        .findById(commentId)
        .orElseThrow(() -> {
          log.error("(deleteById)userProfileId: {}, postId: {}, commentId: {}",
              userProfileId, postId, commentId);
          throw new CommentNotFoundException(commentId);
        });
    if(!repository.existsByIdAndUserProfileIdAndPostId(commentId, userProfileId, postId)) {
      log.error("(deleteById)userProfileId: {}, postId: {}, commentId: {}", userProfileId, postId, commentId);
      throw new UnauthorizedReactionDeletionException();
    }
    repository.deleteById(commentId);
  }

  private void validateParentId(String parentId) {
    log.info("(validateParentId)parentId: {}", parentId);
    if(!repository.existsById(parentId)) {
      log.error("(validateParentId)parentId: {}", parentId);
      throw new ParentIdNotFoundException(parentId);
    }
  }
}
