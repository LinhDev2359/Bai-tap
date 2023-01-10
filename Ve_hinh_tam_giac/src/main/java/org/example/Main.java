package org.example;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

//    Scanner scanner = new Scanner(System.in);
//    System.out.printf("Nhap so dong cua tam gia: ");
//    int n = scanner.nextInt();
//
//    StringBuilder stringBuilder = new StringBuilder();
//    stringBuilder.append("* ");
//    String ve = stringBuilder.toString();
//
//    for (int i = 1; i <= n; i++) {
//      for (int j = 1; j <= n-i; j++) {
//        System.out.printf(" ");
//      }
//      for (int j = 1; j <= i; j++) {
//        System.out.printf(ve);
//      }
//      System.out.printf("\n");
//    }

    int n;
    Scanner sc = new Scanner(System.in);

    System.out.print("enter: ");
    n = sc.nextInt();

    for (int index = 0; index < n; index ++) {
      for (int j = 0; j < n; j ++) {
        System.out.print(" * ");
      }
      System.out.println();
    }


    System.out.println("--------------------------");
    String row = "";
    for (int index = 0; index < n; index ++) {
      for (int j = 0; j < n; j ++) {
        row = row + " * ";
      }
      System.out.println(row);
      row = "";
    }

    System.out.println("--------------------------");
    StringBuilder stringBuilder;
    for (int index = 0; index < n; index ++) {
      stringBuilder = new StringBuilder();
      for (int j = 0; j < n; j ++) {
        stringBuilder.append(" * ");
      }
      System.out.println(stringBuilder.toString());
    }

  }
}