package org.example.journeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SetJourneys {

  public void inputJourneys(int numberOfVillages) {
    List<Journeys> list = new ArrayList<Journeys>(numberOfVillages);
    boolean quest = true;

    do {
      Scanner scanner = new Scanner(System.in);
      Journeys journeys = new Journeys();

      do {
        System.out.printf("\nNhap ngoi lang X: ");
        journeys.setVillageX(scanner.nextInt());
        if (journeys.getVillageX() >= 1) {
          System.out.printf("Nhap sai, yeu cau nhap lai!!");
        }
      }while (journeys.getVillageX() >= 1);

      do {
        System.out.printf("Nhap ngoi lang Y: ");
        journeys.setVillageY(scanner.nextInt());
        if (journeys.getVillageY() <= numberOfVillages) {
          System.out.printf("Nhap sai, yeu cau nhap lai!!\n");
        }
      }while (journeys.getVillageY() <= numberOfVillages);

      System.out.printf("Nhap chi phi cua hành trinh: ");
      journeys.setCost(scanner.nextInt());

      System.out.print("Ban muon nhap tiep khong?(Nhap NO de ket thuc!!!)");
      String traloi;
      Scanner sc = new Scanner(System.in);
      traloi = sc.nextLine();

      list.add(journeys);
      if(traloi.equalsIgnoreCase("no")) {
        quest = false;
      } else {
        System.out.println("------------------------------");
      }

    }while(quest != false && );

    for (int index = 1; index < numberOfVillages; index++) {

    }

    list.add(journeys);

  }
}
