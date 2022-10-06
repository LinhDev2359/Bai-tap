package org.aibles.okr.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.aibles.okr.component.SearchList;
import org.aibles.okr.dto.request.objective.CreateObjective;
import org.aibles.okr.dto.request.objective.UpdateObjective;
import org.aibles.okr.dto.response.ObjectiveResponse;
import org.aibles.okr.entity.Objective;
import org.aibles.okr.exception.InternalServerException;
import org.aibles.okr.exception.ResourceNotFoundException;
import org.aibles.okr.repository.ObjectiveRepository;
import org.aibles.okr.service.ObjectiveService;
import org.aibles.okr.util.SearchSpecificationBuilder;
import org.springframework.data.jpa.domain.Specification;


@Slf4j
public class ObjectiveServiceImpl implements ObjectiveService {
  private final ObjectiveRepository repository;

  public ObjectiveServiceImpl(ObjectiveRepository repository) {
    this.repository = repository;
  }


  @Override
  @Transactional
  public ObjectiveResponse created(CreateObjective createObjective) {
    log.info("(Created)create objective: {}", createObjective);
    Objective objective  = createObjective.toObjective();
    Objective create = repository.save(objective );
    ObjectiveResponse objectiveCreate = ObjectiveResponse.from(create);
    return objectiveCreate;
  }

  @Override
  @Transactional
  public void delete(long id) {
    log.info("(Delete)delete objective by id: {}", id);
    Objective objective =
        repository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new InternalServerException(id);
                }
            );
    repository.delete(objective);
  }

  @Override
  @Transactional
  public List<ObjectiveResponse> list() {
    log.info("(List)list objective");
    List<Objective> objectiveList = repository.findAll();
    return objectiveList.stream().map(ObjectiveResponse::from).collect(Collectors.toList());
  }

  @Override
  @Transactional
  public List<ObjectiveResponse> listSearch(SearchList searchList) {
    log.info("(ListSearch)objective add filter: {}",searchList);
    SearchSpecificationBuilder<Objective> builder = new SearchSpecificationBuilder<>(searchList.getSearch());
    Specification<Objective> specification = builder.build();
    List<Objective> objectiveSearch = repository.findAll(specification);
    return objectiveSearch.stream().map(ObjectiveResponse::from).collect(Collectors.toList());
  }

  @Override
  public ObjectiveResponse update(long id, UpdateObjective updateObjective) {
    log.info("(Update)update objective by id: {}, objective update: {}", id, updateObjective);
    Objective objectiveCheck =
        repository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new ResourceNotFoundException(id);

                });
    Objective objective = updateObjective.toObjective();
    objective.setId(objectiveCheck.getId());
    Objective update = repository.save(objective);
    Optional.of(update)
        .orElseThrow(
            () -> {
              throw new InternalServerException(id);
            });
    ObjectiveResponse objectiveUpdated = ObjectiveResponse.from(update);
    return objectiveUpdated;
  }
}
