package org.aibles.managerdailyplan.configuration;

import org.aibles.managerdailyplan.repository.DailyPlanRepository;
import org.aibles.managerdailyplan.service.DailyPlanService;
import org.aibles.managerdailyplan.service.impl.DailyPlanServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.aibles.managerdailyplan.repository")
@ComponentScan(basePackages = "org.aibles.managerdailyplan.repository")
public class DailyPlanConfiguration {

  @Bean
  public DailyPlanService dailyPlanService(DailyPlanRepository repository) {
    return new DailyPlanServiceImpl(repository);
  }
}
