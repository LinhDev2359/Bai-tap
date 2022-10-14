package org.aibles.projection.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegionResponse {

  private long id;
  private String code;
  private String name;
}
