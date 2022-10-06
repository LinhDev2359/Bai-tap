package org.aibles.demo_car.car.controller;

import lombok.extern.slf4j.Slf4j;
import org.aibles.demo_car.car.entity.Car;
import org.aibles.demo_car.car.service.CarService;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    /**
     * Create vehicle information
     * */
    @PostMapping
    public ResponseEntity<Car> created(@RequestBody Car car) {
        log.info("Add car have info:{}", car);
        Car created = carService.created(car);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /**
     * Delete vehicle information
     * */
    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteCar(@PathVariable int id) {
        log.info("Delete car by id!!: {}", id);
        carService.delete(id);
        return new ResponseEntity<>("Delete successfully", HttpStatus.OK);
    }

    /**
     * Print list car
     * */
    @GetMapping
    public ResponseEntity<List<Car>>listCar() {
        log.info("Show car list");
        List<Car> listCar = carService.list();
        return new ResponseEntity<>(listCar, HttpStatus.OK);
    }
}
