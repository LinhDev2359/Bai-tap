package org.aibles.redis.dto;

import org.aibles.redis.entity.Student;

public class StudentDtoRequest {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Student toStudent() {
    Student student = new Student();
    student.setName(this.getName());
    return student;
  }
}
