package org.trandingjava.arrayexecises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ArrayExecises {


  /**
   * Function that input the length of the array and input the value into the array
   * @return - 1 list of values I entered has been sorted
   */
  public List<Integer> set() {
    Scanner scanner = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();
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
      list.add(value);
    }

    //sử dụng phương thức sort để sắp xếp theo thứ tự tăng dần
    list.sort(Comparator.naturalOrder());
    return list;

  }

  /**
   * The function displays the required values and values
   * @param list - 1 array where we need to find the numbers that satisfy the condition
   */
  public void display(List<Integer> list) {

    int length = list.size();

    System.out.printf("Day so ban dau la: ");
    for (int index = 0; index < length; index++) {

      System.out.printf(list.get(index) + " ");

    }

    System.out.printf("Day so sau khi duoc kiem tra");
    for (int index = 0; index < length; index++) {
      if (searchNumber1AtTheTop(list.get(index)) == 1
          || searchNumber3AtTheEnd(list.get(index)) == 3) {// điều kiện để kiểm tra số đó
        System.out.printf(list.get(index) + " ");
      }
    }

  }

  //Hàm tìm các số có đuôi là 3

  /**
   * Function to find numbers ending in 3
   * @param number - 1 value in array
   * @return - get a balance of 10 of the number you entered
   */
  public int searchNumber3AtTheEnd(int number) {

    int check = number % 10;// ta lấy dư 10 để có thể lấy số hàng đơn vị
    return check;

  }

  /**
   * Function to find numbers top in 1
   * @param number - 1 value in array
   * @return - get the first number of the number of dãy số ta đưa vào
   */
  public int searchNumber1AtTheTop(int number) {
    int check = 0;

    // vòng lặp để tìm ra số đầu là 1
    // vòng lặp này sẽ chia 10 lấy dư và chia hẳn 10 để nhảy sang số tiếp theo cho tới khi được số cuối cùng không thể chia được nữa là cho tới số 0
    while (number != 0) {
      check = number % 10;
      number /= 10;
    }

    return check;
  }


}
