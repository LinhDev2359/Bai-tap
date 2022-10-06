package org.aibles.demo_car.car.entity;

import javax.persistence.*;

@Entity
@Table(name = "car")

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_Car")
    private long id_Car;

    @Column(name ="name_Car", nullable = false)
    private String name_Car;

    @Column(name ="color_Car", nullable = false)
    private String color_Car;

    @Column(name ="date_Car", nullable = false)
    private int date_Car;

    @Column(name ="price_Car", nullable = false)
    private float price_Car;



    //Initialization function
    public long getId() {
        return id_Car;
    }

    public void setId(long id_Car) {
        this.id_Car = id_Car;
    }

    public String getName() {
        return name_Car;
    }

    public void setName(String name_Car) {
        this.name_Car = name_Car;
    }

    public String getColor() {
        return color_Car;
    }

    public void setColor(String color_Car) {
        this.color_Car = color_Car;
    }

    public int getDate() {
        return date_Car;
    }

    public void setDate(int date_Car) {
        this.date_Car = date_Car;
    }

    public float getPrice() {
        return price_Car;
    }

    public void setPrice(float price_Car) {
        this.price_Car = price_Car;
    }
}
