package org.aibles.demo_class.service.impl;

import org.aibles.demo_class.entity.Student;
import org.aibles.demo_class.repository.StudentRepository;
import org.aibles.demo_class.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student createdStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updatedStudent(int id, Student student) {
        return null;
    }

    @Override
    public List<Student> listStudent() {
        return studentRepository.findAll();
    }
}
