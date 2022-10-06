package org.aibles.car_new.dto.request;

import javax.validation.constraints.NotBlank;
import org.aibles.car_new.entity.Car;

public class CreateRequest {

  @NotBlank
  private String name;
  @NotBlank
  private String brand;
  @NotBlank
  private String engineType;
  @NotBlank
  private String color;
  private long price;
  private int amount;

  public CreateRequest() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getEngineType() {
    return engineType;
  }

  public void setEngineType(String engineType) {
    this.engineType = engineType;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public Car toCar() {
    Car car = new Car();
    car.setName(this.getName());
    car.setBrand(this.getBrand());
    car.setEngineType(this.getEngineType());
    car.setColor(this.getColor());
    car.setPrice(this.getPrice());
    car.setAmount(this.getAmount());
    return car;
  }
}
