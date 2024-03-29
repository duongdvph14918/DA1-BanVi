/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Vi;
import java.util.ArrayList;
import java.util.List;
import Hepper.JDBCHeper;

/**
 *
 * @author Admin
 */
public class ViRepository implements ViRepositoryImp{
    String SELECT_GIA_BY_ID = "SELECT GIABAN FROM VI WHERE ID = ?";
    String SELECT_ALL_SQL = "select * from Vi ";
    @Override
    public void insert(Vi Entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Vi Entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public Vi selectByAccount(String account) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vi> selectAll() {
         return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public List<Vi> selectBySql(String sql, Object... args) {
         List<Vi> listVi = new ArrayList<>();
        try {
            ResultSet rs = JDBCHeper.query(sql, args);
            while (rs.next()) {
                Vi Entity = new Vi();
                Entity.setIDVi(rs.getInt("IDVi"));
                Entity.setID_ThuongHieu(rs.getInt("ID_ThuongHieu"));
                Entity.setMa_Vi(rs.getString("Ma_Vi"));
                Entity.setTenVi(rs.getString("TenVi"));
                Entity.setUrl_Anh(rs.getString("Url_Anh"));
                Entity.setTrangThai(rs.getBoolean("TrangThai"));    
                Entity.setGiaBan(rs.getDouble("GiaBan"));    
                listVi.add(Entity);
            }
            rs.getStatement().getConnection().close();
            return listVi;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vi selectGiaById(Double id) {
            return (Vi) this.selectBySql(SELECT_GIA_BY_ID);
    }

    @Override
    public List<Vi> getViByPage(int page, int recordInPage) {
        List<Vi> list = new ArrayList<>();
        String sql = "SELECT IDVi,ID_ThuongHieu, Ma_Vi, KieuDang, TenVi, TrangThai " +
                 "FROM Vi WHERE TRANGTHAI = 1 " +
                 "ORDER BY IDVi " +
                 "OFFSET ? ROWS " +
                 "FETCH NEXT ? ROWS ONLY";

        int startRecord = (page - 1) * recordInPage;

        try {
            ResultSet rs = JDBCHeper.Query(sql, startRecord, recordInPage);
            while(rs.next()){
                Vi sp = new Vi();
                list.add(sp);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int getTotal() {
          String sql = "SELECT COUNT(*) FROM Vi WHERE TRANGTHAI = 1";
      
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
