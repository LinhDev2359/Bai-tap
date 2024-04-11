package org.albles.feature.classroom.service;

import org.albles.feature.classroom.dto.ClassroomResponse;

public interface ClassroomService {

  ClassroomResponse create(String name, int year);
}
