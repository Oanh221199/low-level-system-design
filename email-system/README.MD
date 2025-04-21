# Email Management System

## Giới thiệu
Hệ thống này giúp quản lý email cho nhiều loại người dùng khác nhau, bao gồm người dùng thường (Regular User) và người dùng VIP (VIP User). Mỗi loại người dùng có các yêu cầu xử lý email khác nhau, từ việc lọc email chưa đọc, lọc email từ một người gửi cụ thể, đến việc tìm kiếm email gần đây nhất.

### Các yêu cầu chức năng:
1. **Lọc email chưa đọc**:
    - Regular User: Lọc tất cả email chưa đọc, bất kể nội dung.
    - VIP User: Lọc email chưa đọc và loại bỏ các email có thể là spam.

2. **Lọc email từ một người gửi cụ thể**:
    - Regular User: Trả về tất cả email từ người gửi đó, kể cả email quảng cáo hay spam.
    - VIP User: Chỉ trả về email từ người gửi đó nếu không chứa nội dung nghi ngờ là spam.

3. **Tìm email gần đây nhất**:
    - Regular User: Tìm email có thời gian gửi gần nhất, bất kể nội dung.
    - VIP User: Tìm email gần đây nhất không bị nghi ngờ là spam.

4. **Email Spam**:
    - Email spam là loại email mà tiêu đề chứa từ "spam", "promotion", "win".

---

## Cấu trúc dự án

Dự án này sử dụng **OOP (Lập trình hướng đối tượng)** và **Java 8** để mô phỏng hệ thống email.


### Cấu trúc lớp

- `Email`: Đại diện cho một email. Lớp này sẽ chứa các thuộc tính như `sender`, `subject`, `content`, `receivedDate`, và `isRead` ( đóng gói)
- `User`: Lớp cơ sở đại diện cho người dùng. Các phương thức của lớp này sẽ bao gồm các hành động như lọc email chưa đọc và tìm kiếm email ( trừu tượng).
- `RegularUser`: Kế thừa từ `User`, đại diện cho người dùng thường với các quy tắc xử lý email đơn giản ( kế thừa ).
- `VipUser`: Kế thừa từ `User`, đại diện cho người dùng VIP với các quy tắc xử lý email nâng cao (loại bỏ email spam)(kế thừa).
- `EmailService`: Cung cấp các chức năng tìm kiếm và lọc email, bao gồm lọc email chưa đọc, lọc theo người gửi và tìm email gần đây nhất ( Trừu tượng).
- `RegularService`: Ghi đè các chức năng tìm kiếm và lọc email, bao gồm lọc email chưa đọc, lọc theo người gửi và tìm email gần đây nhất ( Kế thừa, đa hình).
  Có sử dụng Stream API,  Lambda function, Method Reference, Optional của java 8.
- `VipEmailService`: Ghi đè các chức năng tìm kiếm và lọc email, bao gồm lọc email chưa đọc, lọc theo người gửi và tìm email gần đây nhất ( Kế thừa, đa hình).
  Có sử dụng Stream API,  Lambda function, Method Reference, Optional của java 8.  
---

## Hướng dẫn cài đặt và chạy

1. **Cài đặt Java 8**: Đảm bảo bạn đã cài đặt Java 8 hoặc phiên bản mới hơn.
2. **Clone dự án**:
   ```bash
   git clone https://github.com/Oanh221199/low-level-system-design.git
