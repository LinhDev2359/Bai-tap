package org.aibles.okr.dto.response;

import java.sql.Date;
import java.time.Instant;
import org.aibles.okr.entity.Objective;

public class ObjectiveResponse {

  private long id;
  private String name;
  private String type;
  private String description;
  private Date deadline;
  private float progress;
  private Instant createdAt;
  private Instant updatedAt;
  private long userId;

  public ObjectiveResponse() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDeadline() {
    return deadline;
  }

  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }

  public float getProgress() {
    return progress;
  }

  public void setProgress(float progress) {
    this.progress = progress;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public static ObjectiveResponse from(Objective objective) {
    ObjectiveResponse response = new ObjectiveResponse();
    response.setId(objective.getId());
    response.setName(objective.getName());
    response.setType(objective.getType());
    response.setDescription(objective.getDescription());
    response.setDeadline(objective.getDeadline());
    response.setProgress(objective.getProgress());
    response.setCreatedAt(objective.getCreatedAt());
    response.setUpdatedAt(objective.getUpdatedAt());
    response.setUserId(objective.getUserId());
    return response;
  }
}
