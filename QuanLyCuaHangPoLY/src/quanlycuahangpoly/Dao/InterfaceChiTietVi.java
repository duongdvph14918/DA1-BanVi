/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package quanlycuahangpoly.Dao;

import Model.ChiTietVi;
import java.util.List;

/**
 *
 * @author Windows
 */
public interface InterfaceChiTietVi {
            abstract public void insert(ChiTietVi sp);
    
    abstract public void update(ChiTietVi sp);
    
    abstract public void delete(Integer id);
    
    abstract public List<ChiTietVi> selectAll();

    abstract public ChiTietVi selectID(Integer id);
    abstract public ChiTietVi selectID1(String id);
    
    abstract public List<ChiTietVi> selectBySQL(String sql, Object...args);
}
