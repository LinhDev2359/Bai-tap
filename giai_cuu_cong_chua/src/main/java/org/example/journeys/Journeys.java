package org.example.journeys;

public class Journeys {

  int villageX ;
  int villageY ;
  int cost;

  public Journeys() {
  }

  public Journeys(int villageX, int villageY, int cost) {
    this.villageX = villageX;
    this.villageY = villageY;
    this.cost = cost;
  }

  public int getVillageX() {
    return villageX;
  }

  public void setVillageX(int villageX) {
    this.villageX = villageX;
  }

  public int getVillageY() {
    return villageY;
  }

  public void setVillageY(int villageY) {
    this.villageY = villageY;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }
}
