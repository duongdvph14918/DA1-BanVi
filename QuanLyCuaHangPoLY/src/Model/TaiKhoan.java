/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class TaiKhoan {

    private String email;
    private String matKhau;
    private boolean chucVuNV;
    private int trangThaiNV;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isChucVuNV() {
        return chucVuNV;
    }

    public void setChucVuNV(boolean chucVuNV) {
        this.chucVuNV = chucVuNV;
    }

    public int getTrangThaiNV() {
        return trangThaiNV;
    }

    public void setTrangThaiNV(int trangThaiNV) {
        this.trangThaiNV = trangThaiNV;
    }

    public TaiKhoan(String email, String matKhau, boolean chucVuNV, int trangThaiNV) {
        this.email = email;
        this.matKhau = matKhau;
        this.chucVuNV = chucVuNV;
        this.trangThaiNV = trangThaiNV;
    }

   

    public TaiKhoan() {
    }

}
