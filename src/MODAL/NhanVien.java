/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODAL;

/**
 *
 * @author ADMIN
 */
public class NhanVien {

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getTuoiNV() {
        return tuoiNV;
    }

    public void setTuoiNV(int tuoiNV) {
        this.tuoiNV = tuoiNV;
    }

    public String getChucvuNV() {
        return chucvuNV;
    }

    public void setChucvuNV(String chucvuNV) {
        this.chucvuNV = chucvuNV;
    }
    public String tenNV;

    public int getId_NV() {
        return id_NV;
    }

    public void setId_NV(int id_NV) {
        this.id_NV = id_NV;
    }
    public int tuoiNV,id_NV;

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }
    public String chucvuNV, TaiKhoan,MatKhau;
    
    public NhanVien(){}
    public NhanVien(String tenNV, int tuoiNV, String chucvuNV) {
        this.tenNV = tenNV;
        this.tuoiNV = tuoiNV;
        this.chucvuNV = chucvuNV;
    }
}
