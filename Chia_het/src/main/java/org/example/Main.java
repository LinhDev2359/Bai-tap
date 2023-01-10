package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  // ý tưởng thực hiện bài toán là mình sẽ có một list số từ 10-200 và mk sẽ thực hiện kiểm tra
  // các số từ 10-200 đó có chia hết cho 7 mà không chia hết cho 5 hay không
  // sau đó thì hiển thị các số thảo mãn điều kiện ra
  // để mà sau khi kiểm tra xong để hiển thị thì chúng ta sẽ phải lưu những số đó vào một mảng
  // rồi chương trình thực hiện kiểm tra xong sẽ in lần lượt các số đã lưu ra
  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>(); // tạo một mảng tên là list
    for (int index = 10; index <= 200; index++) { // duyệt vòng lặp for giới hạn từ 10-200
      if ((index % 7 == 0) && index % 5 != 0) { // kiểm tra số đó có chia hết cho 7 mà k chia hết cho 5 hay không
        list.add(index); // kiểm tra thành công thì lưu vào list
      }
    }

    for (int index = 0; index < list.size() - 1; index ++) {// bắt đầu duyệt trong list đã lưu
      System.out.printf(list.get(index) + ","); // hiển thị các số đã luu
    }

  }
}