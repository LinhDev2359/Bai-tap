package org.example;

import java.util.Scanner;

public class Main {

  public static Scanner scanner = new Scanner(System.in);

  public static int inputNumberOfVillages() {
    int numberOfVillages;
    do {
      System.out.printf("\nNhap so ngoi lang: ");
      numberOfVillages = scanner.nextInt();
      if (numberOfVillages < 1 || numberOfVillages > 4000) {
        System.out.printf("Nhap sai, yeu cau nhap lai!!\n");
      }
    }while (numberOfVillages < 1 || numberOfVillages > 4000);
    return numberOfVillages;
  }

  public static void run() {
    int numberOfVillages;
    int villageX = 0, villageY = 0;
    int cost = 0;
    int distance = 0;

    numberOfVillages = inputNumberOfVillages();

    for (int index = 1; index < numberOfVillages; index++) {
      do {
        System.out.printf("\nNhap ngoi lang X: ");
        villageX = scanner.nextInt();
        if (villageX < 1) {
          System.out.printf("Nhap sai, yeu cau nhap lai!!");
        }
      }while (villageX < 1);

      do {
        System.out.printf("Nhap ngoi lang Y: ");
        villageY = scanner.nextInt();
        if (villageY > numberOfVillages && villageY != villageY) {
          System.out.printf("Nhap sai, yeu cau nhap lai!!\n");
        }
      }while (villageY > numberOfVillages);

      System.out.printf("Nhap chi phi cua hành trinh: ");
      cost = scanner.nextInt();
    }


  }

  public static void main(String[] args) {

   run();

//    for (int index = 1; index < numberOfVillages; index++) {
//        if (villageX == villageY && )
//    }
//
//    int sum = sum + cost;
//    if (){
//      System.out.printf("Do dai cua hanh trinh dai nhat la: " + distance);
//      System.out.printf("Tong chi phi cua hanh trinh do la: " + sum);
//    }

  }
}