package org.aibles.student.service;

import java.util.List;
import org.aibles.student.dto.request.CreateStudent;
import org.aibles.student.dto.request.UpdateStudent;
import org.aibles.student.dto.respone.StudentRespone;
import org.aibles.student.entity.Student;

public interface StudentService {

  StudentRespone create(CreateStudent createStudent);

  void delete(long id);

  void deleteAll();

  List<Student> list();

  StudentRespone getById(long id);

  StudentRespone update(long id, UpdateStudent updateStudent);
}
