package org.aibles.animal.configuration;

import org.aibles.animal.repository.AnimalRepository;
import org.aibles.animal.service.AnimalService;
import org.aibles.animal.service.impl.AnimalServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.aibles.animal.repository")
@ComponentScan(basePackages = "org.aibles.animal.repository")
public class AnimalConfiguration {

  @Bean
  public AnimalService animalService(AnimalRepository repository) {
    return new AnimalServiceImpl(repository);
  }


}
