/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODAL;

/**
 *
 * @author nguye
 */
public class HoaDon {

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }
    private int TongTien,idHoaDon;

    public String getNhanVien() {
        return NhanVien;
    }

    public void setNhanVien(String NhanVien) {
        this.NhanVien = NhanVien;
    }

    public String getKhachHang() {
        return KhachHang;
    }

    public void setKhachHang(String KhachHang) {
        this.KhachHang = KhachHang;
    }
    private String NgayLap,NhanVien,KhachHang;
    public HoaDon(){}

    public HoaDon(int TongTien, String idNhanVien, String idKhachHang, String NgayLap) {
        this.TongTien = TongTien;
        this.NhanVien = idNhanVien;
        this.KhachHang = idKhachHang;
        this.NgayLap = NgayLap;
    }
}
