package org.aibles.okr.dto.request.objective;

import org.aibles.okr.entity.Objective;

public class UpdateObjective extends CreateObjective {

  private long id;

  public UpdateObjective() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Objective toObjective() {
    Objective objective = new Objective();
    objective.setId(this.getId());
    objective.setName(this.getName());
    objective.setType(this.getType());
    objective.setDescription(this.getDescription());
    objective.setDeadline(this.getDeadline());
    objective.setProgress(this.getProgress());
    objective.setCreatedAt(this.getCreatedAt());
    objective.setUpdatedAt(this.getUpdatedAt());
    objective.setUserId(this.getUserId());
    return objective;
  }

}
