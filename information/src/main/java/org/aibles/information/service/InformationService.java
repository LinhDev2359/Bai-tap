package org.aibles.information.service;

import java.util.List;
import org.aibles.information.dto.request.CreateRequest;
import org.aibles.information.dto.request.UpdateRequest;
import org.aibles.information.dto.respones.InformationResponse;
import org.aibles.information.entity.Information;

public interface InformationService {

  InformationResponse create(CreateRequest createRequest);
  void deleteById(long id);
  void deleteAll();
  List<Information> getAll();
  InformationResponse getById(long id);
  InformationResponse updateById(long id, UpdateRequest updateRequest);

}
