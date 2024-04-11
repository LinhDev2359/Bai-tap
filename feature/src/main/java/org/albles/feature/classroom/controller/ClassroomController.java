package org.albles.feature.classroom.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.albles.feature.classroom.dto.ClassroomRequest;
import org.albles.feature.classroom.dto.ClassroomResponse;
import org.albles.feature.classroom.service.ClassroomService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/classrooms")
@Slf4j
@RequiredArgsConstructor
public class ClassroomController {

  private final ClassroomService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ClassroomResponse create(@RequestBody @Validated() ClassroomRequest request) {
    log.info("(create)request: {}", request);
    return service.create(request.name(), request.year());
  }
}
