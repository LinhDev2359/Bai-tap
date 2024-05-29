package org.aibles.user_profile.facade;

import java.util.List;
import org.aibles.user_profile.dto.request.CommentCreateRequest;
import org.aibles.user_profile.dto.request.CommentUpdateRequest;
import org.aibles.user_profile.dto.response.CommentResponse;

public interface CommentFacadeService {

  CommentResponse create(String userProfileId, String postId, CommentCreateRequest request);
  List<CommentResponse> getAllByPost(String postId);
  List<CommentResponse> getAllByParentId(String postId, String parentId);
  void updateContent(String userProfileId, String postId, String commentId, CommentUpdateRequest request);
  void deleteById(String userProfileId, String postId, String commentId);

}
