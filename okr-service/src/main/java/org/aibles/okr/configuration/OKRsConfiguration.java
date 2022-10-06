package org.aibles.okr.configuration;


import org.aibles.okr.repository.CommitRepository;
import org.aibles.okr.repository.KeyResultsRepository;
import org.aibles.okr.repository.ObjectiveRepository;
import org.aibles.okr.repository.UserRepository;
import org.aibles.okr.service.CommitService;
import org.aibles.okr.service.KeyResultsService;
import org.aibles.okr.service.ObjectiveService;
import org.aibles.okr.service.UserService;
import org.aibles.okr.service.impl.CommitServiceImpl;
import org.aibles.okr.service.impl.KeyResultsServiceImpl;
import org.aibles.okr.service.impl.ObjectiveServiceImpl;
import org.aibles.okr.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"org.aibles.okr.repository"})
@ComponentScan(basePackages = {"org.aibles.okr.repository"})
public class OKRsConfiguration {

  @Bean
  public CommitService commitService(CommitRepository repository) {
    return new CommitServiceImpl(repository);
  }

  @Bean
  public KeyResultsService keyResultsService(KeyResultsRepository repository) {
    return new KeyResultsServiceImpl(repository);
  }

  @Bean
  public ObjectiveService objectiveService(ObjectiveRepository repository) {
    return new ObjectiveServiceImpl(repository);
  }

  @Bean
  public UserService userService(UserRepository repository) {
    return new UserServiceImpl(repository);
  }

}
