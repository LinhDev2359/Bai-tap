package org.aibles.demo_class.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_student")
    private int id_student;

    @Column(name ="surname_and_cushion")
    private String surname_and_cushion;

    @Column(name ="name")
    private String name;

    @Column(name ="date")
    private String date;

    @Column(name ="sex")
    private String sex;

    @Column(name ="place_of_birth")
    private String place_of_birth;

    @Column(name ="id_class")
    private String id_class;


    @Override
    public String toString() {
        return "student{" +
                "id_student=" + id_student +
                ", surname_and_cushion='" + surname_and_cushion + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", sex='" + sex + '\'' +
                ", place_of_birth='" + place_of_birth + '\'' +
                ", id_class='" + id_class + '\'' +
                '}';
    }

}
