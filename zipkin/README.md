1. What?
- Zipkin service là một dịch vụ đóng vai trò là trung tâm xử lý cho các thông tin được thu thập trong quá trình theo dõi hệ thống phân tán 
sử dụng các thư viện của Zipkin hoặc các thư viện tương tự.

2. Why?
- Trong một hệ thống phân tán, khi chúng ta tương tác giữa các service với nhau bằng http.
- Sau đó, Zipkin service sẽ lưu trữ và phân tích các thông tin này để tạo ra các biểu đồ và báo cáo về hiệu suất và tốc độ của các thành phần 
trong hệ thống.
- Zipkin có thể theo dõi các yêu cầu và tương tác giữa các dịch vụ với nhau. Việc này giúp ta xác định các tương tác chậm hoặc có vấn đề và 
giúp giải quyết các vấn đề liên quan đến hiệu suất và tốc độ.
- Với Zipkin service, ta có thể giám sát và quản lý hệ thống một cách hiệu quả hơn, giúp đảm bảo tính sẵn sàng và ổn định của hệ thống.

- Về chung quy Zipkin service sẽ giúp chúng ta dễ dàng đo lường hiệu suất và tốc độ hệ thống, theo dõi các tương tác giữa các dịch vụ, cải 
thiện khả năng giám sát và quản lý hệ thống, giúp ta giải quyết các vấn đề liên quan đến hiệu suất và tốc độ hệ thống.

![image](https://user-images.githubusercontent.com/103310499/229353573-18156595-54e3-4cf9-b12b-73c07066a1de.png)


3. How?

- Để có thể làm về Zipkin service thì đầu tiên ta sẽ phải cài đặt một Zipkin server trước.
- Trước đó chúng ta có ta thường sử dụng @EnableZipkinServer để cấu hình cho Zipkin server. Thời điểm hiện tại, cách sử dụng này không còn được hỗ trợ nữa.
- Vậy chúng ta tạo một Zipkin server kiểu gì? 
- Sau đây tôi sẽ hướng dẫn mọi người cách tạo một Zipkin server:
    + Bước 1: Đầu tiên ta phải clone code của zipkin tại link: https://github.com/openzipkin/zipkin
    + Bước 2: Sau khi clone về ta sẽ mở terminal của nó 
      ![image](https://user-images.githubusercontent.com/103310499/231322564-6c152cc5-2dfa-4c38-957b-6c1ebe4e9477.png)
    + Bước 3: Sau khi mở xong ta sẽ chạy lệnh: ./mvnw -DskipTests --also-make -pl zipkin-server clean install (chờ cho nó build zipkin server, sẽ mất chút thời gian)
    + Bước 4: Sau khi chạy lệnh vừa rồi thì coi như chúng ta đã cấu hình thành công. Để khởi động Zipkin server thì ta sẽ chạy lệnh sau: java -jar ./zipkin-server/target/zipkin-server-2.24.1-SNAPSHOT-exec.jar 
      ![image](https://user-images.githubusercontent.com/103310499/231323147-92d475e4-a5ef-491f-8d77-3615977599d9.png)

- Chúng ta đã hoàn thành cài đặt và khởi động Zipkin server. Đây là giao diện của nó:
![image](https://user-images.githubusercontent.com/103310499/231324027-e4a3d0d8-f952-41cd-8155-b75d841fa121.png)

- Bây giờ ta sẽ cài đặt một client 
- Trước tiên ta vẫn phải cài đặt dependency cho nó trước

![image](https://user-images.githubusercontent.com/103310499/229354578-c3c31ace-6759-4fc6-b55e-7f95b28f572a.png)
![image](https://user-images.githubusercontent.com/103310499/229354589-a575359a-f1cb-4570-97d9-19791daca063.png)
![image](https://user-images.githubusercontent.com/103310499/229354594-6c1834fe-96e0-46df-8428-fa7b3fb98c3d.png)

- Về phía client thì chúng ta sẽ phải cấu hình chúng như sau
![image](https://user-images.githubusercontent.com/103310499/231325426-7ce4b7e3-62da-44ec-a6a8-eb77ae6db5e4.png)
![image](https://user-images.githubusercontent.com/103310499/231325530-56ed2b83-8b71-4463-9b04-9cf61046ddd4.png)


- Ở đây spring.zipkin.base-url: sẽ là chỗ để ta có hể chỉ đến phía port mà server Zipkin đã config
- sampler: probability ở đây có nghĩa là mỗi một request sẽ có một trace ID mới và bắt đầu một hoạt động mới

- Ở bên client chúng ta sẽ hay thấy các từ như trace, span, tracing, brave, sample sau đây tôi sẽ giải thích các từ này nó có 
nghĩa là gì với Zipkin của chúng ta.
  + span: span là quá trình quá trình tương tác với hệ thống. Nó sẽ gửi và nhận các request của HTTP
  + trace: là tập hợp các span được tổ chức dưới dạng cây
  + brave: brave được sử dụng để tạo ra các span mới
  + sample là những dữ liệu của span sẽ được gửi tới các hệ thống như Zipkin
  + reporter: chịu trách nhiệm gửi thông tin trace đến Zipkin Server
  + tracing: nó sẽ chứa toàn bộ thông tin của sample và reporter và cho phép bạn theo dõi các yêu cầu HTTP khi chúng đi qua các ứng dụng khác nhau.

- Ở đây tôi có tạo một controller của client1 và client2
![image](https://user-images.githubusercontent.com/103310499/231324344-358b288a-52f6-4964-b155-f8751612620b.png)
![image](https://user-images.githubusercontent.com/103310499/231324374-a0e29a86-010e-40a9-bca7-cca4aefd86a0.png)


- Khi chúng ta chạy localhost như bên dưới thì mọi hành động sẽ được ghi lại và đẩy lên Zipkin server
![image](https://user-images.githubusercontent.com/103310499/231324413-86faf22c-bef6-4a37-b495-98d3d40092bd.png)

- Đây sẽ là các thông tin được theo dõi và được Zipkin server lưu trữ
- ![image](https://user-images.githubusercontent.com/103310499/231325060-7e87b50e-ca00-4993-89c4-b3d8062098a3.png)





