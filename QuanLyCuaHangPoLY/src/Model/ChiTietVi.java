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
public class ChiTietVi {

    private int idChiTietVi;
    private int ID_Vi;
    private int ID_MauSac;
    private int ID_ChatLieu;
    private int ID_XuatXu;
    private int ID_LoaiVi;
    private String Ma_ChiTietVi;
    private String KhoaVi;
    private String SoNganDungThe;
    private int SoLuong;
    private Double GiaNhap;
    private Double GiaBan;
    private Date NgayNhap;
    private boolean TrangThai;

    public ChiTietVi() {
    }

    public ChiTietVi(int idChiTietVi, int ID_Vi, int ID_MauSac, int ID_ChatLieu, int ID_XuatXu, int ID_LoaiVi, String Ma_ChiTietVi, String KhoaVi, String SoNganDungThe, int SoLuong, Double GiaNhap, Double GiaBan, Date NgayNhap, boolean TrangThai) {
        this.idChiTietVi = idChiTietVi;
        this.ID_Vi = ID_Vi;
        this.ID_MauSac = ID_MauSac;
        this.ID_ChatLieu = ID_ChatLieu;
        this.ID_XuatXu = ID_XuatXu;
        this.ID_LoaiVi = ID_LoaiVi;
        this.Ma_ChiTietVi = Ma_ChiTietVi;
        this.KhoaVi = KhoaVi;
        this.SoNganDungThe = SoNganDungThe;
        this.SoLuong = SoLuong;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.NgayNhap = NgayNhap;
        this.TrangThai = TrangThai;
    }

    public int getID_Vi() {
        return ID_Vi;
    }

    public void setID_Vi(int ID_Vi) {
        this.ID_Vi = ID_Vi;
    }

   

    public String getMa_ChiTietVi() {
        return Ma_ChiTietVi;
    }

    public void setMa_ChiTietVi(String Ma_ChiTietVi) {
        this.Ma_ChiTietVi = Ma_ChiTietVi;
    }


    public int getIdChiTietVi() {
        return idChiTietVi;
    }

    public void setIdChiTietVi(int idChiTietVi) {
        this.idChiTietVi = idChiTietVi;
    }

    public int getID_MauSac() {
        return ID_MauSac;
    }

    public void setID_MauSac(int ID_MauSac) {
        this.ID_MauSac = ID_MauSac;
    }

    public int getID_ChatLieu() {
        return ID_ChatLieu;
    }

    public void setID_ChatLieu(int ID_ChatLieu) {
        this.ID_ChatLieu = ID_ChatLieu;
    }

    public int getID_XuatXu() {
        return ID_XuatXu;
    }

    public void setID_XuatXu(int ID_XuatXu) {
        this.ID_XuatXu = ID_XuatXu;
    }

    public int getID_LoaiVi() {
        return ID_LoaiVi;
    }

    public void setID_LoaiVi(int ID_LoaiVi) {
        this.ID_LoaiVi = ID_LoaiVi;
    }

    public String getKhoaVi() {
        return KhoaVi;
    }

    public void setKhoaVi(String KhoaVi) {
        this.KhoaVi = KhoaVi;
    }

    public String getSoNganDungThe() {
        return SoNganDungThe;
    }

    public void setSoNganDungThe(String SoNganDungThe) {
        this.SoNganDungThe = SoNganDungThe;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(Double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public Double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(Double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }



}
