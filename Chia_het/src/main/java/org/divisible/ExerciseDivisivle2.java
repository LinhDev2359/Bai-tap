package org.divisible;

public class ExerciseDivisivle2 {

  // Sử dụng đệ quy để thực hiện kiểm tra và hiển thị giá trị
  // Hàm kiểm tra và hiển thị giá trị
  public void display(int seriesOfNumbers) {

    seriesOfNumbers++; // tăng biến ln sau mỗi lần đệ quy
    if (seriesOfNumbers <= 200) { // điều kiện dừng của chương trình là <=200

      if ((seriesOfNumbers % 7 == 0) && (seriesOfNumbers % 5 != 0)) { // kiểm tra số đó có chia hết cho 7 mà k chia hết cho 5 hay không

        System.out.print(seriesOfNumbers + ", "); // hiển thị các số thỏa mãn điều kiện

      }
      display(seriesOfNumbers); // đệ quy
    }


  }
}
