package org.aibles.user_profile.dto.response;

import org.aibles.user_profile.constant.TypeReaction;
import org.aibles.user_profile.entity.Reaction;

public class ReactionResponse {

  private String id;
  private TypeReaction type;
  private String postId;
  private String userProfileId;
  private Long createdAt;
  private Long updatedAt;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public TypeReaction getType() {
    return type;
  }

  public void setType(TypeReaction type) {
    this.type = type;
  }

  public String getPostId() {
    return postId;
  }

  public void setPostId(String postId) {
    this.postId = postId;
  }

  public String getUserProfileId() {
    return userProfileId;
  }

  public void setUserProfileId(String userProfileId) {
    this.userProfileId = userProfileId;
  }

  public Long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Long createdAt) {
    this.createdAt = createdAt;
  }

  public Long getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Long updatedAt) {
    this.updatedAt = updatedAt;
  }

  public static ReactionResponse from(Reaction reaction) {
    ReactionResponse response = new ReactionResponse();
    response.setId(reaction.getId());
    response.setType(reaction.getType());
    response.setUserProfileId(reaction.getUserProfileId());
    response.setPostId(reaction.getPostId());
    response.setCreatedAt(reaction.getCreatedAt());
    response.setUpdatedAt(reaction.getUpdatedAt());
    return response;
  }
}
