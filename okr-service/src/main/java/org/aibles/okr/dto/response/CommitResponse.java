package org.aibles.okr.dto.response;

import java.sql.Date;
import java.time.Instant;
import org.aibles.okr.entity.Commit;

public class CommitResponse {

  private long id;
  private String messenger;
  private Instant createdAt;
  private float progress;
  private long keyResultsId;

  public CommitResponse() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getMessenger() {
    return messenger;
  }

  public void setMessenger(String messenger) {
    this.messenger = messenger;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public float getProgress() {
    return progress;
  }

  public void setProgress(float progress) {
    this.progress = progress;
  }

  public long getKeyResultsId() {
    return keyResultsId;
  }

  public void setKeyResultsId(long keyResultsId) {
    this.keyResultsId = keyResultsId;
  }

  public static CommitResponse from(Commit commit) {
    CommitResponse response = new CommitResponse();
    response.setId(commit.getId());
    response.setMessenger(commit.getMessenger());
    response.setProgress(commit.getProgress());
    response.setCreatedAt(commit.getCreatedAt());
    response.setKeyResultsId(commit.getKeyResultsId());
    return response;
  }
}
