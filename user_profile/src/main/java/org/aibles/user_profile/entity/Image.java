package org.aibles.user_profile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.aibles.user_profile.entity.base.BaseEntity;

@Entity
@Table(name = "image")
public class Image extends BaseEntity {

  private String imageUrl;
  private String postId;

  public Image() {
  }

  public Image(String imageUrl, String postId) {
    this.imageUrl = imageUrl;
    this.postId = postId;
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

  public static Image of(String imageUrl, String postId) {
    Image image = new Image();
    image.setImageUrl(imageUrl);
    image.setPostId(postId);
    return image;
  }
}
