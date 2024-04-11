package org.albles.feature.student.dto;

import lombok.Data;

@Data
public class StudentRequest {

  private String name;
  private int age;
  private String classroomId;
}
