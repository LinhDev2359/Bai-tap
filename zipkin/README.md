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
- Cấu hình Zipkin ser vẻ thì trước đó ta sẽ phải add dependency cho nó trước. Sau đâu là cách add dependency(Đang sử dụng version modul thấp và 
sử dụng Java8, chưa tìm được cách sử dụng modul và java cao hơn).

![image](https://user-images.githubusercontent.com/103310499/229353843-e0f914e4-2e39-44cd-ac9f-4c77c47e9145.png)
![image](https://user-images.githubusercontent.com/103310499/229353859-fa58ceb9-f139-4dab-8377-a5946147f963.png)

- Tiếp đến ta sẽ đặt một annotation để đánh dấu service này là một server của Zipkin
![image](https://user-images.githubusercontent.com/103310499/229353947-cc88090e-ce49-4287-85cb-59ffb91accd0.png)

- Sau đó ta sẽ cấu hình cho server này
![image](https://user-images.githubusercontent.com/103310499/229354017-7ac0f94a-665d-4cbb-adeb-701e2a1b0c1d.png)

- Như vậy ta đã có một server hoàn chỉnh của Zipkin
![image](https://user-images.githubusercontent.com/103310499/229354051-c6dd63cb-a614-4ad1-8bdb-5b5e7378025b.png)


- Bây giờ ta sẽ cài đặt một client 
- Trước tiên ta vẫn phải cài đặt dependency cho nó trước
![image](https://user-images.githubusercontent.com/103310499/229354578-c3c31ace-6759-4fc6-b55e-7f95b28f572a.png)
![image](https://user-images.githubusercontent.com/103310499/229354589-a575359a-f1cb-4570-97d9-19791daca063.png)
![image](https://user-images.githubusercontent.com/103310499/229354594-6c1834fe-96e0-46df-8428-fa7b3fb98c3d.png)

- Về phía client thì chúng ta không cần sử dụng annotation nào của Zipkin nữa cả nhưng về cấu hình chúng ta sẽ thực hiện như sau
![image](https://user-images.githubusercontent.com/103310499/229354637-d769e41b-f8b6-42c4-9808-43f167baf3c4.png)

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


