package org.aibles.managerdailyplan.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.aibles.managerdailyplan.constants.Status;

@Data
@Entity
@Table(name = "daily-plan")
public class DailyPlan {

  @Id
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
