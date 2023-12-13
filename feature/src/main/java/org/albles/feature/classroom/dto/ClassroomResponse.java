package org.albles.feature.classroom.dto;

import org.albles.feature.classroom.entity.Classroom;

public record ClassroomResponse(String id, String name, int year) {

  public static ClassroomResponse from(Classroom classroom) {
    ClassroomResponse response = new ClassroomResponse(classroom.getId(), classroom.getName(),
        classroom.getYear());
    return response;
  }
}
