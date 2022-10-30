package org.aibles.managerdailyplan.service.impl;

import org.aibles.managerdailyplan.dto.request.CreateDailyPlanRequest;
import org.aibles.managerdailyplan.dto.request.UpdateDailyPlanRequest;
import org.aibles.managerdailyplan.dto.request.UpdateStatusDailyPlanRequest;
import org.aibles.managerdailyplan.dto.response.DailyPlanDTOResponse;
import org.aibles.managerdailyplan.dto.response.MessageDTOResponse;
import org.aibles.managerdailyplan.repository.DailyPlanRepository;
import org.aibles.managerdailyplan.service.DailyPlanService;

public class DailyPlanServiceImpl implements DailyPlanService {

  private final DailyPlanRepository repository;

  public DailyPlanServiceImpl(DailyPlanRepository repository) {
    this.repository = repository;
  }

  @Override
  public MessageDTOResponse create(CreateDailyPlanRequest createDailyPlanRequest) {
    return null;
  }

  @Override
  public MessageDTOResponse deleteById(long id) {
    return null;
  }

  @Override
  public DailyPlanDTOResponse update(long id, UpdateDailyPlanRequest updateDailyPlanRequest) {
    return null;
  }

  @Override
  public DailyPlanDTOResponse updateStatus(long id,
      UpdateStatusDailyPlanRequest updateStatusDailyPlanRequest) {
    return null;
  }
}
