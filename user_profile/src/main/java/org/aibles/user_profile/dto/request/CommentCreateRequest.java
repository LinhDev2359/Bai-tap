package org.aibles.user_profile.dto.request;

public class CommentCreateRequest {

  private String content;
  private String parentId;

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
}
