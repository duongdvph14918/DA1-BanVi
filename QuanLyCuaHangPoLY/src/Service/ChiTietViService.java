/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.ChiTietVi;
import quanlycuahangpoly.Dao.ChiTietViDao;

/**
 *
 * @author Windows
 */
public class ChiTietViService {
        ChiTietViDao dao = new ChiTietViDao();

    public void insert(ChiTietVi sp) {
        dao.insert(sp);
    }

    public void update(ChiTietVi sp) {
        dao.update(sp);
    }

    public void delete(ChiTietVi sp) {
        dao.delete(sp.getIdChiTietVi());
    }
}
