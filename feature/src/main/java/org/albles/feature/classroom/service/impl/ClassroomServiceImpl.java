package org.albles.feature.classroom.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.albles.feature.classroom.dto.ClassroomResponse;
import org.albles.feature.classroom.entity.Classroom;
import org.albles.feature.classroom.repository.ClassroomRepository;
import org.albles.feature.classroom.service.ClassroomService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClassroomServiceImpl implements ClassroomService {

  private final ClassroomRepository repository;

  @Override
  public ClassroomResponse create(String name, int year) {
    log.info("(create)name: {}, year: {}", name, year);
    Classroom classroom = new Classroom();
    classroom.setName(name);
    classroom.setYear(year);
    return ClassroomResponse.from(repository.save(classroom));
  }
}
