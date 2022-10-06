package org.aibles.demo_class.service;

import org.aibles.demo_class.entity.Student;

import java.util.List;

public interface StudentService {
    Student createdStudent (Student student);

    Student updatedStudent (int id,Student student);

    List<Student> listStudent();
}
