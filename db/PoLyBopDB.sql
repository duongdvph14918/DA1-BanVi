CREATE DATABASE PoLyBop
GO 

USE PoLyBop
GO 

CREATE TABLE [LoaiVi] (
  [IDLoaiVi] INT IDENTITY,
  [Ma_LoaiVi] Varchar(50),
  [TenLoaiVi] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDLoaiVi])
);

CREATE TABLE [ChatLieu] (
  [IDChatLieu] INT IDENTITY,
  [Ma_ChatLieu] Varchar(50),
  [TenChatLieu] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDChatLieu])
);

CREATE TABLE [XuatXu] (
  [IDXuatXu] INT IDENTITY,
  [Ma_XuatXu] Varchar(50),
  [TenXuatXu] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDXuatXu])
);

CREATE TABLE [ThuongHieu] (
  [IDThuongHieu] INT IDENTITY,
  [Ma_ThuongHieu] VarChar(50),
  [TenThuongHieu] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDThuongHieu])
);

CREATE TABLE [Vi] (
  [IDVi] INT IDENTITY,
  [ID_ThuongHieu] INT,
  [Ma_Vi] VarChar(50),
  [KieuDang] NVARCHAR(50),
  [TenVi] NVARCHAR(100),
  [Url_Anh] VARCHAR(200),
  [TrangThai] BIT,
  PRIMARY KEY ([IDVi]),
  CONSTRAINT [FK_Vi.ID_ThuongHieu]
    FOREIGN KEY ([ID_ThuongHieu])
      REFERENCES [ThuongHieu]([IDThuongHieu])
);

CREATE TABLE [MauSac] (
  [IDMauSac] INT IDENTITY,
  [Ma_MauSac] Varchar(50),
  [TenMauSac] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDMauSac])
);

CREATE TABLE [ChiTietVi] (
  [IDChiTietVi] INT IDENTITY,
  [ID_Vi] INT,
  [ID_MauSac] INT,
  [ID_ChatLieu] INT,
  [ID_XuatXu] INT,
  [ID_LoaiVi] INT,
  [Ma_ChiTietVi] VarChar(50),
  [KhoaVi] Nvarchar(50),
  [SoNganDungThe] VARCHAR(50),
  [SoLuong] INT,
  [GiaNhap] Decimal,
  [GiaBan] Decimal,
  [NgayNhap] Date,
  [TrangThai] BIT,
  PRIMARY KEY ([IDChiTietVi]),
  CONSTRAINT [FK_ChiTietVi.ID_LoaiVi]
    FOREIGN KEY ([ID_LoaiVi])
      REFERENCES [LoaiVi]([IDLoaiVi]),
  CONSTRAINT [FK_ChiTietVi.ID_ChatLieu]
    FOREIGN KEY ([ID_ChatLieu])
      REFERENCES [ChatLieu]([IDChatLieu]),
  CONSTRAINT [FK_ChiTietVi.ID_XuatXu]
    FOREIGN KEY ([ID_XuatXu])
      REFERENCES [XuatXu]([IDXuatXu]),
  CONSTRAINT [FK_ChiTietVi.ID_Vi]
    FOREIGN KEY ([ID_Vi])
      REFERENCES [Vi]([IDVi]),
  CONSTRAINT [FK_ChiTietVi.ID_MauSac]
    FOREIGN KEY ([ID_MauSac])
      REFERENCES [MauSac]([IDMauSac])
);

CREATE TABLE [NhanVien] (
  [IDNhanVien] INT IDENTITY,
  [HoTen] Nvarchar(50),
  [ChucVu] BIT,
  [NgaySinh] Date,
  [SDT] Nvarchar(10),
  [Email] Nvarchar(50),
  [GioiTinh] BIT,
  [DiaChi] Nvarchar(50),
  [MatKhau] Nvarchar(32),
  [TrangThai] BIT,
  PRIMARY KEY ([IDNhanVien])
);

CREATE TABLE [KhachHang] (
  [IDKhangHang] INT IDENTITY,
  [TenKhachHang] Nvarchar(50),
  [SDT] Nvarchar(50),
  [NgaySinh] Date,
  [Email] Nvarchar(50),
  [DiaChi] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDKhangHang])
);

CREATE TABLE [KhuyenMai] (
  [IDKhuyenMai] INT IDENTITY,
  [Ma_KhuyenMai] Nvarchar(50),
  [GiaTri] INT,
  [NgayBatDau] Date,
  [NgayKetThuc] Date,
  [KieuGiamGia] Decimal,
  [TrangThai] BIT,
  PRIMARY KEY ([IDKhuyenMai])
);

CREATE TABLE [HoaDon] (
  [IDHoaDon] INT IDENTITY,
  [ID_KhachHang] INT,
  [ID_NhanVien] INT,
  [ID_KhuyenMai] INT,
  [Ma_HoaDon] Varchar(50),
  [TienSauGiamGia] Decimal,
  [ThanhTien] Decimal,
  [PhuongThucThanhToan] BIT,
  [NgayThanhToan] Date,
  [TrangThai] BIT,
  PRIMARY KEY ([IDHoaDon]),
  CONSTRAINT [FK_HoaDon.ID_NhanVien]
    FOREIGN KEY ([ID_NhanVien])
      REFERENCES [NhanVien]([IDNhanVien]),
  CONSTRAINT [FK_HoaDon.ID_KhachHang]
    FOREIGN KEY ([ID_KhachHang])
      REFERENCES [KhachHang]([IDKhangHang]),
  CONSTRAINT [FK_HoaDon.ID_KhuyenMai]
    FOREIGN KEY ([ID_KhuyenMai])
      REFERENCES [KhuyenMai]([IDKhuyenMai])
);
select * from NhanVien where IDNhanVien = 1
CREATE TABLE [HoaDonChiTiet] (
  [IDHoaDonChiTiet] INT IDENTITY,
  [ID_HoaDon] INT,
  [ID_ChiTietVi] INT,
  [Ma_HoaDonChiTiet] Varchar(50),
  [SoLuong] INT,
  [DonGia] Decimal,
  [TrangThai] BIT
  PRIMARY KEY ([IDHoaDonChiTiet]),
  CONSTRAINT [FK_HoaDonChiTiet.ID_ChiTietVi]
    FOREIGN KEY ([ID_ChiTietVi])
      REFERENCES [ChiTietVi]([IDChiTietVi]),
  CONSTRAINT [FK_HoaDonChiTiet.ID_HoaDon]
    FOREIGN KEY ([ID_HoaDon])
      REFERENCES [HoaDon]([IDHoaDon])
);



-- Thêm d? li?u 
-- Lo?i Ví
INSERT INTO LoaiVi (Ma_LoaiVi, TenLoaiVi, TrangThai) VALUES
('LV001', N'Ví nam', 1),
('LV002', N'Ví nữ', 1),
('LV003', N'Ví da', 1),
('LV004', N'Ví dự tiệc', 1),
('LV005', N'Ví thể thao', 1),
('LV006', N'Ví công sở', 1),
('LV007', N'Ví điện thoại', 1),
('LV008', N'Ví cầm tay', 1),
('LV009', N'Ví đeo chéo', 1),
('LV010', N'Ví túi xách', 1),
('LV011', N'Ví đựng card', 1),
('LV012', N'Ví ngắn', 1),
('LV013', N'Ví dài', 1),
('LV014', N'Ví cầm tay', 1),
('LV015', N'Ví tiền', 1),
('LV016', N'Ví bóp', 1),
('LV017', N'Ví da thật', 1),
('LV018', N'Ví da giả', 1),
('LV019', N'Ví lưu trữ', 1),
('LV020', N'Ví du lịch', 1);
-- Ch?t Li?u 
INSERT INTO ChatLieu (Ma_ChatLieu, TenChatLieu, TrangThai) VALUES
('CL001', N'Da bò', 1),
('CL002', N'Da cá sấu', 1),
('CL003', N'Vải', 1),
('CL004', N'Nylon', 1),
('CL005', N'Polyester', 1),
('CL006', N'Canvas', 1),
('CL007', N'Vải dù', 1),
('CL008', N'Vải bố', 1),
('CL009', N'Lụa', 1),
('CL010', N'Denim', 1),
('CL011', N'Satin', 1),
('CL012', N'Len', 1),
('CL013', N'Nhung', 1),
('CL014', N'Suede', 1),
('CL015', N'Kim loại', 1),
('CL016', N'Nhựa', 1),
('CL017', N'Gỗ', 1),
('CL018', N'Miếng', 1),
('CL019', N'Thủy tinh', 1),
('CL020', N'Cao su', 1);
-- Xu?t X? 
INSERT INTO XuatXu (Ma_XuatXu, TenXuatXu, TrangThai) VALUES
('XX001', N'Việt Nam', 1),
('XX002', N'Hoa Kỳ', 1),
('XX003', N'Trung Quốc', 1),
('XX004', N'Hàn Quốc', 1),
('XX005', N'Nhật Bản', 1),
('XX006', N'Đức', 1),
('XX007', N'Pháp', 1),
('XX008', N'Anh', 1),
('XX009', N'Ý', 1),
('XX010', N'Thụy Điển', 1),
('XX011', N'Canada', 1),
('XX012', N'Úc', 1),
('XX013', N'New Zealand', 1),
('XX014', N'Thái Lan', 1),
('XX015', N'Indonesia', 1),
('XX016', N'Malaysia', 1),
('XX017', N'Singapore', 1),
('XX018', N'Nga', 1),
('XX019', N'Ấn Độ', 1),
('XX020', N'Brazil', 1);
-- Màu S?c 
INSERT INTO MauSac (Ma_MauSac, TenMauSac, TrangThai) VALUES
('MS001', N'Do', 1),
('MS002', N'Xanh lá cây', 1),
('MS003', N'Xanh dương', 1),
('MS004', N'Vàng', 1),
('MS005', N'Tím', 1),
('MS006', N'Hồng', 1),
('MS007', N'Đen', 1),
('MS008', N'Trắng', 1),
('MS009', N'Cam', 1),
('MS010', N'Xám', 1),
('MS011', N'Nâu', 1),
('MS012', N'Hồng phấn', 1),
('MS013', N'Lục', 1),
('MS014', N'Vàng nâu', 1),
('MS015', N'Xanh da trời', 1),
('MS016', N'Xanh lơ', 1),
('MS017', N'Nâu đậm', 1),
('MS018', N'Xám sáng', 1),
('MS019', N'Cam đậm', 1),
('MS020', N'Nâu nhạt', 1);
-- Th??ng hi?u 
INSERT INTO ThuongHieu (Ma_ThuongHieu, TenThuongHieu, TrangThai) VALUES 
('TH001', N'Nike', 1),
('TH002', N'Adidas', 1),
('TH003', N'Gucci', 1),
('TH004', N'Apple', 1),
('TH005', N'Samsung', 1),
('TH006', N'Lacoste', 1),
('TH007', N'Chanel', 1),
('TH008', N'Microsoft', 1),
('TH009', N'Toyota', 1),
('TH010', N'Mercedes-Benz', 1),
('TH011', N'Sony', 1),
('TH012', N'Louis Vuitton', 1),
('TH013', N'BMW', 1),
('TH014', N'Coca-Cola', 1),
('TH015', N'Pepsi', 1),
('TH016', N'Nike', 1),
('TH017', N'McDonald', 1),
('TH018', N'Stella Artois', 1),
('TH019', N'KFC', 1),
('TH020', N'Canon', 1);
-- Ví 
INSERT INTO Vi (ID_ThuongHieu, Ma_Vi, KieuDang, TenVi, Url_Anh, TrangThai) VALUES 
(1, 'V001', N'Bifold', N'Nike Sport Wallet', 'wallet.jpg', 1),
(2, 'V002', N'Trilfold', N'Adidas Originals Wallet', 'wallet.jpg', 1),
(3, 'V003', N'Card Holder', N'Gucci Leather Card Holder', 'holder.jpg', 1),
(4, 'V004', N'iPhone Wallet', N'Apple Leather Wallet Case', 'case.jpg', 1),
(5, 'V005', N'Samsung Galaxy Wallet', N'Samsung Galaxy S21 Wallet Case', 'case.jpg', 1),
(6, 'V006', N'Lacoste Slim Wallet', N'Lacoste Men\', 'wallet.jpg', 1),
(7, 'V007', N'Chanel Quilted Wallet', N'Chanel Classic Quilted Wallet', 'wallet.jpg', 1),
(8, 'V008', N'Surface Wallet', N'Microsoft Surface Duo Wallet Case', 'case.jpg', 1),
(9, 'V009', N'Toyota Leather Wallet', N'Toyota Genuine Leather Wallet', 'wallet.jpg', 1),
(10, 'V010', N'Mercedes-Benz Money Clip', N'Mercedes-Benz Men', 'clip.jpg', 1),
(11, 'V011', N'Sony Passport Holder', N'Sony Travel Passport Holder', 'holder.jpg', 1),
(12, 'V012', N'LV Monogram Wallet', N'Louis Vuitton Monogram Canvas Wallet', 'wallet.jpg', 1),
(13, 'V013', N'BMW Card Wallet', N'BMW Genuine Leather Card Wallet', 'wallet.jpg', 1),
(14, 'V014', N'Coca-Cola Coin Purse', N'Coca-Cola Logo Coin Purse', 'purse.jpg', 1),
(15, 'V015', N'Pepsi Slim Wallet', N'Pepsi Logo Slim Wallet', 'wallet.jpg', 1),
(16, 'V016', N'Nike Tri-fold Wallet', N'Nike Tri-fold Wallet for Men', 'wallet.jpg', 1),
(17, 'V017', N'McDonald\', N'McDonal Clip', 'clip.jpg', 1),
(18, 'V018', N'Stella Artois Card Holder', N'Stella Artois Leather Card Holder', 'holder.jpg', 1),
(19, 'V019', N'KFC Slim Wallet', N'KFC Colonel Slim Wallet', 'wallet.jpg', 1),
(20, 'V020', N'Canon Camera Bag', N'Canon DSLR Camera Bag', 'bag.jpg', 1);
-- Chi ti?t Ví  
INSERT INTO ChiTietVi (ID_Vi, ID_MauSac, ID_ChatLieu, ID_XuatXu, ID_LoaiVi, Ma_ChiTietVi, KhoaVi, SoNganDungThe, SoLuong, GiaNhap, GiaBan, NgayNhap, TrangThai) VALUES 
(1, 1, 1, 1, 1, 'CTV001', N'NikeSportWallet-Red', '10 Card Slots', 50, 150000, 200000, '2024-01-01', 1),
(2, 2, 2, 2, 2, 'CTV002', N'AdidasOriginalsWallet-Blue', '8 Card Slots', 30, 120000, 180000, '2024-03-02', 1),
(3, 3, 3, 3, 3, 'CTV003', N'GucciCardHolder-Black', '4 Card Slots', 20, 300000, 450000, '2024-01-03', 1),
(4, 4, 4, 4, 4, 'CTV004', N'AppleWalletCase-Brown', 'iPhone 12 Pro Max', 15, 250000, 350000, '2024-01-04', 1),
(5, 5, 5, 5, 5, 'CTV005', N'SamsungGalaxyWallet-Green', 'Galaxy S21 Ultra', 25, 200000, 300000, '2024-01-05', 1),
(6, 6, 6, 6, 6, 'CTV006', N'LacosteSlimWallet-White', 'Slim Design', 35, 180000, 250000, '2024-01-06', 1),
(7, 7, 7, 7, 7, 'CTV007', N'ChanelQuiltedWallet-Pink', 'Classic Quilted', 40, 500000, 700000, '2024-01-07', 1),
(8, 8, 8, 8, 8, 'CTV008', N'SurfaceWallet-Gray', 'Microsoft Surface Duo', 10, 400000, 600000, '2024-01-08', 1),
(9, 9, 9, 9, 9, 'CTV009', N'ToyotaLeatherWallet-Brown', 'Genuine Leather', 18, 220000, 320000, '2024-01-09', 1),
(10, 10, 10, 10, 10, 'CTV010', N'MercedesMoneyClip-Black', 'Men Money Clip', 22, 280000, 400000, '2024-01-10', 1),
(11, 11, 11, 11, 11, 'CTV011', N'SonyPassportHolder-Red', 'Travel Passport Holder', 28, 350000, 500000, '2024-01-11', 1),
(12, 12, 12, 12, 12, 'CTV012', N'LVMonogramWallet-Beige', 'Monogram Canvas', 12, 600000, 800000, '2024-01-12', 1),
(13, 13, 13, 13, 13, 'CTV013', N'BMWCardWallet-Blue', 'Genuine Leather', 14, 260000, 380000, '2024-01-13', 1),
(14, 14, 14, 14, 14, 'CTV014', N'CocaColaCoinPurse-Red', 'Logo Coin Purse', 16, 120000, 180000, '2024-01-14', 1),
(15, 15, 15, 15, 15, 'CTV015', N'PepsiSlimWallet-Blue', 'Logo Slim Wallet', 20, 150000, 220000, '2024-01-15', 1),
(16, 16, 16, 16, 16, 'CTV016', N'NikeTrifoldWallet-Black', 'Trifold Wallet', 25, 190000, 270000, '2024-01-16', 1),
(17, 17, 17, 17, 17, 'CTV017', N'McDonaldsMoneyClip-Gold', 'Golden Arches', 30, 320000, 450000, '2024-01-17', 1),
(18, 18, 18, 18, 18, 'CTV018', N'StellaArtoisCardHolder-Brown', 'Leather Card Holder', 14, 280000, 380000, '2024-01-18', 1),
(19, 19, 19, 19, 19, 'CTV019', N'KFCSlimWallet-Red', 'Colonel Slim Wallet', 18, 200000, 300000, '2024-01-19', 1),
(20, 20, 20, 20, 20, 'CTV020', N'CanonCameraBag-Black', 'DSLR Camera Bag', 22, 400000, 600000, '2024-01-20', 1);
-- Khách hàng 
INSERT INTO KhachHang ( TenKhachHang, SDT, NgaySinh, Email, DiaChi, TrangThai) VALUES
( N'Khách Lẻ', '', '1990-01-01', '', N'Hà Nội', 1),
( N'Trần Thị B', '0987654321', '1995-02-15', 'tranthib@example.com', N'Hồ Chí Minh', 1),
( N'Phạm Văn C', '0369852147', '1988-06-20', 'phamvanc@example.com', N'Đà Nẵng', 1),
( N'Huỳnh Thị D', '0368741256', '1992-04-10', 'huynhthid@example.com', N'Cần Thơ', 1),
( N'Lê Văn E', '0932147856', '1993-09-05', 'levane@example.com', N'Đắk Lắk', 1),
( N'Võ Thị F', '0912345678', '1990-12-30', 'vothif@example.com', N'Bình Dương', 1),
( N'Trương Văn G', '0987456321', '1994-11-25', 'truongvang@example.com', N'Hải Phòng', 1),
( N'Dương Thị H', '0978563412', '1987-03-18', 'duongthih@example.com', N'Quảng Ninh', 1),
( N'Hoàng Văn I', '0358742965', '1991-07-12', 'hoangvani@example.com', N'Thái Bình', 1),
( N'Mai Thị K', '0914785236', '1998-05-08', 'maithik@example.com', N'Bình Thuận', 1);
-- Khuy?n mãi 
INSERT INTO KhuyenMai (Ma_KhuyenMai, GiaTri, NgayBatDau, NgayKetThuc, KieuGiamGia, TrangThai) VALUES 
('KM001', 10, '2023-01-01', '2024-01-15', 0.1, 1),
('KM002', 20, '2023-02-01', '2024-02-20', 0.2, 1),
('KM003', 15, '2023-03-01', '2024-03-19', 0.15, 1),
('KM004', 25, '2023-04-01', '2024-01-18', 0.25, 1),
('KM005', 30, '2023-05-01', '2024-01-17', 0.3, 1),
('KM006', 18, '2023-06-01', '2024-01-16', 0.18, 1),
('KM007', 12, '2023-07-01', '2024-03-15', 0.12, 1),
('KM008', 22, '2023-08-01', '2024-02-21', 0.22, 1),
('KM009', 28, '2023-09-01', '2024-03-15', 0.28, 1),
('KM010', 35, '2023-10-01', '2024-02-24', 0.35, 1);
-- Nhân viên
INSERT INTO NhanVien ( HoTen, ChucVu, NgaySinh, SDT, Email, GioiTinh, DiaChi, MatKhau, TrangThai) VALUES
( N'Nguyễn Văn A', 1, '1990-01-01', '0123456789', 'nguyenvana@example.com', 1, N'Hà Nội', 'hashed_password', 1),
( N'Trần Thị B', 0, '1995-02-15', '0987654321', 'tranthib@example.com', 0, N'Hồ Chí Minh', 'hashed_password', 1),
( N'Phạm Văn C', 1, '1988-06-20', '0369852147', 'phamvanc@example.com', 1, N'Đà Nẵng', 'hashed_password', 1),
( N'Huỳnh Thị D', 0, '1992-04-10', '0368741256', 'huynhthid@example.com', 0, N'Cần Thơ', 'hashed_password', 1),
( N'Lê Văn E', 0, '1993-09-05', '0932147856', 'levane@example.com', 1, N'Đắk Lắk', 'hashed_password', 1),
( N'Võ Thị F', 1, '1990-12-30', '0912345678', 'vothif@example.com', 0, N'Bình Dương', 'hashed_password', 1),
( N'Trương Văn G', 0, '1994-11-25', '0987456321', 'truongvang@example.com', 1, N'Hải Phòng', 'hashed_password', 1),
( N'Dương Thị H', 1, '1987-03-18', '0978563412', 'duongthih@example.com', 0, N'Quảng Ninh', 'hashed_password', 1),
( N'Hoàng Văn I', 0, '1991-07-12', '0358742965', 'hoangvani@example.com', 1, N'Thái Bình', 'hashed_password', 1),
( N'Mai Thị K', 0, '1998-05-08', '0914785236', 'maithik@example.com', 0, N'Bình Thuận', 'hashed_password', 1);
-- Hóa ??n 
INSERT INTO HoaDon (ID_KhachHang, ID_NhanVien, ID_KhuyenMai, Ma_HoaDon, TienSauGiamGia, ThanhTien, PhuongThucThanhToan, NgayThanhToan, TrangThai) VALUES 
(1, 1, 1, 'HD001', 180000, 160000, 1, '2024-01-10', 1),
(2, 2, 2, 'HD002', 144000, 120000, 0, '2024-02-15', 1),
(3, 3, 3, 'HD003', 255000, 220000, 1, '2024-03-20', 1),
(4, 4, 4, 'HD004', 337500, 300000, 0, '2024-01-25', 1),
(5, 5, 5, 'HD005', 210000, 180000, 1, '2024-03-30', 1),
(6, 6, 6, 'HD006', 225000, 200000, 0, '2023-03-05', 1),
(7, 7, 7, 'HD007', 525000, 480000, 1, '2023-02-10', 1),
(8, 8, 8, 'HD008', 450000, 400000, 0, '2023-01-15', 1),
(9, 9, 9, 'HD009', 285000, 250000, 1, '2023-01-20', 1),
(10, 10, 10, 'HD010', 390000, 350000, 0, '2023-03-25', 1);
-- Hóa ??n chi ti?t 
INSERT INTO HoaDonChiTiet (ID_HoaDon, ID_ChiTietVi, Ma_HoaDonChiTiet, SoLuong, DonGia,TrangThai) VALUES 
(1, 1, 'HDCT001', 2, 80000,1),
(1, 2, 'HDCT002', 1, 80000,1),
(2, 3, 'HDCT003', 3, 40000,1),
(2, 4, 'HDCT004', 1, 40000,1),
(3, 5, 'HDCT005', 2, 110000,1),
(3, 6, 'HDCT006', 1, 110000,1);


-- 
--Truy vấn bảng Vi
Update Vi set TenVi=?, KieuDang =?, ID_ThuongHieu=?, Url_Anh =?, TrangThai=? where Ma_Vi =?
select max(cast(substring(Ma_Vi,3,LEN(IDVi))as int)) from  Vi
select * from Vi where IDVi =?
select * from Vi where TenVi =?

-- truy vấn bảng thương hiệu
update ThuongHieu set TenThuongHieu =? , TrangThai = ? where Ma_ThuongHieu =?
select * from ThuongHieu where Ma_ThuongHieu = N'TH001'
insert into ThuongHieu (Ma_ThuongHieu , TenThuongHieu, TrangThai) values (?,?,?)
select max(cast(substring(Ma_ThuongHieu,4,LEN(IDThuongHieu))as int)) from  ThuongHieu

-- truy vấn bảng xuất xứ
update XuatXu set TenXuatXu =? , TrangThai = ? where Ma_XuatXu =?
select * from XuatXu where TenXuatXu=?
insert into XuatXu (Ma_XuatXu , TenXuatXu, TrangThai) values (?,?,?)
select * from XuatXu where IDXuatXu =?

--truy vấn bảng chi tiết ví
select * from ChiTietVi;
select * from ChiTietVi where Ma_ChiTietVi =?
select * from ChiTietVi where IDChiTietVi =?
select max(cast(substring(Ma_ChiTietVi,5,LEN(IDChiTietVi))as int)) from ChiTietVi 
INSERT INTO ChiTietVi(Ma_ChiTietVi,ID_Vi,ID_ChatLieu,KhoaVi, ID_MauSac, ID_XuatXu,ID_LoaiVi,SoNganDungThe,GiaNhap,GiaBan,SoLuong,NgayNhap,TrangThai) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)
Update ChiTietVi set ID_Vi=?, ID_ChatLieu =?, KhoaVi=?, ID_MauSac =?,ID_XuatXu =?,ID_LoaiVi,SoNganDungThe ?,GiaNhap =?,GiaBan=? ,SoLuong =?,NgayNhap=?, TrangThai=? where Ma_ChiTietVi =?

--truy vấn bảng màu sắc
select * from MauSac ;
select * from MauSac where IDMauSac =?
select * from MauSac where TenMauSac =?

--truy vấn bảng chat lieu
select * from ChatLieu where IDChatLieu = ?
select * from ChatLieu where TenChatLieu =?
-- truy vaans bang loai vi
select * from LoaiVi
select * from LoaiVi where IDLoaiVi =?
select * from LoaiVi where TenLoaiVi =?
-- hôm nay
	SELECT (
	SELECT count(HoaDon.Ma_HoaDon) 
	FROM HoaDon
	WHERE CONVERT(DATE, HoaDon.NgayThanhToan)  = CONVERT(DATE, GETDATE()) AND HoaDon.TrangThai = 1) AS 'Đơn hàng',
    sum(HoaDonChiTiet.SoLuong) as 'Sản phẩm',
	SUM(HoaDon.ThanhTien) as 'Doanh thu' 
	FROM HoaDon
    JOIN HoaDonChiTiet on HoaDon.IDHoaDon = HoaDonChiTiet.ID_HoaDon
    WHERE CONVERT(DATE, HoaDon.NgayThanhToan)  = CONVERT(DATE, GETDATE()) AND HoaDon.TrangThai = 1
	-- theo ngày
	select
	    sum(HoaDonChiTiet.SoLuong) as 'Sản phẩm' 
	FROM HoaDonChiTiet

	--
	SELECT (SELECT count(HoaDon.Ma_HoaDon) FROM HoaDon 
	WHERE CONVERT(DATE, HoaDon.NgayThanhToan) BETWEEN ? and ?   AND HoaDon.TrangThai != 2)  AS DONHANG, 
                 sum(HoaDonChiTiet.SoLuong), 
				 SUM(HoaDon.ThanhTien) FROM HoaDon
                left JOIN HoaDonChiTiet on HoaDon.Ma_HoaDon = HoaDonChiTiet.Ma_HoaDonChiTiet
                WHERE CONVERT(DATE, HoaDon.NgayThanhToan) BETWEEN ? and ?  
                AND HoaDon.TrangThai != 2


	--Thống kê sản phẩm
	SELECT HoaDon.Ma_HoaDon,HoaDonChiTiet.Ma_HoaDonChiTiet, Vi.TenVi,ThuongHieu.TenThuongHieu,XuatXu.TenXuatXu,ChatLieu.TenChatLieu,LoaiVi.TenLoaiVi, SUM(HoaDonChiTiet.SoLuong) as soluong FROM ChiTietVi
               join Vi on ChiTietVi.IDChiTietVi = Vi.IDVi
                join ThuongHieu on ThuongHieu.IDThuongHieu = Vi.ID_ThuongHieu
                join XuatXu on ChiTietVi.ID_XuatXu = XuatXu.IDXuatXu
                join ChatLieu on ChiTietVi.ID_ChatLieu = ChatLieu.IDChatLieu
                join LoaiVi on ChiTietVi.ID_LoaiVi = LoaiVi.IDLoaiVi
				left join HoaDon on  ChiTietVi.IDChiTietVi = HoaDon.IDHoaDon
				left join HoaDonChiTiet on HoaDon.IDHoaDon = HoaDonChiTiet.ID_HoaDon 
                WHERE HoaDon.TrangThai =1
               group by Ma_HoaDon, Ma_HoaDonChiTiet, Vi.TenVi,ThuongHieu.TenThuongHieu,XuatXu.TenXuatXu,ChatLieu.TenChatLieu,LoaiVi.TenLoaiVi


--Thống kê sản phẩm bán
Select Ma_HoaDon,Ma_HoaDonChiTiet,TenVi,TenThuongHieu,TenXuatXu,TenChatLieu,TenLoaiVi,HoaDonChiTiet.SoLuong as N'Số lượng bán'
from HoaDon 
	join HoaDonChiTiet on HoaDonChiTiet.ID_HoaDon = HoaDon.IDHoaDon
	join ChiTietVi on (HoaDonChiTiet.ID_ChiTietVi = ChiTietVi.IDChiTietVi)
	join Vi on (ChiTietVi.ID_Vi = Vi.IDVi)
	join ThuongHieu on (Vi.ID_ThuongHieu = ThuongHieu.IDThuongHieu)
	join XuatXu on (ChiTietVi.ID_XuatXu = XuatXu.IDXuatXu)
	join ChatLieu on (ChiTietVi.ID_ChatLieu = ChatLieu.IDChatLieu)
	join LoaiVi on (ChiTietVi.ID_LoaiVi = LoaiVi.IDLoaiVi)
	where HoaDon.TrangThai = 1

--Thống kê theo biểu đò

SELECT  ? AS Tháng, SUM(HoaDonChiTiet.SoLuong), Sum(HoaDon.ThanhTien),Sum(HoaDon.ThanhTien) - Sum(HoaDonChiTiet.DonGia) AS GiamGia,
               HoaDon.ThanhTien  AS GiaSauGiam
               FROM HoaDon 
               join HoaDonChiTiet on HoaDon.IDHoaDon = HoaDonChiTiet.ID_HoaDon
               WHERE  Month(HoaDon.NgayThanhToan) = ? AND YEAR(HoaDon.NgayThanhToan) = ? and HoaDon.TrangThai = 1
               GROUP BY HoaDon.ThanhTien,HoaDonChiTiet.SoLuong

ALTER TABLE NhanVien
DROP COLUMN Ma_NhanVien ;	
--hoá đơn chi tiết
SELECT HoaDonChiTiet.Ma_HoaDonChiTiet
                                  ,[ID_ChiTietVi]
                               	  ,Vi.Ma_Vi
                              	  ,Vi.TenVi
                				  ,Vi.KieuDang
                				  ,MauSac.TenMauSac
               				  ,ThuongHieu.TenThuongHieu
                					  ,ChiTietVi.GiaBan
                                      ,HoaDonChiTiet.SoLuong
                                     ,[DonGia]
                                FROM [HoaDonChiTiet] 
                               join HoaDon on HoaDon.IDHoaDon = HoaDonChiTiet.ID_HoaDon 
                                 join (ChiTietVi join Vi on Vi.IDVi = ChiTietVi.ID_Vi ) on ChiTietVi.IDChiTietVi = HoaDonChiTiet.ID_ChiTietVi
                				  join ThuongHieu on Vi.ID_ThuongHieu = ThuongHieu.IDThuongHieu
              			  join MauSac on Vi.ID_ThuongHieu = MauSac.IDMauSac
                                 where HoaDon.Ma_HoaDon = N'HD191' and HoaDonChiTiet.TrangThai = 1
--Hoa don chua thanh toan
select IDHoaDon ,Ma_HoaDon , KhachHang.TenKhachHang , NhanVien.HoTen as N'Ten Nhan Vien',
ID_KhuyenMai , TienSauGiamGia, ThanhTien ,PhuongThucThanhToan , NgayThanhToan , HoaDon.TrangThai
			from HoaDon 
			join KhachHang on HoaDon.ID_KhachHang = KhachHang.IDKhangHang
			Join NhanVien on HoaDon.ID_NhanVien = NhanVien.IDNhanVien
			where HoaDon.TrangThai = 1
--khuyen mai

select * from KhuyenMai
SELECT [IDKhuyenMai]
                     ,[Ma_KhuyenMai]
                     ,[GiaTri]
                     ,[NgayBatDau]
                     ,[NgayKetThuc]
                     ,[KieuGiamGia]
                     ,[TrangThai]
                FROM [dbo].[KhuyenMai]
				where N'2023-03-16' between KhuyenMai.NgayBatDau and KhuyenMai.NgayKetThuc
