package org.example;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.printf("Nhap chieu dai hinh chu nhat: ");
    int m = Integer.parseInt(scanner.nextLine());
    System.out.printf("Nhap chieu rong hinh chu nhat: ");
    int n = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < m ;i++) {
      for (int j = 0; j < n; j++) {
        System.out.printf("* ");
      }
      System.out.printf("\n");
    }
  }
}