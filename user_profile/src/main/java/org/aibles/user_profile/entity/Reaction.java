package org.aibles.user_profile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import org.aibles.user_profile.constant.TypeReaction;
import org.aibles.user_profile.entity.base.BaseEntity;

@Entity
@Table(name = "reaction")
public class Reaction extends BaseEntity {

  @Enumerated(EnumType.STRING)
  TypeReaction type;
  String userProfileId;
  String postId;

  public Reaction() {
  }

  public Reaction(TypeReaction type, String userProfileId, String postId) {
    this.type = type;
    this.userProfileId = userProfileId;
    this.postId = postId;
  }

  public TypeReaction getType() {
    return type;
  }

  public void setType(TypeReaction type) {
    this.type = type;
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

  public void setUserProfileIdl(String userProfileId) {
    this.userProfileId = userProfileId;
  }

  public static Reaction of(TypeReaction type, String postId, String userProfileId) {
    Reaction reaction = new Reaction();
    reaction.setType(type);
    reaction.setPostId(postId);
    reaction.setUserProfileIdl(userProfileId);
    return reaction;
  }
}
