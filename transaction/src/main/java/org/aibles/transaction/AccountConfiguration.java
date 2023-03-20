package org.aibles.transaction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"org.aibles.transaction"})
@ComponentScan(basePackages = {"org.aibles.transaction"})
public class AccountConfiguration {

  @Bean
  public AccountService accountService(AccountRepository repository){
    return new AccountServiceImpl(repository);
  }
}
