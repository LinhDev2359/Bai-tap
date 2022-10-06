package org.aibles.student.service.impl;

import static org.aibles.student.controller.StudentController.log;

import java.util.List;
import org.aibles.student.dto.StudentDto;
import org.aibles.student.entity.Student;
import org.aibles.student.mapper.StudentMapper;
import org.aibles.student.repository.StudentRepository;
import org.aibles.student.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements  StudentService{
    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;
    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public Student createdStudent(StudentDto studentDto) {
        Student student = new Student();
        log.info("Add student have info: {}", studentDto);
        studentMapper.mapToEntity(student, studentDto);
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) {

    }

    @Override
    public Student updatedStudent(long id, Student student) {
        Student result = studentRepository.findById((int) id)
                .map(worker -> {
                    worker.setName(updatedStudent(id,student).getName());
                    worker.setPlace_of_birth(updatedStudent(id, student).getPlace_of_birth());
                    return worker;
                })
                .map(studentRepository::save)
                .orElse(null);

        return result;
    }


    @Override
    public List<Student> listStudent() {
        return null;
    }
}
