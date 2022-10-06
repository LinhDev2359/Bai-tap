package org.aibles.library2.user.configuration;


import org.aibles.library2.message.configuration.Message;
import org.aibles.library2.user.repository.UserRepository;
import org.aibles.library2.user.service.UserService;
import org.aibles.library2.user.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@ComponentScan(basePackages = {"org.aibles.library2.user.repository"})
@EnableJpaRepositories(basePackages = {"org.aibles.library2.user.repository"})
@Message
public class UserConfiguration {

  @Bean
  public UserService userService(UserRepository repository) {
    return new UserServiceImpl(repository);
  }

}
