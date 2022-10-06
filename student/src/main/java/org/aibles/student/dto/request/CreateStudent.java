package org.aibles.student.dto.request;

import javax.validation.constraints.NotBlank;
import org.aibles.student.entity.Student;

public class CreateStudent {

  @NotBlank
  private String name;
  private int date;
  @NotBlank
  private String classroom;
  @NotBlank
  private String email;
  @NotBlank
  private String country;
  @NotBlank
  private String numberPhone;

  public CreateStudent() {
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

  public Student toStudent() {
    Student student = new Student();
    student.setName(this.getName());
    student.setDate(this.getDate());
    student.setClassroom(this.getClassroom());
    student.setEmail(this.getEmail());
    student.setCountry(this.getCountry());
    student.setNumberPhone(this.getNumberPhone());
    return student;
  }
}
