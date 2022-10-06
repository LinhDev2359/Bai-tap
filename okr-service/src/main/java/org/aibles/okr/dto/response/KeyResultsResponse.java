package org.aibles.okr.dto.response;

import java.sql.Date;
import java.time.Instant;
import org.aibles.okr.entity.KeyResults;

public class KeyResultsResponse {

  private long id;
  private String name;
  private String description;
  private Date deadline;
  private float progress;
  private String status;
  private Instant createdAt;
  private Instant updatedAt;
  private long objectiveId;

  public KeyResultsResponse() {
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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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

  public long getObjectiveId() {
    return objectiveId;
  }

  public void setObjectiveId(long objectiveId) {
    this.objectiveId = objectiveId;
  }

  public static KeyResultsResponse from(KeyResults keyResults) {
    KeyResultsResponse response = new KeyResultsResponse();
    response.setId(keyResults.getId());
    response.setName(keyResults.getName());
    response.setDescription(keyResults.getDescription());
    response.setDeadline(keyResults.getDeadline());
    response.setProgress(keyResults.getProgress());
    response.setStatus(keyResults.getStatus());
    response.setCreatedAt(keyResults.getCreatedAt());
    response.setUpdatedAt(keyResults.getUpdatedAt());
    response.setObjectiveId(keyResults.getObjectiveId());
    return response;
  }
}
