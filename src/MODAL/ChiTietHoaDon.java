/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODAL;

/**
 *
 * @author nguye
 */
public class ChiTietHoaDon {
    private int idHoaDon,SoLuong,ThanhTien;
    private String TenSanPham;

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int idHoaDon, int SoLuong, int ThanhTien, String TenSanPham) {
        this.idHoaDon = idHoaDon;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
        this.TenSanPham = TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }
}
