package org.aibles.ioc_and_di.car;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfiguration {

  @Bean
  public Car getCar(){
    Car car = new Car();
    return car;
  }
}
