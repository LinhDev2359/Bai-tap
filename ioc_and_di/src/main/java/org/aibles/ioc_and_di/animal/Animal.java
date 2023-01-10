package org.aibles.ioc_and_di.animal;

import org.springframework.stereotype.Component;

@Component
public class Animal {
  String name;
  String sex;
  String habitat;

  public Animal() {
  }

  public Animal(String name, String sex, String habitat) {
    this.name = name;
    this.sex = sex;
    this.habitat = habitat;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getHabitat() {
    return habitat;
  }

  public void setHabitat(String habitat) {
    this.habitat = habitat;
  }


}
