package org.aibles.user_profile.facade.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.request.ImageCreateRequest;
import org.aibles.user_profile.dto.request.ImageUpdateRequest;
import org.aibles.user_profile.dto.response.ImageResponse;
import org.aibles.user_profile.facade.ImageFacadeService;
import org.aibles.user_profile.service.ImageService;
import org.aibles.user_profile.service.PostService;
import org.aibles.user_profile.service.UserProfileService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
public class ImageFacadeServiceImpl implements ImageFacadeService {

  private final UserProfileService userProfileService;
  private final PostService postService;
  private final ImageService imageService;

  @Override
  @Transactional
  public ImageResponse create(String userProfileId, String postId, ImageCreateRequest request) {
    log.info("(create)userProfileId: {}, postId: {}, request: {}", userProfileId, postId, request);
    userProfileService.getById(userProfileId);
    postService.getById(postId);
    postService.existsByUserProfileIdAndId(userProfileId, postId);
    return imageService.create(postId, request);
  }

  @Override
  @Transactional
  public ImageResponse getById(String userProfileId, String postId, String id) {
    log.info("(getById)userProfileId: {}, postId: {}, id: {}", userProfileId, postId, id);
    userProfileService.getById(userProfileId);
    postService.getById(postId);
    postService.existsByUserProfileIdAndId(userProfileId, postId);
    return imageService.getById(id);
  }

  @Override
  @Transactional
  public List<ImageResponse> getAll(String userProfileId, String postId) {
    log.info("(getAll)userProfileId: {}, postId: {}", userProfileId, postId);
    userProfileService.getById(userProfileId);
    postService.getById(postId);
    postService.existsByUserProfileIdAndId(userProfileId, postId);
    return imageService.getAll();
  }

  @Override
  @Transactional
  public ImageResponse updateById(String userProfileId, String id, String postId, ImageUpdateRequest request) {
    log.info("(updateById)userProfileId: {}, id: {}, postId: {}, request: {}", userProfileId, id, postId, request);
    userProfileService.getById(userProfileId);
    postService.getById(postId);
    postService.existsByUserProfileIdAndId(userProfileId, postId);
    return imageService.updateById(id, postId, request);
  }

  @Override
  @Transactional
  public void deleteById(String userProfileId, String postId, String id) {
    log.info("(deleteById)userProfileId: {}, postId: {}, id: {}", userProfileId, postId, id);
    userProfileService.getById(userProfileId);
    postService.getById(postId);
    postService.existsByUserProfileIdAndId(userProfileId, postId);
    imageService.deleteById(id);
  }

}
