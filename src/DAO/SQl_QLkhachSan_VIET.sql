create database QlKhachSan
go

use QLKhachSan

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
	primary key (maNV),
	foreign key (maNQL) references NhanVien(maNV)
)
go

create table HeThong(
	username varchar(10) not null,
	pass varchar(20) not null,
	chucVu bit not null,
	primary key (username)
)
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
create table ChiTietDichVu(
	maPhong  nvarchar(20),
	tenDV nvarchar(20) not null,
	gia money not null,
	moTa nvarchar(100),
	trangthaui bit
	primary key (tenDV),
	foreign key (maPhong) references Phong(maPhong),
	foreign key (tenDV) references DichVu(tenDV)
)
select * from ChiTietDichVu
select * from Phong
drop table ChiTietDichVu
insert into ChiTietDichVu  
values
('1','a',1,'a',1),
('2','b',2,'b',100.0),
('3','c',3,'c',100.0),
('4','d',4,'d',100.0)


go
insert into Phong  
values
('1','ps1',1,'a',100.0),
('2','ps2',2,'b',100.0),
('3','ps3',3,'c',100.0),
('4','ps4',4,'d',100.0)

create table LoaiPhong(
	idLP nvarchar(20) not null,
	gia money not null,
	soNguoi int,
	primary key (idLP)
)
go
insert into LoaiPhong  
values
('ps1',1.1,1),
('ps2',1.2,2),
('ps3',1.3,3),
('ps4',1.4,4)

select * from DichVu
select * from LoaiPhong
select * from Phong

create table DichVu(
	tenDV nvarchar(20) not null,
	gia money not null,
	moTa nvarchar(100),
	primary key (tenDV)
)
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


create table TamDat(
	maNV int not null,
	maPhong varchar(10) not null,
	maKH int not null ,
	soNguoi int not null,
	checkIn date not null,
	gioCheckin float not null, 
	checkOut date not null
)


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
create table thanhtoan(
	idtt nvarchar(20),
	Checkin date not null, 
	checkOut date not null, 
	dienThoai varchar(10) null,
	hoten nvarchar(50) not null,
	soNguoi int not null,
	maPhong nvarchar(20) not null,
	dichVu nvarchar(20) null,
	maKH int not null,
	foreign key (maPhong) references Phong(maPhong),
	foreign key (maKH) references KhachHang(maKH)
)
insert into thanhtoan
values
('1','2023-04-03','2023-04-03','0123',)

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

