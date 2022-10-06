package org.aibles.car_new.dto.request;

import org.aibles.car_new.entity.Car;

public class UpdateRequest extends CreateRequest{

  private long id;

  public UpdateRequest() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Car toCar() {
    Car car = new Car();
    car.setId(this.getId());
    car.setName(this.getName());
    car.setBrand(this.getBrand());
    car.setEngineType(this.getEngineType());
    car.setColor(this.getColor());
    car.setPrice(this.getPrice());
    car.setAmount(this.getAmount());
    return car;
  }

}
