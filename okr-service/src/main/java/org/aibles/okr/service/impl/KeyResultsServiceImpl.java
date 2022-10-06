package org.aibles.okr.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.aibles.okr.dto.request.keyresults.CreateKeyResults;
import org.aibles.okr.dto.request.keyresults.UpdateKeyResults;
import org.aibles.okr.dto.response.KeyResultsResponse;
import org.aibles.okr.entity.KeyResults;
import org.aibles.okr.exception.InternalServerException;
import org.aibles.okr.exception.ResourceNotFoundException;
import org.aibles.okr.repository.KeyResultsRepository;
import org.aibles.okr.service.KeyResultsService;

@Slf4j
public class KeyResultsServiceImpl implements KeyResultsService {

  private final KeyResultsRepository repository;

  public KeyResultsServiceImpl(KeyResultsRepository repository) {
    this.repository = repository;
  }

  @Override
  public KeyResultsResponse created(CreateKeyResults createKeyResults) {
    log.info("(Create)create key results: {}", createKeyResults);
    KeyResults keyResults = createKeyResults.toKeyResults();
    KeyResults create = repository.save(keyResults);
    KeyResultsResponse keyResultsCreate = KeyResultsResponse.from(create);
    return keyResultsCreate;
  }

  @Override
  public void delete(long id) {
    log.info("(Delete)delete key results by id: {}", id);
    KeyResults keyResults =
        repository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new InternalServerException(id);
                }
            );
    repository.delete(keyResults);
  }

  @Override
  @Transactional
  public List<KeyResults> list() {
    log.info("(List)list key results");
    List<KeyResults> keyResultsList = repository.findAll();
    return keyResultsList;
  }

  @Override
  public KeyResultsResponse update(long id, UpdateKeyResults updateKeyResults) {
    log.info("(Update) Update key results by id: {}, Key results: {} ", id, updateKeyResults);
    KeyResults keyResultsCheck =
        repository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new ResourceNotFoundException(id);
                });
    KeyResults keyResults = updateKeyResults.toKeyResults();
    keyResults.setId(keyResultsCheck.getId());
    KeyResults update = repository.save(keyResults);
    Optional.of(update)
        .orElseThrow(
            () -> {
              throw new InternalServerException(id);
            });
    KeyResultsResponse keyResultsUpdated = KeyResultsResponse.from(update);
    return keyResultsUpdated;
  }
}
