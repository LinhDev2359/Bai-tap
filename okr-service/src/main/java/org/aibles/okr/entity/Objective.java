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
@Table(name = "objective")
public class Objective {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", unique = true, length = 100)
  private String name;

  @Column(name = "type", unique = true, length = 256)
  private String type;

  @Column(name = "description", unique = true, length = 256)
  private String description;

  @Column(name = "deadline")
  private Date deadline;

  @Column(name = "progress")
  private Float progress;

  @CreationTimestamp
  @Column(name = "created_at")
  private Instant createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Instant updatedAt;

  @Column(name = "user_id")
  private Long userId;


}
