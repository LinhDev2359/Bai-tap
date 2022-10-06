package org.aibles.okr.dto.request.commit;

import lombok.Data;
import org.aibles.okr.entity.Commit;

@Data
public class UpdateCommit extends CreateCommit {

  private long id;

  public UpdateCommit() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Commit toCommit() {
    Commit commit = new Commit();
    commit.setId(this.getId());
    commit.setMessenger(this.getMessenger());
    commit.setProgress(this.getProgress());
    commit.setCreatedAt(this.getCreatedAt());
    commit.setKeyResultsId(this.getKeyResultsId());
    return commit;
  }


}
