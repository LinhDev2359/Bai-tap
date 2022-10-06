package org.aibles.student.configuration;

import org.aibles.student.mapper.StudentMapper;
import org.aibles.student.repository.StudentRepository;
import org.aibles.student.service.StudentService;
import org.aibles.student.service.impl.StudentServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public StudentService studentService(
            StudentRepository studentRepository, StudentMapper studentMapper) {
        return new StudentServiceImpl(studentRepository, studentMapper);
    }
}
