package org.aibles.demo_class.service.impl;

import org.aibles.demo_class.entity.ClassRoom;
import org.aibles.demo_class.repository.ClassRoomRepository;
import org.aibles.demo_class.service.ClassRoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    private final ClassRoomRepository classRoomRepository;


    public ClassRoomServiceImpl(ClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    @Override
    public ClassRoom createdClassRoom(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }

    @Override
    public ClassRoom updatedClassRoom(int id, ClassRoom classRoom) {
        return null;
    }

    @Override
    public List<ClassRoom> listClassRoom() {
        return classRoomRepository.findAll();
    }
}
