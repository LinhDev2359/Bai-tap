package org.aibles.student.service;

import org.aibles.student.dto.StudentDto;
import org.aibles.student.entity.Student;

import java.util.List;


public interface StudentService {
    Student createdStudent (StudentDto studentDto);
    void deleteStudent(long id);
    Student updatedStudent (long id,Student student);


    List<Student> listStudent();
}
