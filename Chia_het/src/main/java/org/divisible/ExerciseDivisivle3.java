package org.divisible;

public class ExerciseDivisivle3 {

  // Hàm tìm các số chia hết
  public StringBuilder search(StringBuilder stringBuilder) {

    for (int index = 10; index <= 200; index++) { // duyệt vòng lặp for giới hạn từ 10-200

      if ((index % 7 == 0)
          && index % 5 != 0) { // kiểm tra số đó có chia hết cho 7 mà k chia hết cho 5 hay không
        stringBuilder.append(index + ","); // kiểm tra thành công thì lưu vào chuỗi
      }

    }
    return stringBuilder;

  }

  //Hàm hiển thị
  public void display(StringBuilder stringBuilder) {

    String daySo = stringBuilder.toString(); // gán chuỗi stringbuilder thành chuỗi string
    System.out.println(daySo);

  }


  //Hàm hiển thị 2
  public void display2(StringBuilder stringBuilder) {

    StringBuilder daySo2 = new StringBuilder(stringBuilder); // tạo chuỗi bằng từ khóa new
    System.out.println(daySo2);

  }

  //Hàm hiển thị 3
  public void display3(StringBuilder stringBuilder) {

    System.out.println(stringBuilder.substring(0,stringBuilder.length()));// sử dụng substring Trả về chuỗi con từ chỉ số bắt đầu đến chỉ số kết thúc.

  }
}
