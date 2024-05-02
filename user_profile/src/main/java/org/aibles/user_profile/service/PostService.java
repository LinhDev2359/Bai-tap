package org.aibles.user_profile.service;

import java.util.List;
import java.util.Map;
import org.aibles.user_profile.dto.request.PostCreateRequest;
import org.aibles.user_profile.dto.request.PostUpdateRequest;
import org.aibles.user_profile.dto.response.PostResponse;
import org.aibles.user_profile.entity.Post;

public interface PostService {

  PostResponse create(String userProfileId, PostCreateRequest request, String author);
  PostResponse getById(String id);
  List<PostResponse> getAll();
  PostResponse updateById(String id, String userProfileId, PostUpdateRequest request, String author);
  void deleteById(String id);
  void existsByUserProfileIdAndId(String userProfileId, String id);
  void deleteAllByUserProfileId(String userProfileId);
  List<Post> findAllByUserProfileId(String userProfileId);
  List<Post> findByCriteria(Map<String, String> paramsSearch);
  void validateExist(String postId);
  PostResponse sharePost(String userProfileId, String postId, PostCreateRequest request, String author);
}
