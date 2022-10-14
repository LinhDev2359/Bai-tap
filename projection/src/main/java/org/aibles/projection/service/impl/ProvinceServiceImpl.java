package org.aibles.projection.service.impl;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.aibles.projection.dto.request.ProvinceRequest;
import org.aibles.projection.dto.response.ProvinceResponse;
import org.aibles.projection.entity.Province;
import org.aibles.projection.repository.ProvinceRepository;
import org.aibles.projection.service.ProvinceService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProvinceServiceImpl implements ProvinceService {

  public final ProvinceRepository repository;

  public ProvinceServiceImpl(ProvinceRepository repository) {
    this.repository = repository;
  }


  @Override
  public ProvinceResponse create(ProvinceRequest request) {

    province.validateClient();
    province.setActive(
        JobCheck.checkBookIsActive(province)
    );
    return BookResponse.from(repository.save(book));
  }

  @Override
  public void deleteById(long id) {

  }

  @Override
  public ProvinceResponse getById(long id) {
    return null;
  }

  @Override
  public List<ProvinceResponse> getAll() {
    return null;
  }

  @Override
  public ProvinceResponse updateById(long id, ProvinceRequest request) {
    return null;
  }
}
