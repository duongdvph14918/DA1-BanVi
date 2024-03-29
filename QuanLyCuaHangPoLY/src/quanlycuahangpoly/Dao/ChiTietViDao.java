/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlycuahangpoly.Dao;

import Model.ChiTietVi;
import Model.Vi;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import Hepper.JDBCHeper;

/**
 *
 * @author Windows
 */
public class ChiTietViDao implements InterfaceChiTietVi {

    String selectAll = "select * from ChiTietVi";
    String selectSoLuongByID = "select * from ChiTietVi where ID_Vi= ?";
    String select_Trangthai2 = "SELECT * FROM Vi WHERE Trangthai = 0";
    String selectID1 = "select GiaBan from ChiTietVi where ID_Vi= ?";
    String selectID = "select * from ChiTietVi where Ma_ChiTietVi= ?";
    String insert = "INSERT INTO ChiTietVi(Ma_ChiTietVi,ID_Vi,ID_ChatLieu,KhoaVi, ID_MauSac, ID_XuatXu,ID_LoaiVi,SoNganDungThe,GiaNhap,GiaBan,SoLuong,NgayNhap,TrangThai) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String update = "Update ChiTietVi set ID_Vi=?, ID_ChatLieu =?, KhoaVi=?, ID_MauSac =?,ID_XuatXu =?,ID_LoaiVi =?,SoNganDungThe= ?,GiaNhap =?,GiaBan=? ,SoLuong =?,NgayNhap=?, TrangThai=? where Ma_ChiTietVi =?";
    String delete = "delete from SanPham where ID_Sanpham = ?";

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTietVi> selectAll() {
        return selectBySQL(selectAll);
    }

    @Override
    public ChiTietVi selectID(Integer id) {
        List<ChiTietVi> list = selectBySQL(selectID1, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<ChiTietVi> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM dbo.Vi WHERE TenVi LIKE ? AND IdVi = ? AND Trangthai = 1 ";
        return selectBySQL(sql, "%" + keyword + "%");
    }

    @Override
    public List<ChiTietVi> selectBySQL(String sql, Object... args) {
        List<ChiTietVi> list_vi = new ArrayList<>();
        try {
            ResultSet rs = JDBCHeper.query(sql, args);
            while (rs.next()) {
                ChiTietVi ctv = new ChiTietVi();
                ctv.setID_Vi(rs.getInt("ID_Vi"));
                ctv.setID_ChatLieu(rs.getInt("ID_ChatLieu"));
                ctv.setKhoaVi(rs.getString("KhoaVi"));
                ctv.setID_MauSac(rs.getInt("ID_MauSac"));
                ctv.setID_XuatXu(rs.getInt("ID_XuatXu"));
                ctv.setID_LoaiVi(rs.getInt("ID_LoaiVi"));
                ctv.setMa_ChiTietVi(rs.getString("Ma_ChiTietVi"));
                ctv.setSoNganDungThe(rs.getString("SoNganDungThe"));
                ctv.setGiaNhap(rs.getDouble("GiaNhap"));
                ctv.setGiaBan(rs.getDouble("GiaBan"));
                ctv.setSoLuong(rs.getInt("SoLuong"));
                ctv.setNgayNhap(rs.getDate("NgayNhap"));
                ctv.setTrangThai(rs.getBoolean("TrangThai"));
                list_vi.add(ctv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_vi;
    }

    public List<ChiTietVi> selectAlll() {
        return selectBySQL(selectAll);
    }

    public List<ChiTietVi> select_TrangThai() {
        return selectBySQL(select_Trangthai2);
    }

    @Override
    public ChiTietVi selectID1(String id) {
        List<ChiTietVi> list = selectBySQL(selectID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<ChiTietVi> Select_ByName(String name) {  // tìm theo tên sản phẩm
        String Select_ByName = "select  *  from Vi where TenVi like ?";
        return selectBySQL(Select_ByName, "%" + name + "%");
    }

    public int select_Max_id_java() {
        try {
            String sql = "select max(cast(substring(Ma_ChiTietVi,5,LEN(IDChiTietVi))as int)) from ChiTietVi ";
            ResultSet rs = JDBCHeper.query(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void insert(ChiTietVi sp) {
        JDBCHeper.update(insert, sp.getMa_ChiTietVi(), sp.getID_Vi(), sp.getID_ChatLieu(), sp.getKhoaVi(), sp.getID_MauSac(), sp.getID_XuatXu(),
                sp.getID_LoaiVi(), sp.getSoNganDungThe(), sp.getGiaNhap(), sp.getGiaBan(),
                sp.getSoLuong(), sp.getNgayNhap(), sp.isTrangThai());
    }

    @Override
    public void update(ChiTietVi sp) {
        JDBCHeper.update(update, sp.getID_Vi(), sp.getID_ChatLieu(), sp.getKhoaVi(), sp.getID_MauSac(),
                sp.getID_XuatXu(), sp.getID_LoaiVi(), sp.getSoNganDungThe(), sp.getGiaNhap(),
                 sp.getGiaBan(), sp.getSoLuong(), sp.getNgayNhap(), sp.isTrangThai(),sp.getMa_ChiTietVi());
    }

    public String selectNameByid(int id) {
        return selectBySQL(selectID1, id).get(0).getMa_ChiTietVi();
    }

   public int selectSLByID(int id) {
        return selectBySQL(selectSoLuongByID, id).get(0).getSoLuong();
    }
}

