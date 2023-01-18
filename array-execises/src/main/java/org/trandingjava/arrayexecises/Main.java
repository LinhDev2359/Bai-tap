package org.trandingjava.arrayexecises;

//Ý tưởng
// Nhập độ dài của mảng
// Nhập giá trị vào mảng
// kiểm tra đạt đủ điều kiện không
// Hiển thị số đã đạt điều kiện
public class Main {

  public static void main(String[] args) {
    var arrayExecises = new ArrayExecises();

    StringBuilder stringBuilder = arrayExecises.set();

    StringBuilder stringBuilder2 = arrayExecises.search(stringBuilder);

    arrayExecises.display(stringBuilder2);
  }
}