package org.aibles.student.mapper;

import org.aibles.student.dto.StudentDto;
import org.aibles.student.entity.Student;
import  org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    private final ModelMapper modelMapper;


    public StudentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public StudentDto mapToDto(Student student) {
        return modelMapper.map(student, StudentDto.class);
    }

    public Student mapToEntity(Student student, StudentDto studentDto) {
        modelMapper.map(studentDto, student);
        return student;
    }

}
