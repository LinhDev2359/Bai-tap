package org.aibles.user.configuration;

import org.aibles.user.repository.UserRepository;
import org.aibles.user.service.UserService;
import org.aibles.user.service.impl.UserServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@ComponentScan(basePackages = {"org.aibles.user.repository"})
@EnableJpaRepositories(basePackages = {"org.aibles.user.repository"})
public class UserConfiguration {

  @Bean
  public UserService userService(UserRepository repository) {
    return new UserServiceImpl(repository);
  }

  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource
        = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename(
        "classpath:/i18n/messages"
    );
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }
}
