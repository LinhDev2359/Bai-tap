package org.aibles.projection.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "province")
@NoArgsConstructor
public class Province {

  @Id
  private long id;
  private String code;
  private String name;
  @Column(name = "region_id")
  private String regionId;

}
