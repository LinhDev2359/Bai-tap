package org.example;

import java.lang.reflect.Type;
import java.util.Scanner;

public class Main {

  public static Scanner scanner = new Scanner(System.in);

  public static int inputWheel() {
    int wheel;
    do {
      System.out.printf("\nNhap so banh xe: ");
      wheel = scanner.nextInt();
      if (wheel < 0 || wheel > 1000) {
        System.out.printf("Nhap sai, yeu cau nhap lai!!\n");
      }
    } while (wheel < 0 || wheel > 1000);
    return wheel;
  }

  public static void inputCuroa(int index) {
    int startingPoint, endPoint;
    System.out.printf("\nNhap diem bat dau cua day curoa thu "+ index + ": ");
    startingPoint = scanner.nextInt();
    System.out.printf("Nhap diem ket cua day curoa thuc thu "+ index + ": ");
    endPoint = scanner.nextInt();
  }

  public static int inputBelt(int belt, int index) {
    do {
      System.out.printf("Nhap chieu quay cua day curoa thu " + index + "nhap (0 hoac 1): ");
      belt = scanner.nextInt();
      if (belt != 0 && belt != 1) {
        System.out.printf("Nhap sai, yeu cau nhap lai!!\n");
      }
    } while (belt != 0 && belt != 1);
    return belt;
  }

  public static void display(int wheel, int sum) {
    if (sum % 2 == 0) {
      System.out.printf("\nChieu quay cua banh xe " + wheel + " cung chieu kim dong ho");
    } else {
      System.out.printf("\nChieu quay cua banh xe " + wheel + " nguoc chieu kim dong ho");
    }
  }

  public static void run() {
    int belt = 0;
    int sum = 0;

    int wheel = inputWheel();

    for (int index = 1; index < wheel; index ++) {
      inputCuroa(index);
      belt = inputBelt(belt, index);
      sum = sum + belt;
    }

    display(wheel, sum);

  }

  public static void main(String[] args) {

    run();

  }
}