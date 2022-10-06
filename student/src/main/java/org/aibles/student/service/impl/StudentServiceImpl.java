package org.aibles.student.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.aibles.student.dto.request.CreateStudent;
import org.aibles.student.dto.request.UpdateStudent;
import org.aibles.student.dto.respone.StudentRespone;
import org.aibles.student.entity.Student;
import org.aibles.student.exception.ResourceNotFoundException;
import org.aibles.student.repository.StudentRepository;
import org.aibles.student.service.StudentService;

@Slf4j
public class StudentServiceImpl implements StudentService {

  public final StudentRepository repository;

  public StudentServiceImpl(StudentRepository repository) {
    this.repository = repository;
  }

  /**
   * Create student to the list student
   *
   * @return studentRespone
   */
  @Override
  @Transactional
  public StudentRespone create(CreateStudent createStudent) {
    log.info("(create)create student: {}", createStudent);
    Student student = createStudent.toStudent();
    student = repository.save(student);
    StudentRespone studentRespone = StudentRespone.from(student);
    return studentRespone;
  }

  /**
   * Delete student by id in the list student
   */
  @Override
  @Transactional
  public void delete(long id) {
    log.info("(Delete)Delete by id: {}", id);
    repository.deleteById(id);
  }

  /**
   * Delete all student in the list student
   */
  @Override
  @Transactional
  public void deleteAll() {
    log.info("(DeleteAll)");
    repository.deleteAll();
  }

  /**
   * Get student all the list student
   */
  @Override
  @Transactional
  public List<Student> list() {
    log.info("(List)student list");
    return repository.findAll();
  }

  /**
   * Get student by id in the list student
   *
   * @return studentRespone
   */
  @Override
  @Transactional
  public StudentRespone getById(long id) {
    log.info("(getById)id: {}", id);
    Student student = repository.findById(id).orElseThrow(() -> {
      throw new ResourceNotFoundException(id);
    });
    return StudentRespone.from(student);
  }

  /**
   * Update student by id in the list student
   *
   * @return studentRespone
   */
  @Override
  @Transactional
  public StudentRespone update(long id, UpdateStudent updateStudent) {
    log.info("(update)update by id");
    Student studentCheck = repository.findById(id).orElseThrow(() -> {
      throw new ResourceNotFoundException(id);
    });
    Student student = updateStudent.toStudent();
    student.setId(studentCheck.getId());
    student = repository.save(student);
    return StudentRespone.from(student);
  }
}
