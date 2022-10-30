package org.aibles.managerdailyplan.dto.response;

import java.util.Date;
import lombok.Data;
import org.aibles.managerdailyplan.constants.Status;

@Data
public class DailyPlanDTOResponse {

  private String id;
  private String title;
  private String description;
  private Status status;
  private Date date;
  private String userId;
  private String note;
  private String keyResultId;
}
