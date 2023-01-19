package org.trandingjava.arrayexecises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
   * @param list - list after being shuffled
   */
  public void display(ArrayList<Integer> list) {

    System.out.printf(list + " ");
    }

  /**
   * number search function satisfying the condition
   * @param arrayList - sequence of numbers after being sorted
   * @return a sequence of numbers satisfying the condition
   */
  public ArrayList<Integer> search(ArrayList<Integer> arrayList) {

    ArrayList<Integer> list = new ArrayList<>();

    // tìm kiếm giá trị thỏa mãn điều kiện
    for (int temp : arrayList) {
      if (temp %10 == 0  || temp %10 == 3) {
        list.add(temp);
      }
    }

    return list;
  }

  /**
   * position shuffle function
   * @param list - a sequence of numbers satisfying the condition
   * @return a sequence of numbers after being shuffled
   */
  public ArrayList<Integer> suffer(ArrayList<Integer> list) {

    Collections.shuffle(list); //xáo trộn vị trí

    return list;
  }

  /**
   * sort function
   * @param stringBuilder - string value after input
   * @return a list after being sorted
   */
  public ArrayList<Integer> sort(StringBuilder stringBuilder) {

    String string = stringBuilder.toString();
    String[] stringArray = string.split("\\s");

    ArrayList<Integer> list = new ArrayList<>();

    for (String temp : stringArray) {
      int number = Integer.parseInt(temp);
      list.add(number);
    }

    list.sort(Comparator.naturalOrder()); // sắp xếp từ bé đến lớn

    return list;
  }

}
