package org.aibles.managerdailyplan.service;

import java.util.List;
import org.aibles.managerdailyplan.dto.request.CreateDailyPlanRequest;
import org.aibles.managerdailyplan.dto.request.UpdateDailyPlanRequest;
import org.aibles.managerdailyplan.dto.request.UpdateStatusDailyPlanRequest;
import org.aibles.managerdailyplan.dto.response.DailyPlanDTOResponse;
import org.aibles.managerdailyplan.dto.response.MessageDTOResponse;

public interface DailyPlanService {

  MessageDTOResponse create(CreateDailyPlanRequest createDailyPlanRequest);
  MessageDTOResponse deleteById(long id);
  DailyPlanDTOResponse update(long id, UpdateDailyPlanRequest updateDailyPlanRequest);
  DailyPlanDTOResponse updateStatus(long id, UpdateStatusDailyPlanRequest updateStatusDailyPlanRequest);
}
