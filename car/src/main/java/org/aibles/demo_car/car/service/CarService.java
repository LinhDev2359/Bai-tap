package org.aibles.demo_car.car.service;

import org.aibles.demo_car.car.entity.Car;

import java.util.List;

public interface CarService {
    Car created (Car car);
    void delete(long id);

    List<Car> list();
    Car update (long id, Car car);





}
