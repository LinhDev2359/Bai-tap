package org.aibles.user_profile.dto.response;

import org.aibles.user_profile.entity.Post;

public class PostImageResponse extends PostResponse{

  private String imageUrl;

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public static PostImageResponse from(Post post, String imageUrl) {
    PostImageResponse response = new PostImageResponse();
    response.setId(post.getId());
    response.setTitle(post.getTitle());
    response.setContent(post.getContent());
    response.setAuthor(post.getAuthor());
    response.setCategory(post.getCategory());
    response.setUserProfileId(post.getUserProfileId());
    response.setImageUrl(imageUrl);
    response.setCreatedAt(post.getCreatedAt());
    response.setUpdatedAt(post.getUpdatedAt());
    return response;
  }
}
