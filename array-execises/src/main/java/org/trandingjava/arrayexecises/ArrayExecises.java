package org.trandingjava.arrayexecises;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExecises {

  /**
   * function that input the number of elements and values
   * @return - 1 value string entered
   */
  public StringBuilder set() {
    Scanner scanner = new Scanner(System.in);
    StringBuilder stringBuilder = new StringBuilder();
    int length;
    int value;

    System.out.printf("Nhap do dai cua mang(tu 1 den 10^6): ");
    // giới hạn độ dài mảng
    do {
      length = scanner.nextInt();
      if (length <= 0 || length > 10e6) {
        System.out.printf("Nhap sai, yeu cau nhap lai!!!");
      }
    } while (length <= 0 || length > 10e6);

    // nhập các giá trị vào mảng
    for (int index = 0; index < length; index++) {
      System.out.printf("Gia tri thu " + (index + 1) + ": ");
      value = scanner.nextInt();
      stringBuilder.append(value + " ");
    }

    return stringBuilder;

  }

  /**
   * display function
   * @param stringBuilder - string after being checked
   */
  public void display(StringBuilder stringBuilder) {

    System.out.printf(stringBuilder + " ");
    }

  /**
   * search function
   * @param stringBuilder1 - string after import
   * @return - string after being checked
   */

  public StringBuilder search(StringBuilder stringBuilder1) {

    String string = stringBuilder1.toString();
    String[] stringArray = string.split("\\s");

    StringBuilder stringBuilder2 = new StringBuilder();


    for (String temp : stringArray) {
      int number = Integer.parseInt(temp);
      if (number %10 == 0  || number %10 == 3) {
        stringBuilder2.append(number + " ");
      }
    }

    return stringBuilder2;
  }

}
