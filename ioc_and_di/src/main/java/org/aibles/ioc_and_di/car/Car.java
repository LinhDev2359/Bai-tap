package org.aibles.ioc_and_di.car;


public class Car {

  String name;
  String color;

  public Car() {
  }

  public Car(String name, String color) {
    this.name = name;
    this.color = color;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
