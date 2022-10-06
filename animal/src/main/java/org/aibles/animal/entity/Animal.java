package org.aibles.animal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animal")
public class Animal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", unique = true, length = 100)
  private String name;

  @Column(name = "date")
  private Integer date;

  @Column(name = "weight")
  private Float weight;

  @Column(name = "place_to_live", unique = true, length = 200)
  private String placeToLive;

  @Column(name = "country", unique = true, length = 200)
  private String country;

  public Animal() {
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getDate() {
    return date;
  }

  public void setDate(Integer date) {
    this.date = date;
  }

  public Float getWeight() {
    return weight;
  }

  public void setWeight(Float weight) {
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


}
