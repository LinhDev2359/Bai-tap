package org.trandingjava.arrayexecises;

import java.util.ArrayList;
import java.util.List;

//Ý tưởng
// Nhập độ dài của mảng
// Nhập giá trị vào mảng
// Sắp xếp mảng theo thứ tự tăng dần
// kiểm tra đạt đủ điều kiện không
// Hiển thị số đã đạt điều kiện
public class Main {

  public static void main(String[] args) {
    var arrayExecises = new ArrayExecises();

    List<Integer> list = arrayExecises.set();

    arrayExecises.display(list);
  }
}