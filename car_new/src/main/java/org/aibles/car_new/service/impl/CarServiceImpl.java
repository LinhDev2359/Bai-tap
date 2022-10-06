package org.aibles.car_new.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.aibles.car_new.dto.request.CreateRequest;
import org.aibles.car_new.dto.request.UpdateRequest;
import org.aibles.car_new.dto.response.CarResponse;
import org.aibles.car_new.entity.Car;
import org.aibles.car_new.exception.InternalServerException;
import org.aibles.car_new.exception.ResourceNotFoundException;
import org.aibles.car_new.repository.CarRepository;
import org.aibles.car_new.service.CarService;

@Slf4j
public class CarServiceImpl implements CarService {

  public final CarRepository repository;

  public CarServiceImpl(CarRepository repository) {
    this.repository = repository;
  }

  @Override
  @Transactional
  public CarResponse created(CreateRequest request) {
    log.info("(Created)car: {}", request.getName());
    Car car = request.toCar();
    car = repository.save(car);
    Optional.ofNullable(car)
        .orElseThrow(
            () -> {
              throw new InternalServerException();
            });
    CarResponse response = CarResponse.from(car);
    return response;
  }

  @Override
  public List<Car> list() {
    log.info("(List)car list");
    return repository.findAll();
  }

  @Override
  public CarResponse update_by_id(long id, UpdateRequest request) {
    log.info("(Update)car update by id: {}", request);
    Car carCheck = repository.findById(id)
        .orElseThrow(
            () -> {
              throw new ResourceNotFoundException(id);
            });
    Car car = request.toCar();
    car.setId(carCheck.getId());
    car = repository.save(car);
    Optional.of(car)
        .orElseThrow(
            () -> {
              throw new InternalServerException();
            });
    return CarResponse.from(car);
  }
}
