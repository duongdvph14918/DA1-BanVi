/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Windows
 */
public class HoaDon1 {
        private int IDHoaDon;
    private int ID_KhachHang;
    private int ID_NhanVien;
    private int ID_KhuyenMai;
    private String Ma_HoaDon;
   private  double TienSauGiamGia;
   private double ThanhTien;
   private boolean PhuongThucThanhToan;
   private Date NgayThanhToan;
   private boolean TrangThai;

    public HoaDon1() {
    }

    public HoaDon1(int IDHoaDon, int ID_KhachHang, int ID_NhanVien, int ID_KhuyenMai, String Ma_HoaDon, double TienSauGiamGia, double ThanhTien, boolean PhuongThucThanhToan, Date NgayThanhToan, boolean TrangThai) {
        this.IDHoaDon = IDHoaDon;
        this.ID_KhachHang = ID_KhachHang;
        this.ID_NhanVien = ID_NhanVien;
        this.ID_KhuyenMai = ID_KhuyenMai;
        this.Ma_HoaDon = Ma_HoaDon;
        this.TienSauGiamGia = TienSauGiamGia;
        this.ThanhTien = ThanhTien;
        this.PhuongThucThanhToan = PhuongThucThanhToan;
        this.NgayThanhToan = NgayThanhToan;
        this.TrangThai = TrangThai;
    }

    public int getIDHoaDon() {
        return IDHoaDon;
    }

    public void setIDHoaDon(int IDHoaDon) {
        this.IDHoaDon = IDHoaDon;
    }

    public int getID_KhachHang() {
        return ID_KhachHang;
    }

    public void setID_KhachHang(int ID_KhachHang) {
        this.ID_KhachHang = ID_KhachHang;
    }

    public int getID_NhanVien() {
        return ID_NhanVien;
    }

    public void setID_NhanVien(int ID_NhanVien) {
        this.ID_NhanVien = ID_NhanVien;
    }

    public int getID_KhuyenMai() {
        return ID_KhuyenMai;
    }

    public void setID_KhuyenMai(int ID_KhuyenMai) {
        this.ID_KhuyenMai = ID_KhuyenMai;
    }

    public String getMa_HoaDon() {
        return Ma_HoaDon;
    }

    public void setMa_HoaDon(String Ma_HoaDon) {
        this.Ma_HoaDon = Ma_HoaDon;
    }

    public double getTienSauGiamGia() {
        return TienSauGiamGia;
    }

    public void setTienSauGiamGia(double TienSauGiamGia) {
        this.TienSauGiamGia = TienSauGiamGia;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public boolean isPhuongThucThanhToan() {
        return PhuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(boolean PhuongThucThanhToan) {
        this.PhuongThucThanhToan = PhuongThucThanhToan;
    }

    public Date getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(Date NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

   
  
}
