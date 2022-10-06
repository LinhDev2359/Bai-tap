package org.aibles.worker2.service.impl;

import java.util.List;
import java.util.Optional;
import org.aibles.worker2.exeption.InternalServerException;
import org.aibles.worker2.exeption.ResourceNotFoundException;
import org.aibles.worker2.validation.SearchSpecificationBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import org.aibles.worker2.validation.SearchList;
import org.aibles.worker2.dto.WorkerDto;
import org.aibles.worker2.entity.Worker;

import org.aibles.worker2.mapper.WorkerMapper;
import org.aibles.worker2.repository.WorkerRepository;
import org.aibles.worker2.service.WorkerService;

@Slf4j
public class WorkerServiceImpl implements WorkerService {
  private final WorkerRepository workerRepository;
  private  WorkerMapper modelMapper ;

  public WorkerServiceImpl(WorkerRepository workerRepository, WorkerMapper modelMapper) {
    this.workerRepository = workerRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  @Transactional
  public WorkerDto created(WorkerDto workerDto) {
    log.info("(Create) Create dto: {}", workerDto);
    Worker worker = new Worker();
    worker = modelMapper.mapToEntity(workerDto);
    Worker create = workerRepository.save(worker);
    Optional.ofNullable(create)
        .orElseThrow(
            () -> {
              throw new InternalServerException("404_Not_Found", HttpStatus.NOT_FOUND);
            });
    WorkerDto workerDtoCreate = modelMapper.mapToDto(create);
    return workerDtoCreate;
  }

  @Override
  @Transactional
  public void delete(int id) {
    log.info("Delete worker by id: {}", id);
    Worker worker =
        workerRepository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new InternalServerException("404_Not_Found", HttpStatus.NOT_FOUND);
                }
            );
    workerRepository.delete(worker);
  }

  @Override
  @Transactional(readOnly= true)
  public List<Worker> list() {
    log.info("List worker");
    List<Worker> listWorker = workerRepository.findAll();
    return listWorker;
  }

  @Override
  @Transactional()
  public List<WorkerDto> listSearch(SearchList searchList) {
    log.info("list worker add filter: {}",searchList);
    SearchSpecificationBuilder<Worker> builder = new SearchSpecificationBuilder<>(searchList.getSearch());
    Specification<Worker> specification = builder.build();
    List<Worker> workerSearch = workerRepository.findAll(specification);
    List<WorkerDto> workerDtoList = modelMapper.mapList(workerSearch, WorkerDto.class);

    return workerDtoList;


  }

  @Override
  @Transactional
  public WorkerDto update(int id, WorkerDto workerDto) {
    log.info("(Update) Update worker by id: {}, Worker Dto: {}", id, workerDto);
    Worker workerCheck =
        workerRepository
            .findById(id)
            .orElseThrow(
                () -> {
                 throw new ResourceNotFoundException("Please update again", HttpStatus.NOT_FOUND);

                });
    Worker worker = new Worker();
    worker = modelMapper.mapToEntity(workerDto);
    worker.setId(workerCheck.getId());
    Worker update = workerRepository.save(worker);
    Optional.of(update)
        .orElseThrow(
            () -> {
              throw new InternalServerException("Update found, update again!!", HttpStatus.NOT_FOUND);
            });
    WorkerDto workerDtoUpdated = modelMapper.mapToDto(update);
    return workerDtoUpdated;
  }
}
