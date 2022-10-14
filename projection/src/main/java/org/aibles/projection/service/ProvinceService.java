package org.aibles.projection.service;

import java.util.List;
import org.aibles.projection.dto.request.ProvinceRequest;
import org.aibles.projection.dto.response.ProvinceResponse;

public interface ProvinceService {

  ProvinceResponse create(ProvinceRequest request);

  void deleteById(long id);

  ProvinceResponse getById(long id);

  List<ProvinceResponse> getAll();

  ProvinceResponse updateById(long id, ProvinceRequest request);
}
