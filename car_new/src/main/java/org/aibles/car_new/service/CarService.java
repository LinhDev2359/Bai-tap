package org.aibles.car_new.service;

import java.util.List;
import org.aibles.car_new.dto.request.CreateRequest;
import org.aibles.car_new.dto.request.UpdateRequest;
import org.aibles.car_new.dto.response.CarResponse;
import org.aibles.car_new.entity.Car;

public interface CarService {

  CarResponse created(CreateRequest request);

  List<Car> list();

  CarResponse update_by_id(long id, UpdateRequest updateAnimalRequest);
}
