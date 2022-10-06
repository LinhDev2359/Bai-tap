package org.aibles.demo_car.car.repository;

import org.aibles.demo_car.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
