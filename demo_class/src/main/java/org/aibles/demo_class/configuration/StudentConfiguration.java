//package org.aibles.demo_class.configuration;
//
//import org.aibles.demo_class.repository.StudentRepository;
//import org.aibles.demo_class.service.StudentService;
//import org.aibles.demo_class.service.impl.StudentServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//@Configuration
//@EnableJpaRepositories(basePackages = {"org.aibles.demo_class.repository"})
//@ComponentScan(basePackages = {"org.aibles.demo_class.repository"})
//public class StudentConfiguration {
//    @Bean
//    public StudentService studentService (StudentRepository studentRepository) {
//        return new StudentServiceImpl(studentRepository);
//    }
//}
