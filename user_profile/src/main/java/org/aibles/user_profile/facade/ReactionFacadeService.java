package org.aibles.user_profile.facade;

import java.util.List;
import org.aibles.user_profile.dto.request.ReactionCreateRequest;
import org.aibles.user_profile.dto.request.ReactionUpdateRequest;
import org.aibles.user_profile.dto.response.ReactionResponse;

public interface ReactionFacadeService {

  ReactionResponse create(String userProfileId, String postId, ReactionCreateRequest request);
  List<ReactionResponse> getAll(String postId);
  void updateType(String userProfileId, String postId, String reactionId, ReactionUpdateRequest request);
  void deleteById(String userProfileId, String postId, String reactionId);
}
