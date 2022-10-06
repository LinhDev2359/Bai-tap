package org.aibles.okr.service;

import java.util.List;
import org.aibles.okr.dto.request.keyresults.CreateKeyResults;
import org.aibles.okr.dto.request.keyresults.UpdateKeyResults;
import org.aibles.okr.dto.response.KeyResultsResponse;
import org.aibles.okr.entity.KeyResults;

public interface KeyResultsService {

  KeyResultsResponse created(CreateKeyResults createKeyResults);

  void delete(long id);

  List<KeyResults> list();

  KeyResultsResponse update(long id, UpdateKeyResults updateKeyResults);
}
