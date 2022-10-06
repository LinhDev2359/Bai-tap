package org.aibles.message2.configuration;

import org.aibles.message2.repository.UserRepository;
import org.aibles.message2.service.UserService;
import org.aibles.message2.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@ComponentScan(basePackages = {"org.aibles.message2.repository"})
@EnableJpaRepositories(basePackages = {"org.aibles.message2.repository"})
public class UserConfiguration {

  @Bean
  public UserService userService(UserRepository repository) {
    return new UserServiceImpl(repository);
  }


}
