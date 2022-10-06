package org.aibles.information.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aibles.information.dto.request.CreateRequest;
import org.aibles.information.dto.request.UpdateRequest;
import org.aibles.information.dto.respones.InformationResponse;
import org.aibles.information.entity.Information;
import org.aibles.information.service.InformationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/informations")
public class InformationController {

  public final InformationService service;

  public InformationController(InformationService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public InformationResponse created(@RequestBody CreateRequest request) {
    log.info("(Created)information: {}", request);
    return service.create(request);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteById(@PathVariable("id") long id) {
    log.info("(deleteById)id: {}", id);
    service.deleteById(id);
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.OK)
  public void deleteAll() {
    log.info("(deleteAll)delete all information");
    service.deleteAll();
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Information> list() {
    log.info("(List)information list:");
    return service.getAll();
  }

  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public InformationResponse getById(@PathVariable("id") long id) {
    log.info("(getById)get by id: {}", id);
    return service.getById(id);
  }

  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public InformationResponse update(@RequestBody @Valid UpdateRequest request,
      @PathVariable("id") long id) {
    log.info("(Update)information update: {}", request);
    return service.updateById(id, request);
  }
}
