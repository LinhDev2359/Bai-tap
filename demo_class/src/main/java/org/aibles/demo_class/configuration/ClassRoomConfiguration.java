//package org.aibles.demo_class.configuration;
//
//import org.aibles.demo_class.repository.ClassRoomRepository;
//import org.aibles.demo_class.service.ClassRoomService;
//import org.aibles.demo_class.service.impl.ClassRoomServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//@Configuration
//@EnableJpaRepositories(basePackages = {"org.aibles.demo_class.repository"})
//@ComponentScan(basePackages = {"org.aibles.demo_class.repository"})
//public class ClassRoomConfiguration {
//        @Bean
//        public ClassRoomService classRoomService (ClassRoomRepository classRoomRepository) {
//            return new ClassRoomServiceImpl(classRoomRepository);
//        }
//
//}
