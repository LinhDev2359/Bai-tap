package org.trandingjava.arrayexecises;

import java.util.ArrayList;

//Ý tưởng
// Nhập độ dài của mảng
// Nhập giá trị vào mảng
// kiểm tra đạt đủ điều kiện không
// Hiển thị số đã đạt điều kiện
public class Main {

  public static void main(String[] args) {
    System.out.println("Đây là hàm main");
    var arrayExecises = new ArrayExecises();

    StringBuilder stringBuilder = arrayExecises.set();

    ArrayList<Integer> stringBuilder1 = arrayExecises.sort(stringBuilder);

    ArrayList<Integer> stringBuilder2 = arrayExecises.search(stringBuilder1);

    ArrayList<Integer> stringBuilder3 = arrayExecises.suffer(stringBuilder2);

    arrayExecises.display(stringBuilder3);
  }
}