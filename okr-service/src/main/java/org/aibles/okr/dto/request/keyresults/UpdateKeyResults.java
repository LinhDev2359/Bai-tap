package org.aibles.okr.dto.request.keyresults;

import lombok.Data;
import org.aibles.okr.entity.KeyResults;

@Data
public class UpdateKeyResults extends CreateKeyResults {

  private long id;

  public UpdateKeyResults() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public KeyResults toKeyResults() {
    KeyResults keyResults = new KeyResults();
    keyResults.setId(this.getId());
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
