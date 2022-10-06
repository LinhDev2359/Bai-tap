package org.aibles.car_new.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aibles.car_new.dto.request.CreateRequest;
import org.aibles.car_new.dto.request.UpdateRequest;
import org.aibles.car_new.dto.response.CarResponse;
import org.aibles.car_new.entity.Car;
import org.aibles.car_new.service.CarService;
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
@RequestMapping("/api/v1/cars")
public class CarController {

  public final CarService service;

  public CarController(CarService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CarResponse created(@RequestBody CreateRequest request) {
    log.info("(Created)Animal: {}", request);
    return service.created(request);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Car> list() {
    log.info("(List)Animal list");
    return service.list();
  }

  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public CarResponse update(@RequestBody @Valid UpdateRequest request,
      @PathVariable("id") long id) {
    log.info("(Update)Animal update: {}", request);
    return service.update_by_id(id, request);
  }
}
