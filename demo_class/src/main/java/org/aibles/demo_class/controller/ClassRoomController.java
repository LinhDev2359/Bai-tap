package org.aibles.demo_class.controller;

import org.aibles.demo_class.entity.ClassRoom;
//import org.aibles.demo_class.entity.Student;
import org.aibles.demo_class.service.ClassRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/classrooms")
public class ClassRoomController {
    private final ClassRoomService classRoomService;

    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }


    @PostMapping
    public ResponseEntity<ClassRoom> createdStudent(@RequestBody ClassRoom classRoom) {
        ClassRoom createdClassRoom = classRoomService.createdClassRoom(classRoom);
        return new ResponseEntity<>(createdClassRoom, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClassRoom>> listClassRoom() {
        List<ClassRoom> classRoomList = classRoomService.listClassRoom();
        return new ResponseEntity<>(classRoomList, HttpStatus.OK);
    }
}
