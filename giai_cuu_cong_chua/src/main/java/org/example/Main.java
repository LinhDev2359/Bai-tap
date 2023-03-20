package org.example;

import java.util.Queue;

public class Main {

  public static void main(String[] args) {

    int[] a = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int count = 0, count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0;
    for (int index = 0; index < a.length; index++) {
      if (a[index] == 1) {
        count++;
      }
      if (a[index] == 2) {
        count1++;
      }
      if (a[index] == 3) {
        count2++;
      }
      if (a[index] == 4) {
        count3++;
      }
      if (a[index] == 5) {
        count4++;
      }
      if (a[index] == 6) {
        count5++;
      }
      if (a[index] == 7) {
        count6++;
      }
      if (a[index] == 8) {
        count7++;
      }
      if (a[index] == 9) {
        count8++;
      }

    }
    System.out.printf("so 1 co " + count +" so");
    System.out.printf("so 2 co " + count1 +" so");
    System.out.printf("so 3 co " + count2 +" so");
    System.out.printf("so 4 co " + count3 +" so");
    System.out.printf("so 5 co " + count4 +" so");
    System.out.printf("so 6 co " + count5 +" so");
    System.out.printf("so 7 co " + count6 +" so");
    System.out.printf("so 8 co " + count7 +" so");
    System.out.printf("so 9 co " + count8 +" so");

  }
}