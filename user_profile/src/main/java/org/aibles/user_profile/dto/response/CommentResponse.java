package org.aibles.user_profile.dto.response;

import org.aibles.user_profile.entity.Comment;

public class CommentResponse {

  private String id;
  private String content;
  private String parentId;
  private String postId;
  private String userProfileId;
  private Long createdAt;
  private Long updatedAt;

  public CommentResponse() {
  }

  public CommentResponse(String parentId, String content, String id, String userProfileId,
      String postId, Long createdAt, Long updatedAt) {
    this.parentId = parentId;
    this.content = content;
    this.id = id;
    this.userProfileId = userProfileId;
    this.postId = postId;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
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

  public static CommentResponse from(Comment comment) {
    CommentResponse response = new CommentResponse();
    response.setId(comment.getId());
    response.setContent(comment.getContent());
    response.setParentId(comment.getParentId());
    response.setUserProfileId(comment.getUserProfileId());
    response.setPostId(comment.getPostId());
    response.setCreatedAt(comment.getCreatedAt());
    response.setUpdatedAt(comment.getUpdatedAt());
    return response;
  }
}
