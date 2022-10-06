package org.aibles.animal.dto.request;

import com.sun.istack.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.aibles.animal.entity.Animal;

public class CreateAnimalRequest {

  @NotBlank(message = "can't be empty")
  @Size(min = 2, max = 100, message = "lengths name from 2 to 100")
  private String name;
  @NotNull
  private int date;
  @NotNull
  private float weight;
  @NotBlank(message = "can't be empty")
  @Size(min = 2, max = 200, message = "lengths place to live from 2 to 200")
  private String placeToLive;
  @NotBlank(message = "can't be empty")
  @Size(min = 2, max = 200, message = "lengths country name from 2 to 200")
  private String country;

  public CreateAnimalRequest() {
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

  public float getWeight() {
    return weight;
  }

  public void setWeight(float weight) {
    this.weight = weight;
  }

  public String getPlaceToLive() {
    return placeToLive;
  }

  public void setPlaceToLive(String placeToLive) {
    this.placeToLive = placeToLive;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
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
