package org.albles.feature.student.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.albles.feature.student.dto.StudentRequest;
import org.albles.feature.student.dto.StudentResponse;
import org.albles.feature.student.entity.Student;
import org.albles.feature.student.repository.StudentRepository;
import org.albles.feature.student.service.StudentService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

  private final StudentRepository repository;

  @Override
  public StudentResponse create(String name, int age, String classroomId) {
    log.info("(create)name: {}, age: {}, classroomId: {}", name, age, classroomId);
    Student student = new Student();
    student.setName(name);
    student.setAge(age);
    student.setClassroomId(classroomId);
    return StudentResponse.from(repository.save(student));
  }
}
