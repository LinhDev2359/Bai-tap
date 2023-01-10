package org.example;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    long soDaQuy, chieuCao;
    long themBot = 0;
    long tang = 0;

    do {
      System.out.printf("\nNhap so da quy: ");
      soDaQuy = scanner.nextInt();
      if(soDaQuy < 0 || soDaQuy > 10000) {
        System.out.printf("Nhap sai, yeu cau nhap lai!!\n");
      }
    } while (soDaQuy < 0 || soDaQuy > 10000);

    if (soDaQuy == 0) {
      System.out.printf("0 1 1");
    }

    themBot = soDaQuy;

    long tim = (long) Math.sqrt(2 * Math.sqrt(soDaQuy));
    for (chieuCao = tim - 3; chieuCao <= tim + 3; chieuCao++) {
      long soDaQuySuDung = chieuCao * (chieuCao + 1) / 2;
      soDaQuySuDung *= soDaQuySuDung;
      if (chieuCao > tang && Math.abs(soDaQuy - soDaQuySuDung) <= Math.abs(themBot)) {
        tang = chieuCao;
        themBot = soDaQuy - soDaQuySuDung;
      }
    }

    if (themBot == 0) {
      System.out.printf("\n1 " + tang);
    }
    if (themBot > 0) {
      System.out.printf("\n0 -" + themBot + " " + tang);
    } else {
      System.out.printf("\n0 " + Math.abs(themBot) + " " + tang);
    }

  }
}