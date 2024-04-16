SELECT   SUM(ctdonhang.SL), Sum(ctdonhang.DonGia),Sum(ctdonhang.DonGia) - Sum(ctdonhang.DonGiaSauGiam) AS GiamGia,
                ctdonhang.DonGiaSauGiam  AS GiaSauGiam
                FROM sanpham  
				join thuoctinhsanpham on thuoctinhsanpham.MaSP = sanpham.MaSP
                  join ctdonhang on thuoctinhsanpham.id = ctdonhang.idThuocTinh
                 join donhang on ctdonhang.MaDonHang = donhang.MaDonHang  
                  join kichthuoc on kichthuoc.MaSize = thuoctinhsanpham.MaSize 
               WHERE   YEAR(donhang.NgayTao) = 2023 and donhang.TrangThai != 2
               GROUP BY DonGiaSauGiam,ctdonhang.SL

			   ---

SELECT   HoaDonChiTiet.SoLuong AS Soluong ,NgayThanhToan, Sum(HoaDon.ThanhTien),Sum(HoaDon.ThanhTien) - Sum(KhuyenMai.GiaTri) AS GiamGia,
               HoaDon.ThanhTien  AS GiaSauGiam
               FROM HoaDon 
               join HoaDonChiTiet on HoaDon.IDHoaDon = HoaDonChiTiet.ID_HoaDon
			   join KhuyenMai on HoaDon.ID_KhuyenMai = KhuyenMai.IDKhuyenMai
                WHERE   YEAR(HoaDon.NgayThanhToan) = 2024 and HoaDon.TrangThai != 2
                GROUP BY HoaDonChiTiet.SoLuong, NgayThanhToan,HoaDon.ThanhTien
				select * from HoaDon
				select * from HoaDonChiTiet