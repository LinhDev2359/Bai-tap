package org.aibles.redis.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aibles.redis.dto.StudentDtoRequest;
import org.aibles.redis.dto.StudentDtoResponse;
import org.aibles.redis.service.StudentService;
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

@RestController
@RequestMapping("/api/v1/students")
@Slf4j
public class StudentController {

  private final StudentService service;

  public StudentController(StudentService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public StudentDtoResponse create( @RequestBody @Valid StudentDtoRequest studentDtoRequest) {
    log.info("(create)name: {}", studentDtoRequest.getName());
    return service.create(studentDtoRequest);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteById(@PathVariable("id") long id) {
    service.delete(id);
  }

  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public StudentDtoResponse getById(@PathVariable("id") long id) {
    return service.getById(id);
  }

  @GetMapping("/all/{id}")
  @ResponseStatus(HttpStatus.OK)
  public List<StudentDtoResponse> getAll() {
    return service.getAll();
  }

  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public StudentDtoResponse update(@PathVariable("id") long id,
      @RequestBody @Valid StudentDtoRequest studentDtoRequest) {
    return service.update(id, studentDtoRequest);
  }
}
