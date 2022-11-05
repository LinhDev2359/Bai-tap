package org.aibles.redis.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.aibles.redis.dto.StudentDtoRequest;
import org.aibles.redis.dto.StudentDtoResponse;
import org.aibles.redis.entity.Student;
import org.aibles.redis.exception.InternalServerBaseException;
import org.aibles.redis.exception.NotFoundBaseException;
import org.aibles.redis.repository.RedisRepository;
import org.aibles.redis.repository.StudentRepository;
import org.aibles.redis.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
public class StudentServiceImpl implements StudentService {

  private RedisRepository redisRepository ;
  private final StudentRepository repository;

  public StudentServiceImpl(StudentRepository repository) {
    this.redisRepository = redisRepository;
    this.repository = repository;
  }

  @Override
  @Transactional(readOnly = true)
  public StudentDtoResponse create(StudentDtoRequest studentDtoRequest) {
    log.info("(create)name: {}", studentDtoRequest.getName());
    Student student = studentDtoRequest.toStudent();
    Student create = repository.save(student);
    redisRepository.save(student);
    return StudentDtoResponse.from(create);
  }

  @Override
  public void delete(Long id) {
    Student student =
    repository
        .findById(id)
        .orElseThrow(
            () -> {
              throw new InternalServerBaseException(id);
            }
        );
    redisRepository.delete(id);
  }

  @Override
  @Transactional(readOnly = true)
  public List<StudentDtoResponse> getAll() {
    redisRepository.findAll();
    return repository.findAll()
        .stream()
        .map(StudentDtoResponse::from)
        .collect(Collectors.toList());
  }

  @Override
  @Transactional(readOnly = true)
  public StudentDtoResponse getById(Long id) {
    Student student =
        repository
            .findById(id)
            .orElseThrow(() -> {
              throw new NotFoundBaseException(id);
            });
    redisRepository.findById(id);
    redisRepository.save(student);
    return StudentDtoResponse.from(student);
  }

  @Override
  @Transactional(readOnly = true)
  public StudentDtoResponse update(long id, StudentDtoRequest studentDtoRequest) {
    Student studentCheck =
        repository
            .findById(id)
            .orElseThrow(
                () -> {
                  throw new NotFoundBaseException(id);
                });
    Student student = studentDtoRequest.toStudent();
    studentCheck.setId(studentCheck.getId());
    Student update = repository.save(student);
    redisRepository.save(student);
    return StudentDtoResponse.from(student);
  }
}
