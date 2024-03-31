/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.KhuyenMai;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface KhuyenMaiRepositoryImpl {
    List<KhuyenMai> getAll();
    KhuyenMai getById(String id);
    List<KhuyenMai> findKM(String keyWord);
    abstract public void insert(KhuyenMai Entity);
    void delete(String ma);
    void update(KhuyenMai km);  
    List<KhuyenMai> search(String key);
    List<KhuyenMai> getByPage(int page, int recordsPerPage);
    int getTotal();
}
