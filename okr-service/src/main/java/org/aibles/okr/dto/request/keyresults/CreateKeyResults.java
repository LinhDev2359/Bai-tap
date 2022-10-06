package org.aibles.okr.dto.request.keyresults;

import java.sql.Date;
import java.time.Instant;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.aibles.okr.entity.KeyResults;

@Data
public class CreateKeyResults {

  @NotBlank
  private String name;
  @NotBlank
  private String description;
  private Date deadline;
  private float progress;
  @NotBlank
  private String status;
  private Instant createdAt;
  private Instant updatedAt;
  private long objectiveId;

  public CreateKeyResults() {
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

  public long getObjectiveId() {
    return objectiveId;
  }

  public void setObjectiveId(long objectiveId) {
    this.objectiveId = objectiveId;
  }

  public KeyResults toKeyResults() {
    KeyResults keyResults = new KeyResults();
    keyResults.setName(this.getName());
    keyResults.setDescription(this.getDescription());
    keyResults.setDeadline(this.getDeadline());
    keyResults.setProgress(this.getProgress());
    keyResults.setStatus(this.getStatus());
    keyResults.setCreatedAt(this.getCreatedAt());
    keyResults.setUpdatedAt(this.getUpdatedAt());
    keyResults.setObjectiveId(this.getObjectiveId());
    return keyResults;
  }
}
