package org.aibles.demo_car.car.service.Impl;


import lombok.extern.slf4j.Slf4j;
import org.aibles.demo_car.car.entity.Car;
import org.aibles.demo_car.car.repository.CarRepository;
import org.aibles.demo_car.car.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
@Slf4j
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;


    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * created a car
     * */
    @Override
    public Car created(Car car) {
        log.info("Execute create command car: {}", car);
        return carRepository.save(car);
    }

    /**
     * delete by id for car
     * */
    @Override
    public void delete(long id) {
        log.info("Execute delete command by id: {}", id);
        carRepository.deleteById((int) id);
    }

    /**
     * created list
     * */
    @Override
    public List<Car> list() {
        return carRepository.findAll();
    }

    /**
     * update car by id
     * */
    @Override
    public Car update(long id, Car car) {
        log.info("Execute create command by id: {}, car: {}", id, car);
        return null;
    }

}
