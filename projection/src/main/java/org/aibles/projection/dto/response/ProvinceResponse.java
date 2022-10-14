package org.aibles.projection.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProvinceResponse {

  private long id;
  private String code;
  private String name;
  private Region region;

  public ProvinceResponse(long id, String code, String name, long regionId, String regionCode, String regionName) {
    this.id = id;
    this.code = code;
    this.name = name;
    this.region = Region.of(regionId, regionCode, regionName);
  }

  @AllArgsConstructor(staticName = "of")
  @Data
  @NoArgsConstructor
  private static class Region {
    private long id;
    private String code;
    private String name;
  }
}
