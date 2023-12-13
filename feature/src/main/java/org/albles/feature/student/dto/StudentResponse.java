package org.albles.feature.student.dto;

import org.albles.feature.student.entity.Student;

public record StudentResponse(String id, String name, int age, String classroomId) {

  public static StudentResponse from(Student student) {
    StudentResponse response = new StudentResponse(student.getId(), student.getName(),
        student.getAge(), student.getClassroomId());
    return response;
  }
}
