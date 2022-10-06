package org.aibles.demo_class.service;

import org.aibles.demo_class.entity.ClassRoom;
//import org.aibles.demo_class.entity.Student;

import java.util.List;

public interface ClassRoomService {

    ClassRoom createdClassRoom (ClassRoom classRoom);

    ClassRoom updatedClassRoom (int id, ClassRoom classRoom);

    List<ClassRoom> listClassRoom();

}
