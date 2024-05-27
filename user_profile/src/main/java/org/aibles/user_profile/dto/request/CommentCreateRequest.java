package org.aibles.user_profile.dto.request;

import jakarta.validation.constraints.NotBlank;

public class CommentCreateRequest {

  @NotBlank(message = "Content can't be left blank")
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
