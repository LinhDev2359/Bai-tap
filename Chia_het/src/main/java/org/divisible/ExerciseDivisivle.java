package org.divisible;

import java.util.List;

public class ExerciseDivisivle {

  // Hàm tìm các số chia hết
  public void search(List<Integer> list) {

    for (int index = 10; index <= 200; index++) { // duyệt vòng lặp for giới hạn từ 10-200

      if ((index % 7 == 0)
          && index % 5 != 0) { // kiểm tra số đó có chia hết cho 7 mà k chia hết cho 5 hay không
        list.add(index); // kiểm tra thành công thì lưu vào list
      }

    }
  }

  // Hàm hiển thị
  public void display(List<Integer> list) {

    int size = list.size(); // gán chiều dài của list thành size

    for (int index = 0; index < size - 1; index++) {// bắt đầu duyệt trong list đã lưu

      System.out.printf(list.get(index) + ","); // hiển thị các số đã luu

    }
    System.out.println(list.get(size - 1)); // hiển thị giá trị cuối cùng của list
  }

}


