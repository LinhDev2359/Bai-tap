package org.aibles.user_profile.facade.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.request.ImageCreateRequest;
import org.aibles.user_profile.dto.request.PostCreateRequest;
import org.aibles.user_profile.dto.request.PostUpdateRequest;
import org.aibles.user_profile.dto.response.PostImageResponse;
import org.aibles.user_profile.dto.response.PostResponse;
import org.aibles.user_profile.entity.Post;
import org.aibles.user_profile.exception.BadRequestException;
import org.aibles.user_profile.facade.PostFacadeService;
import org.aibles.user_profile.service.ImageService;
import org.aibles.user_profile.service.PostService;
import org.aibles.user_profile.service.UserProfileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
public class PostFacadeServiceImpl implements PostFacadeService {

  private final UserProfileService userProfileService;
  private final PostService postService;
  private final ImageService imageService;

  @Value("${image.value}")
  private Path fileStorageLocation;

  @Override
  @Transactional
  public PostResponse create(String userProfileId, PostCreateRequest request) {
    log.info("(create)userProfileId: {}request: {}", userProfileId, request);
    var userProfile = userProfileService.getById(userProfileId);
    String name = userProfile.getFirstName().concat(" ").concat(userProfile.getLastName());
    return postService.create(userProfileId, request, name);
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
    var userProfile = userProfileService.getById(userProfileId);
    String name = userProfile.getFirstName().concat(" ").concat(userProfile.getLastName());
    return postService.updateById(id, userProfileId, request, name);
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

  @Override
  @Transactional
  public PostResponse sharePost(String userProfileId, String postId, PostCreateRequest request) {
    log.info("(sharePost)userProfileId: {}, postId : {}, request: {}", userProfileId, postId, request);
    var userProfile = userProfileService.getById(userProfileId);
    String name = userProfile.getFirstName().concat(" ").concat(userProfile.getLastName());
    return postService.sharePost(userProfileId, postId, request, name);
  }

  @Override
  @Transactional
  public PostImageResponse uploadImage(String userProfileId, PostCreateRequest request, MultipartFile file) {
    log.info("(uploadImage)userProfileId: {}, request: {}", userProfileId, request);
    var userProfile = userProfileService.getById(userProfileId);
    String name = userProfile.getFirstName().concat(" ").concat(userProfile.getLastName());
    var post = postService.create(userProfileId, request, name);
    try {
      Path targetLocation = fileStorageLocation.resolve(file.getOriginalFilename());
      Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
      ImageCreateRequest imageCreateRequest = new ImageCreateRequest();
      imageCreateRequest.setImageUrl(targetLocation.toString());
      imageService.create(post.getId(), imageCreateRequest);
      return PostImageResponse.from(Post.of(post), targetLocation.toString());
    } catch (Exception ex) {
      log.error("(uploadImage)exception : {} --> Bad request", ex.getClass().getSimpleName());
      throw new BadRequestException();
    }
  }

}
