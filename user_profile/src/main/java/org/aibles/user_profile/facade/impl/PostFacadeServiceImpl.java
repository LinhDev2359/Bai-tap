package org.aibles.user_profile.facade.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.request.PostCreateRequest;
import org.aibles.user_profile.dto.request.PostUpdateRequest;
import org.aibles.user_profile.dto.response.PostResponse;
import org.aibles.user_profile.entity.Post;
import org.aibles.user_profile.facade.PostFacadeService;
import org.aibles.user_profile.service.ImageService;
import org.aibles.user_profile.service.PostService;
import org.aibles.user_profile.service.UserProfileService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
public class PostFacadeServiceImpl implements PostFacadeService {

  private final UserProfileService userProfileService;
  private final PostService postService;
  private final ImageService imageService;

  @Override
  @Transactional
  public PostResponse create(String userProfileId, PostCreateRequest request) {
    log.info("(create)userProfileId: {}request: {}", userProfileId, request);
    userProfileService.getById(userProfileId);
    return postService.create(userProfileId, request);
  }

  @Override
  @Transactional
  public PostResponse getById(String userProfileId, String id) {
    log.info("(getById)userProfileId: {}, id: {}", userProfileId, id);
    userProfileService.getById(userProfileId);
    return postService.getById(id);
  }

  @Override
  @Transactional
  public List<PostResponse> getAll(String userProfileId) {
    log.info("(getAll)userProfileId: {}", userProfileId);
    userProfileService.getById(userProfileId);
    return postService.getAll();
  }

  @Override
  @Transactional
  public PostResponse updateById(String id, String userProfileId, PostUpdateRequest request) {
    log.info("(updateById)id: {}, userProfileId: {} request: {}", id, userProfileId, request);
    userProfileService.getById(userProfileId);
    return postService.updateById(id, userProfileId, request);
  }

  @Override
  @Transactional
  public void deleteById(String userProfileId, String id) {
    log.info("(deleteById)userProfileId: {}, id: {}", userProfileId, id);
    userProfileService.getById(userProfileId);
    imageService.deleteAllByPostId(id);
    postService.deleteById(id);
  }

  @Override
  @Transactional
  public void deleteAllByUserProfileId(String userProfileId) {
    log.info("(deleteAllByUserProfileId)userProfileId: {}", userProfileId);
    var listPost = postService.findAllByUserProfileId(userProfileId);
    for(Post post : listPost) {
      imageService.deleteAllByPostId(post.getId());
    }
    postService.deleteAllByUserProfileId(userProfileId);
  }
}
