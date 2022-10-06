package org.aibles.animal.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aibles.animal.dto.request.CreateAnimalRequest;
import org.aibles.animal.dto.request.ListAnimalRequest;
import org.aibles.animal.dto.request.UpdateAnimalRequest;
import org.aibles.animal.dto.response.AnimalResponse;
import org.aibles.animal.entity.Animal;
import org.aibles.animal.service.AnimalService;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/v1/animals")
public class AnimalController {

  public final AnimalService service;

  public AnimalController(AnimalService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AnimalResponse created(@RequestBody CreateAnimalRequest request) {
    log.info("(Created)Animal: {}", request);
    return service.created(request);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Animal> list(ListAnimalRequest request) {
    log.info("(List)Animal list: {}", request);
    return service.list(request);
  }

  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public AnimalResponse update(@RequestBody @Valid UpdateAnimalRequest request,
      @PathVariable("id") long id) {
    log.info("(Update)Animal update: {}", request);
    return service.update_by_id(id, request);
  }

}
