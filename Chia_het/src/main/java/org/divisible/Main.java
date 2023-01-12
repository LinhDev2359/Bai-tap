package org.divisible;

import java.util.ArrayList;
import java.util.List;

public class Main {

  // ý tưởng thực hiện bài toán là mình sẽ có một list số từ 10-200 và mk sẽ thực hiện kiểm tra
  // các số từ 10-200 đó có chia hết cho 7 mà không chia hết cho 5 hay không
  // sau đó thì hiển thị các số thảo mãn điều kiện ra
  // để mà sau khi kiểm tra xong để hiển thị thì chúng ta sẽ phải lưu những số đó vào một mảng
  // rồi chương trình thực hiện kiểm tra xong sẽ in lần lượt các số đã lưu ra
  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>(); // tạo một mảng tên là list
    int seriesOfNumbers = 10; // khởi tạo giá trị ban đầu = 10

    var exerciseDivisivle = new ExerciseDivisivle();
    var exerciseDivisivle2 = new ExerciseDivisivle2();

//    exerciseDivisivle.search(list);
//
//    exerciseDivisivle.display(list);

    exerciseDivisivle2.display(seriesOfNumbers);

  }
}