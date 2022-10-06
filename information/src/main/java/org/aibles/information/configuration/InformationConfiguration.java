package org.aibles.information.configuration;

import org.aibles.information.repository.InformationRepository;
import org.aibles.information.service.InformationService;
import org.aibles.information.service.impl.InformationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.aibles.information.repository")
@ComponentScan(basePackages = "org.aibles.information.repository")
public class InformationConfiguration {

  @Bean
  public InformationService informationService(InformationRepository repository) {
    return new InformationServiceImpl(repository);
  }
}
