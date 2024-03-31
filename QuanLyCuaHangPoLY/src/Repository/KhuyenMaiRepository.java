/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Hepper.JDBCHeper;
import Model.KhuyenMai;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ADMIN
 */
public class KhuyenMaiRepository implements KhuyenMaiRepositoryImpl {

    String INSERT_SQL = "INSERT KhuyenMai VALUES(?,?,?,?,?,?)";
    String UPDATE_SQL = "update KhuyenMai set GiaTri =? , NgayBatDau =? , NgayKetThuc = ?, KieuGiamGia = ? , TrangThai =? where Ma_KhuyenMai = ?";
    String DELETE_SQL = "UPDATE KhuyenMai set TrangThai = 0 WHERE Ma_KhuyenMai = ?";
    String SELECT_ALL_SQL = "select * from KhuyenMai ";
    String SELECT_BY_ID_SQL = "select * from KhuyenMai where IDKhuyenMai = ?";
    String SELECT_TrangThai1 = "select * from KhuyenMai where Trangthai = 0";
    String SELECT_TrangThai2 = "select * from KhuyenMai where Trangthai = 1";

    @Override
    public List<KhuyenMai> getAll() {
        List<KhuyenMai> list = new ArrayList<>();
        String sql = "select IDKhuyenMai ,Ma_KhuyenMai, GiaTri, NgayBatDau, NgayKetThuc, KieuGiamGia, TrangThai from KhuyenMai";
        ResultSet rs = JDBCHeper.Query(sql);
        try {
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getBoolean(7));
                list.add(km);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//    public List<KhuyenMai> selectAlll() {
//        return getAll(SELECT_ALL_SQL);
//    }
    @Override
    public KhuyenMai getById(String id) {
        KhuyenMai km = null;
        String sql = "select IDKhuyenMai ,Ma_KhuyenMai, GiaTri, NgayBatDau, NgayKetThuc, KieuGiamGia, TrangThai from KhuyenMai where Ma_KhuyenMai =?";
        ResultSet rs = JDBCHeper.Query(sql, id);
        try {
            while (rs.next()) {
                km = new KhuyenMai(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getBoolean(7));
            }
            return km;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<KhuyenMai> findKM(String keyWord) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(KhuyenMai Entity) {
        JDBCHeper.update(INSERT_SQL, Entity.getMa(), Entity.getGiaTri(), Entity.getNgayBatDau(),
                Entity.getNgayKetThuc(), Entity.getKieuGiamGia(), Entity.isTrangThai());
    }

    @Override
    public void delete(String ma) {
        JDBCHeper.update(DELETE_SQL, ma);
    }

    @Override
    public void update(KhuyenMai Entity) {
        JDBCHeper.update(UPDATE_SQL,Entity.getGiaTri(), Entity.getNgayBatDau(), Entity.getNgayKetThuc(), Entity.getKieuGiamGia(),
                Entity.isTrangThai(), Entity.getMa());
    }

    @Override
    public List<KhuyenMai> search(String key) {
        List<KhuyenMai> listKM = new ArrayList<>();
        String sql = "SELECT IDKhuyenMai, Ma_KhuyenMai, NgayBatDau, NgayKetThuc, GiaTri, KieuGiamGia, TrangThai FROM KhuyenMai\n"
                + "WHERE TrangThai = 1 AND (Ma_KhuyenMai like concat('%',?,'%') OR GiaTri like concat('%',?,'%') OR KieuGiamGia like concat('%',?,'%'))";
        ResultSet rs = JDBCHeper.Query(sql, key, key, key);
        try {
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getBoolean(7));
                listKM.add(km);
            }
            return listKM;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<KhuyenMai> getByPage(int page, int recordsPerPage) {
        List<KhuyenMai> list = new ArrayList<>();
        String sql = "SELECT IDKhuyenMai, Ma_KhuyenMai, GiaTri, NgayBatDau, NgayKetThuc, KieuGiamGia, TrangThai  +\n"
                + "                 FROM KhuyenMai WHERE TrangThai = 1  +\n"
                + "                 ORDER BY IDKhuyenMai  +\n"
                + "                 OFFSET ? ROWS  +\n"
                + "                 FETCH NEXT ? ROWS ONLY";
        int startRecord = (page - 1) * recordsPerPage;
        try {
            ResultSet rs = JDBCHeper.Query(sql, startRecord, recordsPerPage);
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getBoolean(7));
                list.add(km);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return null;
    }

    @Override
    public int getTotal() {
        String sql = "SELECT COUNT(*) FROM KhuyenMai WHERE TrangThai = 1";
           ResultSet rs = JDBCHeper.Query(sql);
           try {
            while(rs.next()){
               return rs.getInt(1);
            }
      
        } catch (SQLException ex) {
            ex.printStackTrace();
  
        }
         return 0;
    }

}
