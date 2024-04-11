package org.aibles.user_profile.dto.request;

import jakarta.validation.constraints.NotBlank;

public class PostCreateRequest {

  @NotBlank(message = "Title cannot blank")
  private String title;
  @NotBlank(message = "Content cannot blank")
  private String content;
  @NotBlank(message = "Author cannot blank")
  private String author;
  @NotBlank(message = "Category cannot blank")
  private String category;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
