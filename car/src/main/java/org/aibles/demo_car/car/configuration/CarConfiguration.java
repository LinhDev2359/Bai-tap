package org.aibles.demo_car.car.configuration;

import org.aibles.demo_car.car.repository.CarRepository;
import org.aibles.demo_car.car.service.CarService;
import org.aibles.demo_car.car.service.Impl.CarServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"org.aibles.demo_car.car.repository"})
@ComponentScan(basePackages = {"org.aibles.demo_car.car.repository"})
public class CarConfiguration {
    @Bean
    public CarService carService (CarRepository carRepository) {
        return new CarServiceImpl(carRepository);
    }
}
