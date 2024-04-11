package org.aibles.user_profile.dto.response;

import java.util.List;
import java.util.stream.Collectors;
import org.aibles.user_profile.entity.Image;

public class ImageResponse {

  private String id;
  private String imageUrl;
  private String postId;
  private Long createdAt;
  private Long updatedAt;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getPostId() {
    return postId;
  }

  public void setPostId(String postId) {
    this.postId = postId;
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

  public static ImageResponse from(Image image) {
    ImageResponse response = new ImageResponse();
    response.setId(image.getId());
    response.setImageUrl(image.getImageUrl());
    response.setPostId(image.getPostId());
    response.setCreatedAt(image.getCreatedAt());
    response.setUpdatedAt(image.getUpdatedAt());
    return response;
  }

  public static List<ImageResponse> from(List<Image> image) {
    return image.stream()
        .map(ImageResponse::from)
        .collect(Collectors.toList());
  }
}
