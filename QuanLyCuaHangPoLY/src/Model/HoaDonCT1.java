/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class HoaDonCT1 {
    private String maHDCT ; 
    private int idCTVI ; 
    private String maVi ; 
    private String tenVi ; 
    private String kieuDang;
    private String mauSac;
    private String thuongHieu;
    private  Double giaBan;
    private int soLuong ; 
    private double tongTien; 

    public HoaDonCT1(String maHDCT, int idCTVI, String maVi, String tenVi, String kieuDang, String mauSac, String thuongHieu, Double giaBan, int soLuong, double tongTien) {
        this.maHDCT = maHDCT;
        this.idCTVI = idCTVI;
        this.maVi = maVi;
        this.tenVi = tenVi;
        this.kieuDang = kieuDang;
        this.mauSac = mauSac;
        this.thuongHieu = thuongHieu;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    
    public String getKieuDang() {
        return kieuDang;
    }

    public void setKieuDang(String kieuDang) {
        this.kieuDang = kieuDang;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }



    public HoaDonCT1() {
    }

    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    public int getIdCTVI() {
        return idCTVI;
    }

    public void setIdCTVI(int idCTVI) {
        this.idCTVI = idCTVI;
    }

    public String getMaVi() {
        return maVi;
    }

    public void setMaVi(String maVi) {
        this.maVi = maVi;
    }

    public String getTenVi() {
        return tenVi;
    }

    public void setTenVi(String tenVi) {
        this.tenVi = tenVi;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
}
