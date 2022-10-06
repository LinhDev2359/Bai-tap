package org.aibles.animal.dto.request;

import org.aibles.animal.entity.Animal;

public class ListAnimalRequest extends CreateAnimalRequest {

  public ListAnimalRequest() {
    super();
  }

  public Animal toAnimal() {
    Animal animal = new Animal();
    animal.setName(this.getName());
    animal.setDate(this.getDate());
    animal.setWeight(this.getWeight());
    animal.setPlaceToLive(this.getPlaceToLive());
    animal.setCountry(this.getCountry());
    return animal;
  }
}
