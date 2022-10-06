package org.aibles.student.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aibles.student.dto.request.CreateStudent;
import org.aibles.student.dto.request.UpdateStudent;
import org.aibles.student.dto.respone.StudentRespone;
import org.aibles.student.entity.Student;
import org.aibles.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

  public final StudentService service;

  public StudentController(StudentService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public StudentRespone created(@RequestBody CreateStudent request) {
    log.info("(Created)student: {}", request);
    return service.create(request);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteById(@PathVariable("id") long id) {
    log.info("(deleteById)id: {}", id);
    service.delete(id);
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.OK)
  public void deleteAll() {
    log.info("(deleteAll)delete");
    service.deleteAll();
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Student> list() {
    log.info("(List)studen list:");
    return service.list();
  }

  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public StudentRespone getById(@PathVariable("id") long id) {
    log.info("(getById)get by id: {}", id);
    return service.getById(id);
  }

  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public StudentRespone update(@RequestBody @Valid UpdateStudent request,
      @PathVariable("id") long id) {
    log.info("(Update)student update: {}", request);
    return service.update(id, request);
  }
}
