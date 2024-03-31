/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.KhuyenMai;
import Repository.KhuyenMaiRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class KhuyenMaiService {
    KhuyenMaiRepository kmr = new KhuyenMaiRepository();
    List<KhuyenMai> list;
    
    public void insert(KhuyenMai km) {
        kmr.insert(km);
    }
    
     public void update(KhuyenMai km) {
        kmr.update(km);
    }

    public void delete(KhuyenMai km) {
        kmr.delete(km.getMa());
    }
    
    public List<KhuyenMai> Search(String key){
        List<KhuyenMai> lst_view = new ArrayList<>();
        list = kmr.search(key);
        for(KhuyenMai s : list){
            lst_view.add(new KhuyenMai(s.getId(), s.getMa(), s.getGiaTri(), s.getNgayBatDau(), s.getNgayKetThuc(), s.getKieuGiamGia(), s.isTrangThai()));
        }
        return lst_view;
    }
}
