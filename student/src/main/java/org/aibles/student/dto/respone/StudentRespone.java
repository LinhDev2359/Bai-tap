package org.aibles.student.dto.respone;

import org.aibles.student.entity.Student;

public class StudentRespone {

  private long id;
  private String name;
  private int date;
  private String classroom;
  private String email;
  private String country;
  private String numberPhone;

  public StudentRespone() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDate() {
    return date;
  }

  public void setDate(int date) {
    this.date = date;
  }

  public String getClassroom() {
    return classroom;
  }

  public void setClassroom(String classroom) {
    this.classroom = classroom;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getNumberPhone() {
    return numberPhone;
  }

  public void setNumberPhone(String numberPhone) {
    this.numberPhone = numberPhone;
  }

  public static StudentRespone from(Student student) {
    StudentRespone respone = new StudentRespone();
    respone.setId(student.getId());
    respone.setName(student.getName());
    respone.setDate(student.getDate());
    respone.setClassroom(student.getClassroom());
    respone.setEmail(student.getEmail());
    respone.setCountry(student.getCountry());
    respone.setNumberPhone(student.getNumberPhone());
    return respone;
  }
}
