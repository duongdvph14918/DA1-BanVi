/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.ChiTietVi;
import Model.Vi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Hepper.JDBCHeper;

/**
 *
 * @author Admin
 */
public class ChiTietViRepository implements ChiTietViRepositoryImp{

    String selectbyID = "select * from ChiTietVi where IDVi= ?";
    @Override
    public List<ChiTietVi> getAllVI() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         //List<ChiTietVi> list = new ArrayList<>();
        
       // String sql = "Select GiaBan, SoLuong  from ChiTietVi ";
       // ResultSet rs = JDBCHeper.Query(sql);
  //      try {
       //     while(rs.next()){
               // list.add(ctv);
            //}
       //     return list;
       // } catch (SQLException ex) {
     //      ex.printStackTrace();
         // return null;
       // }
    }

    @Override
    public ChiTietVi getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTietVi> findVi(String keyWord) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(ChiTietVi Entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String sdt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateCTV(ChiTietVi nv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTietVi> searchVi(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTietVi> getViByPage(int page, int recordsPerPage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getTotalCTV() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public ChiTietVi selectID(Integer id) {
        List<ChiTietVi> list = selectBySQL(selectbyID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
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

    @Override
    public ChiTietVi SelectGia(int maVi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
