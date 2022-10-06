package org.aibles.security.configuration;

import org.aibles.security.interceptor.LogInterceptor;
import org.aibles.security.repository.LoginRepository;
import org.aibles.security.service.LoginService;
import org.aibles.security.service.impl.LoginServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableJpaRepositories(basePackages = "org.aibles.security.repository")
@ComponentScan(basePackages = "org.aibles.security.repository")

public class ConfigurationLogin implements WebMvcConfigurer {

  private final LoginRepository repository;

  public ConfigurationLogin(LoginRepository repository) {
    this.repository = repository;
  }

  @Bean
  public LoginService loginService(LoginRepository repository) {
    return new LoginServiceImpl(repository);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(logInterceptor(loginService(repository)));
  }

  @Bean
  public LogInterceptor logInterceptor(LoginService service) {
    return new LogInterceptor(service);
  }

}
