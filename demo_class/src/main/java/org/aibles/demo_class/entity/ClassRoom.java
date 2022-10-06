package org.aibles.demo_class.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "class_room")
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_class")
    private int id_class;

    @Column(name ="name_class")
    private String name_class;

    @Column(name ="department")
    private String department;

    @Column(name ="training_system")
    private String training_system;

    @Column(name ="year_of_admission")
    private int year_of_admission;

    @Column(name ="number_student")
    private int number_student;

    @Column(name ="id_department")
    private int id_department;


    @Override
    public String toString() {
        return "Class{" +
                "id_class=" + id_class +
                ", name_class='" + name_class + '\'' +
                ", department='" + department + '\'' +
                ", training_system='" + training_system + '\'' +
                ", year_of_admission='" + year_of_admission + '\'' +
                ", number_student='" + number_student + '\'' +
                ", id_department='" + id_department + '\'' +
                '}';
    }
}
