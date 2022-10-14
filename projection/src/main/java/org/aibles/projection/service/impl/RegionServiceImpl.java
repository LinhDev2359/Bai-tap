package org.aibles.projection.service.impl;

import java.util.List;
import org.aibles.projection.dto.request.RegionRequest;
import org.aibles.projection.dto.response.RegionResponse;
import org.aibles.projection.service.RegionService;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService {

  @Override
  public RegionResponse create(RegionRequest request) {
    return null;
  }

  @Override
  public void deleteById(long id) {

  }

  @Override
  public RegionResponse getById(long id) {
    return null;
  }

  @Override
  public List<RegionResponse> getAll() {
    return null;
  }

  @Override
  public RegionResponse updateById(long id, RegionRequest request) {
    return null;
  }
}
