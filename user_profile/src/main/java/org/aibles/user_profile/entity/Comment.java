package org.aibles.user_profile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.aibles.user_profile.entity.base.BaseEntity;

@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {

  String content;
  String parentId;
  String userProfileId;
  String postId;

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

  public String getUserProfileId() {
    return userProfileId;
  }

  public void setUserProfileId(String userProfileId) {
    this.userProfileId = userProfileId;
  }

  public String getPostId() {
    return postId;
  }

  public void setPostId(String postId) {
    this.postId = postId;
  }

  public static Comment of(String content, String parentId, String userProfileId, String postId) {
    Comment comment = new Comment();
    comment.setContent(content);
    comment.setParentId(parentId);
    comment.setUserProfileId(userProfileId);
    comment.setPostId(postId);
    return comment;
  }
}
