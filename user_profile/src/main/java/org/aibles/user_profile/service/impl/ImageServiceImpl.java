package org.aibles.user_profile.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.request.ImageCreateRequest;
import org.aibles.user_profile.dto.request.ImageUpdateRequest;
import org.aibles.user_profile.dto.response.ImageResponse;
import org.aibles.user_profile.entity.Image;
import org.aibles.user_profile.exception.ImageIdNotFoundException;
import org.aibles.user_profile.exception.UserProfileIdNotFoundException;
import org.aibles.user_profile.repository.ImageRepository;
import org.aibles.user_profile.service.ImageService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

  private final ImageRepository repository;

  @Override
  @Transactional
  public ImageResponse create(String postId, ImageCreateRequest request) {
    log.info("(create)postId: {}, request: {}", postId, request);
    return ImageResponse.from(
        repository.save(
            Image.of(
                request.getImageUrl(),
                postId)));
  }

  @Override
  @Transactional
  public ImageResponse getById(String id) {
    log.info("(getById)id: {}", id);
    var image = repository
        .findById(id)
        .orElseThrow(() -> {
          log.error("(getById)id: {}", id);
          throw new ImageIdNotFoundException(id);
        });
    return ImageResponse.from(image);
  }

  @Override
  @Transactional
  public List<ImageResponse> getAll() {
    log.info("(getAll)");
    return ImageResponse.from(repository.findAll());
  }

  @Override
  @Transactional
  public ImageResponse updateById(String id, String postId, ImageUpdateRequest request) {
    log.info("(updateById)id: {}, postId: {}, request: {}", id, postId, request);
    var image = repository
        .findById(id)
        .orElseThrow(() -> {
          log.error("(updateById)id: {}", id);
          throw new ImageIdNotFoundException(id);
        });
    image.setImageUrl(request.getImageUrl());
    image.setPostId(postId);
    return ImageResponse.from(repository.save(image));
  }

  @Override
  @Transactional
  public void deleteById(String id) {
    log.info("(deleteById)id: {}", id);
    repository
        .findById(id)
        .orElseThrow(() -> {
          log.error("(deleteById)id: {}", id);
          throw new ImageIdNotFoundException(id);
        });
    repository.deleteById(id);
  }

  @Override
  @Transactional
  public void deleteAllByPostId(String postId) {
    log.info("(deleteAllByPostId)postId: {}", postId);
    repository.deleteAllByPostId(postId);
  }
}
