package org.aibles.user_profile.dto.request;

import jakarta.validation.constraints.NotBlank;

public class ImageCreateRequest {

  @NotBlank(message = "Image url cannot blank")
  private String imageUrl;

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
