package org.aibles.car_new.dto.response;

import javax.validation.constraints.NotBlank;
import org.aibles.car_new.entity.Car;

public class CarResponse {

  private long id;
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

  public CarResponse() {}

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

  public static CarResponse from(Car car) {
    CarResponse response = new CarResponse();
    response.setId(car.getId());
    response.setName(car.getName());
    response.setBrand(car.getBrand());
    response.setEngineType(car.getEngineType());
    response.setColor(car.getColor());
    response.setPrice(car.getPrice());
    response.setAmount(car.getAmount());
    return response;
  }
}
