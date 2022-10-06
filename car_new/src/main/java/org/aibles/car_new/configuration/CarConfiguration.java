package org.aibles.car_new.configuration;

import org.aibles.car_new.repository.CarRepository;
import org.aibles.car_new.service.CarService;
import org.aibles.car_new.service.impl.CarServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"org.aibles.car_new.repository"})
@ComponentScan(basePackages = {"org.aibles.car_new.repository"})
public class CarConfiguration {

  @Bean
  public CarService carService(CarRepository repository) {
    return new CarServiceImpl(repository);
  }
}
