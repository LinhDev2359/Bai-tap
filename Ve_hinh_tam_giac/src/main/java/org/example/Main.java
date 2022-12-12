package org.example;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.printf("Nhap so dong cua tam gia: ");
    int n = scanner.nextInt();

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n-i; j++) {
        System.out.printf(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.printf("* ");
      }
      System.out.printf("\n");
    }

  }
}