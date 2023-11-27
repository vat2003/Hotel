create database QlKhachSan
go
use QLKhachSan
drop database QlKhachSan
go

create table NhanVien(
	maNV int identity(1,1) not null,
	hoTen nvarchar(50) not null,
	ngaySinh date not null,
	phai bit not null,
	diaChi nvarchar(70) null,
	dienThoai varchar(10) not null,
	email varchar(20) not null,
	chucVu bit not null,
	maNQL int null,
	CCCD varchar(15) null,
	primary key (maNV)
	--foreign key (maNQL) references NhanVien(maNV)
)
go


create table HeThong(
	username varchar(10) not null,
	pass varchar(20) not null,
	chucVu bit not null,
	primary key (username)
)
go

create trigger suaSDT on NhanVien after update
as
	update HeThong set username=(select dienThoai from inserted)
	where username = (select dienThoai from deleted)

create table LoaiPhong(
	idLP nvarchar(20) not null,
	gia money not null,
	soNguoi int,
	primary key (idLP)
)

insert into LoaiPhong values 
	('Single bed', 349990, 1), --có 1 giường dành cho 1 khách.
	('Double bed', 270000, 2), --có 1 giường dành cho 2 khách.
	('Twin room', 450000, 4), --có 2 giường dành cho 2 khách riêng biệt.
	('Triple room', 220000, 8), --có 3 giường dành cho 3 khách người lớn hoặc 1 gia đình (3 giường đơn hoặc 1 giường đôi, 1 giường đơn).
	('Quad room', 629930, 7), --phòng quad dành cho 4 khách, gồm 2 giường (2 khách nằm chung 1 giường).
	('Adjacent Room', 2849110, 12), --(Phòng Kế Cận) Một nhóm khách có thể thuê phòng theo hình thức adjacent room để đảm bảo được ở sát cạnh nhau.
	('Connecting Room', 340000, 12), --(Phòng Thông Nhau) Đây là loại phòng có cửa ra vào riêng biệt và cửa nối giữa, giúp khách có thể di chuyển qua lại giữa các phòng mà không cần đi qua hành lang.
	('Handicapped Room', 2200000, 7), --(Phòng Dành Cho Người Khuyết Tật) Loại phòng khách sạn này còn có tên khác là accessible room.
	('Suite', 5800000, 10), --suite có hình thức như một căn hộ đầy đủ tiện nghi, có phòng khách, 1 hoặc 2 phòng ngủ, phòng tắm, bếp…
	('Smoking room', 340000, 7),
	('Non-Smoking room', 360000, 8)
go

create table DichVu(
	tenDV nvarchar(20) not null,
	gia money not null,
	moTa nvarchar(100),
	primary key (tenDV)
)
go
insert into DichVu values
--('Tai 5', 500000, N'nnn')
	('Standard 1', 150000, N'Bao gồm a'),
	('Standard 2', 250000, N'Bao gồm b'),
	('Standard 3', 350000, N'Bao gồm c'),
	('Standard 4', 450000, N'Bao gồm d'),
	
go

create table DoanhThu(
	tongTien money not null,
	soKhach int not null
)

create table Phong(
	maPhong nvarchar(20) primary key,
	idLP nvarchar(20) not null,
	trangThai bit not null,
	tenDV nvarchar(20)null,
	giaPhong money not null
	foreign key (idLP) references LoaiPhong(idLP),
	foreign key (tenDV) references DichVu(tenDV)
)
go
create trigger addTongTienPhong on Phong 
	after insert as
	begin
		update Phong
			set giaPhong = (select gia from LoaiPhong where LoaiPhong.idLP = Phong.idLP)
								+
							(select gia from DichVu where DichVu.tenDV = Phong.tenDV)
			from Phong join inserted on Phong.maPhong = inserted.maPhong
	end
insert into Phong values 
	('P001', 'Single bed', 0, 'Standard 1', 0),
	('P002', 'Double bed', 1, 'Standard 3', 0),
	('P003', 'Twin room', 1, 'Standard 2', 0),
	('P004', 'Triple room', 1, 'Standard 2', 0),
	('P005', 'Quad room', 0, 'Standard 1', 0),
	('P006', 'Suite', 0, 'Standard 4', 0),
	('P007', 'Non-Smoking room', 0, 'Standard 3', 0)
go



create table KhachHang(
	maKH int identity(1,1) primary key,
	dienThoai varchar(10) not null,
	hoten nvarchar(50) not null,
	CCCD varchar(10) null,
	ngaySinh date null,
	email varchar(20) null,
	soLanDP int null,
	loaiKhach nvarchar(50) null,  --Khách mới, thân thiết, hạng bạc, hàng vàng, hạng kim cương....
	ghiChu nvarchar(150) null
)
go
-- thêm KH nếu không có, bên cạnh combobox có button ba chấm để thêm KH

create table DatPhong(
	idDP int identity(1000,1) primary key,
	maNV int not null,
	maPhong nvarchar(20) not null,
	maKH int not null,
	soNguoi int not null,
	checkIn date not null,
	gioCheckin float not null, 
	checkOut date not null,
	donGia money not null,
	ghiChu nvarchar(150) null,
	foreign key (maPhong) references Phong(maPhong),
	foreign key (maKH) references KhachHang(maKH),
	foreign key (maNV) references NhanVien(maNV)
)

go

create table TamDat (
	maNV int not null,
	maPhong varchar(10) not null,
	maKH int not null ,
	soNguoi int not null,
	checkIn date not null,
	gioCheckin float not null, 
	checkOut date not null
)
go

create table HoaDon(
	idHD int identity(1,1) primary key,
	idDP int not null,
	maNV int not null,
	maPhong nvarchar(20) not null,
	maKH int not null,
	dienThoai varchar(10) null,
	hoten nvarchar(50) not null,
	soNguoi int not null,
	checkIn date not null,
	checkOut date not null,
	dichVu nvarchar(20) null,
	donGia money not null,
	ghiChu nvarchar(150) null,
	foreign key (idDP) references DatPhong(idDP),
	foreign key (dichVu) references DichVu(tenDV)
)

create table LSThuePhong(
	idHD int identity(1,1) primary key,
	idDP int not null,
	maNV int not null,
	maPhong nvarchar(20) not null,
	maKH int not null,
	dienThoai varchar(10) null,
	hoten nvarchar(50) not null,
	soNguoi int not null,
	checkIn date not null,
	checkOut date not null,
	dichVu nvarchar(20) null,
	donGia money not null,
	ghiChu nvarchar(150) null
)

go


select count(*) from Phong
select count(trangthai) from phong where trangThai = 0
select count(trangthai) from phong where trangThai = 1
select * from phong