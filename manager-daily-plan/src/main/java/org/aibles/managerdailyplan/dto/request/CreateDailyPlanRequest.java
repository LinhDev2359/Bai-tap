package org.aibles.managerdailyplan.dto.request;

import java.util.Date;
import javax.persistence.Column;
import lombok.Data;
import org.aibles.managerdailyplan.constants.Status;

@Data
public class CreateDailyPlanRequest {

  private String id;
  private String title;
  private String description;
  private Status status;
  private Date date;
  @Column(name = "user_id")
  private String userId;
  private String note;
  @Column(name = "key_result_id")
  private String keyResultId;
}
