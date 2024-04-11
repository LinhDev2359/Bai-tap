package org.aibles.user_profile.facade;

import java.util.List;
import org.aibles.user_profile.dto.request.ImageCreateRequest;
import org.aibles.user_profile.dto.request.ImageUpdateRequest;
import org.aibles.user_profile.dto.response.ImageResponse;

public interface ImageFacadeService {

  ImageResponse create(String userProfileId, String postId, ImageCreateRequest request);
  ImageResponse getById(String userProfileId, String postId, String id);
  List<ImageResponse> getAll(String userProfileId, String postId);
  ImageResponse updateById(String userProfileId, String id, String postId, ImageUpdateRequest request);
  void deleteById(String userProfileId, String postId, String id);
}
