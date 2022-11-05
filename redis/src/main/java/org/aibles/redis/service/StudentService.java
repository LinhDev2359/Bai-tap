package org.aibles.redis.service;

import java.util.List;
import org.aibles.redis.dto.StudentDtoRequest;
import org.aibles.redis.dto.StudentDtoResponse;

public interface StudentService {

  StudentDtoResponse create(StudentDtoRequest studentDtoRequest);
  void delete(Long id);
  List<StudentDtoResponse> getAll();
  StudentDtoResponse getById(Long id);
  StudentDtoResponse update(long id, StudentDtoRequest studentDtoRequest);


}
