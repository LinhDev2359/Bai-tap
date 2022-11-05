package org.aibles.redis.dto;

import org.aibles.redis.entity.Student;

public class StudentDtoResponse {

  private long id;
  private String name;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static StudentDtoResponse from(Student student) {
    StudentDtoResponse response = new StudentDtoResponse();
    response.setId(student.getId());
    response.setName(student.getName());
    return response;
  }
}
