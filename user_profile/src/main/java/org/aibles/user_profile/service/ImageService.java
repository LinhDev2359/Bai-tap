package org.aibles.user_profile.service;

import java.util.List;
import org.aibles.user_profile.dto.request.ImageCreateRequest;
import org.aibles.user_profile.dto.request.ImageUpdateRequest;
import org.aibles.user_profile.dto.response.ImageResponse;

public interface ImageService {

  ImageResponse create(String postId, ImageCreateRequest request);
  ImageResponse getById(String id);
  List<ImageResponse> getAll();
  ImageResponse updateById(String id, String postId, ImageUpdateRequest request);
  void deleteById(String id);
  void deleteAllByPostId(String postId);
}
