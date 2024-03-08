CREATE DATABASE mazCinema
USE mazCinema
-- Tạo bảng Accounts để lưu thông tin về tài khoản
CREATE TABLE Accounts (
   AccountID NVARCHAR(50) PRIMARY KEY, -- Mã tài khoản
   Username NVARCHAR(50), -- Tên đăng nhập
   Password NVARCHAR(100), -- Mật khẩu (cần mã hóa)
   Role NVARCHAR(20) -- Vai trò của tài khoản ('admin', 'user')
);

-- Tạo bảng Customers để lưu thông tin về khách hàng
CREATE TABLE Customers (
   CustomerID NVARCHAR(50) PRIMARY KEY, -- Mã khách hàng
   AccountID NVARCHAR(50), -- Mã tài khoản
   FirstName NVARCHAR(50), -- Họ
   LastName NVARCHAR(50), -- Tên
   Email NVARCHAR(100), -- Địa chỉ email
   Phone NVARCHAR(20), -- Số điện thoại
   Address NVARCHAR(255), -- Địa chỉ
   FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID) -- Khóa ngoại tham chiếu tới bảng Accounts
);

-- Tạo bảng Movies để lưu thông tin về các bộ phim
CREATE TABLE Movies (
   MovieID NVARCHAR(50) PRIMARY KEY, -- Mã phim
   Title NVARCHAR(100), -- Tên phim
   Director NVARCHAR(100), -- Đạo diễn
   ReleaseDate DATE, -- Ngày phát hành
   Genre NVARCHAR(50), -- Thể loại
   DurationMinutes INT -- Thời lượng (phút)
);

-- Tạo bảng Rooms để lưu thông tin về các phòng chiếu
CREATE TABLE Rooms (
   RoomID NVARCHAR(50) PRIMARY KEY, -- Mã phòng
   RoomName NVARCHAR(50), -- Tên phòng
   Capacity INT -- Sức chứa
);

-- Tạo bảng Screenings để lưu thông tin về các lịch chiếu phim trong các phòng chiếu
CREATE TABLE Screenings (
   ScreeningID NVARCHAR(50) PRIMARY KEY, -- Mã lịch chiếu
   MovieID NVARCHAR(50), -- Mã phim
   RoomID NVARCHAR(50), -- Mã phòng
   ScreeningTime DATETIME, -- Thời gian chiếu
   FOREIGN KEY (MovieID) REFERENCES Movies(MovieID), -- Khóa ngoại tham chiếu tới bảng Movies
   FOREIGN KEY (RoomID) REFERENCES Rooms(RoomID) -- Khóa ngoại tham chiếu tới bảng Rooms
);

-- Tạo bảng Seats để lưu thông tin về các ghế ngồi trong các phòng chiếu
CREATE TABLE Seats (
   SeatID NVARCHAR(50) PRIMARY KEY, -- Mã ghế
   RoomID NVARCHAR(50), -- Mã phòng
   SeatNumber NVARCHAR(10), -- Số ghế
   RownName NVARCHAR(10), -- Tên hàng
   IsAvailable BIT, -- Ghế có sẵn hay không (1: có sẵn, 0: không có sẵn)
   FOREIGN KEY (RoomID) REFERENCES Rooms(RoomID) -- Khóa ngoại tham chiếu tới bảng Rooms
);
--Tạo bảng Booking để lưu trữ hoạt động đặt vé của khách hàng 
CREATE TABLE Bookings (
   BookingID NVARCHAR(50) PRIMARY KEY,
   CustomerID NVARCHAR(50),
   ScreeningID NVARCHAR(50),
   SeatID NVARCHAR(50),
   FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
   FOREIGN KEY (ScreeningID) REFERENCES Screenings(ScreeningID),
   FOREIGN KEY (SeatID) REFERENCES Seats(SeatID)
);


