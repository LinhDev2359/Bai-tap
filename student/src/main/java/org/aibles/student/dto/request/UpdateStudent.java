package org.aibles.student.dto.request;

import org.aibles.student.entity.Student;

public class UpdateStudent extends CreateStudent {

  private long id;

  public UpdateStudent() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Student toStudent() {
    Student student = new Student();
    student.setId(this.getId());
    student.setName(this.getName());
    student.setDate(this.getDate());
    student.setClassroom(this.getClassroom());
    student.setEmail(this.getEmail());
    student.setCountry(this.getCountry());
    student.setNumberPhone(this.getNumberPhone());
    return student;
  }
}
