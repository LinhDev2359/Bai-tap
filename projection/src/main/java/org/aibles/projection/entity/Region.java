package org.aibles.projection.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "region")
public class Region {

  @Id
  private long id;
  private String code;
  private String name;

}
