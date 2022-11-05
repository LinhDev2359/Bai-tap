package org.aibles.redis.configuration;


import java.util.Objects;

import org.aibles.redis.repository.StudentRepository;
import org.aibles.redis.service.StudentService;
import org.aibles.redis.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@ComponentScan(basePackages = {"org.aibles.redis.repository"})
@EnableJpaRepositories(basePackages = {"org.aibles.redis.repository"})
@PropertySource("application.properties")
public class RedisConfiguration {

  @Value("${spring.redis.host}")
  private String redisHostName;

  @Value("${spring.redis.port}")
  private int redisPort;

  @Bean
  public StudentService service(StudentRepository repository) {
    return new StudentServiceImpl(repository);
  }

  @Bean
  JedisConnectionFactory jedisConnectionFactory() {
    return new JedisConnectionFactory(new RedisStandaloneConfiguration(redisHostName, redisPort));
  }

  @Bean
  public RedisTemplate redisTemplate() {
    RedisTemplate template = new RedisTemplate<>();
    template.setConnectionFactory(jedisConnectionFactory());
    return template;
  }
}
