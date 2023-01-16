package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai1 {

  public final void bai1() {
    List<Integer> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int n;
    int thaoTac;

    System.out.println("Nhap do dai n: ");
    do {
      n = scanner.nextInt();
      if (n <= 0 || n > 100000) {
        System.out.println("Nhap sai, yeu cau nhap lai!!");
      }
    } while (n <= 0 || n > 100000);

    System.out.println("Nhap so thao tac: ");
    thaoTac = scanner.nextInt();

    for (int index = 1; index <= n; index ++) {
      list.add(index);
    }

    for (int index = 0; index < n-1; index ++) {
      for (int j = index + 1; j < n; j++) {

      }
    }


//    do {
//      thaoTac = scanner.nextInt();
//      if (thaoTac < 0 || thaoTac > 100000) {
//        System.out.println("Nhap sai, yeu cau nhap lai!!");
//      }
//    } while (thaoTac < 0 || thaoTac > 100000);


  }
}
