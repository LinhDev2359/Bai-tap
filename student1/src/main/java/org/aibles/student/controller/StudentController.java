package org.aibles.student.controller;

import org.aibles.student.dto.StudentDto;
import org.aibles.student.entity.Student;
import org.aibles.student.exeption.BadRequestException;
import org.aibles.student.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

//import static java.awt.Container.log;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    public static final Logger log= LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> workerList = studentService.listStudent();
        return new ResponseEntity<>(workerList, HttpStatus.OK);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Transactional
    public Student createdStudent(
            @RequestBody @Valid StudentDto studentDto, BindingResult bindingResult) {
        log.info("add student have info: {}", studentDto);
        if (bindingResult.hasErrors()) {
            throw new BadRequestException("Invalid Input!!!");
        }
        return studentService.createdStudent(studentDto);

    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "{id}")
    @Transactional
    public String deleteStudent(@PathVariable long id) {
        log.info("delete student have id: {}", id);
        studentService.deleteStudent(id);
        return "Delete student successfully!!!";
    }
}
