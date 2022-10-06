package org.aibles.okr.dto.request.commit;

import java.sql.Date;
import java.time.Instant;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.aibles.okr.entity.Commit;

@Data
public class CreateCommit {

  @NotBlank
  private String messenger;
  private Instant createdAt;
  private float progress;
  private long keyResultsId;

  public CreateCommit() {
  }

  public String getMessenger() {
    return messenger;
  }

  public void setMessenger(String messenger) {
    this.messenger = messenger;
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

  public long getKeyResultsId() {
    return keyResultsId;
  }

  public void setKeyResultsId(long keyResultsId) {
    this.keyResultsId = keyResultsId;
  }

  public Commit toCommit() {
    Commit commit = new Commit();
    commit.setMessenger(this.getMessenger());
    commit.setProgress(this.getProgress());
    commit.setCreatedAt(this.getCreatedAt());
    commit.setKeyResultsId(this.getKeyResultsId());
    return commit;
  }
}
