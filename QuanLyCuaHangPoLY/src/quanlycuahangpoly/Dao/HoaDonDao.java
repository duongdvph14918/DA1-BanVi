/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlycuahangpoly.Dao;

import Hepper.JDBCHeper;
import Model.HoaDon;
import Model.HoaDon1;
import Repository.DBconnect;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author Windows
 */
public class HoaDonDao {

    String selectById = "select * from HoaDon where IDHoaDon = ?";
    String selectAll = "select *  from HoaDon";
    String select_Trangthai1 = "SELECT * FROM HoaDon WHERE TrangThai = 1";
    String select_Trangthai2 = "SELECT * FROM HoaDon WHERE TrangThai = 0";

    public List<HoaDon1> selectAll() {
        return selectBySQL(select_Trangthai1);
    }

    public List<HoaDon1> selectBySQL(String sql, Object... args) {
        List<HoaDon1> list_vi = new ArrayList<>();
        try {
            ResultSet rs = JDBCHeper.query(sql, args);
            while (rs.next()) {
                HoaDon1 sp = new HoaDon1();
                sp.setIDHoaDon(rs.getInt("IDHoaDon"));
                sp.setMa_HoaDon(rs.getString("Ma_HoaDon"));
                sp.setID_KhachHang(rs.getInt("ID_KhachHang"));
                sp.setID_KhuyenMai(rs.getInt("ID_NhanVien"));
                sp.setID_KhuyenMai(rs.getInt("ID_KhuyenMai"));
                sp.setThanhTien(rs.getInt("ThanhTien"));
                sp.setPhuongThucThanhToan(rs.getBoolean("PhuongThucThanhToan"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setNgayThanhToan(rs.getDate("NgayThanhToan"));
                list_vi.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_vi;
    }
//    public List<HoaDon> timKiem(String seach) {
//        List<HoaDon> listSeach = new ArrayList<>();
//        String sql = "SELECT [IDHoaDon]\n"
//                + "	 ,[Ma_HoaDon]\n"
//                + "      ,KhachHang.TenKhachHang\n"
//                + "      ,NhanVien.HoTen "
//                + "      ,[ID_KhuyenMai]  \n"
//                + "      ,[TienSauGiamGia]\n"
//                + "      ,[ThanhTien]\n"
//                + "      ,[PhuongThucThanhToan]\n"
//                + "      ,[NgayThanhToan]\n"
//                + "      ,HoaDon.TrangThai\n"
//                + "  FROM [PoLyBop].[dbo].[HoaDon]\n"
//                + "  join KhachHang on KhachHang.IDKhangHang = HoaDon.ID_KhachHang\n"
//                + "  join NhanVien on NhanVien.IDNhanVien = HoaDon.ID_NhanVien\n"
//                + "  where Ma_HoaDon like '%" + seach + "%' or TenKhachHang like N'%" + seach + "%' or NhanVien.HoTen like N'%" + seach + "%' and HoaDon.TrangThai = 1";
//        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
//                      
//            ResultSet rs = JDBCHeper.query(sql, args);
//            while (rs.next()) {
//                HoaDon sp = new HoaDon();
//                sp.setIdHoaDon(rs.getInt("IdHoaDon"));
//                sp.setMaHoaDon(rs.getString("MaHoaDon"));
//                sp.setIdKhachHang(rs.getInt("IdKhachHang"));
//                sp.setIdNhanVien(rs.getInt("IdNhanVien"));
//                sp.setIdKhuyenMai(rs.getInt("IdKhuyenMai"));
//                sp.setThanhTien(rs.getInt("ThanhTien"));
//                sp.setPhuongThucThanhToan(rs.getBoolean("PhuongThucThanhToan"));
//                sp.setTrangThai(rs.getBoolean("TrangThai"));
//                sp.setNgayThanhToan(rs.getDate("NgayThanhToan"));
//                listSeach.add(sp);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return listSeach;
//    }
    public List<HoaDon1> selectAlll() {
        return selectBySQL(selectAll);
    }

    public List<HoaDon1> select_TrangThai() {
        return selectBySQL(select_Trangthai2);
    }

    public String selectNameByID(int id) {
        return selectBySQL(selectById, id).get(0).getMa_HoaDon();
    }
}
