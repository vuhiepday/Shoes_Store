/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODAL;

/**
 *
 * @author nguye
 */
public class KhachHang {
    private String TenKhachHang,SoDienThoai;
    private int SoTienMua,idKhachHang;
    public KhachHang(){};

    public KhachHang(String TenKhachHang, String SoDienThoai, int SoTienMua, int idKhachHang) {
        this.TenKhachHang = TenKhachHang;
        this.SoDienThoai = SoDienThoai;
        this.SoTienMua = SoTienMua;
        this.idKhachHang = idKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public int getSoTienMua() {
        return SoTienMua;
    }

    public void setSoTienMua(int SoTienMua) {
        this.SoTienMua = SoTienMua;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }
}
