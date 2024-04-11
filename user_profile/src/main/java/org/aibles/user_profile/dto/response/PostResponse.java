package org.aibles.user_profile.dto.response;

import java.util.List;
import java.util.stream.Collectors;
import org.aibles.user_profile.entity.Post;

public class PostResponse {

  private String id;
  private String title;
  private String content;
  private String author;
  private String category;
  private String userProfileId;
  private Long createdAt;
  private Long updatedAt;

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

  public String getUserProfileId() {
    return userProfileId;
  }

  public void setUserProfileId(String userProfileId) {
    this.userProfileId = userProfileId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public static PostResponse from(Post post) {
    PostResponse response = new PostResponse();
    response.setId(post.getId());
    response.setTitle(post.getTitle());
    response.setContent(post.getContent());
    response.setAuthor(post.getAuthor());
    response.setCategory(post.getCategory());
    response.setUserProfileId(post.getUserProfileId());
    response.setCreatedAt(post.getCreatedAt());
    response.setUpdatedAt(post.getUpdatedAt());
    return response;
  }

  public static List<PostResponse> from(List<Post> post) {
    return post.stream()
        .map(PostResponse::from)
        .collect(Collectors.toList());
  }
}
