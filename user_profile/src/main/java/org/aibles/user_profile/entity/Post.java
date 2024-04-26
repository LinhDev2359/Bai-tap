package org.aibles.user_profile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.aibles.user_profile.entity.base.BaseEntity;

@Entity
@Table(name = "post")
public class Post extends BaseEntity {

  private String title;
  private String content;
  private String author;
  private String category;
  private String parentId;
  private String authorId;
  private String userProfileId;

  public Post() {
  }

  public Post(String title, String content, String author, String category, String parentId, String authorId, String userProfileId) {
    this.title = title;
    this.content = content;
    this.author = author;
    this.category = category;
    this.parentId = parentId;
    this.authorId = authorId;
    this.userProfileId = userProfileId;
  }

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

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getAuthorId() {
    return authorId;
  }

  public void setAuthorId(String authorId) {
    this.authorId = authorId;
  }

  public static Post of(String title, String content, String author, String category, String userProfileId) {
    Post post = new Post();
    post.setTitle(title);
    post.setContent(content);
    post.setAuthor(author);
    post.setCategory(category);
    post.setUserProfileId(userProfileId);
    return post;
  }

  public static Post of(String title, String content, String author, String category, String parentId, String authorId, String userProfileId) {
    Post post = new Post();
    post.setTitle(title);
    post.setContent(content);
    post.setAuthor(author);
    post.setCategory(category);
    post.setParentId(parentId);
    post.setAuthorId(authorId);
    post.setUserProfileId(userProfileId);
    return post;
  }
}
