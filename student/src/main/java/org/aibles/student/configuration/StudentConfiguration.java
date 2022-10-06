package org.aibles.student.configuration;

import org.aibles.student.repository.StudentRepository;
import org.aibles.student.service.StudentService;
import org.aibles.student.service.impl.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.aibles.student.repository")
@ComponentScan(basePackages = "org.aibles.student.repository")

public class StudentConfiguration {

  @Bean
  public StudentService studentService(StudentRepository studentRepository) {
    return new StudentServiceImpl(studentRepository);
  }
}
