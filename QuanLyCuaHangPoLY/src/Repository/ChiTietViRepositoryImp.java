/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.ChiTietVi;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ChiTietViRepositoryImp {
         List<ChiTietVi> getAllVI();
  
    ChiTietVi getById(String id);

    List<ChiTietVi> findVi(String keyWord);
    abstract public void insert(ChiTietVi Entity);
    void delete(String sdt);
    void updateCTV(ChiTietVi nv);
    List<ChiTietVi> searchVi(String key);
    List<ChiTietVi> getViByPage(int page, int recordsPerPage);
    int getTotalCTV();
    abstract public ChiTietVi SelectGia(int maVi);
    abstract public List<ChiTietVi> selectBySQL(String sql, Object...args);
}
