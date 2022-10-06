package org.aibles.okr.dto.request.objective;

import java.sql.Date;
import java.time.Instant;
import javax.validation.constraints.NotBlank;
import org.aibles.okr.entity.Objective;

public class CreateObjective {

  @NotBlank
  private String name;
  @NotBlank
  private String type;
  @NotBlank
  private String description;
  private Date deadline;
  private float progress;
  private Instant createdAt;
  private Instant updatedAt;
  private long userId;
//chú comment cái này thì còn đâu mà get, nãy em mô tả cho thằng đức anh nên e cmt tạm ạ
  //:))) thế mà bảo k lỗi ạ

  public CreateObjective() {
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

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public Objective toObjective() {
    Objective objective = new Objective();
    objective.setName(this.getName());
    objective.setType(this.getType());
    objective.setDescription(this.getDescription());
    objective.setDeadline(this.getDeadline());
    objective.setProgress(this.getProgress());
//    objective.setCreatedAt(this.getCreatedAt());
//    objective.setUpdatedAt(this.getUpdatedAt());
//    objective.setUserId(this.getUserId());
    return objective;
  }
}
