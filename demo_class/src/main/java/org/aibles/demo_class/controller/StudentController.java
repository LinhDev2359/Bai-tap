package org.aibles.demo_class.controller;

import org.aibles.demo_class.entity.Student;
import org.aibles.demo_class.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createdStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createdStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> listStudent() {
        List<Student> studentList = studentService.listStudent();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

}
