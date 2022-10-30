package org.aibles.managerdailyplan.dto.request;

import lombok.Data;
import org.aibles.managerdailyplan.constants.Status;

@Data
public class UpdateStatusDailyPlanRequest {

  private Status status;
}
