package org.albles.feature.student.service;

import org.albles.feature.student.dto.StudentResponse;

public interface StudentService {

  StudentResponse create(String name, int age, String classroomId);
}
