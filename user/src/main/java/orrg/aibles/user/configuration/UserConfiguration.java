package orrg.aibles.user.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import orrg.aibles.user.repository.UserRepository;
import orrg.aibles.user.service.UserService;
import orrg.aibles.user.service.impl.UserServiceImpl;

@Configuration
@EnableJpaRepositories(basePackages = {"orrg.aibles.user.repository"})
@ComponentScan(basePackages = {"orrg.aibles.user.repository"})
public class UserConfiguration {


 @Bean
  public UserService userService(UserRepository repository) {
   return new  UserServiceImpl(repository);
 }

//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }

//  @Override
//  protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//    // authentication manager (see below)
//  }
//
//  @Override
//  protected void configure(final HttpSecurity http) throws Exception {
//    // http builder configurations for authorize requests and form login (see below)
//  }



}
