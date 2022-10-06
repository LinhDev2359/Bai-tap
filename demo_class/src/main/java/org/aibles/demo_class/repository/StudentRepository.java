package org.aibles.demo_class.repository;

import org.aibles.demo_class.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
