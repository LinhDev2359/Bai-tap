package org.aibles.projection.service;

import java.util.List;
import org.aibles.projection.dto.request.RegionRequest;
import org.aibles.projection.dto.response.RegionResponse;

public interface RegionService {

  RegionResponse create(RegionRequest request);

  void deleteById(long id);
  RegionResponse getById(long id);

  List<RegionResponse> getAll();

  RegionResponse updateById(long id, RegionRequest request);
}
