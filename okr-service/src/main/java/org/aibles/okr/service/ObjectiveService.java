package org.aibles.okr.service;

import java.util.List;
import org.aibles.okr.component.SearchList;
import org.aibles.okr.dto.request.objective.CreateObjective;
import org.aibles.okr.dto.request.objective.UpdateObjective;
import org.aibles.okr.dto.response.ObjectiveResponse;


public interface ObjectiveService {

  ObjectiveResponse created(CreateObjective createObjective);

  void delete(long id);

  List<ObjectiveResponse> list();

  List<ObjectiveResponse> listSearch(SearchList searchList);

  ObjectiveResponse update(long id, UpdateObjective updateObjective);
}
