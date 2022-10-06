package org.aibles.information.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.aibles.information.dto.request.CreateRequest;
import org.aibles.information.dto.request.UpdateRequest;
import org.aibles.information.dto.respones.InformationResponse;
import org.aibles.information.entity.Information;
import org.aibles.information.exception.BadRequestException;
import org.aibles.information.exception.ResourceNotFoundException;
import org.aibles.information.repository.InformationRepository;
import org.aibles.information.service.InformationService;

@Slf4j
public class InformationServiceImpl implements InformationService {

  public final InformationRepository repository;

  public InformationServiceImpl(InformationRepository repository) {
    this.repository = repository;
  }

  /**
   * Create information to the list information
   *
   * @param request
   * @return Information
   */
  @Override
  @Transactional
  public InformationResponse create(CreateRequest request) {
    log.info("(create)create information: {}", request);
    Information information = request.toInformation();
    information = repository.save(information);
    InformationResponse informationResponse = InformationResponse.from(information);
    return informationResponse;
  }

  /**
   * Delete information by id
   *
   * @param id
   */
  @Override
  @Transactional
  public void deleteById(long id) {
    log.info("(Delete)delete information by id: {}", id);
    repository.deleteById(id);
  }

  /**
   * Delete all information on list
   */
  @Override
  @Transactional
  public void deleteAll() {
    log.info("(DeleteAll)");
    repository.deleteAll();
  }

  /**
   * Get a list of information
   *
   * @return list information
   */
  @Override
  @Transactional
  public List<Information> getAll() {
    log.info("(List)list information");
    return repository.findAll();
  }

  /**
   * Get information by id
   *
   * @param id
   * @return information
   */
  @Override
  @Transactional
  public InformationResponse getById(long id) {
    log.info("(getById)get information by id: {}", id);
    Information information = repository.findById(id).orElseThrow(() -> {
      throw new BadRequestException(id);
    });
    return InformationResponse.from(information);
  }

  /**
   * Update information by id
   *
   * @param id
   * @param updateRequest
   * @return information
   */
  @Override
  @Transactional
  public InformationResponse updateById(long id, UpdateRequest updateRequest) {
    log.info("(update)update information by id");
    Information informationCheck = repository.findById(id).orElseThrow(() -> {
      throw new ResourceNotFoundException(id);
    });
    Information information = updateRequest.toInformation();
    information.setId(informationCheck.getId());
    information = repository.save(information);
    return InformationResponse.from(information);
  }
}
