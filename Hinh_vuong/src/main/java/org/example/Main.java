package org.example;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.printf("Nhap do dai canh hinh vuong: ");
    int n = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.printf("* ");
      }
      System.out.printf("\n");
    }
  }
}