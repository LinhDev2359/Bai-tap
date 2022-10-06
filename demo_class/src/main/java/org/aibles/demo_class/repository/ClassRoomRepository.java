package org.aibles.demo_class.repository;

import org.aibles.demo_class.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Integer> {
}
