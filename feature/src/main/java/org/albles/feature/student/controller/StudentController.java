package org.albles.feature.student.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.albles.feature.student.dto.StudentRequest;
import org.albles.feature.student.dto.StudentResponse;
import org.albles.feature.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
@Slf4j
@RequiredArgsConstructor
public class StudentController {

  private final StudentService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public StudentResponse create(@RequestBody @Validated() StudentRequest request) {
    log.info("(create)request: {}", request);
    return service.create(request.getName(), request.getAge(), request.getClassroomId());
  }
}
