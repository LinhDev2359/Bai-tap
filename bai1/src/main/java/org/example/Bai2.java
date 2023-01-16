package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai2 {

  public final void bai2(){

    List<Integer> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int n;
    int so;

    System.out.print("Nhap do dai n: ");
    do {
      n = scanner.nextInt();
      if (n <= 0 || n > 100000) {
        System.out.println("Nhap sai, yeu cau nhap lai!!");
      }
    } while (n <= 0 || n > 100000);

    for (int index = 1; index <= n; index ++) {
      so = scanner.nextInt();
      list.add(so);
    }

    int size = list.size();

    for (int j = 0; j < size -1; j ++) {
      for (int index = 0; index < size - 1; index++) {
        if (list.get(0) % 3 == 0) {
          list.remove(0);
        }
        if (list.get(size - 2) % 3 == 0) {
          list.remove(size - 1);
        }
        if ((list.get(0) + list.get(1) % 3 == 0)) {
          list.remove(0);
          list.remove(1);
        }
        if ((list.get(size - 2) + list.get(size - 3) % 3 == 0)) {
          list.remove(size - 2);
          list.remove(size - 3);
        }
      }
    }

    for (int index = 0; index < size-1; index++) {
      System.out.print(list.get(index));
    }

  }

}
