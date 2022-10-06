package org.aibles.okr.entity;

import java.sql.Date;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Data
@Entity
@Table(name = "key-results")
public class KeyResults {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", unique = true, length = 256)
  private String name;

  @Column(name = "description", unique = true, length = 256)
  private String description;

  @Column(name = "deadline")
  private Date deadline;

  @Column(name = "progress")
  private Float progress;

  @Column(name = "status", unique = true, length = 256)
  private String status;

  @CreationTimestamp
  @Column(name = "created_at")
  private Instant createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Instant updatedAt;

  @Column(name = "objective_id")
  private Long objectiveId;

}
